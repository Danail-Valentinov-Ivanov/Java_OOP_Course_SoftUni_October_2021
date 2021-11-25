package E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations;

import E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Identifiable;

public class Robot implements Identifiable {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
