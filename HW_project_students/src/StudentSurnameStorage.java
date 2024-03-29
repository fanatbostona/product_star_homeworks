import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {
    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    public void studentCreated(Long id, String surname) {
        Set<Long> existingIDs = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIDs.add(id);
        surnamesTreeMap.put(surname,existingIDs);
    }

    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    public Set<Long> getStudentBySurnamesLessOrEqualThan(String surname) {
        Set <Long> res = surnamesTreeMap.headMap(surname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

    public Set<Long> getStudentSurnamesInDiapozon(String firstSurname, String secondSurname) {
        Set <Long> res = surnamesTreeMap.subMap(firstSurname, true, secondSurname, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

}
