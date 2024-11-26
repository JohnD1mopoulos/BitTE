public class LargeShirtMen extends TshirtMen {
    public LargeShirtMen(int value) {
        super(value, 150, 2250, "Large");
    }

    public LargeShirtMen() {
        super(150, 2250, "Large");
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
        return super.toString() + "LargeShirtMen []";
    }
    
}