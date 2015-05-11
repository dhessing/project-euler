(ns project-euler.problem-9)

;;;; Special Pythagorean triplet

;;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for
;;; which,
;;; a² + b² = c²
;;;
;;; For example, 3² + 4² = 9 + 16 = 25 = 5².
;;;
;;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;;; Find the product abc.

(defn pythagorian-triplets-below [x]
  (for [n (range 1 x)
        m (range 1 x)
        :when (> m n)
        :when (odd? (- m n))
        :let [a (- (* m m) (* n n))
              b (* 2 n m)
              c (+ (* m m) (* n n))]]
    [a b c]))

(defn special-pythagorian-triplet [x]
  (->> (pythagorian-triplets-below x)
       (filter #(= x (apply + %)))
       (first)
       (apply *)))

(defn -main [] (special-pythagorian-triplet 1000))