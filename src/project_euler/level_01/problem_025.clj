(ns project-euler.level-01.problem-025
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn fib []
  ((fn step [a b]
     (lazy-seq (cons a (step b (+ a b)))))
    1N 1N))

(defn index-of-fib-with-digits [digits]
  (let [limit (math/expt 10 (dec digits))]
    (->> (fib)
         (keep-indexed (fn [idx n] (when (<= limit n) (inc idx))))
         (first))))

(deftest test-fib
  (is (= (index-of-fib-with-digits 3) 12)))

(defn solve []
  (index-of-fib-with-digits 1000))

