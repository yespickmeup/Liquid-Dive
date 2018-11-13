/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.category_discounts.Dlg_category_discount;
import POS.category_discounts.S1_category_discounts;
import POS.category_discounts.S1_category_discounts.to_category_discounts;
import POS.category_types.S1_categories;
import POS.dlg3.Dlg_add_discount;
import POS.to.to_users;
import POS.utl.Alert;
import POS.utl.DateType;
import POS_svc3.S2_get_discounts;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import test.Dlg_check_liquid;

/**
 *
 * @author i1
 */
public class Dlg_billing_report extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_billing_report
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

        public final String discount;
        public final double rate;
        public final String guest_id;
        public final String guest_name;

        public OutputData(String discount, double rate, String guest_id, String guest_name) {
            this.discount = discount;
            this.rate = rate;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_billing_report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_billing_report(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_billing_report() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_billing_report myRef;

    private void setThisRef(Dlg_billing_report myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_billing_report> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_billing_report create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_billing_report create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_billing_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_report((java.awt.Frame) parent, false);
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
            Dlg_billing_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_report((java.awt.Dialog) parent, false);
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

        Dlg_billing_report dialog = Dlg_billing_report.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

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

        jPanel3 = new javax.swing.JPanel();
        pnl_rpt = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_category_discounts = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lbl_sub_total = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        cb_orders = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_advance_payment = new javax.swing.JLabel();
        lbl_advance_payment_bank = new javax.swing.JLabel();
        lbl_adv_credit_card = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_advance_payment_usd = new javax.swing.JLabel();
        lbl_advance_payment_usd_bank = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_total1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_discount = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lb_rate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pnl_rpt.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_rptLayout = new javax.swing.GroupLayout(pnl_rpt);
        pnl_rpt.setLayout(pnl_rptLayout);
        pnl_rptLayout.setHorizontalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_rptLayout.setVerticalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_category_discounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_category_discounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_category_discountsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_category_discounts);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("SUB TOTAL:");

        lbl_sub_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_sub_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sub_total.setText("0.00");
        lbl_sub_total.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Net Due:");

        lbl_total.setBackground(new java.awt.Color(51, 153, 255));
        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setOpaque(true);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cb_orders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_orders.setText("ORDERS");
        cb_orders.setFocusable(false);
        cb_orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ordersActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Discount:");

        lbl_discount.setBackground(new java.awt.Color(255, 255, 255));
        lbl_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_discount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_discount.setText("0.00");
        lbl_discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_discount.setOpaque(true);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("ADVANCE PAYMENT:");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("PESO");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CREDIT CARD");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("BANK");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("CASH");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_advance_payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_advance_payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment.setText("0.00");
        lbl_advance_payment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_advance_payment_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_advance_payment_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment_bank.setText("0.00");
        lbl_advance_payment_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_adv_credit_card.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_adv_credit_card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adv_credit_card.setText("0.00");
        lbl_adv_credit_card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("USD");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("CASH");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("BANK");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_advance_payment_usd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_advance_payment_usd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment_usd.setText("0.00");
        lbl_advance_payment_usd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbl_advance_payment_usd_bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_advance_payment_usd_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment_usd_bank.setText("0.00");
        lbl_advance_payment_usd_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Amount Due:");

        lbl_total1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_total1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_total1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total1.setText("0.00");
        lbl_total1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lbl_total1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cb_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_advance_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_advance_payment_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addComponent(lbl_advance_payment_usd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(lbl_advance_payment_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_adv_credit_card, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbl_discount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_advance_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_advance_payment_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbl_advance_payment_usd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_advance_payment_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel17))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_adv_credit_card, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(cb_orders))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_sub_total, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TYPE:");

        cb_discount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_discount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_discountActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RATE:");

        lb_rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rate.setText("12");
        lb_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_rate.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("%");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cb_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_discountActionPerformed
        // TODO add your handling code here:
//        get_rate();
    }//GEN-LAST:event_cb_discountActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        discount();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ordersActionPerformed
        get_rate();
    }//GEN-LAST:event_cb_ordersActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_category_discountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_category_discountsMouseClicked
        set_discount();
    }//GEN-LAST:event_tbl_category_discountsMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_discount;
    private javax.swing.JCheckBox cb_orders;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb_rate;
    private javax.swing.JLabel lbl_adv_credit_card;
    private javax.swing.JLabel lbl_advance_payment;
    private javax.swing.JLabel lbl_advance_payment_bank;
    private javax.swing.JLabel lbl_advance_payment_usd;
    private javax.swing.JLabel lbl_advance_payment_usd_bank;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_sub_total;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_total1;
    private javax.swing.JPanel pnl_rpt;
    private javax.swing.JTable tbl_category_discounts;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        init_cb();
        init_tbl_category_discounts();
        jPanel1.setVisible(false);
    }

    private void init_cb() {

        cb_discount.setModel(new ListComboBoxModel(S2_get_discounts.
                get_discounts_for_cb()));

//        get_rate();
    }

    private void get_rate() {
        int row = cb_discount.getItemCount();
        if (row <= 0) {
            return;
        }

        String rate = S2_get_discounts.get_discounts_rate(cb_discount.
                getSelectedItem().
                toString());
        lb_rate.setText(rate);

        double discount = 0;
        List<S1_category_discounts.to_category_discounts> category_discounts = tbl_category_discounts_ALM;
        List<Srpt_category_discounts.field> cdd = new ArrayList();

        if (!category_discounts.isEmpty()) {
            for (S1_category_discounts.to_category_discounts cd : category_discounts) {
//                if (cd.discount_amount != 0) {
                double am = FitIn.toDouble(df.format(cd.due));
                String category = cd.category_name;
                double due = am;
                double disc_percent = cd.discount_percent;
                double disc_amount = cd.discount_amount;
                double sub_total = am - cd.discount_amount;
                if (disc_amount != 0) {
                    Srpt_category_discounts.field tbar = new Srpt_category_discounts.field(category, due, disc_percent, disc_amount, sub_total);
                    cdd.add(tbar);
                }

//                }
            }
        }
        if (j == 1) {
            String img_path = System.getProperty("img_path", "C:\\Users\\i1\\");
            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
            discount = FitIn.toDouble(lbl_discount.getText());
//            double to_pay = to2.to_pay - discount;
            double to_pay = FitIn.toDouble(FitIn.fmt_woc(lbl_total.getText()));
            double dollar = to_pay / to2.dollar_rate;
            String l = "";
            double dollar_to_pay = to_pay / to2.dollar_rate;
            String s = df.format(dollar_to_pay);
            dollar_to_pay = FitIn.toDouble(s);
            double total_charges = 0;
            List<to_category_discounts> datas = tbl_category_discounts_ALM;
            for (to_category_discounts ch : datas) {

                if (!ch.category_id.equals("11")) {

                    total_charges += ch.due;
                }

            }

            Srpt_liquid_billing to3 = new Srpt_liquid_billing("", 0, "", "", new ArrayList(), new ArrayList(),
                    new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), "", "", "", "", "", "", 0, "",
                    0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList(),"");
            if (cb_orders.isSelected()) {
                Srpt_liquid_billing to1 = new Srpt_liquid_billing(to2.busi_name, to2.room_rate,
                        to2.accomodation, SUBREPORT_DIR, resto_items, bar_items, to2.rpt_others,
                        to2.rpt_accomodation, advances, cdd, to2.my_date, to2.guest_id, to2.table_no,
                        to2.check_in, to2.transfers, to2.accomodation_1, to2.accom_total, img_path, to_pay,
                        to2.guest_name, dollar, total_charges, discount, to2.dollar_rate,
                        to2.advance_payment, to2.advance_payment_usd, 0, 0, 0, to2.bank_php,
                        to2.bank_usd, to2.credit_card, dollar_to_pay, new ArrayList(),to2.room_no);
//              
                to3 = to1;
                report_get_viewer_session(to1, "rpt_billing_liquid_items.jrxml");
                l = "rpt_billing_liquid_items.jrxml";
            } else {

                Srpt_liquid_billing to1 = new Srpt_liquid_billing(to2.busi_name, to2.room_rate,
                        to2.accomodation, SUBREPORT_DIR, to2.rpt_bar_and_resto, to2.rpt_bar,
                        to2.rpt_others, to2.rpt_accomodation, advances, cdd, to2.my_date, to2.guest_id, to2.table_no, to2.check_in, to2.transfers, to2.accomodation_1,
                        to2.accom_total, img_path, to_pay, to2.guest_name,
                        dollar, total_charges, discount, to2.dollar_rate,
                        to2.advance_payment, to2.advance_payment_usd, 0, 0, 0,
                        to2.bank_php, to2.bank_usd, to2.credit_card, dollar_to_pay, new ArrayList(),to2.room_no);
//              
                to3 = to1;
                report_get_viewer_session(to1, "rpt_billing_liquid.jrxml");
                l = "rpt_billing_liquid.jrxml";
            }

            JasperReport jasperReport = null;
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(l);
            try {
                jasperReport = JasperCompileManager.compileReport(is);
                jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.
                        setParameter(to3), JasperUtil.emptyDatasource());
            } catch (JRException ex) {
                Logger.getLogger(Dlg_billing_report.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        }
    }
    int j = 0;
    Srpt_liquid_billing to2 = new Srpt_liquid_billing("", 0, "", "", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(),
            new ArrayList(), new ArrayList(), "", "", "", "", "", "", 0, "", 0, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList(),"");
    List<Srpt_bar_and_resto.field> bar_items = new ArrayList();
    List<Srpt_bar_and_resto.field> resto_items = new ArrayList();
    List<Srpt_history_advance_payments.field> advances = new ArrayList();
    List<Dlg_check_liquid.to_guests> my_guest = new ArrayList();
    String guest_ids = "";
    String guest_names = "";
    DecimalFormat df = new DecimalFormat("#,###");

    public void do_pass(Srpt_liquid_billing to, String jrxml_name,
            String table_id,
            List<Srpt_bar_and_resto.field> resto_items1,
            List<Srpt_bar_and_resto.field> bar_items1,
            String guest_name, String guest_id,
            List<Srpt_history_advance_payments.field> advances1,
            List<Srpt_accomodation.field> accom,
            List<Srpt_others.field> rpt_others, List<S1_categories.to_name_cat> categories, List<Dlg_check_liquid.to_guests> guest) {
        j = 1;
        resto_items = resto_items1;
        bar_items = bar_items1;
        my_guest = guest;
        advances = advances1;
        guest_ids = guest_id;
        guest_names = guest_name;
        S1_bill_discounts.to_bill_discounts disc = S1_bill_discounts.ret_data(table_id, guest_ids);
        cb_discount.setSelectedItem(disc.discount);
        lb_rate.setText(FitIn.fmt_wc_0(disc.rate));
        to2 = to;

        List<to_category_discounts> datas = new ArrayList();

        int id = -1;
        String guest_ids1 = to.guest_id;
        String guest_names1 = to.guest_name;
        String room_guest_ids = to.guest_id;
        String table_id1 = to.table_no;
        String date_added = DateType.datetime.format(new Date());
        String user_name = to_users.username1;
        int status = 0;
        double due_resto = 0;
        double discount_percent_resto = 0;
        double discount_amount_resto = 0;
        String category_name_resto = "RESTAURANT";
        String category_id_resto = "10";
        int item_count_resto = 0;
        String discount_resto = "";

        for (Srpt_bar_and_resto.field resto : resto_items) {
            item_count_resto += resto.qty;
            due_resto += resto.total;
//            System.out.println("Due Resto: "+resto.total+ " Date: "+resto.date_added);
        }

        double due_accom = 0;
        double discount_percent_accom = 0;
        double discount_amount_accom = 0;
        String category_name_accom = "ACCOMMODATION";
        String category_id_accom = "11";
        int item_count_accom = 0;
        String discount_accom = "";
        for (Srpt_accomodation.field accomo : accom) {
            item_count_accom += accomo.qty;
            due_accom += accomo.amount;
        }
        to_category_discounts cd_accom = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due_accom, discount_percent_accom, discount_amount_accom, category_name_accom, category_id_accom, item_count_accom, discount_accom);
        if (item_count_accom != 0) {
            datas.add(cd_accom);
        }

        to_category_discounts cd_resto = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name,
                status, due_resto, discount_percent_resto, discount_amount_resto, category_name_resto, category_id_resto, item_count_resto, discount_resto);
        datas.add(cd_resto);

        double due_bar = 0;
        double discount_percent_bar = 0;
        double discount_amount_bar = 0;
        String category_name_bar = "BAR";
        String category_id_bar = "12";
        int item_count_bar = 0;
        String discount_bar = "";
        for (Srpt_bar_and_resto.field bar : bar_items) {
            item_count_bar += bar.qty;
            due_bar += bar.total;
//            System.out.println("Due bar: "+bar.total+ " Date: "+bar.date_added);
        }
        to_category_discounts cd_bar = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due_bar, discount_percent_bar, discount_amount_bar, category_name_bar, category_id_bar, item_count_bar, discount_bar);
        datas.add(cd_bar);
        for (S1_categories.to_name_cat c : categories) {
            if (c.name.equalsIgnoreCase("BAR") || c.name.equalsIgnoreCase("ACCOMODATION") || c.name.
                    equalsIgnoreCase("RESTAURANT")) {
            } else {
                double due_others = 0;
                double discount_percent_others = 0;
                double discount_amount_others = 0;
                String category_name_others = c.name.toUpperCase();
                String category_id_others = c.num;
                int item_count_others = 0;
                String discount_others = "";
                for (Srpt_others.field oth : rpt_others) {
                    if (oth.category.equalsIgnoreCase(c.name)) {
                        item_count_others += oth.qty;
                        due_others += oth.price;
                    }
                }
                to_category_discounts cd_others = new to_category_discounts(id, guest_ids1,
                        guest_names, room_guest_ids, table_id, date_added, user_name, status, due_others, discount_percent_others, discount_amount_others, category_name_others, category_id_others, item_count_others, discount_others);
                if (item_count_others != 0) {
                    datas.add(cd_others);
                }
            }
        }
        int i = 0;
        my_guest_room_ids = "";
        my_guest_ids = "";
        my_guest_names = "";
        for (Dlg_check_liquid.to_guests g : my_guest) {
            if (i == 0) {
                my_guest_room_ids = my_guest_room_ids + g.room_guest_ids;
                my_guest_ids = my_guest_ids + g.id;
                my_guest_names = my_guest_names + g.name;
            } else {
                my_guest_room_ids = my_guest_room_ids + "," + g.room_guest_ids;
                my_guest_ids = my_guest_ids + "," + g.id;
                my_guest_names = my_guest_names + "," + g.name;
            }
            i++;
        }

        loadData_category_discounts(datas);
        reload_discounts();
        get_rate();
    }
    String my_guest_room_ids = "";
    String my_guest_ids = "";
    String my_guest_names = "";

    private void discount() {
        Window p = (Window) this;
        Dlg_add_discount nd = Dlg_add_discount.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_add_discount.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_discount.OutputData data) {
//                closeDialog.ok();
                init_cb();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
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

    public static JasperReport compileJasper(String jrxml_name) {
        try {
            String jrxml = jrxml_name;
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_conn(Srpt_liquid_billing to, String rpt_name) {
//        Connection con11 = null;
        try {
//            con11 = MyConnection1.connect();

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

    private void ok1() {
        String discount = cb_discount.getSelectedItem().
                toString();
        double rate = FitIn.toDouble(lb_rate.getText());
        if (rate != 0) {
            if (callback != null) {
                callback.ok(new CloseDialog(this), new OutputData(discount, rate, guest_ids, guest_names));
            }
        }
    }
    JasperPrint jasperPrint = null;

    private void print() {
        try {
            JasperPrintManager.printReport(jasperPrint, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }
    private ArrayListModel tbl_category_discounts_ALM;
    private Tblcategory_discountsModel tbl_category_discounts_M;

    private void init_tbl_category_discounts() {
        tbl_category_discounts_ALM = new ArrayListModel();
        tbl_category_discounts_M = new Tblcategory_discountsModel(tbl_category_discounts_ALM);
        tbl_category_discounts.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_category_discounts.setModel(tbl_category_discounts_M);
        tbl_category_discounts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_category_discounts.setRowHeight(25);
        int[] tbl_widths_category_discounts = {30, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_category_discounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_category_discounts, i, tbl_widths_category_discounts[i]);
        }
        Dimension d = tbl_category_discounts.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_category_discounts.getTableHeader().
                setPreferredSize(d);
        tbl_category_discounts.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 11));
        tbl_category_discounts.setRowHeight(35);
        tbl_category_discounts.setFont(new java.awt.Font("Arial", 0, 11));
        TableWidthUtilities.setColumnRightRenderer(tbl_category_discounts, 2);
        TableWidthUtilities.setColumnRightRenderer(tbl_category_discounts, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_category_discounts, 4);
    }

    private void loadData_category_discounts(List<to_category_discounts> acc) {
        tbl_category_discounts_ALM.clear();
        tbl_category_discounts_ALM.addAll(acc);
    }

    public static class Tblcategory_discountsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "#", "CATEGORY", "               DUE", "         DISC", "            TOTAL", "date_added", "user_name", "status", "due", "discount_percent", "discount_amount", "category_name", "category_id", "item count"
        };

        public Tblcategory_discountsModel(ListModel listmodel) {
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
            to_category_discounts tt = (to_category_discounts) getRow(row);
            DecimalFormat df = new DecimalFormat("#,###");
            switch (col) {
                case 0:
                    return " " + FitIn.fmt_woc(tt.item_count);
                case 1:
                    return " " + tt.category_name;
                case 2:
                    return df.format(tt.due) + ".00 ";
                case 3:
                    return FitIn.fmt_wc_0(tt.discount_amount) + " ";
                case 4:
                    return tt.table_id;
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.user_name;
                case 7:
                    return tt.status;
                case 8:
                    return tt.due;
                case 9:
                    return tt.discount_percent;
                case 10:
                    return tt.discount_amount;
                case 11:
                    return tt.category_name;
                case 12:
                    return tt.category_id;
                default:
                    return tt.item_count;
            }
        }
    }

    private void data_cols() {
//        String search = tf_search.getText();
//        loadData_category_discounts(S1_category_discounts.ret_data(search));
    }

    private void set_discount() {
        int row = tbl_category_discounts.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_category_discounts to = (to_category_discounts) tbl_category_discounts_ALM.
                get(tbl_category_discounts.convertRowIndexToModel(row));
//        JOptionPane.showMessageDialog(null, to.id);
        final Window p = (Window) this;
        final JComponent comp = this.getSurface();
        Dlg_category_discount nd = Dlg_category_discount.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.category_name, to.due, to.discount, to.discount_percent, to.discount_amount, to.due - to.discount_amount);
        nd.setCallback(new Dlg_category_discount.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_category_discount.OutputData data) {
                closeDialog.ok();
                int id = to.id;
                String guest_ids = my_guest_ids;
                String guest_names = my_guest_names;
                String room_guest_ids = my_guest_room_ids;
                String table_id = to2.table_no;
                String date_added = DateType.datetime.format(new Date());
                String user_name = to_users.username1;
                int status = 0;
                double due = data.due;
                double discount_percent = data.discount_rate;
                double discount_amount = data.discount_amount;
                String category_name = to.category_name;
                String category_id = to.category_id;
                int item_count = to.item_count;
                String discount = data.discount;
                to_category_discounts to = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due, discount_percent, discount_amount, category_name, category_id, item_count, discount);
                if (to.id == -1) {
                    S1_category_discounts.add_category_discounts(to);
                    Alert.set(1, "");
                } else {
                    S1_category_discounts.edit_category_discounts(to);
                    Alert.set(2, "");
                }
                reload_discounts();
                get_rate();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void reload_discounts() {
        List<to_category_discounts> datas = tbl_category_discounts_ALM;
        List<to_category_discounts> new_data = new ArrayList();
        for (to_category_discounts to : datas) {
            to_category_discounts get = S1_category_discounts.ret_data(my_guest_room_ids, to.category_name);
            if (get != null) {
                to_category_discounts to_new = new to_category_discounts(get.id, get.guest_ids, get.guest_names, get.room_guest_ids, get.table_id,
                        get.date_added, get.user_name, get.status, to.due, get.discount_percent, get.discount_amount, get.category_name,
                        get.category_id, get.item_count, get.discount);
                new_data.add(to_new);
            } else {
                new_data.add(to);
            }
        }
        double due = 0;
        double discount = 0;
        double total = 0;
        for (to_category_discounts to : new_data) {
            due += to.due;
            discount += to.discount_amount;
            total += to.due - to.discount_amount;
        }

        List<Srpt_history_advance_payments.field> advances = to2.rpt_advance_payments;
        double peso1 = 0;
        double dollar1 = 0;
        double peso_bank1 = 0;
        double usd_bank = 0;
        double credit1 = 0;
        for (Srpt_history_advance_payments.field ad : advances) {
            peso1 += ad.getPhp_cash();
            dollar1 += ad.getUsd_cash();
            peso_bank1 += ad.getPhp_bank();
            usd_bank += ad.getUsd_bank();

            double credit_rate = ad.getCredit_card_rate();
            credit_rate = (credit_rate / 100) * ad.getCredit_card();
            double credit_total = ad.getCredit_card();//+ credit_rate;
            credit1 += credit_total;
        }

        double prepaid_peso = peso1 + peso_bank1;
        double prepaid_dollar = dollar1 + usd_bank;
        double prepaid_dollar_to_peso = prepaid_dollar * to2.dollar_rate;

        double prepaid_total = prepaid_peso + prepaid_dollar_to_peso;
        double prepaid_credit_card = credit1;

       
        total = total - (prepaid_total + prepaid_credit_card);
      
        lbl_advance_payment.setText(FitIn.fmt_wc_0(peso1));
        lbl_advance_payment_bank.setText(FitIn.fmt_wc_0(peso_bank1));
        lbl_advance_payment_usd.setText(FitIn.fmt_wc_0(dollar1));
        lbl_advance_payment_usd_bank.setText(FitIn.fmt_wc_0(usd_bank));
        lbl_adv_credit_card.setText(FitIn.fmt_wc_0(credit1));

        lbl_total1.setText(df.format(due) + ".00");
        lbl_total.setText(FitIn.fmt_wc_0(total));
        lbl_discount.setText(FitIn.fmt_wc_0(discount));
        loadData_category_discounts(new_data);
        tbl_category_discounts_M.fireTableDataChanged();
    }
}
