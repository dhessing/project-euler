(ns project-euler.level-02.problem-033
  (:require [clojure.math.combinatorics :as combo]))

(defn int-to-digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn digits-to-int [coll]
  (Integer/parseInt (clojure.string/join (map str coll))))


(defn digit-cancelling-fractions []
  (for [[a b] (combo/combinations (range 10 100) 2)
        :let [digits-a (set (int-to-digits a))
              digits-b (set (int-to-digits b))
              digits-a-cancelled (clojure.set/difference digits-a digits-b)
              digits-b-cancelled (clojure.set/difference digits-b digits-a)]
        :when (not-any? empty? [digits-a-cancelled digits-b-cancelled])
        :let [c (digits-to-int digits-a-cancelled)
              d (digits-to-int digits-b-cancelled)]
        :when (try (and (not= (rem a 10) 0)
                        (not= digits-a digits-a-cancelled)
                        (= (/ a b) (/ c d)))
                   (catch ArithmeticException _ false))]
    [a b]))

(defn solve []
  (denominator (reduce * (map (fn [[a b]] (/ a b)) (digit-cancelling-fractions)))))