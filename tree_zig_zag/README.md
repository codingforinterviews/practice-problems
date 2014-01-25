# Tree Zig Zag

Given a tree with distinct elements, starting at the root, alternate
between printing the left-most and then the right-most element at each
level of the tree.

For example, given the following tree:

                100
             .-'   `-.
          .-'         `-.
        50               150
       /  \                 \
      /    \                 \
    40      60                170
              \                  \
               \                  \
                80                 190


The answer is:

    100
    150
    40
    190

## Input Format

Input is passed into your program using standard input. Each line
contains three integers: `a`, `b`, and `c`, indicating that the left
child of `a` is `b` and the right child of `a` is `c`.

The root node is always passed in as `a` on the first line.

If the value of a child is `-1` this implies that the child is not
present.

For example, the following right-leaning tree:

    200
       \
        \
         300
            \
             \
              400

would be represented as:

    200 -1 300
    300 -1 400

and the following left-leaning tree:

              200
             /
            /
         300
        /
       /
    400

would be represented as:

    200 300 -1
    300 400 -1

## Output Format

Output is passed into standard output. Each line contains one
integer, which is the current vertex on the zig zag path.

## Constraints

Each vertex can be represented as an integer in the range [1,
2147483647], i.e. can be stored as a signed 32-bit integer.

Recall that a vertex value of -1 means that a particular child is not
present.

## Examples

### Example 1

Given a tree:

                100
             .-'   `-.
          .-'         `-.
        50               150
       /  \                 \
      /    \                 \
    40      60                170
              \                  \
               \                  \
                80                 190

the input would be:

    100 50 150
    50 40 60
    60 -1 80
    150 -1 170
    170 -1 190

and the output would be:

    100
    150
    40
    190

## Example 2

Given a tree:

                     200
                  .-'
               .-'
            100
           /
          /
        50
       /  \
      /    \
    60      75

the input would be:

    200 100 -1
    100 50 -1
    50 60 75

and the output would be:

    200
    100
    50
    75
