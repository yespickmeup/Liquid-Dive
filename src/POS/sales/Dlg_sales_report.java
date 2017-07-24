/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.currency.S1_currency;
import POS.inventory.S6_items;
import POS.my_reports.Srpt_disbursements;
import POS.my_reports.Srpt_sales_category;
import POS.printing2.S1_get_sales_for_the_day;
import POS.redo_receipts.S1_users;
import POS.rpt2.to_date_from;
import POS.rpt2.to_date_to;
import POS.rpt_liquid.Srpt_liquid;
import POS.sales_report.Srpt_sales_by_item;
import POS.to.to_users;

import POS.utl.DateType;
import POS.utl.Focus_Fire1;
import POS.utl.MyConnection1;
import POS.utl.TableRenderer;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;

import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import rpt_liquid.Srpt_cashier_report;

/**
 *
 * @author i1
 */
public class Dlg_sales_report extends javax.swing.JDialog {

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
    private Dlg_sales_report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_sales_report(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_sales_report() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_sales_report myRef;

    private void setThisRef(Dlg_sales_report myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_sales_report> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_sales_report create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_sales_report create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_sales_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales_report((java.awt.Frame) parent, false);
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
            Dlg_sales_report dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales_report((java.awt.Dialog) parent, false);
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

        Dlg_sales_report dialog = Dlg_sales_report.
                create(new javax.swing.JFrame(), true);
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

        pm_cashiers = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_cash_in = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_dollar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_peso = new javax.swing.JLabel();
        lbl_discounts = new javax.swing.JLabel();
        lbl_credit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lbl_expenses = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_cashout = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_cashier = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_addtl_cashins = new javax.swing.JLabel();
        pnl_rpt = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        l_report_type = new javax.swing.JList();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_cash_in.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cash_in.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cash_in.setText("0.00");
        lbl_cash_in.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cash_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 110, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 940, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CASH IN");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 110, -1));

        lbl_dollar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_dollar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dollar.setText("0.00");
        lbl_dollar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_dollar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DOLLAR");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 120, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CREDIT");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 120, -1));

        lbl_peso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_peso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_peso.setText("0.00");
        lbl_peso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, 30));

        lbl_discounts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_discounts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_discounts.setText("0.00");
        lbl_discounts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_discounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 120, 30));

        lbl_credit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit.setText("0.00");
        lbl_credit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, 120, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("DISCOUNTS");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 120, -1));

        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1251, 10, 50, 70));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("EXPENSES");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 130, -1));

        lbl_expenses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_expenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_expenses.setText("0.00");
        lbl_expenses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_expenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 130, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CASH OUT");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, -1));

        lbl_cashout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_cashout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cashout.setText("0.00");
        lbl_cashout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_cashout, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 110, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PESO");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 120, -1));
        jPanel1.add(dp_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, -1));
        jPanel1.add(dp_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 112, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DATE TO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DATE FROM:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        cb_cashier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashierActionPerformed(evt);
            }
        });
        jPanel1.add(cb_cashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 200, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("CASHIER:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADDTL CASH");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 100, -1));

        lbl_addtl_cashins.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_addtl_cashins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_addtl_cashins.setText("0.00");
        lbl_addtl_cashins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_addtl_cashins, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 100, 30));

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

        l_report_type.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l_report_type.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "DAILY SALES SUMMARY", "CASHIER SALES", "CASH SALES", "CASH COUNT", "CREDIT SALES", "SALES BY CATEGORY", "STOCKS LEFT", "STOCKS OUT", "STOCKS IN", "SALES BY ITEM", "DISBURSEMENTS" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        l_report_type.setFixedCellHeight(25);
        l_report_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_report_typeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(l_report_type);

        jProgressBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("REPORT TYPE");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CASH FLOAT/SALES/SUMMARY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Search Item:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_search)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_rpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void l_report_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_report_typeMouseClicked
        select_report();
    }//GEN-LAST:event_l_report_typeMouseClicked

    private void cb_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashierActionPerformed
//        data_cols_date();
//        set_report();
        select_report();
