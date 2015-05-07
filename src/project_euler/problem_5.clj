(ns project-euler.problem-5)

;;;; Smallest multiple

;;; 2520 is the smallest number that can be divided by each of the numbers from
;;; 1 to 10 without any remainder.

;;; What is the smallest positive number that is evenly divisible by all of the
;;; numbers from 1 to 20?

(defn divisable-by [number number-range]
  (every? zero? (map #(mod number %) number-range)))

(defn smallest-multiple [number]
  (if (= number 1) 1
                   (let [divisors (map inc (range number))
                         last-number (smallest-multiple (dec number))
                         possible-numbers (map (partial * last-number) divisors)]
                     (first (filter #(divisable-by % divisors) possible-numbers)))))

(defn -main []
  (println (smallest-multiple 20)))


;(map smallest-multiple (range 10))
;=> (1 1 2 6 12 60 60 420 840 2520)