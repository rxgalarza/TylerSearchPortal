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
    
    
}
