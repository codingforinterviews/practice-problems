package linklist;


import java.util.Stack;

public class LinkedListUtils {

    public static Node reverseRecursive(Node head) {
        return swap(head, null);
    }

    private static Node swap(Node current, Node previous) {
        if (current == null) {
            return previous;
        }
        Node right = current.next;
        current.next = previous;
        return swap(right, current);
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static Node reverseUsingStack(Node head) {
        Stack<Node> nodes = new Stack<>();
        Node current = head;
        while (current != null) {
            nodes.push(current);
            current = current.next;
        }

        Node newHead = nodes.pop();
        current = newHead;
        while (!nodes.isEmpty()) {
            Node next = nodes.pop();
            current.next = next;
            current = next;
        }

        return newHead;
    }
}
