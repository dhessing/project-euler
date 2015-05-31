(ns project-euler.problem-14-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-14 :refer :all]))

(deftest test-collatz-step
  (is (= (collatz-step 1) 4))
  (is (= (collatz-step 2) 1)))

(deftest test-collatz-length-memo
  (is (= (collatz-chain-length 13) 10)))

(deftest test-longest-collatz-number
  (is (= (longest-collatz-number (range 1 10)) 9)))