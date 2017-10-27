/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.stock_in.Srpt_stock_in;
import POS.branches.Dlg_branches;
import POS.category_types.S1_categories;
import POS.stock_in.Srpt_stock_in_main;
import POS.stock_in.Stock_in;
import POS.stock_in.Stock_in_main;
import POS.stock_in.Stock_in_main.to_stock_in_main;
import POS.stock_out.Stock_out;
import POS.stock_out.Stock_out_main;
import POS.stock_out.Stock_out_main.to_stock_out_main;
import POS.svc.S3_insert_new_user;
import POS.svc3.S10_update_product;
import POS.svc3.S9_add_product;
import POS.to.to_users;
import POS.to2.to_add_product;
import POS.utl.Alert;
import POS.utl.DateType;
import POS.utl.Dlg_confirm_action;
import POS.utl.TableUtility;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import synsoftech.fields.Button;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Dummy
 */
public class Dlg_inventory_stockin_out extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_stockout
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
    private Dlg_inventory_stockin_out(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_inventory_stockin_out(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_inventory_stockin_out() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_inventory_stockin_out myRef;

    private void setThisRef(Dlg_inventory_stockin_out myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory_stockin_out> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory_stockin_out create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory_stockin_out create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory_stockin_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_stockin_out((java.awt.Frame) parent, false);
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
            Dlg_inventory_stockin_out dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory_stockin_out((java.awt.Dialog) parent, false);
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_inventory_stockin_out dialog = Dlg_inventory_stockin_out.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cb_stock_in = new javax.swing.JCheckBox();
        cb_stock_out = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_ref_no = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cb_stock_in_ref = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_stock_usb = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tf_text1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_stock_out = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb_is_selected1 = new javax.swing.JCheckBox();
        cb_category1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cb_is_selected2 = new javax.swing.JCheckBox();
        cb_type1 = new javax.swing.JComboBox();
        jButton2 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new Button.Default();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        tf_search1 = new javax.swing.JTextField();
        jButton4 = new Button.Default();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_stock_in_main = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_stock_in_main1 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel20 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        tf_search2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cb_is_selected5 = new javax.swing.JCheckBox();
        cb_category3 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cb_is_selected6 = new javax.swing.JCheckBox();
        cb_type3 = new javax.swing.JComboBox();
        jButton5 = new Button.Default();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel31 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Transaction Type:");

        cb_stock_in.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cb_stock_in);
        cb_stock_in.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_stock_in.setSelected(true);
        cb_stock_in.setText("Stock In    [ + ]");
        cb_stock_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_stock_inActionPerformed(evt);
            }
        });

        cb_stock_out.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cb_stock_out);
        cb_stock_out.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_stock_out.setText("Stock Out [  -  ]");
        cb_stock_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_stock_outActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tf_remarks.setColumns(20);
        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setLineWrap(true);
        tf_remarks.setRows(5);
        jScrollPane3.setViewportView(tf_remarks);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Remarks:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Reference No.:");

        lbl_ref_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ref_no.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ref_no.setText("000000000000");

        buttonGroup1.add(cb_stock_in_ref);
        cb_stock_in_ref.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_stock_in_ref.setText("STOCK IN (REFERENCE NO)");
        cb_stock_in_ref.setEnabled(false);

        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setToolTipText("NO CONNECTION");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X");
        jLabel6.setToolTipText("NO USB DETECTED");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        buttonGroup1.add(cb_stock_usb);
        cb_stock_usb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_stock_usb.setText("STOCK IN (USB)");
        cb_stock_usb.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("BRANCH:");

        lbl_branch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_branch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_branch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("+");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb_stock_in_ref, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_stock_usb, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbl_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_stock_in_ref, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_stock_usb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Supplier:");

        tf_text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_text1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_text1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_stock_in)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_stock_out)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_text1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_stock_in, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_stock_out, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_text1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_out.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_out.setFocusable(false);
        tbl_stock_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_outMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_stock_out);

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_prod.setFocusable(false);
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Category:");

        cb_is_selected1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected1.setSelected(true);
        cb_is_selected1.setText("All");
        cb_is_selected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected1ActionPerformed(evt);
            }
        });

        cb_category1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_category1.setFocusable(false);
        cb_category1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_category1MouseClicked(evt);
            }
        });
        cb_category1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_category1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Sub:");

        cb_is_selected2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected2.setSelected(true);
        cb_is_selected2.setText("All");
        cb_is_selected2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected2ActionPerformed(evt);
            }
        });

        cb_type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_type1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE" }));
        cb_type1.setFocusable(false);
        cb_type1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_type1MouseClicked(evt);
            }
        });
        cb_type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_type1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_is_selected1)
                            .addComponent(cb_is_selected2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_type1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_category1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tf_search))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_category1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected1))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_type1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cb_is_selected2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_search)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0))
        );

        jButton2.setText("CLOSE");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Total no. of items:");

        jLabel11.setText("0");

        jLabel12.setText("Total no. of items:");

        jLabel13.setText("0");

        jLabel14.setText("Total Amount:");

        jLabel15.setText("0.00");

        jButton6.setText("Clear");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transactions", jPanel6);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Transaction Type:");

        buttonGroup2.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Stock In");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Stock Out");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Date from:");

        jDateChooser1.setDate(new Date());

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("All");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("to:");

        jDateChooser2.setDate(new Date());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Search:");

        tf_search1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search1ActionPerformed(evt);
            }
        });
        tf_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search1KeyReleased(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_search1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        tbl_stock_in_main.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_in_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_in_mainMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_stock_in_main);

        jLabel21.setText("Total no. of rows:");

        jLabel22.setText("0");

        jLabel29.setText("Total Amount:");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("0.00");

        tbl_stock_in_main1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_stock_in_main1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_in_main1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_stock_in_main1);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Transactions", jPanel17);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setText("Status:");

        jProgressBar3.setString("");
        jProgressBar3.setStringPainted(true);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(729, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Print Preview", jPanel18);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reports", jPanel5);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Transaction Type:");

        buttonGroup3.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Stock In");

        buttonGroup3.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Stock Out");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Date from:");

        jDateChooser3.setDate(new Date());

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("All");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("to:");

        jDateChooser4.setDate(new Date());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Search:");

        tf_search2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_search2ActionPerformed(evt);
            }
        });
        tf_search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search2KeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Category:");

        cb_is_selected5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected5.setSelected(true);
        cb_is_selected5.setText("All");
        cb_is_selected5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected5ActionPerformed(evt);
            }
        });

        cb_category3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_category3.setFocusable(false);
        cb_category3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_category3MouseClicked(evt);
            }
        });
        cb_category3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_category3ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Sub:");

        cb_is_selected6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected6.setSelected(true);
        cb_is_selected6.setText("All");
        cb_is_selected6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected6ActionPerformed(evt);
            }
        });

        cb_type3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_type3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE" }));
        cb_type3.setFocusable(false);
        cb_type3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_type3MouseClicked(evt);
            }
        });
        cb_type3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_type3ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_is_selected5)
                            .addComponent(cb_is_selected6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_type3, 0, 777, Short.MAX_VALUE)
                            .addComponent(cb_category3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(tf_search2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cb_category3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected5))
                .addGap(1, 1, 1)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_type3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(cb_is_selected6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search2)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addComponent(jLabel26))
                .addGap(0, 0, 0))
        );

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel31.setText("Status:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox6)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Itemized", jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1)
                .addGap(25, 25, 25))
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

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee_search();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        select_item();
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_stock_outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_outMouseClicked
        do_edit_out();
    }//GEN-LAST:event_tbl_stock_outMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_stock_in_out();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        stock_in_usb();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        branches();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        data_employee_search();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void cb_is_selected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected1ActionPerformed
        data_employee_search();
    }//GEN-LAST:event_cb_is_selected1ActionPerformed

    private void cb_category1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_category1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_category1MouseClicked

    private void cb_category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_category1ActionPerformed
        cb_type2();
        data_employee_search();
    }//GEN-LAST:event_cb_category1ActionPerformed

    private void cb_is_selected2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected2ActionPerformed
        data_employee_search();
    }//GEN-LAST:event_cb_is_selected2ActionPerformed

    private void cb_type1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_type1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type1MouseClicked

    private void cb_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_type1ActionPerformed
        // TODO add your handling code here:
        data_employee_search();
    }//GEN-LAST:event_cb_type1ActionPerformed

    private void tf_text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_text1ActionPerformed

    private void tf_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search2ActionPerformed

    private void tf_search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search2KeyReleased

    private void cb_is_selected5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_is_selected5ActionPerformed

    private void cb_category3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_category3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_category3MouseClicked

    private void cb_category3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_category3ActionPerformed
        cb_type3();
    }//GEN-LAST:event_cb_category3ActionPerformed

    private void cb_is_selected6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_is_selected6ActionPerformed

    private void cb_type3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_type3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type3MouseClicked

    private void cb_type3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_type3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type3ActionPerformed

    private void tf_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_search1KeyReleased

    private void tf_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_search1ActionPerformed
        ret_stock_in();
    }//GEN-LAST:event_tf_search1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ret_stock_in();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        set_report_stock_in_items();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_stock_in_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_in_mainMouseClicked
        select_stock_in_main();
    }//GEN-LAST:event_tbl_stock_in_mainMouseClicked

    private void tbl_stock_in_main1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_in_main1MouseClicked
        select_stock_out_main();
    }//GEN-LAST:event_tbl_stock_in_main1MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jScrollPane5.setVisible(false);
        jScrollPane4.setVisible(true);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        jScrollPane4.setVisible(false);
        jScrollPane5.setVisible(true);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void cb_stock_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_stock_inActionPerformed
        ref_no();
    }//GEN-LAST:event_cb_stock_inActionPerformed

    private void cb_stock_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_stock_outActionPerformed
        ref_no();
    }//GEN-LAST:event_cb_stock_outActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ref_no();
        tbl_out_ALM.clear();
        jLabel15.setText("0.00");
        jLabel13.setText("0");
    }//GEN-LAST:event_jButton6ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cb_category1;
    private javax.swing.JComboBox cb_category3;
    private javax.swing.JCheckBox cb_is_selected1;
    private javax.swing.JCheckBox cb_is_selected2;
    private javax.swing.JCheckBox cb_is_selected5;
    private javax.swing.JCheckBox cb_is_selected6;
    private javax.swing.JCheckBox cb_stock_in;
    private javax.swing.JCheckBox cb_stock_in_ref;
    private javax.swing.JCheckBox cb_stock_out;
    private javax.swing.JCheckBox cb_stock_usb;
    private javax.swing.JComboBox cb_type1;
    private javax.swing.JComboBox cb_type3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
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
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_ref_no;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTable tbl_stock_in_main;
    private javax.swing.JTable tbl_stock_in_main1;
    private javax.swing.JTable tbl_stock_out;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_search1;
    private javax.swing.JTextField tf_search2;
    private javax.swing.JTextField tf_text1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
