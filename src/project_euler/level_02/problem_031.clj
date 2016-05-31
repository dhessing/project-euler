(ns project-euler.level-02.problem-031
  (:use clojure.test))

(def coins [1 2 5 10 20 50 100 200])

(def split
  (memoize
    (fn
      ([sum] (split sum (first (filter #(>= sum %) (rseq coins)))))
      ([sum coin]
       (if (or (= coin 1) (zero? sum))
         1
         (let [next-coin (first (filter #(> coin %) (rseq coins)))]
           (reduce + (for [i (range (inc (quot sum coin)))]
                       (split (- sum (* i coin)) next-coin)))))))))

(deftest test-coin-sums
  (is (= (split 1) 1))
  (is (= (split 2) 2))
  (is (= (split 3) 2))
  (is (= (split 4) 3))
  (is (= (split 5) 4))
  (is (= (split 6) 5)))