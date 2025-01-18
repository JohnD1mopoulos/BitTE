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
  * Main entry point for the application.
  * Initializes the database, connects to it, and manages the creation and processing
  * of suitcases with packing items based on user input.
  */
 public class AppStart {
     
     /**
      * Starts the application, sets up the database, and handles user interaction
      * to manage suitcase packing.
      *
      * @param args command-line arguments (not used)
      * @throws SQLException if a database access error occurs
      */
     public static void main(String[] args) throws SQLException {
         Logger.info("Starting the application...");
 
         // Initialize database tables and ensure the database connection is ready.
         new DatabaseTableCreation();
         DatabaseConnection.getConnection();
 
         Scanner scanner = new Scanner(System.in);
 
         // Setup suitcase based on user specifications.
         CreateSuitcase suitcase = CreateSuitcase.getInstance(scanner);
         final double maxVolume = suitcase.getMaxVolume();
         final double maxWeight = suitcase.getMaxWeight();
 
         // Fill suitcase with essential items and possibly non-essentials if allowed by weight and volume.
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
         // Display the results of the packing process to the user.
         ResultPresenter.showResults(essentialItemsManager.essentialItems, selectedItems);
         scanner.close();
     }
 }
 