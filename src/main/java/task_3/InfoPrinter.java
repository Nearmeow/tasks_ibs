package task_3;

import task_3.model.Company;
import task_3.model.Security;

import java.util.List;

public class InfoPrinter {

    public static void printCompaniesInfo(List<Company> companyList, String msg) {
        System.out.println(msg);
        companyList.forEach(s -> System.out.printf("%s - Дата основания %s\n", s.getName(), s.getFounded().format(CustomDateFormatter.PRINT_FORMATTER)));
    }

    public static void printOldSecurities(List<Security> oldSecurities) {
        System.out.println();
        System.out.println("Список ценных бумаг с истекшим сроком:");
        oldSecurities.forEach(s -> System.out.printf("Код ценной бумаги - %s, дата истечения - %s, владелец - %s\n"
                , s.getCode()
                , s.getDate().format(CustomDateFormatter.PRINT_FORMATTER)
                , s.getOwner().getName()
        ));
        System.out.println("Общее количество ценных бумаг с истекшим сроком - " + oldSecurities.size());
    }

    public static void printSecuritiesByCurrency(List<Security> securityList) {
        System.out.println("Список ID владельцев и кодов ценных бумаг, использующих выбранную валюту:");
        securityList.forEach(s -> System.out.printf("ID владельца - %d, код - %s\n", s.getOwner().getId(), s.getCode()));
    }
}
