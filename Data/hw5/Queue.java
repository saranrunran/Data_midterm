package hw5;

public class Queue {
    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        arr = new Node[cap];
        this.capacity = cap;
    }
    
    public void enqueue(Node node){ //pushBack
        if (!isFull()){
            arr[back] = node;
            back = (back + 1) % capacity;
            size++;
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){ //popFront
        if (!isEmpty()){
            Node temp = arr[front];
            arr[front] = null;
            front = (front + 1) % capacity;
            size--;
            return temp;
            
        }else{
            System.out.println("Queue Underflow!!!");
            return null;
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            
            for(int i = 0; i < size; i++) {
                int index = (front+i)%capacity;
                System.out.print(arr[index].data + " ");
            }

            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}
