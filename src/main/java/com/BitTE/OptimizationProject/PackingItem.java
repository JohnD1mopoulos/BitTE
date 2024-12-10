/**
 * Abstract class representing a packing item.
 */
package main.java.com.BitTE.OptimizationProject;

public abstract class PackingItem {

    // Attributes
    protected int value;
    protected String type;
    protected char size;
  
    /**
     * Constructor for PackingItem with value, type, and size. Essential Items
     *
     * @param value the value of the packing item
     * @param type the type of the packing item
     * @param size the size of the packing item
     */
    public PackingItem(int value, String type, char size) {
      this.value = value;
      this.type = type;
      this.size = size;
    }
  
    /**
     * Constructor for PackingItem with type and size. Non-Essential Items
     *
     * @param type the type of the packing item
     * @param size the size of the packing item
     */
    public PackingItem(String type, char size) {
      this.type = type;
      this.size = size;
    }
  
    /**
     * Gets the value of the packing item.
     *
     * @return the value
     */
    public int getValue() {
      return value;
    }
  
    /**
     * Gets the type of the packing item.
     *
     * @return the type
     */
    public String getType() {
      return type;
    }
  
    /**
     * Gets the size of the packing item.
     *
     * @return the size
     */
    public char getSize() {
      return size;
    }
  
    /**
     * Abstract method to get the weight of the packing item.
     *
     * @return the weight
     */
    public abstract double getWeight();
  
    /**
     * Abstract method to get the volume of the packing item.
     *
     * @return the volume
     */
    public abstract double getVolume();
  
    @Override
    public String toString() {
      return String.format(
          "PackingItem [value=%d, type=%s, size=%s, weight=%.2f, volume=%.2f]",
          value, type, size, getWeight(), getVolume());
    }
  }
  