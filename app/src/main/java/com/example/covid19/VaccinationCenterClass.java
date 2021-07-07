package com.example.covid19;

public class VaccinationCenterClass {

    String centerId;
    String stateName;
    String centerName;
    String address;
    String vaccinationType;
    String pincode;
    String availability;
    String dose1;
    String dose2;
    String age;
    String fee;

    public VaccinationCenterClass(String centerId, String stateName, String centerName, String address, String vaccinationType, String pincode, String availability, String dose1, String dose2, String age, String fee) {
        this.centerId = centerId;
        this.stateName = stateName;
        this.centerName = centerName;
        this.address = address;
        this.vaccinationType = vaccinationType;
        this.pincode = pincode;
        this.availability = availability;
        this.dose1 = dose1;
        this.dose2 = dose2;
        this.age = age;
        this.fee = fee;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    public String getAvailability() {
        return availability;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDose1() {
        return dose1;
    }

    public void setDose1(String dose1) {
        this.dose1 = dose1;
    }

    public String getDose2() {
        return dose2;
    }

    public void setDose2(String dose2) {
        this.dose2 = dose2;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
