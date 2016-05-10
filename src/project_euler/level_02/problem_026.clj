(ns project-euler.level-02.problem-026
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn multiplicative-order [a n]
  (letfn [(f [k] (= (mod (math/expt a k) n) 1))]
    (when (= 1 (math/gcd a n))
      (first (filter f (iterate inc 1))))))

(deftest test-multiplicative-order
  (is (= (multiplicative-order 4 7) 3))
  (is (= (multiplicative-order 10 2) nil)))

(defn solve []
  (apply max-key #(or (multiplicative-order 10 %) 0) (range 2 1000)))