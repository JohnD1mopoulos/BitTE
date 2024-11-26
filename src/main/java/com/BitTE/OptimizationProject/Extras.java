public class Extras extends PackingItem {
    private String type;
    
    public Extras(int value, double weight, double volume, String type) {
        super(weight, volume);
        this.type = type;
    }

    public Extras(double weight, double volume, String type) {
        super(weight, volume);
        this.type = type;
    }

    public static Extras createExtras(String type) {
        switch (type) {
            case "Book":
                        return new Book(360, 1400);
            case "Laptop":
                    return new Laptop(1680, 2000);
                }
            }
        return null;
    }


public class Book extends Extras {
    public Book(int value, double weight, double volume) {
        super(value, weight, volume,"Book");
    }
    public Book(double weight, double volume) {
        super(weight, volume, "Book");
    }
}
