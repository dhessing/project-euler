(ns project-euler.level-02.problem-028
  (:use [clojure.test]))

(defn spiral-numbers []
  (reductions + 1 (mapcat #(repeat 4 %) (iterate #(+ 2 %) 2))))

(defn spiral-sum [size]
  (let [n (dec (* 2 size))]
    (reduce + (take n (spiral-numbers)))))

(deftest test-spiral-numbers
  (is (= (take 9 (spiral-numbers)) '(1 3 5 7 9 13 17 21 25))))

(deftest test-spiral-sum
  (is (= (spiral-sum 5) 101)))

(defn solve []
  (spiral-sum 1001))