//        Main.MyDB.setNames("db_pos_restaurant_liquid");
        init_key();
        init_ref_no();
        tf_search.grabFocus();
        init_tbl_baptism();
        init_tbl_out();
        jPanel2.setVisible(false);

        cb_model();

        init_tbl_stock_in_main(tbl_stock_in_main);
        init_tbl_stock_out_main(tbl_stock_in_main1);
        ref_no();
        jScrollPane5.setVisible(false);
    }

    private void cb_model() {

        cb_category1.setModel(new ListComboBoxModel(S1_categories.
                ret_categories_for_cb()));
        cb_category3.setModel(new ListComboBoxModel(S1_categories.
                ret_categories_for_cb()));

    }

    private void init_ref_no() {
        lbl_ref_no.setText(S1_stock_out.ret_stock_main_no());

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
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);
        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 25));

        tbl_prod.setModel(tbl_employee_payroll_M);
        tbl_prod.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prod.setRowHeight(25);

        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 25));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {70, 80, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_prod, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

//        TableUtility.align_row_to_left(tbl_prod, 1);
        TableUtility.align_row_to_right(tbl_prod, 3);
//        TableUtility.align_row_to_Center(tbl_prod, 3);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_prod.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.NORMAL, 12));
        tbl_prod.setRowHeight(25);
        tbl_prod.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<to_add_product> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Cost", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id", "cost"
        };

        public TblInvoicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
                case 0:
                    return " " + tt.qty;
                case 1:
                    return " " + tt.name;

                case 2:

                    return " " + tt.desc;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    return tt.num;
                case 5:
                    return tt.vat;
                case 6:
                    return tt.category_id;
                case 7:
                    return tt.is_linient;
                case 8:
                    return tt.w_commission;
                case 9:
                    return tt.comm_amount;
                case 10:
                    return tt.cat_id;

                default:
                    return tt.cost;
            }
        }
    }

    private void data_employee_search() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
