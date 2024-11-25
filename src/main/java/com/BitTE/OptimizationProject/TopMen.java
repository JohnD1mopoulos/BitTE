/**
 * Abstract class representing men's tops, extending the Clothing class.
 * Provides constructors and default behavior for clothing items specific to men.
 */
public abstract class TopMen extends Clothing {

    /**
     * Constructor for TopMen with all attributes.
     *
     * @param value  the value of the top
     * @param weight the weight of the top
     * @param volume the volume of the top
     * @param size   the size of the top
     */
    public TopMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size, "Men");
    }

    /**
     * Constructor for TopMen without a specific value.
     *
     * @param weight the weight of the top
     * @param volume the volume of the top
     * @param size   the size of the top
     */
    public TopMen(double weight, double volume, String size) {
        super(weight, volume, size, "Men");
    }

    /**
     * Returns a string representation of the TopMen object.
     *
     * @return a string representation of the top
     */
    @Override
    public String toString() {
        return super.toString() + ", TopMen []";
    }
}
