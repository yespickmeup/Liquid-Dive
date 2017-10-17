/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.expenses.S1_expenses_categories;
import POS.rpt2.rpt_report;
import POS.rpt2.to_date_to;
import POS.sales.S1_edit_sales.to_edit_sales;
import POS.sales.S1_my_sales.to_details;
import POS.sales.S1_my_sales.to_receipts;
import POS.send_mail.Email;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.DateUtils;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import rpt_liquid.*;

/**
 *
 * @author i1
 */
public class Dlg_cashier_sales_all extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_my_sales
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
    private Dlg_cashier_sales_all(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_cashier_sales_all(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_cashier_sales_all() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_cashier_sales_all myRef;

    private void setThisRef(Dlg_cashier_sales_all myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cashier_sales_all> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cashier_sales_all create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cashier_sales_all create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cashier_sales_all dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_sales_all((java.awt.Frame) parent, false);
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
            Dlg_cashier_sales_all dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashier_sales_all((java.awt.Dialog) parent, false);
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


        Dlg_cashier_sales_all dialog = Dlg_cashier_sales_all.create(new javax.swing.JFrame(), true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        EDIT = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_cash_in = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_cashout = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_peso = new javax.swing.JLabel();
        lbl_discounts = new javax.swing.JLabel();
        lbl_credit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_expenses = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cb_session = new javax.swing.JCheckBox();
        cb_cashier = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_addtl_cashins = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_dollar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_advance_payment = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_adv_usd = new javax.swing.JLabel();
        lbl_advance_payment_bank = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_adv_usd_bank = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_credit_card = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_receipt_items = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pnl_rpt = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnl_float = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnl_expenses = new javax.swing.JPanel();
        cb_category = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_vat = new javax.swing.JCheckBox();

        EDIT.setText("EDIT");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });
        jPopupMenu1.add(EDIT);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_cash_in.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cash_in.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cash_in.setText("0.00");
        lbl_cash_in.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_cash_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cash_inMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CASH IN");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_cashout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout.setText("0.00");
        lbl_cashout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ADDTL CASH");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CREDIT");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DOLLAR");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_peso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_peso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_peso.setText("0.00");
        lbl_peso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_discounts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_discounts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_discounts.setText("0.00");
        lbl_discounts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit.setText("0.00");
        lbl_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("DISCOUNTS");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("X");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("EXPENSES");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_expenses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_expenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_expenses.setText("0.00");
        lbl_expenses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CASHIER:");

        jLabel4.setText("DATE TO:");

        cb_session.setSelected(true);
        cb_session.setText("BY SESSION");
        cb_session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sessionActionPerformed(evt);
            }
        });

        cb_cashier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashierActionPerformed(evt);
            }
        });

        jLabel5.setText("DATE FROM:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CASHOUT");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_addtl_cashins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_addtl_cashins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_addtl_cashins.setText("0.00");
        lbl_addtl_cashins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PESO");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_dollar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_dollar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dollar.setText("0.00");
        lbl_dollar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADVANCE PAYMENT:");

        lbl_advance_payment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_advance_payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment.setText("0.00");
        lbl_advance_payment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_advance_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_advance_paymentMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("BANK");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_adv_usd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_adv_usd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adv_usd.setText("0.00");
        lbl_adv_usd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_adv_usd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_adv_usdMouseClicked(evt);
            }
        });

        lbl_advance_payment_bank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_advance_payment_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_advance_payment_bank.setText("0.00");
        lbl_advance_payment_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_advance_payment_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_advance_payment_bankMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PESO");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CASH");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("CASH");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("USD");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("BANK");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_adv_usd_bank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_adv_usd_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adv_usd_bank.setText("0.00");
        lbl_adv_usd_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_adv_usd_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_adv_usd_bankMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("CREDIT CARD:");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_credit_card.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_credit_card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit_card.setText("0.00");
        lbl_credit_card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_credit_card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_credit_cardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cb_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cb_session, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cash_in, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_cashout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_addtl_cashins, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_dollar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_discounts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_advance_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_advance_payment_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_adv_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_adv_usd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_card, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_cashier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_session)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel9))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_cash_in, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_cashout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_addtl_cashins, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_dollar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_discounts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_advance_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lbl_advance_payment_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_adv_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lbl_adv_usd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_credit_card, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ORDERS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_receipt_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl_receipt_items);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSACTIONS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_receipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_receipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_receiptsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_receipts);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("SALES DETAILS", jPanel4);

        pnl_rpt.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_rptLayout = new javax.swing.GroupLayout(pnl_rpt);
        pnl_rpt.setLayout(pnl_rptLayout);
        pnl_rptLayout.setHorizontalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1303, Short.MAX_VALUE)
        );
        pnl_rptLayout.setVerticalGroup(
            pnl_rptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SUMMARY", jPanel3);

        pnl_float.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_floatLayout = new javax.swing.GroupLayout(pnl_float);
        pnl_float.setLayout(pnl_floatLayout);
        pnl_floatLayout.setHorizontalGroup(
            pnl_floatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1303, Short.MAX_VALUE)
        );
        pnl_floatLayout.setVerticalGroup(
            pnl_floatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_float, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_float, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CASH FLOAT", jPanel5);

        pnl_expenses.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_expensesLayout = new javax.swing.GroupLayout(pnl_expenses);
        pnl_expenses.setLayout(pnl_expensesLayout);
        pnl_expensesLayout.setHorizontalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_expensesLayout.setVerticalGroup(
            pnl_expensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CATEGORY:");

        cb_vat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_vat.setText("VAT?");
        cb_vat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_vatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnl_expenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cb_vat)
                        .addGap(0, 817, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_vat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_expenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("EXPENSES", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        data_cols();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        data_cols_date();
        rep = 1;
        if (jTabbedPane1.getSelectedIndex() == 2) {
            set_cash_float();
        } else if (jTabbedPane1.getSelectedIndex() == 3) {
            set_expenses();
        } else {
            set_report();
        }
//           

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void cb_sessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sessionActionPerformed

        if (dp_from.isEnabled()) {

            dp_from.setEnabled(false);
            dp_to.setEnabled(false);
            dp_from.setDate(new Date());
            dp_to.setDate(new Date());
        } else {
            dp_from.setEnabled(true);
            dp_to.setEnabled(true);
        }

        set_sales();
        rep = 1;
        set_report();
    }//GEN-LAST:event_cb_sessionActionPerformed

    private void cb_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashierActionPerformed
        data_cols_date();
        set_sales();
        rep = 1;
        set_report();
    }//GEN-LAST:event_cb_cashierActionPerformed

    private void lbl_cash_inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cash_inMouseClicked
        set();
    }//GEN-LAST:event_lbl_cash_inMouseClicked

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void lbl_advance_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_advance_paymentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_advance_paymentMouseClicked

    private void lbl_adv_usdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_adv_usdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_adv_usdMouseClicked

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        set_expenses();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void cb_vatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_vatActionPerformed
        set_expenses();
    }//GEN-LAST:event_cb_vatActionPerformed

    private void lbl_advance_payment_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_advance_payment_bankMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_advance_payment_bankMouseClicked

    private void lbl_adv_usd_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_adv_usd_bankMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_adv_usd_bankMouseClicked

    private void tbl_receiptsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_receiptsMousePressed

    private void tbl_receiptsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_receiptsMouseReleased

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
        edit_receipt();
    }//GEN-LAST:event_EDITActionPerformed

    private void lbl_credit_cardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_credit_cardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_credit_cardMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EDIT;
    private javax.swing.JComboBox cb_cashier;
    private javax.swing.JComboBox cb_category;
    private javax.swing.JCheckBox cb_session;
    private javax.swing.JCheckBox cb_vat;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_addtl_cashins;
    private javax.swing.JLabel lbl_adv_usd;
    private javax.swing.JLabel lbl_adv_usd_bank;
    private javax.swing.JLabel lbl_advance_payment;
    private javax.swing.JLabel lbl_advance_payment_bank;
    private javax.swing.JLabel lbl_cash_in;
    private javax.swing.JLabel lbl_cashout;
    private javax.swing.JLabel lbl_credit;
    private javax.swing.JLabel lbl_credit_card;
    private javax.swing.JLabel lbl_discounts;
    private javax.swing.JLabel lbl_dollar;
    private javax.swing.JLabel lbl_expenses;
    private javax.swing.JLabel lbl_peso;
    private javax.swing.JPanel pnl_expenses;
    private javax.swing.JPanel pnl_float;
    private javax.swing.JPanel pnl_rpt;
    private javax.swing.JTable tbl_receipt_items;
    private javax.swing.JTable tbl_receipts;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        List<String> cashier = new ArrayList();
        set_category();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        cb_session.setVisible(false);
        init_tbl_receipts();

        compute();
        init_tbl_receipt_items();

        dp_from.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if (jTabbedPane1.getSelectedIndex() == 2) {
                    set_cash_float();
                } else if (jTabbedPane1.getSelectedIndex() == 3) {
                    set_expenses();
                } else {
                    data_cols_date();
                    set_sales();
                    set_report();
                }
            }
        });
        dp_to.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {

                if (jTabbedPane1.getSelectedIndex() == 2) {
                    set_cash_float();
                } else if (jTabbedPane1.getSelectedIndex() == 3) {
                    set_expenses();
                } else {
                    data_cols_date();
                    set_sales();

                    set_report();
                }


            }
        });

    }

    private void set_category() {
        cb_category.setModel(new ListComboBoxModel(S1_expenses_categories.
                ret_cb_data2()));
    }

    private void set_cashiers2() {
        cb_cashier.setModel(new ListComboBoxModel(S1_my_sales.ret_cb_data()));


    }
    String session = "1";

    private void set_sales() {

        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());

        double cash_in = 0;
        double expenses = 0;
        double cashout = 0;
        double addtl_cashins = 0;
        double dollar = 0;
        if (cb_session.isSelected()) {
            data_cols_date();

            compute();
        } else {
            cash_in = S1_my_sales.ret_cash_in_date(date_from, date_to);
            expenses = S1_my_sales.ret_expenses_date(date_from, date_to);
            cashout = S1_my_sales.ret_cashout_date(date_from, date_to);
            lbl_cash_in.setText(FitIn.fmt_wc_0(cash_in));
            lbl_expenses.setText(FitIn.fmt_wc_0(expenses));
            lbl_cashout.setText(FitIn.fmt_wc_0(cashout));
            data_cols_date();

            compute();
        }

    }

    public void do_pass(String cashier_session_id) {

        List<String> cashier = new ArrayList();
        if (to_users.user_level1.equals("1")) {
            set_cashiers2();

        } else {
            cashier.add((to_users.username1));
            cb_cashier.setModel(new ListComboBoxModel(cashier));
        }

        String user = to_users.ret_data(to_users.username1);
        cb_cashier.setSelectedItem(user);
        data_cols_date();
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
    private ArrayListModel tbl_receipts_ALM;
    private TblreceiptsModel tbl_receipts_M;

    private void init_tbl_receipts() {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
//        tbl_receipts.setAutoResizeMode(1);
        int[] tbl_widths_receipts = {0, 100, 0, 0, 0, 100, 100, 100, 0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipts.getTableHeader().
                setPreferredSize(d);
        tbl_receipts.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipts.setRowHeight(35);
        tbl_receipts.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipts(List<to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "TRANS #", "GUEST", "TIME", "or_number", "receipt_status", "TENDERED", "DISCOUNT", "CREDIT", "approval_code", "member_id", "is_payed", "DOLLAR", "PESO", "bank php", "bank usd", "guest_names usd", "room_guest_ids", "table_id", "table_name", "credit_card"
        };

        public TblreceiptsModel(ListModel listmodel) {
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
            to_receipts tt = (to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.guest_names;
                case 2:
                    return tt.receipt_date;
                case 3:
                    return tt.or_number;
                case 4:
                    return tt.receipt_status;
                case 5:
                    return FitIn.fmt_wc_0(tt.tendered);
                case 6:
                    return FitIn.fmt_wc_0(tt.discount);
                case 7:
                    return FitIn.fmt_wc_0(tt.credit);
                case 8:
                    return tt.approval_code;
                case 9:
                    return tt.member_id;
                case 10:
                    return tt.is_payed;
                case 11:
                    return FitIn.fmt_wc_0(tt.dollar);
                case 12:
                    return FitIn.fmt_wc_0(tt.peso);
                case 13:
                    return FitIn.fmt_wc_0(tt.bank_php);
                case 14:
                    return FitIn.fmt_wc_0(tt.bank_usd);
                case 15:
                    return (tt.guest_names);
                case 16:
                    return (tt.room_guest_ids);
                case 17:
                    return (tt.table_id);
                case 18:
                    return (tt.table_name);
                default:
                    return (tt.credit_card);
            }
        }
    }

    private void data_cols(String session_id) {

        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        loadData_receipts(S1_my_sales.ret_data(session_id, date_from, date_to, ""));
    }

    private void data_cols_date() {

        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String users = "";
        if (cb_cashier.getSelectedIndex() == -1) {
        } else {
            users = cb_cashier.getSelectedItem().
                    toString();
        }

        if (users.equals("ALL")) {
            users = "";
        } else {
            users = to_users.ret_user(users);
        }

        if (cb_session.isSelected()) {
            loadData_receipts(S1_my_sales.ret_data(session, date_from, date_to, users));
        } else {
            loadData_receipts(S1_my_sales.ret_data_date(date_from, date_to));
        }
        

        to_details t = S1_my_sales.ret_cash_in(users, date_from, date_to);
        lbl_cash_in.setText(FitIn.fmt_wc_0(t.cashin));

        double bank_php = 0;
        double bank_usd = 0;
        double credit_card = 0;     
        lbl_expenses.setText(FitIn.fmt_wc_0(t.expenses));
        lbl_cashout.setText(FitIn.fmt_wc_0(t.cashout));
        lbl_addtl_cashins.setText(FitIn.fmt_wc_0(t.addtl_cashins));
        lbl_advance_payment.setText(FitIn.fmt_wc_0(t.advance_payment));
        lbl_adv_usd.setText(FitIn.fmt_wc_0(t.advance_payment_usd));
        lbl_advance_payment_bank.setText(FitIn.fmt_wc_0(t.bank_php));
        lbl_adv_usd_bank.setText(FitIn.fmt_wc_0(t.bank_usd));
        
        List<Srpt_advance_payments.field> advances=Srpt_advance_payments.get_expenses(users, date_from, date_to, date_from, users);
        for(Srpt_advance_payments.field to: advances){
            credit_card+=to.getCredit_card();
        }
        System.out.println("User: "+users);
        System.out.println("From: "+date_from);
        System.out.println("To: "+date_to);
        System.out.println("Credit Card: "+credit_card);
        
        
        lbl_credit_card.setText(FitIn.fmt_wc_0(credit_card));
        outside_cash = t.outside_cash;
        cc_reflenishment = t.cc_reflenishment;

        compute();
    }
    private ArrayListModel tbl_receipt_items_ALM;
    private Tblreceipt_itemsModel tbl_receipt_items_M;

    private void init_tbl_receipt_items() {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);

        int[] tbl_widths_receipt_items = {0, 0, 0, 70, 100, 100, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_receipt_items.getTableHeader().
                setPreferredSize(d);
        tbl_receipt_items.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_receipt_items.setRowHeight(35);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_receipt_items(List<S1_my_sales.to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "receipt_id", "product_name", "QTY", "DESCRIPTION", "PRICE", "AMOUNT", "cat_name"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            S1_my_sales.to_receipt_items tt = (S1_my_sales.to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.receipt_id;
                case 2:
                    return tt.product_name;
                case 3:
                    return FitIn.toInt("" + tt.qty);
                case 4:
                    return tt.description;
                case 5:
                    return tt.unit_price;
                case 6:
                    return tt.qty * tt.unit_price;
                default:
                    return tt.cat_name;
            }
        }
    }

    private void data_cols() {

        int idx = tbl_receipts.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.
                convertRowIndexToModel(idx));

        loadData_receipt_items(S1_my_sales.ret_items("" + to.or_number));
    }
    double gross = 0;

    private void compute() {
        gross = 0;
        double peso = 0;
        double dollar = 0;
        double credit = 0;
        double discount = 0;
        double cash_in = 0;

        List<to_receipts> datas = tbl_receipts_ALM;

        for (to_receipts to : datas) {
            peso += to.peso;
            credit += to.credit;
            discount += to.discount;
            dollar += to.dollar;
            gross += to.tendered;
        }

        lbl_peso.setText(FitIn.fmt_wc_0(peso));
        lbl_dollar.setText(FitIn.fmt_wc_0(dollar));
        lbl_discounts.setText(FitIn.fmt_wc_0(discount));
        lbl_credit.setText(FitIn.fmt_wc_0(credit));
    }

    private void print_sales() {
        final to_date_to.session to = new to_date_to.session(new Date(), new Date(), "", "", 0, session);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                if (System.getProperty("version", "ordering").
                        equals("resto")) {
                    rpt_report.pdf_cashier_session(to, "rpt_cashier_session_1_1");
                } else {
                    String print_to_receipt = System.getProperty("print_to_receipt", "true");
                    if (print_to_receipt.equals("true")) {
                        rpt_report.pdf_cashier_session(to, "rpt_cashier_session");
                    } else {
                        rpt_report.pdf_cashier_session(to, "rpt_cashier_session");
                    }

                }
            }
        });
    }
    int rep = 0;
    double outside_cash = 0;
    double cc_reflenishment = 0;

    private void set_report() {
//        if (rep == 0) {
        int row = jTabbedPane1.getSelectedIndex();
//        JOptionPane.showMessageDialog(null, row);
        final String version = System.getProperty("version", "resto");
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String user_name = to_users.username1;


        double tendered = FitIn.toDouble(lbl_peso.getText());
        double discount = FitIn.toDouble(lbl_discounts.getText());
        double credit = FitIn.toDouble(lbl_credit.getText());
        double expences = FitIn.toDouble(lbl_expenses.getText());
        double cashin = FitIn.toDouble(lbl_cash_in.getText());
        double cashout = FitIn.toDouble(lbl_cashout.getText());
        double addtl_cashin = FitIn.toDouble(lbl_addtl_cashins.getText());
        double dollar = FitIn.toDouble(lbl_dollar.getText());
        double advance_payment = FitIn.toDouble(lbl_advance_payment.getText());
        double advance_payment_usd = FitIn.toDouble(lbl_adv_usd.getText());
        double bank_php = FitIn.toDouble(lbl_advance_payment_bank.getText());
        double bank_usd = FitIn.toDouble(lbl_adv_usd_bank.getText());
        double credit_card = FitIn.toDouble(lbl_credit_card.getText());


        String jrxml_name = "";
        String users = "";
        if (cb_cashier.getSelectedIndex() == -1) {
        } else {
            users = cb_cashier.getSelectedItem().
                    toString();
        }

        if (users.equals("ALL")) {
            users = "";
        } else {
            users = to_users.ret_user(users);
        }


        String business_name = System.getProperty("business_name", "");
        if (version.equals("resto")) {
            final Srpt_cashier_report to = Srpt_cashier_report.ret_data_session(session, dp_from.
                    getDate(), dp_to.getDate(), business_name, dollar, date_from
                    , date_to, tbl_receipts_ALM, tendered, discount, credit
                    , expences, users, cashin, cashout, addtl_cashin, 0, gross
                    , advance_payment, advance_payment_usd, outside_cash, cc_reflenishment
                    , bank_php, bank_usd, credit_card);
            jrxml_name = "rpt_daily_sales_liquid.jrxml";
            
            if (to_users.user_level1.equals("1")) {
                jrxml_name = "rpt_daily_sales_liquid_all.jrxml";
            }
            report_get_viewer_conn_summary(to, jrxml_name);
        } else {
            final Srpt_cashier_report to = Srpt_cashier_report.ret_data_session(session, dp_from.
                    getDate(), dp_to.getDate(), business_name, dollar, date_from, date_to, tbl_receipts_ALM, tendered, discount, credit
                    , expences, users, cashin, cashout, addtl_cashin, 0, gross, advance_payment, advance_payment_usd
                    , outside_cash, cc_reflenishment, bank_php, bank_usd, credit_card);

            jrxml_name = "rpt_daily_sales_cashier_2.jrxml";
            report_get_viewer_conn_summary(to, jrxml_name);

        }


    }

    private void set() {
        List<String> datas = S1_my_sales.ret_cashier();
        List<Srpt_cashiers.field> data = new ArrayList();
        for (String s : datas) {
            Srpt_cashiers.field t = new Srpt_cashiers.field(s, 0);
            data.add(t);
        }

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Ronald\\") + "img_templates\\rpt\\";

        Srpt_cashier_report to1 = new Srpt_cashier_report(SUBREPORT_DIR, new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", data, 0, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, 0, 0);
        String jrxml_name = "rpt_daily_sales_cashier_2.jrxml";



        JRViewer viewer = get_viewer_from(to1, "rpt_daily_sales_cashier_2.jrxml");
        JFrame f = Application.launchMainFrame3(viewer, "", true);
    }

    private void report_get_viewer_conn_summary(final Srpt_cashier_report to, String jrxml_name) {
        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_conn_summary(to, jrxml_name);
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

    private void set_cash_float() {

        String jrxml_name = "rpt_cash_float_main.jrxml";

        List<String> dates = new ArrayList();
        int count = DateUtils.count_days(dp_from.getDate(), dp_to.getDate()) + 1;
        String start = DateType.sf.format(dp_from.getDate());
        dates.add(start);
        String date_interval = "" + DateType.m.format(new Date()) + " " + DateType.d.
                format(dp_from.getDate()) + " - " + DateType.d.format(dp_to.
                getDate());
        Date d = dp_from.getDate();
        for (int i = 0; i < count; i++) {
            d = DateUtils.add_day(d, 1);
            System.out.println(DateType.sf.format(d));
            dates.add(DateType.sf.format(d));
        }
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
        List<Srpt_cash_float.field> datas = Srpt_cash_float.ret_data("", dates, date_interval);
        Srpt_cash_float_main rpt = new Srpt_cash_float_main(datas, SUBREPORT_DIR);
        report_set_float(rpt, jrxml_name);
    }

    private void set_expenses() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());


        String users = "";
        if (cb_cashier.getSelectedIndex() == -1) {
        } else {
            users = cb_cashier.getSelectedItem().
                    toString();
        }

        if (users.equals("ALL")) {
            users = "";
        } else {
            users = to_users.ret_user(users);
        }
        String category_name = cb_category.getSelectedItem().
                toString();
        if (category_name.equalsIgnoreCase("ALL")) {
            category_name = "";
        }
        String vat = "";
        if (cb_vat.isSelected()) {
            vat = "VAT";
        } else {
            vat = "NON VAT";
        }

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";

        List<Srpt_expenses.field> datas = Srpt_expenses.get_expenses(users, date_from, date_to, category_name, vat);
        String jrxml_name = "rpt_expenses_all.jrxml";
        Srpt_expenses_all to = new Srpt_expenses_all(datas, SUBREPORT_DIR, "", dp_from.
                getDate(), dp_to.getDate());

        report_set_expenses(to, jrxml_name);

    }


    private void report_set_float(final Srpt_cash_float_main to, String jrxml_name) {
        pnl_float.removeAll();
        pnl_float.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_float(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_float.add(viewer);
            pnl_float.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void report_set_expenses(final Srpt_expenses_all to, String jrxml_name) {
        pnl_expenses.removeAll();
        pnl_expenses.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_expenses(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_expenses.add(viewer);
            pnl_expenses.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_from(Srpt_cashier_report to, String rpt_name) {

        try {


            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static JRViewer get_viewer_conn_summary(Srpt_cashier_report to, String rpt_name) {

        try {


            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_float(Srpt_cash_float_main to, String rpt_name) {

        try {


            return JasperUtil.getJasperViewer(
                    compileJasper_float(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_expenses(Srpt_expenses_all to, String rpt_name) {

        try {


            return JasperUtil.getJasperViewer(
                    compileJasper_expenses(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_cashier_report.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JasperReport compileJasper_float(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_cash_float_main.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JasperReport compileJasper_expenses(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_expenses_all.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void send_email() {

        Window p = (Window) this;
        Email nd = Email.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Email.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Email.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void edit_receipt() {

        int idx = tbl_receipts.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.
                convertRowIndexToModel(idx));
        String guest_name = to.guest_names;
        String room_name = to.table_name;
        double peso = to.peso;
        double dollar = to.dollar;
        double credit = to.credit;
        to_edit_sales to1 = S1_edit_sales.ret_data(to.room_guest_ids);


        double ap_peso_cash = to1.amount_paid;
        double ap_peso_bank = to1.peso_on_bank;
        double ap_dollar_cash = to1.usd;
        double ap_dollar_bank = to1.usd_on_bank;


        Window p = (Window) this;
        Dlg_edit_sales nd = Dlg_edit_sales.create(p, true);
        nd.setTitle("");
        nd.do_pass(guest_name, room_name, peso, dollar, credit, ap_peso_cash, ap_peso_bank, ap_dollar_cash, ap_dollar_bank);
        nd.setCallback(new Dlg_edit_sales.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_edit_sales.OutputData data) {
                closeDialog.ok();
                S1_edit_sales.edit_receipts(data.to1, to.room_guest_ids);
                Prompt.call("Successfully Updated");
                data_cols_date();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
}
