(ns project-euler.problem-1-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-1 :refer :all]))

(deftest test-problem-1
  (is (= 23 (problem-1 10))))
