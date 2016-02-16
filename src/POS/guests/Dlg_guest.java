/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main;
import POS.dlg.country.S1_countries;
import POS.guests.S1_guest.to_guests;
import POS.staff_discount.S1_staff_discount;
import POS.tables.S1_table_types;
import POS.utl.Prompt;
import POS.utl.TableUtility;
import POS_svc4.S2_search;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author Dummy
 */
public class Dlg_guest extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_guest
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

        public final List<to_guests> to1;
        public final double percentages;
        public final List<S2_search.to_items> items;

        public OutputData(List<to_guests> to1, double percentages, List<S2_search.to_items> items) {
            this.to1 = to1;
            this.percentages = percentages;
            this.items = items;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_guest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_guest(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_guest() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_guest myRef;

    private void setThisRef(Dlg_guest myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_guest> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_guest create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_guest create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_guest dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_guest((java.awt.Frame) parent, false);
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
            Dlg_guest dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_guest((java.awt.Dialog) parent, false);
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

        Dlg_guest dialog = Dlg_guest.create(new javax.swing.JFrame(), true);
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

        pm_add = new javax.swing.JPopupMenu();
        pm_a = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_guests = new javax.swing.JTable();
        tf_search = new Field.Search();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_email_address = new javax.swing.JTextField();
        tf_s_lname = new javax.swing.JTextField();
        tf_s_fname = new javax.swing.JTextField();
        tf_s_mi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_s_county = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        lbl_i_id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_level = new javax.swing.JTextField();
        tf_contact = new javax.swing.JTextField();
        tf_contact_name = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_passport = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cb_how = new javax.swing.JComboBox();
        tf_remarks = new javax.swing.JTextField();
        cx_updates = new javax.swing.JCheckBox();
        jButton5 = new Button.Default();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Info();
        jButton3 = new Button.Warning();
        jButton4 = new Button.Default();
        cb_staff = new javax.swing.JCheckBox();
        tf_discount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_rate = new javax.swing.JLabel();
        lbl_room1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        cb_rate_type = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_add = new javax.swing.JTable();
        lbl_room = new javax.swing.JLabel();
        btn_walkin = new Button.Default();
        btn_ok = new Button.Success();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        pm_a.setText("ADD");
        pm_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_aActionPerformed(evt);
            }
        });
        pm_add.add(pm_a);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tbl_guests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_guests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_guestsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_guestsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_guests);

        tf_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Search:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("First Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Last Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Email Address:");

        tf_email_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_email_address.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_s_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_s_lname.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_s_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_s_fname.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_s_mi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_s_mi.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("M.I.:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Country:");

        cb_s_county.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_s_county.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("ID No.:");

        lbl_i_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_i_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_i_id.setText("00000001");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Diver's Certifiied Level:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Emergency Contact No.:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Emergency Contact Name:");

        tf_level.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_level.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        tf_contact_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_contact_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Passport No:");

        tf_passport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_passport.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Remarks:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("How did you know?");

        cb_how.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_how.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Friends?", "Love Ones?", "Advertisement?", "Web?", "Dont Know" }));

        tf_remarks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_remarks.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        cx_updates.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cx_updates.setSelected(true);
        cx_updates.setText("Automatic Updates?");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Clear");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cb_staff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_staff.setText("Staff?");
        cb_staff.setEnabled(false);
        cb_staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_staffActionPerformed(evt);
            }
        });

        tf_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_discount.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_discount.setText("0");
        tf_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_discountActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("%");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Discount:");

        lbl_rate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rate.setText("0.00");
        lbl_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_room1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_room1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_room1.setText("ACCOMODATIONS");
        lbl_room1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_items);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("RATE:");

        cb_rate_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_rate_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_rate_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_rate_typeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("RATE TYPE:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_contact_name, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(tf_contact))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_level, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cb_how, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_passport)
                                        .addComponent(cb_s_county, 0, 285, Short.MAX_VALUE))
                                    .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(lbl_rate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_room1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cb_rate_type, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 80, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_s_fname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_s_lname, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(tf_s_mi)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cb_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cx_updates, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_room1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(cb_rate_type)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_s_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_s_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_s_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(cx_updates, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_staff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_s_county, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_level, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_passport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_how, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tbl_add.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_addMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_add);

        lbl_room.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_room.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_room.setText("Added Guest/s");
        lbl_room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_walkin.setText("WALK-IN");
        btn_walkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_walkinActionPerformed(evt);
            }
        });

        btn_ok.setText("OK");
        btn_ok.setFocusable(false);
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        jLabel18.setText("Total No. of Customers:");

        jLabel19.setText("0");

        jLabel20.setText("Total No. of Customers Added:");

        jLabel21.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_walkin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_walkin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_room, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_guestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMouseClicked
        // TODO add your handling code here:
        select(evt);
    }//GEN-LAST:event_tbl_guestsMouseClicked

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        ret_data();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        ok1();
    }//GEN-LAST:event_btn_okActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_guestsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_guestsMousePressed

    private void tbl_guestsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_guestsMouseReleased

    private void pm_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_aActionPerformed
        add_guest();
    }//GEN-LAST:event_pm_aActionPerformed

    private void btn_walkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_walkinActionPerformed
        add_walkin();
    }//GEN-LAST:event_btn_walkinActionPerformed

    private void cb_rate_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_rate_typeActionPerformed
        get_rate();
    }//GEN-LAST:event_cb_rate_typeActionPerformed

    private void cb_staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_staffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_staffActionPerformed

    private void tf_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_discountActionPerformed
        edit_discount();
    }//GEN-LAST:event_tf_discountActionPerformed

    private void tbl_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_addMouseClicked
        remove_list(evt);
    }//GEN-LAST:event_tbl_addMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_walkin;
    private javax.swing.JComboBox cb_how;
    private javax.swing.JComboBox cb_rate_type;
    private javax.swing.JComboBox cb_s_county;
    private javax.swing.JCheckBox cb_staff;
    private javax.swing.JCheckBox cx_updates;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_i_id;
    private javax.swing.JLabel lbl_rate;
    private javax.swing.JLabel lbl_room;
    private javax.swing.JLabel lbl_room1;
    private javax.swing.JMenuItem pm_a;
    private javax.swing.JPopupMenu pm_add;
    private javax.swing.JTable tbl_add;
    private javax.swing.JTable tbl_guests;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_contact_name;
    private javax.swing.JTextField tf_discount;
    private javax.swing.JTextField tf_email_address;
    private javax.swing.JTextField tf_level;
    private javax.swing.JTextField tf_passport;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_s_fname;
    private javax.swing.JTextField tf_s_lname;
    private javax.swing.JTextField tf_s_mi;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        Main.MyDB.setNames("db_pos_restaurant");

