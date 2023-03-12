import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    static final int LIMIT_0F_ATTEMPT = 5;

    public static void main(String[] args) {
        int attempt = 0;
        int numberSecret = getRandomNumber();
        System.out.println(numberSecret);
        int[] guessArray = new int[LIMIT_0F_ATTEMPT];

        while (attempt < GuessNumber.LIMIT_0F_ATTEMPT) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your number guess: ");
            int numberGuess = scanner.nextInt();
            guessArray[attempt] = numberGuess;

            if (isNumberValid(numberGuess)) {
                if (isGuessCorrect(numberGuess, numberSecret, attempt)) {
                    System.out.println("You won the game! ");
                    break;
                } else {
                    System.out.println("Your remaining attempt: "
                            + ((GuessNumber.LIMIT_0F_ATTEMPT) - (++attempt)));
                }
            } else {
                System.out.println("Please enter a valid number: ");
            }
            System.out.println();
        }

        if (isLostGame(attempt)) {
            System.out.println("You lost the game! ");
        }

        System.out.println();
        printScore(guessArray, numberSecret);
    }

    static int getRandomNumber() {
        return (int) (Math.random() * 100);
    }

    static boolean isNumberValid(int numberGuess) {
        return numberGuess >= 0 && numberGuess < 100;
    }

    static boolean isGuessCorrect(int numberGuess, int numberSecret, int attempt) {
        if (numberGuess == numberSecret) {
            System.out.println("Your guess is correct ! ");
            return true;
        } else {
            if (attempt != (GuessNumber.LIMIT_0F_ATTEMPT - 1)) {
                if (numberGuess > numberSecret) {
                    System.out.println("Too high, try again !");
                } else {
                    System.out.println("Too low, try again !");
                }
            }
        }
        return false;
    }

    static boolean isLostGame(int attempt) {
        return attempt >= GuessNumber.LIMIT_0F_ATTEMPT;
    }

    static void printScore(int[] guessArray, int numberSecret) {
        System.out.println("****** Score Table ******");
        System.out.println("Your guess numbers: " + Arrays.toString(guessArray));
        System.out.println("The secret number: " + numberSecret);
    }
}