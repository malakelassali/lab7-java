package problem4;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root= root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null) {
            return false;
        }
        ListItem current= root;
        ListItem previous= null;
        while (current != null) {
            int comp= current.compareTo(item);
            if (comp == 0) {
                return false;
            }
            if (comp > 0) {
                break;
            }
            previous= current;
            current= current.next();
        }

        item.setPrevious(previous);
        item.setNext(current);
        if (previous == null) {
            root= item;
        } else {
            previous.setNext(item);
        }
        if (current != null) {
            current.setPrevious(item);
        }
        return true;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        }

        ListItem current= root;
        while (current != null) {
            int comp= current.compareTo(item);
            if (comp == 0) {
                ListItem previous= current.previous();
                ListItem next= current.next();
                if (previous == null) {
                    root= next;
                } else {
                    previous.setNext(next);
                }

                if (next != null) {
                    next.setPrevious(previous);
                }
                current.setPrevious(null);
                current.setNext(null);
                return true;
            }
            if (comp > 0) {
                return false;
            }
            current= current.next();
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        ListItem current= root;
        while (current != null) {
            System.out.println(current.getValue());
            current= current.next();
        }
    }
}