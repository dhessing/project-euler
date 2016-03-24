(ns project-euler.problem-17-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-017 :refer :all]))

(deftest test-number-letter-counts
  (is (= (number-letter-counts 1) 3))
  (is (= (number-letter-counts 342) 23))
  (is (= (number-letter-counts 115) 20))
  (is (= (number-letter-counts 200) 10)))