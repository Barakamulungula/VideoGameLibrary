package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    static Library library = new Library();

    //Menu to prompt user for library options
    public void startMenu(){
        System.out.println("" +
                "\nWelcome to the video game library (NUMBER OF GAMES: "+Library.games.size()+") what would you like to do? \n" +
                "1. Add a game to the library \n" +
                "2. Remove a game from the library \n" +
                "3. View what is currently in the library \n" +
                "4. Check a game out \n" +
                "5. Check a game in \n" +
                "6. View checked out games \n" +
                "7. Exit the program");

        try{
            switch (input.nextInt()){

                case 1:
                    library.addGame();
                    startMenu();
                    // Add a game

                    break;
                case 2:
                    // Remove a game
                    library.removeGame();
                    startMenu();
                    break;
                case 3:
                    library.viewGameLibrary();
                    startMenu();
                    // View the game library
                    break;
                case 4:
                    // Check out a game
                    break;
                case 5:
                    // Check in game
                    break;
                case 6:
                    // View checked out games
                    break;
                case 7:
                    // Exit program
                    System.exit(0);
                    break;
                default:
                    // prompt the user to pick a correct number, loop back to menu
                    break;
            }

        }catch (InputMismatchException ime){
            input.nextLine();
            System.out.println("\nSelect a number from 1 - 7");
            startMenu();

        }

    }
}
