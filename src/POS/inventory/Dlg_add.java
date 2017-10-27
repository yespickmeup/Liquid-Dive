/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main;
import POS.dlg2.Dlg_category;
import POS.dlg2.Dlg_confirm;
import POS.dlg2.Dlg_search_product;
import POS.dlg2.Dlg_type;
import POS.rpt2.rpt_barcode;
import POS.svc3.S10_update_product;
import POS.svc3.S9_add_product;
import POS.to2.to_add_product;
import POS.utl.TableUtility;
import POS.category_types.S1_categories;
import POS_svc4.S7_uom.to_product_uom;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_add extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_add
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;




    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_add(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_add(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_add() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_add myRef;

    private void setThisRef(Dlg_add myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_add> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_add create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_add create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_add dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_add dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_add dialog = Dlg_add.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
            initComponents();
            myInit();
            repaint();
        }


    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        pop_p_assembly = new javax.swing.JMenuItem();
        pm_is_active = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        cb_category = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        tf_search = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        pop_p_assembly.setText("PRINTING ASSEMBLY");
        pop_p_assembly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_p_assemblyActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_p_assembly);

        pm_is_active.setSelected(true);
        pm_is_active.setText("Is Active");
        pm_is_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_is_activeActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_is_active);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_categoryMouseClicked(evt);
            }
        });
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CATEGORY:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Type:");

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_type.setFocusable(false);
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCT NAME", "DESCRIPTION", "Unit Price", "QTY"
            }
        ));
        tbl_prod.setFocusable(false);
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_prodMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_prodMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/delete-minus.png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        jButton4.setText("ADD");
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/update.png"))); // NOI18N
        jButton5.setText("UPDATE");
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/barcode.png"))); // NOI18N
        jButton6.setText("BARCODE");
        jButton6.setFocusable(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tf_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SEARCH:");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/barcode.png"))); // NOI18N
        jButton7.setText("BARCODES");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("INVENTORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("STOCK IN/OUT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("PRINTING ASSEMBLY");
        jButton10.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:;
//        cb_type();
        data_employee_category();
//         set_category();
    }//GEN-LAST:event_cb_typeActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
        cb_type();
        data_employee_category();
//        set_category();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        add_prod();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        update_product();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete_product();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
        ok1();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        add_category();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        add_type();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        print_barcode();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        category_id = "";
        data_employee_search();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        do_barcodes();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        // TODO add your handling code here:
//        set_category();
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void cb_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_categoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        stock_in_out();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tbl_prodMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_prodMousePressed

    private void tbl_prodMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_prodMouseReleased

    private void pop_p_assemblyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_p_assemblyActionPerformed
        printing_assembly();
    }//GEN-LAST:event_pop_p_assemblyActionPerformed

    private void pm_is_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_is_activeActionPerformed
        update_active();
    }//GEN-LAST:event_pm_is_activeActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_category;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem pm_is_active;
    private javax.swing.JMenuItem pop_p_assembly;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//      
//        Main.MyDB.setNames("db_pos_casablanca");
        add_assembly();
        if (System.getProperty("version", "resto").
                equals("resto")) {
            ds_title.setText("PRICING MANAGER");
        }
        cb_model();
        cb_type();
        init_tbl_baptism();
        data_employee_search();

        String cashiering_for = System.getProperty("cashiering_for", "retail_store");
//        JOptionPane.showMessageDialog(null, cashiering_for);
//        cb_type.setVisible(false);
//        jLabel2.setVisible(false);
//        jButton3.setVisible(false);
//        if (cashiering_for.equals("endorsements") || cashiering_for.equals("retail_store")) {
//        } else {
//            cb_type.setVisible(true);
//            jLabel2.setVisible(true);
//            jButton3.setVisible(true);
//        }
    }

    private void disposed() {
        this.dispose();
    }

    private void add_assembly() {
    }

    public void do_pass() {
    }

    private void cb_model() {
        cb_category.setModel(new ListComboBoxModel(S1_categories.ret_categories_for_cb()));
    }

    private void cb_type() {
        int row = cb_category.getItemCount();
        if (row == 0) {
            return;
        }

        cb_type.setModel(new ListComboBoxModel(S1_categories.ret_category_types_for_cb(cb_category.getSelectedItem().
                toString())));
    }

    private void add_prod() {

        if (cb_type.getItemCount() == 0) {
//            return;
        }

        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);

//        System.setProperty("cashiering_for", "restaurant_w_order_no");

