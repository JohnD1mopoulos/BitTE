// Represents a specific type of woman's Shirt in size Small.
// Inherits behavior and properties from ShirtWomen.
public class SmallShirtWomen extends ShirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public SmallShirtWomen(int value) {
        // Calls the superclass (ShirtWomen) constructor with a specific value and default properties.
        super(value, 110, 1000, "Small");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public SmallShirtWomen() {
        // Calls the superclass (ShirtWomen) constructor with default properties.
        super(110, 1000, "Small");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "SmallShirtWomen []" to the superclass's string representation.
        return super.toString() + "SmallShirtWomen []";
    }
}
