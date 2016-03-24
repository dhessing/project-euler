;;;; Multiples of 3 and 5

(ns project-euler.problem-001
  (:use clojure.test))

(defn problem-1 [limit]
  (->> (range limit)
       (filter #(or (zero? (mod % 5))
                    (zero? (mod % 3))))
       (apply +)))

(defn problem-1-alt [limit]
  (->> (concat (range 3 limit 3)
               (range 5 limit 5))
       (set)
       (apply +)))

(deftest test-problem-1
  (is (= 23 (problem-1 10))))

(deftest test-problem-1-alt
  (is (= 23 (problem-1-alt 10))))

(defn solve []
  (problem-1 1000))