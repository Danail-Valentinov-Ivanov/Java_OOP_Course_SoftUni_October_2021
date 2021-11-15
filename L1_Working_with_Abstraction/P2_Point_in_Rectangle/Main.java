package L1_Working_with_Abstraction.P2_Point_in_Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayCoordinates = readArray(scanner);
        Point pointA = new Point(arrayCoordinates[0], arrayCoordinates[1]);
        Point pointB = new Point(arrayCoordinates[2], arrayCoordinates[3]);
        Rectangle rectangle = new Rectangle(pointA, pointB);
        int number = Integer.parseInt(scanner.nextLine());
        while (number-- > 0) {
            int[] arrayCoordinatesForCheck = readArray(scanner);
            Point pointForCheck = new Point(arrayCoordinatesForCheck[0], arrayCoordinatesForCheck[1]);
            System.out.println(rectangle.isInside(pointForCheck));
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
