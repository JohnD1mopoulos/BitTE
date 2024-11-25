public class HoodietMen extends TopMen {
    public HoodietMen(int value, double weight, double volume, String size) {
        super(value, weight, volume, size);
    }

    public HoodietMen(double weight, double volume, String size) {
        super(weight, volume, size);
    }

    @Override
    public String toString() {
        return super.toString() + "Hoodie []";
    }
}
