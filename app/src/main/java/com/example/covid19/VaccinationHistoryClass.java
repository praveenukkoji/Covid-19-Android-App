package com.example.covid19;

public class VaccinationHistoryClass {

    int injectionImage;
    String aadhaarCardNo;
    String registeredDate;

    public VaccinationHistoryClass(int injectionImage, String aadhaarCardNo, String registeredDate) {

        this.injectionImage = injectionImage;
        this.aadhaarCardNo = aadhaarCardNo;
        this.registeredDate = registeredDate;
    }

    public int getInjectionImage() {
        return injectionImage;
    }

    public void setInjectionImage(int injectionImage) {
        this.injectionImage = injectionImage;
    }

    public String getAadhaarCardNo() {
        return aadhaarCardNo;
    }

    public void setAadhaarCardNo(String aadhaarCardNo) {
        this.aadhaarCardNo = aadhaarCardNo;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
