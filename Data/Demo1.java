public class Demo1 {
    
    public static int hello(int x) {
        System.out.println("Hello");
        return x*2;
    }

    public static void main(String[] args) {

        int[] arr = {5,6,69,7,8};

        // int myMax = findMax(arr);
        // System.out.println("myMax = "+myMax);

        System.out.println(fibo(50));

    }

    public static int findMax(int[] arr) {
        int max = 0;
        int num = 0;
        for (int i=0; i < arr.length; i++) {
            if (arr[i] > max ) {
                max = arr[i];
                num = i;
            }
        }
        return num;
    }

    public static long fibo(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return fibo(num - 1) + fibo(num -2);
    }
}
