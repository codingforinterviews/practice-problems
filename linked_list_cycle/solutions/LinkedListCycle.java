import java.io.*;
import java.util.*;

class Node<T> {
  public Node<T> next;
  public T data;

  public boolean containsCycle() {
    Node<T> stepping1 = this;
    Node<T> stepping2 = this;

    while (stepping2.next != null && stepping2.next.next != null) {
      stepping1 = stepping1.next;
      stepping2 = stepping2.next.next;

      if (stepping1 == stepping2) {
        return true;
      }
    }

    return false;
  }
}

class Solution {
  public static void main(String[] args) {
    Node<String> a = new Node<String>();
    a.data = "A";
    Node<String> b = new Node<String>();
    b.data = "B";
    Node<String> c = new Node<String>();
    c.data = "C";
    Node<String> d = new Node<String>();
    d.data = "D";
    Node<String> e = new Node<String>();
    d.data = "E";

    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = c;

    System.out.println(a.containsCycle());

    Node<String> f = new Node<String>();
    f.next = null;
    System.out.println(f.containsCycle());

    Node<String> h = new Node<String>();
    Node<String> i = new Node<String>();
    h.next = i;
    i.next = null;
    System.out.println(h.containsCycle());


  }
}
