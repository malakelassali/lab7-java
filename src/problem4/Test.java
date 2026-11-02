package problem4;

public class Test {
    public static void main(String[] args) {
        MyLinkedList list= new MyLinkedList(null);

        list.addItem(new Node("N1"));
        list.addItem(new Node("N2"));
        list.addItem(new Node("N3"));

        list.traverse(list.getRoot());

        System.out.println("\nRemove N1:");
        list.removeItem(new Node("N1"));
        list.traverse(list.getRoot());

        SearchTree tree= new SearchTree(null);

        tree.addItem(new Node("T2"));
        tree.addItem(new Node("T1"));
        tree.addItem(new Node("T3"));

        System.out.println("\nTree:");
        tree.traverse(tree.getRoot());

        System.out.println("\nRemove T2:");
        tree.removeItem(new Node("T2"));
        tree.traverse(tree.getRoot());
    }
}