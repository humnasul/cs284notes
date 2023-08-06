
public abstract class ShapeBase implements ShapeInterface{
    private int offset;

    public ShapeBase(int newOffset) {
        offset = newOffset;
    }

    public void setOffset(int off){offset = off;}

    public int getOffset(){ return offset; }

    public void drawAt(int lineNumber) {
        //Code here
        drawHere();
    }

    public abstract void drawHere();
    //subclasses must implement this
}
