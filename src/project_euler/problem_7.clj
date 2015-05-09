(ns project-euler.problem-7)

;;;; 10001st prime

;;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
;;; that the 6th prime is 13.

;;; What is the 10 001st prime number?

(defn is-prime? [x primes]
  (->> primes
       (take-while (partial >= (Math/sqrt x)))
       (map (partial mod x))
       (not-any? zero?)))

;; Purposefully retains head to beat the garbage collector.
;; We want all previous primes available for checking with is-prime?.
(defn prime-seq []
  (let [primes (lazy-seq (prime-seq))]
    (cons 2 (filter #(is-prime? % primes) (iterate (partial + 2) 3)))))


(defn nth-prime [n] (nth (prime-seq) (dec n)))

(defn -main [] (nth-prime 10001))
