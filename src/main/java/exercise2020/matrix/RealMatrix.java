package exercise2020.matrix;

/**
 * Interface defining a real-valued exercise2020.matrix with basic operations
 * @author mtage
 * @since 2020/10/21 11:17
 */
public interface RealMatrix {
    double[][] getDataAsArray2D();

    int getRowDimension();

    int getColumnDimension();

    RealMatrix set(int row, int column, double value) throws OutOfBoundException;

    double get(int row, int column) throws OutOfBoundException;

    RealMatrix add(RealMatrix matrix) throws DimensionMismatchException;

    RealMatrix multiply(RealMatrix matrix) throws DimensionMismatchException;
}
