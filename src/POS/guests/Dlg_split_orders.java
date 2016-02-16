/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import test.Dlg_check_liquid;
import test.Dlg_check_liquid.to_guests;

/**
 *
 * @author Maytopacka
 */
public class Dlg_split_orders extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_split_orders
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

        public final List<Dlg_check_liquid.to_guests> split_guest;

        public OutputData(List<to_guests> split_guest) {
            this.split_guest = split_guest;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_split_orders(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_split_orders(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_split_orders() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_split_orders myRef;

    private void setThisRef(Dlg_split_orders myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_split_orders> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_split_orders create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_split_orders create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_split_orders dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_split_orders((java.awt.Frame) parent, false);
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
            Dlg_split_orders dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_split_orders((java.awt.Dialog) parent, false);
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


        Dlg_split_orders dialog = Dlg_split_orders.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_room_guests = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_guest = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_count = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_room_guests.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_room_guests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_room_guestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_room_guests);

        jLabel1.setText("SEARCH GUEST:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_guest.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_guest);

        jLabel2.setText("SELECTED GUEST/S:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("COUNT:");

        lbl_count.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_count, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lbl_count, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_cols();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tbl_room_guestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_room_guestsMouseClicked
        add_staff();
    }//GEN-LAST:event_tbl_room_guestsMouseClicked

    private void tbl_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestMouseClicked
        remove_guest();
    }//GEN-LAST:event_tbl_guestMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JTable tbl_guest;
    private javax.swing.JTable tbl_room_guests;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        init_tbl_room_guests();
        init_tbl_tables();
    }

    public void do_pass(List<Dlg_check_liquid.to_guests> datas) {
        tbl_tables_ALM.addAll(datas);
        tbl_tables_M.fireTableDataChanged();
        count_guest();
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
    private ArrayListModel tbl_room_guests_ALM;
    private Tblroom_guestsModel tbl_room_guests_M;

    private void init_tbl_room_guests() {
        tbl_room_guests_ALM = new ArrayListModel();
        tbl_room_guests_M = new Tblroom_guestsModel(tbl_room_guests_ALM);
        tbl_room_guests.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_room_guests.setModel(tbl_room_guests_M);
        tbl_room_guests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_room_guests.setRowHeight(25);
        int[] tbl_widths_room_guests = {0, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_room_guests.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_room_guests, i, tbl_widths_room_guests[i]);
        }
        Dimension d = tbl_room_guests.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_room_guests.getTableHeader().
                setPreferredSize(d);
        tbl_room_guests.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_room_guests.setRowHeight(35);
        tbl_room_guests.setFont(new java.awt.Font("Arial", 1, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_room_guests, 2);
    }

    private void loadData_room_guests(List<S1_room_guests.to_room_guests> acc) {
        tbl_room_guests_ALM.clear();
        tbl_room_guests_ALM.addAll(acc);
    }

    public static class Tblroom_guestsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "GUEST", "ROOM", "guest_name", "checkin_date", "checkout_date", "status", "to_pay", "paid", "room_rate", "staff"
        };

        public Tblroom_guestsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 11) {
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
            S1_room_guests.to_room_guests tt = (S1_room_guests.to_room_guests) getRow(row);
            switch (col) {
                case 0:
                    return tt.rooom_id;
                case 1:
                    return tt.guest_name;
                case 2:
                    return tt.checkin_date;
                case 3:
                    return tt.guest_name;
                case 4:
                    return tt.checkin_date;
                case 5:
                    return tt.checkout_date;
                case 6:
                    return tt.status;
                case 7:
                    return tt.to_pay;
                case 8:
                    return tt.paid;
                case 9:
                    return tt.room_rate;
                default:
                    return tt.staff;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        loadData_room_guests(S1_room_guests.ret_data(search));
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
        int[] tbl_widths_tables = {0, 100, 0};
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
            "id", "GUEST", ""
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

    private void add_staff() {
        int row = tbl_room_guests.getSelectedRow();
        if (row < 0) {
            return;
        }
        S1_room_guests.to_room_guests to = (S1_room_guests.to_room_guests) tbl_room_guests_ALM.
                get(tbl_room_guests.convertRowIndexToModel(row));
        String id = to.guest_id;
        String name = to.guest_name;
        boolean status = true;
        int staff = to.staff;
        int room_guest_id = to.rooom_id;
        String table_ids = "" + to.rooom_id;
        String room_guest_ids = to.room_guest_ids;
        Dlg_check_liquid.to_guests tt = new Dlg_check_liquid.to_guests(id, name, status, staff, room_guest_id, to.table_ids, to.room_guest_ids,to.rooom_id);
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        int i = 0;
        for (Dlg_check_liquid.to_guests g : datas) {
            if (id.equalsIgnoreCase(g.id)) {
                i = 1;
                break;
            }
        }
        if (i == 1) {
            Prompt.call("GUEST ALREADY ADDED");
        } else {
            tbl_tables_ALM.add(tt);
            tbl_tables_M.fireTableDataChanged();
        }
        count_guest();
    }

    private void remove_guest() {
        int row = tbl_guest.getSelectedRow();
        if (row < 0) {
            return;
        }
        Dlg_check_liquid.to_guests to = (Dlg_check_liquid.to_guests) tbl_tables_ALM.
                get(tbl_room_guests.convertRowIndexToModel(row));
        tbl_tables_ALM.remove(row);
        tbl_tables_M.fireTableDataChanged();
        count_guest();
    }

    private void count_guest() {
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        lbl_count.setText("" + datas.size());
    }

    private void ok1() {
        List<Dlg_check_liquid.to_guests> datas = tbl_tables_ALM;
        if (datas.isEmpty()) {
            Prompt.call("SELECT GUEST/S");
            return;
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(datas));
        }
    }
}
