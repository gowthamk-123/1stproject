import java.util.Scanner;

class Math {
    int a, b;

    public void result(Scanner scanner) {
        System.out.print("Enter the value of the 1st number: ");
        a = scanner.nextInt();
        System.out.print("Enter the value of the 2nd number: ");
        b = scanner.nextInt();
    }

    int add() {
        return a + b;
    }

    int subtract() {
        return a - b;
    }

    int multiply() {
        return a * b;
    }

    int divide() {
        if (b == 0) {
            System.out.println("Infinity");
            return 1;
        } else {
            return a / b;
        }
    }

    int[][] matrixAddition(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }

    int[][] matrixMultiplication(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int cols2 = mat2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    int[][] inputMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Math c = new Math();
        Scanner scanner = new Scanner(System.in);
        int ch;

        System.out.println(
                "\nMENU\n1.ADDITION\n2.SUBTRACTION\n3.MULTIPLICATION\n4.DIVISION\n5.MATRIX ADDITION\n6.MATRIX MULTIPLICATION\n0.EXIT\n");

        do {
            System.out.print("Enter your choice: ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    c.result(scanner);
                    System.out.println("Result: " + c.add());
                    break;
                case 2:
                    c.result(scanner);
                    System.out.println("Result: " + c.subtract());
                    break;
                case 3:
                    c.result(scanner);
                    System.out.println("Result: " + c.multiply());
                    break;
                case 4:
                    c.result(scanner);
                    System.out.println("Result: " + c.divide());
                    break;
                case 5:
                    System.out.print("Enter number of rows and columns for matrices: ");
                    int rows = scanner.nextInt();
                    int cols = scanner.nextInt();
                    System.out.println("Matrix 1:");
                    int[][] mat1 = c.inputMatrix(scanner, rows, cols);
                    System.out.println("Matrix 2:");
                    int[][] mat2 = c.inputMatrix(scanner, rows, cols);
                    int[][] sum = c.matrixAddition(mat1, mat2);
                    System.out.println("Matrix Addition Result:");
                    c.printMatrix(sum);
                    break;
                case 6:
                    System.out.print("Enter number of rows and columns for Matrix 1: ");
                    int rows1 = scanner.nextInt();
                    int cols1 = scanner.nextInt();
                    System.out.print("Enter number of columns for Matrix 2: ");
                    int cols2 = scanner.nextInt();
                    System.out.println("Matrix 1:");
                    int[][] mat3 = c.inputMatrix(scanner, rows1, cols1);
                    System.out.println("Matrix 2:");
                    int[][] mat4 = c.inputMatrix(scanner, cols1, cols2);
                    int[][] product = c.matrixMultiplication(mat3, mat4);
                    System.out.println("Matrix Multiplication Result:");
                    c.printMatrix(product);
                    break;
            }
        } while (ch >= 1 && ch <= 6);

        scanner.close();
    }
}
