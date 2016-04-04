(ns project-euler.problem-016
  (:use clojure.test)
  (:require [project-euler.problem-008 :as problem-008]
            [clojure.math.numeric-tower :as math]))

(defn power-digit-sum [exp]
  (apply + (problem-008/to-digits (math/expt 2 exp))))

(deftest example
  (is (= 26 (power-digit-sum 15))))

(defn solve []
  (power-digit-sum 1000))