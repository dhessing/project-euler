(ns project-euler.problem-16-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-16 :refer :all]))

(deftest test-number-explode
  (is (= (number-explode 123) [1 2 3]))
  (is (= (number-explode 100) [1 0 0])))