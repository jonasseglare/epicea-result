(ns epicea.result-test
  (:require [clojure.test :refer :all]
            [epicea.result :refer :all]
            [epicea.outcome :refer :all]))

(deftest result-test
  (testing "FIXME, I fail."
    (is (result? (make-success 1)))
    (is (not (result? [])))
    (is (failure? (make-failure 3)))
    (is (not (failure? (make-success 3))))
    (is (= 3 (get-value (make-success 3))))
    (is (success? (make-success 34234)))
    (is (not (success? (make-failure :baja))))))
