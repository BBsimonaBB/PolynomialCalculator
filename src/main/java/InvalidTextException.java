public class InvalidTextException extends Exception{
    public InvalidTextException() {
    }

    public InvalidTextException(String message) {
        super("Textul introdus nu este un polinom valid. Va rugam rescrieti");
    }
}

