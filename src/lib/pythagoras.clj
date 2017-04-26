(ns lib.pythagoras
  (:require [clojure.math.numeric-tower :as math])
  (:use [clojure.test]))

(defn triplets [c]
  (for [m (drop 1 (range))
        :while (> c (* m m))
        n (drop 1 (range))
        :while (> m n)
        :when (odd? (- m n))
        :when (= 1 (math/gcd m n))
        :let [k (/ c (* 2 m (+ m n)))
              a (* k (- (* m m) (* n n)))
              b (* k (* 2 n m))
              c (* k (+ (* m m) (* n n)))]
        :when (integer? k)]
    #{a b c}))

(deftest test-triplets
  (is (= #{3 4 5} (first (triplets (+ 3 4 5))))))
