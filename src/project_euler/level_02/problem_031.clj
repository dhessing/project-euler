(ns project-euler.level-02.problem-031
  (:use clojure.test))

(def coins [1 2 5 10 20 50 100 200])

(defn coin-sums
  ([sum] (coin-sums sum sum))
  ([sum highest]
   (let [coins (take-while #(<= 0 (- sum %)) (filter #(>= highest %) coins))]
     (if (or (empty? coins) (= highest 1))
       1
       (reduce + (map #(coin-sums (- sum %) %) coins))))))

(deftest test-coin-sums
  (is (= (coin-sums 1) 1))
  (is (= (coin-sums 2) 2))
  (is (= (coin-sums 3) 2))
  (is (= (coin-sums 4) 3))
  (is (= (coin-sums 5) 4))
  (is (= (coin-sums 6) 5)))