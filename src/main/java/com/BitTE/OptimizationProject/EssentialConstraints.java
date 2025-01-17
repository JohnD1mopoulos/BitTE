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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * The {@code EssentialConstraints} class contains methods for managing and
 * checking the constraints of the optimization problem. It provides
 * functionality for calculating the sum of item attributes (weight and volume),
 * checking if the knapsack's constraints (weight and volume) are respected,
 * providing feedback to the user about constraint violations, and handling
 * the process of fixing constraint violations by allowing the user to delete
 *  items or terminate the process.
 */
 class EssentialConstraints {

    /**Constants for constraint states*/
    public static final int BOTH_CONSTRAINTS_RESPECTED = 1;
    public static final int ONLY_WEIGHT_CONSTRAINT_RESPECTED = 2;
    public static final int ONLY_VOLUME_CONSTRAINT_RESPECTED = 3;
    public static final int NO_CONSTRAINTS_RESPECTED = 4;
    
    /**
   * Calculates the sum of a specified attribute for a list of `PackingItem`
   *  objects.This method takes a list of items and a function that extracts
   *  a numeric attribute from each `PackingItem` and sums them up.
   * 
   * @param items a list of `PackingItem` objects to calculate the sum of 
   *              attributes from.
   * @param attributeGetter a function that extracts the numeric attribute from 
   *                        a `PackingItem`.
   *                        The function takes a `PackingItem` and returns a 
   *                        `Double` representing the attribute value to be 
   *                         summed.
   * @return the sum of the attribute values extracted from each `PackingItem`.
   */
    protected static double calculateSumOfAttributes(final ArrayList
                                                    <PackingItem> items,
                                                    final Function<PackingItem,
                                                    Double> attributeGetter) {
        double sum = 0;

        for (PackingItem item : items) {
            Double value = attributeGetter.apply(item);
            if (value != 0) {
                sum += attributeGetter.apply(item);
            }
        }
        return sum;
    }

    /**
    * Used to return correspoding values depending on the state of the 
    * knapsack's weight and volume and their respective constraints.
    *
    * @param items a PackingItem ArrayList to call calculateSumOfAttributes
    *              method on.
    * @param maxVolume representing the maximum volume that can be added to
    *                  the knapsack.
    * @param maxWeight representing the maximum weight that can be added to
    *                  the knapsack.
    * @return int value representing the current state of the constraints:
    *         1 - both weight and volume constraints are respected,
    *         2 - only weight constraint is respected,
    *         3 - only volume constraint is respected,
    *         4 - neither constraint is respected.
    */
    protected static int checkConstraints(final ArrayList<PackingItem> items, 
                                         final double maxWeight,
                                         final double maxVolume) {
        double totalWeight = calculateSumOfAttributes(items, t -> {
            try {
                return t.getWeight();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return null;
        });
        double totalVolume = calculateSumOfAttributes(items, t -> {
            try {
                return t.getVolume();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return null;
        });

        //Return appropriate value for each scenario 
        if (totalWeight <= maxWeight && totalVolume <= maxVolume) {
            return BOTH_CONSTRAINTS_RESPECTED;
        }else if (totalWeight <= maxWeight) {
            return ONLY_WEIGHT_CONSTRAINT_RESPECTED;
        }else if (totalVolume <= maxVolume) {
            return ONLY_VOLUME_CONSTRAINT_RESPECTED;
        }else {
            return NO_CONSTRAINTS_RESPECTED;
        }
    }

    /**
    * Provides the user with feedback based on the constraints
    * 
    * @param items a PackingItem ArrayList representing the list of chosen 
    *              essential items.
    * @param stateOfConstraints which describes the current state of the
    *                           constraints
    *                             1-if both constraints are respected,
    *                             2-if only the weight constraint is respected,
    *                             3-if only the volume constraint is respected,
    *                             4-if no constraints are respected.
    * @param maxVolume representing the maximum volume that can be added to 
    *                  the knapsack.
    * @param maxWeight representing the maximum weight that can be added to the
    *                  knapsack.
    */
    protected static void showConstraintFeedback(ArrayList<PackingItem> items,
                                        int stateOfConstraints,
                                        final double maxWeight,
                                        final double maxVolume) {
        
        double remainingWeight = maxWeight - calculateSumOfAttributes
        (items, t -> {
            try {
                return t.getWeight();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return null;
        });
        double remainingVolume = maxVolume - calculateSumOfAttributes
        (items, t -> {
            try {
                return t.getVolume();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return null;
        });

        switch (stateOfConstraints) {
            case BOTH_CONSTRAINTS_RESPECTED : System.out.printf(
                                    "You have %.2f gr and %.2f cm3"
                                    +" available.%n\n",
                                    remainingWeight, remainingVolume);
                                    break;
            case ONLY_WEIGHT_CONSTRAINT_RESPECTED : System.out.printf(
                                    "You have %.2f gr left but exceeded "
                                    +"volume by %.2f cm3.%n\n"
                                    +"You have to delete items to continue"
                                    +" the process\n", 
                                    remainingWeight, -remainingVolume);
                                    break;
            case ONLY_VOLUME_CONSTRAINT_RESPECTED : System.out.printf(
                                    "You exceeded the weight limit by %.2f gr"
                                    +" but have %.2f cm3 left.%n\n"
                                    +"You have to delete items to continue"
                                    +" the process\n", 
                                    -remainingWeight, remainingVolume);
                                    break;
            case NO_CONSTRAINTS_RESPECTED : System.out.printf(
                                    "You exceeded the weight limit by %.2f gr"
                                    +" and volume limit by %.2f cm3.%n"
                                    +"You have to delete items to continue" 
                                    +" the process\n", 
                                    -remainingWeight, -remainingVolume);
                                    break;
        }
    }

    /**
    * Gets called if the constraints are not being respected
    * Prompts the user between terminating the procedure and deleting as many items as he wishes or are needed
    * to continue the process of adding essential items to the knapsack.
    *
    * @param items a PackingItem ArrayList representing the list of chosen essential items.
    * @param scanner a Scanner instance for capturing the user's input.
    * @param maxVolume representing the maximum volume that can be added to the knapsack.
    * @param maxWeight representing the maximum weight that can be added to the knapsack.
    * @return false if the process is terminated, true if items were deleted successfully.
    */
    protected static boolean fixConstraints(ArrayList<PackingItem> items,
                                        Scanner scanner,
                                        final double maxWeight,
                                        final double maxVolume) {
    
        boolean validChoice = false;
        while (!validChoice) {
        try {
            System.out.println("Press 1 to terminate process.\n"
                                +"Press 2 to remove item(s)\n"
                                +"Enter your choice:");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
        
            if (userChoice == 1) {
                items.clear();//Delete everything that was chosen
                return false;//Terminate process
            } else if (userChoice == 2) {
                ItemDeletionHandler.deleteItem(items, scanner);

                //Recheck constraints
                int constraintsRespected = checkConstraints(items, maxWeight,
                                                            maxVolume);
                if (constraintsRespected == BOTH_CONSTRAINTS_RESPECTED) {
                    validChoice = true;//Exit loop
                } else {//Constraints aren't respected
                    showConstraintFeedback(items, constraintsRespected,
                                                    maxWeight,
                                                    maxVolume);
                }//Restart the loop after the above message
            } else {
                System.err.println("Invalid choice.");
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
        }
    return true;//items where deleted successfully
    }       
}
