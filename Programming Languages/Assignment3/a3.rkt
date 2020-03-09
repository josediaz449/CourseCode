#lang racket


;;env:: Symbol->Value
;;val-of:: expr->Value
;;1
(define value-of
  (lambda (exp env)
    (match exp
      [`,n #:when (natural? n )
           n]
      [`,b #:when (boolean? b)
           b]
      [`(* ,n ,m)
       (* (value-of n env) (value-of m env))]
      [`(sub1 ,n)
       (sub1 (value-of n env))]
      [`(zero? ,n)
       (zero?(value-of n env))]
      [`(if ,this ,then ,else)
       (if (value-of this env) (value-of then env) (value-of else env))]
      [`(let ([,x ,e]) ,body)
       (value-of body (cons (cons x (value-of e env))env))]
      [`,y #:when (symbol? y)
           (env y)]
      [`(lambda (,x) ,body)
       #:when (symbol? x)
          (lambda(a)(value-of body (lambda(y)(if (eqv? x y)a (env y)))))]
      [`(,rator ,rand)
        ((value-of rator env)(value-of rand env))])))
 
(define value-of-fn
  (lambda (exp env)
    (match exp
       [`,n #:when (natural? n )
           n]
      [`,b #:when (boolean? b)
           b]
      [`(* ,n ,m)
       (* (value-of-fn n env) (value-of-fn m env))]
      [`(sub1 ,n)
       (sub1 (value-of-fn n env))]
      [`(zero? ,n)
       (zero? (value-of-fn n env))]
      [`(if ,this ,then ,else)
       (if (value-of-fn this env)
           (value-of-fn then env)
           (value-of-fn else env))]
      [`(let ([,x ,e]) ,body)
       (value-of-fn body (extend-env-fn x env (value-of-fn e env)))]
      [`,y #:when (symbol? y)
           (apply-env-fn env y)]
      [`(lambda (,x) ,body)
       #:when (symbol? x)
          (lambda(a)
            (value-of-fn body (extend-env-fn x env a)))]
      [`(,rator ,rand)
        ((value-of-fn rator env) (value-of-fn rand env))])))
  
(define empty-env-fn
  (lambda ()
    (lambda (y)
      (error "oops"))))

(define extend-env-fn
  (lambda (var env val)
    (lambda(y)
      (if (eqv? var y)
          val
          (env y)))))
    
    
(define apply-env-fn
  (lambda (env y)
    (env y)))
 
(define value-of-ds
  (lambda (exp env)
    (match exp
       [`,n #:when (natural? n )
           n]
      [`,b #:when (boolean? b)
           b]
      [`(* ,n ,m)
       (* (value-of-ds n env) (value-of-ds m env))]
      [`(sub1 ,n)
       (sub1 (value-of-ds n env))]
      [`(zero? ,n)
       (zero? (value-of-ds n env))]
      [`(if ,this ,then ,else)
       (if (value-of-ds this env) (value-of-ds then env) (value-of-ds else env))]
      [`(let ([,x ,e]) ,body)
       (value-of-ds body (extend-env-ds x env (value-of-ds e env)))]
      [`,y #:when (symbol? y)
           (apply-env-ds env y)]
      [`(lambda (,x) ,body)
       #:when (symbol? x)
          (lambda(a)(value-of body (extend-env-ds x env a)))]
      [`(,rator ,rand)
        ((value-of-ds rator env)(value-of-ds rand env))])))


(define empty-env-ds
  (lambda (env y)
      [`(empty-env) (error "no value for" y)]))

(define extend-env-ds
  (lambda (x env val)
    `(extend-env x env val)))

(define apply-env-ds
  (lambda (env x)
    (match env
      [`(empty-env)
       (error "no value for" x)]
      [`(extend-env ,x^ ,env^ ,val)
       (if (eqv? x x^)
          val
          (apply-env-ds env^ x))])))
