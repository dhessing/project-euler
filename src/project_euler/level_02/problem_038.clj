(ns project-euler.level-02.problem-038
  (:require [lib.digits :as digits]
            [clojure.math.combinatorics :as combo])
  (:use [clojure.test]))

(defn pandigital? [n]
  (let [digits (digits/from-int n)]
    (and (= (count digits) 9)
      (every? (set digits) (set (range 1 10))))))

(deftest test-pandigital?
  (is (false? (pandigital? 123)))
  (is (false? (pandigital? 1234567898)))
  (is (false? (pandigital? 123456788)))
  (is (true? (pandigital? 123456789))))

(defn concatenate-product [x products]
  (digits/to-int (map #(* x %) products)))

(deftest test-concatenate-product
  (is (= (concatenate-product 192 [1 2 3])) 192384576)
  (is (= (concatenate-product 9 [1 2 3 4 5])) 918273645))

(defn solve []
  (apply max (for [x (iterate inc 2)
                   :while (<= x 9999)
                   upper (iterate inc 2)
                   :let [products (range 1 (inc upper))
                         concatenated-product (concatenate-product x products)]
                   :while (>= 987654321 concatenated-product)
                   :when (pandigital? concatenated-product)]
               concatenated-product)))