//        set_sales;();
//        rep = 1;
//        set_report();
    }//GEN-LAST:event_cb_cashierActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cash_float();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        init_items();
    }//GEN-LAST:event_tf_searchActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cashier;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList l_report_type;
    private javax.swing.JLabel lbl_addtl_cashins;
    private javax.swing.JLabel lbl_cash_in;
    private javax.swing.JLabel lbl_cashout;
    private javax.swing.JLabel lbl_credit;
    private javax.swing.JLabel lbl_discounts;
    private javax.swing.JLabel lbl_dollar;
    private javax.swing.JLabel lbl_expenses;
    private javax.swing.JLabel lbl_peso;
    private javax.swing.JPopupMenu pm_cashiers;
    private javax.swing.JPanel pnl_rpt;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        dp_from.setDate(new Date());
        dp_to.setDate(new Date());
        jPanel4.setVisible(false);
//        Main.MyDB.setNames("db_pos_restaurant");
        set_cashiers();

        b_name = System.getProperty("business_name", "Synapse");
        init_key();

        dp_from.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                select_report();
            }
        });
        dp_to.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                select_report();
            }
        });

        focus();
    }

    private void focus() {
        JTextField[] tf = {tf_search};
        Focus_Fire1.onFocus_lostFocus(tf);
    }

    private void data_cols_date() {

        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        String users = cb_cashier.getSelectedItem().
                toString();

        if (users.equals("ALL")) {
            users = "";
        } else {
            users = to_users.ret_user(users);
        }

        List<S1_my_sales.to_receipts> datas1 = S1_my_sales.
                ret_data(session, date_from, date_to, users);
        S1_my_sales.to_details t = S1_my_sales.ret_cash_in(users, date_from, date_to);
        lbl_cash_in.setText(FitIn.fmt_wc_0(t.cashin));
        lbl_expenses.setText(FitIn.fmt_wc_0(t.expenses));
        lbl_cashout.setText(FitIn.fmt_wc_0(t.cashout));
        lbl_addtl_cashins.setText(FitIn.fmt_wc_0(t.addtl_cashins));
        double peso = 0;
        double dollar = 0;
        double credit = 0;
        double discount = 0;
        double cash_in = 0;

        List<S1_my_sales.to_receipts> datas = datas1;

        for (S1_my_sales.to_receipts to : datas) {
            peso += to.peso;
            credit += to.credit;
            discount += to.discount;
            dollar += to.dollar;
        }

        lbl_peso.setText(FitIn.fmt_wc_0(peso));
        lbl_dollar.setText(FitIn.fmt_wc_0(dollar));
        lbl_discounts.setText(FitIn.fmt_wc_0(discount));
        lbl_credit.setText(FitIn.fmt_wc_0(credit));
    }

    private void set_cashiers() {
        cb_cashier.setModel(new ListComboBoxModel(S1_my_sales.ret_cb_data2()));
    }
    String session = "";
    String b_name = "";

    private void set_totals() {
        String date_from = DateType.sf.format(dp_from.getDate());
        String date_to = DateType.sf.format(dp_to.getDate());
        S1_sales_report.to_my_sales to = S1_sales_report.
                ret_sales(date_from, date_to);
//        System.out.println(to.peso);
        lbl_peso.setText(FitIn.fmt_wc_0(to.peso));
        lbl_dollar.setText(FitIn.fmt_wc_0(to.dollar));
        lbl_credit.setText(FitIn.fmt_wc_0(to.credit));
        lbl_discounts.setText(FitIn.fmt_wc_0(to.discounts));
        lbl_expenses.setText(FitIn.fmt_wc_0(to.expenses));
        lbl_cash_in.setText(FitIn.fmt_wc_0(to.cash_in));
        lbl_cashout.setText(FitIn.fmt_wc_0(to.cash_out));

    }

    public void do_pass(String cashier_session_id) {
        session = cashier_session_id;
//        double cash_in = S1_my_sales.ret_cash_in(cashier_session_id);
//        double expenses = S1_my_sales.ret_expenses(cashier_session_id);
//        lbl_cash_in.setText(FitIn.fmt_wc_0(cash_in));
//        lbl_expenses.setText(FitIn.fmt_wc_0(expenses));
        set_totals();
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

    private void select_report() {
        final String version = System.getProperty("version", "resto");
        set_totals();
        int row = l_report_type.getSelectedIndex();
        if (row < 0) {
            return;
        }
        final double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));

        if (row == 0) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String date_from = DateType.sf.format(dp_from.getDate());
                    String date_to = DateType.sf.format(dp_to.getDate());
                    String jrxml_name = "";
                    String users = cb_cashier.getSelectedItem().toString();
                    if (users.equals("ALL")) {
                        users = "";
                    } else {
                        users = to_users.ret_user(users);
                    }

                    List<S1_my_sales.to_receipts> datas = S1_my_sales.ret_data(session, date_from, date_to, users);
                    S1_my_sales.to_details t = S1_my_sales.ret_cash_in(users, date_from, date_to);
                    lbl_cash_in.setText(FitIn.fmt_wc_0(t.cashin));
                    lbl_expenses.setText(FitIn.fmt_wc_0(t.expenses));
                    lbl_cashout.setText(FitIn.fmt_wc_0(t.cashout));
                    lbl_addtl_cashins.setText(FitIn.fmt_wc_0(t.addtl_cashins));
                    double peso1 = 0;
                    double dollar1 = 0;
                    double credit1 = 0;
                    double discount1 = 0;
                    double advance_payment = 0;
                    double advance_payment_usd = 0;
                    double gross = 0;
                    for (S1_my_sales.to_receipts to1 : datas) {
                        peso1 += to1.peso;
                        credit1 += to1.credit;
                        discount1 += to1.discount;
                        dollar1 += to1.dollar;
                        gross += to1.tendered;
                    }
                    lbl_peso.setText(FitIn.fmt_wc_0(peso1));
                    lbl_dollar.setText(FitIn.fmt_wc_0(dollar1));
                    lbl_discounts.setText(FitIn.fmt_wc_0(discount1));
                    lbl_credit.setText(FitIn.fmt_wc_0(credit1));
                    String business_name = System.getProperty("business_name", "");
                    double outside_cash = 0;
                    final Srpt_cashier_report to = Srpt_cashier_report.ret_data_session(session, dp_from.getDate(), dp_to.getDate(), business_name, dollar1, date_from, date_to, datas, peso1, discount1, credit1, t.expenses, users, t.cashin, t.cashout, t.addtl_cashins, 0, gross, advance_payment, advance_payment_usd, outside_cash, 0, 0, 0, 0);
                    jrxml_name = "rpt_daily_sales_liquid.jrxml";
                    report_get_viewer_conn_summary(to, jrxml_name);

                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();
        }
        if (row == 1) {

            pm_cashiers();
            jPanel4.setVisible(false);
        }
        final String user_name = "";
        if (row == 2) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_cash_sales_1.jrxml";
                    final to_date_to to = new to_date_to(dp_from.getDate(), dp_to.
                            getDate(), b_name, "", amount, user_name);

                    if (version.equals("resto")) {
                        jrxml_name = "rpt_cash_sales_1.jrxml";
                        report_get_viewer(to, jrxml_name);
                    } else {
                        jrxml_name = "rpt_casa_sales.jrxml";
                        report_get_viewer(to, jrxml_name);
                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }
        if (row == 3) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_cash_sales_1_1.jrxml";
                    to_date_to to = new to_date_to(dp_from.getDate(), dp_to.getDate(), b_name, "", amount, user_name);
                    to_date_from to2 = new to_date_from(dp_from.getDate(), "");

                    if (version.equals("resto")) {
                        jrxml_name = "rpt_cash_in_out.jrxml";
                        report_to_date_from(to2, jrxml_name);
                    } else {
                        jrxml_name = "rpt_cash_in_out_casa.jrxml";
                        report_to_date_from(to2, jrxml_name);
                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }
        if (row == 4) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_cash_in_out.jrxml";
                    final to_date_from to = new to_date_from(dp_from.getDate(), "");
                    to_date_to to2 = new to_date_to(dp_from.getDate(), dp_to.getDate(), b_name, "", amount, user_name);
                    if (version.equals("resto")) {
                        jrxml_name = "rpt_cash_sales_1_1.jrxml";
                        report_get_viewer(to2, jrxml_name);
                    } else {
                        jrxml_name = "rpt_casa_credit_sales.jrxml";
                        report_get_viewer(to2, jrxml_name);
                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }
        if (row == 5) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {

                    String jrxml_name = "rpt_sales_category.jrxml";
                    String date_from = DateType.sf.format(dp_from.getDate());
                    String date_to = DateType.sf.format(dp_to.getDate());
                    Srpt_sales_category to1 = Srpt_sales_category.get_sales_summary(date_from, date_to);
                    jPanel4.setVisible(false);
                    report_viewer_category(to1, jrxml_name);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }
        if (row == 6) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_stocks_left_1.jrxml";
                    final to_date_from to = new to_date_from(dp_from.getDate(), "");
                    final to_date_to to2 = new to_date_to(dp_from.getDate(), dp_to.
                            getDate(), b_name, "", amount, user_name);
                    if (version.equals("resto")) {
                        jrxml_name = "rpt_stocks_left_1.jrxml";
                        report_to_date_from(to, jrxml_name);
                    } else {
                        jrxml_name = "rpt_stocks_left_casablanca_1.jrxml";
                        report_to_date_from(to, jrxml_name);
                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }

        if (row == 7) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_stock_out.jrxml";
                    final to_date_from to = new to_date_from(dp_from.getDate(), "");
                    final to_date_to to2 = new to_date_to(dp_from.getDate(), dp_to.
                            getDate(), b_name, "", amount, user_name);
                    if (version.equals("resto")) {
                        jrxml_name = "rpt_stock_out.jrxml";
                        report_get_viewer(to2, jrxml_name);
                    } else {
                        jrxml_name = "rpt_stock_out_casa.jrxml";
                        report_get_viewer(to2, jrxml_name);
                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }
        if (row == 8) {
            jProgressBar1.setString("Loading...Please wait...");
            jProgressBar1.setIndeterminate(true);
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    String jrxml_name = "rpt_inventory2_liquid.jrxml";
                    to_date_from to = new to_date_from(dp_from.getDate(), "");

                    final to_date_to to2 = new to_date_to(dp_from.getDate(), dp_to.
                            getDate(), b_name, "", amount, user_name);
                    if (version.equals("resto")) {
                        jrxml_name = "rpt_inventory2_liquid.jrxml";
                        report_get_viewer(to2, jrxml_name);
                    } else {
                        jrxml_name = "rpt_inventory2_casablanca.jrxml";
                        report_get_viewer(to2, jrxml_name);

                    }
                    jPanel4.setVisible(false);
                    jProgressBar1.setString("Finished...");
                    jProgressBar1.setIndeterminate(false);
                }
            });
            t.start();

        }

        if (row == 9) {
            jPanel4.setVisible(true);
            tf_search.grabFocus();

        }

        if (row == 10) {
            disbursements();

        }

    }

    private void report_viewer_category(final Srpt_sales_category to, String jrxml_name) {
        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());

        try {
            JRViewer viewer = get_viewer_category_init(to, jrxml_name);
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
    int j = 0;

    private void cash_float() {
        Window p = (Window) this;
        Dlg_cashier_sales_all nd = Dlg_cashier_sales_all.create(p, true);
        nd.setTitle("");
        nd.do_pass("");
        nd.setCallback(new Dlg_cashier_sales_all.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_cashier_sales_all.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void disbursements() {

        Window p = (Window) this;
        Dlg_disbursements_categories nd = Dlg_disbursements_categories.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_disbursements_categories.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_disbursements_categories.OutputData data) {

                System.out.println(data.stmt);
                closeDialog.ok();
                if (data.report == 0) {
                    List<Srpt_disbursements.field> fields = Srpt_disbursements.ret_data_summary(data.stmt);
                    Srpt_disbursements rpt = new Srpt_disbursements(data.date, data.category, data.type);
                    String jrxml = "rpt_disbursements_summary.jrxml";
                    rpt.fields.addAll(fields);
                    report_viewer_disbursements(rpt, jrxml);
                } else {

                    List<Srpt_disbursements.field> fields = Srpt_disbursements.ret_data(data.stmt);
                    Srpt_disbursements rpt = new Srpt_disbursements(data.date, data.category, data.type);
                    String jrxml = "rpt_disbursements.jrxml";
                    rpt.fields.addAll(fields);
                    report_viewer_disbursements(rpt, jrxml);
                }

            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void report_to_date_from(to_date_from to, String jrxml_name) {

        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_from(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl_rpt.add(viewer);
            pnl_rpt.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void report_get_viewer(final to_date_to to, String jrxml_name) {
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

    public static JRViewer get_viewer_from(to_date_from to, String rpt_name) {
        Connection con11 = null;
        try {
            con11 = MyConnection1.connect();
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_conn_summary(S1_get_sales_for_the_day.to_reciept_sales to, String rpt_name) {
        Connection con11 = null;
        try {
            con11 = MyConnection1.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_session(to_date_to.session to, String rpt_name) {
        Connection con11 = null;
        try {
            con11 = MyConnection1.connect();
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JRViewer get_viewer_conn(to_date_to to, String rpt_name) {
        Connection con11 = null;
        try {
            con11 = MyConnection1.connect();
            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }

    public static JRViewer get_viewer_category_init(Srpt_sales_category to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_category(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }

    public static JRViewer get_viewer_disbursements(Srpt_disbursements to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_disbursements(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }

    public static JasperReport compileJasper_disbursements(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_disbursements.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JasperReport compileJasper_category(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_category.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_liquid.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public static JRViewer get_viewer_from(Srpt_cashier_report to, String rpt_name) {
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
//            MyConnection1.close();
        }

    }

    public static JRViewer get_viewer_conn_summary(Srpt_cashier_report to, String rpt_name) {
//        Connection con11 = null;
        try {
//            con11 = MyConnection1.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper2(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper2(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_cashier_report.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void pm_cashiers() {
        pm_cashiers.removeAll();
        Point l = l_report_type.getLocation();
        List<String> datas = S1_users.ret_cb_data();
        for (final String s : datas) {
            JMenuItem tm = new JMenuItem(s);
            pm_cashiers.add(tm);
            tm.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    jProgressBar1.setString("Loading...Please wait...");
                    jProgressBar1.setIndeterminate(true);
                    Thread t = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            String jrxml_name = "rpt_cashier_sales_1.jrxml";
                            String user_name = S1_users.ret_data(s);
                            if (s.equalsIgnoreCase("All")) {
                                user_name = "";
                            }
                            to_date_to to = new to_date_to(dp_from.getDate(), dp_to.getDate(), b_name, "", 0, user_name);
                            report_get_viewer(to, jrxml_name);
                            jProgressBar1.setString("Finished...");
                            jProgressBar1.setIndeterminate(false);
                        }
                    });
                    t.start();

                }
            });
        }
        pm_cashiers.show(l_report_type, l.x + 230, l.y + 25);

    }

    List<S6_items.to_inventory2_stocks_left> item_list = new ArrayList();

    private void init_items() {
        final String search = tf_search.getText();

        item_list.clear();

        item_list = S6_items.ret_data(search);
        Object[][] obj = new Object[item_list.size()][2];
        int i = 0;
        for (S6_items.to_inventory2_stocks_left to : item_list) {
            obj[i][0] = to.prod_num;
            obj[i][1] = to.description;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {50, 200};
        int width = 0;
        String[] col_names = {"Code", "Description"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf_search, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(final TableRenderer.OutputData data) {
                jProgressBar1.setString("Loading...Please wait...");
                jProgressBar1.setIndeterminate(true);
                Thread t = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        S6_items.to_inventory2_stocks_left to = item_list.
                                get(data.selected_row);

                        String date_from = DateType.sf.format(dp_from.getDate());
                        String date_to = DateType.sf.format(dp_to.getDate());
                        List<Srpt_sales_category.to_receipt_items> datas = Srpt_sales_by_item.ret_data_ordered("" + to.description, date_from, date_to);

                        List<Srpt_sales_by_item.field> fields = new ArrayList();

                        String description = to.description;
                        double unit_price = 0;
                        double qty = 0;
                        double amount;
                        for (Srpt_sales_category.to_receipt_items to1 : datas) {
                            qty += to1.qty;
                            unit_price = to1.unit_price;

                        }
                        amount = qty * unit_price;
                        Srpt_sales_by_item.field f = new Srpt_sales_by_item.field(description, unit_price, qty, amount);
                        fields.add(f);

                        String date = DateType.dash.format(dp_from.getDate()) + " - " + DateType.dash.format(dp_to.getDate());

                        String business_name = System.
                                getProperty("business_name", "Liquid Dive Dumaguete");
                        String jrxml = "rpt_sales_by_item.jrxml";
                        Srpt_sales_by_item rpt = new Srpt_sales_by_item(date, business_name);
                        rpt.fields.addAll(fields);
                        rpt_sales_by_item(rpt, jrxml);
                        jProgressBar1.setString("Finished...");
                        jProgressBar1.setIndeterminate(false);
                    }
                });
                t.start();

            }
        });
    }

    private void rpt_sales_by_item(final Srpt_sales_by_item to, String jrxml_name) {
        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());
        try {
            JRViewer viewer = viewer_rpt_sales_by_item(to, jrxml_name);
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

    public static JRViewer viewer_rpt_sales_by_item(Srpt_sales_by_item to, String rpt_name) {

        try {

            return JasperUtil.getJasperViewer(
                    compileJasper_sales_by_category(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_sales_by_category(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_sales_by_item.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void report_viewer_disbursements(final Srpt_disbursements to, String jrxml_name) {
        pnl_rpt.removeAll();
        pnl_rpt.setLayout(new BorderLayout());

        try {
            JRViewer viewer = get_viewer_disbursements(to, jrxml_name);
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
