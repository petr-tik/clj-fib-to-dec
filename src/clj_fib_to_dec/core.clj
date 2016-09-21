(ns clj-fib-to-dec.core)

(defn fib-seq
  "Generates a collection that is Fibonacci sequence of length n
  ===> (fib-seq 5) 
  ===> (5 3 2 1 1)
  "
  [n]
  (if (= 2 n)
     '(1 1)
     (lazy-seq 
        (conj (fib-seq (dec n)) ;;previous sequence
              (+ (first (fib-seq (dec n))) (second (fib-seq (dec n)))))))) ;; new member to add

(defn fib-play
  [num]
  (loop [counter 2]
   (if (< num (first (fib-seq counter)))
    (fib-seq (dec counter))
    (recur (inc counter)))))

(defn- fib 
  ([] (fib 1 1))
  ([n-1 n-2] (lazy-seq (cons n-2 (fib (+ n-1 n-2) n-1)))))

(defn-
  char2num
  "Returns the int value of a symbol (\2 \4 etc.)
  ===> (char2num \2) 
  ===> 2
  "
  [n]
  (- (int n) (int \0)))

(defn-
  chop-in-parts
  "Turns a string of digits into a collection of ints using char2num
  ===> (chop-in-parts \"10001\") 
  ===> (1 0 0 0 1)
  "
  [number]
  (map char2num number))

(defn-
  get-fib-values
  "Given a string of a number in fibonacci base, returns a collection 
  where every element at idx is the product of 1 or 0 from fib_num string 
  and fibonacci value at idx
  ===> (get-fib-values \"1001\")
  ===> (1 0 0 3)
"
  [fib_num]
  (->> fib_num
    chop-in-parts
    reverse
    (map * (fib))))


(defn
  fib2dec
  "Given a number in fibonacci base (as a string) return the decimal value
  ===> (fib2dec \"1001\") 
  ===> 4
  "
  [fib_num]
  (reduce + (get-fib-values fib_num)))


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
