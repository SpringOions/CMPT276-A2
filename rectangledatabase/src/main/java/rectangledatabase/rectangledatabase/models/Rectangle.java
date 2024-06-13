package rectangledatabase.rectangledatabase.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rectangles")
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;

    private String name;
    private String color;
    private int width;
    private int height;
    private String pattern;
    private String chiikawa;
    
    public Rectangle() {
    }

    public Rectangle(String chiikawa, String color, int height, String name, String pattern, int width) {
        this.chiikawa = chiikawa;
        this.color = color;
        this.height = height;
        this.name = name;
        this.pattern = pattern;
        this.width = width;
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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getChiikawa() {
        return chiikawa;
    }

    public void setChiikawa(String chiikawa) {
        this.chiikawa = chiikawa;
    }

    
}
