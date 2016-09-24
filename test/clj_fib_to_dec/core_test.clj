(ns clj-fib-to-dec.core-test
  (:require [clojure.test :refer :all]
            [clj-fib-to-dec.core :refer :all]))


(deftest 
  test-char2num
  (is (= (range 10) (map clj-fib-to-dec.core/char2num '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9)))))


(deftest 
  test-dec-to-fib-to-dec
  (is (= true (reduce = (map clj-fib-to-dec.core/helper [1 5 8 13 37 57])))))

;; (run-tests clj-fib-to-dec.core-test)
