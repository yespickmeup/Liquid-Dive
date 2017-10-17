/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.redo_receipts;

import POS.expenses.S1_expenses_categories;
import POS.redo_receipts.S1_cash_drawer.to_cash_drawer;
import POS.redo_receipts.S2_guest_advance_payments.to_guest_advance_payment;
import POS.redo_receipts.S2_receipts.to_receipts;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.Prompt;
import POS.utl.TextHighlighter1;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
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
 * @author Maytopacka
 */
public class Dlg_receipts extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_receipts
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
    private Dlg_receipts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_receipts(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_receipts() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_receipts myRef;

    private void setThisRef(Dlg_receipts myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_receipts> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_receipts create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_receipts create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Frame) parent, false);
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
            Dlg_receipts dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_receipts((java.awt.Dialog) parent, false);
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


        Dlg_receipts dialog = Dlg_receipts.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cash_drawer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_cash_in = new javax.swing.JTextField();
        tf_cash_out = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_addtl_cash = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_credit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dp_to = new com.toedter.calendar.JDateChooser();
        cb_cashier = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl_cashout_cc = new javax.swing.JLabel();
        lbl_cashout_usd = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_cashout_php = new javax.swing.JLabel();
        lbl_cashin = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dp_from2 = new com.toedter.calendar.JDateChooser();
        dp_to2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_cashier2 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_expenses = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        tf_expense_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dp_expenses = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        tf_reason = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        cb_vat = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_addt_cashins = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        dp_from1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        dp_to1 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        cb_cashier1 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        tf_expense_amount1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tf_reason1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        dp_expenses1 = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        lbl_total1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        dp_from3 = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        dp_to3 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        cb_cashier3 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        tf_expense_amount2 = new javax.swing.JTextField();
        tf_expense_amount3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        tf_expense_amount4 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        lbl_cashout_cc1 = new javax.swing.JLabel();
        lbl_cashout_cc2 = new javax.swing.JLabel();
        lbl_cashout_cc3 = new javax.swing.JLabel();
        lbl_cashout_cc4 = new javax.swing.JLabel();
        lbl_cashout_cc5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tf_guest = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_guest_advance_payment = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        dp_from4 = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        dp_to4 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbl_cashout_cc6 = new javax.swing.JLabel();
        lbl_cashout_cc7 = new javax.swing.JLabel();
        lbl_cashout_cc8 = new javax.swing.JLabel();
        lbl_cashout_cc9 = new javax.swing.JLabel();
        lbl_cashout_cc10 = new javax.swing.JLabel();
        lbl_cashout_cc11 = new javax.swing.JLabel();
        lbl_cashout_cc12 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tf_expense_amount5 = new javax.swing.JTextField();
        tf_expense_amount6 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tf_expense_amount8 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tf_expense_amount9 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        tf_expense_amount10 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_cash_drawer.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cash_drawer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cash_drawerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cash_drawer);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 98, 850, 373));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CASHIN:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 59, -1));

        tf_cash_in.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_cash_in.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(tf_cash_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 96, -1));

        tf_cash_out.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_cash_out.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(tf_cash_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 92, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CASHOUT:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 75, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PESO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 38, 20));

        tf_addtl_cash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_addtl_cash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(tf_addtl_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 92, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("DOLLAR");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, 20));

        tf_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_credit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(tf_credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 92, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CC");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 38, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("DATE FROM:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 17, -1, 20));
        jPanel2.add(dp_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 17, 112, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("DATE TO:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 17, -1, 20));
        jPanel2.add(dp_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 17, 112, -1));

        cb_cashier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashierActionPerformed(evt);
            }
        });
        jPanel2.add(cb_cashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 16, 225, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CASHIER:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 16, -1, 20));

        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 60, -1));

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        lbl_cashout_cc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc.setText("0.00");
        lbl_cashout_cc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_cashout_cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 100, 29));

        lbl_cashout_usd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_usd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_usd.setText("0.00");
        lbl_cashout_usd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_cashout_usd, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 100, 29));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 330, 29));

        lbl_cashout_php.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_php.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_php.setText("0.00");
        lbl_cashout_php.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_cashout_php, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 100, 29));

        lbl_cashin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashin.setText("0.00");
        lbl_cashin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_cashin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 100, 29));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 100, 29));

        jTabbedPane1.addTab("CASHIN-CASHOUT", jPanel2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DATE FROM:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("DATE TO:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("CASHIER:");

        cb_cashier2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_cashier2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashier2ActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tbl_expenses);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("AMOUNT:");

        tf_expense_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("DATE:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("REASON:");

        tf_reason.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_reason.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("EDIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("CATEGORY:");

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        cb_vat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_vat.setText("VAT?");

        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("ADD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("TOTAL:");

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("0.00");
        lbl_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dp_from2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dp_to2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_cashier2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_expense_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_vat)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(dp_expenses, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addGap(85, 85, 85)
                        .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_from2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_to2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_cashier2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_vat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dp_expenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tf_expense_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tf_reason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("EXPENSES", jPanel3);

        tbl_addt_cashins.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_addt_cashins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_addt_cashinsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_addt_cashins);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("DATE FROM:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("DATE TO:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("CASHIER:");

        cb_cashier1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_cashier1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashier1ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("AMOUNT:");

        tf_expense_amount1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("REASON:");

        tf_reason1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_reason1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("DATE:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("TOTAL:");

        lbl_total1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_total1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total1.setText("0.00");
        lbl_total1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton7.setText("CLOSE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("DELETE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("EDIT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("ADD");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(10, 10, 10)
                        .addComponent(dp_from1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(10, 10, 10)
                        .addComponent(dp_to1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(cb_cashier1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_expense_amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_reason1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_expenses1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cashier1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_from1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dp_to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tf_expense_amount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(tf_reason1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(dp_expenses1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton8)
                            .addComponent(jButton9)
                            .addComponent(jButton10))))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADDITIONAL CASHIN", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_receipts.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_receipts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_receiptsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_receipts);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 90, 850, 390));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("DATE FROM:");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));
        jPanel5.add(dp_from3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 17, 112, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("DATE TO:");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 17, -1, 20));
        jPanel5.add(dp_to3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 17, 112, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("CASHIER:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 16, -1, 20));

        cb_cashier3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_cashier3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashier3ActionPerformed(evt);
            }
        });
        jPanel5.add(cb_cashier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 16, 225, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("CREDIT CARD:");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 20));

        tf_expense_amount2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf_expense_amount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 96, -1));

        tf_expense_amount3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf_expense_amount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 96, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("DOLLAR:");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("PESO:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, 20));

        tf_expense_amount4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(tf_expense_amount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 96, -1));

        jButton11.setText("CLOSE");
        jPanel5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 56, -1, -1));

        jButton12.setText("EDIT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 56, 75, -1));

        lbl_cashout_cc1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_cashout_cc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 480, 263, 29));

        lbl_cashout_cc2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc2.setText("0.00");
        lbl_cashout_cc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_cashout_cc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 480, 100, 29));

        lbl_cashout_cc3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc3.setText("0.00");
        lbl_cashout_cc3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_cashout_cc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 480, 100, 29));

        lbl_cashout_cc4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc4.setText("0.00");
        lbl_cashout_cc4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_cashout_cc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 480, 100, 29));

        lbl_cashout_cc5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(lbl_cashout_cc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 270, 29));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("GUEST:");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 50, 20));

        tf_guest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_guest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_guest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_guestKeyReleased(evt);
            }
        });
        jPanel5.add(tf_guest, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        jTabbedPane1.addTab("PAYMENTS", jPanel5);

        jPanel6.setLayout(null);

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_guest_advance_payment.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guest_advance_payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guest_advance_paymentMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_guest_advance_payment);

        jPanel6.add(jScrollPane5);
        jScrollPane5.setBounds(10, 99, 856, 380);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("DATE FROM:");
        jPanel6.add(jLabel33);
        jLabel33.setBounds(10, 12, 75, 20);
        jPanel6.add(dp_from4);
        dp_from4.setBounds(95, 12, 91, 20);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("DATE TO:");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(190, 12, 56, 20);
        jPanel6.add(dp_to4);
        dp_to4.setBounds(256, 12, 128, 20);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("GUESTS:");
        jPanel6.add(jLabel35);
        jLabel35.setBounds(388, 11, 50, 20);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel6.add(jTextField1);
        jTextField1.setBounds(448, 11, 208, 21);

        lbl_cashout_cc6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc6.setText("0.00");
        lbl_cashout_cc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc6);
        lbl_cashout_cc6.setBounds(750, 480, 100, 27);

        lbl_cashout_cc7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc7.setText("0.00");
        lbl_cashout_cc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc7);
        lbl_cashout_cc7.setBounds(650, 480, 100, 27);

        lbl_cashout_cc8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc8.setText("0.00");
        lbl_cashout_cc8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc8);
        lbl_cashout_cc8.setBounds(550, 480, 100, 27);

        lbl_cashout_cc9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc9.setText("0.00");
        lbl_cashout_cc9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc9);
        lbl_cashout_cc9.setBounds(450, 480, 100, 27);

        lbl_cashout_cc10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc10);
        lbl_cashout_cc10.setBounds(10, 480, 200, 27);

        lbl_cashout_cc11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc11.setText("0.00");
        lbl_cashout_cc11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc11);
        lbl_cashout_cc11.setBounds(350, 480, 100, 27);

        lbl_cashout_cc12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout_cc12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout_cc12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(lbl_cashout_cc12);
        lbl_cashout_cc12.setBounds(210, 480, 140, 27);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("PESO-BANK:");
        jPanel6.add(jLabel36);
        jLabel36.setBounds(10, 70, 74, 20);

        tf_expense_amount5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tf_expense_amount5);
        tf_expense_amount5.setBounds(90, 70, 90, 21);

        tf_expense_amount6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tf_expense_amount6);
        tf_expense_amount6.setBounds(290, 70, 90, 21);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("BANK-DOLLAR:");
        jPanel6.add(jLabel37);
        jLabel37.setBounds(190, 70, 100, 20);

        tf_expense_amount8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tf_expense_amount8);
        tf_expense_amount8.setBounds(90, 40, 90, 21);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("PESO:");
        jPanel6.add(jLabel39);
        jLabel39.setBounds(10, 40, 36, 20);

        tf_expense_amount9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tf_expense_amount9);
        tf_expense_amount9.setBounds(290, 40, 90, 21);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("DOLLAR:");
        jPanel6.add(jLabel40);
        jLabel40.setBounds(190, 40, 70, 20);

        tf_expense_amount10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_expense_amount10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tf_expense_amount10);
        tf_expense_amount10.setBounds(480, 70, 90, 21);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("CREDIT CARD:");
        jPanel6.add(jLabel41);
        jLabel41.setBounds(390, 70, 88, 20);

        jButton14.setText("CLOSE");
        jPanel6.add(jButton14);
        jButton14.setBounds(799, 70, 70, 23);

        jButton15.setText("DELETE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton15);
        jButton15.setBounds(720, 70, 70, 23);

        jButton16.setText("EDIT");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton16);
        jButton16.setBounds(650, 70, 70, 23);

        jTabbedPane1.addTab("ADVANCE PAYMENTS", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        edit_cash_drawer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_cash_drawerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cash_drawerMouseClicked
        select_cash_drawer();
    }//GEN-LAST:event_tbl_cash_drawerMouseClicked

    private void cb_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashierActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_cashierActionPerformed

    private void cb_cashier2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashier2ActionPerformed
        data_cols_expenses();
    }//GEN-LAST:event_cb_cashier2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        edit_expenses();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void tbl_expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_expensesMouseClicked
        select_expenses();
    }//GEN-LAST:event_tbl_expensesMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        delete_expenses();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        add_expenses();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cb_cashier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashier1ActionPerformed
        data_cols_expenses();;
    }//GEN-LAST:event_cb_cashier1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        delete_addt_cashins();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        edit_addt_cashins();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tbl_addt_cashinsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_addt_cashinsMouseClicked
        select_addt_cashins();
    }//GEN-LAST:event_tbl_addt_cashinsMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        add_addt_cashins();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cb_cashier3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashier3ActionPerformed
        data_cols_payments();
    }//GEN-LAST:event_cb_cashier3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        select_receipts();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        edit_receipts();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tf_guestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_guestKeyReleased
        data_cols_payments();
    }//GEN-LAST:event_tf_guestKeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        data_cols_ap();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void tbl_guest_advance_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guest_advance_paymentMouseClicked
        select_guest_advance_payment();
    }//GEN-LAST:event_tbl_guest_advance_paymentMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        edit_guest_advance_payment();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        delete_guest_advance_payment();
    }//GEN-LAST:event_jButton15ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cashier;
    private javax.swing.JComboBox cb_cashier1;
    private javax.swing.JComboBox cb_cashier2;
    private javax.swing.JComboBox cb_cashier3;
    private javax.swing.JComboBox cb_category;
    private javax.swing.JCheckBox cb_vat;
    private com.toedter.calendar.JDateChooser dp_expenses;
    private com.toedter.calendar.JDateChooser dp_expenses1;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_from1;
    private com.toedter.calendar.JDateChooser dp_from2;
    private com.toedter.calendar.JDateChooser dp_from3;
    private com.toedter.calendar.JDateChooser dp_from4;
    private com.toedter.calendar.JDateChooser dp_to;
    private com.toedter.calendar.JDateChooser dp_to1;
    private com.toedter.calendar.JDateChooser dp_to2;
    private com.toedter.calendar.JDateChooser dp_to3;
    private com.toedter.calendar.JDateChooser dp_to4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_cashin;
    private javax.swing.JLabel lbl_cashout_cc;
    private javax.swing.JLabel lbl_cashout_cc1;
    private javax.swing.JLabel lbl_cashout_cc10;
    private javax.swing.JLabel lbl_cashout_cc11;
    private javax.swing.JLabel lbl_cashout_cc12;
    private javax.swing.JLabel lbl_cashout_cc2;
    private javax.swing.JLabel lbl_cashout_cc3;
    private javax.swing.JLabel lbl_cashout_cc4;
    private javax.swing.JLabel lbl_cashout_cc5;
    private javax.swing.JLabel lbl_cashout_cc6;
    private javax.swing.JLabel lbl_cashout_cc7;
    private javax.swing.JLabel lbl_cashout_cc8;
    private javax.swing.JLabel lbl_cashout_cc9;
    private javax.swing.JLabel lbl_cashout_php;
    private javax.swing.JLabel lbl_cashout_usd;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_total1;
    private javax.swing.JTable tbl_addt_cashins;
    private javax.swing.JTable tbl_cash_drawer;
    private javax.swing.JTable tbl_expenses;
    private javax.swing.JTable tbl_guest_advance_payment;
    private javax.swing.JTable tbl_receipts;
    private javax.swing.JTextField tf_addtl_cash;
    private javax.swing.JTextField tf_cash_in;
    private javax.swing.JTextField tf_cash_out;
    private javax.swing.JTextField tf_credit;
    private javax.swing.JTextField tf_expense_amount;
    private javax.swing.JTextField tf_expense_amount1;
    private javax.swing.JTextField tf_expense_amount10;
    private javax.swing.JTextField tf_expense_amount2;
    private javax.swing.JTextField tf_expense_amount3;
    private javax.swing.JTextField tf_expense_amount4;
    private javax.swing.JTextField tf_expense_amount5;
    private javax.swing.JTextField tf_expense_amount6;
    private javax.swing.JTextField tf_expense_amount8;
    private javax.swing.JTextField tf_expense_amount9;
    private javax.swing.JTextField tf_guest;
    private javax.swing.JTextField tf_reason;
    private javax.swing.JTextField tf_reason1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        dp_from2.setDate(new Date());
        dp_to2.setDate(new Date());
        dp_expenses.setDate(new Date());


        dp_from1.setDate(new Date());
        dp_to1.setDate(new Date());
        dp_expenses1.setDate(new Date());

        dp_from3.setDate(new Date());
        dp_to3.setDate(new Date());

        dp_from4.setDate(new Date());
        dp_to4.setDate(new Date());

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
        dp_from2.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_expenses();
            }
        });
        dp_to2.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_expenses();
            }
        });

        dp_from1.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_addtl();
            }
        });
        dp_to1.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_addtl();
            }
        });
        dp_from3.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_payments();
            }
        });
        dp_to3.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_payments();
            }
        });
        dp_from4.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_ap();
            }
        });
        dp_to4.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_cols_ap();
            }
        });

        set_cashier();
        set_category();
        init_tbl_cash_drawer();
        data_cols();

        init_tbl_expenses();
        data_cols_expenses();

        init_tbl_addt_cashins();
        data_cols_addtl();

        init_tbl_receipts();
        data_cols_payments();

        init_tbl_guest_advance_payment();
        data_cols_ap();
    }

    private void set_cashier() {
        cb_cashier.setModel(new ListComboBoxModel(S1_users.ret_cb_data()));
        cb_cashier2.setModel(new ListComboBoxModel(S1_users.ret_cb_data()));
        cb_cashier1.setModel(new ListComboBoxModel(S1_users.ret_cb_data()));
        cb_cashier3.setModel(new ListComboBoxModel(S1_users.ret_cb_data()));
    }

    private void set_category() {
        cb_category.setModel(new ListComboBoxModel(S1_expenses_categories.
                ret_cb_data3()));
    }

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
    private ArrayListModel tbl_cash_drawer_ALM;
    private Tblcash_drawerModel tbl_cash_drawer_M;

    private void init_tbl_cash_drawer() {
        tbl_cash_drawer_ALM = new ArrayListModel();
        tbl_cash_drawer_M = new Tblcash_drawerModel(tbl_cash_drawer_ALM);
        tbl_cash_drawer.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_cash_drawer.setModel(tbl_cash_drawer_M);
        tbl_cash_drawer.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cash_drawer.setRowHeight(25);
        int[] tbl_widths_cash_drawer = {0, 0, 100, 100, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_cash_drawer.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cash_drawer, i, tbl_widths_cash_drawer[i]);
        }
        Dimension d = tbl_cash_drawer.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_cash_drawer.getTableHeader().
                setPreferredSize(d);
        tbl_cash_drawer.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cash_drawer.setRowHeight(35);
        tbl_cash_drawer.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_cash_drawer(List<to_cash_drawer> acc) {
        tbl_cash_drawer_ALM.clear();
        tbl_cash_drawer_ALM.addAll(acc);
    }

    public static class Tblcash_drawerModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "cashier_session_id", "DATE ADDED", "CASHIER", "CASHIN", "CASHOUT-Php", "CASHOUT-USD", "CASHOUT-CC"
        };

        public Tblcash_drawerModel(ListModel listmodel) {
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
            to_cash_drawer tt = (to_cash_drawer) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.cashier_session_id;
                case 2:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 3:
                    return to_users.ret_data(tt.user_name);
                case 4:
                    return FitIn.fmt_wc_0(tt.cash_in);
                case 5:
                    return FitIn.fmt_wc_0(tt.cash_out);
                case 6:
                    return FitIn.fmt_wc_0(tt.addtl_cash);
                default:
                    return FitIn.fmt_wc_0(tt.credit);
            }
        }
    }

    private void data_cols() {
//        String search = tf_search.getText();
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String cashier_name = to_users.ret_user(cb_cashier.getSelectedItem().
                toString());
        loadData_cash_drawer(S1_cash_drawer.ret_data(date_from, date_to, cashier_name));
        List<to_cash_drawer> datas = tbl_cash_drawer_ALM;
        double cashin = 0;
        double co_php = 0;
        double co_usd = 0;
        double co_cc = 0;
        for (to_cash_drawer to : datas) {
            cashin += to.cash_in;
            co_php += to.cash_out;
            co_usd += to.addtl_cash;
            co_cc += to.credit;
        }
        lbl_cashin.setText(FitIn.fmt_wc_0(cashin));
        lbl_cashout_php.setText(FitIn.fmt_wc_0(co_php));
        lbl_cashout_usd.setText(FitIn.fmt_wc_0(co_usd));
        lbl_cashout_cc.setText(FitIn.fmt_wc_0(co_cc));

    }

    private void select_cash_drawer() {
        int row = tbl_cash_drawer.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_cash_drawer to = (to_cash_drawer) tbl_cash_drawer_ALM.get(tbl_cash_drawer.
                convertRowIndexToModel(row));
//        tf_cashier_session_id.setText(FitIn.fmt_wc_0(to.cashier_session_id));
//        tf_user_name.setText(to.user_name);
//        tf_date_added.setText(to.date_added);
        tf_cash_in.setText(FitIn.fmt_wc_0(to.cash_in));
        tf_cash_out.setText(FitIn.fmt_wc_0(to.cash_out));
        tf_addtl_cash.setText(FitIn.fmt_wc_0(to.addtl_cash));
        tf_credit.setText(FitIn.fmt_wc_0(to.credit));
    }

    private void edit_cash_drawer() {
        int row = tbl_cash_drawer.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_cash_drawer to = (to_cash_drawer) tbl_cash_drawer_ALM.get(tbl_cash_drawer.
                convertRowIndexToModel(row));
        int id = to.id;
        int cashier_session_id = to.cashier_session_id;//FitIn.toDouble(tf_cashier_session_id.getText());
        String user_name = to.user_name;//tf_user_name.getText();
        String date_added = to.date_added;//tf_date_added.getText();
        double cash_in = FitIn.toDouble(tf_cash_in.getText());
        double cash_out = FitIn.toDouble(tf_cash_out.getText());
        double addtl_cash = FitIn.toDouble(tf_addtl_cash.getText());
        double credit = FitIn.toDouble(tf_credit.getText());
        to_cash_drawer to1 = new to_cash_drawer(id, cashier_session_id, user_name, date_added, cash_in, cash_out, addtl_cash, credit);
        S1_cash_drawer.edit_cash_drawer(to1);
        data_cols();
        clear_cash_drawer();
    }

    private void clear_cash_drawer() {
//        tf_cashier_session_id.setText("");
//        tf_user_name.setText("");
//        tf_date_added.setText("");
        tf_cash_in.setText("");
        tf_cash_out.setText("");
        tf_addtl_cash.setText("");
        tf_credit.setText("");
    }
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
        tbl_expenses.setAutoResizeMode(0);
        int[] tbl_widths_expenses = {0, 150, 100, 100, 200, 0, 150, 100};
        for (int i = 0, n = tbl_widths_expenses.length; i < n; i++) {
//            if (i == 100) {
//                continue;
//            }
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

    private void loadData_expenses(List<S2_expenses.to_expenses> acc) {
        tbl_expenses_ALM.clear();
        tbl_expenses_ALM.addAll(acc);
    }

    public static class TblexpensesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "Date Added", "Cashier", "Amount", "Purpose", "session_id", "Category", "vat"
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
            S2_expenses.to_expenses tt = (S2_expenses.to_expenses) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 2:
                    return to_users.ret_data(tt.user_name);
                case 3:
                    return FitIn.fmt_wc_0(tt.amount);
                case 4:
                    return tt.purpose;
                case 5:
                    return tt.session_id;
                case 6:
                    return tt.category_name;
                default:
                    return tt.vat;
            }
        }
    }

    private void data_cols_expenses() {
        String date_from = DateType.sf.format(dp_from2.getDate());
        String date_to = DateType.sf.format(dp_to2.getDate());
        String cashier_name = to_users.ret_user(cb_cashier2.getSelectedItem().
                toString());
        String category = "";
        loadData_expenses(S2_expenses.ret_data(date_from, date_to, cashier_name));
        List<S2_expenses.to_expenses> datas = tbl_expenses_ALM;
        double total = 0;
        for (S2_expenses.to_expenses to : datas) {
            total += FitIn.toDouble(to.amount);
        }
        lbl_total.setText(FitIn.fmt_wc_0(total));
    }

    private void add_expenses() {
        int id = -1;
        String date_added = DateType.datetime.format(dp_expenses.getDate());

        String user_name = cb_cashier2.getSelectedItem().
                toString();
        if (cb_cashier2.getSelectedIndex() == 0) {
            Prompt.call("Choose User");
            return;
        }
        user_name = to_users.ret_user(user_name);
        String amount = tf_expense_amount.getText();
        String purpose = tf_reason.getText();
        int session_id = -1;
        String category_name = cb_category.getSelectedItem().
                toString();
        String vat = "NON VAT";
        if (cb_vat.isSelected()) {
            vat = "VAT";
        }
        S2_expenses.to_expenses to = new S2_expenses.to_expenses(id, date_added, user_name, amount, purpose, session_id, category_name, vat);
        S2_expenses.add_expenses(to);
        data_cols_expenses();
        clear_expenses();
    }

    private void select_expenses() {
        int row = tbl_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        S2_expenses.to_expenses to = (S2_expenses.to_expenses) tbl_expenses_ALM.
                get(tbl_expenses.convertRowIndexToModel(row));
//        tf_date_added.setText(to.date_added);
        Date d = new Date();
        try {
            d = DateType.datetime.parse(to.date_added);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_receipts.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        dp_expenses.setDate(d);
//        tf_user_name.setText(to.user_name);
        tf_expense_amount.setText(to.amount);
        tf_reason.setText(to.purpose);
//        tf_session_id.setText(FitIn.fmt_wc_0(to.session_id));
        cb_category.setSelectedItem(to.category_name);
//        tf_vat.setText(to.vat);
        if (to.vat.equalsIgnoreCase("VAT")) {
            cb_vat.setSelected(true);
        } else {
            cb_vat.setSelected(false);
        }
    }

    private void edit_expenses() {
        int row = tbl_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }
        S2_expenses.to_expenses to = (S2_expenses.to_expenses) tbl_expenses_ALM.
                get(tbl_expenses.convertRowIndexToModel(row));
        int id = to.id;
        String date_added = DateType.datetime.format(dp_expenses.getDate());
        String user_name = to.user_name;
        String amount = tf_expense_amount.getText();
        String purpose = tf_reason.getText();
        int session_id = to.session_id;
        String category_name = cb_category.getSelectedItem().
                toString();
        String vat = "NON VAT";
        if (cb_vat.isSelected()) {
            vat = "VAT";
        }

        S2_expenses.to_expenses to1 = new S2_expenses.to_expenses(id, date_added, user_name, amount, purpose, session_id, category_name, vat);
        S2_expenses.edit_expenses(to1);
        data_cols_expenses();
        clear_expenses();
    }

    private void clear_expenses() {
//        tf_date_added.setText("");
//        tf_user_name.setText("");
        tf_expense_amount.setText("");
        tf_reason.setText("");
//        tf_session_id.setText("");
//        tf_category_name.setText("");
//        tf_vat.setText("");
    }

    private void delete_expenses() {
        int row = tbl_expenses.getSelectedRow();
        if (row < 0) {
            return;
        }

        S2_expenses.to_expenses to = (S2_expenses.to_expenses) tbl_expenses_ALM.
                get(tbl_expenses.convertRowIndexToModel(row));
        S2_expenses.delete_expenses(to);
        data_cols_expenses();
        clear_expenses();

    }
    private ArrayListModel tbl_addt_cashins_ALM;
    private Tbladdt_cashinsModel tbl_addt_cashins_M;

    private void init_tbl_addt_cashins() {
        tbl_addt_cashins_ALM = new ArrayListModel();
        tbl_addt_cashins_M = new Tbladdt_cashinsModel(tbl_addt_cashins_ALM);
        tbl_addt_cashins.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_addt_cashins.setModel(tbl_addt_cashins_M);
        tbl_addt_cashins.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_addt_cashins.setRowHeight(25);
        int[] tbl_widths_addt_cashins = {0, 100, 150, 100, 200, 0};
        for (int i = 0, n = tbl_widths_addt_cashins.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_addt_cashins, i, tbl_widths_addt_cashins[i]);
        }
