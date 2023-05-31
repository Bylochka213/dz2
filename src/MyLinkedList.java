public class MyLinkedList<E> {
    private class Node {
        public E element;
        public Node next;

        public Node(E element) {
            this.element = element;
            next = null;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public String toString() {
            return "Node = " + this.element.toString();
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        Node node = getNode(index);
        return node.element;
    }

    public int indexOf(Object obj) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (obj.equals(node.element))
                return i;
            node = node.next;
        }
        return -1;
    }

    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node lastNode = getNode(size - 1);
            lastNode.next = new Node(element);
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node prevNode = getNode(index - 1);
            prevNode.next = new Node(element, prevNode.next);
        }
        size++;
    }

    public boolean remove(Object obj) {
        if (head == null)
            return false;

        if (obj.equals(head.element)) {
            head = head.next;
            size--;
            return true;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            if (obj.equals(currNode.element)) {
                prevNode.next = currNode.next;
                size--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node removeNode = head;
            head = head.next;
            size--;
            return removeNode.element;
        }

        Node prevNode = getNode(index - 1);
        Node removeNode = prevNode.next;
        prevNode.next = removeNode.next;
        size--;

        return removeNode.element;
    }
}
