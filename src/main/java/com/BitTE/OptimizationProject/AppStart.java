package com.BitTE.OptimizationProject;   //Added the necessary package
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
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
        
        MenuHandler.showStartingNonEssentialItemsMenu();
        int userChoice = scanner.nextInt();
        if (addNonEssentials & userChoice == 2) {
            NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            ArrayList<PackingItem> selectedItems = spaceOptimizer.solveModel(
                nonEssentialItemsManager.fillNonessentials(scanner), maxWeight, maxVolume);
                
                System.out.println("------------SELECTED ITEMS------------------");
            for (int i = 0; i < selectedItems.size(); i++) {
                System.out.println(selectedItems.get(i));
            }
                System.out.println("-------------------------------------");
        }else if (!addNonEssentials){
            System.out.println("No trip for you");
        } else {
            System.out.println("Trip only with essentials");
        }
        scanner.close();
    }
}
