// Abstract class representing a women's T-shirt, extending the TopWomen class
public abstract class TshirtWomen extends TopWomen {

    // Constructor with value, weight, volume, and size parameters
    public TshirtWomen(int value, double weight, double volume, String size) {
        // Calls the constructor of the superclass (TopWomen) with the given parameters
        super(value, weight, volume, size);
    }

    // Constructor with weight, volume, and size parameters
    public TshirtWomen(double weight, double volume, String size) {
        // Calls the constructor of the superclass (TopWomen) with the given parameters
        super(weight, volume, size);
    }

    // Overrides the toString() method to provide a string representation of the object
    @Override
    public String toString() {
        // Combines the superclass's toString() with additional details specific to TshirtWomen
        return super.toString() + "Tshirt []";
    }
}
