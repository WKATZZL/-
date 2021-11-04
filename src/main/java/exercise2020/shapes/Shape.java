package exercise2020.shapes;

/**
 * @author mtage
 * @since 2020/11/19 19:39
 */
public abstract class Shape implements Comparable<Shape> {
    public abstract double getArea();

    @Override
    public int compareTo(Shape another) {
        return Double.compare(this.getArea(), another.getArea());
    }
}
