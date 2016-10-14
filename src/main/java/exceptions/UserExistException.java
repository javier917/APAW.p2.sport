package exceptions;

public class UserExistException extends Exception{
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "el usuario ya existe";

    public UserExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public UserExistException() {
        this("");
    }
}
