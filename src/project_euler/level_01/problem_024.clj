(ns project-euler.level-01.problem-024
  (:require [clojure.math.combinatorics :as c])
  (:use clojure.test))

(defn solve []
  (c/nth-permutation (range 10) (dec 1000000)))


;;; For fun I wrote my own permutations function

(defn permutations [items]
  (if (= 1 (count items))
    (list items)
    (for [item items
          p (permutations (filter #(not= % item) items))]
      (cons item p))))

(deftest test-lexicographic-permutations
  (is (= [[0]] (permutations (range 1))))
  (is (= [[0 1] [1 0]] (permutations (range 2))))
  (is (= [[0 1 2]
          [0 2 1]
          [1 0 2]
          [1 2 0]
          [2 0 1]
          [2 1 0]] (permutations (range 3)))))
