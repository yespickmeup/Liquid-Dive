/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.dlg2.Dlg_category;
import POS.dlg2.Dlg_confirm;
import POS.dlg2.Dlg_search_product;
import POS.dlg2.Dlg_type;
import POS.rpt2.rpt_barcode;
import POS.svc3.S10_update_product;
import POS.svc3.S9_add_product;
import POS.svc4.S3_get_qty_price;
import POS.to2.to_add_product;
import POS.utl.TableUtility;
import POS.category_types.S1_categories;
import POS.packages.Dlg_item_packages;
import POS_svc4.S7_uom.to_product_uom;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import POS.utl.Dlg_confirm_action;
import POS_svc4.S7_uom;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Dummy
 */
public class Dlg_inventory extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_add
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
    private Dlg_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_inventory() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_inventory myRef;

    private void setThisRef(Dlg_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Frame) parent, false);
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
            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Dialog) parent, false);
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

        Dlg_inventory dialog = Dlg_inventory.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
//        FullScreen.do_max_normal(dialog);
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
        pop_p_assembly = new javax.swing.JMenuItem();
        pm_is_active = new javax.swing.JCheckBoxMenuItem();
        pm_category = new javax.swing.JMenu();
        pm_package = new javax.swing.JMenuItem();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        jButton2 = new Button.Default();
        jLabel2 = new javax.swing.JLabel();
        tf_barcode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_description = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        cb_is_selected = new javax.swing.JCheckBox();
        cb_is_lenient = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        jButton3 = new Button.Default();
        jButton6 = new Button.Default();
        jButton4 = new Button.Primary();
        jButton5 = new Button.Info();
        jButton1 = new Button.Warning();
        cb_happy_hour = new javax.swing.JCheckBox();
        jButton8 = new Button.Default();
        jButton10 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_search = new Field.Search();
        jLabel7 = new javax.swing.JLabel();
        cb_category1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cb_type1 = new javax.swing.JComboBox();
        cb_is_selected1 = new javax.swing.JCheckBox();
        cb_is_selected2 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        jPopupMenu1.setFocusable(false);
        jPopupMenu1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPopupMenu1FocusLost(evt);
            }
        });

        pop_p_assembly.setText("PRINTING ASSEMBLY");
        pop_p_assembly.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pop_p_assemblyFocusLost(evt);
            }
        });
        pop_p_assembly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pop_p_assemblyActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pop_p_assembly);

        pm_is_active.setSelected(true);
        pm_is_active.setText("Is Active");
        pm_is_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_is_activeActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_is_active);

        pm_category.setText("CATEGORY");
        jPopupMenu1.add(pm_category);

        pm_package.setText("PACKAGE");
        pm_package.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_packageActionPerformed(evt);
            }
        });
        jPopupMenu1.add(pm_package);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("CATEGORY:");

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.setFocusable(false);
        cb_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_categoryMouseClicked(evt);
            }
        });
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("BARCODE:");

        tf_barcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_barcode.setFocusable(false);
        tf_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_barcodeActionPerformed(evt);
            }
        });
        tf_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_barcodeKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Description:");

        tf_description.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descriptionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Price:");

        tf_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cb_is_selected.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected.setSelected(true);
        cb_is_selected.setText("Active/Inactive");

        cb_is_lenient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_lenient.setSelected(true);
        cb_is_lenient.setText("Lenient");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("SUB:");

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_type.setFocusable(false);
        cb_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_typeMouseClicked(evt);
            }
        });
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("New");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Add");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Edit");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cb_happy_hour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_happy_hour.setSelected(true);
        cb_happy_hour.setText("Show on Happy Hour-Staff");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/barcode.png"))); // NOI18N
        jButton8.setText("BARCODE");
        jButton8.setFocusable(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/barcode.png"))); // NOI18N
        jButton10.setText("CODES");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_is_selected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_is_lenient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_happy_hour))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_barcode)
                                .addGap(209, 209, 209))
                            .addComponent(tf_description))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_description, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_lenient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_happy_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("SEARCH:");

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Category:");

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Sub:");

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

        cb_is_selected1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected1.setSelected(true);
        cb_is_selected1.setText("All");
        cb_is_selected1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected1ActionPerformed(evt);
            }
        });

        cb_is_selected2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_is_selected2.setSelected(true);
        cb_is_selected2.setText("All");
        cb_is_selected2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_is_selected2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(tf_search))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_is_selected1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_category1, 0, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_is_selected2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_category1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_type1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_is_selected2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_prodMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_prodMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jLabel9.setText("Total Items:");

        jLabel10.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(11, 11, 11))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Item Maintenance", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Stock In & Out", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Reports", jPanel6);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:

        cb_type();

