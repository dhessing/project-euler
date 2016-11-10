(ns project-euler.level-02.problem-035
  (:use [clojure.test])
  (:require [project-euler.level-01.problem-007 :as problem-007]
            [project-euler.level-02.problem-033 :as problem-033]))

(defn rotations [number]
  (let [length (count number)]
    (map #(take length (drop % (cycle number))) (range 1 length))))

(deftest test-rotations
  (is (= (rotations [1 2 3]) [[2 3 1] [3 1 2]])))

(defn circular-primes [max]
  (let [primes (set (map problem-033/int-to-digits (take-while (partial > max) (problem-007/prime-seq))))]
    (sort (for [prime primes
                :when (every? primes (rotations prime))]
            (problem-033/digits-to-int prime)))))

(deftest test-circular-primes
  (is (= (circular-primes 1e2) [2 3 5 7 11 13 17 31 37 71 73 79 97])))

(defn solve []
  (count (circular-primes 1e6)))