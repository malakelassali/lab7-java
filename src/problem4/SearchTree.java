package problem4;

public class SearchTree implements NodeList {
    private ListItem root;
    public SearchTree(ListItem root) {
        this.root= root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null) return false;
        if (root == null) {
            root= item;
            return true;
        }

        ListItem current = root;

        while (true){
            int comp = current.compareTo(item);
            if (comp == 0) return false;
            if (comp > 0) {
                if (current.previous() == null) {
                    current.setPrevious(item);
                    return true;
                }
                current= current.previous();
            }
            if (comp < 0) {
                if (current.next() == null) {
                    current.setNext(item);
                    return true;
                }
                current= current.next();
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        }
        ListItem current= root;
        ListItem parent= null;

        while (current != null) {
            int comparison= current.compareTo(item);
            if (comparison == 0) {
                performRemoval(current, parent);
                return true;
            }

            parent= current;
            if (comparison > 0) {
                current= current.previous();
            } else {
                current= current.next();
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.previous() != null && item.next() != null) {
            ListItem successor= item.next();
            ListItem successorParent= item;

            while (successor.previous() != null) {
                successorParent= successor;
                successor= successor.previous();
            }

            item.setValue(successor.getValue());
            performRemoval(successor, successorParent);
            return;
        }

        ListItem child= item.previous();

        if (child == null) {
            child= item.next();
        }

        if (parent == null) {
            root= child;
        } else if (parent.previous() == item) {
            parent.setPrevious(child);
        } else {
            parent.setNext(child);
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        if (root.previous() != null) {
            traverse(root.previous());
        }

        System.out.println(root.getValue());
        if (root.next() != null) {
            traverse(root.next());
        }
    }
}
