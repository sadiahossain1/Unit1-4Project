import java.util.Scanner;
import
public class BobaShop {
    public void Boba() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want milk tea or fruit tea? ");
        String drinkChoice = scan.nextLine();
        if (drinkChoice.equals("milk")) {
            System.out.print("Do you want regular milk tea, taro milk tea, or brown sugar milk tea? ");
            String milkChoice = scan.nextLine();
        } else {
            System.out.print("Do you want mango fruit tea, peach fruit tea, or strawberry fruit tea? ");
            String fruitChoice = scan.nextLine();
        }
        System.out.print("What topping do you want? ");
        String topping = scan.nextLine();
    }

    public String randomDrink() {
        int random =
    }
}
