package E5_Polymorphism.P1_Vehicles;

public class Truck extends Vehicles {
    private static final double CONSUMPTION_AC = 1.6;
    private static final double REFUEL_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_PERCENTAGE);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CONSUMPTION_AC);
    }
}
