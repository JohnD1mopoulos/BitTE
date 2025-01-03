package com.BitTE.OptimizationProject;

import java.util.Scanner;

public class CreateSuitcase {
    //Static variables represent the allowable weigth in kilos and the volume in cubic meters of the suitcase
    protected static double maxVolume;
    protected static double maxWeight;

    //Method which asks the customer about the dimensions of the suitcase and calculates the volume
    private static void suitcaseCharacteristics() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired weight of the suitcase (in kilograms): ");
            maxWeight = scanner.nextDouble();
        System.out.print("Enter the length of the suitcase (in meters): ");
            double length = scanner.nextDouble();
        System.out.print("Enter the width of the suitcase (in meters): ");
            double width = scanner.nextDouble();
        System.out.print("Enter the height of the suitcase (in meters): ");
            double height = scanner.nextDouble();
        //Calculating volume
        maxVolume = length * width * height;
        scanner.close();
    }
}
