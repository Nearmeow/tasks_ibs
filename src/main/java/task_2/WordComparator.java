package task_2;

import java.util.Comparator;

public class WordComparator implements Comparator<String> {
    public int compare (String str1, String str2) {
        return str1.toLowerCase().compareTo(str2.toLowerCase());
    }
}
