package E5_Polymorphism.P2_Vehicles_Extension;

public class Bus extends Vehicles {
    private static final double CONSUMPTION_AC = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = true;
    }

    public void setIsEmpty(boolean empty) {
//        if (isEmpty==empty){
//            return;
//        }
        if (isEmpty && !empty) {
            super.setFuelConsumption(super.getFuelConsumption() + CONSUMPTION_AC);
        }
        if (!isEmpty && empty) {
            super.setFuelConsumption(super.getFuelConsumption() - CONSUMPTION_AC);
        }
        isEmpty = empty;
    }
}
