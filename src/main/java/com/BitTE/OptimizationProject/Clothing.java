/**
 * Abstract class representing a type of clothing item, which extends PackingItem.
 * Includes additional attributes specific to clothing, such as gender.
 */
public abstract class Clothing extends PackingItem {

    // Attribute specific to Clothing
    private String gender;

    /**
     * Constructor for Clothing with all attributes.
     *
     * @param value   the value of the clothing item
     * @param weight  the weight of the clothing item
     * @param volume  the volume of the clothing item
     * @param size    the size of the clothing item
     * @param gender  the gender associated with the clothing item
     */
    public Clothing(int value, double weight, double volume, String size, String gender) {
        super(value, weight, volume, size);
        this.gender = gender;
    }

    /**
     * Constructor for Clothing without a specific value.
     *
     * @param weight  the weight of the clothing item
     * @param volume  the volume of the clothing item
     * @param size    the size of the clothing item
     * @param gender  the gender associated with the clothing item
     */
    public Clothing(double weight, double volume, String size, String gender) {
        super(weight, volume, size);
        this.gender = gender;
    }

    // Getters

    /**
     * Gets the value of the clothing item.
     *
     * @return the value of the clothing item
     */
    @Override
    public int getValue() {
        return super.getValue();
    }

    /**
     * Gets the weight of the clothing item.
     *
     * @return the weight of the clothing item
     */
    @Override
    public double getWeight() {
        return super.getWeight();
    }

    /**
     * Gets the volume of the clothing item.
     *
     * @return the volume of the clothing item
     */
    @Override
    public double getVolume() {
        return super.getVolume();
    }

    /**
     * Gets the size of the clothing item.
     *
     * @return the size of the clothing item
     */
    @Override
    public String getSize() {
        return super.getSize();
    }

    /**
     * Gets the gender associated with the clothing item.
     *
     * @return the gender associated with the clothing item
     */
    public String getGender() {
        return this.gender;
    }

    // Overridden Methods

    /**
     * Returns a string representation of the clothing item, 
     * including details from PackingItem and the gender attribute.
     *
     * @return a string describing the clothing item
     */
    @Override
    public String toString() {
        return super.toString() + ", Gender: " + this.gender;
    }
}
