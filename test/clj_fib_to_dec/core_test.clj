(ns clj-fib-to-dec.core-test
  (:require [clojure.test :refer :all]
            [clj-fib-to-dec.core :refer :all]))


(deftest 
  test-char2num
  (is (= (range 10) (map clj-fib-to-dec.core/char2num '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9)))))

(deftest
  test-chop-in-parts
  (is (= '(1 0 0 0 1) (clj-fib-to-dec.core/chop-in-parts "10001")))
  (is (= '(0 0 0 0 0) (clj-fib-to-dec.core/chop-in-parts "00000")))
)

(deftest
  test-fib-seq
  (is (= '(21 13 8 5 3 2 1 1) (fib-seq 8)))
  (is (= '(144 89 55 34 21 13 8 5 3 2 1 1) (fib-seq 12)))
)


(deftest 
  test-dec-to-fib-to-dec
  (is (= true (reduce = (map clj-fib-to-dec.core/helper [1 5 8 13 37 57])))))

;; (run-tests clj-fib-to-dec.core-test)
