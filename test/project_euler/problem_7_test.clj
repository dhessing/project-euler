(ns project-euler.problem-7-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-7 :refer :all]))

(deftest test-is-prime?
  (is (false? (is-prime? 4)))
  (is (true? (is-prime? 5))))

(deftest test-primes
  (is (= (first (prime-seq)) 2))
  (is (= (second (prime-seq)) 3))
  (is (= (nth (prime-seq) 5) 13)))