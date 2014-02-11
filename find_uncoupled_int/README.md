Find the only uncoupled integer in an array.

# Problem Statement

Write a program that, given a list of integers as an argument to STDIN  

* `n1, n2, n3, ..` 

Prints out the only uncoupled (unpaired) integer in the list to STDOUT.

**Example 1:**

Given the input

```
1, 2, 3, 1, 2
```

your program should output:

```
3
```

**Example 2:**

Given the input

```
1, 2, 3, 4, 5, 99, 1, 2, 3, 4, 5
```

your program should output:

```
99
```

# Hints

* It is possible to solve this with 

   Time: O(n) and Space: O(1)
 
  So before diving into a hashtable solution, take a refresher on [Bitwise Operations](http://en.wikipedia.org/wiki/Bitwise_operation) 
