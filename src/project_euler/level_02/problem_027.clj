(ns project-euler.level-02.problem-027
  (:require [clojure.math.combinatorics :as comb])
  (:use clojure.test))

(defn make-function [a b]
  (fn [n] (+ (* n n) (* a n) b)))

(defn prime? [n]
  (.isProbablePrime (biginteger n) 10))

(defn count-consecutive-primes [coll]
  (count (take-while prime? coll)))

(deftest test-count-consecutive-primes
  (is (= (count-consecutive-primes (map (make-function 1 41) (range))) 40))
  (is (= (count-consecutive-primes (map (make-function -79 1601) (range))) 80)))

(defn consecutive-primes [n]
  (let [numbers (range (- n) n)
        primes (filter prime? numbers)]
    (for [a numbers
          b primes
          :let [values (map (make-function a b) (range))]]
      [[a b] (count-consecutive-primes values)])))

(defn solve []
  (apply * (first (apply max-key second (consecutive-primes 1000)))))