//        Dimension d = tbl_addt_cashins.getTableHeader().
//                getPreferredSize();
//        d.height = 30;
//        tbl_addt_cashins.getTableHeader().
//                setPreferredSize(d);
        tbl_addt_cashins.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_addt_cashins.setRowHeight(35);
        tbl_addt_cashins.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_addt_cashins(List<S2_addtl_cashins.to_addt_cashins> acc) {
        tbl_addt_cashins_ALM.clear();
        tbl_addt_cashins_ALM.addAll(acc);
    }

    public static class Tbladdt_cashinsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "DATE ADDED", "CASHIER", "AMOUNT", "PURPOSE", "session_id"
        };

        public Tbladdt_cashinsModel(ListModel listmodel) {
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
            S2_addtl_cashins.to_addt_cashins tt = (S2_addtl_cashins.to_addt_cashins) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 2:
                    return to_users.ret_data(tt.user_name);
                case 3:
                    return FitIn.fmt_wc_0(tt.amount);
                case 4:
                    return tt.purpose;
                default:
                    return tt.session_id;
            }
        }
    }

    private void data_cols_addtl() {
//        String search = tf_search.getText();
//        loadData_addt_cashins(S2_addtl_cashins.ret_data(search));
        String date_from = DateType.sf.format(dp_from1.getDate());
        String date_to = DateType.sf.format(dp_to1.getDate());
        String cashier_name = to_users.ret_user(cb_cashier1.getSelectedItem().
                toString());
        if (cb_cashier2.getSelectedIndex() == 0) {
            cashier_name = "";
        }
        loadData_addt_cashins(S2_addtl_cashins.ret_data(date_from, date_to, cashier_name));
        List<S2_addtl_cashins.to_addt_cashins> datas = tbl_addt_cashins_ALM;
        double total = 0;
        for (S2_addtl_cashins.to_addt_cashins to : datas) {
            total += to.amount;
        }

        lbl_total1.setText(FitIn.fmt_wc_0(total));

    }

    private void add_addt_cashins() {
        int id = -1;
        String date_added = DateType.datetime.format(dp_expenses1.getDate());

        String user_name = cb_cashier1.getSelectedItem().
                toString();
        if (cb_cashier1.getSelectedIndex() == 0) {
            Prompt.call("Choose User");
            return;
        }
        user_name = to_users.ret_user(user_name);
        double amount = FitIn.toDouble(tf_expense_amount1.getText());
        String purpose = tf_reason1.getText();
        int session_id = -1;
        S2_addtl_cashins.to_addt_cashins to = new S2_addtl_cashins.to_addt_cashins(id, date_added, user_name, amount, purpose, session_id);
        S2_addtl_cashins.add_addt_cashins(to);
        data_cols_addtl();
        clear_addt_cashins();
    }

    private void select_addt_cashins() {
        int row = tbl_addt_cashins.getSelectedRow();
        if (row < 0) {
            return;
        }
        S2_addtl_cashins.to_addt_cashins to = (S2_addtl_cashins.to_addt_cashins) tbl_addt_cashins_ALM.
                get(tbl_addt_cashins.convertRowIndexToModel(row));
        Date d = new Date();
        try {
            d = DateType.datetime.parse(to.date_added);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_receipts.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        dp_expenses1.setDate(d);
//        tf_user_name.setText(to.user_name);
        tf_expense_amount1.setText(FitIn.fmt_wc_0(to.amount));
        tf_reason1.setText("" + to.purpose);
    }

    private void edit_addt_cashins() {
        int row = tbl_addt_cashins.getSelectedRow();
        if (row < 0) {
            return;
        }
        S2_addtl_cashins.to_addt_cashins to = (S2_addtl_cashins.to_addt_cashins) tbl_addt_cashins_ALM.
                get(tbl_addt_cashins.convertRowIndexToModel(row));
        int id = to.id;

        String date_added = DateType.datetime.format(dp_expenses1.getDate());

        String user_name = to.user_name;
//                toString();
//        if (cb_cashier1.getSelectedIndex() == 0) {
//            Prompt.call("Choose User");
//            return;
//        }
//        user_name = to_users.ret_user(user_name);
        double amount = FitIn.toDouble(tf_expense_amount1.getText());
        String purpose = tf_reason1.getText();
        int session_id = to.session_id;
        S2_addtl_cashins.to_addt_cashins to1 = new S2_addtl_cashins.to_addt_cashins(id, date_added, user_name, amount, purpose, session_id);
        S2_addtl_cashins.edit_addt_cashins(to1);
        data_cols_addtl();
        clear_addt_cashins();
    }

    private void clear_addt_cashins() {
        tf_expense_amount1.setText("");
        tf_reason1.setText("");
//        tf_amount.setText("");
//        tf_purpose.setText("");
//        tf_session_id.setText("");
    }

    private void delete_addt_cashins() {
        int row = tbl_addt_cashins.getSelectedRow();
        if (row < 0) {
            return;
        }
        S2_addtl_cashins.to_addt_cashins to = (S2_addtl_cashins.to_addt_cashins) tbl_addt_cashins_ALM.
                get(tbl_addt_cashins.convertRowIndexToModel(row));
        S2_addtl_cashins.delete_addt_cashins(to);
        data_cols_addtl();
        clear_addt_cashins();
    }
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
//        tbl_receipts.setAutoResizeMode(0);
        int[] tbl_widths_receipts = {0, 0, 0, 0, 150, 150, 100, 100, 0, 0, 0, 100, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 4 || i == 5) {
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
            "id", "cashier_session_id", "tendered", "or_number", "DATE", "GUEST", "DUE", "CREDIT CARD", "approval_code", "member_id", "is_payed", "DOLLAR", "credit_dollar", "dollar_rate", "PESO", "user_name", "guest_ids", "guest_names", "room_guest_ids", "table_id", "table_name", "gross_sales", "bank_php", "bank_usd", "credit_card"
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
                    return tt.cashier_session_id;
                case 2:
                    return tt.discount;
                case 3:
                    return tt.or_number;
                case 4:
                    return DateType.convert_jan_1_2013_datetime(tt.receipt_date);
                case 5:
                    return tt.guest_names;
                case 6:
                    return FitIn.fmt_wc_0(tt.tendered);
                case 7:
                    return FitIn.fmt_wc_0(tt.credit);
                case 8:
                    return tt.approval_code;
                case 9:
                    return tt.member_id;
                case 10:
                    return tt.is_payed;
                case 11:
                    if (tt.dollar > 0 && tt.peso > 0) {
                        return TextHighlighter1.highlight(FitIn.fmt_wc_0(tt.dollar), FitIn.
                                fmt_wc_0(tt.dollar), "RED");
                    } else {
                        return FitIn.fmt_wc_0(tt.dollar);
                    }

                case 12:
                    return tt.credit_dollar;
                case 13:
                    return tt.dollar_rate;
                case 14:
                    if (tt.dollar > 0 && tt.peso > 0) {
                        return TextHighlighter1.highlight(FitIn.fmt_wc_0(tt.peso), FitIn.
                                fmt_wc_0(tt.peso), "RED");
                    } else {
                        return FitIn.fmt_wc_0(tt.peso);
                    }
//                    return FitIn.fmt_wc_0(tt.peso);
                case 15:
                    return tt.user_name;
                case 16:
                    return tt.guest_ids;
                case 17:
                    return tt.guest_names;
                case 18:
                    return tt.room_guest_ids;
                case 19:
                    return tt.table_id;
                case 20:
                    return tt.table_name;
                case 21:
                    return tt.gross_sales;
                case 22:
                    return tt.bank_php;
                case 23:
                    return tt.bank_usd;
                default:
                    return tt.credit_card;
            }
        }
    }

    private void data_cols_payments() {
        String search = tf_guest.getText();
        String date_from = DateType.sf.format(dp_from3.getDate());
        String date_to = DateType.sf.format(dp_to3.getDate());
        String cashier_name = to_users.ret_user(cb_cashier3.getSelectedItem().
                toString());
//        String guest="";
        if (cb_cashier2.getSelectedIndex() == 0) {
            cashier_name = "";
        }
        loadData_receipts(S2_receipts.ret_data(date_from, date_to, search, cashier_name));

        double credit_card = 0;
        double dollar = 0;
        double php = 0;
        List<to_receipts> datas = tbl_receipts_ALM;
        for (to_receipts to : datas) {
            credit_card += to.credit_card;
            dollar += to.dollar;
            php += to.peso;
        }

        lbl_cashout_cc4.setText(FitIn.fmt_wc_0(credit_card));
        lbl_cashout_cc3.setText(FitIn.fmt_wc_0(dollar));
        lbl_cashout_cc2.setText(FitIn.fmt_wc_0(php));
    }

    private void select_receipts() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.
                convertRowIndexToModel(row));

        tf_expense_amount2.setText(FitIn.fmt_wc_0(to.credit));
        tf_expense_amount3.setText(FitIn.fmt_wc_0(to.dollar));
        tf_expense_amount4.setText(FitIn.fmt_wc_0(to.peso));
    }

    private void edit_receipts() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts to = (to_receipts) tbl_receipts_ALM.get(tbl_receipts.
                convertRowIndexToModel(row));
        int id = to.id;
        int cashier_session_id = to.cashier_session_id;
        double tendered = to.tendered;
        String or_number = to.or_number;
        int receipt_status = to.receipt_status;
        String receipt_date = to.receipt_date;
        double discount = to.discount;
        double credit = FitIn.toDouble(tf_expense_amount2.getText());
        String approval_code = to.approval_code;
        String member_id = to.member_id;
        String is_payed = to.is_payed;
        double dollar = FitIn.toDouble(tf_expense_amount3.getText());
        double credit_dollar = to.credit_dollar;
        double dollar_rate = to.dollar_rate;
        double peso = FitIn.toDouble(tf_expense_amount4.getText());
        String user_name = to.user_name;
        String guest_ids = to.guest_ids;
        String guest_names = to.guest_names;
        String room_guest_ids = to.room_guest_ids;
        String table_id = to.table_id;
        String table_name = to.table_name;
        double gross_sales = to.gross_sales;
        double bank_php = to.bank_php;
        double bank_usd = to.bank_usd;
        double credit_card = to.credit_card;
        to_receipts to1 = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar, credit_dollar, dollar_rate, peso, user_name, guest_ids, guest_names, room_guest_ids, table_id, table_name, gross_sales, bank_php, bank_usd, credit_card);
        S2_receipts.edit_receipts(to1);
        data_cols_payments();
        tf_expense_amount2.setText("");
        tf_expense_amount3.setText("");
        tf_expense_amount4.setText("");