//        set_category();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        add_prod();
        add_item();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//        update_product();
        update_item();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete_product();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
        ok1();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        add_category();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        if (add_item == 0) {
            category_id = "";
        }
        data_employee_search();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        // TODO add your handling code here:
//        set_category();
//        jPopupMenu1.hide();
        evt.consume();
//        jPopupMenu1.setVisible(false);
//          jPopupMenu1.setFocusable(false);
        select_item();
//        pm_tbl_users(evt);
//        focus();
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void cb_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_categoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryMouseClicked

    private void tbl_prodMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_prodMousePressed

    private void tbl_prodMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_prodMouseReleased

    private void pop_p_assemblyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pop_p_assemblyActionPerformed
        printing_assembly();
    }//GEN-LAST:event_pop_p_assemblyActionPerformed

    private void tf_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_barcodeActionPerformed
        // TODO add your handling code here:
        check_code();
    }//GEN-LAST:event_tf_barcodeActionPerformed

    private void tf_barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_barcodeKeyReleased
//        tf_barcode.selectAll();
    }//GEN-LAST:event_tf_barcodeKeyReleased

    private void cb_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_typeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_typeMouseClicked

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
//        data_employee_category();
    }//GEN-LAST:event_cb_typeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        sub_category();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clear();
        data_employee_category();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tf_descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_descriptionActionPerformed

    private void jPopupMenu1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPopupMenu1FocusLost
        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_jPopupMenu1FocusLost

    private void pop_p_assemblyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pop_p_assemblyFocusLost
        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_pop_p_assemblyFocusLost

    private void pm_is_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_is_activeActionPerformed
        update_active();
    }//GEN-LAST:event_pm_is_activeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        print_barcode();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        do_barcodes();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void pm_packageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_packageActionPerformed
        item_package();
    }//GEN-LAST:event_pm_packageActionPerformed

    private void cb_category1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_category1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_category1MouseClicked

    private void cb_category1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_category1ActionPerformed
        cb_type2();
        data_employee();
    }//GEN-LAST:event_cb_category1ActionPerformed

    private void cb_type1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_type1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_type1MouseClicked

    private void cb_type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_type1ActionPerformed
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_cb_type1ActionPerformed

    private void cb_is_selected1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected1ActionPerformed
        data_employee();
    }//GEN-LAST:event_cb_is_selected1ActionPerformed

    private void cb_is_selected2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_is_selected2ActionPerformed
        data_employee();
    }//GEN-LAST:event_cb_is_selected2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_category;
    private javax.swing.JComboBox cb_category1;
    private javax.swing.JCheckBox cb_happy_hour;
    private javax.swing.JCheckBox cb_is_lenient;
    private javax.swing.JCheckBox cb_is_selected;
    private javax.swing.JCheckBox cb_is_selected1;
    private javax.swing.JCheckBox cb_is_selected2;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JComboBox cb_type1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu pm_category;
    private javax.swing.JCheckBoxMenuItem pm_is_active;
    private javax.swing.JMenuItem pm_package;
    private javax.swing.JMenuItem pop_p_assembly;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField tf_barcode;
    private javax.swing.JTextField tf_description;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
