;;;; Even Fibonacci numbers

(ns project-euler.level-01.problem-002
  (:use clojure.test))

(defn fib []
  (letfn [(fib' [a b]
            (lazy-seq (cons a (fib' b (+ a b)))))]
    (fib' 1 2)))

(defn problem-2 []
  (->> (fib)
       (take-while #(> 4e6 %))
       (filter even?)
       (apply +)))

(deftest test-fib
  (is (= '(1 2 3 5 8) (take 5 (fib)))))

(defn solve []
  (problem-2))