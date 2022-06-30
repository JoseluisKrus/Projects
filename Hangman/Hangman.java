package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Hangman\\Dictionary.txt"));
        Scanner userInput = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);
        List<Character> playerGuess = new ArrayList<>();

        int wrongLetters = 0;
        printWord(word, playerGuess);
        while (true) {
            if(!getPlayerGuess(userInput, word, playerGuess)){
                wrongLetters++;
                hangman(wrongLetters);
                if(wrongLetters >= 6){
                    System.out.println("You lose!");
                    System.out.println("The word was: " + word);
                    break;
                }
            }
            if(printWord(word, playerGuess)){
                System.out.println("You won!");
                break;
            }
        }
    }

    private static void hangman(int wrongLetters) {
        System.out.println();
        System.out.println(" -------");
        System.out.println(" |     |");
        if(wrongLetters >= 1){
            System.out.println(" O");
        }
        if (wrongLetters >= 2){
            System.out.print("\\ ");
        }
        if (wrongLetters >= 3){
            System.out.println("/");
        }else {
            System.out.println();
        }
        if (wrongLetters >= 4){
            System.out.println(" |");
        }
        if (wrongLetters >= 5){
            System.out.print("/");
        }
        if(wrongLetters >=6){
            System.out.println(" \\");
        }else {
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static boolean getPlayerGuess(Scanner userInput, String word, List<Character> playerGuess) {
        System.out.println("Please enter a letter:");
        String letter = userInput.nextLine();
        playerGuess.add(letter.charAt(0));

        return word.contains(letter);
    }

    private static boolean printWord(String word, List<Character> playerGuess) {
        int wordsGuessed =0;
        for (int i = 0; i < word.length(); i++) {
            if(playerGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                wordsGuessed++;
            }else {
                System.out.print("_");
            }
        }
        System.out.println();

        return (word.length() == wordsGuessed);
    }
}
