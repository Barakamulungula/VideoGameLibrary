package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Scanner;

public class Library{
    //saves games that the user enter
    protected static List<Game> games = new ArrayList<Game>();
    //holds games the user checks out
    protected static List<Game> checkedOut = new ArrayList<Game>();
    private static Scanner input = new Scanner(System.in);
    //date format for due date
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");


    // add a game to the library
    protected void addGame(){
        System.out.println("Enter title of the game you would like to add");
        //Checks if user enters valid input
        if(input.hasNextLine()){
            String g = input.nextLine();
            if(!(g.length() > 0)){
                System.out.println("Error: Enter input");
                addGame();
            }else{
                //add user game to the games LIST
                games.add(new Game(g));
                System.out.println("You just added "+games.get(games.size()-1).getTitle()+" to your game library.");
            }
        }else{
            System.out.println("Error invalid input");
        }
    }

    //remove a game from the library
    protected void removeGame(){
        //list current game in the library
        viewGameLibrary();

        //checks if there is games in the library
        if(!Library.games.isEmpty()){
            System.out.println("Enter the number of the game you would like to remove");
            if(input.hasNextInt()){
                int num = input.nextInt();
                //checks if user input is in range to avoid out of bound exception
                if(num < 1 || num > games.size()){
                    System.out.println("ERROR: enter the number for game you want to remove");
                    removeGame();
                }else{
                    System.out.println("You just removed " + games.get(num-1).getTitle() + " from you game library");
                    games.remove(num-1);
                }
            }else{
                System.out.println("Enter number of the game you wish to remove");
                removeGame();
            }
        }
    }

    //checkout a game from the library
    protected void checkOut(){
        viewGameLibrary();
        //creates instance for the calender class (class is abstract)
        Calendar calendar = Calendar.getInstance();
        int num;
        if(!games.isEmpty()) {
            System.out.println("Enter the number for the game you wish to checkout");
            if(input.hasNextInt()) {
                try {
                    num = input.nextInt();
                    if (num > 0 && num <= games.size()) {
                        //adds seven days to set due date
                        calendar.add(calendar.DAY_OF_YEAR, 7);
                        //sets the dues date
                        games.get(num - 1).setDueDate(dateFormat.format(calendar.getTime()));
                        System.out.println("You just checked out " + games.get(num - 1).getTitle() +"(Due date: " + games.get(num - 1).getDueDate() + ")");
                        checkedOut.add(games.get(num - 1));
                        games.remove(num - 1);
                    }
                } catch (Exception e) {
                    System.out.println("(Catch) Enter the number for the game you wish to checkout");
                    checkOut();
                }
            } else{
                System.out.println("Please enter input (number for the game you wish to checkout)");
                checkOut();
            }
        }
    }

    //check in a game into the l
    // Library
    protected void checkIn(){
        Calendar calendar = Calendar.getInstance();
        viewCheckedOutGames();
        if(!checkedOut.isEmpty()){
            System.out.println("Enter the number for game you wish to check in");
            if(input.hasNextInt()){
                int num = input.nextInt();
                if(num > 0 && num <= checkedOut.size()){
                    System.out.println("You checked in "+checkedOut.get(num-1).getTitle()+"due date: "+checkedOut.get(num-1).getDueDate()+")");
                    //adds game to be checked out into the game library
                    games.add(checkedOut.get(num-1));
                    //removes the game from the library
                    checkedOut.remove(num-1);

                }else {
                    System.out.println("Enter the number for the game you want to check out");

                }
            }else{
                System.out.println("Enter the number for the game you want to check out");
            }
        }
    }

    //view list of checked out games in the library
    protected void viewCheckedOutGames(){
        if(!checkedOut.isEmpty()){
            int n = 1;
            for (Game x:
                 checkedOut) {
                System.out.println(n+". "+x.getTitle());
                n++;
            }

        }else{
            System.out.println("No games are checked out");
        }
    }

    //view games in the game library
    protected void viewGameLibrary(){

        if(!games.isEmpty()){
            System.out.println("List of games in your library");
            for(int x = 0; x < games.size(); x++){
                System.out.println(x+1+". "+games.get(x).getTitle());
            }
        }else{
            System.out.println("There are no games currently in the library");

        }
    }

}
