(ns project-euler.level-01.problem-015
  (:import (cern.jet.math.tdouble DoubleArithmetic)))

(defn solve []
  (long (DoubleArithmetic/binomial 40 20)))