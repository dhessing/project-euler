(ns project-euler.problem-12-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-12 :refer :all]))

(deftest test-triangle-numbers
  (is (= '(1 3 6 10 15 21 28) (take 7 (triangle-numbers)))))

(deftest test-number-of-divisors
  (is (= 6 (number-of-divisors 28))))