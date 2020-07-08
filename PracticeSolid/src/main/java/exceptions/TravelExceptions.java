package exceptions;

public class TravelExceptions extends AssertionError{

    private static final long serialVersionUID = 1L;

    public static final String SELECTED_HOTEL_DOES_NOT_CONTAINS = "------ ERROR ------ El hotel seleccionado no cuenta con la caracteristica SPA deseada en los detalles de sus ofertas.";

    public TravelExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public TravelExceptions(String message) {
        super(message);
    }
}
