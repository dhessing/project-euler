;;;; Longest Collatz sequence
;;; https://projecteuler.net/problem=14

(ns project-euler.level-01.problem-014
  (:use clojure.test))

(defn collatz-step [n]
  (if (even? n) (/ n 2) (inc (* n 3))))

(def collatz-chain-length
  (memoize
    (fn [n]
      (if (= n 1)
        1
        (inc (collatz-chain-length (collatz-step n)))))))

(let [cache (atom {1 1})]
  (defn collatz-chain-length-alt [n]
    (loop [n n, k identity]
      (letfn [(cache-add [length]
                (swap! cache assoc n length) length)]
        (if-let [length (@cache n)]
          (k length)
          (recur (collatz-step n)
                 (comp k inc cache-add)))))))

(defn longest-collatz-number [coll]
  (apply max-key collatz-chain-length coll))

(deftest test-collatz-step
  (is (= (collatz-step 1) 4))
  (is (= (collatz-step 2) 1)))

(deftest test-collatz-length-memo
  (is (= (collatz-chain-length 13) 10)))

(deftest test-longest-collatz-number
  (is (= (longest-collatz-number (range 1 10)) 9)))

(defn solve [] (longest-collatz-number (range 1 1e6)))