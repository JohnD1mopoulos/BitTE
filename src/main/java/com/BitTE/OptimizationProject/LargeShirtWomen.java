// Represents a specific type of woman's Shirt in size Large.
// Inherits behavior and properties from ShirtWomen.
public class LargeShirtWomen extends ShirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public LargeShirtWomen(int value) {
        // Calls the superclass (ShirtWomen) constructor with a specific value and default properties.
        super(value, 150, 2250, "Large");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public LargeShirtWomen() {
        // Calls the superclass (ShirtWomen) constructor with default properties.
        super(150, 2250, "Large");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "LargeShirtWomen []" to the superclass's string representation.
        return super.toString() + "LargeShirtWomen []";
    }
}
