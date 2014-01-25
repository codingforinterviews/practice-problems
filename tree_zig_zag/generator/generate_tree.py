#!/usr/bin/env python

"""Create a random binary search tree (BST) with distinct elements.

The resulting BST is not necessarily balanced.

Output is sent to standard output as lines, each line with two
integers a and b, indicating that a is a parent of b. Children are
added left-to-right to their parents.
"""

import random
import sys


class Node(object):
    __slots__ = ('value', 'left', 'right')

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.value)

    def __repr__(self):
        return "{value=%s}" % self.value

    @property
    def children(self):
        return [self.left, self.right]

    def as_hackerrank_lines(self):
        if all(child is None for child in self.children):
            raise StopIteration
        child_values = map(lambda x: str(x) if x else "-1", self.children)
        yield "%s %s" % (self, " ".join(child_values))
        for child in self.children:
            if child is not None:
                for line in child.as_hackerrank_lines():
                    yield line


def generate_bst(size, min_value=1, max_value=2 ** 31 - 1):
    if size <= 0:
        return None
    if min_value >= (max_value - 1):
        return None
    if random.random() <= 0.5:
        # Both left and right children
        node = Node(min_value + (max_value - min_value) // 2)
        left_subtree_size = random.randint(0, size - 1)
        right_subtree_size = size - left_subtree_size - 1
        node.left = generate_bst(left_subtree_size, min_value, node.value)
        node.right = generate_bst(right_subtree_size, node.value, max_value)
    elif random.random() <= 0.5:
        # Only a left child
        node = Node(max_value - 1)
        node.left = generate_bst(size - 1, min_value, node.value)
    else:
        # Only a right child
        node = Node(min_value + 1)
        node.right = generate_bst(size - 1, node.value, max_value)
    assert(is_bst(node, min_value, max_value))
    return node


def is_bst(node, min_value=1, max_value=2 ** 31 - 1):
    if node is None:
        return True
    if node.value <= min_value or node.value >= max_value:
        return False
    return is_bst(node.left, min_value, node.value) and is_bst(node.right, node.value, max_value)


def main():
    random.seed(42)
    root = generate_bst(int(sys.argv[1]))
    for line in root.as_hackerrank_lines():
        print(line)


if __name__ == "__main__":
    sys.exit(main())
