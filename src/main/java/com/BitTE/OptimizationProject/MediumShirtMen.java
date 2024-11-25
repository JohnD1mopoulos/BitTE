public class MediumShirtMen extends TshirtMen {
    public MediumShirtMen (int value) {
        super(value, 130, 1610, "Medium");
    }

    public MediumShirtMen () {
        super(130, 1610, "Medium");
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
        return super.toString() + "MediumShirtMen []";
    }
}