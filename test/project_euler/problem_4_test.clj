(ns project-euler.problem-4-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-4 :refer :all]))

(deftest test-is-palindrome?
  (is (true? (is-palindrome? 101)))
  (is (false? (is-palindrome? 100))))

(deftest test-palindrome-product
  (is (= 9009 (largest-palindrome-product 2))))