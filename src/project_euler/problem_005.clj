;;;; Smallest multiple

(ns project-euler.problem-005
  (:use clojure.test))

(defn divisable-by-all? [upper n]
  (->> (range upper)
       (map inc)
       (map #(mod n %))
       (every? zero?)))

(defn smallest-multiple []
  (letfn [(smallest-multiple' [previous upper]
            (->> (range)
                 (map inc)
                 (map (partial * previous))
                 (filter (partial divisable-by-all? upper))
                 (first)))]
    (reduce smallest-multiple' 1 (range 1 21))))

(deftest test-divisable-by-all
  (is (true? (divisable-by-all? 10 2520))))

(defn solve []
  (smallest-multiple))