/*
This contains my code from 3 files: ListNode.java, LinkedList.java, and LinkedListReverse.java (which contains the reverse functinos and an example main method). I copied the code into 1 file for convenience.

Partha Rajendra
*/

/*
	Partha Rajendra
	github: pvraj
	ListNode.java
*/

public class ListNode<T> {

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

/*
	Partha Rajendra
	github: pvraj
	LinkedList.java
*/

import java.util.*;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	private ListNode<T> head;
	private int size;


	public LinkedList() {
		this.size = 0;
		this.head = null;
	}

	public int getCount() {
		return this.size;
	}

	public ListNode<T> getHead() {
		return this.head;
	}

	public void setHead(ListNode<T> node) {
		this.head = node;
		this.setCount();
	}

	/*
		Set count in the case that a new head is set
	*/
	public void setCount() {
		LinkedListIterator iter = new LinkedListIterator(this.head);
		int currentSize = 1;
		while (iter.hasNext()) {
			iter.next();
			currentSize++;
		}
		this.size = currentSize;
	}

	public boolean empty() {
		if ((this.size == 0) && (this.head == null)) {
			return true;
		} else {
			return false;
		}
	}
	/*
		add at end.
	*/
	public void add(T data) {
		ListNode<T> newTail = new ListNode<T>(data, null);
		if (empty()) {
			this.head = newTail;
			this.size++;
		} else {
			ListNode<T> currentTail = goToIndex(this.size - 1);
			currentTail.setNext(newTail);
			this.size++;
		}
	}
	/*
		add at index.
	*/
	public void add(T data, int index) {
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (index == size) {
			this.add(data);
		} else if (index == 0) {
			this.addFirst(data);
		} else {
			ListNode<T> previousElement = goToIndex(index - 1);
			ListNode<T> currentElement = goToIndex(index);
			ListNode<T> newElement = new ListNode<T>(data, currentElement);
			previousElement.setNext(newElement);
			this.size++;
		}
	}

	public void addFirst(T data) {
		ListNode<T> previousHead = this.head;
		ListNode<T> newHead = new ListNode<T>(data, previousHead);
		this.head = newHead;
	}

	public void addLast(T data) {
		this.add(data);
	}

	public void clear() {
		this.head = null;
		this.size = 0;
	}

	public T get(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		ListNode<T> node = goToIndex(index);
		return node.getData();
	}

	public T remove(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (index == 0) {
			T temp = goToIndex(index).getData();
			this.head = this.head.getNext();
			this.size--;
			return temp;
		} else if (index == this.size - 1) {
			T temp = goToIndex(index).getData();
			ListNode<T> previousElement = goToIndex(index - 1);
			previousElement.setNext(null);
			this.size--;
			return temp;
		} else {
			T temp = goToIndex(index).getData();
			ListNode<T> previousElement = goToIndex(index - 1);
			ListNode<T> nextElement = goToIndex(index + 1);
			previousElement.setNext(nextElement);
			this.size--;
			return temp;
		}
	}
	/*
	remove first occurence
	*/
	public boolean remove(T data) {
		int targetIndex = indexOf(data);
		if (targetIndex == -1) {
			return false;
		} else {
			T temp = remove(targetIndex);
			return true;
		}
	}

	public T removeFirst() {
		return remove(0);
	}

	public T removeLast() {
		return remove(this.size - 1);
	}

	public ListNode<T> goToIndex(int target) {
		LinkedListIterator iter = new LinkedListIterator(this.head);
		int currentIndex = 0;
		while (iter.hasNext()) {
			if (currentIndex == target) {
				break;
			}
			iter.next();
			currentIndex++;
		}
		return iter.getCurrentNode();
	}

	public void set(int index, T data) {
		goToIndex(index).setData(data);
	}

	// first occurrence
	public int indexOf(T data) {
		LinkedListIterator iter = new LinkedListIterator(this.head);
		int currentIndex = 0;
		int targetIndex = -1;
		while (iter.hasNext()) {
			if (iter.getCurrentNode().getData().equals(data)) {
				targetIndex = currentIndex;
				break;
			}
			iter.next();
			currentIndex++;
		}
		if (targetIndex == -1) {
			iter.next();
			currentIndex++;
			if (iter.getCurrentNode().getData().equals(data)) {
				targetIndex = this.size - 1;
			}
		}
		return targetIndex;
	}

