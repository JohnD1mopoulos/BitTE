package main.java.com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Nonessentials {
    protected static final ArrayList<PackingItem> nonEssentialItems = new ArrayList<>();//allowing polymorphism

    private static boolean fillNonessentials() {
        System.out.println("Dear user, please choose the items that you would like to carry in your suitcase: ");
        Scanner scanner = new Scanner(System.in);
        boolean addingItems = true;
        while (addingItems){
            //Display MENU for choosing type of Item
            System.out.println("Press 1 to add Clothing\n"
                                +"Press 2 to add Accessory");
            //Make choice 
            int inputType = MenuHandler.setTypeOfItem;
             /**If Item is a piece of Clothing set the prefered sex for the item, 
             then display MENU for the process of choosing an Item
             */
            char itemGender = 'X';
            if (inputType == 1){
                itemGender = MenuHandler.setGender(scanner);
                MenuHandler.clothingMenu(itemGender);
            } else {
                MenuHandler.extrasMenu();
            }
            //Choose Item
            int itemOfChoice = MenuHandler.setItemChoice(inputType, itemGender);
            //Choose the item's size
            char itemSize = MenuHandler.setSize(scanner);
            //Choose the item's value
            int value = MenuHandler.setValue;
            //Input item 
            MenuHandler.inputNonEssentialItem(nonEssentialItems, scanner);
            System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to add another item");
            boolean validChoice;
            while (!validChoice){
                try {
                    int userChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (userChoice == 1){
                        System.out.println("All nonesential items have been added!!!");
                        validChoice = true;
                        return true; 
                    } else if (userChoice == 2) {
                        validChoice = true;//Continue adding items
                    } else {
                        System.err.println("INvalid choice. Please press 1 oe 2.");
                    }
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
        return false;//Unrechable code. Was put according to good practices
    }

    // to transfer in ParameterControl
protected static void inputNonEssentialItem(ArrayList<PackingItem> items, int type, int choice, char sex, char size, int value) {
    if (type = 1) {

    }
}

 
 protected static int setValue(Scanner scanner) {
    System.out.println("Please enter the importance of thiw item for your trip on a scale from 1 to 10:(1 for the least important items - 10 for the most important items)");
    while (true) {//Infinite loop until valid input is provided
        try {
            int input = scanner.nextInt();
            scanner.nextLine();//Clear the newline character
            if (input < 1 || input > 10) {//If value is not in the accepted range
                System.out.println("Invalid input. Give me an integer ranging from 1 to 10.");
            } else {//Item is in the accepted range
                return input;
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please select a valid integer");
            scanner.nextLine();
        }
    }
}
}
