/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aw.projekt;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author robak
 */
@Stateful
@LocalBean
@ManagedBean(name="Emoticons")
public class EmoticonsBean {    
    // odpowiednio do: web/images/emotikony.png
    String emoticons[] = {
        ":(" , ":)", ";)", "-.-" , ";p" , ":-P", ":-(", ":-)", ";-)", "!!", "??",
        ";-(", "^^", ":D", "rofl", ":-O", "8[" , ":-|", ":->", ":>", ":-z", ":|",
        ";]", ";/", "loffciam", "<piwo>", ":-x", "<sex>", "<piwo2>", "<przytul>", "<kiss>", "<rozmarzony>", "<sciana>"
    };
    
    final int EMOT_HEIGHT = 16;
    final int EMOT_WIDTH = 17;
    
    
    /**
     * @param row
     * @param tabIndex 
     * @param position Tablica cztero elementowa: 0 = gora, 1=prawy bok, 2=dol, 3=lewy bok
     */
    private void calcEmotPosDepentByRow(int row, int emoticonsIndex, int position[]) {   
        position[0]= row * this.EMOT_WIDTH;
        position[1]= (emoticonsIndex+1) * this.EMOT_HEIGHT;
        position[2]= (row+1) * this.EMOT_WIDTH;
        position[3]= emoticonsIndex * this.EMOT_HEIGHT;
    }
    
    /**
     * 
     * @param tabIndex 
     * @param position Tablica cztero elementowa: 0 = gora, 1=prawy bok, 2=dol, 3=lewy bok
     */
    private void calcEmotPos(int tabIndex, int position[]) {
        int emotsRows = 3;
        int emotsColumns = 11;
        if (tabIndex < emotsColumns) { // first row
            this.calcEmotPosDepentByRow(0, tabIndex, position);
        } else if (tabIndex < 2 * emotsColumns) {
            this.calcEmotPosDepentByRow(1, tabIndex - 11, position);
        } else {
            this.calcEmotPosDepentByRow(2, tabIndex - 22, position);
        }
    }
    
    public void insertEmoticons(MessageBean message) {
        String msg = message.getMessage();
        String replacement;
        String tagWraper = "<div style=\"position: relative; display: inline;\">%s</div>";
        String tagFormat = "<img style=\"position: absolute; clip: rect(%spx, %spx, %spx, %spx); top: -%spx; left: -%spx;\" src=\"%s\" />";
        int emotPos[] = {0, 0, 0, 0};
        int emoticonsIndex = 0;
        for(String emot : this.emoticons) {
            this.calcEmotPos(emoticonsIndex++, emotPos);
            replacement = String.format(
                    tagFormat, 
                    emotPos[0], emotPos[1], emotPos[2], emotPos[3], 
                    emotPos[0], emotPos[3], "images/emotikony.png"
            );
            replacement = String.format(tagWraper, replacement);
            msg = msg.replace(emot, replacement);
        }
        message.setMessage(msg);
    }
}