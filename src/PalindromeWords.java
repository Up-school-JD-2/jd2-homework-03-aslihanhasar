import java.util.Scanner;

public class PalindromeWords {
    public static void main(String[] args) {

        boolean exit = false;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a word : ");
            String word = scanner.nextLine();

            PalindromeWords words = new PalindromeWords();
            System.out.println("Reversed word: " + words.reverseWord(word));

            if (words.isPalindrome(word)) {
                System.out.println(word + " is a palindrome.");
            } else {
                System.out.println(word + " is not a palindrome.");
            }

            System.out.print("Please enter a number to check again or press 0 to exit.");
            int choise = scanner.nextInt();

            if (choise == 0) {
                exit = true;
            }

        } while (!exit);

    }

    public String reverseWord(String word) {
        String storageWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            storageWord += word.charAt(i);
        }
        return storageWord;
    }

    public boolean isPalindrome(String word) {
        String reversedWord = reverseWord(word);
        return word.equalsIgnoreCase(reversedWord);
    }

}