//        btn_ok.setVisible(false);
        jLabel8.setVisible(false);
        cb_rate_type.setVisible(false);
        jLabel15.setVisible(false);
        lbl_rate.setVisible(false);
        cb_rate_type.setVisible(false);
        lbl_room1.setVisible(false);
        jScrollPane3.setVisible(false);
        jLabel8.setVisible(false);
        jLabel15.setVisible(false);
        tf_search.grabFocus();
        set_discount();
        set_country();
        init_key();
        init_id();
        init_tbl_guests();
//        init_tbl_customer_tables_details();
//        load_data();
        ret_data();
        init_tbl_add();
        init_room();
        get_rate();
    }

    private void init_room() {
        cb_rate_type.setModel(new ListComboBoxModel(S1_table_types.ret_cb_data()));
    }

    private void set_discount() {
        
//        tf_discount.setText(FitIn.fmt_wc_0(S1_staff_discount.ret_data()));
    }

    private void edit_discount() {
        double discount = FitIn.toDouble(tf_discount.getText());
//        JOptionPane.showMessageDialog(null, discount);
        S1_staff_discount.edit_data(discount);
        Prompt.call("Discount Updated");
    }

    private void get_rate() {
        lbl_rate.setText("" + S1_table_types.ret_data(cb_rate_type.
                getSelectedItem().
                toString()));
    }

    private void set_country() {
        List<String> countries = S1_countries.ret_cb_data();

//        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            String name = locale.getDisplayCountry();
//            
//            if (!"".equals(name)) {
//                countries.add(name);
//            }
//        }
//        for (String s : countries) {
//            int id = -1;
//            String country = s;
//            String capital = "";
//            S1_countries.to_countries to = new S1_countries.to_countries(id, country, capital);
////            S1_countries.add_country(to);
//        }
        cb_s_county.setEditable(true);
        AutoCompleteDecorator.decorate(cb_s_county);
        cb_s_county.setModel(new ListComboBoxModel(countries));
    }

    private void init_id() {
        lbl_i_id.setText(S1_guest.get_id());
    }

    public void do_pass(String version, String room_no, String type, double percentage, String table_name) {

        set_discount();
        lbl_room.setVisible(true);
        btn_ok.setVisible(true);
        jScrollPane2.setVisible(true);
        String versions = System.getProperty("version", "ordering");
        if (versions.equals("ordering")) {
            lbl_room.setText("TABLE " + table_name);
        } else {
//            lbl_room.setText("ROOM " + table_name);
        }
        cb_rate_type.setSelectedItem(type);
        lbl_rate.setText("" + percentage);

        if (version.equals("resto")) {
            btn_walkin.setVisible(false);

        }
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
//-- 
    private ArrayListModel tbl_guests_ALM;
    private TblguestsModel tbl_guests_M;

    private void init_tbl_guests() {
        tbl_guests_ALM = new ArrayListModel();
        tbl_guests_M = new TblguestsModel(tbl_guests_ALM);
        tbl_guests.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_guests.setModel(tbl_guests_M);
        tbl_guests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guests.setRowHeight(25);
//        tbl_guests.setAutoResizeMode(0);
        int[] tbl_widths_guests = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0};
        for (int i = 0, n = tbl_widths_guests.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guests, i, tbl_widths_guests[i]);
        }
        Dimension d = tbl_guests.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_guests.getTableHeader().
                setPreferredSize(d);
        tbl_guests.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_guests.setRowHeight(25);
        tbl_guests.setFont(new java.awt.Font("Arial", 0, 12));

    }

    private void loadData_guests(List<to_guests> acc) {
        tbl_guests_ALM.clear();
        tbl_guests_ALM.addAll(acc);
    }

    public static class TblguestsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "ID", "guest_id", "FIRST NAME", "LAST NAME", "MI", "Name", "EMAIL ADDRESS", "status", "DIVER'S LEVEL", "CONTACT NO", "EM. CONTACT NAME", "PASSPORT NO", "REMARKS", "HOW", "UPDATES", "NAME", "Staff", "CREDIT"
        };

        public TblguestsModel(ListModel listmodel) {
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
            to_guests tt = (to_guests) getRow(row);
            switch (col) {
                case 0:
                    return "" + tt.id;
                case 1:
                    return tt.guest_id;
                case 2:
                    return tt.fname;
                case 3:
                    return tt.lname;
                case 4:
                    return tt.mi;
                case 5:
                    return " " + tt.fname + " " + tt.mi + " " + tt.lname;
                case 6:
                    return tt.email_address;
                case 7:
                    return tt.status;
                case 8:
                    return tt.diver_cert_lvl;
                case 9:
                    return tt.contact_no;
                case 10:
                    return tt.emergency_contact_name;
                case 11:
                    return tt.passport_no;
                case 12:
                    return tt.remarks;
                case 13:
                    return tt.how;

                case 14:
                    return tt.newsletter;

                case 15:
                    if (tt.staff == 0) {
                        return " No";
                    } else {
                        return " Yes";
                    }
                case 16:
                    if (tt.staff == 0) {
                        return " No";
                    } else {
                        return " Yes";
                    }
                default:
//                    if (tt.staff == 0) {
//                        return "NO";
//                    } else {
//                        return "YES";
//                    }
                    return tt.credit;

            }
        }
    }

    private void ret_data() {
        loadData_guests(S1_guest.ret_data(tf_search.getText()));
        jLabel19.setText("" + tbl_guests_ALM.size());
    }

    private void add() {
        int id = 0;
        String guest_id = S1_guest.get_id();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_how.getSelectedItem().
                toString();
        int newsletter = 0;

        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        int staff = 0;
        if (cb_staff.isSelected()) {
            staff = 1;
        }

        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name
                , passport_no, remarks, how, newsletter, staff, 0);

        S1_guest.add_guest(to);
        ret_data();
        clear();
