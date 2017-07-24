/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_employees;

import POS.guests.S1_guest;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
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
public class Dlg_employee_advance_payment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_employee_advance_payment
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
    private Dlg_employee_advance_payment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }
    
    private Dlg_employee_advance_payment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }
    
    public Dlg_employee_advance_payment() {
        super();
        initComponents();
        myInit();
        
    }
    private Dlg_employee_advance_payment myRef;
    
    private void setThisRef(Dlg_employee_advance_payment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_employee_advance_payment> dialogContainer = new java.util.HashMap();
    
    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }
    
    public static Dlg_employee_advance_payment create(java.awt.Window parent, boolean modal) {
        
        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }
        
        return create(parent, ModalityType.MODELESS);
        
    }
    
    public static Dlg_employee_advance_payment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {
        
        if (parent instanceof java.awt.Frame) {
            
            Dlg_employee_advance_payment dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_employee_advance_payment((java.awt.Frame) parent, false);
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
            Dlg_employee_advance_payment dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_employee_advance_payment((java.awt.Dialog) parent, false);
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
        
        
        Dlg_employee_advance_payment dialog = Dlg_employee_advance_payment.
                create(new javax.swing.JFrame(), true);
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
        tbl_guests = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_guest_prepaid_payments = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_paid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_guests.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_guests);

        tbl_guest_prepaid_payments.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guest_prepaid_payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guest_prepaid_paymentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_guest_prepaid_payments);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SEARCH:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ENTER AMOUNT TO PAY:");

        tf_paid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("DATE FROM:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DATE  TO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(dp_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        ret_data();
    }//GEN-LAST:event_tf_searchKeyReleased
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void tbl_guestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMouseClicked
        data_cols();
    }//GEN-LAST:event_tbl_guestsMouseClicked
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_guest_prepaid_payments();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_guest_prepaid_payments();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void tbl_guest_prepaid_paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guest_prepaid_paymentsMouseClicked
        select_guest_prepaid_payments();
    }//GEN-LAST:event_tbl_guest_prepaid_paymentsMouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_guest_prepaid_payments();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_guest_prepaid_payments;
    private javax.swing.JTable tbl_guests;
    private javax.swing.JTextField tf_paid;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        tf_search.grabFocus();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        init_tbl_guests();
        ret_data();
        init_tbl_guest_prepaid_payments();
    }

