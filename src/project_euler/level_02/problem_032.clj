(ns project-euler.level-02.problem-032
  (:require [clojure.math.combinatorics :as combo])
  (:use clojure.test))

(defn to-digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn digits-to-int [coll]
  (Integer/parseInt (clojure.string/join (map str coll))))

(defn permutations [items length]
  (mapcat combo/permutations (combo/combinations items length)))

(defn pandigital-products [length-a length-b]
  (let [digits (set (range 1 10))]
    (for [digits-a (permutations (range 1 10) length-a)
          digits-b (permutations (remove (set digits-a) digits) length-b)
          :let [a (digits-to-int digits-a)
                b (digits-to-int digits-b)
                product (* a b)
                digits-total (concat digits-a digits-b (to-digits product))]
          :when (and
                  (= (set digits-total) digits)
                  (= (count digits-total) 9))]
      product)))

(deftest test-to-digits
  (is (= (to-digits 123456789) [1 2 3 4 5 6 7 8 9])))

(deftest test-digits-to-int
  (is (= (digits-to-int [1 2 3 4 5 6 7 8 9]) 123456789)))

(deftest test-pandigital-products
  (is (= (#{7254} (pandigital-products 2 3)))))

(defn solve []
  (reduce + (set (mapcat #(pandigital-products %1 %2) [1 2] [4 3]))))