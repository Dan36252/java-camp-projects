import java.util.Scanner;

public class Exersize1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int nextNum = sc.nextInt();
            System.out.println("The number "+String.valueOf(nextNum)+" has "+String.valueOf(String.valueOf(nextNum).length())+" digits.");
        }
    }
}
