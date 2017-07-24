/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.expenses;

import POS.dlg.Dlg_authenticate;
import POS.expenses.S1_expenses.to_expenses;
import POS.svc2.S12_cashier_sessions;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.DateUtils;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author i1
 */
public class Dlg_expenses extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_expenses
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
    private Dlg_expenses(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_expenses(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_expenses() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_expenses myRef;

    private void setThisRef(Dlg_expenses myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_expenses> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_expenses create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_expenses create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_expenses dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_expenses((java.awt.Frame) parent, false);
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
            Dlg_expenses dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_expenses((java.awt.Dialog) parent, false);
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


        Dlg_expenses dialog = Dlg_expenses.create(new javax.swing.JFrame(), true);
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
        tbl_expenses = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dp_date = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        tf_amount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_reason = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cb_vat = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        cb_all = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_expenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_expensesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_expenses);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DATE:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("AMOUNT:");

        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("REASON:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tf_reason.setColumns(20);
        tf_reason.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_reason.setRows(5);
        jScrollPane2.setViewportView(tf_reason);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CATEGORY:");

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("NEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cb_vat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_vat.setText("VAT?");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("TOTAL:");

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cb_all.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_all.setSelected(true);
        cb_all.setText("ALL");
        cb_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb_vat)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(dp_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb_vat)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_all))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(205, 205, 205)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_expensesMouseClicked
        select();
    }//GEN-LAST:event_tbl_expensesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        category();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clear();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cb_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_allActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_allActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_all;
    private javax.swing.JComboBox cb_category;
    private javax.swing.JCheckBox cb_vat;
    private com.toedter.calendar.JDateChooser dp_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_expenses;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextArea tf_reason;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        dp_date.setDate(new Date());
        dp_date.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols();
            }
        });
        set_category();
        init_key();
        init_tbl_expenses();
        data_cols();
    }

    public void do_pass() {
        data_cols();
    }

    private void set_category() {
        cb_category.setModel(new ListComboBoxModel(S1_expenses_categories.
                ret_cb_data()));
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
    private ArrayListModel tbl_expenses_ALM;
    private TblexpensesModel tbl_expenses_M;

    private void init_tbl_expenses() {
        tbl_expenses_ALM = new ArrayListModel();
        tbl_expenses_M = new TblexpensesModel(tbl_expenses_ALM);
        tbl_expenses.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_expenses.setModel(tbl_expenses_M);
        tbl_expenses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_expenses.setRowHeight(25);
        int[] tbl_widths_expenses = {0, 0, 0, 100, 100, 100};
        for (int i = 0, n = tbl_widths_expenses.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_expenses, i, tbl_widths_expenses[i]);
        }
        Dimension d = tbl_expenses.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_expenses.getTableHeader().
                setPreferredSize(d);
        tbl_expenses.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_expenses.setRowHeight(35);
        tbl_expenses.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_expenses(List<to_expenses> acc) {
        tbl_expenses_ALM.clear();
        tbl_expenses_ALM.addAll(acc);
    }

    public static class TblexpensesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "date_added", "user_name", "AMOUNT", "PURPOSE", "VAT"
        };

        public TblexpensesModel(ListModel listmodel) {
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
            to_expenses tt = (to_expenses) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.date_added;
                case 2:
                    return tt.user_name;
                case 3:
                    return FitIn.fmt_wc_0(tt.amount);
                case 4:
                    return tt.purpose;
                default:
                    return tt.vat;
            }
        }
    }

    private void data_cols() {


        String user_name = to_users.ret_user(to_users.username1);
//          JOptionPane.showMessageDialog(null, user_name);
        String date = DateType.sf.format(dp_date.getDate());
        String category = cb_category.getSelectedItem().
                toString();
        if (cb_all.isSelected()) {
            category = "";
        }
        loadData_expenses(S1_expenses.ret_data(user_name, category, date));
        List<to_expenses> ex = tbl_expenses_ALM;
        double total = 0;
        for (to_expenses to : ex) {
            total += FitIn.toDouble(to.amount);
        }
        lbl_total.setText(FitIn.fmt_wc_0(total));
    }

    private void add() {
        int id = 0;
//        String user = to_users.ret_user(to_users.username1);
//        JOptionPane.showMessageDialog(null, user);
        String date_added = DateType.datetime.format(dp_date.getDate());


//        JOptionPane.showMessageDialog(null, count);
        String user_name = to_users.ret_user(to_users.username1);
        String amount = "" + FitIn.toDouble(tf_amount.getText());
        int session = S12_cashier_sessions.get_cashier_ses_id(user_name);
        String category_name = cb_category.getSelectedItem().
                toString();
        String purpose = tf_reason.getText();
        if (purpose.isEmpty()) {
            Prompt.call("Complete Details");
            return;
        }
        String vat = "";
        if (cb_vat.isSelected()) {
            vat = "VAT";
        } else {
            vat = "NON VAT";
        }
        int count = DateUtils.count_days(new Date(), dp_date.getDate());
        final to_expenses to = new to_expenses(id, date_added, user_name, amount, purpose, session, category_name, vat);
        if (count < 0) {
            Window p = (Window) this;
            Dlg_authenticate nd = Dlg_authenticate.create(p, true);
            nd.setTitle("");
//            nd.do_pass("");
            nd.setCallback(new Dlg_authenticate.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_authenticate.OutputData data) {
                    closeDialog.ok();
                    S1_expenses.add_data(to);
                    data_cols();
                    clear();
                }

                @Override
                public void show_login_again(CloseDialog closeDialog) {
                    closeDialog.ok();
                }
            });
            nd.setLocationRelativeTo(this);

            nd.setVisible(true);
        } else {
            S1_expenses.add_data(to);
            data_cols();
            clear();
        }

    }

    private void select() {
        int idx = tbl_expenses.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_expenses to = (to_expenses) tbl_expenses_ALM.get(tbl_expenses.
                convertRowIndexToModel(idx));
        Date d = new Date();
        try {
            d = DateType.sf.parse(to.date_added);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_expenses.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
//        dp_date.setDate(d);
        tf_amount.setText(to.amount);
        tf_reason.setText(to.purpose);
        if (to.vat.equals("VAT")) {
            cb_vat.setSelected(true);
        } else {
            cb_vat.setSelected(false);
        }
    }

    private void edit() {

        int idx = tbl_expenses.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_expenses to = (to_expenses) tbl_expenses_ALM.get(tbl_expenses.
                convertRowIndexToModel(idx));

        int id = 0;
        String date_added = DateType.datetime.format(dp_date.getDate());
        String user_name = to_users.ret_user(to_users.username1);
        String amount = "" + FitIn.toDouble(tf_amount.getText());
        String purpose = tf_reason.getText();
        String category_name = cb_category.getSelectedItem().
                toString();
        if (purpose.isEmpty()) {
            Prompt.call("Complete Details");
            return;
        }
        String vat = "";
        if (cb_vat.isSelected()) {
            vat = "VAT";
        } else {
            vat = "NON VAT";
        }
         int count = DateUtils.count_days(new Date(), dp_date.getDate());
        final to_expenses to1 = new to_expenses(to.id, date_added, user_name, amount, purpose, 0, category_name, vat);
        if (count < 0) {
            Window p = (Window) this;
            Dlg_authenticate nd = Dlg_authenticate.create(p, true);
            nd.setTitle("");
//            nd.do_pass("");
            nd.setCallback(new Dlg_authenticate.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_authenticate.OutputData data) {
                    closeDialog.ok();
                    S1_expenses.edit_data(to1);

                    data_cols();
                    clear();
                }

                @Override
                public void show_login_again(CloseDialog closeDialog) {
                    closeDialog.ok();
                }
            });
            nd.setLocationRelativeTo(this);

            nd.setVisible(true);
        } else {
            S1_expenses.edit_data(to1);

            data_cols();
            clear();
        }


    }

    private void delete() {
        int idx = tbl_expenses.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_expenses to = (to_expenses) tbl_expenses_ALM.get(tbl_expenses.
                convertRowIndexToModel(idx));
        to_expenses to1 = new to_expenses(to.id, "", "", "", "", 0, "", "");

        int count = DateUtils.count_days(new Date(), dp_date.getDate());
        if (count < 0) {
            Window p = (Window) this;
            Dlg_authenticate nd = Dlg_authenticate.create(p, true);
            nd.setTitle("");
//            nd.do_pass("");
            nd.setCallback(new Dlg_authenticate.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_authenticate.OutputData data) {
                    closeDialog.ok();
                    S1_expenses.delete_data(to);
                    data_cols();
                    clear();
                }

                @Override
                public void show_login_again(CloseDialog closeDialog) {
                    closeDialog.ok();
                }
            });
            nd.setLocationRelativeTo(this);

            nd.setVisible(true);
        } else {
            S1_expenses.delete_data(to);
            data_cols();
            clear();
        }


//        clear();
    }

    private void clear() {
        tf_amount.setText("");
        tf_reason.setText("");
        dp_date.setDate(new Date());
        tf_amount.grabFocus();
    }

    private void category() {
        Window p = (Window) this;
        Dlg_expenses_categories nd = Dlg_expenses_categories.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_expenses_categories.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_expenses_categories.OutputData data) {
//                closeDialog.ok();
                set_category();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
