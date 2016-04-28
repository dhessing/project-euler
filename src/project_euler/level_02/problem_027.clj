(ns project-euler.level-02.problem-027
  (:require [clojure.math.combinatorics :as comb])
  (:use clojure.test))

(defn make-function [a b]
  (fn [n] (+ (* n n) (* a n) b)))

(defn prime? [n]
  (.isProbablePrime (biginteger n) 10))

(defn number-of-consecutive-primes [f]
  (count (take-while prime? (map f (range)))))

(deftest test-number-of-consecutive-primes
  (is (= (number-of-consecutive-primes (make-function 1 41)) 40))
  (is (= (number-of-consecutive-primes (make-function -79 1601)) 80)))

(defn max-quadratic-primes [n]
  (let [xs (range (- n) n)
        primes (filter prime? xs)]
    (->> (for [a xs
               b primes
               :let [ncp (number-of-consecutive-primes (make-function a b))]]
           [[a b] ncp])
         (apply max-key second)
         (first))))

(defn solve []
  (apply * (max-quadratic-primes 1000)))