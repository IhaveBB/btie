public class CircularQueueEmptyException extends RuntimeException {
    public CircularQueueEmptyException() {
    }

    public CircularQueueEmptyException(String message) {
        super(message);
    }
}
