package tester1;

public class Main {
    
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(new Node('+'));
        s.push(new Node('-'));
        s.push(new Node('+'));
        s.push(new Node('7'));
        s.push(new Node('5'));
        s.push(new Node('2'));
        s.push(new Node('9'));
        s.printStack();

        System.out.println("The answer is " + postFix(s));

    }

    public static int postFix(Stack n) {
        Stack s = new Stack();
        while(!n.isEmpty()) {
            Node node = n.pop();
            if(node.data == '+') {
                Node a = s.pop();
                Node b = s.pop();
                s.push(new Node((char)(((a.data-'0') + (b.data-'0'))+ '0')));
            } else if (node.data == '-') {
                Node a = s.pop();
                Node b = s.pop();
                s.push(new Node((char)(((b.data-'0') - (a.data-'0'))+ '0')));
            } else if (node.data == '*') {
                Node a = s.pop();
                Node b = s.pop();
                s.push(new Node((char)(((b.data-'0') * (a.data-'0'))+ '0')));
            } else if (node.data == '/'){
                Node a = s.pop();
                Node b = s.pop();
                s.push(new Node((char)(((b.data-'0') / (a.data-'0')) + '0')));  
            } else {
                s.push(node);
            }
        }
        Node answer = s.pop();
        return (char)answer.data;
    }
}