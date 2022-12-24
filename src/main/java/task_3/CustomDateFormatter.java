package task_3;

import java.time.format.DateTimeFormatter;

public class CustomDateFormatter {
    public static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("[dd.MM.yyyy][dd.MM.yy][dd/MM/yyyy][dd/MM/yy]");
    public static final DateTimeFormatter PRINT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");
}
