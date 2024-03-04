import java.util.ArrayList;
import java.util.List;

public class Stable <T>{
    private List<T> horses = new ArrayList<>();

    public T addHorse(T horse) {
        horses.add(horse);
        return horse;
    }

    public void addHorses(List<T> anotherHorses) {
        horses.addAll(anotherHorses);
    }

    public int countHorses() {
        return horses.size();
    }

    public List<T> getHorses() {
        return horses;
    }
}
