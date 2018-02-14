package com.company;

import java.util.Scanner;

public class StartLibrary {
    private Login login = new Login(this);
    private static Scanner input = new Scanner(System.in);

    protected void start(){
        System.out.println("Press 1 to login\nPress 2 to create an account\nPress 3 to exit");
        if(input.hasNextInt()){
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    login.loginAccount();
                    break;
                case 2:
                    login.createAccount();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pick a number between 1 and 3");
                    start();
                    break;

            }
        }
    }
}
