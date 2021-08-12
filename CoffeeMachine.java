package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int waterFilled = 400;
    private static int milkFilled = 540;
    private static int beansFilled = 120;
    private static int cups = 9;
    private static int balance = 550;
    public static int ingridientsToAdd = 0;
    public static MachineStatements statement = MachineStatements.START;


    public static void main(String[] args) {
        while (statement.equals(MachineStatements.START)) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            userInput();
            switch (statement) {
                case BUY: {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    userInput();
                    System.out.println();
                    statement = MachineStatements.START;
                    break;
                }
                case FILL: {
                    fillingTheMachine();
                    statement = MachineStatements.START;
                    break;
                }
                case TAKE: {
                    System.out.println("I gave you $" + getBalance());
                    setBalance(0);
                    System.out.println();
                    statement = MachineStatements.START;
                    break;
                }
                case REMAINING: {
                    printIngridients();
                    statement = MachineStatements.START;
                    break;
                }
                case EXIT: {
                    break;
                }

            }
        }
    }

    public static void userInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        if (userInput.equalsIgnoreCase("back")) {
            statement = MachineStatements.START;
            return;
        }
        if (userInput.equalsIgnoreCase("1") && statement.equals(MachineStatements.BUY)) {
            Coffee espresso = new Espresso();
            checkingResources(espresso);
            return;
        }
        if (userInput.equalsIgnoreCase("2") && statement.equals(MachineStatements.BUY)) {
            Coffee latte = new Latte();
            checkingResources(latte);
            return;
        }
        if (userInput.equalsIgnoreCase("3") && statement.equals(MachineStatements.BUY)) {
            Coffee cappuccino = new Cappuccino();
            checkingResources(cappuccino);
            return;
        }
        if (statement.equals(MachineStatements.FILL)) {
            ingridientsToAdd = Integer.parseInt(userInput);
            return;
        }
        statement = MachineStatements.valueOf(userInput.toUpperCase());
    }

    private static void fillingTheMachine() {
        System.out.println("Write how many ml of water you want to add:");
        userInput();
        setWaterFilled(getWaterFilled() + ingridientsToAdd);
        System.out.println("Write how many ml of milk you want to add:");
        userInput();
        setMilkFilled(getMilkFilled() + ingridientsToAdd);
        System.out.println("Write how many grams of coffee beans you want to add:");
        userInput();
        setBeansFilled(getBeansFilled() + ingridientsToAdd);
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        userInput();
        setCups(getCups() + ingridientsToAdd);
        System.out.println();
    }

    private static void checkingResources(Coffee espresso) {
        int isEnoughWater = getWaterFilled() - espresso.amountOfWater;
        int isEnoughMilk = getMilkFilled() - espresso.amountOfMilk;
        int isEnoughBeans = getBeansFilled() - espresso.amountOfBeans;
        int isEnoughCups = getCups() - 1;
        if (isEnoughWater < 0) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (isEnoughMilk < 0) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (isEnoughBeans < 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (isEnoughCups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        cooking(espresso);


    }

    private static void cooking(Coffee espresso) {
        setWaterFilled(getWaterFilled() - espresso.amountOfWater);
        setMilkFilled(getMilkFilled() - espresso.amountOfMilk);
        setBeansFilled(getBeansFilled() - espresso.amountOfBeans);
        setCups(getCups() - 1);
        setBalance(getBalance() + espresso.price);
    }

    public static void printIngridients() {
        System.out.println("The coffee machine has:");
        System.out.println(getWaterFilled() + " ml of water");
        System.out.println(getMilkFilled() + " ml of milk");
        System.out.println(getBeansFilled() + " g of coffee beans");
        System.out.println(getCups() + " disposable cups");
        System.out.println("$" + getBalance() + " of money");
        System.out.println();
    }

    public static int getWaterFilled() {
        return waterFilled;
    }

    public static void setWaterFilled(int waterFilled) {
        CoffeeMachine.waterFilled = waterFilled;
    }

    public static int getMilkFilled() {
        return milkFilled;
    }

    public static void setMilkFilled(int milkFilled) {
        CoffeeMachine.milkFilled = milkFilled;
    }

    public static int getBeansFilled() {
        return beansFilled;
    }

    public static void setBeansFilled(int beansFilled) {
        CoffeeMachine.beansFilled = beansFilled;
    }

    public static int getCups() {
        return cups;
    }

    public static void setCups(int cups) {
        CoffeeMachine.cups = cups;
    }

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        CoffeeMachine.balance = balance;
    }
}
