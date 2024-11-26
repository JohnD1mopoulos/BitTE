// Represents a specific type of woman's Hoodie in size Medium.
// Inherits behavior and properties from HoodieWomen.
public class MediumHoodieWomen extends HoodieWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public MediumHoodieWomen(int value) {
        // Calls the superclass (HoodieWomen) constructor with a specific value and default properties.
        super(value, 550, 5850, "Medium");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public MediumHoodieWomen() {
        // Calls the superclass (HoodieWomen) constructor with default properties.
        super(550, 5850, "Medium");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "MediumHoodieWomen []" to the superclass's string representation.
        return super.toString() + "MediumHoodieWomen []";
    }
}
