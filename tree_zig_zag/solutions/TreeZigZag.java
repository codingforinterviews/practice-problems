import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    /**
     * An empty constructor is used only for creating sentinels, which
     * are useful in some algorithms. This is why a corresponding
     * setValue() is not provided.
     */
    Node() {
    }

    Node(T value) {
        this.value = value;
    }

    public void setLeft(Node<T> left) { this.left = left; }
    public Node<T> getLeft() { return this.left; }
    public void setRight(Node<T> right) { this.right = right; }
    public Node<T> getRight() { return this.right; }
    public T getValue() { return this.value; }

    @Override
    public String toString() {
        return String.format("{value=%s, left=%s, right=%s}", value, left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?>)) return false;
        Node<?> node = (Node<?>)o;
        return this.value.equals(node.value);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + value.hashCode();
        return result;
    }
}


class ZigZagTreeLevelSearch<T> {
    private boolean isLeftMost;

    public void search(Node<T> root) {
        List<Node<T>> currentLevel = new ArrayList<Node<T>>();
        isLeftMost = true;
        Node<T> sentinel = new Node<T>();
        Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
        queue.add(root);
        queue.add(sentinel);
        while(!queue.isEmpty()) {
            Node<T> current = queue.remove();
            if (current == sentinel) {
                processLevel(currentLevel);
                isLeftMost = !isLeftMost;
                currentLevel = new ArrayList<Node<T>>();
                if (!queue.isEmpty())
                    queue.add(sentinel);
            } else {
                currentLevel.add(current);
                if (current.getLeft() != null)
                    queue.add(current.getLeft());
                if (current.getRight() != null)
                    queue.add(current.getRight());
            }
        }
    }

    public void processLevel(List<Node<T>> level) {
        int index = isLeftMost ? 0 : level.size() - 1;
        System.out.println(level.get(index).getValue());
    } 
}


class TreeReader {
    public Node<Integer> getOrCreate(Integer value, Map<Node<Integer>, Node<Integer>> map) {
        if (value.equals(-1))
            return null;
        Node<Integer> key = new Node<Integer>(value);
        Node<Integer> node;
        if (map.containsKey(key)) {
            node = map.get(key);
        } else {
            node = key;
            map.put(key, key);
        }
        return node;
    }

    public Node<Integer> readTree(InputStream in) {
        Map<Node<Integer>, Node<Integer>> map = new HashMap<Node<Integer>, Node<Integer>>();
        Node<Integer> root = null;
        Scanner sc = new Scanner(in);
        while (sc.hasNextLine()) {
            Integer vertexValue = sc.nextInt();
            Integer leftValue = sc.nextInt();
            Integer rightValue = sc.nextInt();
            Node<Integer> vertex = getOrCreate(vertexValue, map);
            Node<Integer> left = getOrCreate(leftValue, map);
            Node<Integer> right = getOrCreate(rightValue, map);
            vertex.setLeft(left);
            vertex.setRight(right);
            if (root == null)
                root = vertex;
        }
        return root;
    }    
}


class TreeZigZag {
    public static void main(String args[]) {
        TreeReader tr = new TreeReader();
        Node<Integer> root = tr.readTree(System.in);
        ZigZagTreeLevelSearch<Integer> searcher = new ZigZagTreeLevelSearch<Integer>();
        searcher.search(root);
    }
}
