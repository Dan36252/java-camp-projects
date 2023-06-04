import java.util.Scanner;

public class D2Exercise1 {
    static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rand = RandomNum.Generate(0, 99);
        print("Guess a number.");
        int guess = sc.nextInt();
        int score = 1;
        while (guess != rand) {
            if (guess > rand) {
                print("Too high.");
            } else if (guess < rand) {
                print("Too low.");
            }
            guess = sc.nextInt();
            score++;
        }
        print("Correct! The number was "+rand+". You got it in "+score+" guesses!");
    }
}
