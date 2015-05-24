class Node(object):
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left, self.right = left, right
    def add(self, val):
        if val < self.value:
            if self.left == None:
                self.left = Node(val)
            else:
                self.left.add(val)
        else:
            if self.right == None:
                self.right = Node(val)
            else:
                self.right.add(val)
    # The actual bit that matters
    def max_height(self):
        right_h = 0
        left_h = 0
        if self.right != None:
            right_h = self.right.max_height()
        if self.left != None:
            left_h = self.left.max_height()
        return 1 + max(right_h, left_h)
		
node = Node(5)
for i in range(10):
    node.add(i)
print(node.max_height())