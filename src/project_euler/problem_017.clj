(ns project-euler.problem-017)

(defn number-letter-counts [n]
  (let [length (count (re-seq #"\w" (clojure.pprint/cl-format nil "~R" n)))]
    (if (and (> n 100) (not= 0 (rem n 100)))
      (+ 3 length)                                          ; Compensates for 'and'
      length)))

(defn -main []
  (println (apply + (map number-letter-counts (range 1 1001)))))