(ns clj-fib-to-dec.core)

(defn fib-seq
  "Generates a collection that is Fibonacci sequence of length n"
  [n]
  (if (= 2 n)
     '(1 1)
     (lazy-seq 
        (conj (fib-seq (dec n)) ;;previous sequence
              (+ (first (fib-seq (dec n))) (second (fib-seq (dec n)))))))) ;; new member to add




(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
