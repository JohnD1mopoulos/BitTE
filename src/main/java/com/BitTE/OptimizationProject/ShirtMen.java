public class ShirtMen extends TopMen {
    public ShirtMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size);
    }

    public ShirtMen(double weight, double volume, String size) {
        super(weight, volume, size);
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

    public String getGender() {
        return super.getGender();
    }

    public String getSize() {
        return super.getSize();
    }

    @Override
    public String toString() {
        return super.toString() + "Shirt []";
    }
}
