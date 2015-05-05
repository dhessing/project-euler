(ns project-euler.problem-2)

(defn fib []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [1 2])))

(defn problem-2 []
  (apply + (filter even? (take-while #(< % 4000000) (fib)))))

(defn -main [] (println (problem-2)))