import java.util.ArrayList;

public class PrintLinkedListFromTail {

    public int index;
    public int[] printed;

    public class Node {
        int value;
        Node next;

        public Node (int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedList {
        Node sentinel;

        private LinkedList() {
            this.sentinel = new Node(-1, null);
        }

        private LinkedList(Node head) {
            this.sentinel = new Node(-1, head);
            this.sentinel.next = head;
        }

        public void insertAtHead(Node node) {
            Node next = this.sentinel.next;
            this.sentinel.next = node;
            node.next = next;
        }

        public void of(int[] nodeValueArray) {
            for (int nodeValue: nodeValueArray) {
                insertAtHead(new Node(nodeValue, null));
            }
        }
    }

    public void printHelper(Node node) {
        if (node.next == null) {
            System.out.println(node.value);
            printed[index++] = node.value;
        } else {
            printHelper(node.next);
            System.out.println(node.value);
            printed[index++] = node.value;
        }
    }

    public int[] printFromTail(int[] values) {
        LinkedList list = new LinkedList();
        printed = new int[values.length];
        list.of(values);
        printHelper(list.sentinel.next);
        return printed;
    }
}
