import java.util.*;

class LinkedListCyclePvraj {

	public static void main(String[] args) {
		ListNode a = new ListNode();
		ListNode b = new ListNode();
		ListNode c = new ListNode();
		a.setData(new Integer(1));
		a.setNext(b);
		b.setData(new Integer(2));
		b.setNext(c);
		c.setData(new Integer(3));
		c.setNext(a);
		boolean result = hasCycleBJordanAlgorithm(a);
		System.out.println(result);
	}

	/*
		This is using the Brian Jordan algorithm which uses 2 pointers moving at different rates, rather than keeping track of every element.
	*/
	public static boolean hasCycleBJordanAlgorithm(ListNode node1) {
		boolean connected = false;
		if (node1.getNext() == null) {
			return connected;
		} else if (node1.getNext().getNext() == null) {
			return connected;
		} else {
			ListNode node2 = node1.getNext().getNext();
			while (node2 != null && node2.getNext() != null) {
				if (node1 == node2) {
					connected = true;
					return connected;
				} else {
					node2 = node2.getNext().getNext();
					node1 = node1.getNext();
				}
			}
			return connected;
		}
	}
}

/*
	Partha Rajendra
	github: pvraj
	ListNode.java
*/

class ListNode<T> {

	private T data;
	private ListNode<T> nextNode;

	public ListNode() {
		this.data = null;
		this.nextNode = null;
	}

	public ListNode(T d, ListNode<T> newNext) {
		this.data = d;
		this.nextNode = newNext;
	}

	public ListNode(ListNode<T> node) {
		this.data = node.getData();
		this.nextNode = node.getNext();
	}

	public T getData() {
		return this.data;
	}

	public ListNode<T> getNext() {
		return this.nextNode;
	}

	public void setData(T d) {
		this.data = d;
	}

	public void setNext(ListNode<T> newNext) {
		this.nextNode = newNext;
	}

	public String toString() {
		return this.data + "--> " + this.nextNode + " ";
	}
}