//        Main.MyDB.setNames("db_pos_restaurant_liquid");
        tf_search.grabFocus();
        tf_barcode.setText("" + S7_uom.get_barcode());
        cb_model();
        cb_type();
        init_tbl_baptism();
//        data_employee_category();
        jButton8.setVisible(false);
        jButton10.setVisible(false);
//        jButton9.setVisible(false);
        add_dlg_stockin();
        add_dlg_reports();
    }

    private void add_dlg_stockin() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jPanel5.setLayout(new BorderLayout());
                Dlg_inventory_stockin_out in_out = new Dlg_inventory_stockin_out();
                jPanel5.add(in_out.getSurface());
            }
        });
    }

    private void add_dlg_reports() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jPanel6.setLayout(new BorderLayout());
                Dlg_inventory_reports in_out = new Dlg_inventory_reports();
                jPanel6.add(in_out.getSurface());
            }
        });
    }

    private boolean check_code() {
        boolean j = false;
        if (tf_barcode.getText().
                isEmpty()) {
            return true;
        }
        String if_ok = S3_get_qty_price.get_code(tf_barcode.getText());
        if (if_ok.equals(tf_barcode.getText())) {
//            Prompt.call("Product Already exists");
//            JOptionPane.showMessageDialog(null, "Product Already exists");
            tf_barcode.setText(S7_uom.increment_id());
            tf_barcode.setCaretPosition(0);
            tf_barcode.selectAll();
            j = true;
        } else {
            j = false;
//            JOptionPane.showMessageDialog(null, "Product Already exists");
        }
        return j;

    }

    private void disposed() {
        this.dispose();
    }

    private void add_assembly() {
    }
    int add_item = 0;

    public void do_pass(String cat_name) {
        add_item = 1;
        cb_category.setSelectedItem(cat_name);
        cb_category.setEnabled(true);
        jButton2.setEnabled(true);
//        JOptionPane.showMessageDialog(null, "adadad");
        data_employee_category();
    }

    public void do_pass2(String cat_name, String cat_id, int type_id, String type_name) {
        add_item = 1;

        category_id = cat_id;

//        int s = 0;
//        for (int i = 0; i < cb_category.getItemCount(); i++) {
//            String name = cb_category.getItemAt(i).toString();
//            if (name.equals(cat_name)) {
//                s = i;
//                break;
//            }
//        }
//        JOptionPane.showMessageDialog(null, cat_name + " " + s);
        cb_category.setSelectedItem(cat_name);
        cb_category.setEnabled(false);
        cb_type.setSelectedItem(type_name);
//        cb_category.setEnabled(false);
        jButton2.setEnabled(false);
        data_employee_category();

    }

    private void cb_model() {

        cb_category.setModel(new ListComboBoxModel(S1_categories.
                ret_categories_for_cb()));
        cb_category1.setModel(new ListComboBoxModel(S1_categories.
                ret_categories_for_cb()));
    }

    private void cb_type() {
        int row = cb_category.getItemCount();
        String cat = "zzz";

        if (row != 0) {
            cat = cb_category.getSelectedItem().
                    toString();
        }

        cb_type.setModel(new ListComboBoxModel(S1_categories.
                ret_category_types_for_cb(cat)));
    }

    private void cb_type2() {
        int row = cb_category1.getItemCount();
        String cat = "zzz";

        if (row != 0) {
            cat = cb_category1.getSelectedItem().
                    toString();
        }

        cb_type1.setModel(new ListComboBoxModel(S1_categories.
                ret_category_types_for_cb(cat)));
    }
//    private void cb_type() {
//        int row = cb_category.getItemCount();
//        if (row == 0) {
//            return;
//        }
////        cb_type.setModel(new ListComboBoxModel(S1_categories.ret_category_types_for_cb(cb_category.getSelectedItem().toString())));
//    }

    private void add_prod() {
//
//        if (cb_type.getItemCount() == 0) {
////            return;
//        }

        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);

