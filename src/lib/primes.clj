(ns lib.primes
  (:use clojure.test))

(defn is-prime? [n primes]
  (if (= n 1)
    false
    (let [trial-divisors (take-while (fn [p] (>= (Math/sqrt n) p)) primes)
          divisible? (fn [n divisor] (zero? (mod n divisor)))]
      (not-any? #(divisible? n %) trial-divisors))))

(deftest test-is-prime?
  (is (false? (is-prime? 4 [2 3])))
  (is (true? (is-prime? 5 [2 3]))))

(defn prime-seq []
  (lazy-seq
    (let [primes (prime-seq)]
      (cons 2 (filter #(is-prime? % primes) (iterate #(+ 2 %) 3))))))

(deftest test-prime-seq
  (is (= (take 5 (prime-seq))) [2 3 5 7 11]))