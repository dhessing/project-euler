(ns project-euler.problem-5)

;;;; Smallest multiple

;;; 2520 is the smallest number that can be divided by each of the numbers from
;;; 1 to 10 without any remainder.

;;; What is the smallest positive number that is evenly divisible by all of the
;;; numbers from 1 to 20?

(defn divisable-by-all?
  "Checks if n is divisable by all numbers in coll without remainder."
  [n coll]
  (every? zero? (map (partial mod n) coll)))

(defn smallest-multiple
  "Cuts down computing time by using the fact that the new multiple is always a
  factor of the previous smallest multiple"
  ([x] (nth (smallest-multiple 1 1) (dec x)))
  ([x prev]
   (let [divisors (map inc (range x))
         coll     (map (partial * prev) divisors)
         smallest (first (filter #(divisable-by-all? % divisors) coll))]
     (lazy-seq (cons smallest (smallest-multiple (inc x) smallest))))))

(defn -main []
  (println (smallest-multiple 20)))