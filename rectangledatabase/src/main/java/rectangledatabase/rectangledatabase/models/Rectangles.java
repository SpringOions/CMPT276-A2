package rectangledatabase.rectangledatabase.models;

public class Rectangles {
    private String name;
    private String color;
    private int width;
    private int height;
    
    public Rectangles() {
    }

    public Rectangles(String name, String color, int width, int height) {
        this.name = name;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
