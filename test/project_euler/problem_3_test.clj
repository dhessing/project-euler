(ns project-euler.problem-3-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-3 :refer :all]))

(deftest test-fib
  (is (= '(5 7 13 29) (prime-factors 13195))))