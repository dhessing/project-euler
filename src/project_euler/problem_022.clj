(ns project-euler.problem-022
  (:require [clojure.string :as s])
  (:use clojure.test))

(defn load-names []
  (->
    (slurp "resources/p022_names.txt")
    (s/replace #"\"" "")
    (s/split #",")
    (sort)))

(defn alphabetical-value [word]
  (reduce + (map #(- (int %) 64) word)))

(defn name-score [index name]
  (* index (alphabetical-value name)))

(deftest test-load-names
  (let [names (load-names)]
    (is (contains? (set names) "MARY"))
    (is (not= "MARY" (first names)))))

(deftest test-alphabetical-value
  (is (= 53 (alphabetical-value "COLIN"))))

(deftest test-name-score
  (is (= 49714 (name-score 938 "COLIN"))))

(defn solve []
  (->> (load-names)
       (map name-score (iterate inc 1))
       (reduce +)))