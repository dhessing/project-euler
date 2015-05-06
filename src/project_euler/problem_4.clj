(ns project-euler.problem-4)

;;;; Largest palindrome product

;;; A palindromic number reads the same both ways. The largest palindrome made
;;; from the product of two 2-digit numbers is 9009 = 91 × 99.

;;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn is-palindrome? [number]
  (->> number
       (str)
       (reverse)
       (apply str)
       (Integer/parseInt)
       (= number)))

(defn palindrome-product [digits]
  (let [upper (int (Math/pow 10 digits))
        n (range upper (/ upper 10) -1)]
    (apply max (for [x n
                     y n
                     :let [result (* x y)]
                     :when (is-palindrome? result)]
                 result))))

(defn -main [] (palindrome-product 3))