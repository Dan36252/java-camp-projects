import java.util.*;

public class Hangman {
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chosenWord = randomWord();
        String guess = generateGuess(chosenWord, "", '-');
        String message = "Insert a letter.";
        int errors = 0;
        ArrayList<Character> guesses = new ArrayList<>();
        ArrayList<Character> wrongGuesses = new ArrayList<>();

        println(ANSI_YELLOW);
        println("--------------------");
        println("Welcome to Hangman!");
        println("--------------------");
        println(ANSI_RESET);
        println("Ready? (y/n)");

        String ready = sc.next();
        while (!ready.equals("y")) {
            println("Type \"y\" when you're ready.");
            ready = sc.next();
        }

        while(!guess.equals(chosenWord)) {
            draw(HangmanPics.pics[errors]);
            println("Word: "+guess+"      Incorrect letters: "+getWrongLetters(wrongGuesses));
            println(message);
            if (errors == 7) {
                return;
            }
            char letter = sc.next().charAt(0);
            if (!guessedBefore(guesses, letter)) {
                guesses.add(letter);
                if (matches(chosenWord, letter)) {
                    guess = generateGuess(chosenWord, guess, letter);
                    message = ANSI_GREEN+"Correct! Insert another letter."+ANSI_RESET;
                } else {
                    errors++;
                    wrongGuesses.add(letter);
                    if (errors == 7) {
                        message = ANSI_RED+"Oops! You failed... The word was \""+chosenWord+"\"."+ANSI_RESET;
                        continue;
                    }
                    message = ANSI_RED+"Wrong... You have " + (7 - errors) + " tries remaining!"+ANSI_RESET;
                }
            } else {
                message = "You already guessed this!";
            }
        }

        draw(HangmanPics.pics[errors]);
        println("Word: "+guess);
        println("You guessed it! You made "+errors+" mistakes.");
    }
    public static String randomWord() {
        String[] wordBank = WordBank.words;
        int randomIndex = (int)(Math.random()*wordBank.length);
        return wordBank[randomIndex];
    }
    public static void println(String str) {
        System.out.println(str);
    }
    public static void print(String str) {
        System.out.print(str);
    }
    public static void draw(int[][] grid) {
        String[] codes = new String[]{"  ", "# ", "O ", "|", " /", "\\", " "};
        int spaces = 10;
        int gridSize = 8;
        for (int i=0; i<spaces; i++)
            println("");
        print(ANSI_YELLOW);
        for (int i = 0; i<gridSize; i++) {
            for (int j = 0; j<gridSize; j++) {
                int code = grid[i][j];
                print(codes[code]);
            }
            println("");
        }
        print(ANSI_RESET);
    }
    public static String generateGuess(String word, String guess, char c) {
        if (guess.length() != word.length()) {
            guess = "";
            for (int i = 0; i<word.length(); i++)
                guess += "-";
        }
        for (int i = 0; i<word.length(); i++) {
            if (word.charAt(i)==c) {
                guess = guess.substring(0, i)+c+guess.substring(i+1);
            }
        }
        return guess;
    }
    public static boolean matches(String word, char c) {
        boolean found = false;
        for (int i = 0; i<word.length(); i++) {
            if (c == word.charAt(i)) {
                found = true;
            }
        }
        return found;
    }

    public static boolean guessedBefore(ArrayList<Character> guesses, char letter) {
        for (Character c: guesses) {
            if (letter == c) {
                return true;
            }
        }
        return false;
    }

    public static String getWrongLetters(ArrayList<Character> wrongGuesses) {
        String result = "";
        for (Character c: wrongGuesses)
            result += (c+", ");
        if (result.length() == 0)
            return "";
        result = result.substring(0, result.length()-2);
        return result;
    }
}
