(ns project-euler.level-02.problem-034
  (:require [util.digits :as digits]
            [clojure.math.numeric-tower :as math])
  (:use clojure.test))

(def factorial (memoize (fn [n] (reduce *' (range 1 (inc n))))))

(defn upper-bound []
  (->> (iterate inc 2)
       (filter #(>= (math/expt 10 %) (* % (factorial 9))))
       (first)))

(defn digit-factorial? [int]
  (= int (reduce + (map factorial (digits/from-int int)))))

(defn solve []
  (reduce + (for [x (range 10 (math/expt 10 (upper-bound)))
                  :when (digit-factorial? x)]
              x)))

(deftest test-digit-factorial
  (is (true? (digit-factorial? 145))))