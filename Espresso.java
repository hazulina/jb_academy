
package machine;

public class Espresso extends Coffee {




    public Espresso(int amountOfWater, int amountOfMilk, int amountOfBeans, int price) {
        super(amountOfWater, amountOfMilk, amountOfBeans, price);
    }
    public Espresso() {
        amountOfWater = 250;
        amountOfMilk = 0;
        amountOfBeans = 16;
        price = 4;
    }
}


