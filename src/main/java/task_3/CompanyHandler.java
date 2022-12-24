package task_3;

import task_3.model.Company;
import task_3.model.Currency;
import task_3.model.Security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyHandler {

    private List<Company> companies;
    private List<Security> allSecurities;

    public CompanyHandler(List<Company> companies) {
        this.companies = companies;
        allSecurities = new ArrayList<>();
        getAllSecurities();
    }

    public List<Security> getOldSecurities() {
        List<Security> oldSecurities = new ArrayList<>();
        for (Security sec : allSecurities) {
            if (sec.getDate().isBefore(LocalDate.now())) {
                oldSecurities.add(sec);
            }

        }
        return oldSecurities;
    }

    public List<Company> getCompaniesAfterDate(LocalDate afterDate) {
        List<Company> resultList = new ArrayList<>();
        for (Company com : companies) {
            if (com.getFounded().isAfter(afterDate)) {
                resultList.add(com);
            }
        }
        return resultList;
    }

    public List<Security> getSecurityByCurrency(Integer currency) {
        Map<Integer, List<Security>> secMapByCurrency = new HashMap<>();
        secMapByCurrency.put(1, new ArrayList<>());
        secMapByCurrency.put(2, new ArrayList<>());
        secMapByCurrency.put(3, new ArrayList<>());
        for (Security sec : allSecurities) {
            if (sec.getCurrencies().contains(Currency.EU)) {
                secMapByCurrency.get(1).add(sec);
            } else if (sec.getCurrencies().contains(Currency.USD)) {
                secMapByCurrency.get(2).add(sec);
            } else if (sec.getCurrencies().contains(Currency.RUB)) {
                secMapByCurrency.get(3).add(sec);
            }
        }
        return  secMapByCurrency.get(currency);
    }

    private void getAllSecurities() {
        for (Company com : companies) {
            allSecurities.addAll(com.getSecurities());
        }
    }
}
