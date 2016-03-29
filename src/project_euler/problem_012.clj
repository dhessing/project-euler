;;;; Highly divisible triangular number

(ns project-euler.problem-012
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn triangle-numbers []
  (reductions + (iterate inc 1)))

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 10))

(defn prime-seq []
  (filter prime? (range)))

(defn lowest-prime-divisor [x primes]
  (letfn [(divides? [x p] (zero? (mod x p)))]
    (->> (take-while (partial >= x) primes)
         (filter (partial divides? x))
         (first))))

(defn prime-factors [x primes]
  (lazy-seq
    (when-let [prime-factor (lowest-prime-divisor x primes)]
      (cons prime-factor (prime-factors (/ x prime-factor) primes)))))

(defn number-of-divisors [x primes]
  (->> (prime-factors x primes)
       (frequencies)
       (vals)
       (map inc)
       (apply *)))

(deftest test-prime?
  (is (true? (prime? 7))))

(deftest test-triangle-numbers
  (is (= '(1 3 6 10 15 21 28) (take 7 (triangle-numbers)))))

(deftest test-prime-seq
  (is (= '(2 3 5 7 11 13 17) (take 7 (prime-seq)))))

(deftest test-lowest-prime-divisor
  (is (= 2 (lowest-prime-divisor 28 (prime-seq)))))

(deftest test-lowest-prime-divisor-is-prime
  (is (= 7 (lowest-prime-divisor 7 (prime-seq)))))

(deftest test-prime-factors
  (is (= '(2 2 7) (prime-factors 28 (prime-seq)))))

(deftest test-number-of-divisors
  (is (= 6 (number-of-divisors 28 (prime-seq)))))

(defn solve []
  (let [primes (prime-seq)]
    (->> (triangle-numbers)
         (filter #(< 500 (number-of-divisors % primes)))
         (first))))