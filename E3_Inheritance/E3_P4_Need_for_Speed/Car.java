package E3_Inheritance.E3_P4_Need_for_Speed;

public class Car extends Vehicle{
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
