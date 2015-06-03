(ns project-euler.problem-15
  (:require [clojure.math.combinatorics :as combo]))

(defn -main []
  (->> (concat (repeat 20 :r)
               (repeat 20 :d))
       (combo/count-permutations)
       (println)))