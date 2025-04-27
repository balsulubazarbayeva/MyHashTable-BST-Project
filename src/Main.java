public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(i), "Value " + i);
        }
        System.out.println("HashTable size: " + table.getSize());

        table.printBucketSizes();

        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < 10000; i++) {
            bst.put(i, "Value " + i);
        }
        System.out.println("BST size: " + bst.getSize());

        System.out.println("BST In-Order Traversal:");
        for (BST.Pair<Integer, String> entry : bst) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
