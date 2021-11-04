package exercise2020.shapes;

/**
 * @author mtage
 * @since 2020/11/19 19:43
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(final double width, final double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                '}';
    }
}
