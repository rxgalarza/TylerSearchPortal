/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.database.ListQuery;
import com.model.Case;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodolfo
 */

@ManagedBean(name = "main")
@SessionScoped
public class MainController implements Serializable {
   // private Case c = new Case();
    ListQuery query = new ListQuery();
    
    private List<Case> list = new ArrayList<Case>();
   
    
    private String name = "";
     private String nameFirst = "";
      private String nameLast = "";

    
    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }
      

    long timeElapsed = 0;


    

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
       
    }
    
    public String toString()
    {
        
        return "error.xhtml";
    }
    
    public List<Case> getList() {
        
        if (nameFirst.equals("")&& nameLast.equals("")){
            long startTime = System.nanoTime();      
            list = query.listCase(name);
            long endTime = System.nanoTime();    
            timeElapsed = endTime - startTime;
        }
        else{
            long startTime = System.nanoTime();       
            list = query.listCase2(nameFirst,nameLast);
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            nameFirst = "";
            nameLast="";
        }      
    try {
        
    if (list.isEmpty())//list == 0
    {
        //return "error.xhtml";
        Case temp = new Case();
        temp.setNameLast("Not Found");
        temp.setNameFirst("Not Found");
        temp.setPartyID("Not Found");
        temp.setCitationNumber("Not Found");
        temp.setTicketDate("Not Found");
        list.add(temp);
    }
        }
    catch(NullPointerException e)
     {
        System.out.print("NullPointerException Caught At MainController");
     }
        return list; //return the list
    }
    
 
    public void setList(List<Case> list) {
        this.list = list;
    }
    

    
}
