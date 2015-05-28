;;;; Longest Collatz sequence
;;; https://projecteuler.net/problem=14

(ns project-euler.problem-14)

(def collatz-seq-length
  (memoize
    (fn [n]
      (if (< 1 n)
        (inc (collatz-seq-length (if (even? n)
                                   (/ n 2)
                                   (inc (* n 3)))))
        1))))

(defn longest-collatz-number [range]
  (last (sort-by (partial collatz-seq-length) range)))

(defn -main []
  (println (longest-collatz-number 1000000)))