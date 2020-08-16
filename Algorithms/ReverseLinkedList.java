
public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println("hello world");
        ReverseLinkedList t = new ReverseLinkedList();
        Node head = t.makeList();
        head = t.reverse(head);
        while (head != null) {
            System.out.println(head.data);
            head = head.child;
        }
    }

    public Node makeList() {
        Node head = new Node("A");
        Node retVal = head;
        for (int i = 1; i < 5; i++) {
            char val = (char) ('A' + i);
            Node n = new Node(Character.toString(val));
            head.child = n;
            head = head.child;
        }

        return retVal;
    }

    public Node reverse(Node head) {
        Node retVal = new Node(head.data);
        while (head.child != null) {
            Node n = new Node(head.child.data);
            n.child = retVal;
            retVal = n;

            head = head.child;
        }
        return retVal;
    }

    class Node {
        public String data;
        public Node child;

        public Node(String data) {
            this.data = data;
        }
    }
}