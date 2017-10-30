/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.category_types.S1_categories;
import POS.inventory2_stocks_left.Inventory2_stocks_left;
import POS.inventory2_stocks_left.Inventory2_stocks_left.to_inventory2_stocks_left;
import POS.stock_in.Stock_in_main;
import POS.utl.Alert;
import POS.utl.Dlg_confirm_action_clear;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import org.jfree.ui.Align;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_inventory_replenishment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_inventory_replenishment
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

        public final List<to_inventory2_stocks_left> selected_items;

        public OutputData(List<to_inventory2_stocks_left> selected_items) {
            this.selected_items = selected_items;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_inventory_replenishment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_inventory_replenishment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_inventory_replenishment() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_inventory_replenishment myRef;

    private void setThisRef(Dlg_inventory_replenishment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_replenishment> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_replenishment create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_replenishment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_replenishment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_replenishment((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_inventory_replenishment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_replenishment((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
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

        Dlg_inventory_replenishment dialog = Dlg_inventory_replenishment.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_inventory2_stocks_left = new javax.swing.JTable();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        tf_search3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        cb_is_selected7 = new javax.swing.JCheckBox();
        cb_category3 = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        cb_is_selected8 = new javax.swing.JCheckBox();
        cb_type3 = new javax.swing.JComboBox();
        jButton7 = new Button.Default();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_inventory2_stocks_left.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_inventory2_stocks_left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_inventory2_stocks_leftMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_inventory2_stocks_left);

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Search:");

        tf_search3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search3ActionPerformed(evt);
            }
        });
        tf_search3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search3KeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Category:");

        cb_is_selected7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected7.setSelected(true);
        cb_is_selected7.setText("All");
        cb_is_selected7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected7ActionPerformed(evt);
            }
        });

        cb_category3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_category3.setFocusable(false);
        cb_category3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_category3MouseClicked(evt);
            }
        });
        cb_category3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_category3ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Sub:");

        cb_is_selected8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected8.setSelected(true);
        cb_is_selected8.setText("All");
        cb_is_selected8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected8ActionPerformed(evt);
            }
        });

        cb_type3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_type3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE" }));
        cb_type3.setFocusable(false);
        cb_type3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_type3MouseClicked(evt);
            }
        });
        cb_type3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_type3ActionPerformed(evt);
            }
        });

        jButton7.setText("Search");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_is_selected7)
                            .addComponent(cb_is_selected8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_type3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_category3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(tf_search3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cb_category3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected7))
                .addGap(1, 1, 1)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_type3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(cb_is_selected8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search3)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addComponent(jLabel32))
                .addGap(0, 0, 0))
        );

        jLabel1.setText("No. of rows:");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
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

    private void tf_search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search3ActionPerformed

    private void tf_search3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search3KeyReleased

    private void cb_is_selected7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_is_selected7ActionPerformed

    private void cb_category3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_category3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_category3MouseClicked

    private void cb_category3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_category3ActionPerformed
        cb_type3();
    }//GEN-LAST:event_cb_category3ActionPerformed

    private void cb_is_selected8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_is_selected8ActionPerformed

    private void cb_type3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_type3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type3MouseClicked

    private void cb_type3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_type3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ret_items();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_inventory2_stocks_leftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_inventory2_stocks_leftMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_inventory2_stocks_leftMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_category3;
    private javax.swing.JCheckBox cb_is_selected7;
    private javax.swing.JCheckBox cb_is_selected8;
    private javax.swing.JComboBox cb_type3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_inventory2_stocks_left;
    private javax.swing.JTextField tf_search3;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

