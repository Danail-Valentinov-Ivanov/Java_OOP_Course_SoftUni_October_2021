package E4_Interfaces_and_Abstraction.P2_Multiple_Implementation;

import E4_Interfaces_and_Abstraction.P2_Multiple_Implementation.Birthable;

public class Citizen implements Person, Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }
}
