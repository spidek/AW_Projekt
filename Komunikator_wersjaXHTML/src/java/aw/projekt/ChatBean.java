/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import java.io.*;
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Karolina
 */
@Stateful
@ApplicationScoped
@ManagedBean(name="Chat")
public class ChatBean {

    private List<String> users = new ArrayList<String>();
    FileOutputStream chatHtmlBufferWriter;
            
    public ChatBean () throws IOException {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String chatHtmlPath = ctx.getRealPath("/") + "chat.html";
        try {
            this.chatHtmlBufferWriter = new FileOutputStream(chatHtmlPath);  
            this.chatHtmlBufferWriter.write("Start chatu ąęć. <br />".getBytes());
        } catch (IOException ex) {
            this.chatHtmlBufferWriter.close();
            throw ex;
        }

        users.add("Admin");
    }
    
    @PreDestroy
    public void closeFileBuffor() throws Exception {
        this.chatHtmlBufferWriter.close();
    }
    
    public String addMessage(String msg) throws IOException {
        this.chatHtmlBufferWriter.write(msg.getBytes());    
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        return "index"; 
    } 
    
    public String showMePath() {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return ctx.getRealPath("/") + "chat.html";
    }
    
    public SelectItem[] returnUserzy (){        
        SelectItem[] usersBox = new SelectItem[users.size()];
        int loop = this.users.size();
        for (int i = 0; i < loop; i++)
            usersBox[i] = new SelectItem(i, users.get(i));
        return usersBox;
    }
    
    public synchronized String addUser(UserBean user) throws IOException{
        users.add(user.getName());
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        return "index";
    }
    
    public synchronized Object removeUser (String userName){
        return users.remove(userName);
    }
    
    public int getNumerOfUsers(){
        return users.size();
    }
}
