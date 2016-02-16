/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.advance_payment;

import POS.Main;
import POS.advance_payment.S1_guest_advance_payment.to_guest_advance_payment;
import POS.bank.Dlg_bank;
import POS.card_types.Dlg_card_types;
import POS.card_types.S1_card_types;
import POS.svc4.S1_bank;
import POS.utl.DateType;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
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
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author i1
 */
public class Dlg_advance_payment extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_advance_payment
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
    private Dlg_advance_payment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_advance_payment(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_advance_payment() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_advance_payment myRef;

    private void setThisRef(Dlg_advance_payment myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_advance_payment> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_advance_payment create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_advance_payment create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_advance_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_advance_payment((java.awt.Frame) parent, false);
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
            Dlg_advance_payment dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_advance_payment((java.awt.Dialog) parent, false);
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


        Dlg_advance_payment dialog = Dlg_advance_payment.create(new javax.swing.JFrame(), true);
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_php_cash = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_usd_cash = new javax.swing.JLabel();
        lbl_php_bank = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_used_bank = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_room_no = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_guest_id = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_credit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_to_pay = new javax.swing.JLabel();
        lbl_change = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tf_card_holder = new javax.swing.JTextField();
        tf_credit_card_no = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cb_bank1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        tf_app_code = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lbl_credit_rate = new javax.swing.JTextField();
        lb_less3 = new javax.swing.JLabel();
        lbl_net_credit = new javax.swing.JTextField();
        lb_less5 = new javax.swing.JLabel();
        cb_credit = new javax.swing.JCheckBox();
        tf_credit_amount = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_php = new javax.swing.JTextField();
        tf_usd = new javax.swing.JTextField();
        cb_php = new javax.swing.JCheckBox();
        cb_usd = new javax.swing.JCheckBox();
        tf_bank_no = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cb_bank = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_guest_advance_payment = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADVANCE PAYMENT");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_php_cash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_php_cash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_php_cash.setText("0.00");
        lbl_php_cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_php_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PAID");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 310, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Php:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 50, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("CREDIT CARD:");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, 30));

        lbl_usd_cash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_usd_cash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usd_cash.setText("0.00");
        lbl_usd_cash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_usd_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, 30));

        lbl_php_bank.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_php_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_php_bank.setText("0.00");
        lbl_php_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_php_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 210, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CASH");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 50, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("BANK");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 50, 30));

        lbl_used_bank.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_used_bank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_used_bank.setText("0.00");
        lbl_used_bank.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_used_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 210, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CASH");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 50, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("BANK");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 50, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("NAME:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 25));

        lbl_room_no.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_room_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_room_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_room_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 240, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("GUEST ID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 25));

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ROOM:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 25));

        lbl_guest_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_guest_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_guest_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_guest_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 240, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("USD:");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, 60));

        lbl_credit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit.setText("0.00");
        lbl_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lbl_credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 200, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INPUT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TO PAY:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CHANGE:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 80, 30));

        lbl_to_pay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_to_pay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_to_pay.setText("0.00");
        lbl_to_pay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbl_to_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 140, 30));

        lbl_change.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_change.setText("0.00");
        lbl_change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbl_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 80, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 80, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credit Card", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("CARD HOLDER:");

        tf_card_holder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_card_holder.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tf_credit_card_no.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_credit_card_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("CARD #:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("CARD TYPE:");

        cb_bank1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_bank1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VISA", "MASTER CARD", "AMEX" }));
        cb_bank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_bank1ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tf_app_code.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_app_code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_app_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_app_codeActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("APPRV. CODE:");

        lbl_credit_rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_credit_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_credit_rate.setText("4");
        lbl_credit_rate.setEnabled(false);

        lb_less3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_less3.setForeground(new java.awt.Color(41, 9, 149));
        lb_less3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_less3.setText("%");

        lbl_net_credit.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lbl_net_credit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lbl_net_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        lbl_net_credit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_net_creditMouseClicked(evt);
            }
        });
        lbl_net_credit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_net_creditKeyReleased(evt);
            }
        });

        lb_less5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_less5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_less5.setText("+");

        cb_credit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_credit.setText("ENTER AMOUNT:");
        cb_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_creditActionPerformed(evt);
            }
        });

        tf_credit_amount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_credit_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_credit_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_credit_amountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_less5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_net_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_credit_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_less3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_credit_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(276, 276, 276)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_bank1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_app_code, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cb_credit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_credit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_credit)
                    .addComponent(tf_credit_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_card_holder, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_credit_card_no, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_bank1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_app_code, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_credit_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_less3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_net_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_less5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 260));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Php/Dollar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Php:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("USD:");

        tf_php.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_php.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_php.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_phpActionPerformed(evt);
            }
        });

        tf_usd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_usd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_usd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usdActionPerformed(evt);
            }
        });

        cb_php.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_php.setSelected(true);
        cb_php.setText("CASH");

        cb_usd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_usd.setSelected(true);
        cb_usd.setText("CASH");

        tf_bank_no.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf_bank_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_bank_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bank_noActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("BANK #:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("BANK:");

        cb_bank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_bank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tf_php, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cb_php))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tf_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cb_usd))
                    .addComponent(jLabel14)
                    .addComponent(tf_bank_no, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cb_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_php, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_php, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_usd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tf_bank_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 350, 240));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("DELETE");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 80, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("EDIT");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 90, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Php/Dollar/CREDIT CARD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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
        jScrollPane1.setViewportView(tbl_guest_advance_payment);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_phpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_phpActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_tf_phpActionPerformed

    private void tf_usdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usdActionPerformed

    private void tf_bank_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bank_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bank_noActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bank();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cb_bank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_bank1ActionPerformed
        get_rate();
        set_new_credit();
