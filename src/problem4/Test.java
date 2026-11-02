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
    }
}