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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.tinylog.Logger;

/**
 * Provides the main entry point for the application, initializing database connections,
 * managing user input for suitcase creation, and displaying results.
 */
public class AppStart {
    
    /**
     * Initializes the application, establishes database connectivity, processes user input
     * for packing items in a suitcase, and displays the results.
     *
     * <p>This method sets up the necessary database tables, connects to the database,
     * and prompts the user to specify details for packing a suitcase. It handles essential
     * and non-essential items based on available space and weight capacity.
     *
     * @param args the command-line arguments (not used)
     * @throws SQLException if a database access error occurs
     */
    public static void main(String[] args) throws SQLException {
        Logger.info("Starting the application...");

        // Initialize the database and ensure the connection is ready.
        new DatabaseTableCreation();
        DatabaseConnection.getConnection();

        Scanner scanner = new Scanner(System.in);

        // Configure suitcase based on user input.
        CreateSuitcase suitcase = CreateSuitcase.getInstance(scanner);
        final double maxVolume = suitcase.getMaxVolume();
        final double maxWeight = suitcase.getMaxWeight();

        // Attempt to fill the suitcase with essential items first.
        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials = essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);

        ArrayList<PackingItem> selectedItems = null;
        if (addNonEssentials) {
            NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
            if (nonEssentialItemsManager.fillNonEssentialItems(scanner, essentialItemsManager) == true) {
                SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
                selectedItems = spaceOptimizer.solveModel(
                    nonEssentialItemsManager.nonEssentialItems, maxWeight, maxVolume);
            }
        }
        // Present the final packing results to the user.
        ResultPresenter.showResults(essentialItemsManager.essentialItems, selectedItems);
        scanner.close();
    }
}
