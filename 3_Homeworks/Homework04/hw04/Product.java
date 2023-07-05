package hw04;

public class Product {
    private String productName;
    private float price;

    private Category category;

    public Product(String productName, float price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName= '" + productName + '\'' +
                ", price= " + price +
                ", category: " + category +
                '}';
    }
}