	public String toString() {
		if (empty()) {
			return "Empty list";
		}
		LinkedListIterator itr = new LinkedListIterator(this.head);
		StringBuilder str = new StringBuilder();
		while (itr.hasNext()) {
			str.append(" " + itr.getCurrentNode().getData() + "; ");
			itr.next();
		}
		str.append(" " + itr.getCurrentNode().getData());

		return str.toString();
	}



	public Iterator<T> iterator() {
		return new LinkedListIterator(this.head);
	}

	/*
	Wasn't sure how to use the iterator/iterable interface so searhced online for assistance
	*/
	private class LinkedListIterator implements Iterator<T> {

		private ListNode<T> currentNode;

		public LinkedListIterator(ListNode<T> node) {
			this.currentNode = node;
		}

		public boolean hasNext() {
			return (this.currentNode.getNext() != null);
		}

		public T next() {
			if (!hasNext()) {
				return null;
			} else {
				this.currentNode = this.currentNode.getNext();
				return this.currentNode.getData();
			}
		}

		public void remove() {
			// throw new UnsupportedOperationException();
		}

		public ListNode<T> getCurrentNode() {
			return this.currentNode;
		}
	}
}

/*
	Partha Rajendra
	github: pvraj
	LinkedListReverse.java
*/

public class LinkedListReverse {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		System.out.println(list);
		System.out.println("---------------------------");
		ListNode reverseHeadIterative = iterativeReverseNode(list.getHead());
		System.out.println(reverseHeadIterative);
		System.out.println("---------------------------");
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(new Integer(1));
		list2.add(new Integer(2));
		list2.add(new Integer(3));
		list2.add(new Integer(4));
		list2.add(new Integer(5));
		LinkedList reversedRecursiveList = recursiveReverseList(list2);
		System.out.println(reversedRecursiveList);
		System.out.println("---------------------------");
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		list3.add(new Integer(1));
		list3.add(new Integer(2));
		list3.add(new Integer(3));
		list3.add(new Integer(4));
		list3.add(new Integer(5));
		ListNode reverseHeadRecursive = recursiveReverseNode(list3.getHead());
		System.out.println(reverseHeadRecursive);

	}
	/*
		This version takes in a head node and returns the new head node. Iterative
	*/
	public static ListNode iterativeReverseNode(ListNode node) {
		if (node.getNext() == null) {
			return node;
		}
		ListNode previous = new ListNode(node);
		ListNode middle = new ListNode(previous.getNext());
		ListNode next = new ListNode(middle.getNext());
		previous.setNext(null);

		while (next != null) {
			middle.setNext(previous);
			previous = middle;
			middle = next;
			next = middle.getNext();
		}
		middle.setNext(previous);
		return middle;
	}
	/*
		This version takes in a linked list and returns the reversed linked list. Recursive
	*/
	public static LinkedList recursiveReverseList(LinkedList list) {
		if (list.getHead() == null) {
			return list;
		} else if (list.getHead().getNext() == null) {
			return list;
		} else {
			ListNode currentHead = list.getHead();
			ListNode newHead = list.getHead().getNext();
			LinkedList rest = new LinkedList();
			rest.setHead(newHead);
			LinkedList reversedRest = recursiveReverseList(rest);
			reversedRest.add(currentHead.getData());
			return reversedRest;
		}
	}
	/*
		This version takes in a head node and returns the new (reversed) head node. Recursive
	*/
	public static ListNode recursiveReverseNode(ListNode node) {
		if (node == null) {
			return node;
		} else if (node.getNext() == null) {
			return node;
		} else {
			ListNode rest = node.getNext();
			ListNode reversedRest = recursiveReverseNode(rest);
			ListNode pointer = reversedRest;
			while (pointer.getNext() != null) {
				pointer = pointer.getNext();	
			}
			node.setNext(null);
			pointer.setNext(node);
			return reversedRest;
		}
	}
}
