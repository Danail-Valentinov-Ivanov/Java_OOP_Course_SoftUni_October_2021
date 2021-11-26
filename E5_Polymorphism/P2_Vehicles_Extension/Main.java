package E5_Polymorphism.P2_Vehicles_Extension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicles> mapVehicles = new LinkedHashMap<>();
        int n = 3;
        while (n-- > 0) {
            String[] inputVehicle = scanner.nextLine().split("\\s+");
            Vehicles vehicles = getVehicle(inputVehicle);
            String vehicleType = inputVehicle[0];
            mapVehicles.put(vehicleType, vehicles);
        }

//        Car car = new Car(fuelQuantityCar, consumptionCar);

//        String[] inputTruck = scanner.nextLine().split("\\s+");
//        double fuelQuantityTruck = Double.parseDouble(inputTruck[1]);
//        double consumptionTruck = Double.parseDouble(inputTruck[2]);
//        Truck truck = new Truck(fuelQuantityTruck, consumptionTruck);

//        mapVehicles.put("Car", car);
//        mapVehicles.put("Truck", truck);

        int numberCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String currentCommand = input[0];
            String vehicleType = input[1];
            Vehicles vehicles = mapVehicles.get(vehicleType);
            try {
                switch (currentCommand) {
                    case "Drive":
                        double distance = Double.parseDouble(input[2]);
                        if (vehicles instanceof Bus) {
                            ((Bus) vehicles).setIsEmpty(false);
                        }
                        System.out.println(vehicles.drive(distance));
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(input[2]);
                        vehicles.refuel(liters);
                        break;
                    case "DriveEmpty":
                        double distanceEmptyBus = Double.parseDouble(input[2]);
                        if (vehicles instanceof Bus) {
                            ((Bus) vehicles).setIsEmpty(true);
                        }
                        System.out.println(vehicles.drive(distanceEmptyBus));
                        break;
                    default:
                        throw new IllegalArgumentException("No such command");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
        mapVehicles.values().stream().forEach(entry -> System.out.println(entry));
    }

    private static Vehicles getVehicle(String[] inputVehicle) {
        String vehicleType = inputVehicle[0];
        double fuelQuantityVehicle = Double.parseDouble(inputVehicle[1]);
        double consumptionVehicle = Double.parseDouble(inputVehicle[2]);
        double tankCapacity = Double.parseDouble(inputVehicle[3]);
//        Vehicles vehicles = null;
        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantityVehicle, consumptionVehicle, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantityVehicle, consumptionVehicle, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantityVehicle, consumptionVehicle, tankCapacity);
        }
        return null;
    }
}
