/**
 * Abstract class representing women's tops, extending the Clothing class.
 * Provides constructors and default behavior for clothing items specific to women.
 */
public abstract class TopWomen extends Clothing {
    
     /**
     * Constructor for TopWomen with all attributes.
     *
     * @param value  the value of the top
     * @param weight the weight of the top
     * @param volume the volume of the top
     * @param size   the size of the top
     */
    public TopWomen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size, "Woman");
    }

    /**
     * Constructor for TopWomen without a specific value.
     *
     * @param weight the weight of the top
     * @param volume the volume of the top
     * @param size   the size of the top
     */
    public TopWomen(double weight, double volume, String size) {
        super(weight, volume, size, "Woman");
    }
    
    /**
     * Returns a string representation of the TopWomen object.
     *
     * @return a string representation of the top
     */
    @Override
    public String toString() {
        return super.toString() + "TopWomen []";
    }
}
