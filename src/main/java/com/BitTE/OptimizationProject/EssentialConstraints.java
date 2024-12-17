package main.java.com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.function.Function;

public class EssentialConstraints {
    
    /**
     * Calculates the sum of the chosen attribute of the items, specifically weight or volume.
     * 
     * @param items which contains the items with said attributes.
     * @param attributeGetter which represents the Function that will be applied (either getWeight or getVolume).
     */
    private static double calculateSumOfAttributes(ArrayList<PackingItem> items, Function<PackingItem, Double> attributeGetter) {
        double sum = 0;

        for (PackingItem item : items) {
            sum += attributeGetter.apply(item);
        }
        return sum;
    }

    /**
    * Used to return correspoding values depending on the state of the knapsack's weight and volume
    *and their respective constraints.
    *
    * @param MaxVolume representing the maximum volume that can be added to the knapsack.
    * @param MaxWeight representing the maximum weight that can be added to the knapsack.
    * @param items ArrayList to call calculateSumOfAttributes method.
    * @return int value representing the current state of the constraints:
    *         1 - both weight and volume constraints are respected,
    *         2 - only weight constraint is respected,
    *         3 - only volume constraint is respected,
    *         4 - neither constraint is respected.
    */
    private static int checkConstraints(ArrayList<PackingItem> items, 
                                         double maxWeight,
                                         double maxVolume) {
        double totalWeight = calculateSumOfAttributes(items, PackingItem::getWeight);
        double totalVolume = calculateSumOfAttributes(items, PackingItem::getVolume);

        //Return appropriate value for each scenario 
        if (totalWeight <= maxWeight && totalVolume <= maxVolume) {
            return 1;//Both constraints respected
        }else if (totalWeight <= maxWeight) {
            return 2;//Only weight constraint respected
        }else if (totalVolume <= maxVolume) {
            return 3;//Only volume constraint respected
        }else {
            return 4;//No constraint respected
        }

    }

    /**
    * Provides the user with feedback based on the constraints
    * 
    * @param stateOfConstraints which describes the current state of the constraints
    *                             1 - if both constraints are respected
    *                             2 - if only the weight constraint is respected
    *                             3 - if only the volume constraint is respected
    *                             4 - if no constraints are respected
    */
    private static void constraintFeedback(ArrayList<PackingItem> items,
                                        int stateOfConstraints,
                                        double maxWeight,
                                        double maxVolume ) {
        
        double remainingWeight = maxWeight - calculateSumOfAttributes(items, PackingItem::getWeight);
        double remainingVolume = maxVolume - calculateSumOfAttributes(items, PackingItem::getVolume);
        
        switch (stateOfConstraints){
            case 1: //Constraints respected
                System.out.println("You still have "+remainingWeight+" available kgs\n"
                +"and "+remainingVolume+" available cm3.");
                break;
            case 2: //Volume constraint not respected
                System.out.println("You still have "+remainingWeight+" available kgs\n"
                +"and have surpassed the maximum volume by "+(-remainingVolume)+" cm3.\n"
                +"You have to delete items in order to not violate the volume constraint.");
                break;
            case 3: //Weight constraint not respected
                System.out.println("You have surpassed the maximum weight by "+(-remainingWeight)+"kgs."
                +"\nBut you still have "+remainingVolume+" available cm3."
                +"You have to delete items in order to not violate the weight constraint.");   
                break;
            case 4: //Both constraints not respected
                System.out.println("You have surpassed the maximum weight by "+(-remainingWeight)
                +"kgs.\nYou also have surpassed the maximum volume by"+(-remainingVolume)+"cm3."
                +"You have to delete items in order to not violate the volume and weight constraints.");
                break;   
        }
    }
        
}
