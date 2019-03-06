package epamhw3;

public class Main {
    public static void main(String[] args) {
        final int M = 4, N = 6;
        MyMatrix matrix = new MyMatrix(M, N);
        matrix.fillMatrixRandom();
        System.out.println("This matrix:\n");
        matrix.showMatrix();

        System.out.println("The maximum element is: " + matrix.findMaxElement());
        System.out.println("The minimum element is: " + matrix.findMinElement());

        System.out.println("The arithmetic average is: " + matrix.findArithmeticAverage());
        System.out.println("The geometric average is: " + matrix.findGeometricAverage());

        System.out.println("Local maximum is: " + matrix.findLocalMax());
        System.out.println("Local minimum is: " + matrix.findLocalMin());

        System.out.println("Transposed matrix is:\n");
        matrix.transposeMatrix();
        matrix.showMatrix();
    }
}
