(ns project-euler.level-02.problem-030
  (:require [project-euler.level-01.problem-008 :as problem-008]
            [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn n-power-digits [n]
  (let [numbers (range 10 (inc (* n (math/expt 9 n))))]
    (for [number numbers
          :let [digits (problem-008/to-digits number)
                sum (reduce + (map #(math/expt % n) digits))]
          :when (= sum number)]
      number)))

(deftest test-n-digit-powers
  (is (= (n-power-digits 4) [1634 8208 9474])))

(defn solve []
  (reduce + (n-power-digits 5)))