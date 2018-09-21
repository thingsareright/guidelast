package ssm.exception;

public class SendAuthorCodeEmailFailException extends RuntimeException{

    private String message;

    public SendAuthorCodeEmailFailException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public SendAuthorCodeEmailFailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
