package com.BitTE.OptimizationProject;

/**
 * Abstract class representing a generic packing item.
 * This class serves as a base for items that can be packed, providing common properties
 * such as type, size, and value, and requires implementation of weight and volume retrieval methods.
 */
public abstract class PackingItem {
  protected int value;
  protected String type;
  protected char size;

  /**
   * Constructs a new PackingItem with specified value, type, and size. Used for Non-Essential items
   *
   * @param value the monetary value of the packing item
   * @param type the type of the packing item (e.g., "T-Shirt", "Hoodie")
   * @param size the size of the packing item ( "S", "M", "L")
   */
  public PackingItem(int value, String type, char size) {
      this.value = value;
      this.type = type;
      this.size = size;
  }

  /**
   * Constructs a new PackingItem with specified type and size.
   * This constructor is used for Essential items
   *
   * @param type the type of the packing item
   * @param size the size of the packing item
   */
  public PackingItem(String type, char size) {
      this(0, type, size); // Default value is set to 0 for Essential items
  }

  /**
   * Returns the value of the packing item.
   *
   * @return the value of the item
   */
  public int getValue() {
      return this.value;
  }

  /**
   * Returns the size of the packing item.
   *
   * @return the size of the item
   */
  public String getSize() {
      return this.size;
  }

  /**
   * Abstract method to return the weight of the packing item.
   * Implementing classes must provide the logic to return the item's weight.
   * Implemting classes will connect to the database to fetch the weight.
   *
   * @return the weight of the item
   */
  public abstract double getWeight();

  /**
   * Abstract method to return the volume of the packing item.
   * Implementing classes must provide the logic to return the item's volume.
   * Implemting classes will connect to the database to fetch the volume.
   *
   * @return the volume of the item
   */
  public abstract double getVolume();

  /**
   * Provides a string representation of the packing item.
   * Includes value, type, size, weight, and volume in the string.
   *
   * @return a string representation of the packing item
   */
  @Override
  public String toString() {
      return "PackingItem [value =" + value + ", type =" + type + ", size =" + size 
             + ", Weight =" + getWeight() + ", Volume =" + getVolume() + "]";
  }
}
