package E5_Polymorphism.P1_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
    }

    public String drive(double distance) {
        double needFuel = distance * fuelConsumption;
        if (needFuel > fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
        fuelQuantity -= needFuel;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s travelled %s km"
                , getClass().getSimpleName(), decimalFormat.format(distance));
    }

    public void refuel(double liters) {
        fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
