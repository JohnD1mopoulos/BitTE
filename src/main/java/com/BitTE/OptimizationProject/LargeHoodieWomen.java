// Represents a specific type of woman's Hoodie in size Large.
// Inherits behavior and properties from HoodieWomen.
public class LargeHoodieWomen extends HoodieWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public LargeHoodieWomen(int value) {
        // Calls the superclass (HoodieWomen) constructor with a specific value and default properties.
        super(value, 650, 7980, "Large");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public LargeHoodieWomen() {
        // Calls the superclass (HoodieWomen) constructor with default properties.
        super(650, 7980, "Large");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "LargeHoodieWomen []" to the superclass's string representation.
        return super.toString() + "LargeHoodieWomen []";
    }
}