////        int row = cb_type.getItemCount();
////        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }
        String category_name = cb_category1.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        String category_id = cat_id;
        String name = tf_search.getText();
        String type_name = cb_type1.getSelectedItem().
                toString();

        String where = " where description like '%" + name + "%' ";

        if (!cb_is_selected1.isSelected()) {
            where = where + " and cat_id = '" + category_id + "' ";
        }
        if (!cb_is_selected2.isSelected()) {
            where = where + " and types like '" + type_name + "' ";
        }
//        System.out.println(where);
        loadData_baptism(S9_add_product.ret_products_where(where));
    }

    private void select_item() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        final to_add_product to2 = (to_add_product) tbl_employee_payroll_ALM.get(row);
        final String name = to2.name;
        final String desc = to2.desc;
        final double price = to2.price;
        final double qty = to2.qty;
        final String num = to2.num;
        final String vat = to2.vat;
        final String category_id = to2.category_id;
        final String is_linient = to2.is_linient;
        final String w_commission = to2.w_commission;
        final double comm_amount = to2.comm_amount;
        final String cat_id = to2.cat_id;
        final double cost = to2.cost;
        Window p = (Window) this;
        Dlg_number21 nd = Dlg_number21.create(p, true);
        nd.setTitle("");
        nd.do_pass(to2, 1, to2.cost);
        nd.setCallback(new Dlg_number21.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                closeDialog.ok();
                List<to_add_product> acc = new ArrayList();
                to_add_product to = new to_add_product(name, desc, price, data.qty, num,
                        vat, category_id, is_linient, w_commission, comm_amount, cat_id, data.cost, to2.printing_assembly, to2.is_active, to2.category_name, to2.type_id, to2.type_name, to2.item_package_id, to2.happy_hour);
                acc.add(to);
                loadData_out(acc);
                count_total();
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);

        nd.setVisible(true);

