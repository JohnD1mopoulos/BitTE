public class LargeHoodieMen extends TshirtMen {
    public LargeHoodieMen(int value) {
        super(value, 650, 7980, "Large");
    }

    public LargeHoodieMen() {
        super(650, 7980, "Large");
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
        return super.toString() + "Large Hoodie Men []";
    }
    
}