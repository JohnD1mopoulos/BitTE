// Represents a specific type of woman's T-shirt in size Medium.
// Inherits behavior and properties from TshirtWomen.
public class MediumTshirtWomen extends TshirtWomen {

    // Constructor that accepts a value parameter and assigns default values for weight, volume, and size.
    public MediumTshirtWomen(int value) {
        // Calls the superclass (TshirtWomen) constructor with the provided value
        // and predefined properties for weight, volume, and size.
        super(value, 120, 1288, "Medium");
    }
        
    // Default constructor that assigns default values for weight, volume, and size.
    public MediumTshirtWomen() {
        // Calls the superclass (TshirtWomen) constructor with default properties.
        super(120, 1288, "Medium");
    }
    
    // Overrides the toString() method to provide a string representation of the object.
    @Override
    public String toString() {
        // Appends "MediumTshirtWomen []" to the superclass's string representation.
        return super.toString() + "MediumTshirtWomen []";
    }
}
