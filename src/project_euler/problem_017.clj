(ns project-euler.problem-017
  (:use clojure.test))

(defn number->english [n]
  (let [english (clojure.pprint/cl-format nil "~R" n)
        words (clojure.string/split english #"\s")]
    (if (< 2 (count words))
      (let [[w1 w2 w3] words]
        (clojure.string/join " " [w1 w2 "and" w3]))
      english)))

(defn number-letter-counts [n]
  (count (re-seq #"\w" (number->english n))))

(deftest test-number-to-english
  (is (= (number->english 342) "three hundred and forty-two"))
  (is (= (number->english 115) "one hundred and fifteen"))
  (is (= (number->english 200) "two hundred")))

(deftest test-number-letter-counts
  (is (= (number-letter-counts 1) 3))
  (is (= (number-letter-counts 342) 23))
  (is (= (number-letter-counts 115) 20)))

(deftest example
  (is (= 19 (apply + (map number-letter-counts (range 1 6))))))

(defn solve []
  (apply + (map number-letter-counts (range 1 1001))))