//        clear_receipts();
    }
    private ArrayListModel tbl_guest_advance_payment_ALM;
    private Tblguest_advance_paymentModel tbl_guest_advance_payment_M;

    private void init_tbl_guest_advance_payment() {
        tbl_guest_advance_payment_ALM = new ArrayListModel();
        tbl_guest_advance_payment_M = new Tblguest_advance_paymentModel(tbl_guest_advance_payment_ALM);
        tbl_guest_advance_payment.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_guest_advance_payment.setModel(tbl_guest_advance_payment_M);
        tbl_guest_advance_payment.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guest_advance_payment.setRowHeight(25);
        int[] tbl_widths_guest_advance_payment = {
            0, 0, 100, 0, 150, 100, 0, 0, 100, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0};
        for (int i = 0, n = tbl_widths_guest_advance_payment.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guest_advance_payment, i, tbl_widths_guest_advance_payment[i]);
        }
        Dimension d = tbl_guest_advance_payment.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_guest_advance_payment.getTableHeader().
                setPreferredSize(d);
        tbl_guest_advance_payment.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guest_advance_payment.setRowHeight(35);
        tbl_guest_advance_payment.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_guest_advance_payment(List<to_guest_advance_payment> acc) {
        tbl_guest_advance_payment_ALM.clear();
        tbl_guest_advance_payment_ALM.addAll(acc);
    }

    public static class Tblguest_advance_paymentModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "room_id", "DATE", "guest_id", "GUESTS", "PESO", "status", "user_name", "USD", "room_guest_id", "PESO-BANK", "USD-BANK", "is_peso_on_bank", "is_usd_on_bank", "bank_no", "bank", "card_type", "card_holder", "card_no", "approval_code", "CREDIT CARD", "credit_addtl", "credit_rate"
        };

        public Tblguest_advance_paymentModel(ListModel listmodel) {
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
            to_guest_advance_payment tt = (to_guest_advance_payment) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.room_id;
                case 2:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
                case 3:
                    return tt.guest_id;
                case 4:
                    return tt.guest_name + " = " + S2_guest_advance_payments.
                            increment_id(tt.room_id);
                case 5:
                    return FitIn.fmt_wc_0(tt.amount_paid);
                case 6:
                    return tt.status;
                case 7:
                    return tt.user_name;
                case 8:
                    return FitIn.fmt_wc_0(tt.usd);
                case 9:
                    return tt.room_guest_id;
                case 10:
                    return FitIn.fmt_wc_0(tt.peso_on_bank);
                case 11:
                    return FitIn.fmt_wc_0(tt.usd_on_bank);
                case 12:
                    return tt.is_peso_on_bank;
                case 13:
                    return tt.is_usd_on_bank;
                case 14:
                    return tt.bank_no;
                case 15:
                    return tt.bank;
                case 16:
                    return tt.card_type;
                case 17:
                    return tt.card_holder;
                case 18:
                    return tt.card_no;
                case 19:
                    return tt.approval_code;
                case 20:
                    return FitIn.fmt_wc_0(tt.credit_amount);
                case 21:
                    return tt.credit_addtl;
                default:
                    return tt.credit_rate;
            }
        }
    }

    private void data_cols_ap() {
        String date_from = DateType.sf.format(dp_from4.getDate());
        String date_to = DateType.sf.format(dp_to4.getDate());
        String guests = jTextField1.getText();
//        String search = tf_search.getText();
        loadData_guest_advance_payment(S2_guest_advance_payments.ret_data(date_from, date_to, guests));
        List<to_guest_advance_payment> datas=tbl_guest_advance_payment_ALM;
        double peso=0;
        double usd=0;
        double peso_b=0;
        double usd_b=0;
        double cc=0;
        for(to_guest_advance_payment to:datas){
            peso+=to.amount_paid;
            usd+=to.usd;
            peso_b+=to.peso_on_bank;
            usd_b+=to.usd_on_bank;
            cc+=to.credit_amount;
        }
         lbl_cashout_cc11.setText(FitIn.fmt_woc(peso));
        lbl_cashout_cc9.setText(FitIn.fmt_woc(usd));
        lbl_cashout_cc8.setText(FitIn.fmt_woc(peso_b));
        lbl_cashout_cc7.setText(FitIn.fmt_woc(usd_b));
        lbl_cashout_cc6.setText(FitIn.fmt_woc(cc));
    }

    private void select_guest_advance_payment() {
        int row = tbl_guest_advance_payment.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guest_advance_payment to = (to_guest_advance_payment) tbl_guest_advance_payment_ALM.
                get(tbl_guest_advance_payment.convertRowIndexToModel(row));
        tf_expense_amount8.setText(FitIn.fmt_wc_0(to.amount_paid));
        tf_expense_amount9.setText(FitIn.fmt_wc_0(to.usd));
        tf_expense_amount5.setText(FitIn.fmt_wc_0(to.peso_on_bank));
        tf_expense_amount6.setText(FitIn.fmt_wc_0(to.usd_on_bank));
        tf_expense_amount10.setText(FitIn.fmt_wc_0(to.credit_amount));

    }

    private void edit_guest_advance_payment() {
        int row = tbl_guest_advance_payment.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guest_advance_payment to = (to_guest_advance_payment) tbl_guest_advance_payment_ALM.
                get(tbl_guest_advance_payment.convertRowIndexToModel(row));
        int id = to.id;
        String room_id = to.room_id;
        String guest_name = to.guest_name;
        String guest_id = to.guest_id;
        String date_added = to.date_added;
        double amount_paid = FitIn.toDouble(tf_expense_amount8.getText());
        int status = to.status;
        String user_name = to.user_name;
        double usd = FitIn.toDouble(tf_expense_amount9.getText());
        int room_guest_id = to.room_guest_id;
        double peso_on_bank = FitIn.toDouble(tf_expense_amount5.getText());
        double usd_on_bank = FitIn.toDouble(tf_expense_amount6.getText());
        int is_peso_on_bank = to.is_peso_on_bank;
        int is_usd_on_bank = to.is_usd_on_bank;
        String bank_no = to.bank_no;
        String bank = to.bank;
        String card_type = to.card_type;
        String card_holder = to.card_holder;
        String card_no = to.card_no;
        String approval_code = to.approval_code;
        double credit_amount = FitIn.toDouble(tf_expense_amount10.getText());
        double credit_addtl = to.credit_addtl;
        double credit_rate = to.credit_rate;
        to_guest_advance_payment to1 = new to_guest_advance_payment(id, room_id, guest_name, guest_id, date_added, amount_paid, status, user_name, usd, room_guest_id, peso_on_bank, usd_on_bank, is_peso_on_bank, is_usd_on_bank, bank_no, bank, card_type, card_holder, card_no, approval_code, credit_amount, credit_addtl, credit_rate);
        S2_guest_advance_payments.edit_guest_advance_payment(to1);
        data_cols_ap();
        tf_expense_amount8.setText("");
        tf_expense_amount5.setText("");
        tf_expense_amount9.setText("");
        tf_expense_amount6.setText("");
        tf_expense_amount10.setText("");
        
//      clear_guest_advance_payment();
    }

    private void delete_guest_advance_payment() {
        int row = tbl_guest_advance_payment.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guest_advance_payment to = (to_guest_advance_payment) tbl_guest_advance_payment_ALM.
                get(tbl_guest_advance_payment.convertRowIndexToModel(row));
        S2_guest_advance_payments.delete_guest_advance_payment(to);
        data_cols_ap();
        tf_expense_amount8.setText("");
        tf_expense_amount5.setText("");
        tf_expense_amount9.setText("");
        tf_expense_amount6.setText("");
        tf_expense_amount10.setText("");
//      clear_guest_advance_payment();
    }
}
