import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {

        Player firstPlayer = new Player("Jrue", "Holiday", 4, "Point guard");
        Player secondPlayer = new Player("Derrick", "White", 9, "Shooting guard");
        Player thirdPlayer = new Player("Jaylen", "Brown", 7, "Small forward");
        Player fourthPlayer = new Player("Jayson", "Tatum", 0, "Power forward");
        Player fifthPlayer = new Player("Kristaps", "Porzingis", 8, "Center");

        Team bostonCeltics = new Team("Boston Celtics", firstPlayer, secondPlayer, thirdPlayer, fourthPlayer, fifthPlayer);

        File file = new File("/tmp/team.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
        Marshaller jaxBMarshaller = jaxbContext.createMarshaller();
        jaxBMarshaller.marshal(firstPlayer,file);



    }
}