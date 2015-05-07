(ns project-euler.problem-5-test
  (:require [clojure.test :refer :all])
  (:require [project-euler.problem-5 :refer :all]))

(deftest test-smallest-multiple
  (is (= (smallest-multiple 10)) 2520))
