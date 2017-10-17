/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.Main;
import POS.guests.Dlg_guest;
import POS.guests.Dlg_room_accomodation;
import POS.rooms.S1_check_in;
import POS.to.to_users;
import POS.transfer_table.Dlg_transfer_table;
import POS.utl.Alert;
import POS.utl.DateType;
import POS_svc4.S2_search;
import POS_svc4.S5_tables;
import de.jgrid.JGrid;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import POS.utl.Center;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;

/**
 *
 * @author Dummy
 */
public class Dlg_check_liquid extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_check
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void check_in(CloseDialog closeDialog, OutputData data);

        void check_out(CloseDialog closeDialog, OutputData data);

        void order(CloseDialog closeDialog, OutputData data);

        void cancel(CloseDialog closeDialog, OutputData data);

        void add_guest(CloseDialog closeDialog, OutputData data);

        void set_order(CloseDialog closeDialog, OutputData data);

        void set_bill(CloseDialog closeDialog, OutputData data);

        void set_prepaid(CloseDialog closeDialog, OutputData data);

        void transfer(CloseDialog closeDialog, OutputData data);

        void accomodation(CloseDialog closeDialog, OutputData data);

        void print_order(CloseDialog closeDialog);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final List<Dlg_check_liquid.to_guests> to1;
        public final double percentages;
        public final int guest_size;
        public final String guest_id;
        public final List<Dlg_check_liquid.to_guests> all_guest;

        public OutputData(List<Dlg_check_liquid.to_guests> to1, double percentages, int guest_size, String guest_id, List<Dlg_check_liquid.to_guests> all_guest) {
            this.to1 = to1;
            this.percentages = percentages;
            this.guest_size = guest_size;
            this.guest_id = guest_id;
            this.all_guest = all_guest;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_check_liquid(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_check_liquid(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_check_liquid() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_check_liquid myRef;

    private void setThisRef(Dlg_check_liquid myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_check_liquid> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_check_liquid create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_check_liquid create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_check_liquid dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_liquid((java.awt.Frame) parent, false);
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
            Dlg_check_liquid dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_liquid((java.awt.Dialog) parent, false);
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

        Dlg_check_liquid dialog = Dlg_check_liquid.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_plus = new javax.swing.JLabel();
        btn_p_check = new Button.Default();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_guest = new javax.swing.JTable();
        btn_p_cancel = new Button.Default();
        btn_p_close2 = new Button.Default();
        btn_p_order = new Button.Default();
        btn_bill = new Button.Default();
        btn_prepaid = new Button.Default();
        btn_transfer = new Button.Default();
        btn_bill1 = new Button.Default();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_plus.setBackground(new java.awt.Color(255, 255, 255));
        lbl_plus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_plus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/user.png"))); // NOI18N
        lbl_plus.setToolTipText("");
        lbl_plus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_plus.setOpaque(true);
        lbl_plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_plusMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 40, 40));

        btn_p_check.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/login.png"))); // NOI18N
        btn_p_check.setText("CHECK IN");
        btn_p_check.setFocusable(false);
        btn_p_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_checkActionPerformed(evt);
            }
        });
        jPanel1.add(btn_p_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 160, 40));

        tbl_guest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_guest);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 320));

        btn_p_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/reload.png"))); // NOI18N
        btn_p_cancel.setText("CLEAR");
        btn_p_cancel.setFocusable(false);
        btn_p_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_p_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 200, 40));

        btn_p_close2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_close2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/letter-x.png"))); // NOI18N
        btn_p_close2.setText("CLOSE");
        btn_p_close2.setFocusable(false);
        btn_p_close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_close2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_p_close2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 200, 40));

        btn_p_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/shopping-basket.png"))); // NOI18N
        btn_p_order.setText("ORDER");
        btn_p_order.setFocusable(false);
        btn_p_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_orderActionPerformed(evt);
            }
        });
        jPanel1.add(btn_p_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 200, 40));

        btn_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/invoice.png"))); // NOI18N
        btn_bill.setText("BILL");
        btn_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_billActionPerformed(evt);
            }
        });
        jPanel1.add(btn_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 200, 40));

        btn_prepaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_prepaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/prepaid-card-in-a-hand.png"))); // NOI18N
        btn_prepaid.setText("PREPAID");
        btn_prepaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prepaidActionPerformed(evt);
            }
        });
        jPanel1.add(btn_prepaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 200, 40));

        btn_transfer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/transfer.png"))); // NOI18N
        btn_transfer.setText("TRANSFER");
        btn_transfer.setFocusable(false);
        btn_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferActionPerformed(evt);
            }
        });
        jPanel1.add(btn_transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 200, 40));

        btn_bill1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_bill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img_default/printer (1).png"))); // NOI18N
        btn_bill1.setText("Print Orders");
        btn_bill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bill1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_bill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 200, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferActionPerformed
        transfer_order();
    }//GEN-LAST:event_btn_transferActionPerformed

    private void btn_p_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_checkActionPerformed
        check_in();
    }//GEN-LAST:event_btn_p_checkActionPerformed

    private void btn_p_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_orderActionPerformed
        order();
    }//GEN-LAST:event_btn_p_orderActionPerformed

    private void lbl_plusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plusMouseClicked
        add_guests();
    }//GEN-LAST:event_lbl_plusMouseClicked

    private void btn_p_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_cancelActionPerformed
        void_order();
    }//GEN-LAST:event_btn_p_cancelActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    }//GEN-LAST:event_formMouseExited

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
    }//GEN-LAST:event_formFocusLost

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    }//GEN-LAST:event_formWindowLostFocus

    private void tbl_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestMouseClicked
        mouseover();
        set_order();
    }//GEN-LAST:event_tbl_guestMouseClicked

    private void btn_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_billActionPerformed
        bill();
    }//GEN-LAST:event_btn_billActionPerformed

    private void btn_prepaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prepaidActionPerformed
        advance();
    }//GEN-LAST:event_btn_prepaidActionPerformed

    private void btn_p_close2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_close2ActionPerformed
        disposed();
    }//GEN-LAST:event_btn_p_close2ActionPerformed

    private void btn_bill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bill1ActionPerformed
        print_order();
    }//GEN-LAST:event_btn_bill1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bill;
    private javax.swing.JButton btn_bill1;
    private javax.swing.JButton btn_p_cancel;
    private javax.swing.JButton btn_p_check;
    private javax.swing.JButton btn_p_close2;
    private javax.swing.JButton btn_p_order;
    private javax.swing.JButton btn_prepaid;
    private javax.swing.JButton btn_transfer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_plus;
    private javax.swing.JTable tbl_guest;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        btn_accomodation.setEnabled(false);
        init_key();
        init_tbl_tables();
