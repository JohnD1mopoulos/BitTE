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

 import java.util.InputMismatchException;
 import java.util.Scanner;

 /**
  * This class represents a suitcase with specified maximum weight and volume limits.
  * It uses the Singleton pattern to ensure only one instance is created.
  */
 public class CreateSuitcase {

     /**
      * The single instance of CreateSuitcase.
      */
     private static CreateSuitcase instance;

     /**
      * The allowable interior's volume in cubic centimeters.
      */
     private final double maxVolume;

     /**
      * The allowable weight of the suitcase in grams.
      */
     private final double maxWeight;

     /**
      * Private constructor that initializes the suitcase's characteristics.
      * Prompts the user to input weight and dimensions.
      *
      * @param scanner A {@link Scanner} instance for reading user input.
      */
     private CreateSuitcase(Scanner scanner) {
         // Ask the customer about the weight limit of the suitcase
         System.out.println("Enter the desired weight"
                        +" of the suitcase (in grams): ");
         maxWeight = setSuitcaseCharacteristics(scanner);

         // Ask the dimensions of the suitcase in centimeters
         System.out.println("Enter the length of the suitcase (in cm): ");
         double length = setSuitcaseCharacteristics(scanner);
         System.out.println("Enter the width of the suitcase (in cm): ");
         double width = setSuitcaseCharacteristics(scanner);
         System.out.println("Enter the height of the suitcase (in cm): ");
         double height = setSuitcaseCharacteristics(scanner);
 
         // Calculate volume limit of the suitcase
         maxVolume = length * width * height;
     }

     /**
      * Returns the singleton instance of {@link CreateSuitcase}.
      * If no instance exists, it creates one.
      *
      * @param scanner A {@link Scanner} instance for reading user input.
      * @return The single instance of {@link CreateSuitcase}.
      */
     public static CreateSuitcase getInstance(Scanner scanner) {
         if (instance == null) {
             instance = new CreateSuitcase(scanner);
         }
         return instance;
     }

     /**
      * Resets the singleton instance of {@link CreateSuitcase}.
      */
     public static void resetInstance() {
         instance = null;
     }

     /**
      * Prompts the user to input a positive double value and validates the input.
      *
      * @param scanner A {@link Scanner} instance for reading user input.
      * @return A positive double value input by the user.
      */
     private double setSuitcaseCharacteristics(Scanner scanner) {
         while (true) {
             try {
                 double var = scanner.nextDouble();
                 if (var > 0) {
                     return var;
                 } else {
                     System.out.println("Invalid input. The value must"
                                    +" be positive. Try again.");
                 }
             } catch (InputMismatchException e) {
                 System.err.println("Invalid Input. Please"
                                +" provide a valid double.");
                 scanner.nextLine();
             }
         }
     }

     /**
      * Returns the maximum volume of the suitcase in cubic centimeters.
      *
      * @return The maximum volume of the suitcase.
      */
     protected double getMaxVolume() {
         return maxVolume;
     }

     /**
      * Returns the maximum weight of the suitcase in grams.
      *
      * @return The maximum weight of the suitcase.
      */
     protected double getMaxWeight() {
         return maxWeight;
     }
 }
