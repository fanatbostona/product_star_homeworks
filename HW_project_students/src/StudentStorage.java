import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStorage {
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();


    private Long currentID = 0L ;

    public Long createStudent(Student student) {
        Long nextID = getNextID();
        studentStorageMap.put(nextID,student);
        studentSurnameStorage.studentCreated(nextID,student.getSurname());
        return nextID;
    }

    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        }
        else {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student);
            return true;
        }
    }

    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public void search(String data) {
        if (data == "") {
            printAll();
        }
        else {
            String[] parameters = data.split(",");
            if (parameters.length == 1) {
                Set<Long> students = studentSurnameStorage.getStudentBySurnamesLessOrEqualThan(parameters[0]);
                for (Long studentID : students) {
                    Student student = studentStorageMap.get(studentID);
                    System.out.println(student);
                }
            }
            else {
                Set<Long> students = studentSurnameStorage.getStudentSurnamesInDiapozon(parameters[0], parameters[1]);
                for (Long studentID : students) {
                    Student student = studentStorageMap.get(studentID);
                    System.out.println(student);
                }
            }
        }
    }
    public Long getNextID() {
        currentID = currentID + 1;
        return currentID;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap (Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    public Map<String, Long> getCountByCourse() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCourse(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2
                ));
        return res;
    }

    public Map<String,Long> getCountByCities() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCity(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2
                ));
        return res;
    }



}
