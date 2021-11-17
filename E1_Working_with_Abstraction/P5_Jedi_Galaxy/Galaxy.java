package E1_Working_with_Abstraction.P5_Jedi_Galaxy;

public class Galaxy {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Galaxy(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = readMatrix();
    }

    private int[][] readMatrix() {
        matrix = new int[rows][cols];
        int starValue = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = starValue++;
            }
        }
        return matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
