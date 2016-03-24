;;;; Summation of primes

(ns project-euler.problem-010
  (:use clojure.test)
  (:require project-euler.problem-007))

(defn sum-of-primes [n]
  (->> (project-euler.problem-007/prime-seq)
       (take-while (partial > n))
       (apply +)))

(deftest test-sum-of-primes
  (is (= 17 (sum-of-primes 10))))

;;; Alternative solution

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 10))

(defn sum-of-primes-alt [n]
  (->> (range n)
       (filter prime?)
       (apply +)))

(deftest test-sum-of-primes-alt
  (is (= 17 (sum-of-primes-alt 10))))

(defn solve [] (sum-of-primes 2e6))