package com.BitTE.OptimizationProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateSuitcase {

    //instance of CreateSuitcase
    private static CreateSuitcase instance;

    //variables represent the allowable weigth in kilos and the volume in cubic meters of the suitcase
    private final double maxVolume;
    private final double maxWeight;
    

    //private constructor 
    private CreateSuitcase(Scanner scanner) {
        //Ask the customer about the weight limit of the suitcase
        System.out.println("Enter the desired weight of the suitcase (in grams): ");
        maxWeight = setSuitcaseCharacteristics(scanner);
        //Ask the dimencions of the suitcase in centemetres
        System.out.println("Enter the length of the suitcase (in cm): ");
            double length = setSuitcaseCharacteristics(scanner);
        System.out.println("Enter the width of the suitcase (in cm): ");
            double width = setSuitcaseCharacteristics(scanner);
        System.out.println("Enter the height of the suitcase (in cm): ");
            double height = setSuitcaseCharacteristics(scanner);
        //Calculating volume limit of the suitcase
        maxVolume = length * width * height;
    }

    //Singleton method allows access to CreateSuitcase's instance
    public static CreateSuitcase getInstance(Scanner scanner) {
        if (instance == null) {
            instance = new CreateSuitcase(scanner);
        }
        return instance;
    }

    //Singleton method for reset of instance
    public static void resetInstance() {
        instance = null;
    }

    //Method that sets the suitcase's characteristics
    private double setSuitcaseCharacteristics(Scanner scanner) {
        while (true) {
            try {
                double var = scanner.nextDouble();
                if (var > 0) {
                    return var;
                } else {
                    System.out.println("Invalid input. The value must be positive. Try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input. Please give me a valid double.");
                scanner.nextLine();
            }
        }
    }

    protected double getMaxVolume() {
        return maxVolume;
    }

    protected double getMaxWeight() {
        return maxWeight;
    }
}
