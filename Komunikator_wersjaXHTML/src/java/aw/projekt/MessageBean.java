/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Karolina
 */
@Stateful
@RequestScoped
@ManagedBean(name="Message")
public class MessageBean {
    private String message; 
    
    /**
     * @return the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
