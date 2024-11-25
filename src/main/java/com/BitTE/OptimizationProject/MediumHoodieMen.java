/**
 * Represents a specific type of clothing, MediumHoodieMen, which extends TopMen.
 * Defines a medium hoodie for men with fixed attributes for weight, volume, and size.
 */
public class MediumHoodieMen extends TopMen {

    /**
     * Constructor for MediumHoodieMen with a specified value.
     *
     * @param value the value of the medium hoodie
     */
    public MediumHoodieMen(int value) {
        super(value, 150, 1680, "Medium");
    }

    /**
     * Default constructor for MediumHoodieMen with no specified value.
     * Assigns default weight, volume, and size.
     */
    public MediumHoodieMen() {
        super(550, 5850, "Medium");
    }

    /**
     * Returns a string representation of the MediumHoodieMen object.
     *
     * @return a string representation of the medium hoodie
     */
    @Override
    public String toString() {
        return super.toString() + ", Medium Hoodie Men []";
    }
}
