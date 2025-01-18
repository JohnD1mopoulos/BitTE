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

import com.BitTE.OptimizationProject.DatabaseTableCreation;


public class AppStart {
    public static void main(String[] args) throws SQLException {
        Logger.info("Starting the application...");
        
        new DatabaseConnection();
        new DatabaseTableCreation();

        Scanner scanner = new Scanner(System.in);

        CreateSuitcase suitcase = CreateSuitcase.getInstance(scanner);
        final double maxVolume = suitcase.getMaxVolume();
        final double maxWeight = suitcase.getMaxWeight();

        EssentialItems essentialItemsManager = EssentialItems.getInstance();
        boolean addNonEssentials =
            essentialItemsManager.fillEssential(maxWeight, maxVolume, scanner);

        ArrayList<PackingItem> selectedItems = null;
        if (addNonEssentials) {
            NonEssentialItems nonEssentialItemsManager = NonEssentialItems.getInstance();
            if (nonEssentialItemsManager.fillNonEssentialItems(scanner, essentialItemsManager) == true) {
            SpaceOptimizer spaceOptimizer = new SpaceOptimizer();
            selectedItems = spaceOptimizer.solveModel(
                nonEssentialItemsManager.nonEssentialItems, maxWeight, maxVolume);
            }
        }
        ResultPresenter.showResults(essentialItemsManager.essentialItems,
                selectedItems);
        scanner.close();
    }
}
