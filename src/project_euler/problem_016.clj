(ns project-euler.problem-016
  (:require [clojure.math.numeric-tower :as math]))

(defn digits [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn -main []
  (println (apply + (digits (math/expt 2 1000)))))