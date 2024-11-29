/**
 * Created to contain all methods used for constraint control
 
 * This class will be effective in arranging the "workspace" ensuring efficient workflow.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;

 class ParameterControl {
        /**
        * Used to return the weight that has been added to the knapsack
        *
        * @param s Uses PackingItem ArrayList 
        * @return Double variable that represents difference between the maximum weight value and the current weight value
        */
        protected static double checkWeight(ArrayList<PackingItem> items){
           double totalWeight= 0;
           for (int i =0; i < items.size(); i++){
            totalWeight += items.get(i).getWeight();
           }
           return totalWeight;
        }
        
        /**
        * Used to return the volume that has been added to the knapsack
        *
        * @param s Uses PackingItem ArrayList 
        * @return Double variable that represents difference between the maximum weight value and the current weight value
        */
        protected static double checkVolume(ArrayList<PackingItem> items){
            double totalVolume= 0;
            for (int i =0; i < items.size(); i++){
             totalWeight += items.get(i).getVolume();
            }
            return totalVolume;
        }

        /**
        * Used to return the remaining weigth that can be added to the knapsack
        *
        * @param s Double MaxWeight representing the maximum weigth that can be added to the knapsack
        * @return Double value representing difference between the maximum weight value and the current weight value
        */
        protected static double getRemainingWeight(double MaxWeight){
           return  MaxWeight - checkWeight();
        }

        /**
        * Used to return the remaining volume that can be added to the knapsack
        *
        * @param s Double MaxVolume representing the maximum volume that can be added to the knapsack
        * @return Double value representing difference between the maximum volume value and the current volume value
        */
        protected static float getRemainigVolume(double MaxVolume){
           return MaxVolume - checkVolume();
        }

        /**
        * Used to return correspoding values depending on the state of the knapsack's weight and volume
        *and their respective constraints
        *
        * @param s Double MaxVolume representing the maximum volume that can be added to the knapsack
        *          Double MaxWeight representing the maximum weigth that can be added to the knapsack
        * @return int value representing the current state of the constraints
        */
        protected static int checkConstraints(double MaxWeight, double MaxVolume){

            boolean weightConstraintRespected = getRemainingWeight(MaxWeight) > 0;;
            boolean volumeConstraintRepsected = getRemainingVolume(MaxVolume) > 0;;
            
    
            if (weightConstraintRespected && volumeConstraintRepsected){
                return 1;
            }else if (weightConstraintRespected){

                return 2;
            }else if (volumeConstraintRepsected){
                return 3;
            }else {
                return 4;
            }
        }

        /**
        * Used to show all items that have already been added to the Knapsack
        *
        * @param s Uses PackingItem ArrayList 
        * @return Nothing
        */
        protected static void showItems(ArrayList<PackingItem> items){
            for (int i =0; i < items.size(); i++){
                System.out.println((i+1) + ") " + items.get(i));
            }
        }

        /**
        * Used to set the user's gender
        *
        * @param s Scanner object
        * @return Sex variabe of type char representing the user's gender
        */
        protected static char setGender(Scanner scanner) {
            System.out.println("Please enter your gender: (M for Male, F for Female)");
            char sex;
            while (true) { // Infinite loop until valid input is provided
                String input = scanner.nextLine().trim(); // Read the entire line and trim whitespace
                if (input.isEmpty()) { // Check for empty input
                    System.err.println("No input detected. Please enter 'M' for Male or 'F' for Female.");
                    continue; // Prompt user again
                }
                if (input.length() == 1) { // Ensure input is a single character
                    sex = input.toUpperCase().charAt(0);
                    if (sex == 'M' || sex == 'F') {
                        return sex;
                    }
                }
                System.err.println("Invalid input. Please enter 'M' for Male or 'F' for Female.");
            }
        }

        /**
        * Used to set the user's desired size
        *
        * @param s Scanner object
        * @return Size variabe of type char representing the user's choice of size
        */
        protected static char setSize(Scanner scanner) {
            System.out.println("Please enter your desired size: (S for Small, M for Medium, L for Large)");
            char size;
            while (true) { // Infinite loop until valid input is provided
                String input = scanner.nextLine().trim(); // Read the entire line and trim whitespace
                if (input.isEmpty()) { // Check for empty input
                    System.err.println("No input detected. Please enter 'S' for Small or 'M' for Medium or 'L' for Large.");
                    continue; // Prompt user again
                }
                if (input.length() == 1) { // Ensure input is a single character
                    size = input.toUpperCase().charAt(0);
                    if (size == 'S' || size == 'M' || size == 'L') {
                        return size;
                    }
                }
                System.err.println("Invalid input. Please enter 'S' for Small or 'M' for Medium or 'L' for Large.");
            }   
        }
        

        //TODO: After consulting between the backend and the data enginners we should finalize the additions of the items
        protected static void inputEssentialItem(ArrayList<PackingItem> items, Scanner scanner) {
            int choiceOfItem = -1;
            
            try {
                choiceOfItem = scanner.nextInt();
                scanner.nextLine();//Clear the newline character
                    if (choiceOfItem > 0 && choiceOfItem < 11) {//Check for valid choice of item
                    switch (choiceOfItem) {
                        case 1:
                            items.add(new ShirtMen());
                            System.out.println("Item "+ "Object "+"was added succesfully");
                            break;
                        case 2:
                            items.add(new HoodieMen());
                            System.out.println("Item "+ "Object "+"was added succesfully");
                            break;
                        /*case 3:
                            items.add(Object X3);
                            System.out.println("Item "+ "Object "+"was added succesfully");  
                            break;
                        case 4:
                            items.add(Object X4);
                            System.out.println("Item "+ "Object "+"was added succesfully");
                            break;
                        case 5:
                            items.add(Object X5);
                            System.out.println("Item "+ "Object "+"was added succesfully"); 
                            break;*/
                    }       
                } else {
                    System.out.println("Give me an integer ranging from 1 to 11");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please select a valid integer");
            }
        }

        
        /**
        * Deletes a number of items from ArrayList essentialItems depending on the user's input
        * @param s Uses PackingItem ArrayList
        * @return Nothing
        */
        protected static void deleteItem(ArrayList<PackingItem> items, Scanner scanner) {
            while (true) {
                // Check if there are items to delete
                if (items.isEmpty()) {
                    System.out.println("No items available to delete.");
                    return; // Exit the method
                }
        
                // Display available items
                System.out.println("You can delete the following items:");
                showItems();
        
                // Prompt the user to choose an item to delete
                System.out.println("Which one do you want to delete? (Press 0 to cancel)");
        
                int choice1 = -1; // Variable representing the item to be deleted
                try {
                    choice1 = scanner.nextInt();
                    scanner.nextLine(); 
        
                    if (choice1 == 0) {
                        System.out.println("Stopping deletion of items.");
                        return; // Exit the method
                    } else if (choice1 < 1 || choice1 > items.size()) {
                        System.out.println("Invalid choice. Please select a valid item number.");
                        continue; // Restart the loop
                    }
        
                    // Delete the chosen item
                    System.out.println("Item no " + choice1 + " (" + iItems.get(choice1 - 1) + ") has been deleted.");
                    Knapsack.items.remove(choice1 - 1);

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); 
                    continue; // Restart the loop
                }
        
                // Ask the user if they want to delete another item
                System.out.println("Press 1 to delete another item.\nPress 2 to stop deleting items.");
                int choice2 = -1; // Variable representing choice to continue or stop method
        
                while (true) {
                    try {
                        choice2 = scanner.nextInt();
                        scanner.nextLine(); 
        
                        if (choice2 == 1) {// Continue the loop to delete another item
                            break;
                        } else if (choice2 == 2) {
                            System.out.println("Stopping deletion process.");
                            return; // Exit the method
                        } else {
                            System.out.println("Invalid choice. Please press 1 to delete another item or 2 to stop.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter 1 or 2.");
                        scanner.nextLine();
                    }
                }
            }
        }
        
    
}
