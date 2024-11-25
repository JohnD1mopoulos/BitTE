public class SmallShirtMen extends ShirtMen {
    public SmallShirtMen(int value) {
        super(value, 110, 1000, "Small");
    }
    public SmallShirtMen () {
        super(110, 1000);
    }

    @Override
    public void setVolume() {
        this.volume = 1000;
    }

    @Override
    public void setWeight() {
        this.weight = 110;
    }

    @Override
    public String toString() {
        return super.toString() + "SmallShirt []";
    }
}