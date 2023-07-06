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
public class MainV3 {
    /**
     * Lecturer's version of the solution.
     */
    public static void main(String[] args) {
        String[][] credentials = {
                {"John", "p4anfupab67nugoy30*gy", "p4anfupab67nugoy30*gy"},                   // correct
                {"JohnJonsonovichSmithov", "p4anfupab67nugoy30*gy", "p4anfupab67nugoy30*gy"}, // wrong login length
                {"John", "p4anfupab67nugoy30*gy", "ajpdifna"},                                // confirmation mismatch
                {"John", "ajpdifna", "ajpdifna"},                                             // wrong password length
                {"John", "ajpdifna", "dpfnafb"},                                              // wrong password length and confirmation mismatch
        };
        for (int i = 0; i < credentials.length; i++) {
            try {
                System.out.printf("Credentials #%d: ", i);
                System.out.println(checkCredentials(credentials[i][0], credentials[i][1], credentials[i][2]));
            } catch (WrongLoginException e) {
                e.printStackTrace();
            } catch (WrongPasswordException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static class WrongPasswordException extends RuntimeException {
        private int currentLength;
        private boolean matchConfirm;

        public WrongPasswordException(int currentLength, boolean matchConfirm) {
            super();
            this.currentLength = currentLength;
            this.matchConfirm = matchConfirm;
        }

        @Override
        public String getMessage() {
            boolean badlength = currentLength <= 20;
            return String.format("Your password is of %scorrect length%s %d symbols. " +
                            "Password %smatch the confirmation.",
                            ((badlength) ? "in" : ""),
                            ((badlength) ? ", expected > 20, given:" : "of"),
                            currentLength,
                            ((matchConfirm) ? "" : "does not "));
        }
    }

    public static class WrongLoginException extends RuntimeException {
        private int currentLength;

        public WrongLoginException(int currentLength) {
            super();
            this.currentLength = currentLength;
        }

        @Override
        public String getMessage() {
            boolean badlength = currentLength <= 20;
            return String.format("Your password is of %scorrect length %s %d symbols.",
                    ((badlength) ? "in" : ""),
                    ((badlength) ? ", expected > 20, given: " : "of"),
                    currentLength);
        }
    }

    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        boolean confirm = password.equals(confirmPassword);
        int logLength = login.length();
        int pasLength = password.length();
        if (logLength >= 20)
            throw new WrongLoginException(logLength);
        else if (pasLength < 20 || !confirm)
            throw new WrongPasswordException(pasLength, confirm);
        else
            return true;
    }
}
