/**
 * Created to contain all methods used for constraint control
 
 * This class will be effective in arranging the "workspace" ensuring efficient workflow.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 class ParameterControl {
     /**
        * Used to show the remaining weight that can be added in the knapsack
        *
        * @param s Uses the ArrayList essentialItems
        * @return Float variable that represents difference between the maximum weight value and the current weight value
        */
        protected static float checkWeight(){
           float totalWeight= 0;
           for (int i =0; i < Knapsack.essentialItems.size(); i++){
            totalWeight += Knapsack.essentialItems.get(i).getWeight();
           }
           return totalWeight;
        }

        protected static float checkVolume(){
            float totalVolume= 0;
            for (int i =0; i < Knapsack.essentialItems.size(); i++){
             totalWeight += Knapsack.essentialItems.get(i).getVolume();
            }
            return totalVolume;
        }

        protected static float getRemainingWeight(float MaxWeight){
           return  MaxWeight - checkWeight();
        }

        protected static float getRemainigVolume(float MaxVolume){
           return MaxVolume - checkVolume();
        }

        protected static int checkConstraints(float MaxWeight, float MaxVolume){

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


        protected static void showItems(){
            for (int i =0; i < Knapsack.essentialItems.size(); i++){
                System.out.println((i+1) + ") " + Knapsack.essentialItems.get(i));
            }
        }

        protected static void inputItem(){
            Scanner scanner = new Scanner(System.in);
            int choiceOfItem = -1;
            
            try {
                choiceOfItem = scanner.nextInt();
                switch (choiceOfItem){
                    /*case 1:
                        essentialItems.add(Object X1);
                        System.out.println("Item "+ "Object "+"was added succesfully");//Object will be changed with the class item when 
                        //are created
                        break;
                    case 2:
                        essentialItems.add(Object X2);
                        System.out.println("Item "+ "Object "+"was added succesfully");
                    case 3:
                        essentialItems.add(Object X3);
                        System.out.println("Item "+ "Object "+"was added succesfully");  
                    case 4:
                        essentialItems.add(Object X4);
                        System.out.println("Item "+ "Object "+"was added succesfully");
                    case 5:
                        essentialItems.add(Object X5);
                       System.out.println("Item "+ "Object "+"was added succesfully"); */        
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please select a valid integer");
            }
        }

        
        /**
        * Deletes a number of items from ArrayList essentialItems depending on the user's input
        * @param s None
        * @return Nothing
        */
        // TODO: Waiting the classes to be created so that i can be adjusted for ArrayList nonessenitalItems also
        protected static void deleteItem() {
            Scanner scanner = new Scanner(System.in);
        
            while (true) {
                // Check if there are items to delete
                if (Knapsack.essentialItems.isEmpty()) {
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
                    } else if (choice1 < 1 || choice1 > Knapsack.essentialItems.size()) {
                        System.out.println("Invalid choice. Please select a valid item number.");
                        continue; // Restart the loop
                    }
        
                    // Delete the chosen item
                    System.out.println("Item no " + choice1 + " (" + Knapsack.essentialItems.get(choice1 - 1) + ") has been deleted.");
                    Knapsack.essentialItems.remove(choice1 - 1);

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
