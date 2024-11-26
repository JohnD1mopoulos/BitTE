// Represents a women's shirt, extending the TopWoman class.
// Provides constructors for creating a ShirtWomen object with specific properties.
public class ShirtWomen extends TopWomen {

    // Constructor with value, weight, volume, and size parameters.
    public ShirtWomen(int value, double weight, double volume, String size) {
        // Calls the constructor of the superclass (TopWomen) with the given parameters.
        super(value, weight, volume, size);
    }

    // Constructor with weight, volume, and size parameters (no value specified).
    public ShirtWomen(double weight, double volume, String size) {
        // Calls the constructor of the superclass (TopWomen) with the given parameters.
        super(weight, volume, size);
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Combines the superclass's toString() with additional details specific to ShirtWomen.
        return super.toString() + "Shirt []";
    }
}
