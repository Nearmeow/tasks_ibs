package task_3;

import task_3.model.Company;
import task_3.model.Security;

import java.util.List;

public class InfoPrinter {

    public static void printCompaniesInfo(List<Company> companyList, String msg) {
        System.out.println(msg);
        for (Company com : companyList) {
            System.out.printf("%s - Дата основания %s\n", com.getName(), com.getFounded().format(CustomDateFormatter.PRINT_FORMATTER));
        }
    }

    public static void printOldSecurities(List<Security> oldSecurities) {
        System.out.println();
        System.out.println("Список ценных бумаг с истекшим сроком:");
        for (Security sec : oldSecurities) {
            System.out.printf("Код ценной бумаги - %s, дата истечения - %s, владелец - %s\n"
                    , sec.getCode()
                    , sec.getDate().format(CustomDateFormatter.PRINT_FORMATTER)
                    , sec.getOwner().getName()
            );
        }
    }

    public static void printSecuritiesByCurrency(List<Security> securityList) {
        System.out.println("Список ID владельцев и кодов ценных бумаг, использующих выбранную валюту:");
        for (Security sec : securityList) {
            System.out.printf("ID владельца - %d, код - %s\n", sec.getOwner().getId(), sec.getCode());
        }
    }
}
