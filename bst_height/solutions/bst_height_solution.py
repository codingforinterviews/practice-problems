"""
Binary Search Tree Height Solution

"""


class Node(object):
    """
    Node to represent a node in a BST

    """
    def __init__(self, val):
        self.value = val
        self.left = None
        self.right = None


def insert_node(root, new_node):
    """
    Helper function to insert nodes into a BST

    :param root:
    :param new_node:
    :return:
    """
    if new_node.value < root.value:
        if not root.left:
            root.left = new_node
        else:
            insert_node(root.left, new_node)
    else:
        if not root.right:
            root.right = new_node
        else:
            insert_node(root.right, new_node)


def bst_height(root, level_height=0):
    """
    Get the height of a BST

    :param root:
    :return:
    """
    if not root:
        return level_height
    return 1 + max(bst_height(root.left, level_height),
                   bst_height(root.right, level_height))


def test_linear_left_bst():
    root = Node(5)
    insert_node(root, Node(4))
    insert_node(root, Node(3))
    insert_node(root, Node(2))
    insert_node(root, Node(1))
    assert(5 == bst_height(root))


def test_linear_right_bst():
    root = Node(0)
    insert_node(root, Node(1))
    insert_node(root, Node(2))
    assert(3 == bst_height(root))


def test_balanced_bst():
    root = Node(19)
    insert_node(root, Node(10))
    insert_node(root, Node(27))
    insert_node(root, Node(7))
    insert_node(root, Node(17))
    insert_node(root, Node(20))
    insert_node(root, Node(29))
    assert(3 == bst_height(root))


def test_unbalanced_bst():
    root = Node(19)
    insert_node(root, Node(10))
    insert_node(root, Node(27))
    insert_node(root, Node(7))
    insert_node(root, Node(17))
    insert_node(root, Node(29))
    insert_node(root, Node(31))
    insert_node(root, Node(33))
    insert_node(root, Node(35))
    assert(6 == bst_height(root))
