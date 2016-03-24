(ns project-euler.problem-18-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-018 :refer :all]))

(deftest test-add-rows
  (is (= (add-rows [2 3] [1]) [4])))