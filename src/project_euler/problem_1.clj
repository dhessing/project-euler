(ns project-euler.problem-1)

(defn problem-1 [limit]
  (apply + (set (concat (range 3 limit 3) (range 5 limit 5)))))

(defn -main [] (println (problem-1 1000)))