public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void PushBack(int data){ 
        // START FIX CODE HERE
        // โดย เริ่มต้นโปรแกรมจะเช็คว่าจำนวนข้อมูลใน array (size) เท่ากับ ขนาดของ array (capacity) หรือไม่
        if (size == capacity) { // ถ้า size = capacity นั่นหมายความว่า array ไม่มี index ว่างที่จะเพิ่มข้อมูลไปใหม่
            int newCapacity = capacity*2; // ดังนั้น โปรแกรมจะสร้้าง array ขึ้นมาใหม่ โดยมีขนาดเป็น 2 เท่า ของ array เดิม
            if (capacity == 0) {newCapacity = capacity+1 *2;} // ในกรณีที่ capacity เท่ากับ 0 แล้วจะเพิ่มขนาด capacity 2 เท่า จึงต้อง +1 ก่อน เพื่อให้ capacity*2 ไม่เท่ากับ 0
            int []newArr = new int[newCapacity]; //สร้าง array ตัวใหม่ ให้มีขนาดเท่ากับ capacity ที่ได้เพิ่ม 2 เท่า 
            for (int i = 0; i < size; i++) { 
                newArr[i] = arr[i]; // และจะคัดลอกข้อมูลที่อยู่ใน array เดิมมาที่ array ใหม่ โดยใช้ for-loop โดยมีตำแหน่งและข้อมูลเหมือนเดิม
            }
            arr = newArr; // กำหนดค่าให้ array ใหม่ มีชื่อเป็น array ปัจจุบันแทน
            capacity = newCapacity; // กำหนดค่าให้ capacity ใหม่ มีชื่อเป็น capacity ปัจจุบันแทน
        }
        arr[size] = data; // กำหนดค่าใน index ถัดจากตัวสุดท้ายของ array มีค่าเท่ากับ input (data) ที่ได้รับมา โดยใช้ size เป็นตัวบอกตำแหน่ง index ถัดไปจากตัวสุดท้าย เนื่องจาก size มีค่าเท่ากับ index ตัวสุดท้าย + 1
        size++; // เพื่อบอกว่ามีข้อมูลเพิ่มมา 1 ตัว และ เปลี่ยน index ที่ size ชี้ไป 1 index
        // END CODE HERE
    }

    public int PopBack(){
        // START FIX CODE HERE
        if (size > 0) { // โดยเริ่มต้นโปรแกรมจะเช็คว่า size มากกว่า 0 เพื่อดูว่าใน array มีสมาชิกอยู่หรือไม่ หากมีสมาชิกใน array ก็จะทำการลบสมาชิกตัวสุดท้ายของ array ออก
            int temp = arr[size-1]; //สร้างตัวแปรเพื่อเก็บค่าสมาชิกตัวสุดท้ายที่จะลบออก เพื่อนำไป return ออกจากฟังก์ชันก์ในตอนท้าย
            size--; //ลดขนาดของ array ลง เพื่อลบสมาชิกตัวสุดท้ายออก
            return temp; //return ค่าของข้อมูลที่ลบไปส่งให้กับ caller
        } else {
            System.err.println("ERROR"); //ในกรณีที่ size น้อยกว่า 0 หมายความว่าใน array ไม่มีข้อมูลอยู่ จึงไม่มีข้อมูลให้ลบออกจึง print ERROR และ return 0
            return 0;
        }
        // END CODE HERE
    }

    public int Get(int i){ 
        // START FIX CODE HERE
        if (i >= size ) { //เช็คว่าเลขตำแหน่ง index ที่รับเข้ามา (i) มีค่ามากกว่าหรือเท่ากับ size ไหม เพราะ index จะมีได้แค่ 0 ถึง size-1
            System.err.println("ERROR"); //เมื่อเลข index ที่รับเข้ามาเกิน size-1 จึงทำการ print ERROR ออกมา
            return 0;
        } else {
            return arr[i]; // หากเลข index ที่รับเข้ามาไม่เกิน ก็จะทำให้รีเทิร์นข้อมูลของ index นั้น
        }
        // END CODE HERE
    }
    public void Set(int i, int value){
        // START FIX CODE HERE
        if (i >= size ) { //เช็คว่าเลขตำแหน่ง index ที่รับเข้ามา (i) มีค่ามากกว่าหรือเท่ากับ size ไหม เพราะ index จะมีได้แค่ 0 ถึง size-1
            System.err.println("ERROR"); //เมื่อเลข index ที่รับเข้ามาเกิน size-1 จึงทำการ print ERROR ออกมา
        } else {
            arr[i] = value; //หากเลข index ที่รับเข้ามาไม่เกิน size-1 ก็จะแทนค่าเดิมด้วยค่า value ที่รับมา ลงไปใน index นั้น ที่รับ input มา
        }
        // END CODE HERE
    }
    
    public void Remove(int i){
        // START FIX CODE HERE
        if (i >= size ) { ///เช็คว่าเลขตำแหน่ง index ที่รับเข้ามา (i) มีค่ามากกว่าหรือเท่ากับ size ไหม เพราะ index จะมีได้แค่ 0 ถึง size-1
            System.err.println("ERROR"); //เมื่อเลข index ที่รับเข้ามาเกิน size-1 จึงทำการ print ERROR ออกมา
        } else {
            for (int j = i; j < size-1; j++) { //เขียน for loop เพื่อขยับเลื่อนสมาชิกมาทางซ้ายเรื่อย ๆ โดยกำหนดค่าให้ j = i (i มีค่าเท่ากับ index ที่ต้องการจะลบออก)
                arr[j] = arr[j+1]; //แทนค่าที่เราจะลบด้วยตัวถัดไปของ index นั้น ๆ (ลบ index ที่ 7 ด้วยการเอาค่าสมาชิก index ที่ 8 มาแทนที่)
            }
            size--; //ทำการลดขนาด size หลังจากลบสมาชิกออกตัวนึง
        }
        // END CODE HERE
    }
    
    public boolean IsEmpty(){
        // START FIX CODE HERE
        return size == 0; //เช็คว่า size = 0 ไหม ถ้าใช่ ก็แปลว่า array ไม่มีสมาชิกเลย จึงทำการรีเทิร์น true ออกไป
        // END CODE HERE
    }
    
    public int GetSize(){
        // START FIX CODE HERE
        return size; //รีเทิร์นค่าของ size ออกไป ทำให้รู้ว่าตอนนี้มีสมาชิกกี่ตัวใน array
        // END CODE HERE
    }
    
    public void PrintStructure(){
        // START FIX CODE HERE
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ "); //ปริ้นท์ฟอร์มของคำตอบ ประกอบไปด้วย size, capacity และ array
        for(int i=0; i < size; i++) { //ใช้ for loop ปริ้นท์ค่าใน array ออกทีละตัว ตั้งแต่ index: 0 ถึง index ตัวสุดท้าย
            System.out.print(arr[i]);
            if (i < size-1) { //เช็คว่าถ้ายังไม่ใช่ตัวสุดท้ายของ array ก็จะยังใส่ , อยู่
                System.out.print(", ");
            } else if(i == size-1) {System.out.print(" ");} //แต่ถ้าเป็นตัวสุดท้าย จะเลิกใส่ , และวรรค 1 วรรคเพื่อที่จะรอใส่ ] ให้ถูกตามฟอร์ม
        }
        System.out.print("] \n"); //ใส่ ] เพื่อปิดตามฟอร์ม
        // END CODE HERE
    }
}