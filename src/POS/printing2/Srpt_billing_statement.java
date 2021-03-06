/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing2;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Guinness
 */
public class Srpt_billing_statement {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String room_no;
    public final String guess_names;
    public final String print_to;
    public final List<field> fields;
    public final String receipt_footer;
    public final String cashier_name;
    public final String order_no;

    public Srpt_billing_statement(String business_name, String address, String contact_no, String date, String room_no, String guess_names, String print_to, String receipt_footer, String cashier_name, String order_no) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.room_no = room_no;
        this.guess_names = guess_names;
        this.fields = new ArrayList();
        this.print_to = print_to;
        this.receipt_footer = receipt_footer;
        this.cashier_name = cashier_name;
        this.order_no = order_no;
    }

    public static class field {

        public String item_code;
        public String description;
        public String assembly;
        public double qty;
        public double selling_price;
        public double discount;
        public double amount;
        public String datetime;
        public String cat_id;
        public String sub_cat_id;
        public boolean is_selected;
        public String order_no;
        public String table_no_id;
        public String date_added;
        public String guest_id;
        public String guest_name;
        public String user_name;
        public double net_due;
        public int is_add_ons;
        public field() {
        }
        
        public field(String item_code, String description, String assembly, double qty, double selling_price, double discount, double amount, String datetime,
                String cat_id, String sub_cat_id, boolean is_selected,
                String order_no, String table_no_id, String date_added, String guest_id, String guest_name, String user_name,double net_due,int is_add_ons) {
            this.item_code = item_code;
            this.description = description;
            this.assembly = assembly;
            this.qty = qty;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
            this.datetime = datetime;
            this.cat_id = cat_id;
            this.sub_cat_id = sub_cat_id;
            this.is_selected = is_selected;
            this.order_no = order_no;
            this.table_no_id = table_no_id;
            this.date_added = date_added;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.user_name = user_name;
            this.net_due=net_due;
            this.is_add_ons=is_add_ons;
        }

        public int getIs_add_ons() {
            return is_add_ons;
        }

        public void setIs_add_ons(int is_add_ons) {
            this.is_add_ons = is_add_ons;
        }
        
        public String getTable_no_id() {
            return table_no_id;
        }

        public void setTable_no_id(String table_no_id) {
            this.table_no_id = table_no_id;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getGuest_id() {
            return guest_id;
        }

        public void setGuest_id(String guest_id) {
            this.guest_id = guest_id;
        }

        public String getGuest_name() {
            return guest_name;
        }

        public void setGuest_name(String guest_name) {
            this.guest_name = guest_name;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public double getNet_due() {
            return net_due;
        }

        public void setNet_due(double net_due) {
            this.net_due = net_due;
        }
        
        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getSub_cat_id() {
            return sub_cat_id;
        }

        public void setSub_cat_id(String sub_cat_id) {
            this.sub_cat_id = sub_cat_id;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAssembly() {
            return assembly;
        }

        public void setAssembly(String assembly) {
            this.assembly = assembly;
        }

        public Double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        String address = System.getProperty("address", "Dauin, Negros Oriental");
        String contact_no = System.getProperty("contact_no", "1235566");
        String date = "July 23, 2017 08:41 PM";
        String room_no = "DM I (FRONT)";
        String guess_names = "Ronald Pascua, Ronald Pascua";
        String print_to = "";
        String receipt_footer = System.getProperty("receipt_footer", "This is not an Official BIR Receipt");
        String cashier_name = "";
        String order_no = "";
        Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer, cashier_name, order_no);

        for (int i = 0; i < 10; i++) {
            String item_code = "100" + i;
            String description = "Description " + i;
            String assembly = "";
            double qty = i;
            double selling_price = 100 + i;
            double discount = 0;
            double amount = FitIn.toDouble("" + qty) * selling_price;
            String cat_id = "";
            String sub_cat_id = "";
            String order_nos = "";
            String table_no_id = "";
            String date_added = "";
            String guest_id = "";
            String guest_name = "";
            String user_name = "";
            double net_due=0;
            Srpt_billing_statement.field field = new field(item_code, description, assembly, qty, selling_price, discount, amount, "", cat_id, sub_cat_id, true,
                     order_nos, table_no_id, date_added, guest_id, guest_name, user_name,net_due,0);
            rpt.fields.add(field);
        }

        String jrxml = "rpt_billing_statement.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_billing_statement to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static String ret_types_num(String prod_num) {
        String types_num = "";

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + " cat_id"
                    + ",types_num"
                    + " from " + MyDB.getNames() + ".inventory2_stocks_left"
                    + " where product_name='" + prod_num + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {

                types_num = rs.getString(2);
            }
            return types_num;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

}
