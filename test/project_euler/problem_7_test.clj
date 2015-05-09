(ns project-euler.problem-7-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-7 :refer :all]))

(deftest test-is-prime?
  (is (false? (is-prime? 4)))
  (is (true? (is-prime? 5))))

(deftest test-primes
  (is (= (first primes) 2))
  (is (= (second primes) 3))
  (is (= (nth primes 5) 13)))