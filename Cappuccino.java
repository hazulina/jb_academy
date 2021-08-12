
package machine;

public class Cappuccino extends Coffee  {




    public Cappuccino(int amountOfWater, int amountOfMilk, int amountOfBeans, int price) {
        super(amountOfWater, amountOfMilk, amountOfBeans, price);
    }
    public Cappuccino () {
        amountOfWater = 200;
        amountOfMilk = 100;
        amountOfBeans = 12;
        price = 6;
    }
}

