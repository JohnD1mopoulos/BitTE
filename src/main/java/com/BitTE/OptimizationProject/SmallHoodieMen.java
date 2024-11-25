public class SmallHoodieMen extends Tshirt {
    public SmallHoodieMen(int value) {
        super(value, 450, 3795, "Small");
    }
    public SmallHoodieMen () {
        super(450, 3795);
    }

    public int getValue() {
        return super.getValue();
    }
    
    public double getWeight() {
        return this.weight();
    }

    public double getVolume() {
        return this.Volume();
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
