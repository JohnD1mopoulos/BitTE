// Represents a specific type of woman's Hoodie in size Small.
// Inherits behavior and properties from HoodieWomen.
public class SmallHoodieWomen extends HoodieWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public SmallHoodieWomen(int value) {
        // Calls the superclass (HoodieWomen) constructor with a specific value and default properties.
        super(value, 450, 3795, "Small");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public SmallHoodieWomen() {
        // Calls the superclass (HoodieWomen) constructor with default properties.
        super(450, 3795, "Small");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "SmallHoodieWomen []" to the superclass's string representation.
        return super.toString() + "SmallHoodieWomen []";
    }
}
