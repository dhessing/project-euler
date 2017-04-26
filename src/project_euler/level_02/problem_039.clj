(ns project-euler.level-02.problem-039
  (:require [lib.pythagoras :as pythagoras]))

(defn solve []
  (apply max-key (comp count pythagoras/triplets) (range 1 1000)))
