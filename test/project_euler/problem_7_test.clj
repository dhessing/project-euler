(ns project-euler.problem-7-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-7 :refer :all]))

(deftest test-is-prime?
  (is (false? (is-prime? 4 [2 3])))
  (is (true? (is-prime? 5 [2 3]))))

(deftest test-nth-prime
  (is (= (nth-prime 1) 2))
  (is (= (nth-prime 2) 3))
  (is (= (nth-prime 6) 13)))