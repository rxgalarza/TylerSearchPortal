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
 * @author Rodolfo and Zijia 
 */
@ManagedBean(name = "main")
@SessionScoped
public class MainController implements Serializable {
    private Case c = new Case();
    ListQuery query = new ListQuery();
    
    private List<Case> list = new ArrayList<Case>();
    private String error="";
    private int size = 0;
    private String name = "";
    private String nameFirst = "";
    private String nameLast = "";
    private int curr = 0;
    public  String Date = "";
    public String startDate = "";
    public String endDate = "";
    public String citationNumber = "";
    public String businessName = "";
    private Case Case;
    public  List<Case> sortedByDate = new ArrayList<Case>();

    public List<Case> getSortedByDate() {
       // try{
        sortedByDate.clear();
        String [] dateParts = startDate.split("/");
        int monthStart = Integer.parseInt(dateParts[0]);
        int dayStart = Integer.parseInt(dateParts[1]);
        int yearStart = Integer.parseInt(dateParts[2]);
        
        String [] dateParts2 = endDate.split("/");
        int monthEnd   = Integer.parseInt(dateParts2[0]);
        int dayEnd = Integer.parseInt(dateParts2[1]);
        int yearEnd  = Integer.parseInt(dateParts2[2]);
        
        
        for(int i = 0 ; i < list.size() ; i++){
           String caseAppearByDate =  list.get(i).getAppearByDate();
           String [] dateParts3 = caseAppearByDate.split("/");
           int caseMonth   = Integer.parseInt(dateParts3[0]);
           int caseDay = Integer.parseInt(dateParts3[1]);
           int caseYear  = Integer.parseInt(dateParts3[2]);
           
           if (caseYear >= yearStart && caseYear <= yearEnd){
               if(caseMonth >= monthStart && caseMonth <= monthEnd){
                   if(caseDay >= dayStart && caseDay <= dayEnd){
                   sortedByDate.add(list.get(i));
                   System.out.print(list.get(i).getAppearByDate());
                   }
               }
           }
        //}
           
        }
      //  catch(NullPointerException e)
    // {
      //  System.out.print("NullPointerException Caught At MainController");
   //  }
        
        return sortedByDate;
    }
    
    
      public  List<Case> sortedByFiledDate = new ArrayList<Case>();

    public List<Case> getSortedByFiledDate() {
       // try{
        sortedByFiledDate.clear();
        String [] dateParts = startDate.split("/");
        int monthStart = Integer.parseInt(dateParts[0]);
        int dayStart = Integer.parseInt(dateParts[1]);
        int yearStart = Integer.parseInt(dateParts[2]);
        
        String [] dateParts2 = endDate.split("/");
        int monthEnd   = Integer.parseInt(dateParts2[0]);
        int dayEnd = Integer.parseInt(dateParts2[1]);
        int yearEnd  = Integer.parseInt(dateParts2[2]);
        
        
        for(int i = 0 ; i < list.size() ; i++){
           String caseFiledDate =  list.get(i).getFiledDate();
           String [] dateParts3 = caseFiledDate.split("/");
           int caseMonth   = Integer.parseInt(dateParts3[0]);
           int caseDay = Integer.parseInt(dateParts3[1]);
           int caseYear  = Integer.parseInt(dateParts3[2]);
           
           if (caseYear >= yearStart && caseYear <= yearEnd){
               if(caseMonth >= monthStart && caseMonth <= monthEnd){
                   if(caseDay >= dayStart && caseDay <= dayEnd){
                   sortedByFiledDate.add(list.get(i));
                 
                   }
               }
           }
        //}
           
        }
      //  catch(NullPointerException e)
    // {
      //  System.out.print("NullPointerException Caught At MainController");
   //  }
        
        return sortedByFiledDate;
    }

    public Case getCase() {
        return Case;
    }

    public void setCase(Case Case) {
        this.Case = Case;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSortedByDate(List<Case> sortedByDate) {
        this.sortedByDate = sortedByDate;
    }
    
    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }
    
   
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCitationNumber() {
        return citationNumber;
    }

    public void setCitationNumber(String citationNumber) {
        this.citationNumber = citationNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String showCase(String citationNumber){
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getCitationNumber().equals(citationNumber)){
                Case = list.get(i);
            }
        }
        return "detailPage.xhtml";
    }

    public List<Case> getList() {
     //try{   
       if (!nameFirst.equals("")&&!nameLast.equals("")){
           // list.clear();
           long startTime = System.nanoTime();          
            list = query.listCase2(nameFirst,nameLast);    
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            
            
       }
       else if(!businessName.equals("") ){
           
             nameFirst = "";
           nameLast="";
           long startTime = System.nanoTime();          
            list = query.listCase3(businessName);    
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
           
       }
        else
        {
        
            long startTime = System.nanoTime();     
            list = query.listCase(name);
            long endTime = System.nanoTime();    
            timeElapsed = endTime - startTime;
           // name = "";
             
        }    
       
        try {    
        error="";
        size = list.size();
            if (list.isEmpty())//list == 0
            {
                error="No results found";
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
       
    
     public String getDate() {
        return Date;
    }
    
      public void setDate(String Date) {
        this.Date = Date;
    }
      
     public String getStartDate() {
        return startDate;
    }

     public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    
}