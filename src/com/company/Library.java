package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Library{
    ArrayList<Game> games = new ArrayList<Game>();
    ArrayList checkedOutGames = new ArrayList();

    private static Scanner input = new Scanner(System.in);


    // add a game to the library
    protected void addGame(){
        System.out.println("Enter name of the game");
        if(input.hasNextLine()){
            games.add(new Game(input.nextLine()));
            System.out.println("You just added "+games.get(games.size()-1).getTitle());
        }else{
            System.out.println("Error invalid input");
        }
    }

    //remove a game from the library
    protected void removeGame(){

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
