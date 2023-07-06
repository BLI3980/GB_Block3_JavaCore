package group01.exceptions;

/*
Задача: Проверка логина и пароля
1. Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
2. Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить
WrongLoginException.
3. Длина password должна быть больше 20 символов. Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
4. WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
5. В основном классе программы необходимо по-разному обработать исключения.
6. Метод возвращает true, если значения верны или false в другом случае.
 */

import java.util.Scanner;

public class MainV2 {
    /**
     * Seminar version of the solution.
     */

    public static void main(String[] args) {
        String login = userInput("Enter login: ");
        String password = userInput("Enter password: ");
        String confirmPassword = userInput("Enter password confirmation: ");
        LoginPassChecker checker = new LoginPassChecker(login, password, confirmPassword);

        try {
            checker.checker();
        } catch (WrongLoginException e) {
            System.out.print(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.print(e.getMessage());
        }

    }

    public static String userInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
