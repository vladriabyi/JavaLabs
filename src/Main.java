import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Параметри
        final int C5 = 18 % 5;
        final int C7 = 18 % 7;
        final int C11 = 18 % 11;

        // Розмірність матриць
        final int rows = 4;
        final int cols = 5;

        // Створення матриць
        long[][] A = generateMatrix(rows, cols);
        long[][] B = generateMatrix(rows, cols);

        // Виведення початкових матриць
        System.out.println("Матриця A:");
        MatrixUtils.printMatrix(A);

        System.out.println("Матриця B:");
        MatrixUtils.printMatrix(B);
    }

    // Генерація матриці з випадковими числами
    private static long[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Випадкові числа від 0 до 99
            }
        }
        return matrix;
    }
}

class MatrixUtils {
    // Виведення матриці
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long value : row) {
                System.out.printf("%5d ", value);
            }
            System.out.println();
        }
    }
}
