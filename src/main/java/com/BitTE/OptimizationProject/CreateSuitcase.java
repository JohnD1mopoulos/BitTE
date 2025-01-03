package com.BitTE.OptimizationProject;

import java.util.Scanner;

public class CreateSuitcase {

    //instance of CreateSuitcase
    private static CreateSuitcase instance;

    //variables represent the allowable weigth in kilos and the volume in cubic meters of the suitcase
    private double maxVolume;
    private double maxWeight;
    

    //private constructor 
    private CreateSuitcase() {
    }

    //Singleton method allows access to CreateSuitcase's instance
    public static CreateSuitcase getInstance() {
        if (instance == null) {
            instance = new CreateSuitcase();
        }
        return instance;
    }

    //Method which asks the customer about the weight limit of the suitcase
    private void setSuitcaseWeight(Scanner scanner) {
        System.out.print("Enter the desired weight of the suitcase (in kilograms): ");
        maxWeight = scanner.nextDouble();
        scanner.nextLine();
    }

    //Method which asks the customer about the dimensions of the suitcase and calculates the volume
    private void setSuitcaseVolume(Scanner scanner) {
        System.out.print("Enter the length of the suitcase (in meters): ");
            double length = scanner.nextDouble();
        System.out.print("Enter the width of the suitcase (in meters): ");
            double width = scanner.nextDouble();
        System.out.print("Enter the height of the suitcase (in meters): ");
            double height = scanner.nextDouble();
        //Calculating volume
        maxVolume = length * width * height;
        scanner.nextLine();
    }

    //Method that sets the suitcase's characteristics
    protected void setSuitcaseCharacteristics(Scanner scanner) {
        setSuitcaseVolume(scanner);
        setSuitcaseWeight(scanner);
    }

    protected double getMaxVolume() {
        return maxVolume;
    }

    protected double gerMaxWeight() {
        return maxWeight;
    }
}
