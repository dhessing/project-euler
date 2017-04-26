;;;; Special Pythagorean triplet

(ns project-euler.level-01.problem-009
  (:require [lib.pythagoras :as pythagoras]))

(defn solve [] (apply * (first (pythagoras/triplets 1000))))