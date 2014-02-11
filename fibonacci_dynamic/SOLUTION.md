# Fibonacci Sequence with Dynamic Programming
## A.K.A. "Fibonacci Returns"

There are two major differences between this version of the Fibonacci exercise
and our previous "Lite" version. Both differences are to accommodate larger
inputs, as well as computing multiple values of *n* in one test case.

In pseudo-code, the solution works as follows:
    
    memoize the seed values

    for each value of n:
        if n is memoized:
	    return memoized value of n
	else:
	    result = largest memoized value of n
	    n_minus_1 = memoized value of (largest memoized n - 1)

            i = largest memoized n
	    
	    while i < n
	        n_minus_2 = n_minus_1
		n_minus_1 = result
		result = n_minus_2 + n_minus_1

		i++
		memoize(i, result)

	    return result

### Iterative Computation of the Sequence

Our previous reference implementation used a naive recursive implementation, as
it closely reflects the mathematical definition of the Fibonacci sequence and
serves as a good introduction to recursion. However, recursive functions with
this many levels are inefficient in some languages (including Ruby), so we have
opted for an iterative solution this time around.

This will give much better performance in Ruby (and some other languages), as
we avoid the overhead of a number of function call equal to *n*.

### Memoization

This is where the dynamic programming part of the solution comes in. Memoizing
is a dynamic programming technique where the results of a computation for some
input are re-used when the program recognizes that it has already been
computed. This can result in huge performance gains if sub-problems reappear
frequently. But how does this apply to the Fibonacci sequence?

The key observation is that to compute Fib(n), one must also compute every
value of the sequence from 1 to n. If we save all of the results from these
computations, it means that we can retrieve any value of n that is less than or
equal to the largest we have seen thus far in O(1) time instead of O(n) time!

Furthermore, if we need to compute a value of n larger than we have seen
before, we still use our largest value of n and can start computing from there
instead of from Fib(1).
