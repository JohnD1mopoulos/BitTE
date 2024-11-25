public class MediumHoodieMen extends TshirtMen {
    public MediumHoodieMen (int value) {
        super(value, 150, 1680, "Medium");
    }

    public MediumHoodieMen () {
        super(550, 5850, "Medium");
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
        return super.toString() + "Medium Hoodie Men []";
    }
}
