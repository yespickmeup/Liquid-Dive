/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.pnl;

import POS.inventory2_stocks_left.Inventory2_stocks_left;
import POS.users.Users;
import POS.pnl_ordering.Ordering;
import POS.printing2.Dlg_print_orders;
import POS.printing2.Srpt_billing_statement;
import POS.to.to_users;
import POS.utl.DateType;
import POS_svc4.S2_search;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
import org.jfree.ui.Align;
import synsoftech.fields.Button;
import test.Dlg_check_liquid;

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
        setUndecorated(false);
        initComponents();
        myInit();
    }

    private Dlg_print_orders_by_date(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(false);
        initComponents();
        myInit();
    }

    public Dlg_print_orders_by_date() {
        super();
        setUndecorated(false);
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tables2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bank = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date to:");

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Preview");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tables2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_tables2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tables2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_tables2);

        jLabel5.setText("Total no. of rows:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Net Due:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("0.00");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Amount Due:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("0.00");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("0.00");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Discount:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Bar:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("0.00");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("0.00");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Restaurant:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

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
        tbl_bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bankMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bank);

        jLabel3.setText("Total no. of rows:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("0");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
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
            .addGap(0, 255, Short.MAX_VALUE)
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
            .addGap(0, 251, Short.MAX_VALUE)
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
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
        ret_order_nos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bankMouseClicked
        select_order();
    }//GEN-LAST:event_tbl_bankMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        set_order();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_tables2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tables2MouseClicked
        select_list_order();
    }//GEN-LAST:event_tbl_tables2MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnl_report;
    private javax.swing.JTable tbl_bank;
    private javax.swing.JTable tbl_tables2;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_bank(tbl_bank);
        init_tbl_tables2(tbl_tables2);
        ret_users();
        
    }
    static List<Users.to_users> users = new ArrayList();

    private void ret_users() {
        users = Users.ret_data("");
    }
    List<S2_search.to_items> my_orders = new ArrayList();

    private void set_order() {
        List<Srpt_billing_statement.field> list_orders = tbl_bank_ALM;
        String order_no = "";
        List<String> order_nos = new ArrayList();
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
        List<Srpt_billing_statement.field> datas_bar = new ArrayList();
        List<Srpt_billing_statement.field> datas_kitchen = new ArrayList();

        List<Ordering.orders> orders = tbl_tables2_ALM;
        String order_nos1 = "";
        int i = 0;
        for (Ordering.orders o : orders) {
//            System.out.println(o.order_no);
            if (o.is_selected) {
                if (i == 0) {
                    order_nos1 = o.order_no;
                } else {
                    order_nos1 = order_nos1 + "," + o.order_no;
                }
                i++;
            }
        }
        if (!order_nos1.isEmpty()) {

            String where = " where order_no in (" + order_nos1 + ") and guest_id in (" + guest_ids + ") group by order_no,product_name order by id asc ";
            List<Srpt_billing_statement.field> list = Ordering.ret_data_sum(where);
            for (Srpt_billing_statement.field field : list) {
                if (field.cat_id.equalsIgnoreCase("12")) {
                    datas_bar.add(field);
                }
                if (field.cat_id.equalsIgnoreCase("10")) {
                    datas_kitchen.add(field);
                }
            }
        }

        for (Srpt_billing_statement.field f : list_orders) {
            String where = " where product_name='" + f.item_code + "' ";
            List<Inventory2_stocks_left.to_inventory2_stocks_left> items = Inventory2_stocks_left.ret_data(where);
            if (!items.isEmpty()) {
                Inventory2_stocks_left.to_inventory2_stocks_left item = (Inventory2_stocks_left.to_inventory2_stocks_left) items.get(0);
                String sub_cat_id = item.types_num;
                for (String s : l_types_no_wo_qty) {
                    if (sub_cat_id.equalsIgnoreCase(s)) {
                        f.setIs_add_ons(1);

                    }
                }
            }
        }

        for (Srpt_billing_statement.field f : datas_bar) {
            String where = " where product_name='" + f.item_code + "' ";
            List<Inventory2_stocks_left.to_inventory2_stocks_left> items = Inventory2_stocks_left.ret_data(where);
            if (!items.isEmpty()) {
                Inventory2_stocks_left.to_inventory2_stocks_left item = (Inventory2_stocks_left.to_inventory2_stocks_left) items.get(0);
                String sub_cat_id = item.types_num;
                for (String s : l_types_no_wo_qty) {
                    if (sub_cat_id.equalsIgnoreCase(s)) {
                        f.setIs_add_ons(1);
                    }
                }
            }
        }

        for (Srpt_billing_statement.field f : datas_kitchen) {
            String where = " where product_name='" + f.item_code + "' ";
            List<Inventory2_stocks_left.to_inventory2_stocks_left> items = Inventory2_stocks_left.ret_data(where);
            if (!items.isEmpty()) {
                Inventory2_stocks_left.to_inventory2_stocks_left item = (Inventory2_stocks_left.to_inventory2_stocks_left) items.get(0);
                String sub_cat_id = item.types_num;
                for (String s : l_types_no_wo_qty) {
                    if (sub_cat_id.equalsIgnoreCase(s)) {
                        f.setIs_add_ons(1);
                    }
                }
            }
        }

        String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        String address = System.getProperty("address", "Dauin, Negros Oriental");
        String contact_no = System.getProperty("contact_no", "1235566");
        String date = DateType.datetime2.format(new Date());
        String room_no = table_names;
        String print_to = "";
        String receipt_footer = System.getProperty("receipt_footer", "This is not an Official BIR Receipt");
        String cashier_name = to_users.getUser_screen_name();
        Srpt_billing_statement rpt_billing_statement = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer, cashier_name, order_no);
        rpt_billing_statement.fields.addAll(list_orders);
        Srpt_billing_statement rpt_billing_statement_bar = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer, cashier_name, order_no);
        rpt_billing_statement_bar.fields.addAll(datas_bar);
        Srpt_billing_statement rpt_billing_statement_kitchen = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer, cashier_name, order_no);
        rpt_billing_statement_kitchen.fields.addAll(datas_kitchen);

        jLabel4.setText("" + list_orders.size());

        init_report_billing_statement(rpt_billing_statement);
        init_report_billing_stab_bar_and_resto(rpt_billing_statement_bar);
        init_report_billing_stab_kitchen(rpt_billing_statement_kitchen);
        jTabbedPane1.setSelectedIndex(1);
    }

    String guess_names = "";
    String table_names = "";

    String table_no_ids = "";
    String guest_ids = "";

    public void do_pass(List<S2_search.to_items> orders, String table_name, String guess_name, List<Dlg_check_liquid.to_guests> guest) {

        String guest_id = "";
        String table_no_id = "";
        int i = 0;
        for (Dlg_check_liquid.to_guests g : guest) {
            table_no_id = "" + g.table_id;
            if (i == 0) {
                guest_id = "" + g.id;
            } else {
                guest_id = guest_id + "," + g.id;
            }
            i++;
        }
        table_no_ids = table_no_id;
        guest_ids = guest_id;

        my_orders = orders;
        guess_names = guess_name;
        table_names = table_name;
//       
        ret_order_nos();
    }

    private void ret_order_nos() {

        String where = " where table_no_id='" + table_no_ids + "' and guest_id in (" + guest_ids + ") and status=0 and cat_id in (10,12) group by order_no order by order_no,description asc ";

        if (!jCheckBox1.isSelected()) {
            String date_from = DateType.sf.format(jDateChooser1.getDate());
            String date_to = DateType.sf.format(jDateChooser2.getDate());
            where = " where table_no_id='" + table_no_ids + "' and guest_id in (" + guest_ids + ") and status=0 and cat_id in (10,12) "
                    + " and Date(date_added) between '" + date_from + "' and '" + date_to + "' group by order_no order by description asc ";

        }
        tbl_bank_ALM.clear();

        List<Ordering.orders> list_of_orders = Ordering.ret_orders(where);
        loadData_tables2(list_of_orders);
        compute_total();
    }

    private void compute_total() {
        List<Ordering.orders> list_of_orders = tbl_tables2_ALM;
        jLabel6.setText("" + list_of_orders.size());
        double amount = 0;
        double discount = 0;
        double net_due = 0;
        double bar = 0;
        double resto = 0;
        for (Ordering.orders order : list_of_orders) {
            if (order.is_selected) {
                amount += order.amount_due;
                discount += order.line_discount;
                net_due += order.net_due;
            }
        }
        jLabel10.setText(FitIn.fmt_wc_0(amount));
        jLabel11.setText(FitIn.fmt_wc_0(discount));
        jLabel8.setText(FitIn.fmt_wc_0(net_due));
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

    public void init_tbl_bank(JTable tbl_bank) {
        tbl_bank_ALM = new ArrayListModel();
        tbl_bank_M = new TblbankModel(tbl_bank_ALM);
        tbl_bank.setModel(tbl_bank_M);
        tbl_bank.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_bank.setRowHeight(25);
        int[] tbl_widths_bank = {40, 50, 100, 60, 50, 60, 0, 0};
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
        TableColumn tc = tbl_bank.getColumnModel().getColumn(7);
        tc.setCellEditor(tbl_bank.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_bank.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));
    }

    //<editor-fold defaultstate="collapsed" desc=" listener ">
    class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_bank.getRowCount(); x < y; x++) {
                tbl_bank.setValueAt(checked, x, 0);
            }
        }
    }

    class CheckBoxHeader extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(new java.awt.Color(204, 204, 204));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
                    rendererComponent.setOpaque(true);
                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {
            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column1 = tableView.convertColumnIndexToModel(viewColumn);
                if (viewColumn == this.column && e.getClickCount() == 1 && column1 != -1) {
                    doClick();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((JTableHeader) e.getSource()).repaint();
            List<Srpt_billing_statement.field> datas = tbl_bank_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (Srpt_billing_statement.field to : datas) {
                to.setIs_selected(selected);
            }
            e.consume();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //</editor-fold>
    public static void loadData_bank(List<Srpt_billing_statement.field> acc) {
        tbl_bank_ALM.clear();
        tbl_bank_ALM.addAll(acc);
    }

    public static class TblbankModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Qty", "Code", "Description", "Price", "Discount", "Amount", "Date", ""
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
            if (col == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Srpt_billing_statement.field tt = (Srpt_billing_statement.field) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.getQty();
                case 1:
                    return " " + tt.getItem_code();
                case 2:
                    return " " + tt.getDescription();
                case 3:
                    return FitIn.fmt_wc_0(tt.getSelling_price()) + " ";
                case 4:
                    return FitIn.fmt_wc_0(tt.getDiscount()) + " ";
                case 5:
                    return FitIn.fmt_wc_0(tt.getNet_due()) + " ";
                case 6:
                    return " " + DateType.convert_slash3(tt.getDatetime());

                default:
                    return tt.isIs_selected();
            }
        }
    }

    private void select_order() {
        int row = tbl_bank.getSelectedRow();
        if (row < 0) {
            return;
        }
        int col = tbl_bank.getSelectedColumn();
        if (col == 7) {
            Srpt_billing_statement.field to = (Srpt_billing_statement.field) tbl_bank_ALM.get(row);
            if (to.isIs_selected()) {
                to.setIs_selected(false);
            } else {
                to.setIs_selected(true);
            }
            tbl_bank_M.fireTableDataChanged();
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

    //<editor-fold defaultstate="collapsed" desc=" Table Orders ">
    //<editor-fold defaultstate="collapsed" desc=" tables2 "> 
    public static ArrayListModel tbl_tables2_ALM;
    public static Tbltables2Model tbl_tables2_M;

    public void init_tbl_tables2(JTable tbl_tables2) {
        tbl_tables2_ALM = new ArrayListModel();
        tbl_tables2_M = new Tbltables2Model(tbl_tables2_ALM);
        tbl_tables2.setModel(tbl_tables2_M);
        tbl_tables2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables2.setRowHeight(25);
        int[] tbl_widths_tables2 = {100, 60, 150, 80, 50, 80, 60, 80, 30};
        for (int i = 0, n = tbl_widths_tables2.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables2, i, tbl_widths_tables2[i]);
        }
        Dimension d = tbl_tables2.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_tables2.getTableHeader().setPreferredSize(d);
        tbl_tables2.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_tables2.setRowHeight(25);
        tbl_tables2.setFont(new java.awt.Font("Arial", 0, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_tables2, 5);
        TableWidthUtilities.setColumnRightRenderer(tbl_tables2, 6);
        TableWidthUtilities.setColumnRightRenderer(tbl_tables2, 7);

        TableColumn tc = tbl_tables2.getColumnModel().getColumn(8);
        tc.setCellEditor(tbl_tables2.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tbl_tables2.getDefaultRenderer(Boolean.class));
        tc.setHeaderRenderer(new CheckBoxHeader2(new MyItemListener2()));
    }

    //<editor-fold defaultstate="collapsed" desc=" checkbox  ">
    class MyItemListener2 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Object source = e.getSource();
            if (source instanceof AbstractButton == false) {
                return;
            }
            boolean checked = e.getStateChange() == ItemEvent.SELECTED;
            for (int x = 0, y = tbl_bank.getRowCount(); x < y; x++) {
                tbl_bank.setValueAt(checked, x, 0);
            }
        }
    }

    class CheckBoxHeader2 extends JCheckBox
            implements TableCellRenderer, MouseListener {

        protected CheckBoxHeader2 rendererComponent;
        protected int column;
        protected boolean mousePressed = false;

        public CheckBoxHeader2(ItemListener itemListener) {
            rendererComponent = this;
            rendererComponent.addItemListener(itemListener);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    rendererComponent.setForeground(header.getForeground());
                    rendererComponent.setBackground(new java.awt.Color(230, 230, 230));
                    rendererComponent.setHorizontalAlignment(Align.CENTER);
                    rendererComponent.setOpaque(true);
                    header.addMouseListener(rendererComponent);
                }
            }
            setColumn(column);
            rendererComponent.setText("");
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return rendererComponent;
        }

        protected void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }

        protected void handleClickEvent(MouseEvent e) {
            if (mousePressed) {
                mousePressed = false;
                JTableHeader header = (JTableHeader) (e.getSource());
                JTable tableView = header.getTable();
                TableColumnModel columnModel = tableView.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int column1 = tableView.convertColumnIndexToModel(viewColumn);
                if (viewColumn == this.column && e.getClickCount() == 1 && column1 != -1) {
                    doClick();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            handleClickEvent(e);
            ((JTableHeader) e.getSource()).repaint();
            List<Ordering.orders> datas = tbl_tables2_ALM;
            boolean selected = false;
            if (this.isSelected()) {
                selected = true;
            }
            for (Ordering.orders to : datas) {
                to.setIs_selected(selected);
            }

            e.consume();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //</editor-fold>
    public static void loadData_tables2(List<Ordering.orders> acc) {
        tbl_tables2_ALM.clear();
        tbl_tables2_ALM.addAll(acc);
    }

    public static class Tbltables2Model extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Order #", "Table No", "Date", "Added By", "Item/s", "Amount Due", "Discount", "Net Due", ""
        };

        public Tbltables2Model(ListModel listmodel) {
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
            if (col == 8) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Ordering.orders tt = (Ordering.orders) getRow(row);
            String user = "";
            for (Users.to_users u : users) {
                if (u.user_name.equalsIgnoreCase(tt.user_name)) {
                    user = u.user_code;
                    break;
                }
            }
            switch (col) {
                case 0:
                    return " " + tt.order_no;
                case 1:
                    return " " + tt.table_no_id;
                case 2:
                    return " " + DateType.convert_slash3(tt.date_added);
                case 3:
                    return " " + user;
                case 4:
                    return " " + tt.no_of_items;
                case 5:
                    return FitIn.fmt_wc_0(tt.amount_due) + " ";
                case 6:
                    return FitIn.fmt_wc_0(tt.line_discount) + " ";
                case 7:
                    return FitIn.fmt_wc_0(tt.net_due) + " ";
                default:
                    return tt.is_selected;
            }
        }
    }
//</editor-fold> 

    //</editor-fold>
    private void select_list_order() {
        int row = tbl_tables2.getSelectedRow();
        if (row < 0) {
            return;
        }
        Ordering.orders order = (Ordering.orders) tbl_tables2_ALM.get(row);
        int col = tbl_tables2.getSelectedColumn();
        if (col == 8) {
            if (order.is_selected) {
                order.setIs_selected(false);
            } else {
                order.setIs_selected(true);
            }
            tbl_tables2_M.fireTableDataChanged();
            get_items();
        }
    }

    private void get_items() {
        List<Ordering.orders> orders = tbl_tables2_ALM;
        String guest_id = "";
        String order_no = "";
        int i = 0;
        for (Ordering.orders o : orders) {
            if (o.is_selected) {
                if (i == 0) {

                    order_no = o.order_no;
                } else {
                    order_no = order_no + "," + o.order_no;
                }
                i++;
            }
        }
        if (order_no.isEmpty()) {
            tbl_bank_ALM.clear();
            jLabel4.setText("0");
        } else {
            String where = " where order_no in (" + order_no + ")  and guest_id in (" + guest_ids + ") ";
            List<Srpt_billing_statement.field> list = Ordering.ret_data(where);
            loadData_bank(list);
            jLabel4.setText("" + list.size());
            double bar = 0;
            double resto = 0;
            for (Srpt_billing_statement.field f : list) {
                if (f.cat_id.equals("10")) {
                    resto += f.net_due;
                }
                if (f.cat_id.equals("12")) {
                    bar += f.net_due;
                }
            }
            jLabel14.setText(FitIn.fmt_wc_0(bar));
            jLabel15.setText(FitIn.fmt_wc_0(resto));
            compute_total();
        }

    }
}
