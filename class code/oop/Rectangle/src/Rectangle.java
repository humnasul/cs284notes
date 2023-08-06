
public class Rectangle extends Shape{
	//Data fields
	private double width;
	private double height;
	private static int noOfRectangles = 0;
	
	public Rectangle(double width, double height, String color) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, double height) {
		super("Blue");
		this.width = width;
		this.height = height;
	}

	public Rectangle(double width, String color){
		super(color);
		this.width = width;
		height = 0;
	}

	public Rectangle(){
		this(0,0);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double area() {
		return width * height;
	}

	public double area(double w, double h) {
		return w*h;
	}

	public double area(int w, int h) {
		return w*h;
	}

	
	public String toString() {
		return "I am a Rectangle. My width is "+width+". my height is "+height+" and my color is "+this.getColor();
		//this.getColor() must be done to access the color in superclass
	}
}
