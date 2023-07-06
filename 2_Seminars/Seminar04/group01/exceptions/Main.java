package group01.exceptions;

import java.util.Scanner;
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
public class Main {
    /**
     * My version of the solution.
     */
    public static void main(String[] args) {
        try {
            System.out.println(
            checkLoginPassword(userInput("Enter login: "),
                    userInput("Enter password: "),
                    userInput("Enter password confirmation: ")));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }


    public static boolean checkLoginPassword(String login, String password, String confirmPassword) {
        boolean result = false;
            if (login.length() > 20) {
                throw new WrongLoginException("Login length exception: login must be less than 20 symbols");
            }
            else if (password.length() < 20) {
                throw new WrongPasswordException("Password length exception: password must be more than 20 symbols");
            }
            else if (password.length() != confirmPassword.length()) {
                throw new WrongPasswordException("Password and confirmPassword mismatch.");
            } else {
                result = true;
            }
        return result;
    }

    private static class WrongLoginException extends RuntimeException {
        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    private static class WrongPasswordException extends RuntimeException {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }

    private static String userInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}
