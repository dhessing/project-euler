(ns project-euler.problem-5-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-5 :refer :all]))

(deftest test-divisable-by-all
  (is (true? (divisable-by-all? 10 [1 2 5])))
  (is (false? (divisable-by-all? 10 [5 9]))))

(deftest test-smallest-multiple
  (is (= (smallest-multiple 10)) 2520))
