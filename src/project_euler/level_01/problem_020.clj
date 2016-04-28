(ns project-euler.level-01.problem-020
  (:require [project-euler.level-01.problem-008 :as problem-008])
  (:use clojure.test))

(defn factorial [n]
  (reduce *' (range 1 (inc n))))

(defn factorial-digit-sum [n]
  (apply + (map int (problem-008/to-digits (factorial n)))))

(deftest test-factorial
  (is (= 3628800 (factorial 10))))

(deftest test-factorial-digit-sum
  (is (= (factorial-digit-sum 10) 27)))

(defn solve []
  (factorial-digit-sum 100))
