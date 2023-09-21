/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author SERVIDOR
 */
public class FieldListener implements FocusListener {

    private boolean selectAll = false;
    private boolean removeEspacoMargem = true;

    public FieldListener(boolean selectAll) {
        this.selectAll = selectAll;
    }
    public FieldListener() {
    }

    @Override
    public void focusGained(FocusEvent e) {
        
        Object o = e.getSource();

        if (o instanceof JTextField) {

            JTextField f = (JTextField) o;
            f.setBackground(new Color(255, 255, 160));
            if (selectAll) {
                f.selectAll();
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    Object o = e.getSource();

        if (o instanceof JTextField) {
            JTextField f = (JTextField) o;
          
            f.setBackground(new Color(255, 255, 255));
        }
        
    }

}
