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
       (let* ([apply-k-k k]
              [apply-k-v expr])
       (apply-k apply-k-k apply-k-v))]
      [(mult x1 x2)
       (let* ([value-of-exp x1]
              [value-of-env env]
              [value-of-k (kt_outer-mult-k x2 env k)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(sub1 x)
       (let* ([value-of-exp x]
              [value-of-env env]
              [value-of-k (kt_sub1-k k)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(zero x)
       (let* ([value-of-exp x]
              [value-of-env env]
              [value-of-k (kt_zero-k k)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(if test conseq alt)
       (let* ([value-of-exp test]
              [value-of-env env]
              [value-of-k (kt_if-k conseq alt env k)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(letcc body)
       (let* ([value-of-exp body]
              [value-of-env (envmt_extend-env k env)]
              [value-of-k k])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(throw k-exp v-exp)
       (let* ([value-of-exp v-exp]
              [value-of-env env]
              [value-of-k (kt_throw-outer-k k-exp env)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(let e body)
       (let* ([value-of-exp e]
              [value-of-env env]
              [value-of-k (kt_let-k body env k)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(var y)
       (let* ([apply-env-env env]
              [apply-env-y y]
              [apply-env-k k])
       (apply-env apply-env-env apply-env-y apply-env-k))]
      [(lambda body)
       (let* ([apply-k-k k]
              [apply-k-v (clos_make-closure body env)])
       (apply-k apply-k-k apply-k-v))]
      [(app rator rand)
       (let* ([value-of-exp rator]
              [value-of-env env]
              [value-of-k (kt_app-outer-k rand env k)])
       (value-of-cps value-of-exp value-of-env value-of-k))])))

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
           (let* ([apply-k-k k]
              [apply-k-v a^])
          (apply-k apply-k-k apply-k-v))
           (let* ([apply-env-env env^]
              [apply-env-y (sub1 y)]
              [apply-env-k k])
          (apply-env apply-env-env apply-env-y apply-env-k)))])))

(define-union clos
  (make-closure body env))

(define apply-closure
  (lambda (clo arg k)
    (union-case clo clos
      [(make-closure body env)
       (let* ([value-of-exp body]
              [value-of-env (envmt_extend-env arg env)]
              [value-of-k k])
       (value-of-cps value-of-exp value-of-env value-of-k))])))


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
      [(inner-mult-k v1^ k^)
       (let* ([apply-k-k k^]
              [apply-k-v (* v1^ v)])
       (apply-k apply-k-k apply-k-v))]
      [(outer-mult-k x2^ env^ k^)
       (let* ([value-of-exp x2^]
              [value-of-env env^]
              [value-of-k (kt_inner-mult-k v k^)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(sub1-k k^)
       (let* ([apply-k-k k^]
              [apply-k-v (sub1 v)])
       (apply-k apply-k-k apply-k-v))]
      [(zero-k k^)
       (let* ([apply-k-k k^]
              [apply-k-v (zero? v)])
       (apply-k apply-k-k apply-k-v))]
      [(if-k conseq^ alt^ env^ k^)
       (if v
           (let* ([value-of-exp conseq^]
              [value-of-env env^]
              [value-of-k k^])
           (value-of-cps value-of-exp value-of-env value-of-k))
           (let* ([value-of-exp alt^]
                  [value-of-env env^]
              [value-of-k k^])
           (value-of-cps value-of-exp value-of-env value-of-k)))]
      [(throw-inner-k vv^)
       (let* ([apply-k-k v]
              [apply-k-v vv^])
       (apply-k apply-k-k apply-k-v))]
      [(throw-outer-k k-exp^ env^)
       (let* ([value-of-exp k-exp^]
              [value-of-env env^]
              [value-of-k (kt_throw-inner-k v)])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(let-k body^ env^ k^)
       (let* ([value-of-exp body^]
              [value-of-env (envmt_extend-env v env^)]
              [value-of-k k^])
       (value-of-cps value-of-exp value-of-env value-of-k))]
      [(app-inner-k clo^ k^)
       (let* ([apply-clo-clo clo^]
              [apply-clo-arg v]
              [apply-clo-k k^])
       (apply-closure apply-clo-clo apply-clo-arg apply-clo-k))]
      [(app-outer-k rand^ env^ k^)
       (let* ([value-of-exp rand^]
              [value-of-env env^]
              [value-of-k (kt_app-inner-k v k^)])
       (value-of-cps value-of-exp value-of-env value-of-k))])))

;; (let ((f (lambda (f)
;;   	      (lambda (n)
;; 	        (if (zero? n) 
;; 		    1
;; 	            (* n ((f f) (sub1 n))))))))
;;   (* (letcc k ((f f) (throw k ((f f) 4)))) 5))
 
(define main 
  (lambda ()
    (let* ([value-of-exp (expr_let 
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
           [value-of-env (envmt_empty-env)]
           [value-of-k (kt_empty-k)])
    (value-of-cps value-of-exp value-of-env value-of-k))))
