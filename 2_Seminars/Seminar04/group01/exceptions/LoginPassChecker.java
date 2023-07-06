package group01.exceptions;

public class LoginPassChecker {
    private String login;
    private String password;
    private String confirmPassword;

    public LoginPassChecker() {
    }

    public LoginPassChecker(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public boolean checker() throws WrongLoginException, WrongPasswordException {
        boolean result = false;
        if (login.length() > 20)
            throw new WrongLoginException("Login length exception: login must be less than 20 symbols");
        else if (password.length() <= 20)
            throw new WrongPasswordException("Password length exception: password must be more than 20 symbols");
        else if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Password and confirmPassword mismatch.");
        else result = true;
        return result;
    }
}
