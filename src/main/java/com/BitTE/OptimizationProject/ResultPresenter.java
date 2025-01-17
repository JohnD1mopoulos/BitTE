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

import java.util.ArrayList;

final class ResultPresenter {

    // Private constructor to prevent instantiation
    private ResultPresenter() {
        throw new UnsupportedOperationException(
            "This is a utility class and it shouldn't be instantiated");
    }

    /**
     * Prints the result of the whole process informing the user which
     * and how many items were selected.
     *
     * @param essentialList representing the items that were deemed by the user
     *                      as essential for his trip.
     * @param selectedItems the non-essential items that were selected for the
     *                      user by the program.
     */
    public static void showResults(final ArrayList<PackingItem> essentialList,
                                    final ArrayList<PackingItem>
                                    selectedItems) {
        System.out.println("------ SUITCASE FINAL CONTENTS ------");

        // Display essential items
        if (essentialList != null && !essentialList.isEmpty()) {
            System.out.println("--- ESSENTIAL ITEMS PACKED ---");
            for (PackingItem item : essentialList) {
                System.out.println("* " + item);
            }
        } else {
            System.out.println("--- No essential items were packed. ---");
        }

        // Display non-essential items
        if (selectedItems != null && !selectedItems.isEmpty()) {
            System.out.println("--- NON-ESSENTIAL ITEMS PACKED ---");
            for (PackingItem item : selectedItems) {
                System.out.println("* " + item);
            }
        } else {
            System.out.println("--- No non-essential items were packed. ---");
        }

        // Handle case where no items are packed
        if ((essentialList == null || essentialList.isEmpty())
            && (selectedItems == null || selectedItems.isEmpty())) {
            System.out.println("You've selected no items whatsoever!");
            System.out.println("Goodbye!!!!!!");
        }
    }
}
