package com.example.covid19;

public class VaccinationHistoryClass {

    String aadhaarCardNo;
    String vaccineType;
    String pincode;
    String registeredDate;

    VaccinationHistoryClass() { }

    public VaccinationHistoryClass(String aadhaarCardNo, String vaccineType, String pincode, String registeredDate) {
        this.aadhaarCardNo = aadhaarCardNo;
        this.vaccineType = vaccineType;
        this.pincode = pincode;
        this.registeredDate = registeredDate;
    }

    public String getAadhaarCardNo() {
        return aadhaarCardNo;
    }

    public void setAadhaarCardNo(String aadhaarCardNo) {
        this.aadhaarCardNo = aadhaarCardNo;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
