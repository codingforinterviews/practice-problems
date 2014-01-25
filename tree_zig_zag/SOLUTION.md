# Tree Zig Zag

## Human-readable solution

First you must read in the lines from standard input line-by-line and
construct some data structure that represents the tree. One easy
method is to represent each node using a distinct object that has
`left` and `right` variables to other nodes etc.

Next you must traverse the tree, from the root, level by level. A
breadth first search is ideal, as its maximum space complexity is the
number of nodes in the given level. Using a queue with a sentinel node
is the simplest method.

The pseudo-code is:

    current_level = []
    queue = [A, <sentinel>]
    while queue is not empty:
        node = pop left most item from queue
        if node is <sentinel>:
            process the current level using the zig zag rules
            reset current_level = []
            if the queue is not empty:
                add a sentinel to the right of the queue
        else:
            add node to current_level
            if node has a left child:
                add node's left child to current_level
            if node has a right child:
                add node's right child to th current_level

Consider an example tree:

             A
            / \
           /   \
          B     C
         /
        /
       D
      / \
     /   \
    F     E

The values for current_level and queue at each stage is:

    current_level = []
    queue = [A, <sentinel>]

    current_level = [A]
    queue = [<sentinel>, B, C]

    # process [A]

    current_level = []
    queue = [B, C, <sentinel>]

    current_level = [B]
    queue = [C, <sentinel>, D]

    current_level = [B, C]
    queue = [<sentinel>, D]

    # process [B, C]

    current_level = []
    queue = [D, <sentinel>]

    current_level = [D]
    queue = [<sentinel>, F, E]

    # process [D]

    current_level = []
    queue = [F, E, <sentinel>]

    current_level = [F]
    queue = [E, <sentinel>]

    current_level = [F, E]
    queue = [<sentinel>]

    # process [F, E]

    # end

Finally, what does "process" entail? Use a boolean flag to track
whether we're looking for the left-most or right-most element right now.
Depending on what the boolean flag's value is print index `0` or index
`len(current_level) - 1`. Toggle the boolean flag each time we process
a level.


