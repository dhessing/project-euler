;;;; 10001st prime

(ns project-euler.problem-007
  (:use clojure.test))

(defn is-prime? [n primes]
  (let [trial-divisors (take-while (fn [p] (>= (Math/sqrt n) p)) primes)
        divisible? (fn [n divisor] (zero? (mod n divisor)))]
    (not-any? #(divisible? n %) trial-divisors)))

(defn prime-seq []
  (lazy-seq
    (let [primes (prime-seq)]
      (cons 2 (filter #(is-prime? % primes) (iterate #(+ 2 %) 3))))))

(deftest test-is-prime?
  (is (false? (is-prime? 4 [2 3])))
  (is (true? (is-prime? 5 [2 3]))))

(deftest test-nth-prime
  (is (= (nth (prime-seq) 0) 2))
  (is (= (nth (prime-seq) 1) 3))
  (is (= (nth (prime-seq) 5) 13)))

(defn solve [] (nth (prime-seq) 10000))
