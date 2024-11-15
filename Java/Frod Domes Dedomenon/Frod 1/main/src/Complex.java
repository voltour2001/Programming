//compile: javac Complex.java

class Complex implements ComplexInterface {
    public double re, im;
    
    public Complex(double re, double im){ 
    	this.re = re;
    	this.im = im;
    }
    
    public double re(){ 
    	return re;
    }
    
    public double im(){ 
    	return im;
    }
    
    public void add(Complex rhs){ 
        double re = (this.re + rhs.re);
        double im = (this.im + rhs.im);
        this.re = re;
        this.im = im;
    }
    
    
    public void mult(Complex rhs){ 
        //a+ib * c+id = (ac-bd) + (ad+bc)i
        double re = (this.re * rhs.re - this.im * rhs.im);
        double im = (this.re * rhs.im + this.im * rhs.re);
        this.re = re;
        this.im = im;
    }

    public String toString(){ 
    	return re() + " + " + im()+ "i"; 
    }

}