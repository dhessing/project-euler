(ns project-euler.level-02.problem-034
  (:require [util.digits :as digits]
            [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(def factorial (memoize (fn [n] (reduce * (range 1 (inc n))))))

(deftest test-factorial
  (is (= (factorial 5) (* 1 2 3 4 5))))

(defn upper-bound []
  (->> (iterate inc 1)
       (filter #(> (math/expt 10 %) (* % (factorial 9))))
       (first)
       (* (factorial 9))))

(defn digit-factorial? [int]
  (= int (reduce + (map factorial (digits/from-int int)))))

(deftest test-digit-factorial
  (is (true? (digit-factorial? 145))))

(defn solve []
  (reduce + (for [x (range (upper-bound))
                  :when (digit-factorial? x)]
              x)))