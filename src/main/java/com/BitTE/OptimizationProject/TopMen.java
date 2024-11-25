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

    // Overridden Methods

    /**
     * Gets the value of the top.
     *
     * @return the value of the top
     */
    @Override
    public int getValue() {
        return super.getValue();
    }

    /**
     * Gets the weight of the top.
     *
     * @return the weight of the top
     */
    @Override
    public double getWeight() {
        return super.getWeight();
    }

    /**
     * Gets the volume of the top.
     *
     * @return the volume of the top
     */
    @Override
    public double getVolume() {
        return super.getVolume();
    }

    /**
     * Gets the size of the top.
     *
     * @return the size of the top
     */
    @Override
    public String getSize() {
        return super.getSize();
    }

    /**
     * Gets the gender associated with the top.
     *
     * @return the gender of the top (always "Men")
     */
    @Override
    public String getGender() {
        return super.getGender();
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