//        System.setProperty("cashiering_for", "restaurant_w_order_no");
//        Window p = (Window) this;
//        Dlg_add_product2 nd = Dlg_add_product2.create(p, true);
//        nd.setTitle("");
//        nd.do_pass("");
//        nd.setCallback(new Dlg_add_product2.Callback() {
//            
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_add_product2.OutputData data) {
//                closeDialog.ok();
//            }
//        });
//        Center.setCenter(nd);
//        
//        nd.setVisible(true);
        Window p = (Window) this;
        Dlg_add_product2 nd = Dlg_add_product2.create(p, true);
        nd.setTitle("Add Product");
        nd.do_pass();
        nd.setCallback(new Dlg_add_product2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_product2.OutputData data) {
                closeDialog.ok();
                add_product(data.name, data.description, data.price, data.qty, data.remarks, data.supplier, data.vat, data.assemby, data.tt, data.is_linient, data.w_com, data.amount, cat_id, data.cost, data.img_path);

                data_employee_search();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_product(String name, String description, String price, String qty, String remarks, String supp_id, String vat, String assembly, List<to_product_uom> tt, String is_linient, String w_com, double com_amount, String cat_id, double cost, String img_path) {

        String cat = "0";
//        if (cb_type.getItemCount() == 0) {
//            cat = "0";
//        } else {
//            cat = cb_type.getSelectedItem().toString();
//        }

    }

    private void add_item() {

//        boolean c = check_code();
//        if (c) {
//            Prompt.call("ITEM Already Exists");
//            tf_barcode.grabFocus();
//            return;
//        }
        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        final int printing_assembly = S5_printing_assemlby.get_category_assembly_id(cat_id);
        final String barcode = S7_uom.increment_id();
        final String description = tf_description.getText();
        final String price = "" + FitIn.toDouble(tf_price.getText());
        String is_linient = "0";
        if (cb_is_lenient.isSelected()) {
            is_linient = "1";
        }

        int is_active = 0;
        if (cb_is_lenient.isSelected()) {
            is_active = 1;
        }
        int happy_hour = 0;
        if (cb_happy_hour.isSelected()) {
            happy_hour = 1;
        }
        final String is_linient1 = is_linient;
        final int is_active1 = is_active;

        String type_name = cb_type.getSelectedItem().
                toString();
        final String type_name1 = type_name;
        String type_id = S1_categories.ret_type_id(type_name);
        int group_id = S5_printing_assemlby.get_category_group_id(cat_id);
//        JOptionPane.showMessageDialog(null, cat_id);
        final String type_id1 = type_id;
        final int group_id1 = group_id;
        final int happy_hour1 = happy_hour;
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S9_add_product.add(barcode, description, price, "0", "", "none", "", "0", "0", new ArrayList(), is_linient1, "0", 0, cat_id, 0, "", is_active1,
                                   printing_assembly, group_id1, type_name1, type_id1, happy_hour1);
                clear_item();

                category_id = cat_id;
                data_employee_category();
                tf_description.grabFocus();
                ok1();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }

    private void delete_item() {
        int idx = tbl_prod.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_add_product to = (to_add_product) tbl_employee_payroll_ALM.get(tbl_prod.
                convertRowIndexToModel(idx));

        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        String price = "" + FitIn.toDouble(tf_price.getText());
        String is_linient = "0";
        if (cb_is_lenient.isSelected()) {
            is_linient = "1";
        }
        int is_active = 0;
        if (cb_is_selected.isSelected()) {
            is_active = 1;
        }

        to_add_product to1 = new to_add_product(barcode, description, 0, 0, "0", cat_id, is_linient, "0", "0", 0, cat_id, 0, 0, is_active, "", "", "", "", 0);
        S6_items.delete_data(to1);
        clear_item();
        category_id = cat_id;
//        data_employee_search();
        data_employee_category();
        ok1();
    }

    private void clear_item() {
        tf_barcode.setText("" + S7_uom.get_barcode());
        tf_description.setText("");
        tf_price.setText("");
    }
    int selected = 0;

    private void select_item() {
        int idx = tbl_prod.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_add_product to = (to_add_product) tbl_employee_payroll_ALM.get(tbl_prod.
                convertRowIndexToModel(idx));

        tf_barcode.setText("" + to.name);
        tf_description.setText("" + to.desc);
        tf_price.setText("" + to.price);
        cb_category.setSelectedItem(to.category_name);
        cb_type.setSelectedItem(to.type_name);
        if (to.is_active == 0) {
            cb_is_selected.setSelected(false);
        } else {
            cb_is_selected.setSelected(true);
        }

        if (to.is_linient.equals("0")) {
            cb_is_lenient.setSelected(false);
        } else {
            cb_is_lenient.setSelected(true);
        }

        if (to.happy_hour == 0) {
            cb_happy_hour.setSelected(false);
        } else {
            cb_happy_hour.setSelected(true);
        }
        category_id = to.category_id;
        selected = idx;
//        cb_category.setSelectedItem(to.category_name);
//        cb_type.setSelectedItem(to.category_name);

    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void update_item() {
        int idx = tbl_prod.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_add_product to = (to_add_product) tbl_employee_payroll_ALM.get(tbl_prod.
                convertRowIndexToModel(idx));

        String category_name = cb_category.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        String barcode = tf_barcode.getText();
        String description = tf_description.getText();
        double price = FitIn.toDouble(tf_price.getText());
        String is_linient = "0";
        if (cb_is_lenient.isSelected()) {
            is_linient = "1";
        }
        final String is_linient1=is_linient;
        int is_active = 0;
        if (cb_is_selected.isSelected()) {
            is_active = 1;
        }
        final int is_active1=is_active;
        int happy_hour = 0;
        if (cb_happy_hour.isSelected()) {
            happy_hour = 1;
        }
        final int happy_hour1=happy_hour;
        String type_name = cb_type.getSelectedItem().
                toString();
        String type_id = S1_categories.ret_type_id(type_name);
        final String type_id1=type_id;
        final String type_name1=type_name;
        
//        System.out.println(" ***** "+type_name + " = "+type_id);
        final to_add_product to1 = new to_add_product(barcode, description, price, 0, "0", cat_id, is_linient, "0", "0", 0, cat_id, 0, 0, is_active, "", type_id, type_name, "", happy_hour);

        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                S6_items.edit_data(to1, is_linient1, "" + is_active1, type_name1, type_id1, happy_hour1);
                clear_item();

                category_id = cat_id;
                data_employee_category();
                ok1();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);

    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);
        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 30));

        tbl_prod.setModel(tbl_employee_payroll_M);
        tbl_prod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbl_prod.setRowHeight(25);

        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 25));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 300, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 70, 200, 0, 140, 90, 100};
        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_prod, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_left(tbl_prod, 1);
        TableUtility.align_row_to_right(tbl_prod, 2);
        TableUtility.align_row_to_Center(tbl_prod, 3);
        TableUtility.align_row_to_Center(tbl_prod, 7);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_prod.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.NORMAL, 12));
        tbl_prod.setRowHeight(25);
        tbl_prod.setFont(new java.awt.Font("Arial", 1, 12));
        TableWidthUtilities.setColumnRightRenderer(tbl_prod, 2);
    }

    private void loadData_baptism(List<to_add_product> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id", "cost", "printing Assembly", "IS ACTIVE", "CATEGORY", "type id", "SUB", "HAPPy HOUR", "Printing"
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
                    return " " + tt.name;
                case 1:
                    return " " + tt.desc;

                case 2:
                    return FitIn.fmt_wc_0(tt.price) + " ";

                case 3:
                    return " " + tt.qty;
                case 4:
                    return " " + tt.num;
                case 5:
                    return " " + tt.vat;
                case 6:
                    return " " + tt.category_id;
                case 7:
                    return " " + tt.is_linient;
                case 8:
                    return " " + tt.w_commission;
                case 9:
                    return " " + tt.comm_amount;
                case 10:
                    return " " + tt.cat_id;
                case 11:
                    return " " + tt.cost;
                case 12:
                    return " " + tt.printing_assembly;

                case 13:
                    if (tt.is_active == 1) {
                        return " YES";
                    } else {
                        return " NO";
                    }

                case 14:
                    return " " + tt.category_name.toUpperCase();
                case 15:
                    return tt.type_id;
                case 16:
                    return " " + tt.type_name.toUpperCase();
                case 17:
                    if (tt.happy_hour == 1) {
                        return " YES";
                    } else {
                        return " NO";
                    }
                default:
                    if (tt.printing_assembly == 3) {
                        return " Bar and Resto";
                    } else if (tt.printing_assembly == 4) {
                        return " Kitchen";
                    } else {
                        return " ";
                    }

            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
//        int row = cb_type.getItemCount();
//        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }

        String category_name = cb_category1.getSelectedItem().
                toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        category_id = cat_id;
        String name = tf_search.getText();
        String type_name = cb_type1.getSelectedItem().
                toString();
        if (cb_type1.getSelectedItem().
                toString().
                equalsIgnoreCase("NONE")) {
            type_name = "";
        }
//            String type_id = S1_categories.ret_type_id(type_name);
        String where = " where description like '%" + name + "%'   ";
        if (!cb_is_selected1.isSelected()) {
            where = where + " and cat_id = '" + category_id + "' ";
        }
        if (!cb_is_selected2.isSelected()) {
            where = where + " and types like '" + type_name + "' ";
        }

        loadData_baptism(S9_add_product.ret_products_search_category2(where));
    }
    String category_id = "";

    private void data_employee_category() {
        if (cb_category.getItemCount() == 0) {
//            return;
        } else {

        }
//        loadData_baptism(S9_add_product.ret_products_category(cb_category.getSelectedItem().toString(), name, cat_id));
    }

    private void data_employee_search() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
