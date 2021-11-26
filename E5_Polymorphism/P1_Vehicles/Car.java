package E5_Polymorphism.P1_Vehicles;

public class Car extends Vehicles {
    private static final double CONSUMPTION_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CONSUMPTION_AC);
    }
}
