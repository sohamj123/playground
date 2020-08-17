
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeArray {
    public static void main(String[]args){
        int[] a = {1,2,3,4,5,6,7};
        BinaryTreeArray b = new BinaryTreeArray();
        BTree bt = b.new BTree(a);
        System.out.println(bt.head.data);
        b.printchildren(a, 1);
        b.printchildren(a, 2);
        b.printchildren(a, 3);
    }

    public void printchildren(int[] btree, int parent){
        for (int i =0; i<btree.length;i++){
            if (btree[i] == parent) {
                System.out.println(String.format("Parent : %d, Left Child : %d, Right Child : %d", parent, btree[2*i +1], btree[2*i +2]));
                return;
            }
        }
    }

    public class BTree{
        Node head;
        public BTree(int[] input){
            Queue<Node> q = new LinkedList<Node>();
            for (int i=0;i< input.length; i++){
                Node c = q.peek();
                if (c == null) {
                    c = new Node(input[i]);
                    head =c;
                    q.add(c);
                    continue;
                }
                if (c.left == null) {
                    c.left = new Node(input[i]);
                    q.add(c.left);
                    continue;
                }
                if (c.right == null){
                    c.right = new Node(input[i]);
                    q.add(c.right);
                    q.remove();
                }

            }
        }        
    }

    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int i){
            this.data = i;
        }

    }
}