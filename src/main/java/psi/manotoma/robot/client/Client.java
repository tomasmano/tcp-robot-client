package psi.manotoma.robot.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Socket client = null;
        BufferedWriter out = null;
        BufferedReader in = null;

        try {
            client = new Socket(servername, port);
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
        } catch (IOException e) {
            LOG.error("An error occured during creating socket: ",e.getMessage());
        }
        LOG.info("Ack response from [{}]: {}", in.readLine(), client.toString());
        String msg = null; // TODO
        LOG.info("Sending: {}", msg);
        out.write(msg);
        out.flush();
        LOG.info("Response from [{}]: {}", in.readLine(), client.toString());

        out.close();
        in.close();
        client.close();
    }
}
