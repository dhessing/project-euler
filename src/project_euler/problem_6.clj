(ns project-euler.problem-6)

;;;; Sum square difference

;;; The sum of the squares of the first ten natural numbers is,
;;; 1^2 + 2^2 + ... + 10^2 = 385

;;; The square of the sum of the first ten natural numbers is,
;;; (1 + 2 + ... + 10)^2 = 552 = 3025

;;; Hence the difference between the sum of the squares of the first ten natural
;;; numbers and the square of the sum is 3025 − 385 = 2640.

;;; Find the difference between the sum of the squares of the first one hundred
;;; natural numbers and the square of the sum.

(defn sum-square-difference [coll]
  (let [square #(* % %)
        sum-of-squares (apply + (map square coll))
        square-of-sum (square (apply + coll))]
    (- square-of-sum sum-of-squares)))

(defn -main [] (sum-square-difference (map inc (range 100))))