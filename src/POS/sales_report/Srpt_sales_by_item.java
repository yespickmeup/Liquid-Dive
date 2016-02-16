/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales_report;

import POS.my_reports.Srpt_sales_category.to_receipt_items;
import POS.utl.MyConnection1;
import POS.voider.S1_void_table_orders.to_customer_tables_details;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ronald
 */
public class Srpt_sales_by_item {

    public final List<field> fields;
    public final String date;
    public final String busi_name;

    public Srpt_sales_by_item(String date, String busi_name) {
        this.fields = new ArrayList();
        this.date = date;
        this.busi_name = busi_name;
    }

    public static class field {

        String description;
        double unit_price;
        double qty;
        double amount;

        public field() {
        }

        public field(String description, double unit_price, double qty, double amount) {
            this.description = description;
            this.unit_price = unit_price;
            this.qty = qty;
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(double unit_price) {
            this.unit_price = unit_price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {

        List<Srpt_sales_by_item.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_sales_by_item.field s = new Srpt_sales_by_item.field("trans", 100, 100, 100);
            fields.add(s);
        }

        String date = "dadad";
        String business_name = System.getProperty("busi_name", "Liquid Dive");

        Srpt_sales_by_item rpt = new Srpt_sales_by_item(date, business_name);
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_by_item.jrxml";
            InputStream is = Srpt_sales_by_item.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_by_item to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }

    public static List<to_receipt_items> ret_data(String search, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_id"
                    + ",product_name"
                    + ",unit_price"
                    + ",qty"
                    + ",type_name"
                    + ",cat_name"
                    + ",description"
                    + ",disc_name"
                    + ",disc_rate"
                    + ",discount"
                    + ",customer_name"
                    + ",customer_id"
                    + ",customer_address"
                    + ",group_id"
                    + ",date_added"
                    + ",nights"
                    + ",user_name"
                    + " from db_pos_restaurant.receipt_items where "
                    + " product_name = '" + search + "' "
                    + " and date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_id = rs.getString(2);
                String product_name = rs.getString(3);
                double unit_price = rs.getDouble(4);
                double qty = rs.getDouble(5);
                String type_name = rs.getString(6);
                String cat_name = rs.getString(7);
                String description = rs.getString(8);
                String disc_name = rs.getString(9);
                double disc_rate = rs.getDouble(10);
                double discount = rs.getDouble(11);
                double customer_name = rs.getDouble(12);
                String customer_id = rs.getString(13);
                String customer_address = rs.getString(14);
                int group_id = rs.getInt(15);
                String date_added = rs.getString(16);
                int nights = rs.getInt(17);
                String user_name = rs.getString(18);

                to_receipt_items to = new to_receipt_items(id, receipt_id, product_name, unit_price, qty, type_name, cat_name, description, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, group_id, date_added, nights, user_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipt_items> ret_data_ordered(String search, String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",table_no_id"
                    + ",or_no"
                    + ",qty"
                    + ",product_name"
                    + ",description"
                    + ",price"
                    + ",img_path"
                    + ",status"
                    + ",guest_id"
                    + ",guest_name"
                    + ",cat_id"
                    + ",date_added"
                    + ",printing_assembly"
                    + ",disc_name"
                    + ",disc_rate"
                    + ",discount"
                    + ",customer_name"
                    + ",customer_id"
                    + ",customer_address"
                    + ",user_lvl"
                    + ",group_id"
                    + ",check_out"
                    + ",nights"
                    + ",guest_no"
                    + ",room_guest_id"
                    + ",user_name"
                    + ",category_name"
                    + ",sub_category_name"
                    + ",sub_category_id"
                    + " from db_pos_restaurant.customer_tables_details where "
                    + " description like '%" + search + "%' "
                    + " and date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_no_id = rs.getString(2);
                String or_no = rs.getString(3);
                double qty = rs.getDouble(4);
                String product_name = rs.getString(5);
                String description = rs.getString(6);
                double price = rs.getDouble(7);
                String img_path = rs.getString(8);
                int status = rs.getInt(9);
                String guest_id = rs.getString(10);
                String guest_name = rs.getString(11);
                String cat_id = rs.getString(12);
                String date_added = rs.getString(13);
                int printing_assembly = rs.getInt(14);
                String disc_name = rs.getString(15);
                double disc_rate = rs.getDouble(16);
                double discount = rs.getDouble(17);
                String customer_name = rs.getString(18);
                String customer_id = rs.getString(19);
                String customer_address = rs.getString(20);
                String user_lvl = rs.getString(21);
                int group_id = rs.getInt(22);
                String check_out = rs.getString(23);
                int nights = rs.getInt(24);
                int guest_no = rs.getInt(25);
                int room_guest_id = rs.getInt(26);
                String user_name = rs.getString(27);
                String category_name = rs.getString(28);
                String sub_category_name = rs.getString(29);
                String sub_category_id = rs.getString(30);

                to_receipt_items to = new to_receipt_items(id, or_no, product_name, price, qty, ""
                        , category_name, description, disc_name, disc_rate, discount, 0
                        , customer_id, customer_address, group_id, date_added, nights, user_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

}
