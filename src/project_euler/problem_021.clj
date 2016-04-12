(ns project-euler.problem-021
  (require [project-euler.problem-012 :as problem-12]
           [clojure.math.combinatorics :as combo])
  (:use clojure.test))

(defn proper-divisors [primes n]
  (->> primes
       (problem-12/prime-factors n)
       (combo/subsets)
       (butlast)
       (map (partial apply *))
       (set)))

(defn amicable-number? [primes n]
  (let [sum-1 (apply + (proper-divisors primes n))
        sum-2 (apply + (proper-divisors primes sum-1))]
    (and (= n sum-2) (not= n sum-1))))

(deftest test-proper-divisors
  (is (= #{1 2 4 5 10 11 20 22 44 55 110} (proper-divisors (problem-12/prime-seq) 220))))

(deftest test-amicable-number?
  (is (true? (amicable-number? (problem-12/prime-seq) 220))))

(defn solve []
  (let [numbers (range 1 (inc 10001))
        primes (problem-12/prime-seq)]
    (apply + (filter (partial amicable-number? primes) numbers))))
