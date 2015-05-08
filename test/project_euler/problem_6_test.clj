(ns project-euler.problem-6-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-6 :refer :all]))

(deftest test-sum-square-difference
  (is (= 2640 (sum-square-difference (map inc (range 10))))))