/*
 * Copyright 2025 BitTE Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.BitTE.OptimizationProject;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.sql.SQLException;
import java.util.ArrayList;

// Declaration of the class for the optimization problem
public class SpaceOptimizer {

    // Class-level variable to store binary decision variables
    private IntVar[] binaryVars;

    // Create the Model for the problem
    @SuppressWarnings("deprecation")
    public Model createModel(ArrayList<PackingItem> items, int maxWeight, int maxVolume) throws SQLException {
        Model model = new Model("Knapsack model");

        int n = items.size();
        binaryVars = new IntVar[n];  // Initialize the binaryVars array

        IntVar[] scaledVars = new IntVar[n];
        IntVar[] weightVars = new IntVar[n];
        IntVar[] volumeVars = new IntVar[n];
        int maxTotalValue = 0;

        for (int i = 0; i < n; i++) {
            PackingItem item = items.get(i);
            binaryVars[i] = model.intVar("X" + i, 0, 1);  // Store binary vars

            int value = item.getValue();
            scaledVars[i] = model.intScaleView(binaryVars[i], value);
            maxTotalValue += value;

            int weight = (int) (item.getWeight() * 1000);
            int volume = (int) (item.getVolume() * 1000);
            weightVars[i] = model.intScaleView(binaryVars[i], weight);
            volumeVars[i] = model.intScaleView(binaryVars[i], volume);
        }

        IntVar totalValue = model.intVar("TotalValue", 0, maxTotalValue);
        model.sum(scaledVars, "=", totalValue).post();
        model.setObjective(Model.MAXIMIZE, totalValue);

        addConstraints(model, weightVars, volumeVars, maxWeight, maxVolume);

        System.out.println("Model created with max possible total value: " + maxTotalValue);
        System.out.println("Number of items: " + n);
        System.out.println("Max weight: " + maxWeight / 1000 + "gr");
        System.out.println("Max volume: " + maxVolume / 1000 + "cm3");

        return model;
    }

    // Add the volume and weight constraints
    public void addConstraints(Model model, IntVar[] weightVars, IntVar[] volumeVars, int maxWeight, int maxVolume) {
        model.sum(volumeVars, "<=", maxVolume).post();
        model.sum(weightVars, "<=", maxWeight).post();
    }

    public ArrayList<PackingItem> solveModel(ArrayList<PackingItem> items, double maxWeight, double maxVolume) throws SQLException {
<<<<<<< HEAD
        if(items.size()!=0){
=======
>>>>>>> e984be37555fd43fe34c92341cb12897ca764a91
        Model model = createModel(items, (int) (maxWeight * 1000), (int) (maxVolume * 1000));

        if (model.getSolver().solve()) {
            System.out.println("Solution found!");

            ArrayList<PackingItem> selectedItems = new ArrayList<>();

            // Use binaryVars to check which items are selected
            for (int i = 0; i < items.size(); i++) {
                if (binaryVars[i].getValue() == 1) {
                    selectedItems.add(items.get(i));
                    System.out.println("Selected item: " + items.get(i));
                }
            }

            return selectedItems;
        } else {
            System.out.println("No solution found.");
            return new ArrayList<>();
        }
<<<<<<< HEAD
        } else {
            return new ArrayList<>();
        }
    }
}
=======
    }
}
>>>>>>> e984be37555fd43fe34c92341cb12897ca764a91
