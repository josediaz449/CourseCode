#lang racket
(require "parenthec.rkt")

(define-program-counter pc)

(define-registers value-of-exp value-of-env value-of-k
  apply-k-k apply-k-v
  apply-clo-clo apply-clo-arg apply-clo-k
  apply-env-env apply-env-y apply-env-k)


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

(define-label value-of-cps
    (union-case value-of-exp expr
      [(const exprs)
       (begin [set! apply-k-k value-of-k]
              [set! apply-k-v exprs]
       (apply-k))]
      [(mult x1 x2)
       (begin [set! value-of-k (kt_outer-mult-k x2 value-of-env value-of-k)]
               [set! value-of-exp x1]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(sub1 x)
       (begin [set! value-of-k (kt_sub1-k value-of-k)]
               [set! value-of-exp x]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(zero x)
       (begin [set! value-of-k (kt_zero-k value-of-k)]
               [set! value-of-exp x]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(if test conseq alt)
       (begin [set! value-of-k (kt_if-k conseq alt value-of-env value-of-k)]
               [set! value-of-exp test]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(letcc body)
       (begin [set! value-of-k value-of-k]
               [set! value-of-exp body]
              [set! value-of-env (envmt_extend-env value-of-k value-of-env)]
       (value-of-cps))]
      [(throw k-exp v-exp)
       (begin [set! value-of-k (kt_throw-outer-k k-exp value-of-env)]
               [set! value-of-exp v-exp]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(let e body)
       (begin [set! value-of-k (kt_let-k body value-of-env value-of-k)]
               [set! value-of-exp e]
              [set! value-of-env value-of-env]
       (value-of-cps))]
      [(var y)
       (begin [set! apply-env-k value-of-k]
               [set! apply-env-env value-of-env]
              [set! apply-env-y y]
       (apply-env))]
      [(lambda body)
       (begin [set! apply-k-k value-of-k]
              [set! apply-k-v (clos_make-closure body value-of-env)]
       (apply-k))]
      [(app rator rand)
       (begin [set! value-of-k (kt_app-outer-k rand value-of-env value-of-k)]
               [set! value-of-exp rator]
              [set! value-of-env value-of-env]
       (value-of-cps))]))

(define-union envmt
  (extend-env a^ env^)
  (empty-env))

(define-label apply-env
    (union-case apply-env-env envmt
      [(empty-env)(lambda (y)
                     (error 'value-of "unbound identifier"))]
      [(extend-env a^ env^)
       (if (zero? apply-env-y)
           (begin [set! apply-k-k apply-env-k]
              [set! apply-k-v a^]
          (apply-k))
           (begin [set! apply-env-k apply-env-k]
                   [set! apply-env-env env^]
              [set! apply-env-y (sub1 apply-env-y)]
          (apply-env)))]))

(define-union clos
  (make-closure body env))

(define-label apply-closure
    (union-case apply-clo-clo clos
      [(make-closure body env)
       (begin [set! value-of-k apply-clo-k]
               [set! value-of-exp body]
              [set! value-of-env (envmt_extend-env apply-clo-arg env)]
       (value-of-cps))]))


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

(define-label apply-k
    (union-case apply-k-k kt
      [(empty-k) apply-k-v]
      [(inner-mult-k v1^ k^)
       (begin [set! apply-k-k k^]
              [set! apply-k-v (* v1^ apply-k-v)]
       (apply-k))]
      [(outer-mult-k x2^ env^ k^)
       (begin [set! value-of-k (kt_inner-mult-k apply-k-v k^)]
               [set! value-of-exp x2^]
              [set! value-of-env env^]
       (value-of-cps))]
      [(sub1-k k^)
       (begin [set! apply-k-k k^]
              [set! apply-k-v (sub1 apply-k-v)]
       (apply-k))]
      [(zero-k k^)
       (begin [set! apply-k-k k^]
              [set! apply-k-v (zero? apply-k-v)]
       (apply-k))]
      [(if-k conseq^ alt^ env^ k^)
       (if apply-k-v
           (begin [set! value-of-k k^]
                   [set! value-of-exp conseq^]
              [set! value-of-env env^]
           (value-of-cps))
           (begin [set! value-of-k k^]
                   [set! value-of-exp alt^]
                  [set! value-of-env env^]
           (value-of-cps)))]
      [(throw-inner-k vv^)
       (begin [set! apply-k-k apply-k-v]
              [set! apply-k-v vv^]
       (apply-k))]
      [(throw-outer-k k-exp^ env^)
       (begin [set! value-of-k (kt_throw-inner-k apply-k-v)]
               [set! value-of-exp k-exp^]
              [set! value-of-env env^]
       (value-of-cps))]
      [(let-k body^ env^ k^)
       (begin [set! value-of-k k^]
               [set! value-of-exp body^]
              [set! value-of-env (envmt_extend-env apply-k-v env^)]
       (value-of-cps))]
      [(app-inner-k clo^ k^)
       (begin [set! apply-clo-k k^]
               [set! apply-clo-clo clo^]
              [set! apply-clo-arg apply-k-v]
       (apply-closure))]
      [(app-outer-k rand^ env^ k^)
       (begin [set! value-of-k (kt_app-inner-k apply-k-v k^)]
               [set! value-of-exp rand^]
              [set! value-of-env env^]
       (value-of-cps))]))

;; (let ((f (lambda (f)
;;   	      (lambda (n)
;; 	        (if (zero? n) 
;; 		    1
;; 	            (* n ((f f) (sub1 n))))))))
;;   (* (letcc k ((f f) (throw k ((f f) 4)))) 5))
 
(define-label main 
    (begin
      [set! value-of-k (kt_empty-k)]
      [set! value-of-exp (expr_let 
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
       (expr_const 5)))]
           [set! value-of-env (envmt_empty-env)])
    (value-of-cps))
