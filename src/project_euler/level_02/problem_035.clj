(ns project-euler.level-02.problem-035
  (:use [clojure.test])
  (:require [util.primes :as primes]
            [util.digits :as digits]))

(defn rotations [coll]
  (let [length (count coll)]
    (map #(take length (drop % (cycle coll))) (range 1 length))))

(deftest test-rotations
  (is (= (rotations [1 2 3]) [[2 3 1] [3 1 2]])))

(defn circular-primes [max]
  (let [primes (set (map digits/from-int (take-while (partial > max) (primes/prime-seq))))]
    (sort (for [prime primes
                :when (every? primes (rotations prime))]
            (digits/to-int prime)))))

(deftest test-circular-primes
  (is (= (circular-primes 1e2) [2 3 5 7 11 13 17 31 37 71 73 79 97])))

(defn solve []
  (count (circular-primes 1e6)))