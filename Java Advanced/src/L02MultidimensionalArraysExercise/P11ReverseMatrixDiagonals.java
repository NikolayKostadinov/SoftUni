package L02MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] matrixDimensions = readArray(scan, "\\s+");
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        int[][] matrix = readMatrix(rows, cols, scan, "\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int row = i;
                int col = j;
                while (row >= 0 && col < cols-1) {
                    sb.append(String.format("%d ", matrix[row][col]));
                    row--;
                    col++;
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scan, String separator) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(readArray(scan, separator)).limit(cols).toArray();
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }
}
