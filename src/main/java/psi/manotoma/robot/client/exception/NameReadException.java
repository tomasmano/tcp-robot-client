package psi.manotoma.robot.client.exception;


public class NameReadException extends RobotClientException {

    public NameReadException() {
    }

    public NameReadException(String message) {
        super(message);
    }

    public NameReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameReadException(Throwable cause) {
        super(cause);
    }

    public NameReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
