/**
 * Represents a dynamic knapsack used to store items, both essential and non-essential.
 
 * The knapsack is designed to operate under specific weight and volume constraints. 
 * If these constraints are not met during the addition of items, the operation 
 * may terminate or fail to add the item depending on if the item is or isn't essential.
 
 * This class can dynamically adjust to accommodate different types of items, 
 * ensuring efficient use of available space and weight capacity.
 */

 //
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 class Knapsack{
    // Static ArrayLists shared across all methods in this class
    protected static final ArrayList<Object> essentialItems = new ArrayList<>();//Using Object as data type until we have 
    private static final ArrayList<Object> nonEssentialItems = new ArrayList<>();//the corresponding classes
    //Scanner object for user to input choices
    private static Scanner scanner = new Scanner(System.in);


    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms if the constraints are met with each added item
    *
    * @param s The Weight and Volume of the knapsack
    * @return A boolean variable that confirms the continuation of the operation if the constraints are still met.
    */

    // TODO: Impliment the item classes when created and make the corresponding changes
    private static boolean fillEssential(float MaxWeight, float MaxVolume){
        
        
        
        System.out.println("Dear user, please choose the items that are essential for you: ");
        boolean processRunning = true;

        while (processRunning){
            //Display MENU 
            System.out.println("Press 1 to add X1/n"
                              +"Press 2 to add  X2/n"
                              +"Press 3 to add X3/n"
                              +"Press 4 to add X4/n"
                              +"Press 5 to add X5/n");

            //Input item
            ParameterControl.inputItem();

            //Check constraints
            int constraintsMet = ParameterControl.checkConstraints(MaxWeight, MaxVolume);

            //Provide feedback based on constraints
            switch (constraintsMet){
                case 1: //Constraints respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(MaxWeight)+" available kgs"
                        +"and "+ParameterControl.getRemainigVolume(MaxVolume)+" available cm2.");
                        break;
                case 2: //Volume constraint not respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(MaxWeight)+" available kgs"
                        +"and have surpassed the maximum volume by"+(-ParameterControl.getRemainigVolume(MaxVolume))+" by cm2.");
                        break;
                case 3: //Weigth constraint not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(MaxWeight))
                        +"kgs. But you still have "+ParameterControl.getRemainigVolume(MaxVolume)+" available cm2.");   
                        break;
                case 4: //Both constraints not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(MaxWeight))
                        +"kgs. You also have surpassed the maximum volume by"+(-ParameterControl.getRemainigVolume(MaxVolume))
                        +" by cm2.");
                        break;   
            }

            //Handle different constraint scenarios
            if (constraintsMet != 1){//Constraints arent met
                System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to remove item");
                boolean validChoice;
                while (!validChoice){
                    try {
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (userChoice == 1){
                            return false;//Knapsack wasnt filled 
                        } else if (userChoice == 2){
                            ParameterControl.deleteItem();
                            validChoice = true;//stop loop
                        } else {
                            System.out.println("Invalid choice. Please enter 1 or 2");
                        }
                    } catch (InputMismatchException e){
                         System.out.println("Invalid input. Please enter a valid integer.");
                         scanner.nextLine();
                    }
                }
            } else {//Constraints are met
                
                System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to add another item");
                
                 boolean validChoice;
                 while (!validChoice){
                     try {
                         int userChoice = scanner.nextInt();
                         scanner.nextLine();
                         if (userChoice == 1){
                            System.out.println("All esential items have been added!!!");
                             return true;//Knapsack was filled 
                        } else if (userChoice == 2) {
                             validChoice = true;//Continue adding items
                        } else {
                            System.err.println("INvalid choice. Please press 1 oe 2.");
                        }
                     } catch (InputMismatchException e){
                             System.out.println("Invalid input. Please enter a valid integer.");
                             scanner.nextLine();
                     }
                 }
            
            }
        } 
        return false; 
    }
 }