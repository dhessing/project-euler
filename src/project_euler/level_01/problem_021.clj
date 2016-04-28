(ns project-euler.level-01.problem-021
  (:use clojure.test))

(defn factors [n]
  (->> (for [x (range 1 (inc (Math/sqrt n)))
             :when (zero? (rem n x))]
         [x (/ n x)])
       (reduce concat)
       (set)))

(defn proper-divisors [n]
  (disj (factors n) n))

(defn amicable-number? [a]
  (let [d (fn [n] (apply + (proper-divisors n)))
        b (d a)]
    (and (= a (d b)) (not= a b))))

(deftest test-factors
  (is (= #{1 2 4 5 10 11 20 22 44 55 110 220} (factors 220))))

(deftest test-amicable-number?
  (is (true? (amicable-number? 220))))

(defn solve []
  (apply + (filter amicable-number? (range 1 10001))))
