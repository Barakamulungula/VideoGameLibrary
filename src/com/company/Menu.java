package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner input = new Scanner(System.in);
    private static Library library = new Library();

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
                    // Add a game
                    library.addGame();
                    startMenu();
                    break;
                case 2:
                    // Remove a game
                    library.removeGame();
                    startMenu();
                    break;
                case 3:
                    // View the game library
                    library.viewGameLibrary();
                    startMenu();
                    break;
                case 4:
                    // Check out a game
                    library.checkOut();
                    startMenu();
                    break;
                case 5:
                    library.checkIn();
                    startMenu();
                    // Check in game
                    break;
                case 6:
                    // View checked out games
                    library.viewCheckedOutGames();
                    startMenu();
                    break;
                case 7:
                    // Exit program
                    System.exit(0);
                    break;
                default:
                    // prompt the user to pick a correct number, loop back to menu
                    System.out.println("\nSelect a number from 1 - 7");
                    startMenu();
                    break;
            }

        }catch (InputMismatchException ime){
            input.nextLine();
            System.out.println("\nSelect a number from 1 - 7");
            startMenu();

        }

    }
}
