(ns project-euler.problem-2-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-2 :refer :all]))

(deftest test-fib
  (is (= '(1 2 3 5 8) (take 5 (fibonacci-sequence)))))
