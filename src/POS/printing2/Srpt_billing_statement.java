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

    public Srpt_billing_statement(String business_name, String address, String contact_no, String date, String room_no, String guess_names, String print_to, String receipt_footer) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.room_no = room_no;
        this.guess_names = guess_names;
        this.fields = new ArrayList();
        this.print_to = print_to;
        this.receipt_footer = receipt_footer;
    }

    public static class field {

        String item_code;
        String description;
        String assembly;
        String qty;
        double selling_price;
        double discount;
        double amount;
        String datetime;
        String cat_id;
        String sub_cat_id;

        public field() {
        }

        public field(String item_code, String description, String assembly, String qty, double selling_price, double discount, double amount, String datetime, String cat_id, String sub_cat_id) {
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

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
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
        Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names, print_to, receipt_footer);

        for (int i = 0; i < 10; i++) {
            String item_code = "100" + i;
            String description = "Description " + i;
            String assembly = "";
            String qty = "" + i;
            double selling_price = 100 + i;
            double discount = 0;
            double amount = FitIn.toDouble(qty) * selling_price;
            String cat_id = "";
            String sub_cat_id = "";
            Srpt_billing_statement.field field = new field(item_code, description, assembly, qty, selling_price, discount, amount, "", cat_id, sub_cat_id);
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
