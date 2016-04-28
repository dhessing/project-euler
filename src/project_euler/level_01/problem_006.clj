;;;; Sum square difference

(ns project-euler.level-01.problem-006
  (:use clojure.test))

(defn sum-square-difference [numbers]
  (let [square #(* % %)]
    (- (square (apply + numbers))
       (apply + (map square numbers)))))

(deftest test-sum-square-difference
  (is (= 2640 (sum-square-difference (map inc (range 10))))))

(defn solve [] (sum-square-difference (map inc (range 100))))