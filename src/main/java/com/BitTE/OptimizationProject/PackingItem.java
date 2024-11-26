/**
 * Abstract class representing a packing item with attributes such as value,
 * weight, volume, and size.
 */
public abstract class PackingItem {

    // Attributes
    private int value;
    private double weight;
    private double volume;
    private String size;

    /**
     * Constructor to create a PackingItem with all attributes.
     *
     * @param value  the value of the packing item
     * @param weight the weight of the packing item
     * @param volume the volume of the packing item
     * @param size   the size of the packing item
     */
    public PackingItem(int value, double weight, double volume, String size) {
        this.value = value;
        this.weight = weight;
        this.volume = volume;
        this.size = size;
    }

    /**
     * Constructor to create a PackingItem without a specified value.
     *
     * @param weight the weight of the packing item
     * @param volume the volume of the packing item
     * @param size   the size of the packing item
     */
    public PackingItem(double weight, double volume, String size) {
        this(0, weight, volume, size); // Default value is set to 0
    }

    // Getters

    /**
     * Gets the value of the packing item.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets the weight of the packing item.
     *
     * @return the weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Gets the volume of the packing item.
     *
     * @return the volume
     */
    public double getVolume() {
        return this.volume;
    }

    /**
     * Gets the size of the packing item.
     *
     * @return the size
     */
    public String getSize() {
        return this.size;
    }

    // Overridden Methods

    /**
     * Returns a string representation of the PackingItem.
     *
     * @return a string with the attributes of the packing item
     */
    @Override
    public String toString() {
        return "PackingItem {" +
                "value=" + value +
                ", weight=" + weight +
                ", volume=" + volume +
                ", size='" + size + '\'' +
                '}';
    }
}
