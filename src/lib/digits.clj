(ns lib.digits
  (:use [clojure.test]))

(defn from-int [n]
  (map #(Integer/parseInt (str %)) (str n)))

(deftest test-from-int
  (is (= (from-int 123) [1 2 3])))

(defn to-int [coll]
  (Long/parseLong (clojure.string/join (map str coll))))

(deftest test-to-int
  (is (= (to-int [1 2 3]) 123)))