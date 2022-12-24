package task_3.model;

import task_3.CustomDateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private LocalDate founded;
    private List<Security> securities;

    public Company(int id, String name, String address, String phoneNumber, String inn, LocalDate founded, List<Security> securities) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.founded = founded;
        this.securities = securities;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(String founded) {

        this.founded = LocalDate.parse(founded, CustomDateFormatter.PARSE_FORMATTER);
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        for (Security sec : securities) {
            sec.setOwner(this);
        }
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn='" + inn + '\'' +
                ", founded=" + founded +
                ", securities=" + securities +
                '}';
    }
}
