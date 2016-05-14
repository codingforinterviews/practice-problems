class Node
  attr_accessor :node, :next

  def initialize(node)
    @node = node
  end

  def self.node_list(node, msg = nil)
    # Display a linked list as a string
    msg ||= ""
    return msg[0..-5] if node.nil?
    node_list(node.next, msg << "#{node.node} -> ")
  end

  def self.reverse(node)
    # Reverse a linked list, returns new head
    # 1 -> 2 -> 3 -> 4 -> nil
    # 4 -> 3 -> 2 -> 1 -> nil
    a = nil
    b = node
    while b != nil do
      c = b.next
      b.next = a
      a = b
      b = c
    end
    return a
  end
end
