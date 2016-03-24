;;;; Largest palindrome product

(ns project-euler.problem-004
  (:use clojure.test))

(defn palindrome? [n]
  (let [s (str n)]
    (->> s
         (reverse)
         (apply str)
         (= s))))

(defn largest-palindrome-product [numbers]
  (->> (for [a numbers
             b numbers
             :while (>= a b)
             :let [product (* a b)]
             :when (palindrome? product)]
         product)
       (apply max)))

(deftest test-palindrome?
         (is (true? (palindrome? 101)))
         (is (false? (palindrome? 100))))

(deftest test-palindrome-product
         (is (= 9009 (largest-palindrome-product (range 10 100)))))

(defn solve [] (largest-palindrome-product (range 100 1000)))