package E5_Polymorphism.P2_Vehicles_Extension;

public class Car extends Vehicles{private static final double CONSUMPTION_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CONSUMPTION_AC);
    }
}
