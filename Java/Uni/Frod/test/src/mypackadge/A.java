package mypackadge;

public class A{
    /*
    ! How to run A.java from App.java
    * import mypackadge.A;

    * A test = new A();
    * System.out.println(test.findMax(5, 10, 20));      
    */
    public static int findMax(int a, int b, int c){
        int max = a;
        if (b>max) max = b;
        
        if (c>max) max = c;

        return max;
    }
}

class B{
    public static void test(){
        System.out.println("THIS IS FROM CLASS B");
    }
}