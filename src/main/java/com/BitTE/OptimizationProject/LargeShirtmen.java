public class LargeShirtMen extends TshirtMen {
    public LargeShirtMen(int value) {
        super(value, 150, 2250, "Large");
    }

    public LargeShirtMen() {
        super(150, 2250, "Large");
    }

    @Override
    public void setVolume() {
        this.volume = 2250;
    }

    @Override
    public void setWeight() {
        this.weight = 150;
    }

    @Override
    public String toString() {
        return super.toString() + "LargeShirtMen []";
    }
    
}