# Balanced Delimiters

## Explanation

This exercise is designed as a use case for a stack structure. The idea is that
characters are processed individually; opening characters go on the stack, and
closing characters check the stack for a match. If we encounter a closing
character that does not match the top of our stack, encounter a closing
character with an empty stack, or have a non-empty stack at the end of the
string, the string is unbalanced.

Here it is in pseudo-code:
    for each character in string:
        if opener:
	    push on stack
	else:
	    previous = pop stack OR False
	    if not (character closes previous):
	        False
    if stack empty:
        True
    else:
        False

Stacks are ideal for this problem, as their FILO (First In, Last Out) behavior
corresponds to the fact that we must match the innermost delimiter first *but*
we must also remember each layer of delimiters in order. In addition, checking
whether the stack is empty allows us to easily handle cases where we have too
many opening or closing delimiters.
