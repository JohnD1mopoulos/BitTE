public class SmallTshirtMen extends TshirtMen {
    public SmallTshirtMen(int value) {
        super(value, 130, 1400, "Small");
    }
    public SmallTshirtMen () {
        super(130, 1400, "Small");
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
        return super.toString() + "Small Tshirt Men []";
    }
}
