(ns project-euler.problem-10-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-10 :refer :all]))

(deftest test-sum-of-primes
  (is (= 17 (sum-of-primes 10))))