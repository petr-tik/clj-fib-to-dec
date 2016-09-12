(ns clj-fib-to-dec.core)

(defn fib-seq
  "Generates a collection that is Fibonacci sequence of length n"
  [n]
  (if (= 2 n)
     '(1 1)
     (lazy-seq 
        (conj (fib-seq (dec n)) ;;previous sequence
              (+ (first (fib-seq (dec n))) (second (fib-seq (dec n)))))))) ;; new member to add


(defn- fib 
  ([] (fib 1 1))
  ([n-1 n-2] (lazy-seq (cons n-2 (fib (+ n-1 n-2) n-1)))))

(defn-
  char2num
  [n]
  (- (int n) (int \0)))

(defn- 
  chop-in-parts
  [number]
  (map char2num number))

(defn-
  get-fib-values
  [fib_num]
  (->> fib_num
    chop-in-parts
    reverse
    (map * (fib))))

;; (fib2dec "1001") -> 4
(defn
  fib2dec
  [fib_num]
  (reduce + (get-fib-values fib_num)))


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
