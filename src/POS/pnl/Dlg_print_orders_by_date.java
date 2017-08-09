/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.pnl;

import POS.printing2.Dlg_print_orders;
import POS.printing2.Srpt_billing_statement;
import POS.utl.DateType;
import POS_svc4.S2_search;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_print_orders_by_date extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_print_orders
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
    private Dlg_print_orders_by_date(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_print_orders_by_date(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_print_orders_by_date() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_print_orders_by_date myRef;

    private void setThisRef(Dlg_print_orders_by_date myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_print_orders_by_date> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_print_orders_by_date create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_print_orders_by_date create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_print_orders_by_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_print_orders_by_date((java.awt.Frame) parent, false);
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
            Dlg_print_orders_by_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_print_orders_by_date((java.awt.Dialog) parent, false);
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

        Dlg_print_orders_by_date dialog = Dlg_print_orders_by_date.create(new javax.swing.JFrame(), true);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bank = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new Button.Success();
        pnl_report = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new Button.Success();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new Button.Success();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Date from:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date to:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_bank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_bank);

        jLabel3.setText("Total no. of rows:");

        jLabel4.setText("0");

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel5);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Print Order/s");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_reportLayout = new javax.swing.GroupLayout(pnl_report);
        pnl_report.setLayout(pnl_reportLayout);
        pnl_reportLayout.setHorizontalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_reportLayout.setVerticalGroup(
            pnl_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_report, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        jButton2.setText("Print Bar and Resto Order/s");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Print Kitchen Order/s");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Preview", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        print();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        print2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        print3();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        set_order();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JTable tbl_bank;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_bank(tbl_bank);
    }
    List<S2_search.to_items> my_orders = new ArrayList();

    private void set_order() {
        String types_no_wo_qty = System.getProperty("catid_orders_wo_qty", "");
        String[] l_types_no_wo_qty = types_no_wo_qty.split(",");
        String min1 = DateType.sf.format(jDateChooser1.getDate()) + " 00:00:00";
        String max1 = DateType.sf.format(jDateChooser2.getDate()) + " 00:00:00";
        Date min = new Date();
        Date max = new Date();
        try {
            min = DateType.datetime.parse(min1);
            max = DateType.datetime.parse(max1);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_print_orders_by_date.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.println("min: " + min);
//        System.out.println("max: " + max);
        List<Srpt_billing_statement.field> datas = new ArrayList();
        List<Srpt_billing_statement.field> datas_bar = new ArrayList();
        List<Srpt_billing_statement.field> datas_kitchen = new ArrayList();
        for (S2_search.to_items order : my_orders) {
            if (order.cat_id.equals("10") || order.cat_id.equals("12")) {
                Date d = new Date();
                Date d2 = new Date();
                try {
                    d = DateType.datetime.parse(order.date_added);
                    String sf = DateType.sf.format(d) + " 00:00:00";
                    d2 = DateType.datetime.parse(sf);
                } catch (ParseException ex) {
                    Logger.getLogger(Dlg_print_orders_by_date.class.getName()).log(Level.SEVERE, null, ex);
                }
//                System.out.println("date: " + d2 + " | " + (min.getTime() <= d2.getTime() && d2.getTime() <= max.getTime())   );

                boolean m1 = d.compareTo(min) >= 0;
                boolean m2 = d.compareTo(max) <= 0;

                String item_code = order.name;
                String description = order.desc;
                String assembly = "" + order.printing_assembly;
                double qty = order.qty;
                double selling_price = order.price;
                double discount = order.discount;
                double amount = (qty * selling_price) - discount;
                boolean status = (min.getTime() >= d.getTime() && d.getTime() <= max.getTime());
//                System.out.println("item_code: " + item_code);
                if (!jCheckBox1.isSelected()) {
                    if ((min.getTime() <= d2.getTime() && d2.getTime() <= max.getTime())) {

                        String qty1 = "" + qty;

                        String cat_id = order.cat_id;
                        String sub_cat_id = Srpt_billing_statement.ret_types_num(item_code);
                        for (String s : l_types_no_wo_qty) {
                            if (sub_cat_id.equalsIgnoreCase(s)) {
                                qty1 = "";
                            }
                        }
//                    System.out.println("sub_cat_id: "+sub_cat_id);
                        Srpt_billing_statement.field field = new Srpt_billing_statement.field(item_code, description, assembly, qty1, selling_price, discount, amount, order.date_added, cat_id, sub_cat_id);
                        datas.add(field);

                        if (order.cat_id.equals("12")) {
                            datas_bar.add(field);
                        }
                        if (order.cat_id.equals("10")) {
                            datas_kitchen.add(field);
                        }
                    }
                } else {
                    String qty1 = "" + qty;

                    String cat_id = order.cat_id;
                    String sub_cat_id = Srpt_billing_statement.ret_types_num(item_code);
                    for (String s : l_types_no_wo_qty) {
                        if (sub_cat_id.equalsIgnoreCase(s)) {
                            qty1 = "";
                        }
                    }
//                    System.out.println("sub_cat_id: "+sub_cat_id);
                    Srpt_billing_statement.field field = new Srpt_billing_statement.field(item_code, description, assembly, qty1, selling_price, discount, amount, order.date_added, cat_id, sub_cat_id);
                    datas.add(field);

                    if (order.cat_id.equals("12")) {
                        datas_bar.add(field);
                    }
                    if (order.cat_id.equals("10")) {
                        datas_kitchen.add(field);
                    }
                }

            }
        }

        loadData_bank(datas);

        String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        String address = System.getProperty("address", "Dauin, Negros Oriental");
        String contact_no = System.getProperty("contact_no", "1235566");
        String date = DateType.datetime2.format(new Date());
        String room_no = table_names;
        String print_to = "";
        String receipt_footer = System.getProperty("receipt_footer", "This is not an Official BIR Receipt");
        Srpt_billing_statement rpt_billing_statement = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer);
        rpt_billing_statement.fields.addAll(datas);
        Srpt_billing_statement rpt_billing_statement_bar = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer);
        rpt_billing_statement_bar.fields.addAll(datas_bar);
        Srpt_billing_statement rpt_billing_statement_kitchen = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer);
        rpt_billing_statement_kitchen.fields.addAll(datas_kitchen);

        jLabel4.setText("" + datas.size());

        init_report_billing_statement(rpt_billing_statement);
        init_report_billing_stab_bar_and_resto(rpt_billing_statement_bar);
        init_report_billing_stab_kitchen(rpt_billing_statement_kitchen);
    }
    String guess_names = "";
    String table_names = "";

    public void do_pass(List<S2_search.to_items> orders, String table_name, String guess_name) {
        my_orders = orders;
        guess_names = guess_name;
        table_names = table_name;
        set_order();
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

    //<editor-fold defaultstate="collapsed" desc=" bank "> 
    public static ArrayListModel tbl_bank_ALM;
    public static TblbankModel tbl_bank_M;

    public static void init_tbl_bank(JTable tbl_bank) {
        tbl_bank_ALM = new ArrayListModel();
        tbl_bank_M = new TblbankModel(tbl_bank_ALM);
        tbl_bank.setModel(tbl_bank_M);
        tbl_bank.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_bank.setRowHeight(25);
        int[] tbl_widths_bank = {60, 80, 100, 80, 80, 100, 80};
        for (int i = 0, n = tbl_widths_bank.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_bank, i, tbl_widths_bank[i]);
        }
        Dimension d = tbl_bank.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_bank.getTableHeader().setPreferredSize(d);
        tbl_bank.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_bank.setRowHeight(25);
        tbl_bank.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_bank, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_bank, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_bank, 3);
    }

    public static void loadData_bank(List<Srpt_billing_statement.field> acc) {
        tbl_bank_ALM.clear();
        tbl_bank_ALM.addAll(acc);
    }

    public static class TblbankModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Code", "Description", "Price", "Discount", "Amount", "Date"
        };

        public TblbankModel(ListModel listmodel) {
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
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Srpt_billing_statement.field tt = (Srpt_billing_statement.field) getRow(row);
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.getQty());
                case 1:
                    return " " + tt.getItem_code();
                case 2:
                    return " " + tt.getDescription();
                case 3:
                    return FitIn.fmt_wc_0(tt.getSelling_price()) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.getDiscount()) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.getAmount()) + " ";
                default:
                    return " " + DateType.convert_slash(tt.getDatetime());
            }
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" billing statement ">
    private void init_report_billing_statement(final Srpt_billing_statement rpt) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String jrxml = "rpt_billing_statement.jrxml";
                String print_billing_statement_size = System.getProperty("print_billing_statement_size", "default");
                if (print_billing_statement_size.equalsIgnoreCase("58mm")) {
                    jrxml = "rpt_billing_statement_58mm.jrxml";
                }
                report_billing_statement(rpt, jrxml);
                InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    String auto_print_billing_statement = System.getProperty("auto_print_billing_statement", "false");
                    if (auto_print_billing_statement.equalsIgnoreCase("true")) {
                        print();
                    }
                } catch (JRException ex) {
                    Logger.getLogger(Dlg_print_orders.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();

    }

    private void report_billing_statement(final Srpt_billing_statement to, String jrxml_name) {
        pnl_report.removeAll();
        pnl_report.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_billing_statement(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_report.add(viewer);
            pnl_report.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_billing_statement(Srpt_billing_statement to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            if (jasperPrint != null) {
                JasperPrintManager.printReport(jasperPrint, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Bar and Resto ">

    private void init_report_billing_stab_bar_and_resto(final Srpt_billing_statement rpt) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String jrxml = "rpt_billing_stab.jrxml";
                report_billing_stab_bar_and_resto(rpt, jrxml);
                InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint2 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
                    String auto_print_stab_bar_and_resto = System.getProperty("auto_print_stab_bar_and_resto", "false");
                    if (auto_print_stab_bar_and_resto.equalsIgnoreCase("true")) {
                        print2();
                    }
                } catch (JRException ex) {
                    Logger.getLogger(Dlg_print_orders.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();

    }

    private void report_billing_stab_bar_and_resto(final Srpt_billing_statement to, String jrxml_name) {
        jPanel6.removeAll();
        jPanel6.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_billing_stab_bar_and_resto(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel6.add(viewer);
            jPanel6.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_billing_stab_bar_and_resto(Srpt_billing_statement to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_bar_and_resto(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_bar_and_resto(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint2 = null;

    private void print2() {
        try {
            if (jasperPrint2 != null) {
                JasperPrintManager.printReport(jasperPrint2, false);
            }

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" kitchen ">

    private void init_report_billing_stab_kitchen(final Srpt_billing_statement rpt) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                String jrxml = "rpt_billing_stab.jrxml";
                report_billing_stab_kitchen(rpt, jrxml);
                InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
                try {
                    JasperReport jasperReport = JasperCompileManager.compileReport(is);
                    jasperPrint3 = JasperFillManager.fillReport(jasperReport, JasperUtil.
                            setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));

                    String auto_print_stab_kitchen = System.getProperty("auto_print_stab_kitchen", "false");
                    if (auto_print_stab_kitchen.equalsIgnoreCase("true")) {

                        print3();
                    }
                } catch (JRException ex) {
                    Logger.getLogger(Dlg_print_orders.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        t.start();

    }

    private void report_billing_stab_kitchen(final Srpt_billing_statement to, String jrxml_name) {
        jPanel7.removeAll();
        jPanel7.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_billing_stab_kitchen(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel7.add(viewer);
            jPanel7.updateUI();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_billing_stab_kitchen(Srpt_billing_statement to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_kitchen(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_kitchen(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    JasperPrint jasperPrint3 = null;

    private void print3() {
        try {
            if (jasperPrint3 != null) {
                JasperPrintManager.printReport(jasperPrint3, true);
            }
        } catch (JRException e) {
            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
//            throw new RuntimeException(e);
        }
    }
//</editor-fold>

}
