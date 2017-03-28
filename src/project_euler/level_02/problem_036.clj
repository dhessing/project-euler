(ns project-euler.level-02.problem-036
  (:require [util.palindrome :as palindrome])
  (:use [clojure.test]))

(defn solve []
  (apply + (for [i (range 1e6)
         :when (and (palindrome/palindrome? i) (palindrome/palindrome? (Integer/toBinaryString i)))]
     i)))





