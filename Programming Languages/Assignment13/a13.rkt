#lang racket
(require "mk.rkt")
(require "numbers.rkt")

;1.

(defrel (listo ls)
  (conde
   [(== ls '())]
   [(fresh (a d)
           (== ls `(,a . ,d))
           (listo d))]))

;2.

(defrel (facto n out)
  (conde
   [(== n '())
    (== (build-num 1) out)]
   [(fresh (k res)
           (minuso n (build-num 1) k)
           (facto k res)
           (*o n res out))]))

;3.

(defrel (fibso n out1 out2)
  (conde
   [(== n '())
    (== out1 (build-num 1))
    (== out2 (build-num 1))]
   [(fresh (k a b c)
           (minuso n (build-num 1) k)
           (fibso k a b)
           (pluso a b c)
           (== out1 b)
           (== out2 c))]))

;4

(defrel (lookupo var vars vals o)
  (fresh (a rest-vars v rest-vals)
         (== `(,a . ,rest-vars) vars)
         (== `(,v . ,rest-vals) vals)
         (conde
          
          [(=/= a var) (lookupo var rest-vars rest-vals o)]
          [(== a var) (== v o)])))

(defrel (fo-lavo exp vars vals o)
  (conde
   [(symbolo exp) (lookupo exp vars vals o)]
    ;[`,n #:when (number? n) n]
   [(fresh (a)
           (absento 'clos a)
           (== `(etouq ,a) exp)
           (== a o))]
   [(fresh (exps)
           (== `(tsil . ,exps) exp)
           (fo-lavo exps vars vals o))]
   [(fresh (x b)
           (symbolo x)
           (=/= 'clos x)
           (=/= 'λ x)
           (=/= 'tsil x)
           (== `(λ (,x) ,b) exp)
           (== `(clos ,x ,b ,vars ,vals) o))]
   [(fresh (rator rand)
           (== `(,rator ,rand) exp)
           (fresh (x b vars^ vals^ a)
                  (fo-lavo rator vars vals `(clos ,x ,b ,vars^ ,vals^))
                  (fo-lavo rand vars vals a)
                  (fo-lavo b `(,x . ,vars^) `(,a . ,vals^) o)))]))