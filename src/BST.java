import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Pair<K, V>> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Node<K, V> root;
    private int size = 0;

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }
        Node<K, V> current = root;
        while (true) {
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    size++;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<>() {
            private Stack<Node<K, V>> stack = new Stack<>();
            private Node<K, V> current = root;

            {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Pair<K, V> next() {
                Node<K, V> node = stack.pop();
                Pair<K, V> result = new Pair<>(node.key, node.value);
                if (node.right != null) {
                    Node<K, V> temp = node.right;
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }
                return result;
            }
        };
    }
}

