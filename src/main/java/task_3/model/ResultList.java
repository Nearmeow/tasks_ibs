package task_3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultList {
    @JsonProperty("companies")
    private List<Company> companyList;

    public ResultList() {
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    @Override
    public String toString() {
        return "ResultList{" +
                "companyList=" + companyList +
                '}';
    }
}
