(ns project-euler.level-01.problem-023
  (:require [project-euler.level-01.problem-021 :as p21])
  (:use clojure.test))

(defn abundant-number? [n]
  (< n (reduce + (p21/proper-divisors n))))

(defn sum-of-two-abundant-numbers-checker []
  (let [abundant-numbers (into [] (filter abundant-number? (range 1 28124)))
        abundant-number-set (set abundant-numbers)]
    (fn [n]
      (let [half (/ n 2)]
        (some true?
              (for [a abundant-numbers
                    :while (<= a half)
                    :let [b (- n a)]
                    :when (contains? abundant-number-set b)]
                true))))))

(deftest test-abundant-number?
  (is (true? (abundant-number? 12))))

(deftest test-sum-of-two-abundant-numbers?
  (let [sum-of-two-abundant-numbers? (sum-of-two-abundant-numbers-checker)]
    (is (true? (sum-of-two-abundant-numbers? 24)))
    (is (true? (sum-of-two-abundant-numbers? 28124)))))

(defn solve []
  (let [sum-of-two-abundant-numbers? (sum-of-two-abundant-numbers-checker)]
    (reduce + (remove sum-of-two-abundant-numbers? (range 1 28124)))))