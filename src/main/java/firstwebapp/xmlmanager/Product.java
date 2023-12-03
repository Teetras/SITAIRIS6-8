package firstwebapp.xmlmanager;

public class Product {
    private String name;
    private String description;
    private int price;
    private String group;

    public Product(String name, String description, int price, String group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
