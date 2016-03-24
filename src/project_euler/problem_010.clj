;;;; Summation of primes

;;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

;;; Find the sum of all the primes below two million.

(ns project-euler.problem-010
  (:require project-euler.problem-007))

(defn sum-of-primes [n]
  (->> (project-euler.problem-007/prime-seq)
       (take-while (partial > n))
       (apply +)))

(defn -main [] (sum-of-primes 2000000))