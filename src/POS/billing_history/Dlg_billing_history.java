/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.billing_history;

import POS.billing_history.S1_billing_guest.to_billing_guest;
import POS.billing_history.S1_billing_history.to_billing_histories;
import POS.category_discounts.S1_category_discounts;
import POS.currency.S1_currency;
import POS.pnl.Dashboard;
import POS.utl.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import rpt_liquid.*;

/**
 *
 * @author Maytopacka
 */
public class Dlg_billing_history extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_billing_history
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
    private Dlg_billing_history(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_billing_history(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_billing_history() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_billing_history myRef;

    private void setThisRef(Dlg_billing_history myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_billing_history> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_billing_history create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_billing_history create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_billing_history dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_history((java.awt.Frame) parent, false);
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
            Dlg_billing_history dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_history((java.awt.Dialog) parent, false);
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

        Dlg_billing_history dialog = Dlg_billing_history.create(new javax.swing.JFrame(), true);
//        FullScreen.do_max_normal(dialog);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
//        frame.setVisible(true);
        dialog.setSize(xSize, ySize);
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
        pnl_rpt = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_billing_histories = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_billing_guest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_orders = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_rptLayout = new javax.swing.GroupLayout(pnl_rpt);
        pnl_rpt.setLayout(pnl_rptLayout);
        pnl_rptLayout.setHorizontalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );
        pnl_rptLayout.setVerticalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_billing_histories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_billing_histories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_billing_historiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_billing_histories);

        tbl_billing_guest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_billing_guest);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CHECK OUT DATE:");

        jLabel2.setText("FROM:");

        jLabel3.setText("TO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("SEARCH GUEST:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ROOMS");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_orders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_orders.setText("ORDERS");
        cb_orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ordersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dp_to, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(cb_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_orders))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_billing_historiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_billing_historiesMouseClicked
        data_cols_guest();
