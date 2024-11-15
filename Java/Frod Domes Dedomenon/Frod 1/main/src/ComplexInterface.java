//compile: javac ComplexInterface.java

public interface ComplexInterface {
    public double re();
    
    public double im();
    
    public void add(Complex rhs);
    
    public void mult(Complex rhs);

    public String toString();    
}
