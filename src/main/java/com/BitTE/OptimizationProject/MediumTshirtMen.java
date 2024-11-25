public class MediumTshirtMen extends TshirtMen {
    public MediumTshirtMen (int value) {
        super(value, 150, 1680, "Medium");
    }

    public MediumTshirtMen () {
        super(150, 1680, "Medium");
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
        return super.toString() + "MediumTshirtMen []";
    }
}
