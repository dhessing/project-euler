(ns project-euler.problem-7)

;;;; 10001st prime

;;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
;;; that the 6th prime is 13.

;;; What is the 10 001st prime number?

(declare primes)

(def prime-list (primes))

(defn is-prime? [x]
  (->> prime-list
       (take-while (partial >= (Math/sqrt x)))
       (map (partial mod x))
       (not-any? zero?)))

(defn primes
  ([] (cons 2 (primes 3)))
  ([x] (lazy-seq
         (if (is-prime? x)
           (cons x (primes (+ x 2)))
           (primes (+ x 2))))))

(defn -main [] (nth (primes) 10000))