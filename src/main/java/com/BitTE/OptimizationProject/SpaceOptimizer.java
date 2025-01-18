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

/**
 * SpaceOptimizer is a utility class designed to solve optimization problems
 * related to space and weight constraints, such as knapsack problems.
 * It uses the Choco Solver library to define
 * and solve mathematical models for packing items within defined limits.
 */
public class SpaceOptimizer {

    /**
     * Class-level variable to store binary decision variables.
     */
    private IntVar[] binaryVars;
    /**
     * Class-level variable to scale variables.
     */
    private final int scale = 100;

    /**
     * Create the Model for the problem.
     * @param items
     * @param maxWeight
     * @param maxVolume
     * @return a model {@link Model} for the solver.
     * @throws SQLException
     */
    @SuppressWarnings("deprecation")
    public Model createModel(
        final ArrayList<PackingItem> items,
        final int maxWeight,
        final int maxVolume) throws SQLException {
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

            int weight = (int) (item.getWeight() * scale);
            int volume = (int) (item.getVolume() * scale);
            weightVars[i] = model.intScaleView(binaryVars[i], weight);
            volumeVars[i] = model.intScaleView(binaryVars[i], volume);
        }

        IntVar totalValue = model.intVar("TotalValue", 0, maxTotalValue);
        model.sum(scaledVars, "=", totalValue).post();
        model.setObjective(Model.MAXIMIZE, totalValue);

        addConstraints(model, weightVars, volumeVars, maxWeight, maxVolume);

        System.out.println(
            "Model created with max possible total value: " + maxTotalValue);
        System.out.println("Number of items: " + n);
        System.out.println("Max weight: " + maxWeight / scale + "gr");
        System.out.println("Max volume: " + maxVolume / scale + "cm3");

        return model;
    }

    /**
     * Add the volume and weight constraints.
     * @param model
     * @param weightVars
     * @param volumeVars
     * @param maxWeight
     * @param maxVolume
     */
    public void addConstraints(
         final Model model, final IntVar[] weightVars,
         final IntVar[] volumeVars,
         final int maxWeight,
         final int maxVolume) {
        model.sum(volumeVars, "<=", maxVolume).post();
        model.sum(weightVars, "<=", maxWeight).post();
    }

    /**
     * Solve the model.
     * @param items
     * @param maxWeight
     * @param maxVolume
     * @return a list of {@link PackingItem} that are selected.
     * @throws SQLException
     */
    public ArrayList<PackingItem> solveModel(
        final ArrayList<PackingItem> items,
        final double maxWeight,
        final double maxVolume) throws SQLException {
        if (items.size() != 0) {
        Model model = createModel(
            items, (int) (maxWeight * scale), (int) (maxVolume * scale));

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
        } else {
            return new ArrayList<>();
        }
    }
}
