#lang racket

(require racket/trace)

(define value-of-cps
  (lambda (expr env k)
    (match expr
      [`(const ,expr)
       (apply-k k expr)]
      [`(mult ,x1 ,x2)
       (value-of-cps x1 env (outer-mult-k x2 env k))]
      [`(sub1 ,x)
       (value-of-cps x env (sub1-k k))]
      [`(zero ,x)
       (value-of-cps x env (zero-k k))]
      [`(if ,test ,conseq ,alt)
       (value-of-cps test env (if-k conseq alt env k))]
      [`(letcc ,body) (value-of-cps body (extend-env k env)k)]
      [`(throw ,k-exp ,v-exp)(value-of-cps v-exp env (throw-outer-k k-exp env))]
      [`(let ,e ,body) (value-of-cps e env (let-k body env k))]
      [`(var ,y) (apply-env env y k)]
      [`(lambda ,body) (apply-k k (make-closure body env))]
      [`(app ,rator ,rand) (value-of-cps rator env
                                         (app-outer-k rand env k))])))
 
(define empty-env
  (lambda ()
    `(empty-env)))
 
(define empty-k
  (lambda ()
    (lambda (v)
      v)))

(define extend-env
  (lambda (a^ env^)
    `(extend-env ,a^ ,env^)))

(define apply-env
  (lambda (env y k)
    (match env
      [`(empty-env)(lambda (y)
                     (error 'value-of "unbound identifier"))]
      [`(extend-env ,a^ ,env^)
       (if (zero? y)
          (apply-k k a^)
          (apply-env env^ (sub1 y) k))])))

(define make-closure
  (lambda (body env )
    `(clos ,body ,env)))

(define apply-closure
  (lambda (clo arg k)
    (match clo
      [`(clos ,body ,env)(value-of-cps body (extend-env arg env) k)])))

(define inner-mult-k
  (lambda (v1^ k^)
    (lambda (v)
      (apply-k k^(* v1^ v)))))

(define outer-mult-k
  (lambda (x2^ env^ k^)
    (lambda (v)
      (value-of-cps x2^ env^ (inner-mult-k v k^)))))

(define sub1-k
  (lambda (k^)
    (lambda (v)
      (apply-k k^ (sub1 v)))))

(define zero-k
  (lambda (k^)
    (lambda (v)
      (apply-k k^(zero? v)))))

(define if-k
  (lambda (conseq^ alt^ env^ k^)
    (lambda (v)
      (if v (value-of-cps conseq^ env^ k^) (value-of-cps alt^ env^ k^)))))

(define throw-inner-k
  (lambda (vv^)
    (lambda (v)
      (v vv^))))

(define throw-outer-k
  (lambda (k-exp^ env^)
    (lambda (v)
      (value-of-cps k-exp^ env^ (throw-inner-k v)))))

(define let-k
  (lambda (body^ env^ k^)
    (lambda (v)
      (value-of-cps body^ (extend-env v env^)k^))))

(define app-inner-k
  (lambda (clo^ k^)
    (lambda (v)
      (apply-closure clo^ v k^))))

(define app-outer-k
  (lambda (rand^ env^ k^)
    (lambda (v)
      (value-of-cps rand^ env^
                    (app-inner-k v k^)))))

(define apply-k
  (lambda (k v)
    (k v)))

(trace value-of-cps)
;(value-of-cps '(app (if (zero (const 4)) (lambda (var 0)) (lambda (const 5))) (const 3)) (empty-env) (empty-k))
;(value-of-cps '(letcc (throw (const 5) (throw (var 0) (const 5)))) (empty-env) (empty-k))
;(value-of-cps '(if (zero (const 5)) (app (lambda (app (var 0) (var 0))) (lambda (app (var 0) (var 0)))) (const 4))(empty-env)(empty-k))
;(value-of-cps '(let (const 5) (var 0)) (empty-env) (empty-k))
;(value-of-cps '(app (lambda (if (zero (var 0)) (const 4) (const 5))) (const 3)) (empty-env) (empty-k))
