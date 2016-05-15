(ns epicea.outcome)

(defprotocol Failure? 
  (failure? [x]))

(extend-type Object
  Failure?
  (failure? [x] false))

(extend-type Throwable
  Failure?
  (failure? [x] true))

(defn success? [x]
  (not (failure? x)))
