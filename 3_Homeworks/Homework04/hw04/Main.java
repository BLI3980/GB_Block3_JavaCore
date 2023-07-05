package hw04;

import java.util.Arrays;

public class Main {
    static Customer[] customers = null;
    static Product[] products = null;
    public static void main(String[] args) {
        customers = new Customer[] {
                new Customer("John", "Smith", 50, "111"),
                new Customer("Varvara", "Ivanova", 25, "222")
        };

        products = new Product[] {
                new Product("Milk", 100),
                new Product("Bread", 70.5f),
                new Product("Cheese", 300),
                new Product("Eggs", 50.3f),
                new Product("Meat", 500),
        };

        Order[] orders = new Order[5];

        String[] firstNames = {"John", "Varvara", "Ivan", "Masha", "Jimmy"};
        String[] lastNames = {};
        String[] productNames ={};

        try {
            orders[0] = makePurchase("111", "Milk", 2);
//            orders[1] = makePurchase("222", "Bread", 1);
//            orders[2] = makePurchase("222", "Cheese", 3);
//            orders[3] = makePurchase("111", "Eggs", 20);
//            orders[4] = makePurchase("222", "Milk", 5);
        } catch (ProductException e) {
            System.out.println("ProductException: Product does not exist. Order will not be created.");
        } catch (AmountException e) {
            System.out.println(e);
//            orders[0] = makePurchase("111", "Milk", 1);
        } catch (CustomerException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(orders));



    }

    public static Order makePurchase(String phone,
                                     String productName, int amount) throws
            CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;
        for (Customer cust: customers) {
            if (cust.getPhone().equals(phone)) {
                customer = cust;
            } else {
                throw new CustomerException("Customer not found.");
            }
        }
        for (Product prod: products) {
            if (prod.getProductName() == productName) {
                product = prod;
            } else {
                throw new ProductException("Product not found.");
            }
        }

        if (amount < 0 || amount > 100) {
            throw new AmountException("Amount quantity is incorrect. Must be within 0 and 100.");
        }
        return new Order(customer, product, amount);
    }
}
