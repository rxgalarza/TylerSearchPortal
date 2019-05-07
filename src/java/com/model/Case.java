/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author Rodolfo
 */
public class Case implements Serializable{
    private String nameLast;
    private String nameFirst;
    private String PartyID;
    private String citationNumber;
    private String ticketDate;
     private String BusinessName;
    private String appearByDate;
    private String caseNbr;
    private int   index;
    private String filedDate;
    private String caseNumber;
    private String city;
    private String state;
    private String zip;
    private String road;
    private String VehicleLicenseNumber;
    private String licenseNumber;
    
    
    
    
    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getPartyID() {
        return PartyID;
    }

    public void setPartyID(String PartyID) {
        this.PartyID = PartyID;
    }

    public String getCitationNumber() {
        return citationNumber;
    }

    public void setCitationNumber(String citationNumber) {
        this.citationNumber = citationNumber;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }
    
     public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    public String getAppearByDate() {
        return appearByDate;
    }

    public void setAppearByDate(String appearByDate) {
        this.appearByDate = appearByDate;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCaseNbr() {
        return caseNbr;
    }

    public void setCaseNbr(String caseNbr) {
        this.caseNbr = caseNbr;
    }

    public String getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(String filedDate) {
        this.filedDate = filedDate;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getVehicleLicenseNumber() {
        return VehicleLicenseNumber;
    }

    public void setVehicleLicenseNumber(String VehicleLicenseNumber) {
        this.VehicleLicenseNumber = VehicleLicenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    
    
}
