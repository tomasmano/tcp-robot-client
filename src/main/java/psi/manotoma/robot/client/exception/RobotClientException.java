package psi.manotoma.robot.client.exception;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotClientException extends RuntimeException{

    public RobotClientException() {
    }

    public RobotClientException(String message) {
        super(message);
    }

    public RobotClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public RobotClientException(Throwable cause) {
        super(cause);
    }

    public RobotClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
