public class RotateMatrix {

    public static void main(String[] args) {
        int matrix_1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("-------------Ist matrix before rotating-------------");
        printMatrix(matrix_1);
        rotateMatrix(matrix_1, 3);
        System.out.println("-------------Ist matrix after rotating-------------");
        printMatrix(matrix_1);
        int matrix_2[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("-------------2nd matrix before rotating-------------");
        printMatrix(matrix_2);
        rotateMatrix(matrix_2, 4);
        System.out.println("-------------2nd matrix after rotating-------------");
        printMatrix(matrix_2);
    }

    public static void rotateMatrix(int[][] matrix, int n) {
        int layers = n / 2;
        for (int row = 0; row < layers; row++) {
            int start = row;
            int end = n - 1 - row;
            for (int col = start; col < end; col++) {
                int temp = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
