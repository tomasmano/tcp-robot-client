package psi.manotoma.robot.client;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robot.client.robot.RobotController;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Client {

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws IOException {
        init(3999, "localhost");
    }

    public static void init(int port, String servername) throws IOException {
        RobotController controller = RobotController.init("localhost", 3999);

        System.out.println(controller);
        LOG.info("Sending STEP REQUEST with response: {}", controller.step());

    }
}
