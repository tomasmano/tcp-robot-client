package psi.manotoma.robot.client.robot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.rmi.server.ServerCloneException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psi.manotoma.robot.client.io.RobotResponseReader;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotController {

    private static final Logger LOG = LoggerFactory.getLogger(RobotController.class);
    private Socket client;
    private BufferedWriter out;
    private RobotResponseReader reader;
    private String robotName;
    private static final String CRLF = "\r\n";

    private RobotController(String servername, int port) {
        try {
            client = new Socket(servername, port);
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            reader = new RobotResponseReader(new InputStreamReader(
                    client.getInputStream()));
            LOG.info("Ack response from [{}].", client.toString());
            robotName = reader.readName();
        } catch (IOException e) {
            LOG.error("An error occured during creating socket: ", e.getMessage());
            System.exit(-1);
        }
    }

    public static RobotController init(String servername, int port) {
        return new RobotController(servername, port);
    }

    public String step() {
        try {
            out.write(robotName + " " + "KROK" + CRLF);
            out.flush();
        } catch (IOException ex) {
            LOG.error("An error occured during step request sending: [{}]", ex);
            close();
            System.exit(-1);
        }
        return getResponse();
    }

    public void turnLeft(GameContext ctx) {
    }

    public void repair(int nProcessor, GameContext ctx) {
    }

    public void pickup(GameContext ctx) {
    }

    public Socket getClient() {
        return client;
    }

    public void close() {
        try {
            out.close();
            reader.close();
            client.close();
        } catch (IOException ex) {
            LOG.error("An error occured during closing socket and streams: [{}]", ex);
            System.exit(-1);
        }
    }

    private String getResponse() {
        String response = null;
        try {
            response = reader.readLine();
        } catch (IOException ex) {
            LOG.error("An error occured during reading response: [{}]", ex);
            close();
            System.exit(-1);
        }
        return response;
    }

    @Override
    public String toString() {
        return "RobotController{" + "client=" + client + ", robotName=" + robotName + '}';
    }
}