//        Window p = (Window) this;
//        Dlg_add_product2 nd = Dlg_add_product2.create(p, true);
//        nd.setTitle("");
//        nd.do_pass("");
//        nd.setCallback(new Dlg_add_product2.Callback() {
//            
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_add_product2.OutputData data) {
//                closeDialog.ok();
//            }
//        });
//        Center.setCenter(nd);
//        
//        nd.setVisible(true);

        Window p = (Window) this;
        Dlg_add_product2 nd = Dlg_add_product2.create(p, true);
        nd.setTitle("Add Product");
        nd.do_pass();
        nd.setCallback(new Dlg_add_product2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_product2.OutputData data) {
                closeDialog.ok();
                add_product(data.name, data.description, data.price, data.qty, data.remarks, data.supplier, data.vat, data.assemby, data.tt, data.is_linient, data.w_com, data.amount, cat_id, data.cost, data.img_path, data.is_active);

//                data_employee_search();
                data_employee_category();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_product(String name, String description, String price, String qty, String remarks, String supp_id, String vat, String assembly, List<to_product_uom> tt, String is_linient, String w_com, double com_amount, String cat_id, double cost, String img_path, int is_active) {

        String cat = "0";
        if (cb_type.getItemCount() == 0) {
            cat = "0";
        } else {
            cat = cb_type.getSelectedItem().
                    toString();
        }
        int printing_assembly = S5_printing_assemlby.get_category_assembly_id(cat_id);
        int group_id = S5_printing_assemlby.get_category_group_id(cat_id);
        String type_name = cb_type.getSelectedItem().
                toString();
        String type_id = S1_categories.ret_type_id(type_name);
        S9_add_product.add(name, description, price, qty, remarks, cat, supp_id, vat, assembly, tt, is_linient, w_com, com_amount, cat_id
                , cost, img_path, is_active, printing_assembly, group_id, type_name, type_id,0);
    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);
        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 30));

        tbl_prod.setModel(tbl_employee_payroll_M);
        tbl_prod.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prod.setRowHeight(25);

        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 300, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_prod, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_left(tbl_prod, 1);
        TableUtility.align_row_to_right(tbl_prod, 2);
        TableUtility.align_row_to_Center(tbl_prod, 3);
        TableUtility.align_row_to_Center(tbl_prod, 7);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_prod.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_prod.setRowHeight(35);
        tbl_prod.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<to_add_product> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id", "cost", "printing Assembly", "IS ACTIVE", "CATEGORY", "TYPES num", "TYPE"
        };

        public TblInvoicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.desc;

            case 2:
                return FitIn.fmt_wc_0(tt.price);

            case 3:
                return tt.qty;
            case 4:
                return tt.num;
            case 5:
                return tt.vat;
            case 6:
                return tt.category_id;
            case 7:
                return tt.is_linient;
            case 8:
                return tt.w_commission;
            case 9:
                return tt.comm_amount;
            case 10:
                return tt.cat_id;
            case 11:
                return tt.cost;
            case 12:
                return tt.printing_assembly;

            case 13:
                return tt.is_active;
            case 14:
                return tt.category_name;
            case 15:
                return tt.type_id;
            default:
                return tt.type_name;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
        int row = cb_type.getItemCount();
        System.out.println(row);
        if (row == 0) {
            tbl_employee_payroll_ALM.clear();
            tbl_employee_payroll_M.fireTableDataChanged();
            return;
        }

        String name = tf_search.getText();

        loadData_baptism(S9_add_product.ret_products(cb_type.getSelectedItem().
                toString(), name));
    }
    String category_id = "";

    private void data_employee_category() {
        if (cb_category.getItemCount() == 0) {
            return;
        }
        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        category_id = cat_id;
        String name = tf_search.getText();
        String type_name = cb_type.getSelectedItem().
                toString();
        String type_id = S1_categories.ret_type_id(type_name);


        loadData_baptism(S9_add_product.ret_products_search_category(category_id, name, type_id));
//        loadData_baptism(S9_add_product.ret_products_category(cb_category.getSelectedItem().toString(), name, cat_id));

    }

    private void data_employee_search() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
