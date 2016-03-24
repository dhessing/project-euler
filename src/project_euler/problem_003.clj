;;;; Largest prime factor

(ns project-euler.problem-003
  (:use clojure.test))

(defn lowest-divisor [n]
  (->> (range 2 (inc n))
       (filter #(zero? (mod n %)))
       (first)))

(defn prime-factors [n]
  (when-let [prime-factor (lowest-divisor n)]
    (->> (/ n prime-factor)
         (prime-factors)
         (cons prime-factor)
         (lazy-seq))))

(deftest test-prime-factors
  (is (= '(5 7 13 29) (prime-factors 13195))))

(defn solve []
  (->> 600851475143
       (prime-factors)
       (apply max)))