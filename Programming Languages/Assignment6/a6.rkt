#lang racket


(define empty-k
  (lambda ()
    (let ((once-only #f))
      (lambda (v)
        (if once-only
	    (error 'empty-k "You can only invoke the empty continuation once")
	    (begin (set! once-only #t) v))))))

;1~
(define binary-to-decimal
  (lambda (n)
    (cond
      [(null? n) 0]
      [else (+ (car n) (* 2 (binary-to-decimal (cdr n))))])))

(define binary-to-decimal-cps
  (lambda (n k)
    (cond
      [(null? n) (k 0)]
      [else (binary-to-decimal-cps (cdr n) (lambda (v)
                                             (+ (car n)(* 2 v))
                                             ))])))

;2~
(define times
  (lambda (ls)
    (cond
      [(null? ls) 1]
      [(zero? (car ls)) 0]
      [else (* (car ls) (times (cdr ls)))])))

(define times-cps
  (lambda (ls k)
    (cond
      [(null? ls) (k 1)]
      [(zero? (car ls)) (k 0)]
      [else (times-cps (cdr ls)(lambda (v)
                                 (k (* (car ls) v))))])))

;3~
(define times-cps-shortcut
  (lambda (ls k)
    (cond
      [(null? ls) (k 1)]
      [(zero? (car ls)) 0]
      [else (times-cps-shortcut (cdr ls)(lambda (v)
                                 (k(* (car ls) v))))])))

;4~
(define plus
  (lambda (m)
    (lambda (n)
      (+ m n))))

(define plus-cps
  (lambda (m k)
    (k (lambda (n k)
      (k (+ m n))))))

;5~
(define remv-first-9*
  (lambda (ls)
    (cond
      [(null? ls) '()]
      [(pair? (car ls))
       (cond
         [(equal? (car ls) (remv-first-9* (car ls)))
          (cons (car ls) (remv-first-9* (cdr ls)))]
         [else (cons (remv-first-9* (car ls)) (cdr ls))])]
      [(eqv? (car ls) '9) (cdr ls)]
      [else (cons (car ls) (remv-first-9* (cdr ls)))])))

(define remv-first-9*-cps
  (lambda (ls k)
    (cond
      [(null? ls) (k '())]
      [(pair? (car ls))
       (cond
         [(remv-first-9*-cps (car ls) (lambda (v)
                                        (equal? v (car ls))))
          (remv-first-9*-cps (cdr ls) (lambda (v)
                                        (k(cons (car ls) v))))]
         [else (remv-first-9*-cps (car ls)(lambda (v)
                                                  (k(cons v (cdr ls)))))])]
      [(eqv? (car ls) '9) (k (cdr ls))]
      [else (remv-first-9*-cps (cdr ls)(lambda (v)
                                         (k(cons (car ls) v))))])))

;6~
(define cons-cell-count
  (lambda (ls)
    (cond
      [(pair? ls)
       (add1 (+ (cons-cell-count (car ls)) (cons-cell-count (cdr ls))))]
      [else 0])))

(define cons-cell-count-cps
  (lambda (ls k)
    (cond
      [(pair? ls)
       (cons-cell-count-cps (car ls) (lambda (v)
                                       (cons-cell-count-cps (cdr ls)(lambda (w)
                                                                      (k(add1(+ v w)))))))]
      [else (k 0)])))

;7~
(define find 
  (lambda (u s)
    (let ((pr (assv u s)))
      (if pr (find (cdr pr) s) u))))

(define find-cps 
  (lambda (u s k)
    (let ((pr (assv u s)))
      (if pr (find-cps (cdr pr) s k) u))))

;8~
(define ack
  (lambda (m n)
    (cond
      [(zero? m) (add1 n)]
      [(zero? n) (ack (sub1 m) 1)]
      [else (ack (sub1 m)
                 (ack m (sub1 n)))])))

(define ack-cps
  (lambda (m n k)
    (cond
      [(zero? m) (k(add1 n))]
      [(zero? n) (ack-cps (sub1 m) 1 k)]
      [else (ack-cps m (sub1 n) (lambda (ack-mn1)
                                  (ack-cps (sub1 m) ack-mn1 k)))])))
;9~
(define fib
  (lambda (n)
    ((lambda (fib)
       (fib fib n))
     (lambda (fib n)
       (cond
	 [(zero? n) 0]
	 [(zero? (sub1 n)) 1]
	 [else (fib fib (sub1 n)) (fib fib (sub1 (sub1 n)))])))))

(define fib-cps
  (lambda (n k)
    ((lambda (fib k)
       (fib fib n k))
     (lambda (fib n k)
       (cond
	 [(zero? n) (k 0)]
	 [(zero? (sub1 n)) (k 1)]
	 [else (fib fib (sub1 n) (lambda (fib1)
                                   (fib fib (sub1 (sub1 n)) (lambda (fib2)
                                                              (k(+ fib1 fib2))))))]))k)))

;10

(define unfold
  (lambda (p f g seed)
    ((lambda (h)
       ((h h) seed '()))
     (lambda (h)
       (lambda (seed ans)
	 (if (p seed)
	     ans
	     ((h h) (g seed) (cons (f seed) ans))))))))

(define unfold-cps
  (lambda (p f g seed k)
    ((k(lambda (h k)
       ((h h) seed '())))
     (lambda (h k)
       (lambda (seed ans k)
	 (if (p seed)
	     (k ans)
	     ((h h) (g seed) (cons (f seed) ans)))))k)))

;11~

(define empty-s
  (lambda ()
    '()))

(define unify
  (lambda (u v s)
    (cond
      ((eqv? u v) s)
      ((number? u) (cons (cons u v) s))
      ((number? v) (unify v u s))
      ((pair? u)
       (if (pair? v)
	   (let ((s (unify (find (car u) s) (find (car v) s) s)))
             (if s (unify (find (cdr u) s) (find (cdr v) s) s) #f))
	   #f))
      (else #f))))
 
(define unify-cps
  (lambda (u v s k)
    (cond
      [(eqv? u v) (k s)]
      [(number? u) (k (cons (cons u v) s))]
      [(number? v) (unify-cps v u s k)]
      [(pair? u)
       (if (pair? v)
	   (find-cps (car u) s (lambda (f1)
                             (find-cps (car v) s (lambda (f2)
                                               (unify-cps f1 f2 s (lambda (s)
                                                                    (if s (find-cps (cdr u) s (lambda (f3)
                                                                                                (find-cps (cdr v) s (lambda (f4)
                                                                                                                     (unify-cps f3 f4 s k))))) (k #f))))))))
	   (k #f))]
      [else (k #f)])))

;12~
(define M
  (lambda (f)
    (lambda (ls)
      (cond
        ((null? ls) '())
        (else (cons (f (car ls)) ((M f) (cdr ls))))))))

(define M-cps
  (lambda (f k)
    (k(lambda (ls k)
      (cond
        [(null? ls) (k '())]
        [else (f (car ls) (lambda (f1)
                 (M-cps f (lambda (f2)
                            (f2 (cdr ls) (lambda (f3)
                                            (k(cons f1 f3))))))))])))))

;13
(define use-of-M-cps
  (M-cps (lambda (n k) (k (add1 n)))
   (lambda (f)
     (f '(1 2 3 4 5) (empty-k)))))