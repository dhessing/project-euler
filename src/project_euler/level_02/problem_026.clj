(ns project-euler.level-02.problem-026
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn multiplicative-order [a n]
  (if (= 1 (math/gcd a n))
    (first (filter (fn [k] (= (mod (math/expt a k) n) 1)) (iterate inc 1)))
    0))

(deftest test-multiplicative-order
  (is (= (multiplicative-order 4 7) 3))
  (is (= (multiplicative-order 10 2) 0)))

(defn solve []
  (apply max-key #(multiplicative-order 10 %) (range 2 1000)))