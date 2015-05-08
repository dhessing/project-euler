(ns project-euler.problem-7)

;;;; 10001st prime

;;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
;;; that the 6th prime is 13.

;;; What is the 10 001st prime number?

(declare is-prime?)

(defn prime-seq []
  (cons 2 (lazy-seq (filter is-prime? (iterate (partial + 2) 3)))))

(def primes (prime-seq))

(defn is-prime? [x]
  (->> primes
       (take-while (partial >= (Math/sqrt x)))
       (map (partial mod x))
       (not-any? zero?)))

(defn -main [] (nth (prime-seq) 10000))
