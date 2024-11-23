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
import java.util.Scanner;

 class Knapsack{
    // Static ArrayLists shared across all methods in this class
    private static final ArrayList<Object> essentialItems = new ArrayList<>();//Using Object as data type until we have 
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
    private static boolean essential(float weight, float volume){
        
        boolean volumeMet = true;
        boolean weightMet = true;
        boolean stopInput = false;
        float totalWeight = 0;
        float totalVolume = 0;
        System.out.println("Dear user, please choose the items that are essential for you: ");

        while (volumeMet != false && weightMet != false && stopInput != true){
            System.out.println("Press 1 for X1/n"
                              +"Press 2 for X2/n"
                              +"Press 3 for X3/n"
                              +"Press 4 for X4/n"
                              +"Press 5 for X5/n");

            int choice = scanner.nextInt();

            switch (choice){
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
                   System.out.println("Item "+ "Object "+"was added succesfully");         
            };*/



        }   
    }
 }