package hw5;

public class Main {
    
    public static void main(String[] args) {
        	
        Queue q = new Queue(4);
        q.dequeue();
        q.enqueue(new Node(5));
        q.enqueue(new Node(6));
        q.enqueue(new Node(7));
        q.enqueue(new Node(8));
        q.printQueue();
        q.enqueue(new Node(9));
        System.out.println(q.dequeue().data);
        System.out.println(q.dequeue().data);
        System.out.println(q.dequeue().data);
        q.printQueue();
            
    }
}
