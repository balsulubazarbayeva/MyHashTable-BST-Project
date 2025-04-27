public class MyHashTable<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] buckets;
    private int size;

    public MyHashTable() {
        buckets = new Node[16];
        size = 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    // Bucket өлшемдерін басып шығару
    public void printBucketSizes() {
        for (int i = 0; i < buckets.length; i++) {
            int bucketSize = 0;
            Node<K, V> node = buckets[i];
            while (node != null) {
                bucketSize++;
                node = node.next;
            }
            System.out.println("Bucket " + i + " size: " + bucketSize);
        }
    }
}
