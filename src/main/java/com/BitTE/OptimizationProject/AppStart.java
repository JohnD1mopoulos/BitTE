package com.BitTE.OptimizationProject;   //Added the necessary package
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.BitTE.OptimizationProject.CreateSuitcase;

public class AppStart {

    public static void main(String[] args) {
        
        CreateSuitcase.suitcaseCharacteristics();
        double maxVolume = CreateSuitcase.maxVolume;
        double maxWeight = CreateSuitcase.maxWeight;
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume);
        if (addNonEssentials) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            spaceOptimizer.solveModel(NonEssentialItems.nonEssentialItems, maxWeight, maxVolume);
        }
    }
}