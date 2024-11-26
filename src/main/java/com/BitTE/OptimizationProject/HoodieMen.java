/**
 * Represents a specific type of clothing, HoodieMen, which extends TopMen.
 * Inherits attributes and behavior from TopMen and adds its unique implementation.
 */
public class HoodieMen extends TopMen {

    /**
     * Constructor for HoodieMen with all attributes.
     *
     * @param value  the value of the hoodie
     * @param weight the weight of the hoodie
     * @param volume the volume of the hoodie
     * @param size   the size of the hoodie
     */
    public HoodieMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size);
    }

    /**
     * Constructor for HoodieMen without a specific value.
     *
     * @param weight the weight of the hoodie
     * @param volume the volume of the hoodie
     * @param size   the size of the hoodie
     */
    public HoodieMen(double weight, double volume, String size) {
        super(weight, volume, size);
    }

    // Overridden Methods

    /**
     * Gets the value of the hoodie.
     *
     * @return the value of the hoodie
     */
    @Override
    public int getValue() {
        return super.getValue();
    }

    /**
     * Gets the weight of the hoodie.
     *
     * @return the weight of the hoodie
     */
    @Override
    public double getWeight() {
        return super.getWeight();
    }

    /**
     * Gets the volume of the hoodie.
     *
     * @return the volume of the hoodie
     */
    @Override
    public double getVolume() {
        return super.getVolume();
    }

    /**
     * Gets the gender associated with the hoodie.
     *
     * @return the gender associated with the hoodie
     */
    @Override
    public String getGender() {
        return super.getGender();
    }

    /**
     * Gets the size of the hoodie.
     *
     * @return the size of the hoodie
     */
    @Override
    public String getSize() {
        return super.getSize();
    }

    /**
     * Returns a string representation of the hoodie.
     *
     * @return a string representation of the hoodie
     */
    @Override
    public String toString() {
        return super.toString() + ", Hoodie []";
    }
}
