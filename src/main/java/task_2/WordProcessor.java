package task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class WordProcessor {

    private Path path;
    private Map<String, Integer> map;

    public WordProcessor(Path path) {
        this.path = path;
        map = new TreeMap<>(new WordComparator());
        getWords();
    }

    public void printWordStatistic() {
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void printMosFreqWords() {
        int maxFrequency = getMaxFreq();
        for (Map.Entry<String, Integer> elem : map.entrySet()) {
            if (elem.getValue() == maxFrequency) {
                System.out.printf("Чаще всего встречается слово %s, количество - %d\n",elem.getKey(), elem.getValue());
            }
        }
    }

    private void getWords() {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                String[] arr = line.split("[^A-Za-zА-яЁё]".strip());
                for (String elem : arr) {
                    putElemToMap(elem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void putElemToMap(String elem) {
        if (!elem.equals("")) {
            Integer count = getCount(map.get(elem));
            map.put(elem, count);
        }
    }

    private Integer getCount(Integer count) {
        if (count != null) {
            count++;
        } else {
            count = 1;
        }
        return count;
    }

    private int getMaxFreq() {
        int max = 0;
        for (Map.Entry<String, Integer> elem : map.entrySet()) {
            if (elem.getValue() > max) {
                max = elem.getValue();
            }
        }
        return max;
    }
}
