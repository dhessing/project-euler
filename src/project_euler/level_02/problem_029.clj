(ns project-euler.level-02.problem-029
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(defn count-distinct-powers [coll]
  (count (into #{} (for [a coll
                         b coll]
                     (math/expt a b)))))

(deftest test-count-distinct-powers
  (is (= 15 (count-distinct-powers (range 2 6)))))

(defn solve []
  (count-distinct-powers (range 2 101)))