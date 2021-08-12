
package machine;

public class Latte extends Coffee {




    public Latte(int amountOfWater, int amountOfMilk, int amountOfBeans, int price) {
        super(amountOfWater, amountOfMilk, amountOfBeans, price);
    }
    public Latte () {
        amountOfWater = 350;
        amountOfMilk = 75;
        amountOfBeans = 20;
        price = 7;
    }
}

