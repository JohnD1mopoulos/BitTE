public class SmallHoodieMen extends HoodieMen {
    public SmallHoodieMen(int value) {
        super(value, 450, 3795, "Small");
    }
    public SmallHoodieMen () {
        super(450, 3795, "Small");
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
        return super.toString() + "Small Hoodie Men []";
    }
}
