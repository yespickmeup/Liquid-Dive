/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Maytopacka
 */
public class Focus_Fire {

    public static void onFocus_lostFocus(JTextField[] tf) {
        for (final JTextField t : tf) {
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 153));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                }
            });
        }
    }
}
