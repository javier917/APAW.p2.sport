package exceptions;

public class InvalidFieldException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;
    public static final String DESCRIPTION = "Campo no adecuado";

    public InvalidFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidFieldException() {
        this("");
    }
}
