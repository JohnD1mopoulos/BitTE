package com.BitTE.OptimizationProject;   //Added the necessary package

import java.sql.SQLException;
import java.util.Scanner;

public class AppStart {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        CreateSuitcase.suitcaseCharacteristics(scanner);
        double maxVolume = CreateSuitcase.maxVolume;
        double maxWeight = CreateSuitcase.maxWeight;
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);
        if (addNonEssentials) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            spaceOptimizer.solveModel(nonEssentialItemsManager.fillNonessentials(scanner), maxWeight, maxVolume);
        } else {
            System.out.println("No trip for you");
        }
    }
}