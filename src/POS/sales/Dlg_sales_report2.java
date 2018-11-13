/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.categories.Categories;
import POS.categories.Category_types;
import POS.currency.S1_currency;
import POS.expenses.S1_expenses_categories;
import POS.my_reports.Srpt_disbursements;
import POS.receipts.Receipt_items;
import POS.receipts.Receipt_items.to_receipt_items;
import POS.receipts.Receipts;
import POS.receipts.Receipts.to_receipts;
import POS.rpt2.to_date_to;
import static POS.sales.Dlg_sales_report.compileJasper;
import static POS.sales.Dlg_sales_report.compileJasper_disbursements;
import static POS.sales.Dlg_sales_report.get_viewer_conn_summary;
import POS.to.to_users;
import POS.users.Users;
import POS.utl.DateType;
import POS.utl.DateUtils1;
import POS.utl.MyConnection1;
import POS.utl.TableRenderer;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import rpt_liquid.Srpt_cashier_report;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Guinness
 */
public class Dlg_sales_report2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_sales_report2
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
    private Dlg_sales_report2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_sales_report2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_sales_report2() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_sales_report2 myRef;

    private void setThisRef(Dlg_sales_report2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_sales_report2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_sales_report2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_sales_report2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_sales_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales_report2((java.awt.Frame) parent, false);
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
            Dlg_sales_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales_report2((java.awt.Dialog) parent, false);
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

        Dlg_sales_report2 dialog = Dlg_sales_report2.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dp_from = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        dp_to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField1 = new Field.Combo();
        jButton1 = new Button.Success();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        pnl_rpt_summary = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dp_from2 = new com.toedter.calendar.JDateChooser();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        dp_to2 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField3 = new Field.Combo();
        jButton3 = new Button.Success();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jTextField4 = new Field.Combo();
        jTextField5 = new Field.Combo();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        pnl_rpt_sales_by_category = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dp_from1 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        dp_to1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField2 = new Field.Combo();
        jButton2 = new Button.Success();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        pnl_rpt_cashier_sales = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_receipts = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_receipt_items = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jTextField6 = new Field.Combo();
        jLabel23 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jButton4 = new Button.Success();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Date from:");

        dp_from.setDate(new Date());
        dp_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("All");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("to:");

        dp_to.setDate(new Date());
        dp_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cashier:");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("All");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jProgressBar1.setRequestFocusEnabled(false);
        jProgressBar1.setStringPainted(true);

        jLabel4.setText("Status:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_from, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_to, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(398, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addGap(6, 6, 6))
        );

        pnl_rpt_summary.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_rpt_summaryLayout = new javax.swing.GroupLayout(pnl_rpt_summary);
        pnl_rpt_summary.setLayout(pnl_rpt_summaryLayout);
        pnl_rpt_summaryLayout.setHorizontalGroup(
            pnl_rpt_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_rpt_summaryLayout.setVerticalGroup(
            pnl_rpt_summaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_rpt_summary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_rpt_summary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sales Summary", jPanel2);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date from:");

        dp_from2.setDate(new Date());
        dp_from2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("All");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("to:");

        dp_to2.setDate(new Date());
        dp_to2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cashier:");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setSelected(true);
        jCheckBox6.setText("All");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jProgressBar3.setRequestFocusEnabled(false);
        jProgressBar3.setStringPainted(true);

        jLabel12.setText("Status:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Category:");

        jCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox7.setSelected(true);
        jCheckBox7.setText("All");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setSelected(true);
        jCheckBox8.setText("All");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("SubCategory:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_from2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_to2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_from2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_to2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3)))
                        .addGap(6, 6, 6))))
        );

        pnl_rpt_sales_by_category.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_rpt_sales_by_categoryLayout = new javax.swing.GroupLayout(pnl_rpt_sales_by_category);
        pnl_rpt_sales_by_category.setLayout(pnl_rpt_sales_by_categoryLayout);
        pnl_rpt_sales_by_categoryLayout.setHorizontalGroup(
            pnl_rpt_sales_by_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_rpt_sales_by_categoryLayout.setVerticalGroup(
            pnl_rpt_sales_by_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_rpt_sales_by_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_rpt_sales_by_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sales by Category", jPanel8);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date from:");

        dp_from1.setDate(new Date());
        dp_from1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("to:");

        dp_to1.setDate(new Date());
        dp_to1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cashier:");

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("All");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jProgressBar2.setRequestFocusEnabled(false);
        jProgressBar2.setStringPainted(true);

        jLabel8.setText("Status:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_from1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dp_to1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_from1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dp_to1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addGap(6, 6, 6))
        );

        pnl_rpt_cashier_sales.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

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
        });
        jScrollPane1.setViewportView(tbl_receipts);

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

        jLabel15.setText("No. of rows:");

        jLabel16.setText("0");

        jLabel17.setText("No. of rows:");

        jLabel18.setText("0");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("0.00");

        jLabel20.setText("Amount:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Sales Transactions", jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Summary", jPanel14);

        javax.swing.GroupLayout pnl_rpt_cashier_salesLayout = new javax.swing.GroupLayout(pnl_rpt_cashier_sales);
        pnl_rpt_cashier_sales.setLayout(pnl_rpt_cashier_salesLayout);
        pnl_rpt_cashier_salesLayout.setHorizontalGroup(
            pnl_rpt_cashier_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rpt_cashier_salesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        pnl_rpt_cashier_salesLayout.setVerticalGroup(
            pnl_rpt_cashier_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rpt_cashier_salesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_rpt_cashier_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnl_rpt_cashier_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cashier Sales", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox9.setText("All");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Date:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Category:");

        jCheckBox10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox10.setSelected(true);
        jCheckBox10.setText("All");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("To:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Report:");

        buttonGroup1.add(jCheckBox11);
        jCheckBox11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox11.setSelected(true);
        jCheckBox11.setText("Summary");

        buttonGroup1.add(jCheckBox12);
        jCheckBox12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox12.setText("Itemized");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Vatable:");

        buttonGroup2.add(jCheckBox13);
        jCheckBox13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox13.setSelected(true);
        jCheckBox13.setText("All");

        buttonGroup2.add(jCheckBox14);
        jCheckBox14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox14.setText("Yes");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox15);
        jCheckBox15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox15.setText("No");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jProgressBar4.setRequestFocusEnabled(false);
        jProgressBar4.setStringPainted(true);

        jLabel26.setText("Status:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox12))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox11)
                                .addComponent(jCheckBox12))
                            .addGap(2, 2, 2)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox14)
                                .addComponent(jCheckBox13)
                                .addComponent(jCheckBox15)))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox9))))
                            .addGap(2, 2, 2)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox10))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disbursements", jPanel11);

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        init_users(jTextField1);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        init_sales_summary();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        init_users(jTextField1);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        init_users(jTextField2);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        init_users(jTextField2);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ret_receipts();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_users(jTextField3);
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_users(jTextField3);
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        init_report_sales_by_category();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        init_categories(jTextField4);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        init_categories(jTextField4);
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        init_category_types(jTextField5);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        init_category_types(jTextField5);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void tbl_receiptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_receiptsMouseClicked
        ret_receipt_items();
    }//GEN-LAST:event_tbl_receiptsMouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        init_receipt_types();
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        init_report_disbursements();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        init_receipt_types();
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser dp_from;
    private com.toedter.calendar.JDateChooser dp_from1;
    private com.toedter.calendar.JDateChooser dp_from2;
    private com.toedter.calendar.JDateChooser dp_to;
    private com.toedter.calendar.JDateChooser dp_to1;
    private com.toedter.calendar.JDateChooser dp_to2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel pnl_rpt_cashier_sales;
    private javax.swing.JPanel pnl_rpt_sales_by_category;
    private javax.swing.JPanel pnl_rpt_summary;
    private javax.swing.JTable tbl_receipt_items;
    private javax.swing.JTable tbl_receipts;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
