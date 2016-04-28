(ns project-euler.level-01.problem_019
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]
            [clj-time.periodic :as p])
  (:use clojure.test))

(defn first-sunday-of-year [year]
  (first (filter pr/sunday? (p/periodic-seq (t/date-midnight year) (t/days 1)))))

(deftest test-first-sunday-of-year
  (let [date (first-sunday-of-year 1901)]
    (is (= 7 (t/day-of-week date)))
    (is (= 1 (t/week-number-of-year date)))))

(defn solve []
  (->> (p/periodic-seq (first-sunday-of-year 1901) (t/weeks 1))
       (take-while #(< (t/year %) 2001))
       (filter pr/first-day-of-month?)
       (count)))