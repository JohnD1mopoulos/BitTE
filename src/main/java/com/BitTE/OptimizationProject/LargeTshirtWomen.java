// Represents a specific type of woman's T-shirt in size Large.
// Inherits behavior and properties from TshirtWomen.
public class LargeTshirtWomen extends TshirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public LargeTshirtWomen(int value) {
        // Calls the superclass (TshirtWomen) constructor with the provided value
        // and predefined properties for weight, volume, and size.
        super(value, 140, 1500, "Large");
    }
        
    // Default constructor that assigns default values for weight, volume, and size.
    public LargeTshirtWomen() {
        // Calls the superclass (TshirtWomen) constructor with default properties.
        super(140, 1500, "Large");
    }
    
    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "LargeTshirtWomen []" to the superclass's string representation.
        return super.toString() + "LargeTshirtWomen []";
    }
}
