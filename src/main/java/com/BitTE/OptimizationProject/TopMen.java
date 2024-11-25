public abstract class TopMen extends Clothing {
    public TopMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size, "Men");
    }
    
    public TopMen(double weight, double volume, String size) {
        super(weight, volume, size, "Men");
    }
    public int getValue() {
        return super.getValue();
    }

    public double getWeight() {
        return super.getWeight();
    }

    public double getVolume() {
        return super.getVolume();
    }

    public String getSize() {
        return super.getSize();
    }

    public String getGender() {
        return super.getGender();
    }
    
    @Override
    public String toString() {
        return super.toString() + "TopMen []";
    }
}
