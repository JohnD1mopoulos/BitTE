package com.BitTE.OptimizationProject;   //Added the necessary package

import java.sql.SQLException;

public class AppStart {

    public static void main(String[] args) throws SQLException {
        
        CreateSuitcase.suitcaseCharacteristics();
        double maxVolume = CreateSuitcase.maxVolume;
        double maxWeight = CreateSuitcase.maxWeight;
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume);
        if (addNonEssentials) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            spaceOptimizer.solveModel(NonEssentialItems.fillNonessentials(), maxWeight, maxVolume);
        }
    }
}