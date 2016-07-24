(ns util.digits)

(defn from-int [n]
  (map #(Integer/parseInt (str %)) (str n)))

(defn to-int [coll]
  (Integer/parseInt (clojure.string/join (map str coll))))