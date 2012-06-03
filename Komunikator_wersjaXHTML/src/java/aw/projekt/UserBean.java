/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Karolina
 */
@Stateful
@LocalBean
@SessionScoped
@ManagedBean(name="User")
public class UserBean {

    private String name;
    private String city;
    private String age;
    private String info; 
    private boolean chkBoxChecked;
    
    public UserBean() { 
        this.chkBoxChecked = false; 
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
    
    public String getInfo(){
        return "Witaj!";
    }

    /**
     * @return the chkBoxChecked
     */
    public boolean isChkBoxChecked() {
        return chkBoxChecked;
    }

    /**
     * @param chkBoxChecked the chkBoxChecked to set
     */
    public void setChkBoxChecked(boolean chkBoxChecked) {
        this.chkBoxChecked = chkBoxChecked;
    }
    
    public String writeMessage(MessageBean msg) {        
        String chatBoxMsg = "<" + msg.getTime() + " " + this.name + "> " + msg.getMessage() + "<br />";
        msg.setMessage("");
        return chatBoxMsg;
    }
    
    public String writeMessage(MessageBean msg, EmoticonsBean emots) {   
        emots.insertEmoticons(msg);
        return this.writeMessage(msg);
    }
    
}
