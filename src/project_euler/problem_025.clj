(ns project-euler.problem-025
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn index-of-fib-with-digits [digits]
  (let [max (math/expt 10 (dec digits))]
    (loop [a 1 b 1 idx 1]
      (if (<= max a)
        idx
        (recur b (+' a b) (inc idx))))))

(deftest test-fib
  (is (= (index-of-fib-with-digits 3) 12)))

(defn solve []
  (index-of-fib-with-digits 1000))

