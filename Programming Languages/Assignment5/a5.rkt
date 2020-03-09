#lang racket

;Part 1

(define lookup
  (lambda (var ls)
    (cond
      [(null? ls)#f]
      [(assv var ls)=>(lambda(pr)(cdr pr))]
      [else(lookup var (cdr ls))])))

(define lex
  (lambda (e a)
    (match e
      [`,y
       #:when (symbol? y)
       (if (lookup y a)
       `(var ,(lookup y a))
       `(free-var))]
      [`,n
       #:when (number? n)
       `(const ,n)]
      [`(zero? ,n)
       `(zero? ,(lex n a))]
      [`(if ,test ,conseq ,alt)
       `(if ,(lex test a)
           ,(lex conseq a)
           ,(lex alt a))]
      [`(sub1 ,n)
       `(sub1 ,(lex n a))]
      [`(* ,n1 ,n2)
       `(* ,(lex n1 a) ,(lex n2 a))]
      [`(let ([,x ,e]) ,body)
       `(let ,(lex e a) ,(lex body (cons `(,x . 0) (map (λ (v) (cons (car v) (add1 (cdr v)))) a))))]
      [`(lambda (,x) ,body)
       #:when (symbol? x)
       `(lambda ,(lex body (cons `(,x . 0) (map (λ (v) (cons (car v) (add1 (cdr v)))) a))))]
      [`(,rator ,rand)
       `(,(lex rator a),(lex rand a))])))

;Part 2

(define value-of-fn
  (lambda (exp env)
    (match exp
      [`,b #:when
           (boolean? b) b]
      [`,n #:when (number? n)
           n]
      [`(zero? ,n)
       (zero? (value-of-fn n env))]
      [`(sub1 ,n)
       (sub1 (value-of-fn n env))]
      [`(* ,n1 ,n2)
       (* (value-of-fn n1 env) (value-of-fn n2 env))]
      [`(if ,test ,conseq ,alt)
       (if (value-of-fn test env)
           (value-of-fn conseq env)
           (value-of-fn alt env))]
      [`(begin2 ,e1 ,e2)
       (begin (value-of-fn e1 env) (value-of-fn e2 env))]
      [`(random ,n)
       (random (value-of-fn n env))]
      [`(set! ,x ,e)
       (env x)(value-of-fn e env)]
       [`(let ([,x ,e]) ,body)
       (value-of-fn body (extend-env x env (value-of-fn e env)))]
      [`,y #:when (symbol? y)
           (apply-env env y)]
      [`(lambda (,x) ,body)
       (closure-fn x body env)]
      [`(,rator ,rand)
       (apply-closure-fn (value-of-fn rator env)
                                      (value-of-fn rand env))])))

(define empty-env
  (lambda ()
    (lambda (y)
      (error "oops"))))
       
(define extend-env
  (lambda (x env arg)
    (lambda (y)
      (if (eqv? x y)
          arg
          (apply-env env y)))))

(define apply-env
  (lambda (env y)
    (env y)))

(define closure-fn
  (lambda (x body env)
    (lambda (arg)
      (value-of-fn body (extend-env x env arg)))))
    
(define apply-closure-fn
  (lambda (clo arg)
    (clo arg)))

(define value-of-ds
  (lambda (exp env)
    (match exp
      [`,b #:when
           (boolean? b) b]
      [`,n #:when (number? n)
           n]
      [`(zero? ,n)
       (zero? (value-of-ds n env))]
      [`(sub1 ,n)
       (sub1 (value-of-ds n env))]
      [`(* ,n1 ,n2)
       (* (value-of-ds n1 env) (value-of-ds n2 env))]
      [`(if ,test ,conseq ,alt)
       (if (value-of-ds test env)
           (value-of-ds conseq env)
           (value-of-ds alt env))]
      [`(begin2 ,e1 ,e2)
       (begin (value-of-ds e1 env) (value-of-ds e2 env))]
      [`(random ,n)
       (random (value-of-ds n env))]
      [`(set! ,x ,e)
       (env x)(value-of-ds e env)]
       [`(let ([,x ,e]) ,body)
       (value-of-ds body (extend-env x env (value-of-ds e env)))]
      [`,y #:when (symbol? y)
           (apply-env env y)]
      [`(lambda (,x) ,body)
       (closure-ds x body env)]
      [`(,rator ,rand)
       (apply-closure-ds (value-of-ds rator env)
                                      (value-of-ds rand env))])))
(define closure-ds
  (lambda (x b env)
    `(clos ,x ,b ,env)))

(define apply-closure-ds
  (lambda (clo arg)
    (match clo
    [`(clos ,x ,b ,env^)
       (if (eqv? arg x)
          arg
          (value-of-fn b (extend-env x env^ arg)))])))


;Part 3

(define value-of-dynamic
  (lambda (exp env)
    (match exp
      [`,b #:when
           (boolean? b) b]
      [`,n #:when (number? n)
           n]
      [`(zero? ,n)
       (zero? (value-of-dynamic n env))]
      [`(sub1 ,n)
       (sub1 (value-of-dynamic n env))]
      [`(* ,n1 ,n2)
       (* (value-of-dynamic n1 env) (value-of-dynamic n2 env))]
      [`(if ,test ,conseq ,alt)
       (if (value-of-dynamic test env)
           (value-of-dynamic conseq env)
           (value-of-dynamic alt env))]
      [`(begin2 ,e1 ,e2)
       (begin (value-of-dynamic e1 env) (value-of-dynamic e2 env))]
      [`(random ,n)
       (random (value-of-dynamic n env))]
      [`(set! ,x ,e)
       (env x)(value-of-dynamic e env)]
       [`(let ([,x ,e]) ,body)
       (value-of-dynamic body (extend-env x env (value-of-dynamic e env)))]
      [`(null? ,n)
       (null? (value-of-dynamic n env))]
      [`(cons ,x ,y)
       (cons (value-of-dynamic x env)(value-of-dynamic y env))]
      [`(quote ,v) v]
      [`(car ,e)
       (car (value-of-dynamic e env))]
      [`(cdr ,e)
       (cdr (value-of-dynamic e env))]
      [`,y #:when (symbol? y)
           (apply-env env y)]
      [`(lambda (,x) ,body)
       `(lambda (,x) ,body)]
      [`(,rator ,rand)
       (match (value-of-dynamic rator env)
         [`(lambda (,x) ,body) (value-of-dynamic body (extend-env x env (value-of-dynamic rand env)))])])))

;(val-of b (extend-env x (val-of rand env) env))