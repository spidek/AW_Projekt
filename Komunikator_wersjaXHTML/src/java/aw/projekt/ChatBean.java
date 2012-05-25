/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set; 
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Karolina
 */
@Stateless
@LocalBean
@SessionScoped
@ManagedBean(name="Chat")
public class ChatBean {

    private Map users = new HashMap();
    private List messages = new LinkedList(); 
    
    public synchronized void addUser (UserBean user){
        users.put(user.getName(), user);
    }
    
    public synchronized Object removeUser (String userName){
        return users.remove(userName);
    }
    
    public int getNumerOfUsers(){
        return users.size();
    }
    
    public Set getUsers(){
        return users.entrySet();
    }
}
