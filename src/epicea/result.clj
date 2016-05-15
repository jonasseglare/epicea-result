(ns epicea.result
  (:require [epicea.outcome :as outcome]))

(defn make-result [type value]
  [type value])

(defn make-success [value]
  (make-result :success value))

(defn make-failure [value]
  (make-result :failure value))

(defn result? [x]
  (and (vector? x)
       (<= 2 (count x))
       (contains? #{:success :failure} (first x))))

(defn get-value [x] (second x))

(defn get-outcome [x] (first x))

(extend-type clojure.lang.PersistentVector
  outcome/Failure?
  (failure? [x]
    (= (get-outcome x) :failure)))
