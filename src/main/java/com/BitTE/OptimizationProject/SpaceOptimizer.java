package com.BitTE.OptimizationProject;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.sql.SQLException;
import java.util.ArrayList;

// Declaration of the class for the optimization problem
public class SpaceOptimizer {

    // Create the Model for the problem
    public Model createModel(ArrayList<PackingItem> items, int maxWeight, int maxVolume) throws SQLException {
        // Create a Choco Solver model
        Model model = new Model("Knapsack model");

        // Number of items
        int n = items.size();

        // Create variables
        IntVar[] binaryVars = new IntVar[n];
        IntVar[] scaledVars = new IntVar[n];
        IntVar[] weightVars = new IntVar[n];
        IntVar[] volumeVars = new IntVar[n];

        // Calculate the maximum possible total value
        int maxTotalValue = 0;

        for (int i = 0; i < n; i++) {
            PackingItem item = items.get(i);

            // Binary variable for each item
            binaryVars[i] = model.intVar("X" + i, 0, 1);

            // Scaled variable for value
            int value = item.getValue();
            scaledVars[i] = model.intScaleView(binaryVars[i], value);
            maxTotalValue += value;

            // Scale weight and volume to integers
            int weight = (int) (item.getWeight() * 1000);
            int volume = (int) (item.getVolume() * 1000);

            weightVars[i] = model.intScaleView(binaryVars[i], weight);
            volumeVars[i] = model.intScaleView(binaryVars[i], volume);
        }

        // Define the objective function: maximize total value
        IntVar totalValue = model.intVar("TotalValue", 0, maxTotalValue);
        model.sum(scaledVars, "=", totalValue).post();
        model.setObjective(Model.MAXIMIZE, totalValue);

        // Add constraints for weight and volume
        addConstraints(model, weightVars, volumeVars, maxWeight, maxVolume);

        // Debugging logs
        System.out.println("Model created with max possible total value: " + maxTotalValue);
        System.out.println("Number of items: " + n);
        System.out.println("Max weight: " + maxWeight/1000 +"gr");
        System.out.println("Max volume: " + maxVolume/1000 +"cm3");

        return model;
    }

    // Add the volume and weight constraints
    public void addConstraints(Model model, IntVar[] weightVars, IntVar[] volumeVars, int maxWeight, int maxVolume) {
        // Add the volume constraint
        model.sum(volumeVars, "<=", maxVolume).post();
        // Add the weight constraint
        model.sum(weightVars, "<=", maxWeight).post();
    }

    public ArrayList<PackingItem> solveModel(ArrayList<PackingItem> items, double maxWeight, double maxVolume) throws SQLException {
        // Create the model with scaled weight and volume constraints
        Model model = createModel(items, (int) (maxWeight * 1000), (int) (maxVolume * 1000));
    
        // Attempt to solve the model
        if (model.getSolver().solve()) {
            System.out.println("Solution found!");
    
            // List to store the selected items
            ArrayList<PackingItem> selectedItems = new ArrayList<>();
    
            // Iterate through the items and add selected ones to the list
            for (int i = 0; i < items.size(); i++) {
                if (((IntVar) model.getVar(i)).getValue() == 1) {
                    selectedItems.add(items.get(i));
                }
            }
    
            return selectedItems; // Return the list of selected items
        } else {
            System.out.println("No solution found.");
            return new ArrayList<>(); // Return an empty list if no solution is found
        }
    }  
}
