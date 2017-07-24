/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_card;

import POS.bank.Dlg_bank;
import POS.bank.S1_bank;
import POS.credit_card.S1_credit_card_ins.to_credit_card_ins;

import POS.utl.DateType;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author Maytopacka
 */
public class Dlg_credit_card_ins extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_credit_card_ins
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
    private Dlg_credit_card_ins(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_credit_card_ins(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_credit_card_ins() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_credit_card_ins myRef;

    private void setThisRef(Dlg_credit_card_ins myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_credit_card_ins> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_credit_card_ins create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_credit_card_ins create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_credit_card_ins dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_credit_card_ins((java.awt.Frame) parent, false);
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
            Dlg_credit_card_ins dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_credit_card_ins((java.awt.Dialog) parent, false);
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


        Dlg_credit_card_ins dialog = Dlg_credit_card_ins.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_credits = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dp_pay_from = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dp_pay_to = new com.toedter.calendar.JDateChooser();
        lbl_totals = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_credit_card_ins = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dp_ref_from = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dp_ref_to = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_bank = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lbl_total2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_payments = new javax.swing.JLabel();
        lbl_reflenishment = new javax.swing.JLabel();
        lbl_balance = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_credits.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_credits);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREDIT CARD PAYMENTS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DATE FROM:");

        dp_pay_from.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DATE TO:");

        dp_pay_to.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lbl_totals.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_totals.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_totals.setText("0.00");
        lbl_totals.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dp_pay_from, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dp_pay_to, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_totals, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbl_totals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dp_pay_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dp_pay_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_credit_card_ins.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_credit_card_ins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_credit_card_insMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_credit_card_ins);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CREDIT CARD REFLENISHMENTS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DATE FROM:");

        dp_ref_from.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DATE TO:");

        dp_ref_to.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ENTER AMOUNT:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("BANK:");

        cb_bank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_bank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_bankActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("NEW");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("CLOSE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lbl_total2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_total2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total2.setText("0.00");
        lbl_total2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dp_ref_from, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(115, 115, 115)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dp_ref_to, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_total2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbl_total2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dp_ref_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dp_ref_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BALANCE");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PAYMENTS");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("REFLENISHMENTS");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_payments.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_payments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_payments.setText("0.00");
        lbl_payments.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_reflenishment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reflenishment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_reflenishment.setText("0.00");
        lbl_reflenishment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_balance.setText("0.00");
        lbl_balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("=");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_payments, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_reflenishment, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_balance, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_payments, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_reflenishment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_credit_card_ins();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit_credit_card_ins();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_credit_card_insMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_credit_card_insMouseClicked
        select_credit_card_ins();
    }//GEN-LAST:event_tbl_credit_card_insMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete_credit_card_ins();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_bankActionPerformed
        data_cols();
    }//GEN-LAST:event_cb_bankActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        bank();
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_bank;
    private com.toedter.calendar.JDateChooser dp_pay_from;
    private com.toedter.calendar.JDateChooser dp_pay_to;
    private com.toedter.calendar.JDateChooser dp_ref_from;
    private com.toedter.calendar.JDateChooser dp_ref_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_balance;
    private javax.swing.JLabel lbl_payments;
    private javax.swing.JLabel lbl_reflenishment;
    private javax.swing.JLabel lbl_total2;
    private javax.swing.JLabel lbl_totals;
    private javax.swing.JTable tbl_credit_card_ins;
    private javax.swing.JTable tbl_credits;
    private javax.swing.JTextField tf_amount;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        get_balance();
        dp_pay_from.setDate(new Date());
        dp_pay_to.setDate(new Date());
        dp_ref_from.setDate(new Date());
        dp_ref_to.setDate(new Date());
        set_bank();
        dp_ref_from.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_credit_payments();
            }
        });
        dp_ref_to.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_credit_payments();
            }
        });
        dp_pay_from.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_credit_payments();
            }
        });
        dp_pay_to.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                data_credit_payments();
            }
        });
        init_tbl_credit_card_ins();
        data_cols();
        init_tbl_credits();
        data_credit_payments();
    }

    private void set_bank() {
        cb_bank.setModel(new ListComboBoxModel(S1_bank.ret_cb_data()));
    }

    public void do_pass() {
        get_balance();
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

    private void get_balance() {
        S2_credit_card_balance.to_credit_card_balance to = S2_credit_card_balance.
                ret_data("");
        lbl_payments.setText(FitIn.fmt_wc_0(to.credit_card_payments));
        lbl_reflenishment.setText(FitIn.fmt_wc_0(to.actual_balance));
        lbl_balance.setText(FitIn.fmt_wc_0(to.credit_card_payments - to.actual_balance));
    }
    private ArrayListModel tbl_credit_card_ins_ALM;
    private Tblcredit_card_insModel tbl_credit_card_ins_M;

    private void init_tbl_credit_card_ins() {
        tbl_credit_card_ins_ALM = new ArrayListModel();
        tbl_credit_card_ins_M = new Tblcredit_card_insModel(tbl_credit_card_ins_ALM);
        tbl_credit_card_ins.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_credit_card_ins.setModel(tbl_credit_card_ins_M);
        tbl_credit_card_ins.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_credit_card_ins.setRowHeight(25);
        int[] tbl_widths_credit_card_ins = {0, 100, 100, 0, 0};
        for (int i = 0, n = tbl_widths_credit_card_ins.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_credit_card_ins, i, tbl_widths_credit_card_ins[i]);
        }
        Dimension d = tbl_credit_card_ins.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_credit_card_ins.getTableHeader().
                setPreferredSize(d);
        tbl_credit_card_ins.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_credit_card_ins.setRowHeight(35);
        tbl_credit_card_ins.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_credit_card_ins(List<to_credit_card_ins> acc) {
        tbl_credit_card_ins_ALM.clear();
        tbl_credit_card_ins_ALM.addAll(acc);
    }

    public static class Tblcredit_card_insModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "DATE ADDED", "AMOUNT", "user_name", "bank"
        };

        public Tblcredit_card_insModel(ListModel listmodel) {
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
            to_credit_card_ins tt = (to_credit_card_ins) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.date_added;
                case 2:
                    return FitIn.fmt_wc_0(tt.amount);
                case 3:
                    return tt.user_name;
                default:
                    return tt.bank;
            }
        }
    }

    private void data_cols() {

        String date_from = DateType.sf.format(dp_ref_from.getDate());
        String date_to = DateType.sf.format(dp_ref_to.getDate());
        String bank = cb_bank.getSelectedItem().
                toString();
        if (bank.equalsIgnoreCase("ALL")) {
            bank = "";
        }
        loadData_credit_card_ins(S1_credit_card_ins.ret_data(date_from, date_to, bank));
        List<to_credit_card_ins> datas = tbl_credit_card_ins_ALM;
        double total = 0;
        for (to_credit_card_ins to : datas) {

            total += to.amount;
        }
        lbl_total2.setText(FitIn.fmt_wc_0(total));
    }

    private void add_credit_card_ins() {
        double payments = FitIn.toDouble(lbl_payments.getText());
        double reflenishment = FitIn.toDouble(lbl_reflenishment.getText());
        double balance = FitIn.toDouble(lbl_balance.getText());

        int id = -1;
        String date_added = DateType.datetime.format(new Date());
        double amount = FitIn.toDouble(tf_amount.getText());
        String user_name = "ronald";
        String bank = cb_bank.getSelectedItem().
                toString();
        to_credit_card_ins to = new to_credit_card_ins(id, date_added, amount, user_name, bank);
        S1_credit_card_ins.add_credit_card_ins(to, payments, reflenishment, balance);
        data_cols();
        clear_credit_card_ins();
        get_balance();
    }

    private void select_credit_card_ins() {
        int row = tbl_credit_card_ins.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_credit_card_ins to = (to_credit_card_ins) tbl_credit_card_ins_ALM.get(tbl_credit_card_ins.convertRowIndexToModel(row));
////        tf_id.setText(FitIn.w_c_0(id));
////        tf_date_added.setText(date_added);
        tf_amount.setText(FitIn.fmt_wc_0(to.amount));
////        tf_user_name.setText(user_name);
//        cb_bank.setSelectedItem(to.bank);
    }

    private void edit_credit_card_ins() {
        int row = tbl_credit_card_ins.getSelectedRow();
        if (row < 0) {
            return;
        }
        double payments = FitIn.toDouble(lbl_payments.getText());
        double reflenishment = FitIn.toDouble(lbl_reflenishment.getText());
        double balance = FitIn.toDouble(lbl_balance.getText());

        to_credit_card_ins to = (to_credit_card_ins) tbl_credit_card_ins_ALM.get(tbl_credit_card_ins.
                convertRowIndexToModel(row));
        int id = to.id;
        String date_added = to.date_added;
        double amount = FitIn.toDouble(tf_amount.getText());
        String user_name = to.user_name;
        String bank = cb_bank.getSelectedItem().
                toString();
        to_credit_card_ins to1 = new to_credit_card_ins(id, date_added, amount, user_name, bank);
        S1_credit_card_ins.edit_credit_card_ins(to1, payments, reflenishment, balance, amount, to.amount);
        data_cols();
        clear_credit_card_ins();
        get_balance();
    }

    private void clear_credit_card_ins() {
//        tf_id.setText("");
//        tf_date_added.setText("");
        tf_amount.setText("");
//        tf_user_name.setText("");
//        tf_bank.setText("");
    }

    private void delete_credit_card_ins() {
        int row = tbl_credit_card_ins.getSelectedRow();
        if (row < 0) {
            return;
        }
        double payments = FitIn.toDouble(lbl_payments.getText());
        double reflenishment = FitIn.toDouble(lbl_reflenishment.getText());
        double balance = FitIn.toDouble(lbl_balance.getText());

        to_credit_card_ins to = (to_credit_card_ins) tbl_credit_card_ins_ALM.get(tbl_credit_card_ins.
                convertColumnIndexToModel(row));
        to_credit_card_ins to1 = new to_credit_card_ins(to.id, to.date_added, to.amount, to.user_name, to.bank);
        S1_credit_card_ins.delete_credit_card_ins("" + to1.id, to1.amount, payments, reflenishment, balance);
        data_cols();
        clear_credit_card_ins();
        get_balance();
    }

    private void bank() {
        Window p = (Window) this;
        Dlg_bank nd = Dlg_bank.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_bank.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_bank.OutputData data) {
//                closeDialog.ok();'
                set_bank();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
    private ArrayListModel tbl_credits_ALM;
    private TblcreditsModel tbl_credits_M;

    private void init_tbl_credits() {
        tbl_credits_ALM = new ArrayListModel();
        tbl_credits_M = new TblcreditsModel(tbl_credits_ALM);
        tbl_credits.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_credits.setModel(tbl_credits_M);
        tbl_credits.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_credits.setRowHeight(25);
        int[] tbl_widths_credits = {0, 0, 100, 0, 0, 0, 0, 100, 100, 0, 100, 0, 0, 0};
        for (int i = 0, n = tbl_widths_credits.length; i < n; i++) {
            if (i == 10) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_credits, i, tbl_widths_credits[i]);
        }
        Dimension d = tbl_credits.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_credits.getTableHeader().
                setPreferredSize(d);
        tbl_credits.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_credits.setRowHeight(35);
        tbl_credits.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_credits(List<S3_credit_card_payments.to_credits> acc) {
        tbl_credits_ALM.clear();
        tbl_credits_ALM.addAll(acc);
    }

    public static class TblcreditsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "or_no", "CARD TYPE", "card_type", "card_holder", "card_no", "approval_code", "AMOUNT", "ADDED BY", "user_id", "DATE ADDED", "dollar_amount", "dollar_rate", "session_id"
        };

        public TblcreditsModel(ListModel listmodel) {
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
            S3_credit_card_payments.to_credits tt = (S3_credit_card_payments.to_credits) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.or_no;
                case 2:
                    return tt.bank_name;
                case 3:
                    return tt.card_type;
                case 4:
                    return tt.card_holder;
                case 5:
                    return tt.card_no;
                case 6:
                    return tt.approval_code;
                case 7:
                    return FitIn.fmt_wc_0(tt.amount);
                case 8:
                    return tt.user_name;
                case 9:
                    return tt.user_id;
                case 10:
                    return tt.date_payed;
                case 11:
                    return tt.dollar_amount;
                case 12:
                    return tt.dollar_rate;
                default:
                    return tt.session_id;
            }
        }
    }

    private void data_credit_payments() {
        String date_from = DateType.sf.format(dp_pay_from.getDate());
        String date_to = DateType.sf.format(dp_pay_to.getDate());
        loadData_credits(S3_credit_card_payments.ret_data(date_from, date_to));
        List<S3_credit_card_payments.to_credits> datas = tbl_credits_ALM;
        double total = 0;
        for (S3_credit_card_payments.to_credits to : datas) {

            total += to.amount;
        }
        lbl_totals.setText(FitIn.fmt_wc_0(total));
    }
}
