(ns project-euler.problem-7)

;;;; 10001st prime

;;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
;;; that the 6th prime is 13.

;;; What is the 10 001st prime number?

(declare primes)

(defn is-prime? [x]
  (->> primes
       (take-while (partial >= (Math/sqrt x)))
       (map (partial mod x))
       (not-any? zero?)))

;; Declares primes at top level scope to beat the garbage collector.
;; We want all previous primes available for checking with is-prime?.
(def primes (cons 2 (filter is-prime? (iterate (partial + 2) 3))))

(defn -main [] (nth primes 10000))
