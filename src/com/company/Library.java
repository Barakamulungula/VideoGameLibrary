package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Library{
    static ArrayList<Game> games = new ArrayList<Game>();
    static ArrayList checkedOutGames = new ArrayList();

    private static Scanner input = new Scanner(System.in);


    // add a game to the library
    protected void addGame(){
        System.out.println("Enter name of the game");
        if(input.hasNextLine()){
            String g = input.nextLine();
            if(!(g.length() > 0)){
                System.out.println("Enter input");
                addGame();
            }else{
                games.add(new Game(g));
                System.out.println("You just added "+games.get(games.size()-1).getTitle());
            }

        }else{
            System.out.println("Error invalid input");
        }
    }

    //remove a game from the library
    protected void removeGame(){
        String removedGame;
        viewGameLibrary();
        if(Library.games.size() > 0){
            System.out.println("Enter the number of the game you would like to remove");
            if(input.hasNextInt()){
                int num = input.nextInt();
                if(num < 1 || num > games.size()){
                    System.out.println("ERROR: enter number for game you want to remove");
                    removeGame();
                }else{
                    removedGame = games.get(num-1).getTitle();
                    games.remove(num-1);
                    System.out.println("You just removed "+removedGame);
                }
            }else{
                System.out.println("Error: Enter number of the game you wish to remove");
            }
        }
    }

    //checkout a game from the library
    protected void checkOut(){

    }

    //check in a game into the library
    protected void checkIn(){

    }

    //view list of checked out games in the library
    protected void viewCheckedOutGames(){

    }

    //view games in the game library
    protected void viewGameLibrary(){
        if(games.size() > 0){
            System.out.println("List of games in your library");
            for(int x = 0; x < games.size(); x++){
                System.out.println(x+1+". "+games.get(x).getTitle());
            }
        }else{
            System.out.println("There are no games currently in the library");

        }
    }

}
