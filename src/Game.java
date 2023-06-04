import java.util.Scanner;

public class Game {
    static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print("----- Welcome to THE GAME. -----");
        print("Insert your Username:");
        String username = sc.nextLine();
        print("Hello, "+username+".");
    }
}
