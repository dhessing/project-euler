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

(defn largest-palindrome-product [digits]
  (let [upper (int (Math/pow 10 digits))
        n (range (/ upper 10) upper)]
    (->> (for [x n
               y n
               :when (>= x y)]                              ; No doubles.
           (* x y))
         (sort)
         (reverse)
         (filter is-palindrome?)
         (first))))

(defn -main [] (largest-palindrome-product 3))