//        sample();
    }
    String guest_ids = "";

    private void sample() {
        tbl_tables_ALM.clear();
        List<Dlg_check_liquid.to_guests> tt = new ArrayList();
        tt = tbl_tables_ALM;

        for (int i = 0; i < 10; i++) {
            Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests("" + i, "Ronald Pascua" + i, false, 0, 0, "", "", 0);
            tt.add(to);
        }

        loadData_tables(tt);
    }
    JGrid jg_orders1 = new JGrid();
    DefaultListModel orders_model1 = new DefaultListModel();
    ArrayListModel tbl_table_orders_ALM1;
    int row_selected = 0;
    String room_no = "";
    String type = "";
    double percentage = 0;
    String table_name = "";
    double rates;

    public void do_pass2(JGrid jg_orders, DefaultListModel orders_model, int selected, String room, String types, double percent, String user_id, String status, ArrayListModel tbl_table_orders_ALM, String table_names, double table_rate) {
//        tbl_table_orders_ALM1.clear();
        tbl_tables_ALM.clear();
        tbl_tables_M.fireTableDataChanged();
        rates = table_rate;
        table_name = table_names;
        jg_orders1 = jg_orders;
        orders_model1 = orders_model;
        tbl_table_orders_ALM1 = tbl_table_orders_ALM;
        row_selected = selected;
        room_no = room;
        type = types;
        percentage = percent;
        int check_in = to_users.get_check_ins();
        int check_out = to_users.get_check_outs();
//        JOptionPane.showMessageDialog(null, orders_model1.size());
        set_order();
        final String version = System.getProperty("version", "ordering");
//        if (version.equals("ordering") && user_id.equals("7") || version.equals("ordering") && user_id.equals("")) {
//            if (btn_p_check.getText().
//                    equals("TAKE-OUT")) {
//                btn_p_check.setEnabled(true);
//            } else {
//                btn_p_check.setEnabled(false);
//                btn_p_order.setEnabled(true);
//            }
//        }
//        if (version.equals("ordering") && user_id.equals("0") || user.equals("6") || user.equals("5")) {
//            if (btn_p_check.getText().
//                    equals("TAKE-OUT") || btn_p_check.getText().
//                    equals("DINE IN")) {
//                btn_p_check.setEnabled(true);
//            } else {
//                if (user_id.equals("0")) {
//                    btn_p_order.setEnabled(true);
//                    btn_p_check.setEnabled(true);
//                } else {
////                     btn_p_order.setEnabled(false);
////                    if (check_in == 1) {
////                        btn_p_order.setEnabled(false);
////                        btn_p_check.setEnabled(true);
////                        btn_p_check.setText("CHECK-IN");
////                    } else {
////                        btn_p_order.setEnabled(false);
////                        btn_p_check.setEnabled(true);
////                    }
//                }
//
//
//
//            }
//        }
//
//        if (status.equals("BUSY")) {
//            btn_p_check.setEnabled(true);
//        }
    }

    private void refresh_guest() {
        final String ui_items = System.getProperty("ui_items", "list");
        final String version = System.getProperty("version", "ordering");
        String name = "";
        if (version.equals("ordering")) {
            name = "TABLE";
        } else {
            name = "ROOM";
        }
        List<S5_tables.to_tables2> room = S5_tables.get_tables("");
//       
        Object value = new Object();
        if (ui_items.equals("list")) {
            tbl_table_orders_ALM1.clear();
        } else {
            orders_model1.clear();
            for (S5_tables.to_tables2 t : room) {
                S2_search.to_rooms to = new S2_search.to_rooms(t.no, name, "" + t.name, t.status, t.amount, t.guest_id, t.guest_name, t.date_added, t.name, t.rate, t.to_guest, t.rate_type, t.percentage, t.table_location_id);
                orders_model1.addElement(to);
            }

        }
//         JOptionPane.showMessageDialog(null, row_selected);
        value = orders_model1.getElementAt(row_selected);
        final S2_search.to_rooms t = (S2_search.to_rooms) value;
        List<to_guests> datas = t.to_guest;

        for (to_guests g : datas) {
        }
        selected = -1;
        do_pass(datas, t, user, 0);
    }

    public static class to_guests {

        public final String id;
        public String name;
        public boolean status;
        public final int staff;
        public final int room_guest_id;
        public final String table_guest_ids;
        public final String room_guest_ids;
        public final int table_id;

        public to_guests(String id, String name, boolean status, int staff, int room_guest_id, String table_guest_ids, String room_guest_ids, int table_id) {
            this.id = id;
            this.name = name;
            this.status = status;
            this.staff = staff;
            this.room_guest_id = room_guest_id;
            this.table_guest_ids = table_guest_ids;
            this.room_guest_ids = room_guest_ids;
            this.table_id = table_id;
        }

        public String getId() {
            return id;
        }

        public int getRoom_guest_id() {
            return room_guest_id;
        }

        public String getRoom_guest_ids() {
            return room_guest_ids;
        }

        public int getStaff() {
            return staff;
        }

        public String getTable_guest_ids() {
            return table_guest_ids;
        }

        public int getTable_id() {
            return table_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
//    List<Dlg_check_liquid.to_guests> tbl_tables_ALM = new ArrayList();
    int selected = -1;

    private void mouseover() {
//

        int row = tbl_guest.getSelectedRow();
        if (row < 0) {
            return;
        }
        Dlg_check_liquid.to_guests to = (Dlg_check_liquid.to_guests) tbl_tables_ALM.
                get((row));
        if (to.status == true) {
            to.setStatus(false);
        } else {
            to.setStatus(true);
        }
        tbl_tables_M.fireTableDataChanged();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        int size = 0;
        for (Dlg_check_liquid.to_guests t : datas) {
            if (t.status == true) {
                guest_ids = t.id;
                size++;
            }
        }

        if (datas.size() > 0 && size > 1) {
            guest_ids = "zzz";
        }
    }
    String user = "0";
    int table_location_id = 0;
    int has_other_orders = 0;

    public void do_pass(List<Dlg_check_liquid.to_guests> tt, S2_search.to_rooms t, String user_lvl, int has_other_orders1) {
        has_other_orders = has_other_orders1;

        for (Dlg_check_liquid.to_guests j : tt) {
//            System.out.println(j.status + " --------------");
        }

        tbl_tables_ALM.clear();
        tbl_tables_M.fireTableDataChanged();
        loadData_tables(tt);
        int check_in = to_users.get_check_ins();
        int check_out = to_users.get_check_outs();
        if (user_lvl.equals("7")) {
            user = "7";
            btn_p_check.setEnabled(false);
        } else if (user_lvl.equals("6")) {
            user = "6";
            btn_p_check.setEnabled(false);
        } else {
            user = "0";
            btn_p_check.setEnabled(true);
        }

        table_location_id = t.table_location_id;
        btn_prepaid.setEnabled(false);
        btn_bill.setEnabled(false);

        if (t.status.equalsIgnoreCase("available")) {
            lbl_plus.setEnabled(false);
            btn_transfer.setEnabled(false);
            if (user.equals("6") || user.equals("7")) {

                if (check_in == 1) {

                    if (table_location_id == 0 || table_location_id == 2) {
                        btn_p_order.setEnabled(false);
                    } else {
                        btn_p_order.setEnabled(true);
                    }

                    btn_p_check.setEnabled(true);

                } else {
                    if (check_in == 0 && check_out == 0 && table_location_id == 1) {
                        btn_p_order.setEnabled(true);
                    } else {
                        btn_p_order.setEnabled(true);
                    }

                    btn_p_check.setEnabled(false);
                }
                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            } else {

                btn_p_order.setEnabled(false);
                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            }
            btn_p_cancel.setEnabled(false);
            if (System.getProperty("version", "ordering").
                    equals("ordering")) {
                btn_p_check.setEnabled(true);
                btn_p_order.setEnabled(false);
                btn_p_check.setText("DINE IN");
            }

        } else {

            if (check_out == 0) {

            }
            lbl_plus.setEnabled(true);
            btn_p_check.setEnabled(true);
            btn_prepaid.setEnabled(true);
            btn_bill.setEnabled(true);
            btn_transfer.setEnabled(true);

            final String version = System.getProperty("version", "ordering");
            if (version.equals("ordering")) {
                btn_p_check.setText("PAY");
            } else {
                btn_p_check.setText("CHECK-OUT");
            }
            if (user.equals("6") || user.equals("7") || user.equals("5")) {
                if (check_out == 1) {
                    btn_p_check.setText("CHECK-OUT");

                } else {
                    btn_p_check.setText("PAY");

                }
                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            } else {
                btn_p_order.setEnabled(true);
                btn_prepaid.setEnabled(true);
                btn_bill.setEnabled(true);
            }
            if (check_in == 1) {

            } else {
            }

            if (to_users.user_level1.equals("6") && table_location_id == 0) {
                btn_p_check.setEnabled(false);
            }
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

    private void check_in() {
        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        int count = Main.CountOrders.getCounts();
        if (count > 0) {
            Prompt.call("Guest Has other Charges, Please Settle Bill Downstairs");
            return;
        }
        for (Dlg_check_liquid.to_guests a : datas) {
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }

        if (callback != null) {
            if (btn_p_check.getText().
                    equals("CHECK IN") || btn_p_check.getText().
                    equals("DINE IN")) {
                callback.check_in(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                        size(), guest_ids, tbl_tables_ALM));
                this.dispose();
            } else {
                if (!tbl_tables_ALM.isEmpty() && ok.isEmpty()) {
                    for (Dlg_check_liquid.to_guests a : datas) {

                        Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                        ok.add(to);
                    }
                }
                if (System.getProperty("version", "resto").
                        equals("resto")) {
                    if (tbl_tables_ALM.isEmpty()) {

                    }
                } else {
                }
                if (System.getProperty("version", "resto").
                        equals("ordering")) {
                    if (tbl_tables_ALM.size() == 1) {
                        Dlg_check_liquid.to_guests to = (Dlg_check_liquid.to_guests) tbl_tables_ALM.
                                get((0));
                        ok.add(to);
                    }
                }
                List<Dlg_check_liquid.to_guests> my_guest = tbl_tables_ALM;
                int t = 0;
                for (Dlg_check_liquid.to_guests g : my_guest) {
                    if (g.status == true) {
                        t++;
                    }
                }
                if (t == 0) {
                    Alert.set(0, "Please Select Guest/s!");

                    return;
                }
                this.dispose();
                callback.check_out(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                        size(), guest_ids, tbl_tables_ALM));

            }
        }
    }

    private void order() {

        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        int check_in = to_users.get_check_ins();
        int check_out = to_users.get_check_outs();
        String version = System.getProperty("version", "ordering");
        if (ok.isEmpty()) {
            if (version.equals("resto") && check_in == 0 && table_location_id == 1 || version.
                    equals("resto") && check_in == 1 && table_location_id == 1) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests("" + -1, "Walk-in", true, 0, 0, "", "", 0);
                ok.add(to);
            } else {
                if (user.equals("5") || user.equals("0") || user.equals("6")) {
                    JOptionPane.showMessageDialog(null, "Choose Guest");
                    return;
                } else {
                    if (check_in == 1) {
                        JOptionPane.showMessageDialog(null, "Choose Guest");
                        return;
                    }
                }
            }
        }
        List<Dlg_check_liquid.to_guests> my_guest = tbl_tables_ALM;
        int t = 0;
        for (Dlg_check_liquid.to_guests g : my_guest) {
            if (g.status == true) {
                t++;
            }
        }
        if (t == 0) {
            Alert.set(0, "Please Select Guest/s!");

            return;
        }
        if (callback != null) {
            callback.order(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
            this.dispose();
        }
    }
    double percentag = 0;

    private void add_guests() {
        Object value = orders_model1.getElementAt(row_selected);
        final S2_search.to_rooms t = (S2_search.to_rooms) value;
        String version = System.getProperty("version", "ordering");
        Window p = (Window) this;
        Dlg_guest nd = Dlg_guest.create(p, true);
        nd.setTitle("");
        nd.do_pass(version, room_no, type, percentage, "");
        nd.setCallback(new Dlg_guest.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_guest.OutputData data) {
                closeDialog.ok();
                percentag = data.percentages;
                String id = "0";
                String table_no = t.id;
                String date_added = DateType.datetime.format(new Date());
                double amount = t.topay;
                String or_no = "0";
                String status = "0";
                S1_check_in.to_customer_tables to = new S1_check_in.to_customer_tables(id, table_no, date_added, amount, or_no, status);

                S1_check_in.check_in(to, data.to1, t.room_rate, 1, new ArrayList());

                add_guest();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void add_guest() {

        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        if (callback != null) {
            this.dispose();
            callback.add_guest(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }

    private void void_order() {

        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        if (ok.isEmpty()) {
            for (Dlg_check_liquid.to_guests a : datas) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }

        if (callback != null) {
            this.dispose();
            callback.cancel(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }

    private void transfer_order() {

        final List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        if (ok.isEmpty()) {
            for (Dlg_check_liquid.to_guests a : datas) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }

        Window p = (Window) this;
        Dlg_transfer_table nd = Dlg_transfer_table.create(p, true);
        nd.setTitle("");
        nd.do_pass(ok, table_name, room_no, rates);
        nd.setCallback(new Dlg_transfer_table.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_transfer_table.OutputData data) {
                closeDialog.ok();
                ok_transfer(ok);
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void ok_transfer(List<Dlg_check_liquid.to_guests> ok) {
        if (callback != null) {
            this.dispose();
            callback.transfer(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }

    private void set_order() {
        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        if (callback != null) {
            callback.set_order(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }
    private ArrayListModel tbl_tables_ALM;
    private TbltablesModel tbl_tables_M;

    private void init_tbl_tables() {
        tbl_tables_ALM = new ArrayListModel();
        tbl_tables_M = new TbltablesModel(tbl_tables_ALM);
        tbl_guest.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_guest.setModel(tbl_tables_M);
        tbl_guest.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guest.setRowHeight(25);
        int[] tbl_widths_tables = {0, 100, 60};
        for (int i = 0, n = tbl_widths_tables.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guest, i, tbl_widths_tables[i]);
        }
        Dimension d = tbl_guest.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_guest.getTableHeader().
                setPreferredSize(d);
        tbl_guest.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guest.setRowHeight(35);
        tbl_guest.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tables(List<Dlg_check_liquid.to_guests> acc) {
        tbl_tables_ALM.clear();
        tbl_tables_ALM.addAll(acc);
    }

    public static class TbltablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "NAME", ""
        };

        public TbltablesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 2) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Dlg_check_liquid.to_guests tt = (Dlg_check_liquid.to_guests) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.name;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols() {
        loadData_tables(new ArrayListModel());
    }

    private void bill() {
        String version = System.getProperty("version", "ordering");
        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            if (a.status == true && version.equals("resto") || a.status == true && version.
                    equals("ordering")) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }

        if (ok.isEmpty() && version.equals("resto") || ok.isEmpty() && version.
                equals("ordering")) {
            for (Dlg_check_liquid.to_guests a : datas) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        List<Dlg_check_liquid.to_guests> my_guest = tbl_tables_ALM;
        int t = 0;
        for (Dlg_check_liquid.to_guests g : my_guest) {
            if (g.status == true) {
                t++;
            }
        }
        if (t == 0) {
            Alert.set(0, "Please Select Guest/s!");

            return;
        }
        if (callback != null) {
            callback.set_bill(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }

    private void advance() {
        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status, a.staff, a.room_guest_id, a.table_guest_ids, a.room_guest_ids, a.table_id);
                ok.add(to);
            }
        }
        String version = System.getProperty("version", "ordering");
        if (ok.isEmpty()) {
            Prompt.call("Please Choose One of the guest!!!");
            return;
        } else {
            if (ok.size() > 1) {
                Prompt.call("Please Choose One of the guest!!!");
                return;
            }
        }
        List<Dlg_check_liquid.to_guests> my_guest = tbl_tables_ALM;
        int t = 0;
        for (Dlg_check_liquid.to_guests g : my_guest) {
            if (g.status == true) {
                t++;
            }
        }
        if (t == 0) {
            Alert.set(0, "Please Select Guest/s!");

            return;
        }

        if (callback != null) {
            this.dispose();
            callback.set_prepaid(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }

    private void accomocation() {
        Window p = (Window) this;
        Dlg_room_accomodation nd = Dlg_room_accomodation.create(p, true);
        nd.setTitle("");
        nd.do_pass(room_no, tbl_tables_ALM.size(), tbl_tables_ALM);
        nd.setCallback(new Dlg_room_accomodation.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_room_accomodation.OutputData data) {
                closeDialog.ok();
                accomodation1();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void accomodation1() {
        List<Dlg_check_liquid.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
//        for (Dlg_check_liquid.to_guests a : datas) {
//            System.out.println(a.status);
//            if (a.status == true) {
//                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests(a.id, a.name, a.status);
//                ok.add(to);
//            }
//        }
//        String version = System.getProperty("version", "ordering");
//        if (ok.isEmpty()) {
//            if (version.equals("ordering") || version.equals("resto") && user.equals("6")) {
//                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests("" + -1, "Walk-in", true);
//                ok.add(to);
//            } else {
//                JOptionPane.showMessageDialog(null, "Choose Guest");
//                return;
//            }
//        }
        if (callback != null) {
//            this.dispose();
            callback.accomodation(new CloseDialog(this), new OutputData(ok, percentag, tbl_tables_ALM.
                    size(), guest_ids, tbl_tables_ALM));
        }
    }
    
    private void print_order() {
        if (callback != null) {
            callback.print_order(new CloseDialog(this));
        }
    }
}
