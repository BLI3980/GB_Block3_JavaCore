package group01.exceptions;

import java.util.Scanner;

public class Main {
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
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Login length exception: login must be less than 20 symbols");
            }
            else if (password.length() > 20) {
                throw new WrongLoginException("Password length exception: password must be less than 20 symbols");
            }
            else if (password.length() != confirmPassword.length()) {
                throw new WrongPasswordException("Password and confirmPassword mismatch.");
            } else {
                result = true;
            }
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException(e.getMessage());
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
