package group01.store;

import group02.competition.Obstacle;

import java.util.Arrays;
import java.util.Objects;
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
public class MainV2 {
    /**
     * Lecturer's version of the solution.
     */
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

        Object[][] info = {
                {customers[0], products[0], 1},                                 // Good case.
                {customers[0], products[0], -1},                                // Incorrect amount: -1.
                {customers[0], products[0], 101},                               // Incorrect amount: >100.
                {customers[1], new Product("Water", 30), 1},    // Unknown product.
                {new Customer("Will", "Shakespeare", 428, "000"), products[1], 1},
                                                                                // Unknown customer.
        };
        int capacity = 0;
        int iterator = 0;
        while (capacity != orders.length - 1 || iterator != info.length) {
            try {
                orders[capacity] = makePurchase((Customer) info[iterator][0],
                                                (Product) info[iterator][1],
                                                (int) info[iterator][2]);
                capacity++;
            } catch (ProductException1 e) {
                e.printStackTrace();
            } catch (AmountException1 e) {
                orders[capacity++] = makePurchase((Customer) info[iterator][0],
                                                    (Product) info[iterator][1],
                                                    1);
            } catch (CustomerException1 e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++iterator;
        }

        System.out.println(Arrays.deepToString(orders));

    }

    private static boolean isInArray (Object[] array, Object compareObject) {
        for (Object item: array)
            if (item.equals(compareObject)) return true;
        return false;
    }
    public static Order makePurchase(Customer customer, Product product, int amount) {
        if (!isInArray(customers, customer))
            throw new CustomerException1("Unknown customer: " + customer);
        if (!isInArray(products, product))
            throw new ProductException1("Unknown product: " + product);
        if (amount <=0 || amount >100)
            throw new AmountException1("Incorrect amount: " + amount);
        return new Order(customer, product, amount);
    }
}
