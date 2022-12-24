package task_3;

import com.fasterxml.jackson.databind.ObjectMapper;
import task_3.model.Company;
import task_3.model.ResultList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;


public class App {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ObjectMapper mapper = new ObjectMapper();
            FileNameReader fileNameReader = new FileNameReader(reader);
            Path path = fileNameReader.getPath();
            ResultList resultList = mapper.readValue(path.toFile(), ResultList.class);
            List<Company> companies = resultList.getCompanyList();
            CompanyHandler companyHandler = new CompanyHandler(companies);

            InfoPrinter.printCompaniesInfo(companies, "Список компаний:");
            InfoPrinter.printOldSecurities(companyHandler.getOldSecurities());

            InfoPrinter.printCompaniesInfo(companyHandler.getCompaniesAfterDate(fileNameReader.readDateAfter())
                    , "Компании, основанные после указанной даты:"
            );
            InfoPrinter.printSecuritiesByCurrency(companyHandler.getSecurityByCurrency(fileNameReader.readCurrency()));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
