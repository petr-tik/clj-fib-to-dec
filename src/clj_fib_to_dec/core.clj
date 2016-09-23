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
  ===> (char2num \\2) 
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
  [fib-num]
  (reduce + (get-fib-values fib-num)))

;;;;;
;;   dec2fib and its helpers
;;;;;

(defn 
  fib-digits-from-dec
  "Given a decimal number and a sequence of relevant (less or equal to dec-num) 
  fibonacci numbers, returns a string with dec-num in fibonacci base
  ===> (fib-digits-from-dec '(13 8 5 3 2 1 1) 14)
  ===> \"1000010\"
  "
  ([fib-seq dec-num]
  (fib-digits-from-dec fib-seq dec-num (vector))) 
  ;; use a vector, so you can conj values to the end
  ([fib-seq dec-num digit-vec]
  (cond
   (empty? fib-seq) ;; cannot use lazy-seqs. Lazy sequence is never empty! 
       (reduce str digit-vec)
   (or (= 0 dec-num) 
       (< dec-num (first fib-seq)))
    ;; if decimal number is less than the first of fib-seq 
    ;; we won't be using that element of the fib-seq. It will be used zero times. 
       (fib-digits-from-dec 
        (rest fib-seq) 
        dec-num ;; dec-num isn't big enough to factor out this fib value
        (conj digit-vec 0)) ;; this fib value was used 0 times
    ;; otherwise
   (>= dec-num (first fib-seq))
   (fib-digits-from-dec 
    (rest fib-seq) 
    (- dec-num (first fib-seq)) 
    (conj digit-vec 1)))))

(defn 
  fib-seq-up-to-dec
  "Given a dec-num, returns a Fibonacci sequence (non-lazy) 
  increasing from right to left, where the leftmost (first) member 
  is less than or equal to dec-num
  ===> (fib-seq-up-to-dec 27) 
  ===> (21 13 8 5 3 2 1 1)
  "
  [dec-num]
  (loop [counter 2]
    (if (< dec-num (first (fib-seq counter)))
      (fib-seq (dec counter))
      (recur (inc counter)))))

(defn
  dec2fib
  "Given a number in decimal form, returns a string with number in fibonacci base
  Uses 
     fib-digits-from-dec 
     fib-seq-up-to-dec
  eg.
  ===> (dec2fib 27) 
  ===> \"10010010\"
  "
  ;; given a decimal, finds the greatest fib number that is less or equal to the decimal.
  ;; generate such a fib seq, where the max member 
  ;; is the biggest possible member of fib-seq smaller than dec-num
  ;; eg. 27 -> 
  ;; fib-seq    (21 13 8 5 3 2 1 1)
  ;; nums-used  (1  0  0 1 0 0 1 0)
  ;; then return a sequence of 1s or 0s for each fib number that is used or not
  [dec-num]
  (fib-digits-from-dec (fib-seq-up-to-dec dec-num) dec-num))


(defn
  test-both
  [dec-num]
  (= dec-num (fib2dec (dec2fib dec-num))))

(defn main
  "testing dec2fib and fib2dec"
  []
  (reduce = (map test-both [1 5 8 13 37 57])))
