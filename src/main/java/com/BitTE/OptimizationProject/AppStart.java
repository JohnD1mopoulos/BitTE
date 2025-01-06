package com.BitTE.OptimizationProject;   //Added the necessary package
import java.sql.SQLException;
import java.util.Scanner;

import com.BitTE.OptimizationProject.CreateSuitcase;
import com.BitTE.OptimizationProject.DatabaseConnection;
import com.BitTE.OptimizationProject.SpaceOptimizer;
import org.tinylog.Logger;

public class AppStart {
    public static void main(String[] args) throws SQLException {
        Logger.info("Starting the application...");
        
        new DatabaseTableCreation();
        DatabaseConnection.getConnection();
        Scanner scanner = new Scanner(System.in);
        CreateSuitcase suitcase = CreateSuitcase.getInstance(scanner);
        final double maxVolume = suitcase.getMaxVolume();
        final double maxWeight = suitcase.getMaxWeight();
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);
        NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
        if (addNonEssentials) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            spaceOptimizer.solveModel(nonEssentialItemsManager.fillNonessentials(scanner), maxWeight, maxVolume);
        } else {
            System.out.println("No trip for you");
        }
        scanner.close();
    }
}
