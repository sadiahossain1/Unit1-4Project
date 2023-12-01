public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Boba Shop!");
        System.out.println();
        String line = "------------------------------------------------";
        System.out.println(line);
        BobaShop boba1 = new BobaShop();
        System.out.println("Total Cost of Random Drink: $" + boba1.calculatePrice(5));
        System.out.println(line);
        BobaShop boba2 = new BobaShop("Taro");
        boba2.addToppings();
        System.out.println("Total Cost of Personal Drink: $" + boba2.calculatePrice(3));
        System.out.println(line);
        System.out.println();
        boba2.wordScramble("chicken", boba1.calculatePrice(5), boba2.calculatePrice(3));
    }
}