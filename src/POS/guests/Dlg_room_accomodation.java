/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.guests.S1_room_accomodation.to_room_accomodations;
import POS.utl.Prompt;
import POS.utl.TableUtility;
import POS_svc4.S2_search;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import test.Dlg_check_liquid;

/**
 *
 * @author i1
 */
public class Dlg_room_accomodation extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_room_accomodation
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
    private Dlg_room_accomodation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_room_accomodation(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_room_accomodation() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_room_accomodation myRef;

    private void setThisRef(Dlg_room_accomodation myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_room_accomodation> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_room_accomodation create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_room_accomodation create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_room_accomodation dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_room_accomodation((java.awt.Frame) parent, false);
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
            Dlg_room_accomodation dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_room_accomodation((java.awt.Dialog) parent, false);
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


        Dlg_room_accomodation dialog = Dlg_room_accomodation.create(new javax.swing.JFrame(), true);
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
        tbl_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_room_accomodations = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_items);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHOOSE ACCOMODATION");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_room_accomodations.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_room_accomodations);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MY ACCOMODATION");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("SEARCH:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(507, 507, 507)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        load_data();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        add();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cancel_accom();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTable tbl_room_accomodations;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
//        Main.MyDB.setNames("db_pos_restaurant");

        init_tbl_room_accomodations();
        data_cols();
        init_tbl_customer_tables_details();
        load_data();


    }
    int guest_size = 0;
    List<Dlg_check_liquid.to_guests> my_guest = new ArrayList();

    public void do_pass(String table_ids, int guest_sizes, List<Dlg_check_liquid.to_guests> guests) {

        my_guest.clear();
        my_guest = guests;
        table_id = table_ids;
        guest_size = guest_sizes;

        data_cols();
        load_data();
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
    private ArrayListModel tbl_customer_tables_details_ALM;
    private Dlg_guest.Tblcustomer_tables_detailsModel tbl_customer_tables_details_M;

    private void init_tbl_customer_tables_details() {
        tbl_customer_tables_details_ALM = new ArrayListModel();
        tbl_customer_tables_details_M = new Dlg_guest.Tblcustomer_tables_detailsModel(tbl_customer_tables_details_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_customer_tables_details_M);
        tbl_items.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int amount = 0;
//        if (my_order == 1) {
//            amount = 100;
//        }
        int[] tbl_widths_customer_tables_details = {0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customer_tables_details.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_customer_tables_details[i]);
        }
        TableUtility.align_row_to_Center(tbl_items, 2);
        TableUtility.align_row_to_Center(tbl_items, 4);
        TableUtility.align_column_to_Center(tbl_items, 2);
        TableUtility.align_column_to_Center(tbl_items, 4);
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        tbl_items.setRowHeight(35);
        tbl_items.setFont(new java.awt.Font("Arial", 1, 12));

    }

    private void loadData_customer_tables_details(List<S2_search.to_items> acc) {
        tbl_customer_tables_details_ALM.clear();
        tbl_customer_tables_details_ALM.addAll(acc);
    }

    public static class Tblcustomer_tables_detailsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "name", "uom", "QTY", "DESCRIPTION", "PRICE", "img_path", "AMOUNT", "guest_id", "cat_id", "category_name", "printing_assembly", "status", "disc_name", "disc_rate", "discount", "customer_name", "customer_id", "customer_address"
        };

        public Tblcustomer_tables_detailsModel(ListModel listmodel) {
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
            S2_search.to_items tt = (S2_search.to_items) getRow(row);
            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.uom;
                case 2:
                    return FitIn.toInt("" + tt.qty);
                case 3:
                    return tt.desc;
                case 4:
                    return FitIn.fmt_wc_0(tt.price);
                case 5:
                    return tt.img_path;
                case 6:
                    return FitIn.fmt_wc_0(tt.qty * tt.price);
                case 7:
                    return tt.guest_id;
                case 8:
                    return tt.cat_id;
                case 9:
                    return tt.category_name;
                case 10:
                    return tt.printing_assembly;
                case 11:
                    return tt.status;
                case 12:
                    return tt.disc_name;
                case 13:
                    return tt.disc_rate;
                case 14:
                    return tt.discount;
                case 15:
                    return tt.customer_name;
                case 16:
                    return tt.customer_id;
                default:
                    return tt.customer_address;
            }
        }
    }

    private void load_data() {
        List<S2_search.to_items> results = new ArrayList();

        String search = tf_search.getText();
        results = S2_search.ret_items("11", search, "1", 0);
        loadData_customer_tables_details(results);
    }
    private ArrayListModel tbl_room_accomodations_ALM;
    private Tblroom_accomodationsModel tbl_room_accomodations_M;

    private void init_tbl_room_accomodations() {
        tbl_room_accomodations_ALM = new ArrayListModel();
        tbl_room_accomodations_M = new Tblroom_accomodationsModel(tbl_room_accomodations_ALM);
        tbl_room_accomodations.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_room_accomodations.setModel(tbl_room_accomodations_M);
        tbl_room_accomodations.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_room_accomodations.setRowHeight(25);
        int[] tbl_widths_room_accomodations = {0, 0, 0, 120, 0, 0, 0, 100, 0, 100};
        for (int i = 0, n = tbl_widths_room_accomodations.length; i < n; i++) {
            if (i == 7) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_room_accomodations, i, tbl_widths_room_accomodations[i]);
        }
        Dimension d = tbl_room_accomodations.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_room_accomodations.getTableHeader().
                setPreferredSize(d);
        tbl_room_accomodations.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_room_accomodations.setRowHeight(35);
        tbl_room_accomodations.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_room_accomodations(List<to_room_accomodations> acc) {
        tbl_room_accomodations_ALM.clear();
        tbl_room_accomodations_ALM.addAll(acc);
    }

    public static class Tblroom_accomodationsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "table_id", "STATUS", "CHECK IN", "check out", "status", "product_num", "DESCRIPTION", "qty", "RATE"
        };

        public Tblroom_accomodationsModel(ListModel listmodel) {
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
            to_room_accomodations tt = (to_room_accomodations) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.table_id;
                case 2:
                    return tt.table_names;
                case 3:

                    return tt.check_in;
                case 4:

                    return tt.check_out;
                case 5:
                    return tt.status;
                case 6:
                    return tt.product_num;
                case 7:
                    return tt.description;
                case 8:
                    return tt.qty;
                default:
                    return FitIn.fmt_wc_0(tt.price);
            }
        }
    }
    String table_id = "10";

    private void data_cols() {
        String table_ids = table_id;
        loadData_room_accomodations(S1_room_accomodation.ret_data(table_ids));
    }

    private void add() {
        int idx = tbl_items.getSelectedRow();
        if (idx < 0) {
            return;
        }
        List<S2_search.to_items> results = new ArrayList();

        final S2_search.to_items to = (S2_search.to_items) tbl_customer_tables_details_ALM.
                get(tbl_items.convertRowIndexToModel(idx));
        results.add(to);

        S1_room_accomodation.edit_data(table_id, results, guest_size);
        data_cols();
        ok1();
        Prompt.call("Successfully Added");

    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void cancel_accom() {
        int idx = tbl_room_accomodations.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_room_accomodations to = (to_room_accomodations) tbl_room_accomodations_ALM.
                get(tbl_room_accomodations.convertRowIndexToModel(idx));


//        JOptionPane.showMessageDialog(null, "adadad");
        String table_ids = table_id;
        String del_product_num = to.product_num;
        String update_product_num = "";
        double amount = 0;
        if (tbl_room_accomodations_ALM.size() > 1) {
            final to_room_accomodations to1 = (to_room_accomodations) tbl_room_accomodations_ALM.
                    get(tbl_room_accomodations.convertRowIndexToModel(idx - 1));
            amount = to1.price / guest_size;
        }


        S1_room_accomodation.delete_data(table_ids, del_product_num, update_product_num, amount,tbl_room_accomodations_ALM.size());

//        data_cols();
        ok1();
        Prompt.call("ACCOMODATION CANCELLED");

    }
}
