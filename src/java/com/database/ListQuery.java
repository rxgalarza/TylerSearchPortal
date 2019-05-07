/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.model.Case;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Rodolfo
 */
public class ListQuery extends DBConnection implements Serializable {

    public List<Case> listCase(String query) {
        List<Case> list = new ArrayList<Case>();

        try {
           ps = (PreparedStatement) connect().prepareStatement("select * from test1 where CitationNumber = '" + query + "' limit 0, 1000 option max_matches=1000");
            
          Case c;
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {
                c = new Case();
                c.setNameFirst(rs.getString("nameFirst"));
                c.setNameLast(rs.getString("nameLast"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                c.setPartyID(rs.getString("PartyID"));
                c.setTicketDate(rs.getString("ticketDate"));
                c.setAppearByDate(rs.getString("AppearDate"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setZip(rs.getString("Zip"));
                c.setRoad(rs.getString("Road"));
                c.setVehicleLicenseNumber(rs.getString("VehicleLicenseNumber"));
                System.out.println(c.getCity());
                c.setIndex(i);
                i++;
                list.add(c);
            }

            return list;

        } catch (Exception e) {

            return null;
        }
    }

    public List<Case> listCase2(String nameFirst, String nameLast) {
        List<Case> list = new ArrayList<Case>();
        try {
            //   ps = (PreparedStatement) connect().prepareStatement("select * from "
            //         + "test1 where NameFirst match ('"+ NameFirst + "') and NameLast match ('" + NameLast + "')");

            ps = (PreparedStatement) connect().prepareStatement("select * from test1 where nameFirst= '" + nameFirst + "' and nameLast = '" + nameLast + "' limit 0, 1000 option max_matches=1000");

            //  ps = (PreparedStatement) connect().prepareStatement("select * from test1 where match('')");
            Case c;
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Case();
                c.setNameFirst(rs.getString("nameFirst"));
                c.setNameLast(rs.getString("nameLast"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                c.setPartyID(rs.getString("PartyID"));
                c.setTicketDate(rs.getString("ticketDate"));
                c.setAppearByDate(rs.getString("appearDate"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setZip(rs.getString("Zip"));
                c.setRoad(rs.getString("Road"));
                c.setLicenseNumber(rs.getString("VehicleLicenseNumber"));
                list.add(c);
            }
            ps = null;
            rs = null;
            return list;

        } catch (Exception e) {

            return null;
        }

    }

    public List<Case> listCase3(String businessName) {
        List<Case> list = new ArrayList<Case>();

        try {
            //   ps = (PreparedStatement) connect().prepareStatement("select * from "
            //         + "test1 where NameFirst match ('"+ NameFirst + "') and NameLast match ('" + NameLast + "')");

            ps = (PreparedStatement) connect().prepareStatement("select * from test2 where nameLast = '" + businessName + "' limit 0, 1000 option max_matches=1000");

            //  ps = (PreparedStatement) connect().prepareStatement("select * from test1 where match('')");
            Case c;
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Case();
                c.setNameLast(rs.getString("nameLast"));
                c.setCaseNbr(rs.getString("CaseNbr"));
                c.setFiledDate(rs.getString("FiledDate"));
                // c.setPartyID(rs.getString("PartyID"));
                list.add(c);
            }
            ps = null;
            rs = null;
            return list;

        } catch (Exception e) {

            return null;
        }
    }
    
    public List<Case> listCase4(String caseNumber) {
        List<Case> list = new ArrayList<Case>();

        try {
            //   ps = (PreparedStatement) connect().prepareStatement("select * from "
            //         + "test1 where NameFirst match ('"+ NameFirst + "') and NameLast match ('" + NameLast + "')");

            ps = (PreparedStatement) connect().prepareStatement("select * from test3 where CaseNbr = '" + caseNumber + "' limit 0, 1000 option max_matches=1000");

            //  ps = (PreparedStatement) connect().prepareStatement("select * from test1 where match('')");
            Case c;
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Case();
                c.setNameFirst(rs.getString("NameFirst"));
                c.setNameLast(rs.getString("NameLast"));
                c.setCaseNbr(rs.getString("CaseNbr"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                list.add(c);
            }
            ps = null;
            rs = null;
            return list;

        } catch (Exception e) {

            return null;
        }
    }

    public List<Case> listCaseWildCard(String query,int flag, String query2) {
        
       List<Case> list = new ArrayList<Case>();
        
        try{
            if(flag==1){
                 ps = (PreparedStatement) connect().prepareStatement("select * from test1  where match ('@nameFirst "+ query2 + "') and nameLast = '" + query + "' limit 0, 1000 option max_matches=1000");
                 
            }
            else if(flag==0){
                 ps = (PreparedStatement) connect().prepareStatement("select * from test1  where match ('@nameLast "+ query2 + "') and nameFirst = '" + query + "' limit 0, 1000 option max_matches=1000");
            }
            else if(flag==2){
                 ps = (PreparedStatement) connect().prepareStatement("select * from test1  where match ('@citationNumber "+ query + "') limit 0, 1000 option max_matches=1000");
            }
            Case c;
            rs = ps.executeQuery();
            int i = 0;
           
            while(rs.next()){
                c = new Case();
                c.setNameFirst(rs.getString("nameFirst"));
                c.setNameLast(rs.getString("nameLast"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                c.setPartyID(rs.getString("PartyID"));
                c.setTicketDate(rs.getString("ticketDate"));
                c.setAppearByDate(rs.getString("AppearDate"));
                
                c.setIndex(i);
                i++;
                list.add(c);
            }
            
            return list;
                   
        }catch(Exception e){
            
            return null;
        }
    }
    
    
    public List<Case> listCaseWildCardBusiness(String query) {
       List<Case> list = new ArrayList<Case>();
        System.out.println("LIST CASE WILD CARD BUSINESS");
        try{
            ps = (PreparedStatement) connect().prepareStatement("select * from test2 where match('@nameLast "+ query + "') limit 0, 1000 option max_matches=1000");
            Case c;
            rs = ps.executeQuery();
            int i = 0;
           
            while(rs.next()){
                c = new Case();
                c.setNameLast(rs.getString("nameLast"));
                c.setCaseNbr(rs.getString("CaseNbr"));
                c.setFiledDate(rs.getString("FiledDate"));
                c.setIndex(i);
                i++;
                list.add(c);
            }
            
            return list;
                   
        }catch(Exception e){
            
            return null;
        }
    }
    
    
    public List<Case> listCaseWildCardCitationNumber(String query) {
       List<Case> list = new ArrayList<Case>();
        System.out.println("LIST CASE WILD CARD BUSINESS");
        try{
            ps = (PreparedStatement) connect().prepareStatement("select * from test2 where match('@citationNumber "+ query + "') limit 0, 1000 option max_matches=1000");
            Case c;
            rs = ps.executeQuery();
            int i = 0;
           
            while(rs.next()){
                c = new Case();
                c.setNameLast(rs.getString("nameLast"));
                c.setCaseNbr(rs.getString("CaseNbr"));
                c.setFiledDate(rs.getString("FiledDate"));
                c.setIndex(i);
                i++;
                list.add(c);
            }
            
            return list;
                   
        }catch(Exception e){
            
            return null;
        }
    }
    
    
     public List<Case> listCaseWildCardCaseNumber(String query) {
       List<Case> list = new ArrayList<Case>();
       System.out.println("Case Number");
        try{
            ps = (PreparedStatement) connect().prepareStatement("select * from test3 where match('"+ query + "') limit 0, 1000 option max_matches=1000");
            Case c;
            rs = ps.executeQuery();
            int i = 0;
           
            while(rs.next()){
                c = new Case();
                c.setNameLast(rs.getString("nameLast"));
                c.setNameFirst(rs.getString("nameFirst"));
                c.setCaseNbr(rs.getString("CaseNbr"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                //c.setFiledDate(rs.getString("FiledDate"));
                c.setIndex(i);
                i++;
                list.add(c);
            }
            
            return list;
                   
        }catch(Exception e){
            
            return null;
        }
    }
}
