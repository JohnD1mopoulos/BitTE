public abstract class PackingItem {
    private int value;
    private double weight;
    private double volume;
    private String size;

    public PackingItem(int value, double weight, double volume, String size) {
        this.value = value;
        this.weight = weight;
        this.volume = volume;
        this.size = size;
    }
    public PackingItem(double weight, double volume, String size) {
        this.weight = weight;
        this.volume = volume;
        this.size = size;
    }

    public int getValue() {
        return this.value;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getVolume() {
        return this.volume;
    }

    public String getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "PackingItem [value=" + value + ", weight=" + weight + ", volume=" + volume + ", size=" + size + "]";
    }
}