//        Main.MyDB.setNames("db_pos_liquid");

        users = Users.ret_data(" order by user_code asc ");

        set_user();

        init_tbl_receipts(tbl_receipts);
        init_tbl_receipt_items(tbl_receipt_items);
    }

    private void set_user() {

        Field.Combo tf1 = (Field.Combo) jTextField1;
        tf1.setText(to_users.getUser_screen_name());
        tf1.setId(to_users.getId());

        Field.Combo tf2 = (Field.Combo) jTextField3;
        tf2.setText(to_users.getUser_screen_name());
        tf2.setId(to_users.getId());

        Field.Combo tf3 = (Field.Combo) jTextField2;
        tf3.setText(to_users.getUser_screen_name());
        tf3.setId(to_users.getId());
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
    List<Users.to_users> users = new ArrayList();

    private void init_users(final JTextField tf1) {

        Object[][] obj = new Object[users.size()][1];
        int i = 0;
        for (Users.to_users to : users) {
            obj[i][0] = " " + to.user_code;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf1.getWidth()};
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Users.to_users to = users.get(data.selected_row);
                Field.Combo dep = (Field.Combo) tf1;
                dep.setText("" + to.user_code);
                dep.setId("" + to.id);
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Sales Summary ">
    private void init_sales_summary() {
        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(dp_from.getDate());
                String date_to = DateType.sf.format(dp_to.getDate());
                String jrxml_name = "";
                String users = jTextField1.getText();
                Field.Combo f_user = (Field.Combo) jTextField1;
                if (jCheckBox2.isSelected()) {
                    users = "";
                } else {
                    List<Users.to_users> user = Users.ret_data(" where id='" + f_user.getId() + "' ");
                    if (!user.isEmpty()) {
                        Users.to_users to = user.get(0);
                        users = to.user_name;
                    }

                }

                List<S1_my_sales.to_receipts> datas = S1_my_sales.ret_data("", date_from, date_to, users);
                S1_my_sales.to_details t = S1_my_sales.ret_cash_in(users, date_from, date_to);
//                lbl_cash_in.setText(FitIn.fmt_wc_0(t.cashin));
//                lbl_expenses.setText(FitIn.fmt_wc_0(t.expenses));
//                lbl_cashout.setText(FitIn.fmt_wc_0(t.cashout));
//                lbl_addtl_cashins.setText(FitIn.fmt_wc_0(t.addtl_cashins));
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
//                lbl_peso.setText(FitIn.fmt_wc_0(peso1));
//                lbl_dollar.setText(FitIn.fmt_wc_0(dollar1));
//                lbl_discounts.setText(FitIn.fmt_wc_0(discount1));
//                lbl_credit.setText(FitIn.fmt_wc_0(credit1));
                double dollar_rate = 0;
                String business_name = System.getProperty("business_name", "");
                double outside_cash = 0;
                int count_days = DateUtils1.count_days(dp_from.getDate(), dp_to.getDate());
                if (count_days == 0) {
                    String where3 = " where Date(date_added) ='" + date_from + "' ";
                    List<S1_currency.to_currencies> currency = S1_currency.ret_data_where(where3);
                    if (!currency.isEmpty()) {
                        S1_currency.to_currencies cur = (S1_currency.to_currencies) currency.get(0);
                        dollar_rate = FitIn.toDouble(cur.amount);
                    }
                } else {
                    String where3 = " where Date(date_added) ='" + date_to + "' ";
                    List<S1_currency.to_currencies> currency = S1_currency.ret_data_where(where3);
                    if (!currency.isEmpty()) {
                        S1_currency.to_currencies cur = (S1_currency.to_currencies) currency.get(0);
                        dollar_rate = FitIn.toDouble(cur.amount);
                    }
                }

                final Srpt_cashier_report to = Srpt_cashier_report.ret_data_session("", dp_from.getDate(), dp_to.getDate(), business_name, dollar1, date_from, date_to, datas, peso1, discount1, credit1, t.expenses, users, t.cashin, t.cashout, t.addtl_cashins, 0, gross, advance_payment, advance_payment_usd, outside_cash, 0, 0, 0, 0,dollar_rate,0);
                jrxml_name = "rpt_daily_sales_liquid.jrxml";
                report_get_viewer_sales_summary(to, jrxml_name);

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_get_viewer_sales_summary(final Srpt_cashier_report to, String jrxml_name) {
        pnl_rpt_summary.removeAll();
        pnl_rpt_summary.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_conn_summary(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            pnl_rpt_summary.add(viewer);
            pnl_rpt_summary.updateUI();
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

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Cashier Sales ">
    private void report_get_viewer_cashier_sales(final to_date_to to, String jrxml_name) {
        pnl_rpt_cashier_sales.removeAll();
        pnl_rpt_cashier_sales.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_conn(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl_rpt_cashier_sales.add(viewer);
            pnl_rpt_cashier_sales.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    //</editor-fold>
    List<Categories.to_category> categories = new ArrayList();

    private void init_categories(final JTextField tf1) {
        if (jCheckBox7.isSelected()) {
            categories = Categories.ret_data(" where cat_name like '%" + tf1.getText() + "%' order by cat_name asc ");
        } else {
            categories = Categories.ret_data(" order by cat_name asc ");
        }
        Object[][] obj = new Object[categories.size()][1];
        int i = 0;
        for (Categories.to_category to : categories) {
            obj[i][0] = " " + to.cat_name;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf1.getWidth()};
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Categories.to_category to = categories.get(data.selected_row);
                Field.Combo dep = (Field.Combo) tf1;
                dep.setText("" + to.cat_name);
                dep.setId("" + to.id);
            }
        });
    }
    List<Category_types.to_category_type> categories_types = new ArrayList();

    private void init_category_types(final JTextField tf1) {

        String where = " where cat_name like '%" + "" + "%' ";
        if (jCheckBox7.isSelected()) {
            where = where + " order by type_name asc";
        } else {
            Field.Combo cat = (Field.Combo) jTextField4;
            if (jCheckBox8.isSelected()) {
                where = where + " and cat_num like '" + cat.getId() + "' order by type_name asc";
            } else {
                where = where + " and cat_num like '" + cat.getId() + "' and type_name like '%" + tf1.getText() + "%' order by type_name asc  ";
            }
        }
        categories_types = Category_types.ret_data(where);
        Object[][] obj = new Object[categories_types.size()][1];
        int i = 0;
        for (Category_types.to_category_type to : categories_types) {
            obj[i][0] = " " + to.type_name;
            i++;
        }

        JLabel[] labels = {};
        int[] tbl_widths_customers = {tf1.getWidth()};
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(tf1, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Category_types.to_category_type to = categories_types.get(data.selected_row);
                Field.Combo dep = (Field.Combo) tf1;
                dep.setText("" + to.type_name);
                dep.setId("" + to.id);
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc=" Sales by Category ">

    private void init_report_sales_by_category() {
        jProgressBar3.setString("Loading...Please wait...");
        jProgressBar3.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String where = " where sub_category_name like '%" + "" + "%' ";

                String date_from = DateType.sf.format(dp_from2.getDate());
                String date_to = DateType.sf.format(dp_to2.getDate());
                String cashier = "All";
                String category = "";
                String category_type = "";
                if (!jCheckBox5.isSelected()) {
                    where = where + " and Date(ctd.date_added) between '" + date_from + "' and '" + date_to + "' ";
                }
                if (!jCheckBox6.isSelected()) {
                    Field.Combo f_user = (Field.Combo) jTextField3;
                    List<Users.to_users> user = Users.ret_data(" where id='" + f_user.getId() + "' ");
                    String user_name = "";
                    if (!user.isEmpty()) {
                        Users.to_users to = user.get(0);
                        user_name = to.user_name;
                    }
                    where = where + " and ctd.user_name like '" + user_name + "' ";
                    cashier = f_user.getText();
                }
                Field.Combo cat = (Field.Combo) jTextField4;
                Field.Combo cat_type = (Field.Combo) jTextField5;
                if (!jCheckBox7.isSelected()) {
                    category = cat.getText();
                    if (!jCheckBox8.isSelected()) {
                        category_type = cat_type.getText();
                        where = where + " and ctd.cat_id='" + cat.getId() + "' and isl.types_num='" + cat_type.getId() + "' ";
                    } else {
                        category_type = "All";
                        where = where + " and ctd.cat_id='" + cat.getId() + "' ";
                    }
                } else {
                    category = "All";
                    category_type = "All";
                }

                where = where + " group by CASE WHEN isl.item_package_id='1' THEN ctd.room_guest_id END "
                        + "  ,ctd.product_name, "
                        + "  CASE WHEN isl.item_package_id='0' THEN ctd.price END "
                        + "  ,ctd.discount "
                        + " order by ctd.category_name asc ,ctd.description asc ";
                String business_name = System.getProperty("business_name", "");
                String address = System.getProperty("address", "");
                String contact_no = System.getProperty("contact_no", "");
                System.out.println("where: "+where);
                String date = DateType.convert_slash2(date_from) + " - " + DateType.convert_slash2(date_to);
                List<Srpt_sales_by_category.field> fields = Srpt_sales_by_category.ret_data(where);
                double grand_total = 0;
                double paid = 0;
                double unpaid = 0;
                for (Srpt_sales_by_category.field to : fields) {
                    grand_total += to.amount;
                    if (to.status == 0) {
                        unpaid += to.amount;
                    }
                    if (to.status == 1) {
                        paid += to.amount;
                    }
                }
                Srpt_sales_by_category rpt = new Srpt_sales_by_category(business_name, address, contact_no, date, cashier, category, category_type, grand_total, paid, unpaid);

                rpt.fields.addAll(fields);
                String jrxml_name = "rpt_sales_by_category.jrxml";
                report_get_viewer_sales_by_category(rpt, jrxml_name);

                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_get_viewer_sales_by_category(final Srpt_sales_by_category to, String jrxml_name) {
        pnl_rpt_sales_by_category.removeAll();
        pnl_rpt_sales_by_category.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_sales_by_category(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl_rpt_sales_by_category.add(viewer);
            pnl_rpt_sales_by_category.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_sales_by_category(Srpt_sales_by_category to, String rpt_name) {
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
            InputStream is = Srpt_sales_by_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Cashier Sales ">
    //<editor-fold defaultstate="collapsed" desc=" receipts "> 
    public static ArrayListModel tbl_receipts_ALM;
    public static TblreceiptsModel tbl_receipts_M;

    public static void init_tbl_receipts(JTable tbl_receipts) {
        tbl_receipts_ALM = new ArrayListModel();
        tbl_receipts_M = new TblreceiptsModel(tbl_receipts_ALM);
        tbl_receipts.setModel(tbl_receipts_M);
        tbl_receipts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipts.setRowHeight(25);
        int[] tbl_widths_receipts = {70, 80, 100, 80, 80, 80, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipts, i, tbl_widths_receipts[i]);
        }
        Dimension d = tbl_receipts.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipts.getTableHeader().setPreferredSize(d);
        tbl_receipts.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_receipts.setRowHeight(25);
        tbl_receipts.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 4);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipts, 7);
    }

    public static void loadData_receipts(List<to_receipts> acc) {
        tbl_receipts_ALM.clear();
        tbl_receipts_ALM.addAll(acc);
    }

    public static class TblreceiptsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Trans #", "Date", "Guest", "Tendered", "Discount", "Credit Card", "Dollar", "Peso", "approval_code", "member_id", "is_payed", "dollar", "credit_dollar", "dollar_rate", "peso", "user_name", "guest_ids", "guest_names", "room_guest_ids", "table_id", "table_name", "gross_sales", "bank_php", "bank_usd", "credit_card"
        };

        public TblreceiptsModel(ListModel listmodel) {
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
            to_receipts tt = (to_receipts) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.or_number;
                case 1:
                    return " " + DateType.convert_slash(tt.receipt_date);
                case 2:
                    return " " + tt.guest_names;
                case 3:
                    return FitIn.fmt_wc_0(tt.tendered) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.discount) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.credit) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.dollar) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.peso) + " ";
                case 8:
                    return tt.approval_code;
                case 9:
                    return tt.member_id;
                case 10:
                    return tt.is_payed;
                case 11:
                    return tt.dollar;
                case 12:
                    return tt.credit_dollar;
                case 13:
                    return tt.dollar_rate;
                case 14:
                    return tt.peso;
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

    private void ret_receipts() {

        String where = " where approval_code like '%" + "" + "%' ";
        if (!jCheckBox3.isSelected()) {
            String date_from = DateType.sf.format(dp_from1.getDate());
            String date_to = DateType.sf.format(dp_to1.getDate());
            where = where + " and Date(receipt_date) between '" + date_from + "' and '" + date_to + "' ";
        }
        if (!jCheckBox6.isSelected()) {
            Field.Combo f_user = (Field.Combo) jTextField2;
            List<Users.to_users> user = Users.ret_data(" where id='" + f_user.getId() + "' ");
            String user_name = "";
            if (!user.isEmpty()) {
                Users.to_users to = user.get(0);
                user_name = to.user_name;
            }
            where = where + " and user_name like '" + user_name + "' ";

        }
        List<to_receipts> receipts = Receipts.ret_data(where);
        loadData_receipts(receipts);
        jLabel16.setText("" + receipts.size());
//        init_cashier_sales_summary();
    }
//</editor-fold> 

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" receipt_items "> 
    public static ArrayListModel tbl_receipt_items_ALM;
    public static Tblreceipt_itemsModel tbl_receipt_items_M;

    public static void init_tbl_receipt_items(JTable tbl_receipt_items) {
        tbl_receipt_items_ALM = new ArrayListModel();
        tbl_receipt_items_M = new Tblreceipt_itemsModel(tbl_receipt_items_ALM);
        tbl_receipt_items.setModel(tbl_receipt_items_M);
        tbl_receipt_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_receipt_items.setRowHeight(25);
        int[] tbl_widths_receipt_items = {70, 100, 100, 80, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_receipt_items.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_receipt_items, i, tbl_widths_receipt_items[i]);
        }
        Dimension d = tbl_receipt_items.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_receipt_items.getTableHeader().setPreferredSize(d);
        tbl_receipt_items.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_receipt_items.setRowHeight(25);
        tbl_receipt_items.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 3);
        TableWidthUtilities.setColumnRightRenderer(tbl_receipt_items, 4);
    }

    public static void loadData_receipt_items(List<to_receipt_items> acc) {
        tbl_receipt_items_ALM.clear();
        tbl_receipt_items_ALM.addAll(acc);
    }

    public static class Tblreceipt_itemsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Price", "Amount", "type_name", "cat_name", "description", "disc_name", "disc_rate", "discount", "customer_name", "customer_id", "customer_address", "group_id", "date_added", "nights", "user_name"
        };

        public Tblreceipt_itemsModel(ListModel listmodel) {
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
            to_receipt_items tt = (to_receipt_items) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.qty;
                case 1:
                    return " " + tt.product_name;
                case 2:
                    return " " + tt.description;
                case 3:
                    return FitIn.fmt_wc_0(tt.unit_price) + " ";
                case 4:
                    double total = (tt.qty * tt.unit_price);
                    double amount = 0;
                    double discount = 0;
                    boolean con = tt.description.contains("DISCOUNT");
                    if (con) {
                        int index1 = tt.description.indexOf("@");
                        int index2 = tt.description.indexOf("% DISCOUNT");

                        String disc = tt.description.substring(index1 + 2, index2);
                        discount = FitIn.toDouble(disc);
                        discount = total * (discount / 100);
                    }
                    amount += total - discount;
                    return FitIn.fmt_wc_0(amount) + " ";
                case 5:
                    return tt.type_name;
                case 6:
                    return tt.cat_name;
                case 7:
                    return tt.description;
                case 8:
                    return tt.disc_name;
                case 9:
                    return tt.disc_rate;
                case 10:
                    return tt.discount;
                case 11:
                    return tt.customer_name;
                case 12:
                    return tt.customer_id;
                case 13:
                    return tt.customer_address;
                case 14:
                    return tt.group_id;
                case 15:
                    return tt.date_added;
                case 16:
                    return tt.nights;
                default:
                    return tt.user_name;
            }
        }
    }

    private void ret_receipt_items() {
        int row = tbl_receipts.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_receipts rec = (to_receipts) tbl_receipts_ALM.get(row);

        String where = " where receipt_id='" + rec.id + "' ";

        List<to_receipt_items> items = Receipt_items.ret_data(where);
        double amount = 0;
        for (to_receipt_items to : items) {
            double discount = 0;
            double total = (to.qty * to.unit_price);
            boolean con = to.description.contains("DISCOUNT");
            if (con) {
                int index1 = to.description.indexOf("@");
                int index2 = to.description.indexOf("% DISCOUNT");
                String disc = to.description.substring(index1 + 2, index2);
                discount = FitIn.toDouble(disc);
                discount = total * (discount / 100);
            }
            amount += total - discount;
        }
        loadData_receipt_items(items);
        jLabel18.setText("" + items.size());
        jLabel19.setText(FitIn.fmt_wc_0(amount));
    }

    private void init_cashier_sales_summary() {
        jProgressBar2.setString("Loading...Please wait...");
        jProgressBar2.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(dp_from.getDate());
                String date_to = DateType.sf.format(dp_to.getDate());

                double tendered = 0;
                double discount = 0;
                double credit = 0;
                double expences = 0;
                double cashin = 0;
                double cashout = 0;
                double addtl_cashin = 0;
                double dollar = 0;
                double advance_payment = 0;
                double advance_payment_usd = 0;
                double bank_php = 0;
                double bank_usd = 0;
                double credit_card = 0;
                double gross = 0;
                double outside_cash = 0;
                double cc_reflenishment = 0;
                String users = "";
                String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");

                String jrxml_name = "rpt_daily_sales_liquid_all.jrxml";
                List<to_receipts> datas = tbl_receipts_ALM;
                final Srpt_cashier_report to = Srpt_cashier_report.ret_data_session2("", dp_from1.
                        getDate(), dp_to1.getDate(), business_name, dollar, date_from,
                        date_to, datas, tendered, discount, credit,
                        expences, users, cashin, cashout, addtl_cashin, 0, gross,
                        advance_payment, advance_payment_usd, outside_cash, cc_reflenishment,
                        bank_php, bank_usd, credit_card);

                report_get_viewer_cashier_sales_summary(to, jrxml_name);

                jProgressBar2.setString("Finished...");
                jProgressBar2.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_get_viewer_cashier_sales_summary(final Srpt_cashier_report to, String jrxml_name) {
        jPanel14.removeAll();
        jPanel14.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_cashier_sales_summary(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel14.add(viewer);
            jPanel14.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_cashier_sales_summary(Srpt_cashier_report to, String rpt_name) {
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
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" Disbursements ">
    List<S1_expenses_categories.to_expenses_categories> expenses = new ArrayList();

    private void init_receipt_types() {

        Object[][] obj = new Object[expenses.size()][1];
        int i = 0;
        for (S1_expenses_categories.to_expenses_categories to : expenses) {
            obj[i][0] = " " + to.category_name.toUpperCase();
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {jTextField6.getWidth()};
        int width = 0;
        String[] col_names = {"Category"};
        TableRenderer tr = new TableRenderer();
        TableRenderer.
                setPopup(jTextField6, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                S1_expenses_categories.to_expenses_categories to = (S1_expenses_categories.to_expenses_categories) expenses.get(data.selected_row);
                jTextField6.setText(to.category_name.toUpperCase());
            }
        });
    }

    private void init_report_disbursements() {
        jProgressBar4.setString("Loading...Please wait...");
        jProgressBar4.setIndeterminate(true);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                String date_from = DateType.sf.format(jDateChooser1.getDate());
                String date_to = DateType.sf.format(jDateChooser2.getDate());
                String date = "All";
                String category = "All";
                String type = "All";

                String where = " where user_name like '%" + "" + "%' ";
                if (!jCheckBox9.isSelected()) {
                    where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                    date = DateType.convert_slash2(DateType.sf.format(jDateChooser1.getDate())) + " - " + DateType.convert_slash2(DateType.sf.format(jDateChooser2.getDate()));

                }
                if (!jCheckBox10.isSelected()) {
                    where = where + " and category_name like '%" + jTextField6.getText() + "%' ";
                    category = jTextField6.getText();
                }
                if (jCheckBox14.isSelected()) {
                    where = where + " and vat like '" + "VAT" + "' ";
                    type = "VAT";
                }
                if (jCheckBox15.isSelected()) {
                    where = where + " and vat like '" + "NON VAT" + "' ";
                    type = "NON VAT";
                }
                where = where + " order by category_name asc ";
                int report = 0;
                String jrxml = "rpt_disbursements_summary.jrxml";
                if (jCheckBox11.isSelected()) {
                    report = 1;
                }

                if (report == 0) {
                    jrxml = "rpt_disbursements.jrxml";
                    where = " where user_name like '%" + "" + "%' ";
                    if (!jCheckBox9.isSelected()) {
                        where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
                        date = DateType.convert_slash2(DateType.sf.format(jDateChooser1.getDate())) + " - " + DateType.convert_slash2(DateType.sf.format(jDateChooser2.getDate()));

                    }
                    if (!jCheckBox10.isSelected()) {
                        where = where + " and category_name like '%" + jTextField6.getText() + "%' ";
                        category = jTextField6.getText();
                    }
                    where = where + " group by category_name order by category_name asc ";
                }
                List<Srpt_disbursements.field> fields = Srpt_disbursements.ret_data(where);
                Srpt_disbursements rpt = new Srpt_disbursements(date, category, type);

                rpt.fields.addAll(fields);
                report_viewer_disbursements(rpt, jrxml);

                jProgressBar4.setString("Finished...");
                jProgressBar4.setIndeterminate(false);
            }
        });
        t.start();
    }

    private void report_viewer_disbursements(final Srpt_disbursements to, String jrxml_name) {
        jPanel10.removeAll();
        jPanel10.setLayout(new BorderLayout());

        try {
            JRViewer viewer = get_viewer_disbursements(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel10.add(viewer);
            jPanel10.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
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
    //</editor-fold>
}
