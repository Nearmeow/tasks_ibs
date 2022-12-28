package task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FileNameReader {
    private BufferedReader reader;
    private Path path;

    public FileNameReader(BufferedReader reader) {
        this.reader = reader;
    }

    public Path getPath() {
        processPath();
        return path;
    }

    public LocalDate readDateAfter() {
        System.out.println();
        System.out.println("Введите дату в одном из форматов «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»:");
        LocalDate localDate = null;
        try {
            String stringDate = reader.readLine();
            localDate = LocalDate.parse(stringDate, CustomDateFormatter.PARSE_FORMATTER);
        } catch (DateTimeParseException exception) {
            System.out.println("Введена неверная дата!");
            localDate = readDateAfter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localDate;
    }

    public Integer readCurrency() {
        System.out.println();
        System.out.println("Введите код валюты, для вывода ценных бумаг:\n" +
                "1 - для USD\n" +
                "2 - для EU\n" +
                "3 - для RUB");
        Integer cur = null;
        try {
            cur = Integer.parseInt(reader.readLine());
            if (cur != 1 && cur != 2 && cur != 3) {
                System.out.println("Введен неверный код валюты!");
                cur = readCurrency();
            }
        } catch (NumberFormatException exception) {
            System.out.println("Введен неверный код валюты!");
            cur = readCurrency();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cur;
    }

    private void processPath() {
        System.out.println("Enter the path to the json file or 'exit' for exit:");
        String fileName;
        try {
            fileName = reader.readLine();
            if (isValidPath(fileName)) {
                path = Path.of(fileName).toAbsolutePath();
            } else {
                isExit(fileName);
                System.out.println("Invalid path or empty file");
                processPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidPath(String fileName) {
        Path sourceFile = Paths.get(fileName);
        return Files.exists(sourceFile) && sourceFile.toFile().length() > 0;
    }

    private void isExit(String fileName) {
        if (fileName.equalsIgnoreCase("exit")) {
            System.out.println("Closing...");
            System.exit(0);
        }
    }
}
