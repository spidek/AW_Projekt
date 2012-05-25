/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

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
@ManagedBean(name="Message")
public class MessageBean {

    private String userName; 
    private String message; 
    private long timeStamp;
    
    public MessageBean(){}
    
    public MessageBean(String name, String message, long timeStamp) {
        this.userName = name;
        this.message = message; 
        this.timeStamp = timeStamp;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }
    
}
