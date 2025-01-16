/*
* Copyright 2025 BitTE Team
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class NonEssentialItems {
    //instance of the class
    private static NonEssentialItems instance;

    protected final ArrayList<PackingItem> nonEssentialItems = new ArrayList<>();//allowing polymorphism
    
    //private constructor
    private NonEssentialItems() {
    }
    
    //Singleton method allows access to NonEssentialItems' instance
    public static NonEssentialItems getInstance() {
        if (instance == null) {
            instance = new NonEssentialItems();
        }
        return instance;
    }
    
    public boolean fillNonEssentialItems(Scanner scanner) {
        System.out.println("----------------------------\n"
        +"INSERTION OF NONESSENTIAL ITEMS\n"
        +"----------------------------");
        boolean processRunning = true;
        while (processRunning) {
            MenuHandler.showNonEssentialItemsMenu();
            try {
                int userChoice = scanner.nextInt();
                if (userChoice == 1){
                    if (nonEssentialItems.isEmpty()) {
                        System.out.println("No nonessential items added.");
                        return false;
                    } else {
                        System.out.println("All nonesential items have been added!!!");
                        return true;
                    } 
                } else if (userChoice == 2) {
                    addNonEssentials(scanner);
                } else if (userChoice == 3) {
                    ItemDeletionHandler.deleteItem(nonEssentialItems, scanner);//Delete item(s)
                } else if (userChoice == 4) {
                    nonEssentialItems.clear();
                    return false;
                } else {
                    System.err.println("Invalid input. Please press 1, 2, 3 or 4.");
                }
                } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return false;//Unrechable code. Was put according to good practices
    }
    

    protected void addNonEssentials(Scanner scanner) {
        //Display MENU for choosing type of Item
        MenuHandler.chooseItemType();
        
        //Make choice 
        int inputType = ItemInputHandler.setTypeOfItem(scanner);

            /**If Item is a piece of Clothing set the prefered sex for the item, 
         then display MENU for the process of choosing an Item
            */
        char itemGender = 'X';
        if (inputType == 1){
            itemGender = ItemInputHandler.setGender(scanner);
            MenuHandler.showClothingMenu(itemGender);
        } else {
            MenuHandler.showExtrasMenu();
        }

        //Choose Item
        String itemOfChoice = ItemInputHandler.setItemChoice(inputType, 
                                                                itemGender, scanner);
                                                            
        //Choose the item's size
        char itemSize = ItemInputHandler.setSize(scanner);

        //Choose the item's value
        int value = setValue(scanner);

        //Input item 
        ItemInputHandler.inputItem(nonEssentialItems, inputType,
                                        itemOfChoice, itemGender, itemSize, value);
    }


    protected int setValue(Scanner scanner) {
        System.out.println("Please enter the importance of this item for your trip on a scale from 1 to 10:(1 for the least important items - 10 for the most important items)");
            while (true) {//Infinite loop until valid input is provided
            try {
                int input = scanner.nextInt();
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