// Importing members from the Choco Solver library.
// These imports allow direct access to methods and members of the specified classes
// without needing to prefix them with the class name.

import  org.chocosolver.solver.Model;        // Provides methods for creating and manipulating models.
import  org.chocosolver.solver.Solution;     // Enables working with solutions, such as storing and retrieving variable values.
import  org.chocosolver.solver.variables.IntVar; // Allows direct use of integer variable methods without prefixing.
import  org.chocosolver.solver.constraints.Constraint; // Enables defining and using constraints in optimization problems.
import java.util.ArrayList; // Enables working with ArrayLists.
// Declaration of the class for the optimization problem
public class SpaceOptimizer {
    //Create the Model for the problem
    public Model createModel(ArrayList<PackingItem> Items, double maxWeight, double maxVolume) {
         // Create a Choco Solver model
        Model model = new Model("Knapsack model");
         // Number of items in ArrayList -1
        int n = Items.size(); 
        // Create variables and multipliers
        IntVar[] binaryVars = new IntVar[n];
        IntVar[] scaledVars = new IntVar[n];
        IntVar[] volumeVars = new IntVar[n];
        RealVar[] weightVars = new RealVar[n];
        for (int i = 0; i < n; i++) {
            binaryVars[i] = model.intVar("X" + i, 0, 1);  // Binary variable for each item
            int value = Items.get(i).getValue(); // Get the value of the item
            scaledVars[i] = model.intScaleView(binaryVars[i], value); // Declare the multiplier of the variable
            double volume = Items.get(i).getVolume(); // Get the volume of the item
            volumeVars[i] = model.realVar("Volume" + i, 0, volume);  // RealVar for the volume, bounded by 0 and the item's volume
            double weight = Items.get(i).getWeight(); // Get the weight of the item
            weightVars[i] = model.realVar("Weight" + i, 0, weight); // RealVar for the weight, bounded by 0 and the item's weight
            model.times(binaryVars[i], volume, scaledVolumeVars[i]).post(); // If binaryVar[i] is 1, VolumeVars[i] takes the volume value ****
            model.times(binaryVars[i], weight, scaledWeightVars[i]).post(); // If binaryVar[i] is 1, WeightVars[i] takes the weight value ****
             
        }
            // Define the objective function
        IntVar totalValue = model.intVar("TotalValue", 0, Integer.MAX_VALUE);
        model.sum(scaledVars, "=", totalValue).post(); // Sum of scaled values as the total value
        model.setObjective(Model.MAXIMIZE, totalValue); // Maximize the total value

            // Call the addConstraint method
       addConstraint(model, volumeVars, weightVars, maxWeight, maxVolume);

            // Return the final model
       return model;
    }

    //Add the volume and weight constraints
    public void addConstraint(Model model, RealVar[] volumeVars, RealVar[] weightVars, double maxWeight, double maxVolume){
       //Add the volume constraint
       model.realSum(volumeVars, "<=", maxVolume).post();
       //Add the weight constraint 
       model.realSum(weightVars, "<=", maxWeight).post();
    }

    // Solve the model and print the solution
    public void solveModel(ArrayList<PackingItem> Items, double maxWeight, double maxVolume) {
        // Create the model
        Model model = createModel(Items, maxWeight, maxVolume);

        // Solve the model
        if (model.getSolver().solve()) {
            System.out.println("Solution found!");

            // Output the selected items
            for (int i = 0; i < Items.size(); i++) {
                // Output the result for the binary decision variable (whether the item is selected)
                System.out.println("Item " + i + " (" + Items.get(i).getName() + "): Selected = " + model.getVar("X" + i).getValue());
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
