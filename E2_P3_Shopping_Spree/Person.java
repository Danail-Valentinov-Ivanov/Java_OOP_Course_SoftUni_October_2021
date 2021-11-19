package E2_P3_Shopping_Spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
//    - name: String
//- money: double
//- products: List&lt;Product&gt;

    //+ E4_Interfaces_and_Abstraction.P1_Define_an_Interface_Person.E4_Interfaces_and_Abstraction.P2_Multiple_Implementation.E4_Interfaces_and_Abstraction.P4_Food_Shortage.Person (String , double)
//- setName (String) : void
//- setMoney (double) : void
//+ buyProduct (Product) : void
//+ getName(): String
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s"
                    , this.name, product.getName()));
        }
        products.add(product);
        this.money -= product.getCost();
        System.out.printf("%s bought %s\n", this.name, product.getName());
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
