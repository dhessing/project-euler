(ns project-euler.problem-16
  (:require [clojure.math.numeric-tower :as math]))

(defn number-explode [n]
  (if (> 1 n)
    []
    (conj (number-explode (quot n 10)) (int (rem n 10)))))

(defn -main []
  (println (apply + (number-explode (math/expt 2 1000)))))