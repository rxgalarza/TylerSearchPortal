/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.database.ListQuery;
import com.model.Case;

import java.io.Serializable;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
       
    }
    
    
    public List<Case> getList() {
        list = query.listCase(name);

        return list;
    }
    
   /** public List<Case> getList() {
list = query.listCase(name);
if(list.size()==0){
Case temp = new Case();
temp.setNameLast("error");
temp.setNameFirst("error");
temp.setPartyID("error");
temp.setCitationNumber("error");
temp.setTicketDate("error");
list.add(temp);
}
return list;
}
**/

    public void setList(List<Case> list) {
        this.list = list;
    }
    

    
}
