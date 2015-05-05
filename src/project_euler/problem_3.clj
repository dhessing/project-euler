(ns project-euler.problem-3)

;;;; Problem 3

;;; The prime factors of 13195 are 5, 7, 13 and 29.
;;;
;;; What is the largest prime factor of the number 600851475143 ?

(defn lowest-divisor [number]
  (first (filter #(zero? (mod number %)) (range 2 (inc number)))))

(defn prime-factors [number]
  (when-let [lowest (lowest-divisor number)]
    (cons lowest (lazy-seq (prime-factors (/ number lowest))))))

(defn -main [] (println (apply max (prime-factors 600851475143))))