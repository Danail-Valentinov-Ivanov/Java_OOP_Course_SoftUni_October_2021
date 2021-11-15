package L1_Working_with_Abstraction;

import java.util.Scanner;

class P1_Rhombus_of_Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombus(n);
    }

    public static void printRhombus(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTop(n)).append(getMiddle(n)).append(getBottom(n));
        System.out.println(stringBuilder);
    }

    private static String getTop(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int r = 1; r < n; r++) {
            stringBuilder.append(repeatString(n - r, " ")).append(repeatString(r, "* "))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String getMiddle(int n) {
        return repeatString(n, "* ") + System.lineSeparator();
    }

    private static String getBottom(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int r = 1; r < n; r++) {
            stringBuilder.append(repeatString(r, " ")).append(repeatString(n - r, "* "))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String repeatString(int count, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}

