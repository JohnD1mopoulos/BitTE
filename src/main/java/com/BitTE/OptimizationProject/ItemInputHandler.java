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

/**
 * The {@code ItemInputHandler} class provides functionality for handling
 *  user input related to the addition of clothing items or accessories to
 *  a packing list. It prompts the user to choose between different types of
 *  items, genders (for clothing), and sizes and then allows the user to input
 *  those items into a list.
 *
 * This class includes methods for:
 * - Asking the user to select the type of item (clothing or accessory).
 * - Prompts to select specific items, such as clothing based on gender or
 *   accessories.
 * - Validating user input to ensure valid choices for item type, item choice,
 *   gender, and size.
 * - Collecting all necessary information to create and add an item to the
 *   packing list.
 */
final class ItemInputHandler {

    // Private constructor to prevent instantiation
    private ItemInputHandler() {
        throw new UnsupportedOperationException(
            "This is a utility class and it shouldn't be instantiated");
    }

    // Constants for identifying types of clothing and accessories in the application.

// Unisex clothing constants
/** Represents a T-shirt, applicable for all gender selections. */
private static final int T_SHIRT = 1;
/** Represents a Shirt, applicable for all gender selections. */
private static final int SHIRT = 2;
/** Represents a Hoodie, applicable for all gender selections. */
private static final int HOODIE = 3;
/** Represents Jeans, applicable for all gender selections. */
private static final int JEANS = 4;
/** Represents Sweatpants, applicable for all gender selections. */
private static final int SWEATPANTS = 5;
/** Represents Trousers, applicable for all gender selections. */
private static final int TROUSERS = 6;

// Men's specific clothing constants
/** Represents Boxers, specific to men's clothing options. */
private static final int BOXERS = 7;
/** Represents Shorts, specific to men's clothing options. */
private static final int SHORTS = 8;
/** Represents Sneakers, specific to men's clothing options. */
private static final int SNEAKERS = 9;
/** Represents Sandals, specific to men's clothing options. */
private static final int SANDALS = 10;
/** Represents Boots, specific to men's clothing options. */
private static final int BOOTS = 11;
/** Represents Socks, specific to men's clothing options. */
private static final int SOCKS = 12;

// Women's specific clothing constants
/** Represents a Skirt, specific to women's clothing options. */
private static final int SKIRT = 7;
/** Represents Panties, specific to women's clothing options. */
private static final int PANTIES = 8;
/** Represents Shorts, specific to women's clothing options. */
private static final int SHORTS_W = 9;
/** Represents Sneakers, specific to women's clothing options. */
private static final int SNEAKERS_W = 10;
/** Represents Sandals, specific to women's clothing options. */
private static final int SANDALS_W = 11;
/** Represents Boots, specific to women's clothing options. */
private static final int BOOTS_W = 12;
/** Represents Socks, specific to women's clothing options. */
private static final int SOCKS_W = 13;

// Accessory constants
/** Represents a Passport as an accessory item. */
private static final int PASSPORT = 1;
/** Represents a Laptop as an accessory item. */
private static final int LAPTOP = 2;
/** Represents a Book as an accessory item. */
private static final int BOOK = 3;

