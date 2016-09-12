(ns clj-fib-to-dec.core)

(defn fib-seq
  "Generates a collection that is Fibonacci sequence of length n"
  [n]
  (if (= 2 n)
     '(1 1)
     (lazy-seq 
        (conj (fib-seq (dec n)) ;;previous sequence
              (+ (first (fib-seq (dec n))) (second (fib-seq (dec n)))))))) ;; new member to add

(defn fib-play
  [num]
  (loop [counter 2]
   (if (> num (first (fib-seq counter)))
    (fib-seq (dec counter))
    (recur (inc counter)))))


;;(defn dec-to-fib
;;  "Given a decimal number, return a collection of 1s and 0s for Fibonacci base"
;;)  


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
