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
public class ListQuery extends DBConnection implements Serializable{
    
    public List<Case> listCase(String query){
        List<Case> list = new ArrayList<Case>();
        try{
            ps = (PreparedStatement) connect().prepareStatement("select * from test1 where "
                    + "match('"+ query + "')");
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
    
    
     public List<Case> listCase2(String nameFirst, String nameLast){
        List<Case> list = new ArrayList<Case>();
        try{
         //   ps = (PreparedStatement) connect().prepareStatement("select * from "
          //         + "test1 where NameFirst match ('"+ NameFirst + "') and NameLast match ('" + NameLast + "')");
           
   ps = (PreparedStatement) connect().prepareStatement("select * from test1 where nameFirst= ('"+nameFirst+"') and nameLast = ('"+nameLast+"')");
          
             //  ps = (PreparedStatement) connect().prepareStatement("select * from test1 where match('')");
                 Case c;
            rs = ps.executeQuery();
           
            while(rs.next()){
                c = new Case();
                c.setNameFirst(rs.getString("nameFirst"));
                c.setNameLast(rs.getString("nameLast"));
                c.setCitationNumber(rs.getString("CitationNumber"));
                c.setPartyID(rs.getString("PartyID"));
                c.setTicketDate(rs.getString("ticketDate"));
                list.add(c);
            }
            ps=null;
            rs=null;
            return list;
             
             
        }catch(Exception e){
            
            return null;
        }
    }
}
