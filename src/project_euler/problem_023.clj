(ns project-euler.problem-023
  (:require [project-euler.problem-021 :as p21])
  (:use clojure.test))

(defn abundant-number? [n]
  (< n (reduce + (p21/proper-divisors n))))

(defn abundant-numbers [n]
  (filter abundant-number? (range 1 (inc n))))

(defn- sum-of-two-abundant-numbers? [abundant-numbers abundant-number-set n]
  (some
    #(contains? abundant-number-set %)
    (for [x abundant-numbers
          :while (<= (/ n 2))]
      (- n x))))

(deftest test-sum-of-two-abundant-numbers?
  (let [abundant-numbers (abundant-numbers 28124)
        abundant-number-set (set abundant-numbers)]
    (is (true? (sum-of-two-abundant-numbers? abundant-numbers abundant-number-set 24)))
    (is (true? (sum-of-two-abundant-numbers? abundant-numbers abundant-number-set 28124)))))

(defn solve []
  (let [abundant-numbers (abundant-numbers 28124)
        sum-of-two-abundant-numbers? (partial sum-of-two-abundant-numbers? abundant-numbers (set abundant-numbers))]
    (->> (range 1 28124)
         (remove sum-of-two-abundant-numbers?)
         (reduce +))))