public class Shape {

    //Data fields
    private String color;

    //Constructors
    Shape(String color){
        this.color = color;
    }

    public String getColor(){return color;}

    public void setColor(String color){this.color = color;}
    @Override
    public String toString(){
        return "I am a shape and my color is " + color;
    }
}
