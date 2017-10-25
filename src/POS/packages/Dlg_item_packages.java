/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.packages;

import POS.packages.S1_item_packages.to_item_packages;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Maytopacka
 */
public class Dlg_item_packages extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_item_packages
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
    private Dlg_item_packages(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_item_packages(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_item_packages() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_item_packages myRef;

    private void setThisRef(Dlg_item_packages myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_item_packages> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_item_packages create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_item_packages create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_item_packages dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_packages((java.awt.Frame) parent, false);
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
            Dlg_item_packages dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_item_packages((java.awt.Dialog) parent, false);
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_item_packages dialog = Dlg_item_packages.create(new javax.swing.JFrame(), true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_item_packages = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_product_name = new javax.swing.JLabel();
        tf_description = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_range_from = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_range_to = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_rate = new javax.swing.JTextField();
        cb_is_active = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        tf_package_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_item_packages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_item_packages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_item_packagesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_item_packages);

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("NEW");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PRODUCT CODE:");

        tf_product_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_product_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tf_description.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DESCRIPTION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Range from:");

        tf_range_from.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tf_range_from.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Range to:");

        tf_range_to.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tf_range_to.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("RATE:");

        tf_rate.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tf_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cb_is_active.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_is_active.setText("IS ACTIVE");
        cb_is_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_activeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("PACKAGE NAME:");

        tf_package_name.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_is_active))
                            .addComponent(tf_description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_range_from, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(tf_rate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)
                        .addComponent(tf_range_to, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_package_name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_is_active)
                    .addComponent(tf_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(tf_description, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_range_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tf_range_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel8)
                    .addComponent(tf_package_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(233, 233, 233)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_item_packages();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_item_packages();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_item_packages();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear_item_packages();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_item_packagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_item_packagesMouseClicked
        select_item_packages();
    }//GEN-LAST:event_tbl_item_packagesMouseClicked

    private void cb_is_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_activeActionPerformed
        update_package_status();
    }//GEN-LAST:event_cb_is_activeActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_is_active;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_item_packages;
    private javax.swing.JLabel tf_description;
    private javax.swing.JTextField tf_package_name;
    private javax.swing.JLabel tf_product_name;
    private javax.swing.JTextField tf_range_from;
    private javax.swing.JTextField tf_range_to;
    private javax.swing.JTextField tf_rate;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        init_tbl_item_packages();

    }

    public void do_pass(String product_name, String description, String item_package_id) {
        if (item_package_id != null) {
            if (item_package_id.equals("1")) {
                cb_is_active.setSelected(true);
            }
            tf_product_name.setText(product_name);
            tf_description.setText(description);

            data_cols();
        }

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
    private ArrayListModel tbl_item_packages_ALM;
    private Tblitem_packagesModel tbl_item_packages_M;

    private void init_tbl_item_packages() {
        tbl_item_packages_ALM = new ArrayListModel();
        tbl_item_packages_M = new Tblitem_packagesModel(tbl_item_packages_ALM);
        tbl_item_packages.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_item_packages.setModel(tbl_item_packages_M);
        tbl_item_packages.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_item_packages.setRowHeight(25);
        int[] tbl_widths_item_packages = {0, 100, 100, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_item_packages.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_item_packages, i, tbl_widths_item_packages[i]);
        }
        Dimension d = tbl_item_packages.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_item_packages.getTableHeader().
                setPreferredSize(d);
        tbl_item_packages.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_item_packages.setRowHeight(35);
        tbl_item_packages.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_item_packages(List<to_item_packages> acc) {
        tbl_item_packages_ALM.clear();
        tbl_item_packages_ALM.addAll(acc);
    }

    public static class Tblitem_packagesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "Range from", "Range to", "Rate", "product_name", "description", "is_active", "package_name"
        };

        public Tblitem_packagesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_item_packages tt = (to_item_packages) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return FitIn.toInt("" + tt.range_from);
                case 2:
                    return FitIn.toInt("" + tt.range_to);
                case 3:
                    return FitIn.fmt_wc_0("" + tt.rate);
                case 4:
                    return tt.product_name;
                case 5:
                    return tt.description;
                case 6:
                    return tt.is_active;
                default:
                    return tt.package_name;
            }
        }
    }

    private void data_cols() {
        String product_name = tf_product_name.getText();
        loadData_item_packages(S1_item_packages.ret_data(product_name));
    }

    private void add_item_packages() {

        int id = 0;
        double range_from = FitIn.toDouble(tf_range_from.getText());
        double range_to = FitIn.toDouble(tf_range_to.getText());
        double rate = FitIn.toDouble(tf_rate.getText());
        String product_name = tf_product_name.getText();
        String description = tf_description.getText();
        String package_name = tf_package_name.getText();
        String is_active = "0";
        if (cb_is_active.isSelected()) {
            is_active = "1";
        }
        to_item_packages to = new to_item_packages(id, range_from, range_to, rate, product_name, description, is_active, package_name);
        S1_item_packages.add_item_packages(to);
        data_cols();
        clear_item_packages();
    }

    private void select_item_packages() {
        int row = tbl_item_packages.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_packages to = (to_item_packages) tbl_item_packages_ALM.get(tbl_item_packages.
                convertRowIndexToModel(row));
//        tf_id.setText(FitIn.w_c_0(to.id));
        tf_range_from.setText("" + FitIn.toInt("" + to.range_from));
        tf_range_to.setText("" + FitIn.toInt("" + to.range_to));
        tf_rate.setText(FitIn.fmt_wc_0(to.rate));
        tf_product_name.setText(to.product_name);
        tf_description.setText(to.description);
        tf_package_name.setText(to.package_name);
//        tf_is_active.setText(to.is_active);
    }

    private void edit_item_packages() {
        int row = tbl_item_packages.getSelectedRow();
        if (row < 0) {
            return;
        }

        to_item_packages to = (to_item_packages) tbl_item_packages_ALM.get(tbl_item_packages.
                convertRowIndexToModel(row));
        int id = to.id;
        double range_from = FitIn.toDouble(tf_range_from.getText());
        double range_to = FitIn.toDouble(tf_range_to.getText());
        double rate = FitIn.toDouble(tf_rate.getText());
        String product_name = tf_product_name.getText();
        String description = tf_description.getText();
        String package_name = tf_package_name.getText();
        String is_active = "0";

        to_item_packages to1 = new to_item_packages(
                to.id, range_from, range_to, rate, product_name, description, is_active, package_name);
        S1_item_packages.edit_item_packages(to1);
        data_cols();
        clear_item_packages();

    }

    private void clear_item_packages() {
//        tf_id.setText("");
        tf_range_from.setText("");
        tf_range_to.setText("");
        tf_rate.setText("");
        tf_package_name.setText("");
//        tf_product_name.setText("");
//        tf_description.setText("");
//        tf_is_active.setText("");
    }

    private void delete_item_packages() {
        int row = tbl_item_packages.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_item_packages to = (to_item_packages) tbl_item_packages_ALM.get(tbl_item_packages.
                convertRowIndexToModel(row));
        S1_item_packages.delete_item_packages(to);
        data_cols();
        clear_item_packages();
    }

    private void update_package_status() {
        String product_name = tf_product_name.getText();
//        String description = tf_description.getText();
        String is_active = "0";
        if (cb_is_active.isSelected()) {
            is_active = "1";
        }
        S1_item_packages.edit_inventory2_stocks_left(product_name, is_active);
        Prompt.call("Status Updated");
    }
}
