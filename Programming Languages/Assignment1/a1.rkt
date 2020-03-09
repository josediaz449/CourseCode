#lang racket

(provide (all-defined-out))


#;1~
(define countdown 
  (lambda (n)
    (cond
      [(zero? n) '(0)]
      [else (cons n(countdown (sub1 n)))])))

#;2~
(define insertR
  (lambda (a b ls)
    (cond
      [(null? ls) '()]
      [(eqv? (car ls) a) (cons a(cons b(insertR a b (cdr ls))))]
      [else (cons (car ls) (insertR a b (cdr ls)))])))

#;3~
(define remv-1st
  (lambda (a ls)
    (cond
      [(null? ls) '()]
      [(eqv? (car ls) a) (cdr ls)]
      [else ( cons (car ls)(remv-1st a (cdr ls)))])))

#;4~
(define list-index-ofv?
  (lambda (a ls)
    (cond
      [(eqv? (car ls) a) 0]
      [else (add1 (list-index-ofv? a (cdr ls)))])))

#;5~
(define filter
  (lambda (a? ls)
    (cond
      [(null? ls) '()]
      [(a? (car ls))(cons (car ls)(filter a? (cdr ls)))]
      [else (filter a? (cdr ls))])))

#;6~
(define zip
  (lambda (ls1 ls2)
    (cond
      [(null? ls1) '()]
      [(null? ls2) '()]
      [else (cons (cons (car ls1)(car ls2))(zip (cdr ls1)(cdr ls2)))])))

#;7~
(define map
  (lambda (p ls)
    (cond
      [{null? ls} '()]
      [else (cons (p (car ls))(map p (cdr ls)))])))

#;8~
(define append
  (lambda (ls1 ls2)
    (cond
      [(null? ls1) ls2]
      [(null? ls2) ls1]
      [else (cons (car ls1) (append (cdr ls1) ls2))])))


#;9 
(define reverse
  (lambda (ls)
    (cond
      [(null? ls) '()]
      [else ((append((cdr ls)(car ls)))(reverse (cdr ls)))])))

#;10~
(define fact
  (lambda (n)
    (cond
      [(zero? n) 1]
      [else (* n (fact (sub1 n)))])))

#;11~
(define memv
  (lambda (e ls)
    (cond
      [(null? ls) #f]
      [(eqv?(car ls) e) (cons (car ls)(cdr ls))]
      [else(or(memv e (cdr ls)))])))

#;12~
(define fib
  (lambda (n)
    (cond
      [(zero? n) 0]
      [(eqv? n 1)(+ 1 (fib (sub1 n)))]
      [else(+ (fib (- n 2)) (fib (sub1 n)))])))

#;13 ;((w x) y (z)) = ((w.(x.()))).y.()).((x.()))


#;14 
(define binary->natural
  (lambda (ls)
    (cond
      [(null? ls) 0]
      [(zero? (car ls))(binary->natural (cdr ls))]
      [else (* 2 (+ 2 (binary->natural (cdr ls))))])))

#;15~
(define minus
  (lambda (n m)
    (cond
      [(zero? m) n]
      [else (sub1 (minus n (sub1 m)))])))

#;16~
(define div
  (lambda (n m)
    (cond
      [(zero? n) 0]
      [else (+ 1 (div (- n m) m))])))

#;17~
(define append-map
  (lambda (p ls)
    (cond
      [(null? ls) '()]
      [else (append (p (car ls)) (append-map p (cdr ls)))])))

#;18~
(define set-difference
  (lambda (s1 s2)
    (cond
      [(null? s1) '()]
      [(null? s2) s1]
      [(not(memv (car s1) s2))(cons (car s1)(set-difference (cdr s1) s2))]
      [else (set-difference (cdr s1) s2)])))
      

      

