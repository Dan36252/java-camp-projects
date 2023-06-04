import java.util.Scanner;

public class NumGuesser {
    static void print(String str) {
        System.out.println(str);
    }
    static void printn(int n) {
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        print("");
        print("------------------------------------------------------");
        print("Come up with a number between 0 and 100.");
        print("Reply with (yes), (higher), or (lower) accordingly.");
        print("------------------------------------------------------");
        print("");
        print("Ready?");
        while (!((sc.nextLine()).equals("yes"))) {
            print("Type (yes) when you're ready.");
        }
        print("Okay, my guess is...");
        int guess = 50;
        int high = 100;
        int low = 0;
        int prev;
        int score = 1;
        printn(guess);
        String reply = sc.nextLine();
        while (!(reply.equals("yes"))) {
            if (reply.equals("higher")) {
                low = guess;
                prev = 1;
            } else if (reply.equals("lower")) {
                high = guess;
                prev = 0;
            } else {
                print("Answer with (higher) or (lower).");
                reply = sc.nextLine();
                continue;
            }
            score++;
            if (!((high-low)/2 == 0))
                prev = 0;
            guess = (high-low)/2+low+prev;
            print(guess+"?");
            reply = sc.nextLine();
        }
        print("Yes! I guessed the correct number "+guess+" in "+score+" guesses.");
    }
}
