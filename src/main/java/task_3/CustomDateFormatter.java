package task_3;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class CustomDateFormatter {
    //public static final DateTimeFormatter PARSE_FORMATTER = DateTimeFormatter.ofPattern("[dd.MM.yyyy][dd.MM.yy][dd/MM/yyyy][dd/MM/yy]");
    public static final DateTimeFormatter PRINT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

    public static final DateTimeFormatter PARSE_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("[dd.MM.][dd.MM.][dd/MM/][dd/MM/]")
            .appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 4, 1971)
            .toFormatter();
}
