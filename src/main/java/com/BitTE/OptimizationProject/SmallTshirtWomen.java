// Represents a specific type of woman's T-shirt in size Small.
// Inherits behavior and properties from TshirtWomen.
public class SmallTshirtWomen extends TshirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public SmallTshirtWomen(int value) {
        // Calls the superclass (TshirtWomen) constructor with a specific value and default properties.
        super(value, 100, 750, "Small");
    }

    // Default constructor that assigns default values for weight, volume, and size.
    public SmallTshirtWomen() {
        // Calls the superclass (TshirtWomen) constructor with default properties.
        super(100, 750, "Small");
    }

    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "SmallTshirtWomen []" to the superclass's string representation.
        return super.toString() + "SmallTshirtWomen []";
    }
}

