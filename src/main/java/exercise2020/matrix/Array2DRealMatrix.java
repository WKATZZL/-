package exercise2020.matrix;

/**
 * Implementation for {@link RealMatrix} based on a double[][] array to store entities
 *
 * @author mtage
 * @since 2020/10/21 11:20
 */
public class Array2DRealMatrix implements RealMatrix {
    private double[][] value;

    public Array2DRealMatrix(final double[][] value)
            throws NoDataException, DimensionMismatchException {
        checkArrayShape(value);
        this.value = value;
    }

    public Array2DRealMatrix(final int rowDimension, final int columnDimension) throws OutOfBoundException {
        this.value = new double[rowDimension][columnDimension];
    }

    @Override
    public double[][] getDataAsArray2D() {
        return this.value;
    }

    @Override
    public int getRowDimension() {
        return value.length;
    }

    @Override
    public int getColumnDimension() {
        return value[0].length;
    }

    @Override
    public RealMatrix set(final int row, final int column, final double value) throws OutOfBoundException {
        if (row < 0 || row > getRowDimension() || column < 0 || column > getColumnDimension()) {
            throw new OutOfBoundException();
        }
        this.value[row][column] = value;
        return this;
    }

    @Override
    public double get(final int row, final int column) throws OutOfBoundException {
        if (row < 0 || row > getRowDimension() || column < 0 || column > getColumnDimension()) {
            throw new OutOfBoundException();
        }
        return this.value[row][column];
    }

    @Override
    public RealMatrix add(final RealMatrix matrix) {
        if (matrix.getRowDimension() != this.getRowDimension()
                || matrix.getColumnDimension() != this.getColumnDimension()) {
            throw new DimensionMismatchException();
        }
        double[][] resultValue = new double[getRowDimension()][getColumnDimension()];
        double[][] anotherMatrixData = matrix.getDataAsArray2D();
        for (int i = 0; i < getRowDimension(); i++) {
            for (int j = 0; j < getColumnDimension(); j++) {
                resultValue[i][j] = this.value[i][j] + anotherMatrixData[i][j];
            }
        }

        return new Array2DRealMatrix(resultValue);
    }

    @Override
    public RealMatrix multiply(final RealMatrix matrix) throws DimensionMismatchException {
        if (this.getColumnDimension() != matrix.getRowDimension()) {
            throw new DimensionMismatchException();
        }

        double[][] resultValue = new double[getRowDimension()][matrix.getColumnDimension()];
        double[][] anotherMatrixValue = matrix.getDataAsArray2D();

        for (int i = 0; i < getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                double currentValue = 0;
                for (int k = 0; k < getColumnDimension(); k++) {
                    currentValue += this.value[i][k] * anotherMatrixValue[k][j];
                }
                resultValue[i][j] = currentValue;
            }
        }

        return new Array2DRealMatrix(resultValue);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getRowDimension(); i++) {
            for (int j = 0; j < getColumnDimension(); j++) {
                builder.append(this.value[i][j]);
                if (j != getColumnDimension() - 1) {
                    builder.append(" ");
                }
            }
            if (i != getRowDimension() - 1) {
                builder.append(String.format("%n"));
            }
        }
        return builder.toString();
    }

    private static void checkArrayShape(final double[][] value) {
        if (value == null || value.length <= 0) {
            throw new NoDataException();
        }
        int columnCount = value[0].length;
        for (double[] row : value) {
            int currentColumnCount = row.length;
            if (currentColumnCount <= 0 || columnCount != currentColumnCount) {
                throw new DimensionMismatchException();
            }
        }
    }
}
