#!/usr/bin/env python

import collections
import sys


class Node(object):
    __slots__ = ('value', 'left', 'right')

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __hash__(self):
        return hash(self.value)

    def __eq__(self, other):
        if id(self) == id(other):
            return True
        return self.value == other.value

    def __str__(self):
        return "{value=%s, left=%s, right=%s}" % (self.value, self.left, self.right)

    def __repr__(self):
        return str(self.value)


class TreeReader(object):
    @classmethod
    def get_vertex(cls, value, vertices):
        if value == -1:
            return None
        key = Node(value)
        if key not in vertices:
            vertices[key] = key
        return vertices[key]

    @classmethod
    def read_tree(cls, stream):
        root = None
        vertices = {}
        for line in stream:
            (vertex_value, left_value, right_value) = map(int, line.split())
            vertex = cls.get_vertex(vertex_value, vertices)
            vertex.left = cls.get_vertex(left_value, vertices)
            vertex.right = cls.get_vertex(right_value, vertices)
            if root is None:
                root = vertex
        return root


def zig_zag_traverse(root):
    is_left_most = True
    current_level = []
    sentinel = Node(-1)
    queue = collections.deque([root, sentinel])
    while len(queue) != 0:
        node = queue.popleft()
        if node == sentinel:
            index = 0 if is_left_most else len(current_level) - 1
            print(current_level[index].value)
            current_level = []
            is_left_most = not is_left_most
            if len(queue) != 0:
                queue.append(sentinel)
        else:
            current_level.append(node)
            queue.extend(x for x in [node.left, node.right] if x)


def main():
    root = TreeReader.read_tree(sys.stdin)
    zig_zag_traverse(root)


if __name__ == "__main__":
    sys.exit(main())
