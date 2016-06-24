(ns project-euler.level-02.problem-032
  (:require [clojure.math.combinatorics :as combo])
  (:use clojure.test))

(defn int-to-digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn digits-to-int [coll]
  (Integer/parseInt (clojure.string/join (map str coll))))

(defn permutations [items length]
  (mapcat combo/permutations (combo/combinations items length)))

(defn gen-multipliers []
  (let [digits (range 1 10)]
    (for [[length-a length-b] [[1 4] [2 3]]
          digits-a (permutations digits length-a)
          digits-b (permutations (remove (set digits-a) digits) length-b)]
      [digits-a digits-b])))

(defn pandigital-products []
  (let [digits (set (range 1 10))]
    (for [[digits-a digits-b] (gen-multipliers)
          :let [a (digits-to-int digits-a)
                b (digits-to-int digits-b)
                c (* a b)
                digits-total (concat digits-a digits-b (int-to-digits c))]
          :when (and
                  (= (set digits-total) digits)
                  (= (count digits-total) 9))]
      c)))

(deftest test-to-digits
  (is (= (int-to-digits 123456789) [1 2 3 4 5 6 7 8 9])))

(deftest test-digits-to-int
  (is (= (digits-to-int [1 2 3 4 5 6 7 8 9]) 123456789)))

(deftest test-pandigital-products
  (is (= (#{7254} (pandigital-products)))))

(defn solve []
  (reduce + (set (pandigital-products))))