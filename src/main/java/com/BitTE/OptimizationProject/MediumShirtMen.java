public class MediumShirtMen extends TshirtMen {
    public MediumShirtMen (int value) {
        super(value, 130, 1610, "Medium");
    }

    public MediumShirtMen () {
        super(130, 1610, "Medium");
    }

    @Override
    public void setVolume() {
        this.volume = 1610;
    }

    @Override
    public void setWeight() {
        this.weight = 130;
    }

    @Override
    public String toString() {
        return super.toString() + "MediumShirtMen []";
    }
}