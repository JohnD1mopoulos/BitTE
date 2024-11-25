public class LargeTshirtMen extends TshirtMen {
    public LargeTshirtMen(int value) {
        super(value, 180, 2475, "Large");
    }

    public LargeTshirtMen() {
        super(180, 2475, "Large");
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
        return super.toString() + "LargeTshirtMen []";
    }
    
}