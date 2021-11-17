package E1_Working_with_Abstraction.P5_Jedi_Galaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensionsGalaxy = readData(scanner.nextLine());
        int rows = dimensionsGalaxy[0];
        int cols = dimensionsGalaxy[1];

        Galaxy galaxy = new Galaxy(rows,cols);

        String coordinates = scanner.nextLine();
        long sumStarsValue = 0;
        while (!coordinates.equals("Let the Force be with you")) {
            int[] coordinatesPlayer = readData(coordinates);
            int[] coordinatesEvil = readData(scanner.nextLine());
            int rowEvil = coordinatesEvil[0];
            int colEvil = coordinatesEvil[1];

            while (rowEvil >= 0 && colEvil >= 0) {
                getMovementEvil(rowEvil, colEvil, rows, cols, galaxy.getMatrix());
                rowEvil--;
                colEvil--;
            }

            int rowPlayer = coordinatesPlayer[0];
            int colPlayer = coordinatesPlayer[1];

            while (rowPlayer >= 0 && colPlayer < cols) {
                sumStarsValue += getSumStarsValue(rowPlayer, colPlayer, rows, cols, galaxy.getMatrix());
                colPlayer++;
                rowPlayer--;
            }

            coordinates = scanner.nextLine();
        }

        System.out.println(sumStarsValue);

    }

    private static void getMovementEvil(int rowEvil, int colEvil, int rows, int cols, int[][] galaxy) {
        if (rowEvil < rows && colEvil < cols) {
            galaxy[rowEvil][colEvil] = 0;
        }
    }

    private static long getSumStarsValue(int rowPlayer, int colPlayer, int rows, int cols, int[][] galaxy) {
        int sumStarsValue = 0;
        if (rowPlayer < rows && colPlayer >= 0) {
            sumStarsValue += galaxy[rowPlayer][colPlayer];
        }
        return sumStarsValue;
    }

    private static int[] readData(String coordinates) {
        return Arrays.stream(coordinates.split(" ")).mapToInt(Integer::parseInt)
                .toArray();
    }
}
