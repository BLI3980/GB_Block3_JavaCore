package hw04;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = new Customer[2];
        Product[] products = new Product[5];
        Order[] orders = new Order[5];

        customers[0] = new Customer("John", "Smith", 50, 111, Gender.MALE);
        customers[1] = new Customer("Varvara", "Ivanova", 25, 222, Gender.FEMALE);

        products[0] = new Product("Product1", 1000);
        products[1] = new Product("Product2", 2000);
        products[2] = new Product("Product3", 3000);
        products[3] = new Product("Product4", 4000);
        products[4] = new Product("Product5", 5000);
    }
}
