;;;; Special Pythagorean triplet

(ns project-euler.level-01.problem-009
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn pythagorian-triplets [s]
  (for [m (drop 1 (range))
        n (drop 1 (range))
        :while (> m n)
        :when (odd? (- m n))
        :when (= 1 (math/gcd m n))
        :let [k (/ s (* 2 m (+ m n)))
              a (* k (- (* m m) (* n n)))
              b (* k (* 2 n m))
              c (* k (+ (* m m) (* n n)))]
        :when (integer? k)]
    [a b c]))

(deftest test-pythagorian-triplets
  (is (= [3 4 5] (first (pythagorian-triplets (+ 3 4 5))))))

(defn solve [] (apply * (first (pythagorian-triplets 1000))))