//        JOptionPane.showMessageDialog(null, "Successfully Added");
    }

    private void clear() {
        tf_email_address.setText("");
        tf_s_fname.setText("");
        tf_s_lname.setText("");
        tf_s_mi.setText("");
        ids = 0;
        tf_contact.setText("");
        tf_contact_name.setText("");
        tf_level.setText("");
        tf_passport.setText("");
        tf_remarks.setText("");
        cx_updates.setSelected(true);
//        tf_s_mi.setText("");
        init_id();
    }
    int ids = 0;

    private void select(MouseEvent e) {
        if (e.getClickCount() == 2) {
            add_guest();
        } else {
            int row = tbl_guests.getSelectedRow();
            if (row < 0) {
                return;
            }
            to_guests to = (to_guests) tbl_guests_ALM.get(tbl_guests.
                    convertRowIndexToModel(row));
            ids = to.id;

            String guest_id = "" + to.guest_id;
            String fname = to.fname;
            String lname = to.lname;
            String mi = to.mi;
            String country = to.country;

            String email_address = to.email_address;
            int status = to.status;

            String diver_cert_lvl = to.diver_cert_lvl;
            String contact_no = to.contact_no;
            String emergency_contact_name = to.emergency_contact_name;
            String passport_no = to.passport_no;
            String remarks = to.remarks;
            String how = to.how;
            String newsletter = "" + to.newsletter;
            String staff = "" + to.staff;
            if (newsletter.equals("1")) {
                cx_updates.setSelected(true);
            } else {
                cx_updates.setSelected(false);
            }

            if (to.staff == 1) {
                cb_staff.setSelected(true);
            } else {
                cb_staff.setSelected(false);
            }

            lbl_i_id.setText("" + guest_id);
            tf_s_fname.setText(fname);
            tf_s_lname.setText(lname);
            tf_s_mi.setText(mi);

            tf_email_address.setText(email_address);
            tf_contact.setText(contact_no);
            tf_contact_name.setText(emergency_contact_name);
            tf_passport.setText(passport_no);
            tf_remarks.setText(remarks);
            cb_how.setSelectedItem(how);
            tf_level.setText(diver_cert_lvl);
            jLabel21.setText("" + tbl_add_ALM.size());
            cb_s_county.setSelectedItem(country);
            cb_s_county.updateUI();

        }

    }

    private void edit() {
        int id = ids;
        String guest_id = lbl_i_id.getText();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_s_county.getSelectedItem().
                toString();

        int newsletter = 0;
        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        int staff = 0;
        if (cb_staff.isSelected()) {
            staff = 1;
        }
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter, staff, 0);

        S1_guest.edit_guest(to, lbl_i_id.getText());
        ret_data();
        clear();
        JOptionPane.showMessageDialog(null, "Successfully Updated");
    }

    private void delete() {
        int id = 0;
        String guest_id = lbl_i_id.getText();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_s_county.getSelectedItem().
                toString();

        int newsletter = 0;
        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        int staff = 0;
        if (cb_staff.isSelected()) {
            staff = 1;
        }
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter, staff, 0);

        S1_guest.delete_guest(to, ids);
        ret_data();
        clear();
    }

    private void ok1() {

        if (tbl_add_ALM.isEmpty()) {
            Prompt.call("ADD GUEST/S");
            return;
        }
        double per = FitIn.toDouble(lbl_rate.getText());

        List<S2_search.to_items> results = new ArrayList();
        int[] idx = tbl_items.getSelectedRows();
        if (idx.length < 0) {

        } else {
            for (int i = 0; i < idx.length; i++) {
                final S2_search.to_items to = (S2_search.to_items) tbl_customer_tables_details_ALM. get(tbl_items.convertRowIndexToModel(i));
                results.add(to);
            }
        }

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(tbl_add_ALM, per, results));
        }
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_add.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void add_guest() {
        int row = tbl_guests.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_guests to = (to_guests) tbl_guests_ALM.get(tbl_guests.
                convertRowIndexToModel(row));
        int id = to.id;
        String guest_id = to.guest_id;
        String fname = to.fname;
        String lname = to.lname;
        String mi = to.mi;
        String country = to.country;
        String email_address = to.email_address;
        int status = to.status;
        String diver_cert_lvl = to.diver_cert_lvl;
        String contact_no = to.contact_no;
        String emergency_contact_name = to.emergency_contact_name;
        String passport_no = to.passport_no;
        String remarks = to.remarks;
        String how = to.how;
        int newsletter = to.newsletter;

        String staffs = "" + to.staff;

        int staff = 0;

        to_guests to1 = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter, staff, 0);
        List<to_guests> datas = new ArrayList();
        datas.add(to1);
        loadData_add(datas);
        jLabel21.setText("" + tbl_add_ALM.size());
    }

    private void remove_list(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            int[] idx = tbl_add.getSelectedRows();
            List rem = new ArrayList();
            for (int ix : idx) {
                if (tbl_add.isRowSelected(ix)) {
                    int mx = tbl_add.convertRowIndexToModel(ix);
                    rem.add(tbl_add_ALM.get(mx));
                }
            }
            tbl_add_ALM.removeAll(rem);
            tbl_add_M.fireTableDataChanged();
            jLabel21.setText("" + tbl_add_ALM.size());
        }
    }

    private void add_walkin() {
        int id = -1;
        String guest_id = "-1";
        String fname = "Walk-In";
        String lname = "";
        String mi = "";
        String country = "";
        String email_address = "";
        int status = 0;
        String diver_cert_lvl = "0";
        String contact_no = "0";
        String emergency_contact_name = "0";
        String passport_no = "0";
        String remarks = "0";
        String how = "0";
        int newsletter = 0;
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter, 0, 0);
        List<to_guests> datas = new ArrayList();
        datas.add(to);
        loadData_add(datas);
        ok1();
    }
    private ArrayListModel tbl_add_ALM;
    private TbladdModel tbl_add_M;

    private void init_tbl_add() {
        tbl_add_ALM = new ArrayListModel();
        tbl_add_M = new TbladdModel(tbl_add_ALM);
        tbl_add.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_add.setModel(tbl_add_M);
        tbl_add.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_add.setRowHeight(25);
//        tbl_add.setAutoResizeMode(0);
        int[] tbl_widths_guests = {0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40};
        for (int i = 0, n = tbl_widths_guests.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_add, i, tbl_widths_guests[i]);
        }
        Dimension d = tbl_add.getTableHeader().
                getPreferredSize();
        d.height = 25;
        tbl_add.getTableHeader().
                setPreferredSize(d);
        tbl_add.getTableHeader().
                setFont(new java.awt.Font("Arial", 0, 12));
        tbl_add.setRowHeight(25);
        tbl_add.setFont(new java.awt.Font("Arial", 0, 12));
    }

    private void loadData_add(List<to_guests> acc) {
//        tbl_add_ALM.clear();
        tbl_add_ALM.addAll(acc);
    }

    public static class TbladdModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "guest_id", "FIRST NAME", "LAST NAME", "MI", "Name", "EMAIL ADDRESS", "status", "DIVER'S LEVEL", "CONTACT NO", "EM. CONTACT NAME", "PASSPORT NO", "REMARKS", "HOW", "UPDATES", "Staff"
        };

        public TbladdModel(ListModel listmodel) {
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
            to_guests tt = (to_guests) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.guest_id;
                case 2:
                    return tt.fname;
                case 3:
                    return tt.lname;
                case 4:
                    return tt.mi;
                case 5:
                    return " " + tt.fname + " " + tt.mi + " " + tt.lname;
                case 6:
                    return tt.email_address;
                case 7:
                    return tt.status;
                case 8:
                    return tt.diver_cert_lvl;
                case 9:
                    return tt.contact_no;
                case 10:
                    return tt.emergency_contact_name;
                case 11:
                    return tt.passport_no;
                case 12:
                    return tt.remarks;
                case 13:
                    return tt.how;
                case 14:
                    return tt.newsletter;
                default:
                    if (tt.staff == 0) {
                        return " No";
                    } else {
                        return " Yes";
                    }

            }
        }
    }
    private ArrayListModel tbl_customer_tables_details_ALM;
    private Tblcustomer_tables_detailsModel tbl_customer_tables_details_M;

    private void init_tbl_customer_tables_details() {
        tbl_customer_tables_details_ALM = new ArrayListModel();
        tbl_customer_tables_details_M = new Tblcustomer_tables_detailsModel(tbl_customer_tables_details_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_customer_tables_details_M);
        tbl_items.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);
        int amount = 0;
