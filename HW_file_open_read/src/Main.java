import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        listenClient();

    }
    private static void listenClient() {
        for (; ; ) {
            System.out.print("Введите 1 для поиска, 2 для сохранения и 'выход' для выхода: ");
            String searchType = in.nextLine();
            if (searchType.equals("1")) {
                System.out.print("Введите путь для поиска c именем файла: ");
                String dir = in.nextLine();
                if (isValid(dir)) {
                    readFile(dir);
                } else {
                    continue;
                }
            }
            if (searchType.equals("2")) {
                System.out.print("Введите путь для сохранения c именем файла: ");
                String dir = in.nextLine();
                if (!isValid(dir)) {
                    continue;
                }
                System.out.print("Введите содержимое файла: ");
                String text = in.nextLine();
                if (!isValid(text)) {
                    continue;
                }
                writeFile(dir, text);
            }
            if (searchType.equalsIgnoreCase("выход")) {
                break;
            }
        }
    }

    public static boolean isValid(String dir) {
        return !dir.isEmpty();
    }

    public static void writeFile(String dir, String text) {
        File file = new File(dir);
        if (file.exists()) {
            System.out.println("!!! Файл будет перетерт !!!");
        }
        try (FileWriter writer = new FileWriter(dir, false)) {
            long start = System.currentTimeMillis();
            writer.write(text);
            writer.flush();
            long finish = System.currentTimeMillis();
            System.out.println("запись файла заняла: " + (finish - start) + " миллисекунд");
            File currentFile = new File(dir);
            if (currentFile.exists()) {
                System.out.println("файл весит: " + currentFile.length() + " байта");
            } else {
                System.out.println("запись не удалась:");
            }
        } catch (IOException ex) {
            System.out.println("запись не удалась: " + ex.getMessage());
        }

    }

    public static void readFile(String dir) {
        try (FileReader reader = new FileReader(dir)) {
            System.out.println("Содержимое вашего файла: ");
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println("чтение файло не удалось: " + ex.getMessage());
        }
    }
}