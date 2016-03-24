;;;; Highly divisible triangular number
;;; https://projecteuler.net/problem=12

(ns project-euler.problem-012)

(defn triangle-numbers []
  (map first (iterate (fn [[x y]] [(+ x y) (inc y)]) [1 2])))

(defn number-of-divisors [x]
  (->> (range 1 (Math/sqrt x))
       (filter #(zero? (mod x %)))
       (count)
       (* 2)))

(defn -main []
  (->> (triangle-numbers)
       (filter #(< 500 (number-of-divisors %)))
       (first)))