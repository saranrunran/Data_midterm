package hw3;

public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        this.listName = name;
    }
    
    public void popBack() {
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            Node current = head;
            if (head.next == null) {
                head = null;
            } else {
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
  
        }
    }
    
    public void popFront(){
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }
    
    public Node topBack(){ 
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()){
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) {
                if (current.student_id == id) { //ถ้าเจอ id ที่เราต้องการหาแล้ว
                    return current; //เอา node นั้นที่เจอออกไป
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) {
                if(current.student_id == id) {
                    if (current == head) {
                        head = head.next;
                        return current;
                    } else if (current.next == null) {
                        Node prev = head;
                        while (prev.next != current) {
                            prev = prev.next;
                        }
                        prev.next = null;
                        return current;
                    } else {
                        Node prev = head;
                        while (prev.next != current) {
                            prev = prev.next;
                        }
                        prev.next = current.next;
                        return current;
                    }
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        Node curr = head; //let it be the last one
        while (curr.next != null) {
            curr = curr.next;
        }
        if (node1 == curr) { //in case node1 is tail
            node1.next = node2;
            node2.next = null;
        } else {
            node2.next = node1.next;
            node1.next = node2;
        }
        
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if (node1 == head) {
            node2.next = node1;
            head = node2;
        } else {
            Node prev = head;
            while (prev.next != node1) {
                prev = prev.next;
            }
            prev.next = node2;
            node2.next = node1;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void merge(SinglyLinkedList list){
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list.head;
    }
    
    public void printStructure(){
        Node curerent = head;
        System.out.print(listName +": head -> ");
        while (curerent != null) {
            System.out.print("{"+curerent.student_id+"} -> ");
            curerent = curerent.next;
        }
        System.out.println("null");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node max = current;
            while(current != null) {
                if (current.gpa >= max.gpa) {
                    max = current;
                }
                current = current.next;
            }
            return max;
        }
    }
}
