(ns project-euler.level-02.problem-037
  (:require [lib.primes :as primes]
            [lib.digits :as digits])
  (:use [clojure.test]))

(def primes (primes/prime-seq))

(defn truncate-l [coll]
  (lazy-seq
    (when-let [s (seq coll)]
      (cons s (truncate-l (rest s))))))

(deftest test-truncate-l
  (is (= (truncate-l [3 7 9 7]) '((3 7 9 7) (7 9 7) (9 7) (7)))))

(defn truncate-r [coll]
  (lazy-seq
    (when-let [s (seq coll)]
      (cons s (truncate-r (butlast s))))))

(deftest test-truncate-r
  (is (= (truncate-r [3 7 9 7]) '((3 7 9 7) (3 7 9) (3 7) (3)))))

(defn truncate [coll]
  (concat (truncate-l coll) (truncate-r coll)))

(deftest test-truncate
  (is (= (truncate [3 7 9 7]) '((3 7 9 7) (7 9 7) (9 7) (7) (3 7 9 7) (3 7 9) (3 7) (3)))))

(defn truncatable-prime? [n]
  (every? #(primes/is-prime? (digits/to-int %) primes) (truncate (digits/from-int n))))

(deftest test-truncatable-prime?
  (is (true? (truncatable-prime? 3797))))

(defn solve []
  (apply + (take 11 (for [p (drop-while #(>= 7 %) primes)
                          :when (truncatable-prime? p)]
                      p))))