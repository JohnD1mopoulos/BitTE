/**
 * Represents a specific type of clothing, LargeHoodieMen, which extends TopMen.
 * Defines a large hoodie for men with fixed attributes for weight, volume, and size.
 */
public class LargeHoodieMen extends TopMen {

    /**
     * Constructor for LargeHoodieMen with a specified value.
     *
     * @param value the value of the large hoodie
     */
    public LargeHoodieMen(int value) {
        super(value, 650, 7980, "Large");
    }

    /**
     * Default constructor for LargeHoodieMen with no specified value.
     * Assigns default weight, volume, and size.
     */
    public LargeHoodieMen() {
        super(650, 7980, "Large");
    }

    /**
     * Returns a string representation of the LargeHoodieMen object.
     *
     * @return a string representation of the large hoodie
     */
    @Override
    public String toString() {
        return super.toString() + ", Large Hoodie Men []";
    }
}
