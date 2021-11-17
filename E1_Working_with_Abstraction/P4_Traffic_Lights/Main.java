package E1_Working_with_Abstraction.P4_Traffic_Lights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Color[] startColors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> e.toUpperCase()).map(e -> Color.valueOf(e)).toArray(value -> new Color[value]);

        List<TrafficLight> trafficLights = new ArrayList<>();
        for (Color color : startColors) {
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);
        }
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight + " ");
            }
            System.out.println();
        }
    }
}
