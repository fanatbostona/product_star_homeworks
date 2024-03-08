import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player implements Serializable
{
    private final static long serialVersionID = 1L;
    private String name;
    private String Surname;

    private int jerseyNumber;

    private String position;
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
    @XmlElement
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    @XmlElement
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public Player(String name, String surname, int jerseyNumber, String position) {
        this.name = name;
        Surname = surname;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
    }
}
