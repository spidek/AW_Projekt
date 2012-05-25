/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import java.util.*; 
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Karolina
 */
@Stateful
@ApplicationScoped
@ManagedBean(name="Chat")
public class ChatBean {

    private Map users = new HashMap();
    private List<String> messages = new ArrayList<String>(); 
    
    public ChatBean () {
        messages.add("Start chatu.");
    }
    
    public void setMessages(String msg){
        messages.add(msg);
    }
    
    public String getMessages(){
        StringBuilder chatBox = new StringBuilder();
        for (String s : this.messages) {
            chatBox.append(s).append("\n");
        }
        return chatBox.toString();
    }
    
    public SelectItem[] returnUserzy (){
        
        for (int i = 0; i < 5; ++i)
            users.put(i, "user");
        
        SelectItem[] usersBox = new SelectItem[users.size()];
        for (int i = 0; i < 5; i++)
            usersBox[i] = new SelectItem(i, "uzytkownik" + i);
        return usersBox;
    }
    
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
