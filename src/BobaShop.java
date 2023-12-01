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
        // Randomly select a drink and toppings and stores it in the Strings
        drink = "";
        topping = "";
        int randomDrink = (int) (Math.random() * 4) + 1;
        if (randomDrink == 1) {
            drink = "Milk Tea";
        } else if (randomDrink == 2) {
            drink = "Taro Slush";
        } else if (randomDrink == 3) {
            drink = "Green Tea";
        } else {
            drink = "Thai Tea";
        }
        int randomTopping = (int) (Math.random() * 3) + 1;
        if (randomTopping == 1) {
            topping = "Pearls";
        } else if (randomTopping == 2) {
            topping = "Jelly";
        } else {
            topping = "Pudding";
        }
        randomBoba = true;
        System.out.println(toString());
        }

    // void method with no parameters which allows user to add toppings if they want
    public void addToppings() {
        Scanner scan = new Scanner(System.in);
        System.out.print("The personal drink you want is " + drink +"\nWhat toppings do you want to add to your personalized order? (If no toppings, type N/A): ");
        topping = scan.nextLine();
    }

    // method which calculates the total price of the boba order based on how many drinks the user wants
    // has one parameter which represents the number of drinks the user wants to order
    public double calculatePrice(int numOfDrinks) {
        double drinkPrice = 5.50;
        double toppingPrice = 0.50;
        if (randomBoba) {
            price1 = (drinkPrice + toppingPrice) * numOfDrinks;
            return price1;
        } else {
            if (!(topping.equals("N/A"))) {
                price2 = (drinkPrice + toppingPrice) * numOfDrinks;
                return price2;
            } else {
                price2 = drinkPrice * numOfDrinks;
                return price2;
            }
        }
    }

    // this void method has three parameters: a String for the word that will be scrambled,
    // and the prices of the random order and personalized order
    // this method scrambles the word then asks the user if they want to play the game. If the
    // user says yes, the user gets 5 tries to guess the word and if they win they get a discount
    // and the method will print the discounted prices
    public void wordScramble(String originalWord, double price1, double price2) {
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

        Scanner scan = new Scanner (System.in);
        System.out.print("Do you want to play a game of Word Scramble to win a 50% discount? ");
        String choice = scan.nextLine();
        if (choice.equals("yes")) {
            System.out.println("Scrambled Word: " + scrambled);
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
                System.out.println("You won a 50% discount!" +
                        "\nThe new price of your random order is: $" + price1/2.0 +
                        "\nThe new price of your personal order is: $" + price2/2.0);
            } else {
                System.out.println("You lost :(");
            }
        } else {
            System.out.println("Okay, have a good day.");
        }
    }

    // method for my random order constructor
    public String toString() {
        String returnString = "Your Randomized Boba Order: " + drink + " with " + topping;
        return returnString;
    }
}
