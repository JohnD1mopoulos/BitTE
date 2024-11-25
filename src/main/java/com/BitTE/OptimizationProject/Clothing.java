public abstract class Clothing extends PackingItem {
    private String gender;

    public Clothing(int value, double weight, double volume, String size, String gender) {
        super(value, weight, volume, size);
        this.gender = gender;
    }

    public Clothing(double weight, double volume, String size, String gender) {
        super(weight, volume, size);
        this.gender = gender;
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

    public String getSize() {
        return super.getSize();
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return super.toString() + ", Gender: " + this.gender;
    }
}