//        int row = cb_type.getItemCount();
//        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }

        String name = tf_search.getText();
        loadData_baptism(S9_add_product.ret_products_search_like(category_id, name));
    }

    private void set_category() {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String type_id = "";

        String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();
        type_id = tbl_prod.getModel().
                getValueAt(row, 6).
                toString();
        String id = type_id;
        String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
//        JOptionPane.showMessageDialog(null, type_id);
        type_id = S10_update_product.get_category_name(type_id);


        String cat_name = S10_update_product.get_category_id(id);
//       


        cat_name = S10_update_product.get_class_name(cat_name);

        cb_category.setSelectedItem(cat_name);
        cb_type.setSelectedItem(type_id);
        System.out.println(cat_name + " - " + type_id);

        List<to_add_product> datas = tbl_employee_payroll_ALM;

        int i = 0;

        for (to_add_product to : datas) {

            if (to.num.equals(num)) {
                System.out.println(to.num + " - " + num);
                break;
            }
            i++;
        }
        System.out.println(i);
        tbl_prod.setColumnSelectionInterval(0, i);

    }

    private void update_active() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        String active = "0";
        if (pm_is_active.isSelected()) {
            active = "1";
        } else {
            active = "0";
        }

        S6_items.edit_data_active(num, active);
        data_employee_category();
    }

    private void update_product() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        String name = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        String desc = tbl_prod.getModel().
                getValueAt(row, 1).
                toString();
        String price = tbl_prod.getModel().
                getValueAt(row, 2).
                toString();
        String qty = tbl_prod.getModel().
                getValueAt(row, 3).
                toString();
        String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();
        String category_type = tbl_prod.getModel().
                getValueAt(row, 6).
                toString();
        String is_linient = tbl_prod.getModel().
                getValueAt(row, 7).
                toString();
        String w_comm = tbl_prod.getModel().
                getValueAt(row, 8).
                toString();
        double comm_amount = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 9).
                toString());
        double cost = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 11).
                toString());


        String cat_id = tbl_prod.getModel().
                getValueAt(row, 10).
                toString();
        Window p = (Window) this;
        Dlg_Menu_update_product nd = Dlg_Menu_update_product.create(p, true);
        nd.setTitle("");
        nd.pass(num, name, desc, price, qty, vat, category_type, is_linient, w_comm, comm_amount, cat_id, cost);
        nd.setCallback(new Dlg_Menu_update_product.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_Menu_update_product.OutputData data) {
//                closeDialog.ok();
//                data_employee_search();
                data_employee_category();
                ok1();
            }

            @Override
            public void o2(CloseDialog closeDialog, Dlg_Menu_update_product.OutputData data) {
                closeDialog.ok();
                update_types(data.barcode, data.types, data.types_num, data.cat_id, data.assemble);
//                data_employee_search();
                data_employee_category();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_types(String id, String types, String types_num, String cat_id, String assembly) {
        S10_update_product.add_types(id, types, types_num, cat_id, assembly);
    }

    private void delete_product() {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }


        final String num = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass();
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete(num);
                data_employee_category();
//                data_employee_search();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void delete(String num) {
        S10_update_product.do_delete_product(num);

        ok1();
    }

    private void ok1() {

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void add_category() {
        Window p = (Window) this;
        Dlg_category nd = Dlg_category.create(p, true);
        nd.setTitle("Prompt");

        nd.setCallback(new Dlg_category.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_category.OutputData data) {
//                closeDialog.ok();
                cb_model();
                data_employee_category();
//                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_type() {
        Window p = (Window) this;
        Dlg_type nd = Dlg_type.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass(cb_category.getSelectedItem().
                toString());
        nd.setCallback(new Dlg_type.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_type.OutputData data) {
//                closeDialog.ok();
                cb_type();
                data_employee_category();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void print_barcode() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        final String name = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        final String desc = tbl_prod.getModel().
                getValueAt(row, 1).
                toString();
        final double price = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 2).
                toString());
        final String qty = tbl_prod.getModel().
                getValueAt(row, 3).
                toString();
        final String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();

        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_barcode.print_barcode("", name, desc, price);
            }
        });
    }

    private void do_barcodes() {
        Window p = (Window) this;
        Dlg_search_product nd = Dlg_search_product.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_search_product.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_search_product.OutputData data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void stock_in_out() {
        Window p = (Window) this;
        Dlg_inventory_stockin_out nd = Dlg_inventory_stockin_out.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_inventory_stockin_out.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_stockin_out.OutputData data) {
//                closeDialog.ok();
                data_employee_search();
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        nd.setSize(xSize, ySize);
        nd.setVisible(true);
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
//            JOptionPane.showMessageDialog(null, jPopupMenu1.getSubElements().length);
            if (jPopupMenu1.getSubElements().length == 2) {
            } else {
                jPopupMenu1.remove(2);
            }

            int row = tbl_prod.getSelectedRow();
            if (row < 0) {
                return;
            }
            final String num = tbl_prod.getModel().
                    getValueAt(row, 0).
                    toString();
            int print_assembly = FitIn.toInt(tbl_prod.getModel().
                    getValueAt(row, 12).
                    toString());
            int is_active = FitIn.toInt(tbl_prod.getModel().
                    getValueAt(row, 13).
                    toString());
            if (is_active == 0) {
                pm_is_active.setSelected(false);
            } else {
                pm_is_active.setSelected(true);
            }

            JMenu jm = new javax.swing.JMenu();
            jm.setText("ASSEMBLY");

            List<S5_printing_assemlby.to_printing_assembly> datas = new ArrayList();

            datas = S5_printing_assemlby.ret_data("");

            for (final S5_printing_assemlby.to_printing_assembly to : datas) {
                final JCheckBoxMenuItem p = new javax.swing.JCheckBoxMenuItem();
                p.setText(to.place);
                if (to.id == print_assembly) {
                    p.setSelected(true);
                } else {
                    p.setSelected(false);
                }
                p.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        S5_printing_assemlby.update_printing_assembly_item(num, to.id);
//                        Prompt.call("Updated Successfully");
                        data_employee_category();
                    }
                });
                jm.add(p);
            }


            final JCheckBoxMenuItem p = new javax.swing.JCheckBoxMenuItem();
            jPopupMenu1.add(jm);

            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void printing_assembly() {
        Window p = (Window) this;
        Dlg_printing_assembly nd = Dlg_printing_assembly.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_printing_assembly.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_printing_assembly.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
