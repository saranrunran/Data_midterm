package tester1;

public class Stack {

    Node head;

    public void push(Node node) {
        node.next = head;
        head = node;
    }

    public Node pop() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp;
        } else {
            System.out.println("ERR:Head is null");
            return null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Top] ");

            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }

            System.out.println("[Bottom]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}