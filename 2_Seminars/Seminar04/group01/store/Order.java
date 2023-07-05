package group01.store;

public class Order {
    private Customer customer;
    private Product product;
    private int amount;

    public Order() {
    }

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Customer= " + customer.getFirstName() +
                " " + customer.getLastName() +
                ", Product= " + product.getProductName() +
                ", Amount= " + amount +
                '}';
    }
}
