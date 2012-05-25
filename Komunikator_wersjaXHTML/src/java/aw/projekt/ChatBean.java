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

    private List<String> users = new ArrayList<String>();
    private List<String> messages = new ArrayList<String>(); 
    
    public ChatBean () {
        messages.add("Start chatu.");
        users.add("Admin");
    }
    
    public String addMessage(String msg){
        messages.add(msg);
        
        return "index";
    }
    
    public String getMessages(){
        StringBuilder chatBox = new StringBuilder();
        for (String s : this.messages) {
            chatBox.append(s).append("\n");
        }
        return chatBox.toString();
    }
    
    public SelectItem[] returnUserzy (){        
        SelectItem[] usersBox = new SelectItem[users.size()];
        int loop = this.users.size();
        for (int i = 0; i < loop; i++)
            usersBox[i] = new SelectItem(i, users.get(i));
        return usersBox;
    }
    
    public synchronized String addUser(UserBean user){
        users.add(user.getName());
        
        return "index";
    }
    
    public synchronized Object removeUser (String userName){
        return users.remove(userName);
    }
    
    public int getNumerOfUsers(){
        return users.size();
    }
}
