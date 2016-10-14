package exceptions;

public class SportExistException extends Exception{
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "el deporte ya existe";

    public SportExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public SportExistException() {
        this("");
    }
}
