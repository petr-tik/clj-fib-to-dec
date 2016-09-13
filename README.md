## Converter from decimal to Fibonacci sequence (and vice versa). 

(Source: [Daily programmer in Reddit](https://www.reddit.com/r/dailyprogrammer/comments/5196fi/20160905_challenge_282_easy_unusual_bases/))

The Fibonacci Sequence has a similar property that any positive integer can be written in the form of Fibonacci numbers (with no repeats). For example:

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

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
