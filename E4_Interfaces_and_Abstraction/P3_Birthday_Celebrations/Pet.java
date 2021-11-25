package E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations;

import E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Birthable;

public class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
