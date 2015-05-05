(ns project-euler.problem-1)

;;;; Problem 1

;;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we
;;; get 3, 5, 6 and 9. The sum of these multiples is 23.
;;;
;;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn problem-1 [limit]
  (apply + (set (concat (range 3 limit 3) (range 5 limit 5)))))

(defn -main [] (println (problem-1 1000)))