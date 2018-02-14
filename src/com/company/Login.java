package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    private static List<User> users = new ArrayList<User>();
    private String value;
    private Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    public final StartLibrary startlibrary;
    public Login(StartLibrary startlibrary) {
        this.startlibrary = startlibrary;
    }

    protected void loginAccount(){
        users.add(new User("root", "root","default"));
        System.out.println("Enter a username");
        if(input.hasNextLine()){
            lengthCheck(input.nextLine());
            String username = value;
            System.out.println("Hey, "+username+" enter a password for your account");
            if(input.hasNextLine()) {
                lengthCheck(input.nextLine());
                String password = value;
                for(User user: users){
                    if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                        System.out.println("You have successfully logged in "+user.getFullName());
                        menu.startMenu();
                    }else{
                        System.out.println("Incorrect Info. Try again");
                        startlibrary.start();
                    }
                }
            }else {
                loginAccount();
            }
        }
    }

    protected void createAccount(){
        System.out.println("Enter a username");
        if(input.hasNextLine()){
            lengthCheck(input.nextLine());
            String username = value;
            System.out.println("Hey, "+username+" enter a password for your account");
            if(input.hasNextLine()){
                lengthCheck(input.nextLine());
                String password = value;
                System.out.println("Enter a name for your account");
                if(input.hasNextLine()){
                    lengthCheck(input.nextLine());
                    String fullName = value;
                    users.add(new User(username,password,fullName));
                    System.out.println(fullName+" welcome to the game library \nusername: "+username+"\npassword: "+password);
                    loginAccount();

                }else{
                    createAccount();
                }
            }else{
                createAccount();
            }
        }else{
            createAccount();
        }
    }

    protected void lengthCheck(String userInput){
        if(userInput.length() < 1){
            System.out.println("Enter valid input (Renter info)");
            createAccount();
        }
        else{
            value = userInput;
        }
    }



}
