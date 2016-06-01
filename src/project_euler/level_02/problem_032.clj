(ns project-euler.level-02.problem-032
  (:require [project-euler.level-01.problem-008 :refer [to-digits]])
  (:require [clojure.math.combinatorics :as combo])
  (:use clojure.test))

(defn to-digit [coll]
  (reduce + (map * (reverse coll) (iterate #(* % 10) 1))))


(reduce + (set (for [[na nb] [[1 4] [2 3]]
                     a' (mapcat combo/permutations (combo/combinations (range 1 10) na))
                     b' (mapcat combo/permutations (combo/combinations (clojure.set/difference (set (range 1 10)) (set a')) nb))
                     :let [a (to-digit a')
                           b (to-digit b')
                           c (* a b)
                           total (concat a' b' (to-digits c))]
                     :when (and
                             (= (set total) (set (range 1 10)))
                             (= (count total) 9))]
                 c)))