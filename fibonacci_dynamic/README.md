This question expands on our earlier Fibonacci Lite challenge. While the goal
of Fibonacci Lite was to understand recursion, this challenge is about solving
problems efficiently with dynamic programming.

The difference in this challenge is that each test case will consist of many
inputs instead of just one. Furthermore, we're allowing larger values of *n*.
You'll need to use dynamic programming to solve all the inputs without running
out of time.

So, given many numbers *n*, print the *n*th value of the Fibonacci
sequence for each of them, in order, on their own line.

Here are the definitions of the sequence again:

> *F<sub>n</sub> = F<sub>n - 1</sub> + F<sub>n - 2</sub>*

Using the following seed values:

> *F<sub>0</sub> = 0, F<sub>1</sub> = 1*

## Examples
Input:

```
1
2
3
4
5
6
7
8
9
10
```

Output:

```
1
1
2
3
5
8
13
21
34
55	
```

Input:

```
41
8
22
```

Output:

```
165580141
21
17711
```
## Input Format and Restrictions
Each test case will consist of several positive integers *n*, each on their own line.

The inputs will always satisfy the following restrictions:

* *F<sub>n</sub>* < 2^**64** - 1,
* 0 <= *n* < **100**
