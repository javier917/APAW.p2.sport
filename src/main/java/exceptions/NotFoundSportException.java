package exceptions;

public class NotFoundSportException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Deporte no encontrado";

    public NotFoundSportException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public NotFoundSportException() {
        this("");
    }

}
