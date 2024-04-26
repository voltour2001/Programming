interface Shape1 {
	
	String color="RED";
    double area();
	
}

class Rectangle1 implements Shape1 {
	
	double length;
	double width;

	public Rectangle1(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double area() {
        return length * width;
    }
	
	public String xxx() {
        return "Color " + color + " length " + length + " width " + width;
    }
}

class App1 {
	
    public static void main(String[] args) {
		Rectangle1 r1 = new Rectangle1(2.0, 3.0);
		System.out.println ("Rectangle: " + r1);
		System.out.println ("Area of Rectangle: " + r1.area());
	}
}
