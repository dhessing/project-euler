(ns project-euler.problem-9-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-9 :refer :all]))

(deftest test-pythagorian-triplets-below
  (is (= [3 4 5] (first (pythagorian-triplets-below 10)))))

(deftest test-special-pythagorian-triplet
  (is (= (* 3 4 5) (special-pythagorian-triplet (+ 3 4 5)))))