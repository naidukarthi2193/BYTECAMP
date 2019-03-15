package com.example.crime_fight.Models;



public class ComplainModel {

    public String name;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAdharnumber() {
        return adharnumber;
    }

    public String getComplain() {
        return complain;
    }

    public String getStatus() {
        return status;
    }

    public String getPoliceStn() {
        return policeStn;
    }

    public String address;
    public String adharnumber;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdharnumber(String adharnumber) {
        this.adharnumber = adharnumber;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPoliceStn(String policeStn) {
        this.policeStn = policeStn;
    }

    public String complain;

    public ComplainModel(String name, String address, String adharnumber, String complain, String status, String policeStn) {
        this.name = name;
        this.address = address;
        this.adharnumber = adharnumber;
        this.complain = complain;
        this.status = status;
        this.policeStn = policeStn;
    }

    public  ComplainModel(){}

    public String status;
    public String policeStn;





}
