package group01.store;

import java.util.Arrays;
import java.util.Random;
/*
Задание про интернет-магазин:
Класс «Эмуляция интернет-магазина».
1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель,
 объект товар, целочисленное количество).
2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов)
 и массив заказов (пустой на 5 элементов).
3. Создать статический метод «совершить покупку» со строковыми параметрами,соответствующими полям объекта заказа.
 Метод должен вернуть объект заказа.
4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException,
 если передан несуществующий товар, метод должен выбросить исключение ProductException, если было передано
 отрицательное или слишком больше значение количества (например, 100), метод должен выбросить исключение
 AmountException.
5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми
 значениями. Обработать исключения следующим образом (в заданном порядке):
– если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
– если было передано неверное количество – купить товар в количестве 1;
– если был передан неверный пользователь – завершить работу приложения с исключением.
6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.
7. реализовать логику приложения Магазин из описания к уроку.
8. Добавить перечисление с гендерами. В класс покупателя добавить свойство «пол» со значением созданного
 перечисления. Добавить геттеры, сеттеры.
9. Добавить в приложение Магазин учет цены товара - в Заказ добавить поле стоимость. Добавить перечисление с
 размерами скидок - 0, 5, 10, 15, 20%.
Написать метод, при вызове которого на переданный тип товара назначается рандомная скидка из перечисления
 (меняем значение поля price)
4. ** Товарам добавить категорию. Задать категории Стандарт и Премиум. Если на товар категории Премиум
 назначилась скидка более 15%, выбросить исключение TooMuchSaleException(msg), сообщение с ошибкой вывести
 в консоль, цену товара не менять.
*/
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

        String[] phones = {"111", "111", "222", "222", "333"};
        String[] productNames ={"Milk", "Bread", "Cheese", "Tomato", "Cucumber"};

        int count = 0;
        for (int i = 0; i < 5; i++) {
            int random = new Random().nextInt(5);
            int amount = new Random().nextInt(-200, 200);
            try {
                orders[i] = makePurchase(phones[random], productNames[random], amount);
                count++;
                System.out.println("Order # " + (i+1) + ": " + orders[i]);
            } catch (ProductException e) {
                System.out.println("ProductException: Order # " + (i+1) +
                                    ". Product '" + productNames[random] + "' does not exist. " +
                                    "Order will not be created.");
            } catch (AmountException e) {
                System.out.println("AmountException: Order # " + (i+1) +
                                    ". Incorrect amount specified (" + amount + "). " +
                                    "Must be within 1 and 100. " + "The amount was changed to 1.");
                try {
                    orders[i] = makePurchase(phones[random], productNames[random], 1);
                    count++;
                } catch (ProductException ex) {
                    System.out.println(ex.getMessage());
                } catch (AmountException ex) {
                    System.out.println(ex.getMessage());
                } catch (CustomerException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (CustomerException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println(Arrays.deepToString(orders));
        System.out.println("Orders created: " + count);

    }

    public static Order makePurchase(String phone,
                                     String productName,
                                     int amount) throws
                                     CustomerException, ProductException, AmountException{
        Customer customer = null;
        Product product = null;
        for (Customer cust: customers) {
            if (cust.getPhone().equals(phone)) {
                customer = cust;
            }
        }
        for (Product prod: products) {
            if (prod.getProductName() == productName) {
                product = prod;
            }
        }

        if (customer == null) {
            throw new CustomerException("Customer not found.");
        }

        if (product == null) {
            throw new ProductException("Product not found.");
        }

        if (amount <= 0 || amount > 100) {
            throw new AmountException("Amount is incorrect.");
        }
        return new Order(customer, product, amount);
    }
}
