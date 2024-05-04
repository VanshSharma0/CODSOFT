import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;

        int totalAttempts = 0; 
        int roundsWon = 0; 

        do {
            int attempts = 1; 
            System.out.println("\nHello, Player 1");

            int gen = (int) (Math.random() * 101);

            System.out.println("Enter a number between 0 and 100:");
            int num = sc.nextInt();

            while (num != gen && attempts < 10) {
                if (num < gen) {
                    System.out.println("Your number is less than the generated number.");
                } else if (num > gen) {
                    System.out.println("Your number is greater than the generated number.");
                }
                attempts++;
                System.out.println("Enter a number:");
                num = sc.nextInt();
            }

            if (num == gen) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                roundsWon++;
            } else {
                System.out.println("You have exceeded the number of attempts. The number was: " + gen);
            }
            totalAttempts += attempts;
            System.out.println("\nDo you want to play again? (yes/no)");
            playAgain = sc.next();
            sc.nextLine(); 
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println(" !! Your score: !!");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
