package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int menuSelection;
        MenuMaker loginMenu;
        Error err;
        Scanner sc = new Scanner(System.in);
        System.out.println("Faculty Management System");
        System.out.println("1. Login As Admin");
        System.out.println("2. Login As Employee");
        System.out.println("3. Exit");
        menuSelection = sc.nextInt();
        switch(menuSelection){
            case 1 :
                loginMenu = new MenuMaker();
                loginMenu.createLoginMenu("adminLogin");
                break;
            case 2 :
                loginMenu = new MenuMaker();
                loginMenu.createLoginMenu("empLogin");
                break;
            case 3 :
                System.exit(0);
                break;
            default :
                Error.displayError(403,null);
        }

    }
}
