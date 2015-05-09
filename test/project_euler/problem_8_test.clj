(ns project-euler.problem-8-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-8 :refer :all]))

(deftest test-largest-product-in
  (is (= 5832 (largest-product-in-series 4))))