import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Team implements Serializable
{
    private final static long serialVersionID = 1L;

    private String name;
    @XmlElement
    public String getName() {
        return name;
    }

    private Player firstPlayer;

    private Player secondPlayer;

    private Player thirdPlayer;

    private Player fouthPlayer;

    private Player fifthPlayer;
    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public Team(String name, Player firstPlayer, Player secondPlayer, Player thirdPlayer, Player fouthPlayer, Player fifthPlayer) {
        this.name = name;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
        this.fouthPlayer = fouthPlayer;
        this.fifthPlayer = fifthPlayer;
    }

    @XmlElement
    public Player getFirstPlayer() {
        return firstPlayer;
    }
    @XmlElement
    public Player getSecondPlayer() {
        return secondPlayer;
    }
    @XmlElement
    public Player getThirdPlayer() {
        return thirdPlayer;
    }
    @XmlElement
    public Player getFouthPlayer() {
        return fouthPlayer;
    }
    @XmlElement
    public Player getFifthPlayer() {
        return fifthPlayer;
    }
}
