// Represents a specific type of woman's Shirt in size Medium.
// Inherits behavior and properties from ShirtWomen.
public class MediumShirtWomen extends ShirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public MediumShirtWomen(int value) {
        // Calls the superclass (ShirtWomen) constructor with a specific value and default properties.
        super(value, 130, 1610, "Medium");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public MediumShirtWomen() {
        // Calls the superclass (ShirtWomen) constructor with default properties.
        super(130, 1610, "Medium");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "MediumShirtWomen []" to the superclass's string representation.
        return super.toString() + "MediumShirtWomen []";
    }
}
