package task_3;

import task_3.model.Company;
import task_3.model.Currency;
import task_3.model.Security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyHandler {

    private List<Company> companies;
    private List<Security> allSecurities;

    public CompanyHandler(List<Company> companies) {
        this.companies = companies;
        allSecurities = new ArrayList<>();
        getAllSecurities();
    }

    public List<Security> getOldSecurities() {
        return allSecurities.stream().filter(s -> s.getDate().isBefore(LocalDate.now())).collect(Collectors.toList());
    }

    public List<Company> getCompaniesAfterDate(LocalDate afterDate) {
        return companies.stream().filter(s -> s.getFounded().isAfter(afterDate)).collect(Collectors.toList());
    }

    public List<Security> getSecurityByCurrency(Integer currency) {
        return allSecurities.stream().filter(p -> p.getCurrencies().contains(Currency.values()[currency-1])).collect(Collectors.toList());
    }

    private void getAllSecurities() {
        for (Company com : companies) {
            allSecurities.addAll(com.getSecurities());
        }
    }
}
