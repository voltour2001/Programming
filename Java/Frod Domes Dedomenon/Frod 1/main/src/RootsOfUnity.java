//compile: javac RootsOfUnity.java
//execute: java RootsOfUnity 10

public class RootsOfUnity 
  {
    public static void main(String[] args)
      { 
        int N = 10;

        for(int k = 0; k < N; k++){
          double re = Math.cos(2*Math.PI*k/N);
          double im = Math.sin(2*Math.PI*k/N);

          Complex t = new Complex(re, im);
          Complex z = new Complex(t.re, t.im);

          System.out.println("k: " + k + "(" + t.toString() + ")^N");

          for (int i = 0; i < N-1; i++) {
            z.mult(t);
          }

          System.out.println(z.toString());
        }
      }
  }