//        type_peso();
    }//GEN-LAST:event_cb_bank1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        set_card();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_app_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_app_codeActionPerformed
        ok1();
    }//GEN-LAST:event_tf_app_codeActionPerformed

    private void lbl_net_creditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_net_creditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_net_creditMouseClicked

    private void lbl_net_creditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_net_creditKeyReleased
//        type_peso();
    }//GEN-LAST:event_lbl_net_creditKeyReleased

    private void cb_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_creditActionPerformed
        credit();
    }//GEN-LAST:event_cb_creditActionPerformed

    private void tf_credit_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_credit_amountKeyReleased
        set_new_credit();
    }//GEN-LAST:event_tf_credit_amountKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        delete_payment();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        edit_guest_advance_payment();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbl_guest_advance_paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guest_advance_paymentMouseClicked
        select_guest_advance_payment();
    }//GEN-LAST:event_tbl_guest_advance_paymentMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_bank;
    private javax.swing.JComboBox cb_bank1;
    private javax.swing.JCheckBox cb_credit;
    private javax.swing.JCheckBox cb_php;
    private javax.swing.JCheckBox cb_usd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_less3;
    private javax.swing.JLabel lb_less5;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_credit;
    private javax.swing.JTextField lbl_credit_rate;
    private javax.swing.JLabel lbl_guest_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTextField lbl_net_credit;
    private javax.swing.JLabel lbl_php_bank;
    private javax.swing.JLabel lbl_php_cash;
    private javax.swing.JLabel lbl_room_no;
    private javax.swing.JLabel lbl_to_pay;
    private javax.swing.JLabel lbl_usd_cash;
    private javax.swing.JLabel lbl_used_bank;
    private javax.swing.JTable tbl_guest_advance_payment;
    private javax.swing.JTextField tf_app_code;
    private javax.swing.JTextField tf_bank_no;
    private javax.swing.JTextField tf_card_holder;
    private javax.swing.JTextField tf_credit_amount;
    private javax.swing.JTextField tf_credit_card_no;
    private javax.swing.JTextField tf_php;
    private javax.swing.JTextField tf_usd;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        Main.MyDB.setNames("db_pos_restaurant");
        init_tbl_guest_advance_payment();
        jLabel8.setVisible(false);
        lbl_change.setVisible(false);
        tf_credit_amount.setEnabled(false);
        tf_card_holder.setEnabled(false);
        tf_credit_card_no.setEnabled(false);
        cb_bank1.setEnabled(false);
        tf_app_code.setEnabled(false);
        jButton3.setEnabled(false);
        set_bank();
        init_cb_card_types();
    }

    private void set_bank() {
        cb_bank.setModel(new ListComboBoxModel(S1_bank.get_banks()));
    }
    String room_id = "";
    String guest_id = "";
    int room_guest_id = 0;

    public void do_pass(String room_no, String guest_ids, String guest, double paid, double to_pay, String room_ids, int room_guest_ids, double paid_usd) {
        room_id = room_ids;
        guest_id = guest_ids;
        room_guest_id = room_guest_ids;
        lbl_guest_id.setText(guest_id);
        lbl_name.setText(guest);
        lbl_php_cash.setText(FitIn.fmt_wc_0(paid));
        lbl_usd_cash.setText(FitIn.fmt_wc_0(paid_usd));
        lbl_room_no.setText(room_no);
        lbl_to_pay.setText(FitIn.fmt_wc_0(to_pay));
        data_cols();
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

    private void do_7() {
        put_text("7");
    }

    private void do_8() {
        put_text("8");
    }

    private void do_9() {
        put_text("9");
    }

    private void do_4() {
        put_text("4");
    }

    private void do_5() {
        put_text("5");
    }

    private void do_6() {
        put_text("6");
    }

    private void do_1() {
        put_text("1");
    }

    private void do_2() {
        put_text("2");
    }

    private void do_3() {
        put_text("3");
    }

    private void do_0() {
        put_text("0");
    }

    private void do_dot() {
        put_text(".");
    }

    private void put_text(String str) {

        if (tf_php.hasFocus()) {
            tf_php.setText(tf_php.getText() + str);
        }
        if (tf_usd.hasFocus()) {
            tf_usd.setText(tf_usd.getText() + str);
        }
//        if(tf_cc.hasFocus()){
//             tf_cc.setText(tf_cc.getText() + str);
//        }
    }

    private void clear() {
        tf_php.setText("");
    }

    private void add() {

        double paid = FitIn.toDouble(lbl_php_cash.getText());
        double paid2 = FitIn.toDouble(lbl_usd_cash.getText());
        double amount = FitIn.toDouble(tf_php.getText());
        double usd = FitIn.toDouble(tf_usd.getText());

        double total = paid + amount;
        double tota2 = paid2 + usd;
        String guest_name = lbl_name.getText();
        String date_added = DateType.datetime.format(new Date());
        int status = 0;
        double peso_on_bank = 0;
        double usd_on_bank = 0;
        int is_peso_on_bank = 0;
        int is_usd_on_bank = 0;
        String bank_no = "";
        String bank = "";
        if (!cb_php.isSelected()) {
            amount = 0;
            is_peso_on_bank = 1;
            peso_on_bank = FitIn.toDouble(tf_php.getText());
            bank_no = tf_bank_no.getText();
            bank = cb_bank.getSelectedItem().
                    toString();
        }
        if (!cb_usd.isSelected()) {
            usd = 0;
            is_usd_on_bank = 1;
            usd_on_bank = FitIn.toDouble(tf_usd.getText());
            bank_no = tf_bank_no.getText();
            bank = cb_bank.getSelectedItem().
                    toString();
        }

        String card_type = cb_bank1.getSelectedItem().
                toString();
        String card_holder = tf_card_holder.getText();
        String card_no = tf_credit_card_no.getText();
        String approval_code = tf_app_code.getText();
        double credit_amount = FitIn.toDouble(tf_credit_amount.getText());
        double credit_addtl = FitIn.toDouble(lbl_net_credit.getText());
        double credit_rate = FitIn.toDouble(lbl_credit_rate.getText());
        if (!cb_credit.isSelected()) {
            card_type = "";
            card_holder = "";
            card_no = "";
            approval_code = "";
            credit_amount = 0;
            credit_addtl = 0;
            credit_rate = 0;
        }
        S1_cash_advance.to_guest_advance_payment to = new S1_cash_advance.to_guest_advance_payment(0, room_id, guest_name, guest_id, date_added, amount, status);
        S1_cash_advance.add_data(to, usd, room_guest_id, peso_on_bank, usd_on_bank, is_peso_on_bank, is_usd_on_bank, bank_no, bank, card_type, card_holder, card_no, approval_code, credit_amount, credit_addtl, credit_rate);
//        JOptionPane.showMessageDialog(null, usd);
        lbl_to_pay.setText(FitIn.fmt_wc_0((FitIn.toDouble(lbl_to_pay.getText()) - amount)));
        lbl_php_cash.setText(FitIn.fmt_wc_0(total));
        lbl_usd_cash.setText(FitIn.fmt_wc_0(tota2));

//        lbl_change.setText("" + change);
        tf_php.setText("");
        tf_usd.setText("");

        tf_card_holder.setText("");
        tf_app_code.setText("");
        tf_credit_amount.setText("");
        lbl_net_credit.setText("");
        lbl_credit_rate.setText("");
        cb_credit.setSelected(false);
        Prompt.call("Successfully Added");
//        JOptionPane.showMessageDialog(null, "Successfully Added");
        data_cols();
        ok1();
    }

    private void edit() {
    }

    private void delete() {
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void bank() {

        Window p = (Window) this;
        Dlg_bank nd = Dlg_bank.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_bank.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_bank.OutputData data) {
//                closeDialog.ok();
                set_bank();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
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
//        tbl_guest_advance_payment.setAutoResizeMode(0);
        int[] tbl_widths_guest_advance_payment = {0, 0, 0, 0, 160, 80, 0, 0, 80, 0, 80, 80, 0, 0, 130, 150, 0, 150, 0, 200, 120, 0, 0};
        for (int i = 0, n = tbl_widths_guest_advance_payment.length; i < n; i++) {
//            if (i == 100) {
//                continue;
//            }
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
            "id", "room_id", "guest_name", "guest_id", "DATE ADDED", "Php-Cash", "status", "user_name", "USD-Cash", "room_guest_id", "Php-Bank", "USD-Bank", "is_peso_on_bank", "is_usd_on_bank", "BANK NO", "BANK", "card_type", "CARD HOLDER", "card_no", "APPROVAL CODE", "CREDIT AMOUNT", "credit_addtl", "credit_rate"
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
                    return tt.guest_name;
                case 3:
                    return tt.guest_id;
                case 4:
                    return DateType.convert_jan_1_2013_datetime(tt.date_added);
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

    private void data_cols() {
//        String where="";
        loadData_guest_advance_payment(S1_guest_advance_payment.ret_data(room_id, guest_id));

        List<to_guest_advance_payment> acc = tbl_guest_advance_payment_ALM;
        double cash_php = 0;
        double cash_usd = 0;
        double bank_php = 0;
        double bank_usd = 0;
        double credit = 0;

        for (to_guest_advance_payment to : acc) {
            cash_php += to.amount_paid;
            cash_usd += to.usd;
            bank_php += to.peso_on_bank;
            bank_usd += to.usd_on_bank;
            credit += to.credit_amount;
        }
        
        lbl_php_cash.setText(FitIn.fmt_wc_0(cash_php));
        lbl_usd_cash.setText(FitIn.fmt_wc_0(cash_usd));
        lbl_php_bank.setText(FitIn.fmt_wc_0(bank_php));
        lbl_used_bank.setText(FitIn.fmt_wc_0(bank_usd));
        double all_php = cash_php + bank_php;
        double all_usd = cash_usd + bank_usd;
        double to_pay = FitIn.toDouble(lbl_to_pay.getText());
        double total = to_pay - (all_php + all_usd);
        lbl_to_pay.setText(FitIn.fmt_wc_0(total));
        lbl_credit.setText(FitIn.fmt_wc_0(credit));
    }

    private void get_rate() {
        if (cb_bank1.getItemCount() == 0) {
            return;
        }
        double rate = S1_card_types.ret_rate(cb_bank1.getSelectedItem().
                toString());
        lbl_credit_rate.setText("" + rate);
    }

    private void set_new_credit() {


        double late_credit = FitIn.toDouble(tf_credit_amount.getText());
        double net_rate = FitIn.toDouble(lbl_credit_rate.getText());
        net_rate = net_rate / 100;
        net_rate = net_rate * late_credit;
//        lbl_credit.setText(FitIn.fmt_wc_0(total));
        lbl_net_credit.setText(FitIn.fmt_wc_0(net_rate));

    }

    private void set_card() {
        Window p = (Window) this;
        Dlg_card_types nd = Dlg_card_types.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_card_types.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_card_types.OutputData data) {
//                closeDialog.ok();
                init_cb_card_types();
//                type_peso();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void init_cb_card_types() {
        cb_bank1.setModel(new ListComboBoxModel(S1_card_types.ret_cb_data()));
        get_rate();
    }

    private void credit() {
        if (cb_credit.isSelected()) {
            tf_credit_amount.setEnabled(true);
            tf_card_holder.setEnabled(true);
            tf_credit_card_no.setEnabled(true);
            cb_bank1.setEnabled(true);
            tf_app_code.setEnabled(true);
            jButton3.setEnabled(true);
            tf_credit_amount.grabFocus();
        } else {
            tf_credit_amount.setEnabled(false);
            tf_card_holder.setEnabled(false);
            tf_credit_card_no.setEnabled(false);
            cb_bank1.setEnabled(false);
            tf_app_code.setEnabled(false);
            jButton3.setEnabled(false);
        }
    }

    private void select_guest_advance_payment() {
        int row = tbl_guest_advance_payment.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guest_advance_payment to = (to_guest_advance_payment) tbl_guest_advance_payment_ALM.
                get(tbl_guest_advance_payment.convertRowIndexToModel(row));
//        tf_room_id.setText(to.room_id);
//        tf_guest_name.setText(to.guest_name);
//        tf_guest_id.setText(to.guest_id);
//        tf_date_added.setText(to.date_added);
        if (to.amount_paid != 0) {
            tf_php.setText(FitIn.fmt_wc_0(to.amount_paid));
            cb_php.setSelected(true);
        }
        if (to.peso_on_bank != 0) {
            tf_php.setText(FitIn.fmt_wc_0(to.peso_on_bank));
            cb_php.setSelected(false);
            tf_bank_no.setText(to.bank_no);
            cb_bank.setSelectedItem(to.bank);
        }

        if (to.usd != 0) {
            tf_usd.setText(FitIn.fmt_wc_0(to.usd));
            cb_usd.setSelected(true);
        }
        if (to.usd_on_bank != 0) {
            tf_usd.setText(FitIn.fmt_wc_0(to.usd_on_bank));
            cb_usd.setSelected(false);
            tf_bank_no.setText(to.bank_no);
            cb_bank.setSelectedItem(to.bank);
        }
        tf_bank_no.setText(to.bank_no);
        cb_bank.setSelectedItem(to.bank);
        if (to.credit_amount != 0) {
            cb_credit.setSelected(true);
            tf_credit_amount.setEnabled(true);
            tf_card_holder.setEnabled(true);
            tf_credit_card_no.setEnabled(true);
            cb_bank1.setEnabled(true);
            tf_app_code.setEnabled(true);
            jButton3.setEnabled(true);
        } else {
            cb_credit.setSelected(false);
            tf_credit_amount.setEnabled(false);
            tf_card_holder.setEnabled(false);
            tf_credit_card_no.setEnabled(false);
            cb_bank1.setEnabled(false);
            tf_app_code.setEnabled(false);
            jButton3.setEnabled(false);
        }
        cb_bank1.setSelectedItem(to.card_type);
        tf_card_holder.setText(to.card_holder);
        tf_credit_card_no.setText(to.card_no);
        tf_app_code.setText(to.approval_code);
        tf_credit_amount.setText(FitIn.fmt_wc_0(to.credit_amount));
        lbl_net_credit.setText(FitIn.fmt_wc_0(to.credit_addtl));
        lbl_credit_rate.setText(FitIn.fmt_wc_0(to.credit_rate));
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

        int status = to.status;
        String user_name = to.user_name;

        int room_guest_id1 = to.room_guest_id;

        double amount_paid = 0;
        double usds = 0;
        double peso_on_bank = 0;
        double usd_on_bank = 0;
        int is_peso_on_bank = 0;
        int is_usd_on_bank = 0;
        String bank_no = "";
        String bank = "";
        toString();
        if (cb_php.isSelected()) {
            amount_paid = FitIn.toDouble(tf_php.getText());
            is_peso_on_bank = 0;
        } else {
            peso_on_bank = FitIn.toDouble(tf_php.getText());
            is_peso_on_bank = 1;
            bank_no = tf_bank_no.getText();
            bank = cb_bank.getSelectedItem().
                    toString();
        }
        if (cb_usd.isSelected()) {
            usds = FitIn.toDouble(tf_usd.getText());
            is_usd_on_bank = 0;


        } else {
            usd_on_bank = FitIn.toDouble(tf_usd.getText());
            is_usd_on_bank = 1;
            bank_no = tf_bank_no.getText();
            bank = cb_bank.getSelectedItem().
                    toString();
        }





        String card_type = cb_bank1.getSelectedItem().
                toString();
        String card_holder = tf_card_holder.getText();
        String card_no = tf_credit_card_no.getText();
        String approval_code = tf_app_code.getText();
        double credit_amount = FitIn.toDouble(tf_credit_amount.getText());
        double credit_addtl = FitIn.toDouble(lbl_net_credit.getText());
        double credit_rate = FitIn.toDouble(lbl_credit_rate.getText());
        if (!cb_credit.isSelected()) {
            card_type = "";
            card_holder = "";
            card_no = "";
            approval_code = "";
            credit_amount = 0;
            credit_addtl = 0;
            credit_rate = 0;
        }

        to_guest_advance_payment to1 = new to_guest_advance_payment(id, room_id, guest_name, guest_id, date_added, amount_paid, status, user_name, usds, to.room_guest_id, peso_on_bank, usd_on_bank, bank_no, bank, is_peso_on_bank, is_usd_on_bank, card_type, card_holder, card_no, approval_code, credit_amount, credit_addtl, credit_rate);
        S1_guest_advance_payment.edit_guest_advance_payment(to1);
        tf_php.setText("");
        tf_usd.setText("");

        tf_card_holder.setText("");
        tf_app_code.setText("");
        tf_credit_amount.setText("");
        lbl_net_credit.setText("");
        lbl_credit_rate.setText("");
        cb_usd.setSelected(true);
        cb_php.setSelected(true);
        data_cols();

//        clear_guest_advance_payment();
    }

    private void delete_payment() {
        int row = tbl_guest_advance_payment.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guest_advance_payment to = (to_guest_advance_payment) tbl_guest_advance_payment_ALM.
                get(tbl_guest_advance_payment.convertRowIndexToModel(row));
         S1_guest_advance_payment.delete_guest_advance_payment(to);
          data_cols();
        tf_php.setText("");
        tf_usd.setText("");

        tf_card_holder.setText("");
        tf_app_code.setText("");
        tf_credit_amount.setText("");
        lbl_net_credit.setText("");
        lbl_credit_rate.setText("");
        cb_usd.setSelected(true);
        cb_php.setSelected(true);
    }
}
