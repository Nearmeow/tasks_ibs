package task_3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import task_3.CustomDateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Security {

    private String name;

    //@JsonIgnoreProperties
    private Company owner;

    @JsonProperty("currency")
    private List<Currency> currencies;
    private String code;
    private LocalDate date;

    public Security(String name, List<Currency> currencies, String code, LocalDate date) {
        this.name = name;
        this.currencies = currencies;
        this.code = code;
        this.date = date;
    }

    public Security() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getOwner() {
        return owner;
    }

    public void setOwner(Company owner) {
        this.owner = owner;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, CustomDateFormatter.PARSE_FORMATTER);
    }

    @Override
    public String toString() {
        return "Security{" +
                "name='" + name + '\'' +
                ", owner=" + owner.getName() +
                ", currencies=" + currencies +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
