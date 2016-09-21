## Converter from decimal to Fibonacci sequence (and vice versa). 

(Source: [Daily programmer in Reddit](https://www.reddit.com/r/dailyprogrammer/comments/5196fi/20160905_challenge_282_easy_unusual_bases/))

There is a mathematical property that any positive integer can be written as a sum of Fibonacci numbers (with no repeats). For example:

``
25 = 21 + 3 + 1
``

If we use the same form as for writing binary, with the Fibonacci sequence instead of powers of 2, we can represent which Fibonacci numbers we use with a 1, and the ones we don't with a 0.

```
13	8	5	3	2	1	1
1	0	1	0	0	1	0
```

The no-repeats property applies to the Fibonacci-based encoding. There can be multiple ways of representing a decimal number:

```
25 = 21 + 3 + 1
25 = 21 + 2 + 1 + 1
```

### Basic puzzle

Write dec-to-fib and fib-to-dec  converters.

### Harder

Make sure the dec-to-fib converter outputs a number with the fewest 1's

### Even more interesting 

Make sure the dec-to-fib converter outputs a number with the most 1's


## License

Puzzle at the London Clojure Dojo 2016
