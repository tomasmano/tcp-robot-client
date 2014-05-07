package psi.manotoma.robot.client.io;

import java.io.BufferedReader;
import java.io.Reader;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class RobotResponseReader extends BufferedReader {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RobotResponseReader.class);
    private static final int NAME_BEGIN_INDEX = 16;

    public RobotResponseReader(Reader in) {
        super(in);
    }

    public RobotResponseReader(Reader in, int sz) {
        super(in, sz);
    }

    public String readName() {
        String name = "";
        String line;
        try {
            line = readLine();
            name = line.substring(NAME_BEGIN_INDEX, line.length() - 1);
        } catch (Exception ex) {
            LOG.error("An error occured during reading a name: []", ex);
            System.exit(-1);
        }
        return name;
    }
}
