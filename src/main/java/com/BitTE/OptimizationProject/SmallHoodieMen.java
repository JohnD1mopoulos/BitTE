/**
 * Represents a specific type of clothing, SmallHoodieMen, which extends HoodieMen.
 * Defines a small hoodie for men with fixed attributes for weight, volume, and size.
 */
public class SmallHoodieMen extends HoodieMen {

    /**
     * Constructor for SmallHoodieMen with a specified value.
     *
     * @param value the value of the small hoodie
     */
    public SmallHoodieMen(int value) {
        super(value, 450, 3795, "Small");
    }

    /**
     * Default constructor for SmallHoodieMen with no specified value.
     * Assigns default weight, volume, and size.
     */
    public SmallHoodieMen() {
        super(450, 3795, "Small");
    }

    /**
     * Returns a string representation of the SmallHoodieMen object.
     *
     * @return a string representation of the small hoodie
     */
    @Override
    public String toString() {
        return super.toString() + ", Small Hoodie Men []";
    }
}
