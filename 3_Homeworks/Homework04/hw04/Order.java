package hw04;

public class Order {
    private Customer customer;
    private Product product;
    private int amount;
    private float orderCost;

    public Order() {
    }

    public Order(Customer customer, Product product, int amount, float orderCost) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.orderCost = orderCost;
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

    public float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(float orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Customer= " + customer.getFirstName() +
                " " + customer.getLastName() +
                ", Product= " + product.getProductName() +
                ", Amount= " + amount +
                ", Order Cost= " + orderCost +
                '}';
    }
}
