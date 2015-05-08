(ns project-euler.problem-7)

(declare primes)

(defn is-prime? [x primes]
  (not-any? zero? (map #(mod x %) (take-while #(< (/ % 2) x) primes))))

(defn primes
  ([] (cons 2 (primes 3 [2])))
  ([x coll] (lazy-seq
              (if (is-prime? x coll)
                (cons x (primes (+ x 2) (cons x coll)))
                (primes (+ x 2) coll)))))

(defn -main [] (nth (primes) 10000))