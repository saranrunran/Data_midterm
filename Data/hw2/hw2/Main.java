public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray var1 = new DynamicArray(2);
        var1.PushBack(1);
        var1.PrintStructure();

        var1.PushBack(2);
        var1.PrintStructure();

        var1.PushBack(3);
        var1.PrintStructure();

        var1.Set(2, 5);
        var1.PrintStructure();

        var1.Remove(1);
        var1.PrintStructure();
    }
    
}
