package task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private void processPath() {
        System.out.println("Enter the path to the text file or 'exit' for exit");
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