////        Center.setCenter(nd);
//        int x = evt.getXOnScreen();
//        int y = evt.getYOnScreen();
//        nd.setLocation(x, y);
//        nd.setVisible(true);
    }

    private void count_total() {
        List<to_add_product> datas = tbl_out_ALM;
        double total = 0;
        for (to_add_product to : datas) {
            total += (to.qty * to.cost);

        }
        jLabel15.setText(FitIn.fmt_wc_0(total));
        jLabel13.setText("" + datas.size());
    }
    private ArrayListModel tbl_out_ALM;
    private TbloutModel tbl_out_M;
////    

    private void init_tbl_out() {
        tbl_out_ALM = new ArrayListModel();
        tbl_out_M = new TbloutModel(tbl_out_ALM);
        tbl_stock_out.getTableHeader().
                setPreferredSize(new Dimension(100, 25));

        tbl_stock_out.setModel(tbl_out_M);
        tbl_stock_out.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_out.setRowHeight(25);

        tbl_stock_out.getTableHeader().
                setPreferredSize(new Dimension(100, 25));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {50, 80, 100, 80, 80, 30, 30, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_out, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

//        TableUtility.align_row_to_left(tbl_stock_out, 1);
        TableUtility.align_row_to_right(tbl_stock_out, 3);
        TableUtility.align_row_to_right(tbl_stock_out, 4);
//        TableUtility.align_row_to_Center(tbl_stock_out, 3);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_stock_out.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.NORMAL, 12));
        tbl_stock_out.setRowHeight(25);
        tbl_stock_out.setFont(new java.awt.Font("Arial", 1, 12));
        tbl_stock_out.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        tbl_stock_out.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    private void loadData_out(List<to_add_product> acc) {
//        tbl_out_ALM.clear();
        tbl_out_ALM.addAll(acc);
    }

    public static class TbloutModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Item Code", "Description", "Cost", "Amount", "", "", "is_linient", "w_comm", "amount", "cat_id", "cost"
        };

        public TbloutModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
                case 0:
                    return " " + tt.qty;
                case 1:
                    return " " + tt.name;
                case 2:
                    return " " + tt.desc;
                case 3:
                    return FitIn.fmt_wc_0(tt.cost) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.cost * tt.qty) + " ";
                case 5:
                    return "/POS/icons/new-file.png";
                case 6:
                    return "/POS/icons/remove11.png";
                case 7:
                    return tt.is_linient;
                case 8:
                    return tt.w_commission;
                case 9:
                    return tt.comm_amount;
                case 10:
                    return tt.cat_id;
                default:
                    return tt.cost;
            }
        }
    }

    private void do_edit_out() {

        int idx = tbl_stock_out.getSelectedRow();
        if (idx < 0) {
            return;
        }

        to_add_product to = (to_add_product) tbl_out_ALM.get(idx);
        double qty = to.qty;
        double cost = to.cost;
        int col = tbl_stock_out.getSelectedColumn();

        if (col == 5) {
            Window p = (Window) this;
            Dlg_number21 nd = Dlg_number21.create(p, true);
            nd.setTitle("");
            nd.do_pass(to, qty, cost);

            nd.setCallback(new Dlg_number21.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                    closeDialog.ok();
                    edit(data.qty, data.cost);
                }

                @Override
                public void cancel(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                    int[] idx = tbl_stock_out.getSelectedRows();
                    List rem = new ArrayList();
                    for (int ix : idx) {
                        if (tbl_stock_out.isRowSelected(ix)) {
                            int mx = tbl_stock_out.convertRowIndexToModel(ix);
                            rem.add(tbl_out_ALM.get(mx));
                        }
                    }
                    tbl_out_ALM.removeAll(rem);
                    tbl_out_M.fireTableDataChanged();
                    closeDialog.ok();
                }
            });
            Application.locateOnParentCenter(p, nd);

            nd.setVisible(true);
        }
        if (col == 6) {
            tbl_out_ALM.remove(idx);
            tbl_out_M.fireTableDataChanged();
            count_total();
        }

    }

    private void edit(double qty, double cost) {

        int idx = tbl_stock_out.getSelectedRow();
        if (idx < 0) {
            return;
        }
        to_add_product order = (to_add_product) tbl_out_ALM.get(tbl_stock_out.convertRowIndexToModel(idx));
        order.setQty(qty);
        order.setCost(cost);
        tbl_out_M.fireTableDataChanged();
        count_total();

//
//        tbl_stock_out.getSelectionModel().
//                setSelectionInterval(idx, idx);
//        HelpScrollToView.view(idx, tbl_stock_out);
//        count_total();
    }

    private void stock_out() {
        if (tbl_out_ALM.isEmpty()) {
            return;
        }
        List<to_add_product> datas = tbl_out_ALM;

        String remarks = tf_remarks.getText();
        String branch = "main";
        String branch_id = "0";

        String ref_no = lbl_ref_no.getText();
        int item_count = tbl_out_ALM.size();

        double c = 0;
        for (to_add_product t : datas) {
            c += t.price * t.qty;
        }
        double total_cost = c;
        String date_added = DateType.datetime.format(new Date());

        String user = "";
        String user_id = "";
        if (to_users.get_user() == null) {
            user = "NO";
            user_id = "0";
        } else {
            user = to_users.get_user();
            user_id = S3_insert_new_user.get_id(to_users.get_user());
        }
        String status = "0";

        S1_stock_out.to_stock_out_main t_main = new S1_stock_out.to_stock_out_main(ref_no, item_count, total_cost, date_added, branch, branch_id, user_id, user_id, status);

        if (cb_stock_out.isSelected()) {
            S1_stock_out.stock_out(datas, remarks, branch, branch_id, t_main);
            JOptionPane.showMessageDialog(null, "STOCK OUT");
        }

        if (cb_stock_in.isSelected()) {
//            S3_stockout_usb.save_ending_to_usb(datas);
            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
            JOptionPane.showMessageDialog(null, "STOCK IN");
        }
        if (cb_stock_in_ref.isSelected()) {
//            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
//            JOptionPane.showMessageDialog(null, "STOCK IN");
        }
        if (cb_stock_usb.isSelected()) {
//            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
//            JOptionPane.showMessageDialog(null, "STOCK IN");
        }

        tbl_out_ALM.clear();
        data_employee_search();
        init_ref_no();

        ok1();
    }

    private void stock_in_usb() {
        S3_stockout_usb.get_from_usb();
    }

    private void branches() {
        Window p = (Window) this;
        Dlg_branches nd = Dlg_branches.create(p, true);
        nd.setTitle("");
        nd.do_pass(lbl_branch.getText());
        nd.setCallback(new Dlg_branches.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_branches.OutputData data) {
                closeDialog.ok();
                lbl_branch.setText(data.branch);
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void cb_type2() {
        int row = cb_category1.getItemCount();
        String cat = "zzz";

        if (row != 0) {
            cat = cb_category1.getSelectedItem().
                    toString();
        }

        cb_type1.setModel(new ListComboBoxModel(S1_categories.ret_category_types_for_cb(cat)));
    }

    private void cb_type3() {
        int row = cb_category3.getItemCount();
        String cat = "zzz";

        if (row != 0) {
            cat = cb_category3.getSelectedItem().
                    toString();
        }

        cb_type3.setModel(new ListComboBoxModel(S1_categories.
                ret_category_types_for_cb(cat)));
    }

    private void save_stock_in_out() {

        if (cb_stock_in.isSelected()) {
            int id = 0;
            String ref_no = Stock_in_main.increment_id();
            List<Stock_in_main.to_stock_in_main> nos = Stock_in_main.ret_data(" where ref_no='" + ref_no + "'");
            if (!nos.isEmpty()) {
                ref_no = Stock_in_main.increment_id();
            }

            int item_count = FitIn.toInt(jLabel13.getText());
            double total_cost = FitIn.toDouble(jLabel15.getText());
            String date_added = DateType.datetime.format(new Date());
            String branch = "";
            int branch_id = 0;
            String user_name = to_users.getUser_screen_name();
            int user_id = 0;
            int status = 0;
            String remarks = tf_remarks.getText();
            String supplier = tf_text1.getText();

            final Stock_in_main.to_stock_in_main to = new Stock_in_main.to_stock_in_main(id, ref_no, item_count, total_cost, date_added, branch, branch_id, user_name, user_id, status, remarks, supplier);

            List<to_add_product> items = tbl_out_ALM;
            final List<Stock_in.to_stock_in> to_add = new ArrayList();
            for (to_add_product item : items) {

                String prod_num = item.name;
                String prod_name = item.desc;
                double qty = item.qty;
                double amount = item.price;
                String cashier_name = to.user_name;
                String cashier_id = "" + to.user_id;
                double cost = item.cost;
                String types = item.type_name;
                String types_num = item.type_id;
                String cat_id = item.cat_id;
                String stock_in_no = to.ref_no;
                Stock_in.to_stock_in stock = new Stock_in.to_stock_in(id, prod_num, prod_name, qty, amount, date_added, cashier_name, cashier_id, remarks, branch_id, branch, status, cost, types, types_num, cat_id, stock_in_no, supplier);
                to_add.add(stock);
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();

                    Stock_in_main.add_data(to, to_add);
                    Alert.set(1, "");

                    data_employee_search();
                    ref_no();
                    tbl_out_ALM.clear();
                    jLabel15.setText("0.00");
                    jLabel13.setText("0");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            int id = 0;
            String ref_no = Stock_out_main.increment_id();
            List<Stock_out_main.to_stock_out_main> nos = Stock_out_main.ret_data(" where ref_no='" + ref_no + "'");
            if (!nos.isEmpty()) {
                ref_no = Stock_out_main.increment_id();
            }

            int item_count = FitIn.toInt(jLabel13.getText());
            double total_cost = FitIn.toDouble(jLabel15.getText());
            String date_added = DateType.datetime.format(new Date());
            String branch = "";
            int branch_id = 0;
            String user_name = to_users.getUser_screen_name();
            int user_id = 0;
            int status = 0;
            String remarks = tf_remarks.getText();
            String supplier = tf_text1.getText();

            final Stock_out_main.to_stock_out_main to = new Stock_out_main.to_stock_out_main(id, ref_no, item_count, total_cost, date_added, branch, branch_id, user_name, user_id, status, remarks, supplier);

            List<to_add_product> items = tbl_out_ALM;
            final List<Stock_out.to_stock_out> to_add = new ArrayList();
            for (to_add_product item : items) {

                String prod_num = item.name;
                String prod_name = item.desc;
                double qty = item.qty;
                double amount = item.price;
                String cashier_name = to.user_name;
                String cashier_id = "" + to.user_id;
                double cost = item.cost;
                String types = item.type_name;
                String types_num = item.type_id;
                String cat_id = item.cat_id;
                String stock_out_no = to.ref_no;
                Stock_out.to_stock_out stock = new Stock_out.to_stock_out(id, prod_num, prod_name, qty, amount, date_added, cashier_name, cashier_id, remarks, branch_id, branch, status, cost, types, types_num, cat_id, stock_out_no, supplier);
                to_add.add(stock);
            }
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");

            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();

                    Stock_out_main.add_data(to, to_add);
                    Alert.set(1, "");

                    data_employee_search();
                    ref_no();
                    tbl_out_ALM.clear();
                    jLabel15.setText("0.00");
                    jLabel13.setText("0");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" stock_in_main "> 
    public static ArrayListModel tbl_stock_in_main_ALM;
    public static Tblstock_in_mainModel tbl_stock_in_main_M;

    public static void init_tbl_stock_in_main(JTable tbl_stock_in_main) {
        tbl_stock_in_main_ALM = new ArrayListModel();
        tbl_stock_in_main_M = new Tblstock_in_mainModel(tbl_stock_in_main_ALM);
        tbl_stock_in_main.setModel(tbl_stock_in_main_M);
        tbl_stock_in_main.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_in_main.setRowHeight(25);
        int[] tbl_widths_stock_in_main = {80, 80, 120, 100, 50, 80, 40, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_in_main.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_in_main, i, tbl_widths_stock_in_main[i]);
        }
        Dimension d = tbl_stock_in_main.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_in_main.getTableHeader().setPreferredSize(d);
        tbl_stock_in_main.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_in_main.setRowHeight(25);
        tbl_stock_in_main.setFont(new java.awt.Font("Arial", 0, 12));
        TableUtility.align_row_to_right(tbl_stock_in_main, 5);
    }

    public static void loadData_stock_in_main(List<to_stock_in_main> acc) {
        tbl_stock_in_main_ALM.clear();
        tbl_stock_in_main_ALM.addAll(acc);
    }

    public static class Tblstock_in_mainModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference #", "Date", "Supplier", "Remarks", "Items", "Total Cost", "", "user_name", "user_id", "status", "remarks", "supplier"
        };

        public Tblstock_in_mainModel(ListModel listmodel) {
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
            to_stock_in_main tt = (to_stock_in_main) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.ref_no;
                case 1:
                    return " " + DateType.convert_slash(tt.date_added);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.remarks;
                case 4:
                    return " " + tt.item_count;
                case 5:
                    return FitIn.fmt_wc_0(tt.total_cost) + " ";
                case 6:
                    return " Print";
                case 7:
                    return tt.user_name;
                case 8:
                    return tt.user_id;
                case 9:
                    return tt.status;
                case 10:
                    return tt.remarks;
                default:
                    return tt.supplier;
            }
        }
    }

    private void ret_stock_in() {
        if (jCheckBox1.isSelected()) {
            String where = " where remarks like '%%' ";
            String date_from = DateType.sf.format(jDateChooser1.getDate());
            String date_to = DateType.sf.format(jDateChooser2.getDate());
            if (!jCheckBox3.isSelected()) {
                where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
            }
            where = where + " and ref_no like '%" + tf_search1.getText() + "%' ";
            where = where + " order by id desc ";
            List<to_stock_in_main> datas = Stock_in_main.ret_data(where);
            loadData_stock_in_main(datas);
            double total = 0;
            for (to_stock_in_main to : datas) {
                total += to.total_cost;
            }
            jLabel30.setText(FitIn.fmt_wc_0(total));
            jLabel22.setText("" + datas.size());
        } else {
            ret_stock_out();
        }

    }

    //<editor-fold defaultstate="collapsed" desc=" stock in items ">
    private void set_report_stock_in_items() {

        jProgressBar1.setString("Loading...Please wait...");
        jProgressBar1.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                List<Srpt_stock_in.field> datas = new ArrayList();
                String jrxml = "rpt_stock_in.jrxml";
                String date_from = DateType.sf.format(jDateChooser3.getDate());
                String date_to = DateType.sf.format(jDateChooser4.getDate());

                String cat_id = Stock_in_main.ret_cat_id(cb_category3.getSelectedItem().toString());
                String sub_cat_id = Stock_in_main.ret_sub_cat_id(cb_type3.getSelectedItem().toString());

                if (jCheckBox4.isSelected()) {
                    String where = " where prod_name like '%%' ";
                    if (!cb_is_selected5.isSelected() && !cb_is_selected6.isSelected()) {
                        where = where + " and s.types_num='" + sub_cat_id + "' ";
                    }
                    if (cb_is_selected5.isSelected() && !cb_is_selected6.isSelected()) {
                        where = where + " and s.cat_id='" + cat_id + "' ";
                    }
                    if (!jCheckBox6.isSelected()) {
                        where = where + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                    }
                    where = where + " order by si.prod_name asc ";

                    datas = Srpt_stock_in.ret_data(where);
                } else {
                    String where = " where prod_name like '%%' ";
                    if (!cb_is_selected5.isSelected() && !cb_is_selected6.isSelected()) {
                        where = where + " and s.types_num='" + sub_cat_id + "' ";
                    }
                    if (cb_is_selected5.isSelected() && !cb_is_selected6.isSelected()) {
                        where = where + " and s.cat_id='" + cat_id + "' ";
                    }
                    if (!jCheckBox6.isSelected()) {
                        where = where + " and Date(si.date_added) between '" + date_from + "' and '" + date_to + "' ";
                    }
                    where = where + " order by si.prod_name asc ";
                    datas = Srpt_stock_in.ret_data_out(where);
                    jrxml = "rpt_stock_out.jrxml";
                }

                String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
                String date = DateType.month_date.format(new Date());

                String category = "All";
                String sub_category = "All";
                String printed_by = "Administrator";
                Srpt_stock_in rpt = new Srpt_stock_in(business_name, date, category, sub_category);
                rpt.fields.addAll(datas);

                report_stock_in_items(rpt, jrxml);

                jProgressBar1.setString("Finished...");
                jProgressBar1.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void report_stock_in_items(final Srpt_stock_in to, String jrxml_name) {
        jPanel14.removeAll();
        jPanel14.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_stock_in_items(to, jrxml_name);
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

    public static JRViewer get_viewer_stock_in_items(Srpt_stock_in to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_stock_in_items(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_stock_in_items(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stock_in.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" stock in main report">
    private void select_stock_in_main() {
        int row = tbl_stock_in_main.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_in_main.getSelectedColumn();
        if (col == 6) {
            to_stock_in_main to = (to_stock_in_main) tbl_stock_in_main_ALM.get(row);
            set_report_stock_in_main("" + to.id);

        }
    }

    private void select_stock_out_main() {
        int row = tbl_stock_in_main1.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_stock_in_main1.getSelectedColumn();
        if (col == 6) {
            to_stock_out_main to = (to_stock_out_main) tbl_stock_out_main_ALM.get(row);
            set_report_stock_in_main("" + to.id);

        }
    }

    private void set_report_stock_in_main(final String stock_in_id) {

        jProgressBar3.setString("Loading...Please wait...");
        jProgressBar3.setIndeterminate(true);

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                jTabbedPane2.setSelectedIndex(1);
                Srpt_stock_in_main rpt = null;
                String jrxml = "rpt_stock_in_main.jrxml";
                if (jCheckBox1.isSelected()) {
                    rpt = Srpt_stock_in_main.ret_data(stock_in_id);
                } else {
                    rpt = Srpt_stock_in_main.ret_data_out(stock_in_id);
                    jrxml = "rpt_stock_out_main.jrxml";
                }

                report_stock_in_main(rpt, jrxml);

                jProgressBar3.setString("Finished...");
                jProgressBar3.setIndeterminate(false);
            }
        });
        t.start();

    }

    private void report_stock_in_main(final Srpt_stock_in_main to, String jrxml_name) {
        jPanel20.removeAll();
        jPanel20.setLayout(new BorderLayout());
        try {
            JRViewer viewer = get_viewer_stock_in_main(to, jrxml_name);
            JPanel pnl = new JPanel();
            pnl.add(viewer);
            pnl.setVisible(true);
            pnl.setVisible(true);
            jPanel20.add(viewer);
            jPanel20.updateUI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_stock_in_main(Srpt_stock_in_main to, String rpt_name) {
        try {
            return JasperUtil.getJasperViewer(
                    compileJasper_stock_in_main(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper_stock_in_main(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_stock_in_main.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>
//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" stock out main ">
    public static ArrayListModel tbl_stock_out_main_ALM;
    public static Tblstock_out_mainModel tbl_stock_out_main_M;

    public static void init_tbl_stock_out_main(JTable tbl_stock_out_main) {
        tbl_stock_out_main_ALM = new ArrayListModel();
        tbl_stock_out_main_M = new Tblstock_out_mainModel(tbl_stock_out_main_ALM);
        tbl_stock_out_main.setModel(tbl_stock_out_main_M);
        tbl_stock_out_main.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_out_main.setRowHeight(25);
        int[] tbl_widths_stock_out_main = {80, 80, 120, 100, 50, 80, 40, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_stock_out_main.length; i < n; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_out_main, i, tbl_widths_stock_out_main[i]);
        }
        Dimension d = tbl_stock_out_main.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_stock_out_main.getTableHeader().setPreferredSize(d);
        tbl_stock_out_main.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_stock_out_main.setRowHeight(25);
        tbl_stock_out_main.setFont(new java.awt.Font("Arial", 0, 12));
        TableUtility.align_row_to_right(tbl_stock_out_main, 5);
    }

    public static void loadData_stock_out_main(List<to_stock_out_main> acc) {
        tbl_stock_out_main_ALM.clear();
        tbl_stock_out_main_ALM.addAll(acc);
    }

    public static class Tblstock_out_mainModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Reference #", "Date", "Supplier", "Remarks", "Items", "Total Cost", "", "user_name", "user_id", "status", "remarks", "supplier"
        };

        public Tblstock_out_mainModel(ListModel listmodel) {
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
            to_stock_out_main tt = (to_stock_out_main) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.ref_no;
                case 1:
                    return " " + DateType.convert_slash(tt.date_added);
                case 2:
                    return " " + tt.supplier;
                case 3:
                    return " " + tt.remarks;
                case 4:
                    return " " + tt.item_count;
                case 5:
                    return FitIn.fmt_wc_0(tt.total_cost) + " ";
                case 6:
                    return " Print";
                case 7:
                    return tt.user_name;
                case 8:
                    return tt.user_id;
                case 9:
                    return tt.status;
                case 10:
                    return tt.remarks;
                default:
                    return tt.supplier;
            }
        }
    }

    private void ret_stock_out() {
        String where = " where remarks like '%%' ";
        String date_from = DateType.sf.format(jDateChooser1.getDate());
        String date_to = DateType.sf.format(jDateChooser2.getDate());
        if (!jCheckBox3.isSelected()) {
            where = where + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' ";
        }
        where = where + " and ref_no like '%" + tf_search1.getText() + "%' ";
        where = where + " order by id desc ";
        List<to_stock_out_main> datas = Stock_out_main.ret_data(where);
        loadData_stock_out_main(datas);
        double total = 0;
        for (to_stock_out_main to : datas) {
            total += to.total_cost;
        }
        jLabel30.setText(FitIn.fmt_wc_0(total));
        jLabel22.setText("" + datas.size());
    }
    //</editor-fold>

    private void ref_no() {
        if (cb_stock_in.isSelected()) {
            String no = Stock_in_main.increment_id();
            lbl_ref_no.setText(no);
        } else {
            String no = Stock_out_main.increment_id();
            lbl_ref_no.setText(no);
        }
    }
}
