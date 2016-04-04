(ns project-euler.problem-015
  (:import (cern.jet.math.tdouble DoubleArithmetic)))

(defn solve []
  (long (DoubleArithmetic/binomial 40 20)))