    /**
    * Prompts the user to choose between inputting a clothing item or
    * an accessory.
    *
    * This method ensures robust handling of user input, allowing only
    * valid integers (1 or 2) as choices.
    * If the input is invalid, the user is repeatedly prompted until a
    * valid input is provided.
    *
    * @param scanner a Scanner instance for capturing the user's input.
    * @return an integer representing the user's choice: 1 for Clothing, or
    *         2 for Accessory.
    */
    protected static int setTypeOfItem(final Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Invalid input."
                    + " Please give me 1 to input clothing or"
                    + " 2 to input an accessory.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input."
                                    + " Please give me a valid integer.");
                scanner.next();
            }
        }
    }

    /**
    * Prompts the user to pick what item he wants to input depending on
    * if it's a clothing item or an accessory.
    *
    * @param itemType representing the user's previous choice for the type
    *                 of item he will be inputting
    *                 (1 for clothing, or 2 for an accessory).
    * @param itemGender a char representing the user's choice of gender
    *             ('M' for male, 'F' for female).
    * @param scanner a Scanner instance for capturing the user's input.
    * @return the user's choice as a String.
    */
    protected static String setItemChoice(final int itemType,
                                        final char itemGender,
                                        final Scanner scanner) {

        int choiceOfItem = validateChoiceOfItem(itemType, itemGender, scanner);

        if (itemType == 1) { //Item is a piece of Clothing
            //Return the appropriate item if the selected gender is Male
            if (itemGender == 'M') {
                switch (choiceOfItem) {
                        case T_SHIRT : return "T-Shirt";
                        case SHIRT : return "Shirt";
                        case HOODIE : return "Hoodie";
                        case JEANS : return "Jeans";
                        case SWEATPANTS : return "Sweatpants";
                        case TROUSERS : return "Trousers";
                        case BOXERS : return "Boxers";
                        case SHORTS : return "Shorts";
                        case SNEAKERS : return "Sneakers";
                        case SANDALS : return "Sandals";
                        case BOOTS : return "Boots";
                        case SOCKS : return "Socks";
                        default: throw new IllegalArgumentException(
                                        "Invalid clothing choice");
                }
            } else { //Return the appropriate item if the selected gender is 'F'
                switch (choiceOfItem) {
                        case T_SHIRT : return "T-Shirt";
                        case SHIRT : return "Shirt";
                        case HOODIE : return "Hoodie";
                        case JEANS : return "Jeans";
                        case SWEATPANTS : return "Sweatpants";
                        case TROUSERS : return "Trousers";
                        case SKIRT : return "Skirt";
                        case PANTIES : return "Panties";
                        case SHORTS_W : return "Shorts";
                        case SNEAKERS_W : return "Sneakers";
                        case SANDALS_W : return "Sandals";
                        case BOOTS_W : return "Boots";
                        case SOCKS_W : return "Socks";
                        default: throw new IllegalArgumentException(
                                        "Invalid clothing choice");
                }
            }
        } else { //If item is an accessory
            switch (choiceOfItem) {
                case PASSPORT : return "Passport";
                case LAPTOP : return "Laptop";
                case BOOK : return "Book";
                default: throw new IllegalArgumentException(
                                    "Invalid accessory choice");
            }
        }
    }

    /**
     * Prompts the user to choose an item and validates their input.
     *
     * @param itemType an integer representing the type of item
     *                 (1 for clothing, 2 for accessory).
     * @param itemGender a char representing the gender for the item
     *                  ('M' for male, 'F' for female).
     * @param scanner a Scanner instance for capturing the user's input.
     * @return the user's validated choice as an integer
     */
    private static int validateChoiceOfItem(final int itemType,
                                            final char itemGender,
                                            final Scanner scanner) {
        /*Set accepted range of int choices depending of if the item is a piece
         of clothing or an accessory.*/
        int minRange = 1;
        int maxRange;
        if (itemType == 1) { //Item is a piece of clothing
            /*Account for the difference in choices depending on the previously
             selected gender of choice.*/
            if (itemGender == 'M') {
                maxRange = 12;
            } else {
                maxRange = 13;
            }
        } else { //Item is an accessory
            maxRange = 3;
        }
        System.out.println("Enter your choice:");
        while (true) {
            try {
                int choiceOfItem = scanner.nextInt();
                scanner.nextLine();
                //If item is not in the accepted range
                if (choiceOfItem < minRange || choiceOfItem > maxRange) {
                    System.out.println("Invalid input. Give me an integer "
                            + "ranging from " + minRange + " to "
                            + maxRange + ".");
                } else { //Item is in the accepted range
                    return choiceOfItem;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input."
                                    + " Please give me a valid integer");
                scanner.nextLine();
            }
        }
    }

    /**
    * Prompts the user to choose the gender of the clothing item.
    *
    * @param scanner a Scanner instance for capturing the user's input.
    * @return a char representing the user's choice of gender
    *         ('M' for male, 'F' for female).
    */
    protected static char setGender(final Scanner scanner) {
        System.out.println("Please enter your gender: "
                            + "(M for Male, F for Female)");
        char gender;
        while (true) { // Infinite loop until valid input is provided
            // Read the entire line and trim whitespace
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { // Check for empty input
                System.err.println("No input detected. "
                            + "Please enter 'M' for Male or 'F' for Female.");
                continue; // Prompt user again
            }
            if (input.length() == 1) { // Ensure input is a single character
                gender = input.toUpperCase().charAt(0);
                    if (gender == 'M' || gender == 'F') {
                        return gender;
                    }
            }
            System.err.println("Invalid input. Please enter"
                                + " 'M' for Male or 'F' for Female.");
            }
    }

    /**
    * Prompts the user to choose the item's size.
    *
    * @param scanner a Scanner instance for capturing the user's input.
    * @return a char representing the user's choice of size
    *         (S for Small, M for Medium, L for Large).
    */
    protected static char setSize(final Scanner scanner) {
        System.out.println("Please enter your desired size: "
                        + "(S for Small, M for Medium, L for Large)");

        while (true) { //Infinite loop until valid input is provided
            //Read the entire line and trim whitespace
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) { //Check for empty input
                System.err.println("No input detected."
                            + "Please enter 'S' for Small or 'M' for Medium"
                            + " or 'L' for Large.");
                continue; //Prompt user again
            }
            if (input.length() == 1) {
                char gender = input.toUpperCase().charAt(0);
                if (gender == 'S' || gender == 'M' || gender == 'L') {
                    return gender;
                } else {
                    System.err.println("Invalid input. Please enter"
                    + " 'S' for Small or 'M' for Medium or 'L' for Large.");
                }
            } else {
                System.err.println("Invalid input. Please enter one letter:"
                        + " 'S' for Small or 'M' for Medium or 'L' for Large.");
            }
        }
    }

    protected static int getNumberOfItems(final Scanner scanner) {
        System.out.println("How many items like this would you like to pack?"
                            + "(max 8)");
        while (true) { //Infinite loop until valid input is provided
            try {
                int numberOfitems = scanner.nextInt();
                if (numberOfitems > 0 && numberOfitems < 9) {
                    return numberOfitems;
                } else {
                    System.out.println("Invalid input. Give me an integer"
                                        + " ranging from 1 to 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Give me an integer"
                                        + "ranging from 1 to 8.");
                scanner.nextLine(); //Clear the next line
            }
        }
    }

    /**
     * Creates an object of type PackingItem for it to be included later on
     * in the list of items to be packed.
     *
     * @param type representing if the item is a piece of clothing (1)
     *                                                     or an accessory (2)
     * @param choiceOfItem representing the type of item (example -> jacket)
     * @param sex The gender-specific designation for the item ('M', 'F',
     *             or 'X' if not applicable).
     * @param size representing the selected size (Small||Medium||Large)
     * @param value representing the value given by the user as
     *              a preference measure
     * @return a PackingItem object representing the item to be packed
     */
    private static PackingItem createItem(final int type,
                                        final String choiceOfItem,
                                        final char sex,
                                        final char size,
                                        final int value) {
        if (type == 1) {
            return value == -1 ? new Clothing(choiceOfItem, size, sex)
                            : new Clothing(value, choiceOfItem, size, sex);
        } else if (type == 2) {
            return value == -1 ? new Extras(choiceOfItem, size, sex)
                            : new Extras(value, choiceOfItem, size, sex);
        } else {
            throw new IllegalArgumentException("Invalid type: "
                                                + choiceOfItem);
        }
    }

    /**
     * Inputs the user's choice of Item in ArrayList PackingItem according to
     * the user's previous choices of Item type, choice, sex and size.
     *
     * @param items representing the essential clothing and what not items
     * @param choiceOfItem representing the type of item (example -> jacket)
     * @param type representing if the item is a piece of
     *             clothing (1) or an accessory (2)
     * @param sex The gender-specific designation for the item ('M', 'F',
     *             or 'X' if not applicable).
     * @param size representing the selected size (Small||Medium||Large)
     * @param timesPacked representing how many times the item will be packed
     */
    protected static void inputItem(final ArrayList<PackingItem> items,
                                    final int type,
                                    final String choiceOfItem,
                                    final char sex,
                                    final char size,
                                    final int timesPacked) {

        //Insert a default value for value
        PackingItem pack = createItem(type, choiceOfItem, sex, size, 0);
        for (int i = 0; i < timesPacked; i++) {
            items.add(pack);
        }
    }

    /**
     * Overloaded version of inputItem that includes a value parameter.
     *
     * @param items The list of PackingItem objects to which items
     *               will be added.
     * @param type  The type of item (e.g., clothing or accessory).
     * @param choiceOfItem  The specific item choice (e.g., "jacket").
     * @param sex The gender-specific designation for the item ('M', 'F',
     *             or 'X' if not applicable).
     * @param size The size of the item ('S', 'M', 'L').
     * @param value An additional parameter for item-specific value
     *              (e.g., price, priority, etc.).
     * @param timesPacked The number of times to pack the item.
     */
    protected static void inputItem(final ArrayList<PackingItem> items,
                                    final int type,
                                    final String choiceOfItem,
                                    final char sex,
                                    final char size,
                                    final int value,
                                    final int timesPacked) {

        PackingItem pack = createItem(type, choiceOfItem, sex, size, value);
        for (int i = 0; i < timesPacked; i++) {
            items.add(pack);
        }
    }
}
