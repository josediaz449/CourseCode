#lang racket
(require "monads.rkt")
(provide (all-defined-out))
;1.

(define findf-maybe
  (lambda (p ls)
    (cond
      [(null? ls)(Nothing)]
      [(p (car ls))(Just(car ls))]
      [else (findf-maybe p (cdr ls))])))

;2.

(define partition-writer
  (lambda (p ls)
    (cond
      [(null? ls) (inj-writer '())]
      [(not (p (car ls)))(go-on ([r (partition-writer p (cdr ls))])
                          (inj-writer (cons (car ls) r)))]
      [else (go-on ([_ (tell (car ls))])
                   (partition-writer p (cdr ls)))])))

;3.

(define power
  (lambda (x n)
    (cond
      [(zero? n) 1]
      [(zero? (sub1 n)) x]
      [(odd? n) (* x (power x (sub1 n)))]
      [(even? n) (let ((nhalf (/ n 2)))
                   (let ((y (power x nhalf)))
                     (* y y)))])))

(define powerXpartials
  (lambda (x n)
    (cond
      [(zero? n) (inj-writer 1)]
      [(zero? (sub1 n)) (inj-writer x)]
      [(odd? n) (go-on ([r (powerXpartials x (sub1 n))]
                        [_ (tell r)])
                       (inj-writer (* x r)))]
      [(even? n) (go-on (
                         [y (powerXpartials x (/ n 2))]
                         [_ (tell y)])
                        (inj-writer (* y y)))])))

;4.

(define replace-with-count
  (lambda (x tr)
    (cond
      [(empty? tr)(inj-state '())]
      [(symbol? tr)(if (eqv? x tr)
                       (go-on ([sum (get)]
                               [_ (put (add1 sum))])
                              (inj-state sum))
                              (inj-state tr))]
      [(pair? tr) (go-on([rcr (replace-with-count x (car tr))]
                         [rdr (replace-with-count x (cdr tr))])
                        (inj-state(cons rcr rdr)))])))


;5.
(define traverse
  (lambda (inj bind f)
    (letrec
        ((trav
          (lambda (tree)
            (cond
              [(pair? tree)
               (go-on ([a (trav (car tree))]
                       [d (trav (cdr tree))])
                      (inj (cons a d)))]
              [else (f tree)]))))
      trav)))


(define reciprocal
  (lambda (n)
    (cond
      [(zero? n)(Nothing)]
      [else (Just (/ 1 n))])))

(define traverse-reciprocal
  (traverse Just bind-maybe reciprocal))

;6.

(define halve
  (lambda (n)
    (cond
      [(even? n)(inj-writer (/ n 2))]
      [else (go-on ([_ (tell n)])
                   (inj-writer n))])))

(define traverse-halve
  (traverse inj-writer bind-writer halve))

;7.

(define state/sum
  (lambda (n)
    (cond
      [else (go-on ([state (get)]
                    [_ (put(+ state n))])
                   (inj-state state))])))

(define traverse-state/sum
  (traverse inj-state bind-state state/sum))