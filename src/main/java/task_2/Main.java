package task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileNameReader fileNameReader = new FileNameReader(reader);
            Path path = fileNameReader.getPath();

            WordProcessor wordProcessor = new WordProcessor(path);
            wordProcessor.printWordStatistic();
            wordProcessor.printMosFreqWords();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