//        if (my_order == 1) {
//            amount = 100;
//        }
        int[] tbl_widths_customer_tables_details = {0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customer_tables_details.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_customer_tables_details[i]);
        }
        TableUtility.align_row_to_Center(tbl_items, 2);
        TableUtility.align_row_to_Center(tbl_items, 4);
        TableUtility.align_column_to_Center(tbl_items, 2);
        TableUtility.align_column_to_Center(tbl_items, 4);
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
        tbl_items.setRowHeight(35);
        tbl_items.setFont(new java.awt.Font("Arial", 1, 12));

    }

    private void loadData_customer_tables_details(List<S2_search.to_items> acc) {
        tbl_customer_tables_details_ALM.clear();
        tbl_customer_tables_details_ALM.addAll(acc);
    }

    public static class Tblcustomer_tables_detailsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "name", "uom", "QTY", "DESCRIPTION", "PRICE", "img_path", "AMOUNT", "guest_id", "cat_id", "category_name", "printing_assembly", "status", "disc_name", "disc_rate", "discount", "customer_name", "customer_id", "customer_address"
        };

        public Tblcustomer_tables_detailsModel(ListModel listmodel) {
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
            S2_search.to_items tt = (S2_search.to_items) getRow(row);
            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.uom;
                case 2:
                    return FitIn.toInt("" + tt.qty);
                case 3:
                    return tt.desc;
                case 4:
                    return FitIn.fmt_wc_0(tt.price);
                case 5:
                    return tt.img_path;
                case 6:
                    return FitIn.fmt_wc_0(tt.qty * tt.price);
                case 7:
                    return tt.guest_id;
                case 8:
                    return tt.cat_id;
                case 9:
                    return tt.category_name;
                case 10:
                    return tt.printing_assembly;
                case 11:
                    return tt.status;
                case 12:
                    return tt.disc_name;
                case 13:
                    return tt.disc_rate;
                case 14:
                    return tt.discount;
                case 15:
                    return tt.customer_name;
                case 16:
                    return tt.customer_id;
                default:
                    return tt.customer_address;
            }
        }
    }

    private void load_data() {
        List<S2_search.to_items> results = new ArrayList();

        results = S2_search.ret_items("11", "", "1", 0);
        loadData_customer_tables_details(results);
    }
}
