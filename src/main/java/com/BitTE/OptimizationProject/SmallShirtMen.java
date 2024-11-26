public class SmallShirtMen extends ShirtMen {
    public SmallShirtMen(int value) {
        super(value, 110, 1000, "Small");
    }
    public SmallShirtMen () {
        super(110, 1000, "Small");
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
        return super.toString() + "SmallShirt []";
    }
}