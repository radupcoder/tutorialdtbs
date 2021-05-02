package com.tutorialdtbs;

import java.io.Serializable;

public class Company implements Serializable {

    private String companyName;
    private int numberOfEmployees;

    public Company(String companyName, int numberOfEmployees) {
        this.companyName = companyName;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
