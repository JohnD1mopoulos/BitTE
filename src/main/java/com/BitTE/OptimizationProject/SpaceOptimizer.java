import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import java.util.ArrayList;

// Declaration of the class for the optimization problem
public class SpaceOptimizer {

    // Create the Model for the problem
    public Model createModel(ArrayList<PackingItem> items, double maxWeight, double maxVolume) {
        // Create a Choco Solver model
        Model model = new Model("Knapsack model");

        // Number of items
        int n = items.size();

        // Create variables
        IntVar[] binaryVars = new IntVar[n];
        IntVar[] scaledVars = new IntVar[n];
        IntVar[] weightVars = new IntVar[n];
        IntVar[] volumeVars = new IntVar[n];

        for (int i = 0; i < n; i++) {
            PackingItem item = items.get(i);

            binaryVars[i] = model.intVar("X" + i, 0, 1); // Binary variable for each item
            int value = item.getValue(); // Get the value of the item
            scaledVars[i] = model.intScaleView(binaryVars[i], value); // Scaled variable for value

            // Scale weight and volume to integers
            int weight = (int) (item.getWeight() * 1000);
            int volume = (int) (item.getVolume() * 1000);

            weightVars[i] = model.intScaleView(binaryVars[i], weight);
            volumeVars[i] = model.intScaleView(binaryVars[i], volume);
        }

        // Define the objective function: maximize total value
        IntVar totalValue = model.intVar("TotalValue", 0, Integer.MAX_VALUE);
        model.sum(scaledVars, "=", totalValue).post();
        model.setObjective(Model.MAXIMIZE, totalValue);

        // Add constraints for weight and volume
        addConstraints(model, weightVars, volumeVars, (int)maxWeight * 1000, (int)maxVolume * 1000);

        return model;
    }

    // Add the volume and weight constraints
    public void addConstraints(Model model, IntVar[] weightVars, IntVar[] volumeVars, int maxWeight, int maxVolume) {
        // Add the volume constraint
        model.sum(volumeVars, "<=", maxVolume).post();
        // Add the weight constraint
        model.sum(weightVars, "<=", maxWeight).post();
    }

    // Solve the model and print the solution
    public void solveModel(ArrayList<PackingItem> items, double maxWeight, double maxVolume) {
        // Create the model
        Model model = createModel(items, (int) (maxWeight * 1000), (int) (maxVolume * 1000));

        // Solve the model
        if (model.getSolver().solve()) {
            System.out.println("Solution found!");

            // Output the selected items
            for (int i = 0; i < items.size(); i++) {
                int selected = model.getVar("X" + i).getValue();
                System.out.println("Item " + i + " : Selected = " + selected);
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
