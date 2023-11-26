import java.util.Scanner;

public class BobaShop {

    // instance variables
    private String drink;
    private String topping;
    private boolean randomBoba;
    private double price1;
    private double price2;

    // constructor
    public BobaShop(String drink) {
        this.drink = drink;
    }

    // overloaded constructor
    public BobaShop() {
        // Randomly select a drink and toppings
        drink = "";
        topping = "";
        int randomDrink = (int) (Math.random() * 4);
        if (randomDrink == 1) {
            drink = "Milk Tea";
        } else if (randomDrink == 2) {
            drink = "Taro Slush";
        } else if (randomDrink == 3) {
            drink = "Green Tea";
        } else {
            drink = "Thai Tea";
        }
        int randomTopping = (int) (Math.random() * 3);
        if (randomTopping == 1) {
            topping = "Pearls";
        } else if (randomTopping == 2) {
            topping = "Jelly";
        } else {
            topping = "Pudding";
        }
        randomBoba = true;
        System.out.println("Your Randomized Boba Order: " + drink + " with " + topping);
        }

    // void method with no parameters which allows user to add toppings
    public void addToppings() {
        Scanner scan = new Scanner(System.in);
        System.out.print("The drink you want is " + drink +"\nWhat toppings do you want to add to your personalized order? (If no toppings, type N/A): ");
        topping = scan.nextLine();
    }

    public double calculatePrice(int numOfDrinks) {
        double drinkPrice = 5.50;
        double toppingPrice = 0.50;
        if (randomBoba) {
            price1 = (drinkPrice + toppingPrice) * numOfDrinks;
            return price1;
        } else {
            if (!(topping.equals("N/A"))) {
                price2 = drinkPrice + toppingPrice;
            } else {
                price2 = drinkPrice;
            }
        }
        price2 = price2 * numOfDrinks;
        return price2;
    }

    public void wordScramble(String originalWord) {
        String word = originalWord;
        String scrambled = "";
        for (int i = word.length(); i > 0; i--) {
            int randomIndex = (int) (Math.random() * i);
            char randomChar = word.charAt(randomIndex);
            scrambled += randomChar;
            String before = word.substring(0, randomIndex);
            String after;
            if (randomIndex < i - 1) {
                after = word.substring(randomIndex + 1, i);
            } else {
                after = "";
            }
            word = before + after;
        }
        System.out.println("Scrambled Word: " + scrambled);

        Scanner scan = new Scanner(System.in);
        System.out.print("Your Guess: ");
        String guess = scan.nextLine();
        int count = 1;
        while ((!(guess.equals(originalWord))) && (count <= 4)) {
            System.out.println("Guesses Left: " + (5 - count));
            System.out.print("That's not it! Guess again: ");
            guess = scan.nextLine();
            count++;
        }
        if ((guess.equals(originalWord)) && (count <= 5)) {
            System.out.println("You won a 50% discount!");
            System.out.println("The new price of your random order is: $" + price1/2.0);
            System.out.println("The new price of your personal order is: $" + price2/2.0);
        } else {
            System.out.println("You lost :(");
        }
    }
}
