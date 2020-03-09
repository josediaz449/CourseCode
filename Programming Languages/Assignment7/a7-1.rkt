#lang racket

(require racket/trace)

(define value-of
  (lambda (expr env)
    (match expr
      [`(const ,expr) expr]
      [`(mult ,x1 ,x2) (* (value-of x1 env) (value-of x2 env))]
      [`(sub1 ,x) (sub1 (value-of x env))]
      [`(zero ,x) (zero? (value-of x env))]
      [`(if ,test ,conseq ,alt) (if (value-of test env)
                                    (value-of conseq env)
                                    (value-of alt env))]
      [`(letcc ,body) (let/cc k
                        (value-of body (lambda (y) (if (zero? y) k (env (sub1 y))))))]
      [`(throw ,k-exp ,v-exp) ((value-of k-exp env) (value-of v-exp env))]
      [`(let ,e ,body) (let ((a (value-of e env)))
                         (value-of body (lambda (y) (if (zero? y) a (env (sub1 y))))))]
      [`(var ,y) (env y)]
      [`(lambda ,body) (lambda (a) (value-of body (lambda (y) (if (zero? y) a (env (sub1 y))))))]
      [`(app ,rator ,rand) ((value-of rator env) (value-of rand env))])))


(define value-of-cps
  (lambda (expr env k)
    (match expr
      [`(const ,expr)
       (k expr)]
      [`(mult ,x1 ,x2)
       (value-of-cps x1 env (lambda (v1)
                              (value-of-cps x2 env (lambda (v2)
                                                     (k(* v1 v2))))))]
      [`(sub1 ,x)
       (value-of-cps x env (lambda (v)
                             (k (sub1 v))))]
      [`(zero ,x)
       (value-of-cps x env (lambda (v)
                             (k(zero? v))))]
      [`(if ,test ,conseq ,alt)
       (value-of-cps test env (lambda (v?)
                                (if v? (value-of-cps conseq env k) (value-of-cps alt env k))))]
      [`(letcc ,body) (value-of-cps body (lambda (y k^) (if (zero? y) (k^ k) (env (sub1 y) k^)))k)]
      [`(throw ,k-exp ,v-exp)(value-of-cps v-exp env (lambda (vv)
                                                       (value-of-cps k-exp env (lambda (kv)
                                                                                 (kv vv)))))]
      [`(let ,e ,body) 
       (value-of-cps e env (lambda (a)
                         (value-of-cps body (lambda (y k) (if (zero? y) (k a) (env (sub1 y) k)))k)))]
      [`(var ,y) (env y k)]
      [`(lambda ,body) (k(lambda (a k) (value-of-cps body (lambda (y k) (if (zero? y) (k a) (env (sub1 y) k)))k)))]
      [`(app ,rator ,rand) (value-of-cps rator env
                                         (lambda (clo)
                                           (value-of-cps rand env
                                                         (lambda (arg)
                                                           (clo arg k)))))])))
 
(define empty-env
  (lambda ()
    (lambda (y)
      (error 'value-of-cps "unbound identifier"))))
 
(define empty-k
  (lambda ()
    (lambda (v)
      v)))

(trace value-of-cps)
;(value-of-cps '(app (if (zero (const 4)) (lambda (var 0)) (lambda (const 5))) (const 3)) (empty-env) (empty-k))
(value-of-cps '(letcc (throw (const 5) (throw (var 0) (const 5)))) (empty-env) (empty-k))
;(value-of-cps '(if (zero (const 5)) (app (lambda (app (var 0) (var 0))) (lambda (app (var 0) (var 0)))) (const 4))(empty-env)(empty-k))
;(value-of-cps '(let (const 5) (var 0)) (empty-env) (empty-k))
;(value-of-cps '(app (lambda (if (zero (var 0)) (const 4) (const 5))) (const 3)) (empty-env) (empty-k))
