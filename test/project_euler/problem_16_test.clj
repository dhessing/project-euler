(ns project-euler.problem-16-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-016 :refer :all]))

(deftest test-number-explode
  (is (= (digits 123) [1 2 3]))
  (is (= (digits 100) [1 0 0])))