//    String emp_id="";
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
    private ArrayListModel tbl_guests_ALM;
    private TblguestsModel tbl_guests_M;
    
    private void init_tbl_guests() {
        tbl_guests_ALM = new ArrayListModel();
        tbl_guests_M = new TblguestsModel(tbl_guests_ALM);
        tbl_guests.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_guests.setModel(tbl_guests_M);
        tbl_guests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guests.setRowHeight(25);
//        tbl_guests.setAutoResizeMode(0);
        int[] tbl_widths_guests = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};
        for (int i = 0, n = tbl_widths_guests.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guests, i, tbl_widths_guests[i]);
        }
        Dimension d = tbl_guests.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_guests.getTableHeader().
                setPreferredSize(d);
        tbl_guests.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guests.setRowHeight(35);
        tbl_guests.setFont(new java.awt.Font("Arial", 1, 12));
        
    }
    
    private void loadData_guests(List<S1_guest.to_guests> acc) {
        tbl_guests_ALM.clear();
        tbl_guests_ALM.addAll(acc);
    }
    
    public static class TblguestsModel extends AbstractTableAdapter {
        
        public static String[] COLUMNS = {
            "id", "guest_id", "FIRST NAME", "LAST NAME", "MI", "NAME", "EMAIL ADDRESS", "status", "DIVER'S LEVEL", "CONTACT NO", "EM. CONTACT NAME", "PASSPORT NO", "REMARKS", "HOW", "UPDATES", "NAME", "STAFF", "BALANCE"
        };
        
        public TblguestsModel(ListModel listmodel) {
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
            S1_guest.to_guests tt = (S1_guest.to_guests) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.guest_id;
                case 2:
                    return tt.fname;
                case 3:
                    return tt.lname;
                case 4:
                    return tt.mi;
                case 5:
                    return tt.fname + " " + tt.mi + " " + tt.lname;
                case 6:
                    return tt.email_address;
                case 7:
                    return tt.status;
                case 8:
                    return tt.diver_cert_lvl;
                case 9:
                    return tt.contact_no;
                case 10:
                    return tt.emergency_contact_name;
                case 11:
                    return tt.passport_no;
                case 12:
                    return tt.remarks;
                case 13:
                    return tt.how;
                case 14:
                    return tt.newsletter;
                case 15:
                    if (tt.staff == 0) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                
                default:
                    return FitIn.fmt_wc_0(tt.credit);
                
            }
        }
    }
    
    private void ret_data() {
        loadData_guests(S1_guest.ret_data2(tf_search.getText()));
    }
    private ArrayListModel tbl_guest_prepaid_payments_ALM;
    private Tblguest_prepaid_paymentsModel tbl_guest_prepaid_payments_M;
    
    private void init_tbl_guest_prepaid_payments() {
        tbl_guest_prepaid_payments_ALM = new ArrayListModel();
        tbl_guest_prepaid_payments_M = new Tblguest_prepaid_paymentsModel(tbl_guest_prepaid_payments_ALM);
        tbl_guest_prepaid_payments.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_guest_prepaid_payments.setModel(tbl_guest_prepaid_payments_M);
        tbl_guest_prepaid_payments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guest_prepaid_payments.setRowHeight(25);
        int[] tbl_widths_guest_prepaid_payments = {0, 0, 0, 100, 100, 0};
        for (int i = 0, n = tbl_widths_guest_prepaid_payments.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guest_prepaid_payments, i, tbl_widths_guest_prepaid_payments[i]);
        }
        Dimension d = tbl_guest_prepaid_payments.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_guest_prepaid_payments.getTableHeader().
                setPreferredSize(d);
        tbl_guest_prepaid_payments.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guest_prepaid_payments.setRowHeight(35);
        tbl_guest_prepaid_payments.setFont(new java.awt.Font("Arial", 1, 12));
    }
    
    private void loadData_guest_prepaid_payments(List<S1_guest_prepaid_payments.to_guest_prepaid_payments> acc) {
        tbl_guest_prepaid_payments_ALM.clear();
        tbl_guest_prepaid_payments_ALM.addAll(acc);
    }
    
    public static class Tblguest_prepaid_paymentsModel extends AbstractTableAdapter {
        
        public static String[] COLUMNS = {
            "id", "guest_id", "guest_name", "Date Added", "Amount", "user_name"
        };
        
        public Tblguest_prepaid_paymentsModel(ListModel listmodel) {
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
            S1_guest_prepaid_payments.to_guest_prepaid_payments tt = (S1_guest_prepaid_payments.to_guest_prepaid_payments) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.guest_id;
                case 2:
                    return tt.guest_name;
                case 3:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 4:
                    return FitIn.fmt_wc_0(tt.paid);
                default:
                    return tt.user_name;
            }
        }
    }
    
    private void data_cols() {
        
        int row = tbl_guests.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_guest.to_guests to = (S1_guest.to_guests) tbl_guests_ALM.get(tbl_guests.
                convertRowIndexToModel(row));
        loadData_guest_prepaid_payments(S1_guest_prepaid_payments.ret_data("" + to.guest_id));
        
    }
    
    private void add_guest_prepaid_payments() {
        int id = -1;
        int row = tbl_guests.getSelectedRow();
        if (row < 0) {
            Prompt.call("Please Select Staff");
            return;
        }
        S1_guest.to_guests to = (S1_guest.to_guests) tbl_guests_ALM.get(tbl_guests.
                convertRowIndexToModel(row));
        String guest_id = to.guest_id;
        String guest_name = to.fname + " " + to.mi + " " + to.fname;
        double paid = FitIn.toDouble(tf_paid.getText());
        String date_added = DateType.datetime.format(new Date());
        String user_name = to_users.username1;
        S1_guest_prepaid_payments.to_guest_prepaid_payments to1 = new S1_guest_prepaid_payments.to_guest_prepaid_payments(
                id, guest_id, guest_name, paid, date_added, user_name);
        S1_guest_prepaid_payments.add_guest_prepaid_payments(to1);
        data_cols();
        clear_guest_prepaid_payments();
        ret_data();
    }
    
    private void select_guest_prepaid_payments() {
        int row = tbl_guest_prepaid_payments.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_guest_prepaid_payments.to_guest_prepaid_payments to =
                (S1_guest_prepaid_payments.to_guest_prepaid_payments) tbl_guest_prepaid_payments_ALM.
                get(tbl_guest_prepaid_payments.convertRowIndexToModel(row));
//        tf_guest_id.setText(to.guest_id);
//        tf_guest_name.setText(to.guest_name);
        tf_paid.setText(FitIn.fmt_wc_0(to.paid));
//        tf_date_added.setText(to.date_added);
//        tf_user_name.setText(to.user_name);
    }
    
    private void edit_guest_prepaid_payments() {
        int row = tbl_guest_prepaid_payments.getSelectedRow();
        if (row < 0) {
            Prompt.call("Please Select Staff");
            return;
        }
        S1_guest_prepaid_payments.to_guest_prepaid_payments to = (S1_guest_prepaid_payments.to_guest_prepaid_payments) tbl_guest_prepaid_payments_ALM.
                get(tbl_guest_prepaid_payments.convertRowIndexToModel(row));
        int id = to.id;
        String guest_id = to.guest_id;
        String guest_name = to.guest_name;
        double paid = FitIn.toDouble(tf_paid.getText());
        String date_added = DateType.datetime.format(new Date());
        String user_name = to_users.username1;
        S1_guest_prepaid_payments.to_guest_prepaid_payments to1 = new S1_guest_prepaid_payments.to_guest_prepaid_payments(
                id, guest_id, guest_name, paid, date_added, user_name);
        S1_guest_prepaid_payments.edit_guest_prepaid_payments(to1);
        data_cols();
        clear_guest_prepaid_payments();
        ret_data();
    }
    
    private void clear_guest_prepaid_payments() {
//        tf_guest_id.setText("");
//        tf_guest_name.setText("");
        tf_paid.setText("");
//        tf_date_added.setText("");
//        tf_user_name.setText("");
    }
    
    private void delete_guest_prepaid_payments() {
        int row = tbl_guest_prepaid_payments.getSelectedRow();
        if (row < 0) {
            Prompt.call("Please Select Staff");
            return;
        }
        S1_guest_prepaid_payments.to_guest_prepaid_payments to = (S1_guest_prepaid_payments.to_guest_prepaid_payments) tbl_guest_prepaid_payments_ALM.
                get(tbl_guest_prepaid_payments.convertRowIndexToModel(row));
        S1_guest_prepaid_payments.delete_guest_prepaid_payments(to);
        data_cols();
        clear_guest_prepaid_payments();
        ret_data();
    }
}
