import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage = new StudentStorage();
    public void processCommand(Command command)
    {
        Action action = command.getAction();
        switch (action) {
            case CREATE -> {
                processCreateCommand(command);
                break;
            }
            case UPDATE -> {
                processUpdateCommand(command);
                break;
            }
            case DELETE -> {
                processDeleteCommand(command);
                break;
            }
            case STATS_BY_COURSE -> {
                processStatsByCourse(command);
                break;
            }
            case STATS_BY_CITIES -> {
                processStatsByCities(command);
                break;
            }
            case SEARCH -> {
                processSearchCommand(command);
                break;
            }
            default -> {
                System.out.println("Действие " + command + " не поддерживается");
                break;
            }
        }
        System.out.println("Обработка команды. " +
                "Действие: " + command.getAction().name()
                + ", данные: " + command.getData());
    }

    private void processStatsByCities(Command command) {
        Map<String, Long> data = studentStorage.getCountByCities();
        studentStorage.printMap(data);
    }

    private void processSearchCommand(Command command) {
        String data = command.getData();
        studentStorage.search(data);
    }
    private void processStatsByCourse(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }
    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (Integer.valueOf(dataArray[4]) <= 0) {
            System.out.println("Ошибка. Возраст введён неверно");
        }
        else {
            Student student = new Student();
            student.setSurname(dataArray[0]);
            student.setName(dataArray[1]);
            student.setCourse(dataArray[2]);
            student.setCity(dataArray[3]);
            student.setAge(Integer.valueOf(dataArray[4]));

            studentStorage.createStudent(student);
            studentStorage.printAll();
        }
    }

    public void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (Long.valueOf(dataArray[0]) <= 0) {
            System.out.println("Ошибка. Неверно введён ID");
        }
        else if (Integer.valueOf(dataArray[5]) <= 0) {
            System.out.println("Ошибка. Неверно введён возраст");
        }
        else {
            Long id = Long.valueOf(dataArray[0]);
            Student student = new Student();
            student.setSurname(dataArray[1]);
            student.setName(dataArray[2]);
            student.setCourse(dataArray[3]);
            student.setCity(dataArray[4]);
            student.setAge(Integer.valueOf(dataArray[5]));

            studentStorage.updateStudent(id, student);
            studentStorage.printAll();
        }
    }

    public void processDeleteCommand(Command command) {
        String data = command.getData();
        if (Long.valueOf(data) <= 0) {
            System.out.println("Ошибка. Неверно введён ID");
        }
        else {
            Long id = Long.valueOf(data);
            studentStorage.deleteStudent(id);
            studentStorage.printAll();
        }

    }
}
