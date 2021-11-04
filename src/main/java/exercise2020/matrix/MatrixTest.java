package exercise2020.matrix;

/**
 * @author mtage
 * @since 2020/10/21 11:35
 */
public class MatrixTest {
    public static void main(String[] args) {
        RealMatrix matrix = new Array2DRealMatrix(new double[][]{{1d, 2d}, {2.5d, -1d}});
        RealMatrix another = new Array2DRealMatrix((new double[][]{{3d, 1d}, {0d, -2d}}));
        RealMatrix expect = new Array2DRealMatrix((new double[][]{{2d, 3d}}));
        RealMatrix expectB = new Array2DRealMatrix(5, 5);

        System.out.println(matrix);
        System.out.println(matrix.get(0, 1));
        System.out.println();
        matrix.set(0, 1, -6d);
        expectB.set(2, 2, -9d);
        System.out.println(matrix);
        System.out.println(expectB);
        System.out.println();
        System.out.println(another);
        System.out.println();
        System.out.println(expect);

        System.out.println();
//        exercise2020.matrix.set(2, 1, 9d);
        System.out.println(matrix);

        System.out.println(matrix.add(another));
        System.out.println();
        System.out.println(matrix.multiply(another));

//        new Array2DRealMatrix(new double[0][0]);

        new Array2DRealMatrix(new double[][]{new double[2], new double[3]});
    }
}
