#lang racket

;ack

(define m* #f)
(define n* #f)

(define k* #f)
(define v* #f)

(define ack-reg-driver
  (lambda (m n)
    (begin
      (set! k* (empty-k))
      (set! m* m)
      (set! n* n)
      (ack))))

(define ack
  (lambda ()
    (cond
      [(zero? m*) ;(apply-k k* (add1 n*)
       (begin (set! v* (add1 n*)) (apply-k))]
      [(zero? n*) ;(ack (sub1 m*) 1 k*)
       (begin
         (set! k* k*)
         (set! m* (sub1 m*))
         (set! n* 1)
         (ack))]
      ;[else (ack m (sub1 n) (big-k n m k))])))
      [else (begin
              (set! k* (big-k m* k*))
              (set! n* (sub1 n*))
              (set! m* m*)
              (ack))])))

(define empty-k
  (lambda ()
    `(empty-k)))

(define big-k
  (lambda (m k)
    `(big-k ,m ,k)))

(define apply-k
  (lambda ()
    (match k*
      [`(empty-k) v*]
      [`(big-k ,m ,k)
       ;(ack (sub1 m) v k)
       (begin
         (set! k* k)
         (set! n* v*)
         (set! m* (sub1 m))
         (ack))]
      [`(little-k-d ,l ,k)
       ;(let ((l (add1 l)))(if (< l v) (apply-k-d k v) (apply-k-d k l)))
       (begin
         (set! k* k)
         (set! l (add1 l))
         (if (< l v*)
             (apply-k)
             (begin
               (set! v* l)
               (apply-k))))]
      [`(big-k-d ,ls ,k)
       ;(depth (cdr ls)(little-k-d v k))
       (begin
         (set! k* (little-k-d v* k))
         (set! ls* (cdr ls))
         (depth))]
      [`(big-k-f ,n ,k)
       ;(apply-k k (* n v))
       (begin
         (set! v* (* n v*))
         (apply-k))])))

;depth

(define ls* #f)

(define depth-reg-driver
  (lambda (ls)
    (begin
      (set! k* (empty-k))
      (set! ls* ls)
      (depth))))

(define depth
  (lambda ()
    (cond
      [(null? ls*) ;(apply-k-d k-d* 1)
       (begin (set! v* 1)
              (apply-k))]
      [(pair? (car ls*))
       ;(depth (car ls*)(big-k-d ls k))
       (begin
         (set! k* (big-k-d ls* k*))
         (set! ls* (car ls*))
         (depth))]
      [else ;(depth (cdr ls) k)
            (begin
              (set! ls* (cdr ls*))
              (depth))])))

(define little-k-d
  (lambda (l k)
    `(little-k-d ,l ,k)))

(define big-k-d
  (lambda (ls k)
    `(big-k-d ,ls ,k)))

;fact

(define n** #f)
(define rator-fact* #f)
(define rand-fact* #f)
(define rand-n* #f)

(define fact-reg-driver
  (lambda (n)
    (begin
      (set k* (empty-k))
      (set! n** n))))

(define fact
  (lambda ()
    ((lambda ()
       ;(fact f* n** k*)
       (begin
         (set rand-n* n**)
         (set! rator-fact* (lambda ()
                 (cond
                   [(zero? rand-n*) ;(apply-k k 1)
                    (begin (set! v* 1)(apply-k))]
                   [else ;(fact fact (sub1 n) (big-k-f n k))
                    (begin
                      (set! k* (big-k-f rand-n* k*))
                      (set! rand-n* (sub1 rand-n*))
                      (rand-fact*))])))
         (set! n** n**)
         (rator-fact*)))
     k*)))

(define big-k-f
  (lambda (n k)
    `(big-k-f ,n ,k)))

;pascal

(define pascal
  (lambda (n k)
    (let ((pascal
           (lambda (pascal k)
             (k (lambda (m a k)
		  (cond
		    [(> m n) (k '())]
		    [else (let ((a (+ a m)))
			    (pascal pascal (lambda (f) (f (add1 m) a (lambda (v) (k (cons a v)))))))]))))))
      (pascal pascal (lambda (f) (f 1 0 k))))))

