import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Boba Shop!");
        System.out.println();
        String line = "------------------------------------------------";
        System.out.println(line);
        BobaShop boba1 = new BobaShop();
        Scanner scan = new Scanner(System.in);
        System.out.print("How many drinks do you want for your random order? ");
        int randomNumOfDrinks = scan.nextInt();
        scan.nextLine();
        System.out.println("Total Cost of Random Drink: $" + boba1.calculatePrice(randomNumOfDrinks));
        System.out.println(line);
        System.out.print("What drink do you want for your personal order? ");
        String drinkName = scan.nextLine();
        BobaShop boba2 = new BobaShop(drinkName);
        boba2.addToppings();
        System.out.print("How many drinks do you want for your personal order? ");
        int personalNumOfDrinks = scan.nextInt();
        System.out.println("Total Cost of Personal Drink: $" + boba2.calculatePrice(personalNumOfDrinks));
        System.out.println(line);
        System.out.println();
        boba2.wordScramble("reassurance", boba1.calculatePrice(randomNumOfDrinks), boba2.calculatePrice(personalNumOfDrinks));
    }
}