(ns project-euler.problem-11-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-11 :refer :all]))

(deftest test-lines
  (is (= '(8 2 22 97) (first (lines 0 0)))))