//        Main.MyDB.setNames("db_pos_restaurant");

        init_key();
        init_tbl_inventory2_stocks_left(tbl_inventory2_stocks_left);
        cb_model();

    }

    private void cb_model() {

        cb_category3.setModel(new ListComboBoxModel(S1_categories.
                ret_categories_for_cb()));

    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    private void cb_type3() {
        int row = cb_category3.getItemCount();
        String cat = "zzz";

        if (row != 0) {
            cat = cb_category3.getSelectedItem().
                    toString();
        }

        cb_type3.setModel(new ListComboBoxModel(S1_categories.
                ret_category_types_for_cb(cat)));
    }
    //<editor-fold defaultstate="collapsed" desc=" inventory2_stocks_left "> 
    public static ArrayListModel tbl_inventory2_stocks_left_ALM;
    public static Tblinventory2_stocks_leftModel tbl_inventory2_stocks_left_M;

    public void init_tbl_inventory2_stocks_left(JTable tbl_inventory2_stocks_left) {
        tbl_inventory2_stocks_left_ALM = new ArrayListModel();
        tbl_inventory2_stocks_left_M = new Tblinventory2_stocks_leftModel(tbl_inventory2_stocks_left_ALM);
        tbl_inventory2_stocks_left.setModel(tbl_inventory2_stocks_left_M);
        tbl_inventory2_stocks_left.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_inventory2_stocks_left.setRowHeight(25);
        int[] tbl_widths_inventory2_stocks_left = {50, 70, 100, 80, 130, 130, 50, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory2_stocks_left.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_inventory2_stocks_left, i, tbl_widths_inventory2_stocks_left[i]);
        }
        Dimension d = tbl_inventory2_stocks_left.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_inventory2_stocks_left.getTableHeader().setPreferredSize(d);
        tbl_inventory2_stocks_left.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_inventory2_stocks_left.setRowHeight(25);
        tbl_inventory2_stocks_left.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_inventory2_stocks_left, 3);
        TableColumn tc = tbl_inventory2_stocks_left.getColumnModel().getColumn(7);
        tc.setCellEditor(tbl_inventory2_stocks_left.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_inventory2_stocks_left.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
    }

    public static void loadData_inventory2_stocks_left(List<to_inventory2_stocks_left> acc) {
        tbl_inventory2_stocks_left_ALM.clear();
        tbl_inventory2_stocks_left_ALM.addAll(acc);
    }
    //<editor-fold defaultstate="collapsed" desc=" listener ">

    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_inventory2_stocks_left.getRowCount(); x < y; x++) {
                tbl_inventory2_stocks_left.setValueAt(checked, x, 0);
            }
        }
    }

    class CheckBoxHeader extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(new java.awt.Color(204, 204, 204));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
                    rendererComponent.setOpaque(true);
                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {
            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column1 = tableView.convertColumnIndexToModel(viewColumn);
                if (viewColumn == this.column && e.getClickCount() == 1 && column1 != -1) {
                    doClick();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((JTableHeader) e.getSource()).repaint();
            List<to_inventory2_stocks_left> datas = tbl_inventory2_stocks_left_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (to_inventory2_stocks_left to : datas) {
                to.setIs_selected(selected);
            }

            e.consume();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //</editor-fold>
    public static class Tblinventory2_stocks_leftModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Price", "Category", "Sub Category", "Active", "", "types_num", "is_vat", "prod_assembly", "is_linient", "w_commission", "comm_amount", "cat_id", "cost", "img_path", "printing_assembly", "is_active", "group_id", "item_package_id", "happy_hour"
        };

        public Tblinventory2_stocks_leftModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 117) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_inventory2_stocks_left tt = (to_inventory2_stocks_left) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.product_qty;
                case 1:
                    return " " + tt.product_name;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.price) + " ";
                case 4:
                    return " " + tt.img_path;
                case 5:
                    return " " + tt.types;
                case 6:
                    if (tt.is_active == 0) {
                        return "  No";
                    } else {
                        return "  Yes";
                    }

                case 7:
                    return tt.is_selected;
                case 8:
                    return tt.types_num;
                case 9:
                    return tt.is_vat;
                case 10:
                    return tt.prod_assembly;
                case 11:
                    return tt.is_linient;
                case 12:
                    return tt.w_commission;
                case 13:
                    return tt.comm_amount;
                case 14:
                    return tt.cat_id;
                case 15:
                    return tt.cost;
                case 16:
                    return tt.img_path;
                case 17:
                    return tt.printing_assembly;
                case 18:
                    return tt.is_active;
                case 19:
                    return tt.group_id;
                case 20:
                    return tt.item_package_id;
                default:
                    return tt.happy_hour;
            }
        }
    }

    private void ret_items() {
        String cat_id = Stock_in_main.ret_cat_id(cb_category3.getSelectedItem().toString());
        String sub_cat_id = Stock_in_main.ret_sub_cat_id(cb_type3.getSelectedItem().toString());
        String where = " where i.img_path like '%%' ";
        if (!cb_is_selected7.isSelected() && !cb_is_selected8.isSelected()) {
            where = where + " and i.types_num='" + sub_cat_id + "' ";
        }
        if (!cb_is_selected7.isSelected() && cb_is_selected8.isSelected()) {
            where = where + " and i.cat_id='" + cat_id + "' ";

        }
        where = where + " order by description asc ";
       
        List<to_inventory2_stocks_left> datas = Inventory2_stocks_left.ret_data(where);
        loadData_inventory2_stocks_left(datas);
        jLabel2.setText("" + datas.size());
    }

    private void select_item() {
        int row = tbl_inventory2_stocks_left.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_inventory2_stocks_left to = (to_inventory2_stocks_left) tbl_inventory2_stocks_left_ALM.get(row);
        int col = tbl_inventory2_stocks_left.getSelectedColumn();
        if (col == 7) {
            if (to.is_selected) {
                to.setIs_selected(false);
            } else {
                to.setIs_selected(true);
            }
            tbl_inventory2_stocks_left_M.fireTableDataChanged();
        }
    }

    private void ok() {
        List<to_inventory2_stocks_left> items = tbl_inventory2_stocks_left_ALM;
        final List<to_inventory2_stocks_left> selected = new ArrayList();
        for (to_inventory2_stocks_left to : items) {
            if (to.is_selected) {
                selected.add(to);
            }
        }
        if (selected.isEmpty()) {
            Alert.set(0, "No Item/s selected!");
            return;
        }
        Window p = (Window) this;
        Dlg_confirm_action_clear nd = Dlg_confirm_action_clear.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_confirm_action_clear.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action_clear.OutputData data) {
                closeDialog.ok();
                ok2(selected);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
//</editor-fold> 

    private void ok2(List<to_inventory2_stocks_left> selected) {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(selected));
        }
    }
}
