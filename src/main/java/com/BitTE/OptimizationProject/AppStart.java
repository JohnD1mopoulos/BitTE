package com.BitTE.OptimizationProject;   //Added the necessary package
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.tinylog.Logger;

import com.BitTE.OptimizationProject.DatabaseTableCreation;


public class AppStart {
    public static void main(String[] args) throws SQLException {
        Logger.info("Starting the application...");
        
        new DatabaseTableCreation();
        DatabaseConnection.getConnection();
        //Create object to show Results
        ResultPresenter resultPresenter = new ResultPresenter();

        Scanner scanner = new Scanner(System.in);

        CreateSuitcase suitcase = CreateSuitcase.getInstance(scanner);
        final double maxVolume = suitcase.getMaxVolume();
        final double maxWeight = suitcase.getMaxWeight();

        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);
        
        MenuHandler.showStartingNonEssentialItemsMenu();
        int userChoice = scanner.nextInt();

        ArrayList<PackingItem> selectedItems = null;
        if (addNonEssentials & userChoice == 2) {
            NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            selectedItems = spaceOptimizer.solveModel(
                nonEssentialItemsManager.fillNonessentials(scanner), maxWeight, maxVolume);
        }
        resultPresenter.showResults(essentialItemsManager.essentialItems, 
                selectedItems,
                scanner);
        scanner.close();
    }
}
