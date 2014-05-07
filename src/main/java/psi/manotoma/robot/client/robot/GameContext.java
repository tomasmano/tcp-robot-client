package psi.manotoma.robot.client.robot;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GameContext {

    private Coordinates currentCoordinates;
    private Status lastStatus;

    public GameContext() {
    }

    public Coordinates getCurrentCoordinates() {
        return currentCoordinates;
    }

    public GameContext setCurrentCoordinates(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
        return this;
    }

    public Status getLastStatus() {
        return lastStatus;
    }

    public GameContext setLastStatus(Status lastStatus) {
        this.lastStatus = lastStatus;
        return this;
    }

    @Override
    public String toString() {
        return "GameContext{" + "currentCoordinates=" + currentCoordinates + '}';
    }
}
