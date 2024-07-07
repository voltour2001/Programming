class A{
    public void method() { 
        System.out.println("A"); 
    } 
}

class B extends A {
     
    public B(){
        System.out.println("this is the constructor of Class B!!!");
    }
    
    public void method() {
         System.out.println("B"); 
        } 
    
}

class MyClass{
    public static void main(String args[]){

        A x = new B();

        ((B)x).method();

    }
}
