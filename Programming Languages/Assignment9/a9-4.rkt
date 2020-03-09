#lang racket
(require "parenthec.rkt")

(define-union expr
  (const cexp)
  (var n)
  (if test conseq alt)
  (mult nexp1 nexp2)
  (sub1 nexp)
  (zero nexp)
  (letcc body)
  (throw kexp vexp)
  (let exp body)              
  (lambda body)
  (app rator rand))

(define value-of-cps
  (lambda (exp env k)
    (union-case exp expr
      [(const expr)
       (apply-k k expr)]
      [(mult x1 x2)
       (value-of-cps x1 env (kt_outer-mult-k x2 env k))]
      [(sub1 x)
       (value-of-cps x env (kt_sub1-k k))]
      [(zero x)
       (value-of-cps x env (kt_zero-k k))]
      [(if test conseq alt)
       (value-of-cps test env (kt_if-k conseq alt env k))]
      [(letcc body) (value-of-cps body (envmt_extend-env k env) k)]
      [(throw k-exp v-exp)(value-of-cps v-exp env (kt_throw-outer-k k-exp env))]
      [(let e body) (value-of-cps e env (kt_let-k body env k))]
      [(var y) (apply-env env y k)]
      [(lambda body) (apply-k k (clos_make-closure body env))]
      [(app rator rand) (value-of-cps rator env
                                         (kt_app-outer-k rand env k))])))

(define-union envmt
  (extend-env a^ env^)
  (empty-env))

(define empty-env
  (lambda ()
    `(empty-env)))
 
(define empty-k
  (lambda ()
    `(empty-k)))

(define extend-env
  (lambda (a^ env^)
    `(extend-env ,a^ ,env^)))

(define apply-env
  (lambda (env y k)
    (union-case env envmt
      [(empty-env)(lambda (y)
                     (error 'value-of "unbound identifier"))]
      [(extend-env a^ env^)
       (if (zero? y)
          (apply-k k a^)
          (apply-env env^ (sub1 y) k))])))

(define-union clos
  (make-closure body env))

(define make-closure
  (lambda (body env)
    `(clos ,body ,env)))

(define apply-closure
  (lambda (clo arg k)
    (union-case clo clos
      [(make-closure body env)(value-of-cps body (envmt_extend-env arg env) k)])))

(define inner-mult-k
  (lambda (v1^ k^)
    `(inner-mult-k ,v1^ ,k^)))

(define outer-mult-k
  (lambda (x2^ env^ k^)
    `(outer-mult-k ,x2^ ,env^ ,k^)))

(define sub1-k
  (lambda (k^)
    `(sub1-k ,k^)))

(define zero-k
  (lambda (k^)
    `(zero-k ,k^)))

(define if-k
  (lambda (conseq^ alt^ env^ k^)
    `(if-k ,conseq^ ,alt^ ,env^ ,k^)))

(define throw-inner-k
  (lambda (vv^)
    `(throw-inner-k ,vv^)))

(define throw-outer-k
  (lambda (k-exp^ env^)
    `(throw-outer-k ,k-exp^ , env^)))

(define let-k
  (lambda (body^ env^ k^)
    `(let-k ,body^ ,env^ ,k^)))

(define app-inner-k
  (lambda (clo^ k^)
    `(app-inner-k ,clo^ ,k^)))

(define app-outer-k
  (lambda (rand^ env^ k^)
    `(app-outer-k ,rand^ ,env^ ,k^)))

(define-union kt
  (empty-k)
  (inner-mult-k v1^ k^)
  (outer-mult-k x2^ env^ k^)
  (sub1-k k^)
  (zero-k k^)
  (if-k conseq^ alt^ env^ k^)
  (throw-inner-k vv^)
  (throw-outer-k k-exp^ env^)
  (let-k ,body^ env^ k^)
  (app-inner-k clo^ k^)
  (app-outer-k rand^ env^ k^))

(define apply-k
  (lambda (k v)
    (union-case k kt
      [(empty-k) v]
      [(inner-mult-k v1^ k^)(apply-k k^(* v1^ v))]
      [(outer-mult-k x2^ env^ k^)(value-of-cps x2^ env^ (kt_inner-mult-k v k^))]
      [(sub1-k k^)(apply-k k^ (sub1 v))]
      [(zero-k k^)(apply-k k^ (zero? v))]
      [(if-k conseq^ alt^ env^ k^)(if v (value-of-cps conseq^ env^ k^) (value-of-cps alt^ env^ k^))]
      [(throw-inner-k vv^)(apply-k v vv^)]
      [(throw-outer-k k-exp^ env^)(value-of-cps k-exp^ env^ (kt_throw-inner-k v))]
      [(let-k body^ env^ k^)(value-of-cps body^ (envmt_extend-env v env^)k^)]
      [(app-inner-k clo^ k^)(apply-closure clo^ v k^)]
      [(app-outer-k rand^ env^ k^)(value-of-cps rand^ env^
                    (kt_app-inner-k v k^))])))

;; (let ((f (lambda (f)
;;   	      (lambda (n)
;; 	        (if (zero? n) 
;; 		    1
;; 	            (* n ((f f) (sub1 n))))))))
;;   (* (letcc k ((f f) (throw k ((f f) 4)))) 5))
 
(define main 
  (lambda ()
    (value-of-cps 
     (expr_let 
      (expr_lambda
       (expr_lambda 
        (expr_if
         (expr_zero (expr_var 0))
         (expr_const 1)
         (expr_mult (expr_var 0) (expr_app (expr_app (expr_var 1) (expr_var 1)) (expr_sub1 (expr_var 0)))))))
      (expr_mult
       (expr_letcc
        (expr_app
         (expr_app (expr_var 1) (expr_var 1))
         (expr_throw (expr_var 0) (expr_app (expr_app (expr_var 1) (expr_var 1)) (expr_const 4)))))
       (expr_const 5)))
     (envmt_empty-env)
     (kt_empty-k))))
