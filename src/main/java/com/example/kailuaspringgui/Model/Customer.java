package com.example.kailuaspringgui.Model;



public class Customer {
    private int customerID;
    private String fName;
    private String lName;
    private String address;
    private int zipCode;
    private String city;
    private int phoneNumber;
    private String eMail;
    private int driverLicenseNumber;
    private String driverSinceDate;

    public Customer(){}

    public Customer(int customerID, String fName, String lName,
                    String address, int zipCode, String city, int phoneNumber,
                    String eMail, int driverLicenseNumber, String driverSinceDate) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverSinceDate = driverSinceDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(int driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverSinceDate() {
        return driverSinceDate;
    }

    public void setDriverSinceDate(String driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }
}
