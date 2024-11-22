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

        // Використовуємо методи з MatrixUtils
        long xorResult[][] = MatrixUtils.bitwiseXOR(A, B);
        System.out.println("Результат побітового XOR матриць A і B:");
        MatrixUtils.printMatrix(xorResult);

        long sum = MatrixUtils.sumOddEvenColumns(A);
        System.out.println("Сума найбільших (непарні стовпці) та найменших (парні стовпці): " + sum);
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
    // Побітове виключне "але"
    public static long[][] bitwiseXOR(long[][] A, long[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        long[][] result = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] ^ B[i][j];
            }
        }
        return result;
    }

    // Сума найбільших (непарні стовпці) та найменших (парні стовпці)
    public static long sumOddEvenColumns(long[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long sum = 0;

        for (int j = 0; j < cols; j++) {
            long extreme = (j % 2 == 0) ? Long.MAX_VALUE : Long.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                if (j % 2 == 0) {
                    extreme = Math.min(extreme, matrix[i][j]); // Найменше (парні)
                } else {
                    extreme = Math.max(extreme, matrix[i][j]); // Найбільше (непарні)
                }
            }
            sum += extreme;
        }
        return sum;
    }

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
