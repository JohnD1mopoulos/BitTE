package com.BitTE.OptimizationProject;   //Added the necessary package
import java.sql.SQLException;
import java.util.Scanner;

public class AppStart {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CreateSuitcase suitcase = CreateSuitcase.getInstance();
        suitcase.setSuitcaseCharacteristics(scanner);
        double maxVolume = suitcase.getMaxVolume();
        double maxWeight = suitcase.gerMaxWeight();
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);
        NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
        if (addNonEssentials) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            spaceOptimizer.solveModel(nonEssentialItemsManager.fillNonessentials(scanner), maxWeight, maxVolume);
        } else {
            System.out.println("No trip for you");
        }
    }
}
