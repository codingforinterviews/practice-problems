# Fibonacci Lite

## Explanation

The example solution for this challenge deliberately uses a naive recursive
solution, as it is meant to be an introduction to recursion. Notice that our
function definition looks very similar to the (recursive) mathematical
definition. Furthermore, take note that the function calls itself in the last
line; this is what makes it recursive.

Here it is in pseudo-code:
    fibonacci(n)
        if n == 0
            return 0
        else if n == 1
            return 1
        else
            return fibonacci(n - 1) + fibonacci(n - 2)

Our base cases are defined for positions 0 and 1 in the sequence, so we check
for those values first. Any larger values are recursively derived by breaking
*n* down into progressively smaller values, eventually reaching the base case.

## Limitations

This implementation is sufficient for our exercise, but we should also consider
why solutions in this form should not be used in production applications.

First of all, it assumes that it will receive a positive integer as input. If
it is given a negative integer, the base cases will never be reached and the
function will run until the call stack is exhausted and the program crashes.

Second, it is not at all efficient. Even languages which support tail call
elimination are not likely to optimize this function, as the last line depends
on the results of two separate recursive calls. In any case, even for valid
inputs, the amount of memory required to compute the recursive calls may be
large enough that the program will crash, even though it would succeed if there
were more memory available.
