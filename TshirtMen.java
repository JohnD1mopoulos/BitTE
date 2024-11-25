public abstract class TshirtMen extends TopMen {
    public TshirtMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size);
    }
    
    public TshirtMen(double weight, double volume, String size) {
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
        return super.toString() + "Tshirt []";
    }
}
