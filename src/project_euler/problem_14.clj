;;;; Longest Collatz sequence
;;; https://projecteuler.net/problem=14

(ns project-euler.problem-14)

(defn collatz-step [n]
  (if (even? n) (/ n 2) (inc (* n 3))))

(def collatz-chain-length
  (memoize
    (fn [n]
      (if (= n 1)
        1
        (inc (collatz-chain-length (collatz-step n)))))))

(defn longest-collatz-number [coll]
  (apply max-key collatz-chain-length coll))

(defn -main []
  (println (longest-collatz-number (range 1 1000000))))