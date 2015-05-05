(ns project-euler.problem-3)

(defn lowest-divisor [number]
  (first (filter #(zero? (mod number %)) (range 2 (inc number)))))

(defn prime-factors [number]
  (when-let [lowest (lowest-divisor number)]
    (cons lowest (lazy-seq (prime-factors (/ number lowest))))))

(defn -main [] (println (apply max (prime-factors 600851475143))))