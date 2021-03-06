package kmitl.lab03.danaya58070042.simplemydot.model;

public class Dot {

    public interface OnDotChangedListener {
        void onDotChanged(Dot dot);
    }



    private OnDotChangedListener listener;


    public void setListener(OnDotChangedListener listener) {
        this.listener = listener;
    }

    private int centerX;
    private int centerY;
    private int radius;



    public Dot(OnDotChangedListener listener, int centerX, int centerY, int radius) {
        this.listener = listener;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.listener.onDotChanged(this);
    }

    public Dot(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

    }

    public int getCenterX() {return centerX;}

    public int getCenterY() {return centerY;}

    public int getRadius() {return radius;}

    public void setCenterX(int centerX) {
        this.centerX = centerX;
        this.listener.onDotChanged(this);

    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
        this.listener.onDotChanged(this);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
