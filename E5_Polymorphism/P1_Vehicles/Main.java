package E5_Polymorphism.P1_Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputCar = scanner.nextLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(inputCar[1]);
        double consumptionCar = Double.parseDouble(inputCar[2]);
        Car car = new Car(fuelQuantityCar, consumptionCar);

        String[] inputTruck = scanner.nextLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
        double consumptionTruck = Double.parseDouble(inputTruck[2]);
        Truck truck = new Truck(fuelQuantityTruck, consumptionTruck);

        Map<String, Vehicles>mapVehicles = new LinkedHashMap<>();
        mapVehicles.put("Car", car);
        mapVehicles.put("Truck", truck);

        int numberCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String currentCommand = input[0];
            String vehicleType = input[1];
            switch (currentCommand){
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    System.out.println(mapVehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(input[2]);
                    mapVehicles.get(vehicleType).refuel(liters);
                    break;
                default:
                    throw new IllegalArgumentException("No such command");
            }
        }
        mapVehicles.values().stream().forEach(entry -> System.out.println(entry));
    }
}
