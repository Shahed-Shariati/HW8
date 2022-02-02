package utility;

public class ProductNotFound extends RuntimeException{
    final private String message = "Product not found";
    public ProductNotFound(String message) {
        super(message);
    }

    public ProductNotFound() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