//        int row = cb_type.getItemCount();
//        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }

        String name = tf_search.getText();
        String type_name = cb_type.getSelectedItem().
                toString();
        String type_id = S1_categories.ret_type_id(type_name);
        loadData_baptism(S9_add_product.ret_products_search_like(category_id, name));
    }

    private void set_category() {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String type_id = "";

        String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();
        type_id = tbl_prod.getModel().
                getValueAt(row, 6).
                toString();
        String id = type_id;
        String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
//        JOptionPane.showMessageDialog(null, type_id);
        type_id = S10_update_product.get_category_name(type_id);

        String cat_name = S10_update_product.get_category_id(id);
//       

        cat_name = S10_update_product.get_class_name(cat_name);

        cb_category.setSelectedItem(cat_name);
//        cb_type.setSelectedItem(type_id);
        System.out.println(cat_name + " - " + type_id);

        List<to_add_product> datas = tbl_employee_payroll_ALM;

        int i = 0;

        for (to_add_product to : datas) {

            if (to.num.equals(num)) {
                System.out.println(to.num + " - " + num);
                break;
            }
            i++;
        }
        System.out.println(i);
        tbl_prod.setColumnSelectionInterval(0, i);

    }

    private void update_product() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        String name = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        String desc = tbl_prod.getModel().
                getValueAt(row, 1).
                toString();
        String price = tbl_prod.getModel().
                getValueAt(row, 2).
                toString();
        String qty = tbl_prod.getModel().
                getValueAt(row, 3).
                toString();
        String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();
        String category_type = tbl_prod.getModel().
                getValueAt(row, 6).
                toString();
        String is_linient = tbl_prod.getModel().
                getValueAt(row, 7).
                toString();
        String w_comm = tbl_prod.getModel().
                getValueAt(row, 8).
                toString();
        double comm_amount = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 9).
                toString());
        double cost = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 11).
                toString());

        String cat_id = tbl_prod.getModel().
                getValueAt(row, 10).
                toString();
        Window p = (Window) this;
        Dlg_Menu_update_product nd = Dlg_Menu_update_product.create(p, true);
        nd.setTitle("");
        nd.pass(num, name, desc, price, qty, vat, category_type, is_linient, w_comm, comm_amount, cat_id, cost);
        nd.setCallback(new Dlg_Menu_update_product.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_Menu_update_product.OutputData data) {
//                closeDialog.ok();
                data_employee_search();
                ok1();
            }

            @Override
            public void o2(CloseDialog closeDialog, Dlg_Menu_update_product.OutputData data) {
                closeDialog.ok();
                update_types(data.barcode, data.types, data.types_num, data.cat_id, data.assemble);
                data_employee_search();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_types(String id, String types, String types_num, String cat_id, String assembly) {
        S10_update_product.add_types(id, types, types_num, cat_id, assembly);
    }

    private void delete_product() {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String num = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass();
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete_item();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void delete(String num) {
        S10_update_product.do_delete_product(num);

        ok1();
    }

//    private void ok1() {
//
//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//        }
//    }
    private void add_category() {
        Window p = (Window) this;
        Dlg_category nd = Dlg_category.create(p, true);
        nd.setTitle("Prompt");

        nd.setCallback(new Dlg_category.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_category.OutputData data) {
//                closeDialog.ok();
                cb_model();
//                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_type() {
        Window p = (Window) this;
        Dlg_type nd = Dlg_type.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass(cb_category.getSelectedItem().
                toString());
        nd.setCallback(new Dlg_type.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_type.OutputData data) {
//                closeDialog.ok();
                cb_type();
                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void print_barcode() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        final String name = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        final String desc = tbl_prod.getModel().
                getValueAt(row, 1).
                toString();
        final double price = Double.parseDouble(tbl_prod.getModel().
                getValueAt(row, 2).
                toString());
        final String qty = tbl_prod.getModel().
                getValueAt(row, 3).
                toString();
        final String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();

        Executor.doExecute(this, new Executor.Task() {

                       @Override
                       public void work_on() {
                           rpt_barcode.print_barcode("", name, desc, price);
                       }
                   });
    }

    private void do_barcodes() {
        Window p = (Window) this;
        Dlg_search_product nd = Dlg_search_product.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_search_product.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_search_product.OutputData data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void stock_in_out() {
        Window p = (Window) this;
        Dlg_inventory_stockin_out nd = Dlg_inventory_stockin_out.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_inventory_stockin_out.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_inventory_stockin_out.OutputData data) {
//                closeDialog.ok();
                data_employee_search();
            }
        });
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        nd.setSize(xSize, ySize);
        nd.setVisible(true);
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {

            jPopupMenu1.removeAll();
            pm_category.removeAll();
            jPopupMenu1.add(pop_p_assembly);
            jPopupMenu1.add(pm_is_active);

            int row = tbl_prod.getSelectedRow();
            if (row < 0) {
                return;
            }
            to_add_product to2 = (to_add_product) tbl_employee_payroll_ALM.get(row);
            String is_active = (tbl_prod.getModel().
                    getValueAt(row, 13).
                    toString());
            if (is_active.equals("YES")) {
                pm_is_active.setSelected(true);
            } else {
                pm_is_active.setSelected(false);
            }
            final String num = to2.num;
            final int print_assembly = FitIn.toInt(tbl_prod.getModel().
                    getValueAt(row, 12).
                    toString());

            final int cat_id = FitIn.toInt(tbl_prod.getModel().
                    getValueAt(row, 10).
                    toString());
//            JOptionPane.showMessageDialog(null, cat_id);
            final int type_id = FitIn.toInt(tbl_prod.getModel().
                    getValueAt(row, 15).
                    toString());
            final String category = tbl_prod.getModel().
                    getValueAt(row, 14).
                    toString();
            final String type = tbl_prod.getModel().
                    getValueAt(row, 16).
                    toString();

            JMenu jm = new javax.swing.JMenu();
            jm.setText("ASSEMBLY");

            List<S5_printing_assemlby.to_printing_assembly> datas = new ArrayList();

            datas = S5_printing_assemlby.ret_data("");

            for (final S5_printing_assemlby.to_printing_assembly to : datas) {
                final JCheckBoxMenuItem p = new javax.swing.JCheckBoxMenuItem();
                p.setText(to.place);

                if (to.id == print_assembly) {
//                    JOptionPane.showMessageDialog(null, to.id);
                    p.setSelected(true);
                } else {
                    p.setSelected(false);
                }
                p.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        S5_printing_assemlby.update_printing_assembly_item(num, to.id);
//                        System.out.println(to.id + " = " + print_assembly + " = " + to.place + " ," + num);
//                        data_employee_category();
                        data_employee();
                    }
                });
                jm.add(p);
            }
            List<String> categories = new ArrayList();
            categories = S1_categories.ret_categories_for_cb();
            for (final String cat : categories) {
                JMenu c = new JMenu(cat);
//                System.out.println("");
                int j = 0;
                if (cat.equalsIgnoreCase(category)) {
                    c.setSelected(true);
                    Icon im1 = new ImageIcon(this.getClass().
                            getResource("/POS/mini_icons/award_star_gold.png"));
                    c.setIcon(im1);
                    j = 1;
                }

                List<String> t = new ArrayList();
                t = S1_categories.ret_category_types_for_cb(cat);
                for (final String s : t) {
                    JCheckBoxMenuItem types = new JCheckBoxMenuItem(s);
                    if (j == 1) {
                        if (s.equalsIgnoreCase(type)) {
                            types.setSelected(true);
                            Icon im1 = new ImageIcon(this.getClass().
                                    getResource("/POS/mini_icons/award_star_gold.png"));
                            types.setIcon(im1);
                        }
                    }
                    types.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            final S6_items.to_types to = S6_items.select_type(cat, s);
                            S6_items.edit_type(num, to.cat_id, s, "" + to.type_id);
                            data_employee_category();
                        }
                    });
                    c.add(types);
                }
                pm_category.add(c);

            }

            jPopupMenu1.add(pm_category);
            jPopupMenu1.add(jm);
            jPopupMenu1.add(pm_package);
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void printing_assembly() {
        Window p = (Window) this;
        Dlg_printing_assembly nd = Dlg_printing_assembly.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_printing_assembly.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_printing_assembly.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void sub_category() {
        Window p = (Window) this;
        Dlg_type nd = Dlg_type.create(p, true);
        nd.setTitle("");
        nd.do_pass(cb_category.getSelectedItem().
                toString());
        nd.setCallback(new Dlg_type.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_type.OutputData data) {
//                closeDialog.ok();
                cb_type();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    private void clear() {
        tf_description.setText("");
        tf_price.setText("");
        tf_barcode.setText("" + S7_uom.get_barcode());
        tf_description.grabFocus();
        cb_is_selected.setSelected(true);
        cb_is_lenient.setSelected(true);
    }

    private void focus() {
        if (jPopupMenu1.hasFocus()) {
            JOptionPane.showMessageDialog(null, "adadad");
        }
    }

    private void update_active() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        String num = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        String active = "0";
//        int is_active = 0;
//        if (cb_is_selected.isSelected()) {
//            is_active = 1;
//        }

        if (pm_is_active.isSelected()) {
//            JOptionPane.showMessageDialog(null, "adadad");
            active = "1";
        } else {
            active = "0";
        }

//        JOptionPane.showMessageDialog(null, active + " "+num);
        S6_items.edit_data_active(num, active);
        clear();
        data_employee_category();
    }

    private void item_package() {

        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_add_product to = (to_add_product) tbl_employee_payroll_ALM.get(tbl_prod.
                convertRowIndexToModel(row));
        Window p = (Window) this;
        Dlg_item_packages nd = Dlg_item_packages.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.name, to.desc, to.item_package_id);
        nd.setCallback(new Dlg_item_packages.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_item_packages.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
}
