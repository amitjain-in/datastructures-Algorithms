package amit.theory.ds;

/**
 * Most naive implementation of LinkedList for educational purpose ONLY. Not thread-safe
 *
 * @param <T> - The data you want to save in the list's nodes.
 */
public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * Adds new <param>data</param> to the tail
     *
     * @param data - The data to be added to the node
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    /**
     * Remove the first occurrence of the <param>data</<param> in the list.
     * @param data - Data to be removed from the list.
     * @return true if the node was found and remove and false otherwise.
     */
    public boolean remove(T data) {

        if (head == null) {//List is empty
            return false;

        } else if (head.data == data) {//Element to be removed is head itself.
            if (head.next == null) {//and it is the only element
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return true;

        } else {//Element is after head
            Node<T> node = head;
            Node<T> prev = null;
            while (node != null && !node.data.equals(data)) {
                prev = node;
                node = node.next;
            }

            if (node != null) {
                if (node.equals(tail)) {//Tail is the element to be deleted.
                    tail = prev;
                } else {
                    prev.next = node.next;//Removed the node by pointing prev to node.next
                    node.next.prev = prev;
                }
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean contains(T data) {
        Node<T> node = head;
        while(node != null && !node.data.equals(data)) {
            node = node.next;
        }

        return node != null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    static class Node<T> {
        private final T data;//You cannot the change the data in the node.
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}
