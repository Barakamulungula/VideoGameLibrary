package com.company;

public class Library{

    Game game1 = new Game("Fortnite");
    Game game2 = new Game("FIFA18");
    Game games[] = {game1, game2};


    // add a game to the library
    protected void addGame(){

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
        if(games.length > 0){
            System.out.println("List of games in your library");
            for(int x = 0; x < games.length; x++){
                System.out.println(x+1+". "+games[x].getTitle());
            }
        }else{
            System.out.println("There are no games currently in the library");

        }


    }

}
