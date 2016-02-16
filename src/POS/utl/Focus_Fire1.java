/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Maytopacka
 */
public class Focus_Fire1 {
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

    public static void nextFocus(JTextField tf, final JTextField tf2) {
        tf.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf2.grabFocus();
            }
        });
    }

    public static void hover(JLabel[] tf) {
        for (final JLabel t : tf) {
            t.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    t.setBackground(new java.awt.Color(102, 102, 102));
                    t.setForeground(new java.awt.Color(0, 0, 0));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                    t.setForeground(new java.awt.Color(153, 153, 153));
                }
            });
        }
    }

    public static void hover2(JLabel[] tf) {
        for (final JLabel t : tf) {
            t.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                }

                @Override
                public void mousePressed(MouseEvent me) {
                }

                @Override
                public void mouseReleased(MouseEvent me) {
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    t.setBackground(new java.awt.Color(230, 227, 227));
                    t.setForeground(new java.awt.Color(0, 0, 0));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    t.setBackground(new java.awt.Color(255, 255, 255));
                    t.setForeground(new java.awt.Color(153, 153, 153));
                }
            });
        }
    }
    public static void select_all(JTextField[] tf){
        for(final JTextField t:tf){
            t.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent fe) {
                  t.selectAll();
                }

                @Override
                public void focusLost(FocusEvent fe) {
                   
                }
            });
        }
    }
    public static void init_disable(JTextField[] tf){
        for(final JTextField t:tf){
           t.enable(false);
        }
    }
}