//        get_billing_items();
    }//GEN-LAST:event_tbl_billing_historiesMouseClicked

    private void cb_ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ordersActionPerformed
        data_cols_guest();
    }//GEN-LAST:event_cb_ordersActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb_orders;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnl_rpt;
    private javax.swing.JTable tbl_billing_guest;
    private javax.swing.JTable tbl_billing_histories;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant_liquid");
        init_key();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        dp_from.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols();
            }
        });

        dp_to.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols();
            }
        });

        tf_search.grabFocus();
        init_tbl_billing_histories();
        data_cols();
        init_tbl_billing_guest();
    }

    public void do_pass() {
        tf_search.grabFocus();
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
    private ArrayListModel tbl_billing_histories_ALM;
    private Tblbilling_historiesModel tbl_billing_histories_M;

    private void init_tbl_billing_histories() {
        tbl_billing_histories_ALM = new ArrayListModel();
        tbl_billing_histories_M = new Tblbilling_historiesModel(tbl_billing_histories_ALM);
        tbl_billing_histories.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_billing_histories.setModel(tbl_billing_histories_M);
        tbl_billing_histories.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_billing_histories.setRowHeight(25);
        int[] tbl_widths_billing_histories = {0, 0, 100, 0, 0, 0, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_billing_histories.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_billing_histories, i, tbl_widths_billing_histories[i]);
        }
        Dimension d = tbl_billing_histories.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_billing_histories.getTableHeader().
                setPreferredSize(d);
        tbl_billing_histories.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_billing_histories.setRowHeight(35);
        tbl_billing_histories.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_billing_histories(List<to_billing_histories> acc) {
        tbl_billing_histories_ALM.clear();
        tbl_billing_histories_ALM.addAll(acc);
    }

    public static class Tblbilling_historiesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "room_id", "ROOM", "guest_ids", "guest_names", "checkin_date", "DATE", "status", "gross_sales", "NET PAY", "adv_peso", "adv_usd", "paid_peso", "paid_dollar", "paid_credit", "dollar_rate", "discount", "discount_rate", "discount_name", "room_guest_ids", "user_name", "credit_card"
        };

        public Tblbilling_historiesModel(ListModel listmodel) {
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
            to_billing_histories tt = (to_billing_histories) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.room_id;
                case 2:
                    return tt.room_name;
                case 3:
                    return tt.guest_ids;
                case 4:
                    return tt.guest_names;
                case 5:
                    return tt.checkin_date;
                case 6:
                    return DateType.convert_jan_1_2013_datetime(tt.checkout_date);
                case 7:
                    return tt.status;
                case 8:
                    return tt.gross_sales;
                case 9:
                    return FitIn.fmt_wc_0(tt.to_pay);
                case 10:
                    return tt.adv_peso;
                case 11:
                    return tt.adv_usd;
                case 12:
                    return tt.paid_peso;
                case 13:
                    return tt.paid_dollar;
                case 14:
                    return tt.paid_credit;
                case 15:
                    return tt.dollar_rate;
                case 16:
                    return tt.discount;
                case 17:
                    return tt.discount_rate;
                case 18:
                    return tt.discount_name;
                case 19:
                    return tt.room_guest_ids;
                case 20:
                    return tt.user_name;
                default:
                    return tt.credit_card;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        loadData_billing_histories(S1_billing_history.ret_data(search, date_from, date_to));
    }

    private void set_guest() {
    }
    private ArrayListModel tbl_billing_guest_ALM;
    private Tblbilling_guestModel tbl_billing_guest_M;

    private void init_tbl_billing_guest() {
        tbl_billing_guest_ALM = new ArrayListModel();
        tbl_billing_guest_M = new Tblbilling_guestModel(tbl_billing_guest_ALM);
        tbl_billing_guest.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_billing_guest.setModel(tbl_billing_guest_M);
        tbl_billing_guest.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_billing_guest.setRowHeight(25);
        int[] tbl_widths_billing_guest = {0, 0, 100};
        for (int i = 0, n = tbl_widths_billing_guest.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_billing_guest, i, tbl_widths_billing_guest[i]);
        }
        Dimension d = tbl_billing_guest.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_billing_guest.getTableHeader().
                setPreferredSize(d);
        tbl_billing_guest.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_billing_guest.setRowHeight(35);
        tbl_billing_guest.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_billing_guest(List<to_billing_guest> acc) {
        tbl_billing_guest_ALM.clear();
        tbl_billing_guest_ALM.addAll(acc);
    }

    public static class Tblbilling_guestModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "guest_id", "GUEST/S"
        };

        public Tblbilling_guestModel(ListModel listmodel) {
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
            to_billing_guest tt = (to_billing_guest) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.guest_id;
                default:
                    return tt.guest_name;
            }
        }
    }

    private void data_cols_guest() {
        int row = tbl_billing_histories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_billing_histories to = (to_billing_histories) tbl_billing_histories_ALM.
                get(tbl_billing_histories.convertRowIndexToModel(row));
        List<to_billing_guest> datas = new ArrayList();
        to_billing_guest to1 = new to_billing_guest(to.id, to.guest_ids, to.guest_names);
        datas.add(to1);
        loadData_billing_guest(datas);
        List<S1_billing_history_items.to_billing_history_items> items = S1_billing_history_items.
                ret_data("" + to.id);

        List<Srpt_bar_and_resto.field> resto_items = new ArrayList();
        List<Srpt_bar_and_resto.field> bar_items = new ArrayList();

        String busi_name = System.getProperty("business_name", "");
        double room_rate = 100;
        String accomodation = "";// + (count) + " x nights @ " + FitIn.fmt_wc_0(table_rate);   
        String img_path = System.getProperty("img_path", "C:\\Users\\Maytopacka\\");
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
        List<Srpt_bar_and_resto.field> rpt_bar_and_resto = new ArrayList();
        List<Srpt_bar_and_resto.field> rpt_bar = new ArrayList();
        List<Srpt_bar_and_resto.field> regroup = new ArrayList();
        List<Srpt_bar_and_resto.field> regroup3 = new ArrayList();
        List<Srpt_others.field> rpt_others = new ArrayList();
        List<Srpt_accomodation.field> accom = new ArrayList();
        double accom_total = 0;
        double to_pay = to.to_pay;
        double total_charges = 0;
        double ch = 0;
        double bar_resto = 0;
//        accom.clear();
        String resto_f_date = "";
        String bar_f_date = "";
        for (S1_billing_history_items.to_billing_history_items t1 : items) {
            Date date = new Date();

            int r_f = 0;
            int r_b = 0;
            try {
                date = DateType.datetime.parse(t1.date_added);
            } catch (ParseException ex) {
                Logger.getLogger(Dlg_billing_history.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

            if (t1.cat_id.equals("10")) {

                double am = (t1.price * t1.qty) - t1.discount_amount;

                Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field("RESTO", date, am, t1.qty, t1.discount_amount);
                regroup.add(tbar);

                String s = DateType.sf.format(date) + " 00:00:00";
                Date d1 = new Date();
                try {
                    d1 = DateType.datetime.parse(s);
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_billing_history.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

                Srpt_bar_and_resto.field tbar2 = new Srpt_bar_and_resto.field(t1.description, d1, am, t1.qty, t1.discount_amount);
                resto_items.add(tbar2);
                if (r_f == 0) {
                    resto_f_date = DateType.sf.format(date);
                }
                ch += am;
                bar_resto += t1.price;
                r_f++;
            } else if (t1.cat_id.equals("12")) {
//                System.out.println("t1: "+t1.description+ " am: "+t1.price+ " dis: "+t1.discount_amount);
                double am = (t1.price * t1.qty) - t1.discount_amount;
//                System.out.println("desc: "+t1.description+ " price: "+t1.price+ " disc: "+t1.discount_amount);
                Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field("BAR", date, am, t1.qty, t1.discount_amount);
                regroup3.add(tbar);
//                System.out.println(tbar);
                String s = DateType.sf.format(date) + " 00:00:00";
                Date d1 = new Date();
                try {
                    d1 = DateType.datetime.parse(s);
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_billing_history.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                Srpt_bar_and_resto.field tbar2 = new Srpt_bar_and_resto.field(t1.description, d1, am, t1.qty, t1.discount_amount);
                bar_items.add(tbar2);
                if (r_b == 0) {
                    bar_f_date = DateType.sf.format(date);
                }
                ch += am;
                bar_resto += t1.price;
                r_b++;
            } else if (t1.cat_id.equals("11")) {
                Date now = new Date();
                Date date_added = new Date();

                try {
                    date_added = DateType.datetime.parse(t1.date_added);
                } catch (ParseException ex) {
                    Logger.getLogger(Dashboard.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
//                        z
                double qty = t1.qty;
                int nights = 1;
                String description = t1.description;
                double price = 0;
                double am = (t1.price * t1.qty) - t1.discount_amount;
                double amount = am;
                nights = 1;
                nights = FitIn.toInt("" + qty);
//                        JOptionPane.showMessageDialog(null, amount);
                String date_stayed = "( " + DateType.month_date.format(date_added) + " - " + DateType.month_date.
                        format(now) + " )" + to.guest_names.toUpperCase();
                Srpt_accomodation.field t = new Srpt_accomodation.field(qty, nights, description, price, am, date_stayed, "ACCOMODATION", t1.discount_amount);
                accom.add(t);
                accom_total += amount;
            } else {
                double am = (t1.price * t1.qty) - t1.discount_amount;
                Srpt_others.field tbar = new Srpt_others.field(t1.cat_name.
                        toUpperCase(), t1.description, t1.qty, am, t1.discount_amount);
                rpt_others.add(tbar);
                ch += am;
            }
        }
        String my_data = "";
        List<Srpt_bar_and_resto.field> regroup2 = new ArrayList();
        List<String> resto_dates = new ArrayList();
        resto_dates.add(resto_f_date);
        for (Srpt_bar_and_resto.field ss : regroup) {
            if (!DateType.sf.format(ss.getDate_added()).
                    equals(my_data)) {
                Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field(ss.
                        getDesc().
                        toUpperCase(), ss.getDate_added(), ss.getTotal(), ss.
                        getQty(), ss.getDiscount_amount());
                regroup2.add(tbar);
            }
            my_data = DateType.sf.format(ss.getDate_added());
//            }

//            my_data = DateType.sf.format(ss.getDate_added());
//            System.out.println(my_data + " -------  ");
        }

        for (String s : resto_dates) {
            System.out.println(s + " ---- ");
        }
        for (Srpt_bar_and_resto.field ss2 : regroup2) {
//            System.out.println(ss2.getDesc()+ " *********");
            double am = 0;
            double qty = 0;
            double dis = 0;
            for (Srpt_bar_and_resto.field ss : regroup) {
                if (DateType.sf.format(ss2.getDate_added()).
                        equals(DateType.sf.format(ss.getDate_added()))) {
                    am += ss.getTotal();
                    dis += ss.getDiscount_amount();
                }
            }
            Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field(ss2.
                    getDesc().
                    toUpperCase(), ss2.getDate_added(), am, ss2.getQty(), dis);
            rpt_bar_and_resto.add(tbar);

        }

        String my_data3 = "";
        List<Srpt_bar_and_resto.field> regroup33 = new ArrayList();
        for (Srpt_bar_and_resto.field ss : regroup3) {
            if (!DateType.sf.format(ss.getDate_added()).
                    equals(my_data3)) {
                Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field(ss.
                        getDesc().
                        toUpperCase(), ss.getDate_added(), ss.getTotal(), ss.
                        getQty(), ss.getDiscount_amount());
                regroup33.add(tbar);

            }
            my_data3 = DateType.sf.format(ss.getDate_added());
        }

        for (Srpt_bar_and_resto.field ss2 : regroup33) {
//            System.out.println(ss2.getDesc()+ " *********");
            double am = 0;
            double qty = 0;
            double dis = 0;
            for (Srpt_bar_and_resto.field ss : regroup3) {
                if (DateType.sf.format(ss2.getDate_added()).
                        equals(DateType.sf.format(ss.getDate_added()))) {
                    am += ss.getTotal();
                    dis += ss.getDiscount_amount();
                }
            }
//            am = am - dis;
//            System.out.println("am: "+am);
            Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field(ss2.
                    getDesc().
                    toUpperCase(), ss2.getDate_added(), am, ss2.getQty(), dis);

            rpt_bar.add(tbar);
        }

        List<Srpt_others.field> accom2 = new ArrayList();

        List<String> cats = S1_category.ret_cb_data();
        for (String s : cats) {
//                      System.out.println(s +" ---------------------------");
            for (Srpt_others.field a : rpt_others) {
//                           System.pr                     
                if (s.equalsIgnoreCase(a.getCategory())) {
                    accom2.add(a);
                }
            }
        }
        List<Srpt_accomodation.field> accom3 = new ArrayList();
        accom3 = accom;
        String my_date = "Billing Statement";
        String day = DateType.d.format(new Date());
        Date d = new Date();
        try {
            d = DateType.datetime.parse(to.checkout_date);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_billing_history.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        my_date = DateType.day.format(new Date()) + " " + day + " " + DateType.month_year.
                format(d) + ": Billing";
        String accomodation_1 = "";
        double dollar = to.dollar_rate;
        total_charges = ch;
        double bank_php = to.adv_peso + to.bank_php;
        double cash_usd = to.adv_usd * to.dollar_rate;
        double bank_usd = to.bank_usd * to.dollar_rate;
        double usd = cash_usd + bank_usd;
//        System.out.println("Total Charges: " + total_charges + " accom_total: " + accom_total);
//        System.out.println("bank_php: " + bank_php + " usd: " + usd + " to.credit_card: " + to.credit_card+ " to.discount: "+to.discount);
        to_pay = (total_charges + accom_total) - (bank_php + usd + to.credit_card + to.discount);
        double discount = to.discount;
        double dollar_rate = S1_currency.ret_dollar(DateType.sf.format(new Date()));
        List<Srpt_history_advance_payments.field> advances = Srpt_history_advance_payments.
                ret_data(to.room_guest_ids);
        List<S1_category_discounts.to_category_discounts> category_discounts = S1_category_discounts.
                ret_data(to.room_guest_ids);
        List<Srpt_category_discounts.field> cdd = new ArrayList();

        for (S1_category_discounts.to_category_discounts cd : category_discounts) {
            if (cd.discount_amount != 0) {
                String category = cd.category_name;
                double due = cd.due;
                double disc_percent = cd.discount_percent;
                double disc_amount = cd.discount_amount;
                double sub_total = cd.due - cd.discount_amount;
                Srpt_category_discounts.field tbar = new Srpt_category_discounts.field(category, due, disc_percent, disc_amount, sub_total);
                cdd.add(tbar);
            }
        }
        double dollar_to_pay = to_pay / dollar_rate;
        String s = df.format(dollar_to_pay);
        dollar_to_pay = FitIn.toDouble(s);
        if (cb_orders.isSelected()) {
            to_pay = bar_resto;
            to_pay = FitIn.toDouble(df2.format(to_pay));
            Srpt_liquid_billing rpt = new Srpt_liquid_billing(busi_name, room_rate, accomodation,
                    SUBREPORT_DIR, resto_items, bar_items, accom2, accom3, advances, cdd, my_date, to.guest_ids, to.room_id,
                    to.checkin_date, "", accomodation_1, accom_total, img_path, to_pay, to.guest_names, dollar, total_charges,
                    discount, dollar_rate, to.adv_peso, to.adv_usd, to.paid_peso, to.paid_dollar, to.paid_credit, to.bank_php,
                    to.bank_usd, to.credit_card, dollar_to_pay, new ArrayList());
            report_get_viewer_session(rpt, "rpt_billing_liquid_items.jrxml");

        } else {
            to_pay = FitIn.toDouble(df2.format(to_pay));
            Srpt_liquid_billing rpt = new Srpt_liquid_billing(busi_name, room_rate, accomodation,
                    SUBREPORT_DIR, rpt_bar_and_resto, rpt_bar, accom2, accom3, advances, cdd, my_date, to.guest_ids, to.room_id,
                    to.checkin_date, "", accomodation_1, accom_total, img_path, to_pay, to.guest_names, dollar,
                    total_charges, discount, dollar_rate, to.adv_peso, to.adv_usd, to.paid_peso, to.paid_dollar,
                    to.paid_credit, to.bank_php, to.bank_usd, to.credit_card, dollar_to_pay, new ArrayList());
            report_get_viewer_session(rpt, "rpt_billing_liquid_paid.jrxml");
        }

    }
    DecimalFormat df = new DecimalFormat("#,###");
    DecimalFormat df2 = new DecimalFormat("#,##0");

    private void get_billing_items() {
        int row = tbl_billing_histories.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_billing_histories to = (to_billing_histories) tbl_billing_histories_ALM.
                get(tbl_billing_histories.convertRowIndexToModel(row));

        List<S1_billing_history_items.to_billing_history_items> datas = S1_billing_history_items.
                ret_data("" + to.id);
//        JOptionPane.showMessageDialog(null, datas.size());
    }

    public static JasperReport compileJasper(String jrxml) {
        try {
//            String jrxml = jrxml;
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_conn(Srpt_liquid_billing to, String rpt_name) {
//        Connection con11 = null;
        try {
//            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }

    private void report_get_viewer_session(final Srpt_liquid_billing to, String jrxml_name) {
        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_conn(to, jrxml_name);

            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_rpt.add(viewer);
            pnl_rpt.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
