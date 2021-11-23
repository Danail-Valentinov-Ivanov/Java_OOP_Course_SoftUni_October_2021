package E3_Inheritance.E3_P4_Need_for_Speed;

public class SportCar extends Car {
    private static final double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
