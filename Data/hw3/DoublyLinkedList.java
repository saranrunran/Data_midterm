package hw3;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        this.listName = name;
    }
    
    public void popBack() { //not yet
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.previous; //เอา tail ไปชี้ตัวก่อนหน้าของมัน
                tail.next = null; //พอได้ tail เป็นตัวก่อนหน้า ก็เลยชี้ตัวถัดไปซึ่งก็คือตัวที่จะลบ พอชี้แล้ว ก็เลยให้มีค่า null เพื่อลบออก
            }
        }
    }
    
    public void popFront(){ //not yet
        if (isEmpty()){
            System.out.println("ERROR");
        }else{
            if (head.next == null) {
                head = null;
                tail = null;
            } else { 
                head = head.next;
                head.previous = null;
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
            return tail;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) { //
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
                if (current.student_id == id) { //ถ้าเจอ id ที่เราต้องการหาแล้ว
                    if (current == head) {
                        head = head.next;
                        head.previous = null;
                    } else if (current == tail) {
                        tail = current.previous;
                        tail.next = null;
                    } else {
                        current.previous.next = current.next; //เอาตัวก่อนหน้าชี้ถัดไปของปจบ และพอไม่มีอะไรชี้ตัวปจบ ปจบก้หายไปเลย
                        current.next.previous = current.previous;
                    }
                    return current; //รีเทิร์นออกไปให้ caller
                }
                current = current.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if (node1 == tail) {
            node1.next = node2;
            node2.previous = node1;
            tail = node2;
        } else {
            node2.next = node1.next;
            node2.next.previous = node2;
            node1.next = node2;
            node2.previous = node1;
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if (node1 == head) {
            node1.previous = node2;
            node2.next = node1;
            node2.previous = null;
            head = node2;
        } else {
            node2.next = node1;
            node2.previous = node1.previous;
            node1.previous.next = node2;
            node1.previous = node2;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }

    public void merge(DoublyLinkedList list){
        this.tail.next = list.head;
        list.head.previous = this.tail;
        this.tail = list.tail;
    }
    
    public void printStructure(){
        Node curerent = head;
        System.out.print(listName +": head <-> ");
        while (curerent != null) {
            System.out.print("{"+curerent.student_id+"} <-> ");
            curerent = curerent.next;
        }
        System.out.println("tail");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current != null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
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
