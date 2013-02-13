package Model;

public class FoodCombo {

    private String name;
    private String description;
    private double Price;

    public FoodCombo() {
    }

    public FoodCombo(String name, String description, double Price) {
        this.name = name;
        this.description = description;
        this.Price = Price;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }
}
