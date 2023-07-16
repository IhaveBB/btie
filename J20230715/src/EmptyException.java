public class EmptyException extends RuntimeException {
    EmptyException() {
        super();
    }

    EmptyException(String message) {
        super(message);
    }
}

