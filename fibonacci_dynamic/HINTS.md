## General Approach

1. Find the base case(s),
2. Have your function recognize the base case(s) and provide a solution,
3. *Recognize if you have already solved this input,*
4. Recursively define a solution to the sub-problem for other inputs,
5. Call your function on the input and print the result to STDOUT.

## Things to think about

* If your language doesn't support tail call elimination, you might want to use an iterative approach this time.
* How will you recognize if you already have a solution for a given sub-problem?
* How do you plan to store your previous solutions? Are there major trade-offs for using different data structures in this case?
