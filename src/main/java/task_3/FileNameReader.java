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
    private Integer currency;
    private LocalDate dateAfter;

    public FileNameReader(BufferedReader reader) {
        this.reader = reader;
    }

    public Path getPath() {
        processPath();
        return path;
    }

    public Integer getCurrency() {
        readCurrency();
        return currency;
    }

    public LocalDate getDateAfter() {
        readDateAfter();
        System.out.println(dateAfter);
        return dateAfter;
    }

    private void readDateAfter() {
        System.out.println();
        System.out.println("Введите дату в одном из форматов «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»:");
        try {
            String stringDate = reader.readLine();
            dateAfter = LocalDate.parse(stringDate, CustomDateFormatter.PARSE_FORMATTER);
        } catch (DateTimeParseException exception) {
            System.out.println("Введена неверная дата!");
            readDateAfter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCurrency() {
        System.out.println();
        System.out.println("Введите код валюты, для вывода ценных бумаг:\n" +
                "1 - для EU\n" +
                "2 - для USD\n" +
                "3 - для RUB");
        try {
            currency = Integer.parseInt(reader.readLine());
            if (currency != 1 && currency != 2 && currency != 3) {
                System.out.println("Введен неверный код валюты!");
                readCurrency();
            }
        } catch (NumberFormatException exception) {
            System.out.println("Введен неверный код валюты!");
            readCurrency();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
