(ns lib.palindrome
  (:use clojure.test))

(defn palindrome? [n]
  (let [s (str n)]
    (->> s
         (reverse)
         (apply str)
         (= s))))

(deftest test-palindrome?
  (is (true? (palindrome? 101)))
  (is (false? (palindrome? 100)))
  (is (true? (palindrome? "meetsysteem"))))