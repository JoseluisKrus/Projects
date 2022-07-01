package RockPaperScissorsLizardSpock;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] moves = {"rock", "paper", "scissors", "lizard", "spock"};

            String playerMove;
            String computerMove = moves[new Random().nextInt(moves.length)];


            while (true) {
                System.out.println("Enter your move (rock, paper, scissors, lizard, spock):");
                playerMove = scanner.nextLine();
                if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors") || playerMove.equals("lizard") || playerMove.equals("spock")) {
                    break;
                }
                System.out.println("Please enter valid move!");
            }
            System.out.println("CPU played: " + computerMove);
            if(playerMove.equals(computerMove)){
                System.out.println("It's a draw!!");
            }else if (playerMove.equals("rock")){
                switch (computerMove) {
                    case "paper" -> System.out.println("Paper covers rock. You lose!");
                    case "scissors" -> System.out.println("Rock crushes scissors. You win!");
                    case "lizard" -> System.out.println("Rock crushes lizard. You win!");
                    case "spock" -> System.out.println("Spock vaporizes rock. You lose!");
                }
            }
            else if (playerMove.equals("paper")){
                switch (computerMove) {
                    case "rock" -> System.out.println("Paper covers rock. You win!");
                    case "scissors" -> System.out.println("Scissors cut paper. You lose!");
                    case "lizard" -> System.out.println("Lizard eats paper. You lose!");
                    case "spock" -> System.out.println("Paper disproves spock. You win!");
                }
            }
            else if (playerMove.equals("scissors")){
                switch (computerMove) {
                    case "rock" -> System.out.println("Rock crushes scissors. You lose!");
                    case "paper" -> System.out.println("Scissors cut paper. You win!");
                    case "lizard" -> System.out.println("Scissors decapitates lizard. You win!");
                    case "spock" -> System.out.println("Spock crushes scissors. You lose!");
                }
            }
            else if (playerMove.equals("lizard")){
                switch (computerMove) {
                    case "rock" -> System.out.println("Rock crushes lizard. You lose!");
                    case "paper" -> System.out.println("Lizard eats paper. You win!");
                    case "scissors" -> System.out.println("Scissors decapitates lizard. You lose!");
                    case "spock" -> System.out.println("Lizard poisons spock. You win!");
                }
            }
            else if (playerMove.equals("spock")){
                switch (computerMove) {
                    case "rock" -> System.out.println("Spock vaporizes rock. You win!");
                    case "paper" -> System.out.println("Paper disproves spock. You lose!");
                    case "scissors" -> System.out.println("Spock crushes scissors. You win!");
                    case "lizard" -> System.out.println("Lizard poisons spock. You lose!");
                }
            }

            System.out.println("Do you wanna play again ? (yes/no)");
            String playAgain = scanner.nextLine();
            if(!playAgain.equals("yes")){
                break;
            }
        }
    }
}
