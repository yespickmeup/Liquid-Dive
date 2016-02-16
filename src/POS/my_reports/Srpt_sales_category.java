/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.my_reports;

import POS.Main.MyDB;
import POS.my_reports.Srpt_sales_category_accomodation.field;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Maytopacka
 */
public class Srpt_sales_category {

    public final String SUBREPORT_DIR;
    public final String busi_name;
    public final String date;
    public final double total;
    public final List<Srpt_sales_category_accomodation.field> rpt_sales_category_accomodation;
    public final List<Srpt_sales_category_accomodation.field> rpt_sales_category_bar;
    public final List<Srpt_sales_category_accomodation.field> rpt_sales_category_restaurant;
    public final List<Srpt_sales_category_accomodation.field> rpt_sales_category_others;

    public Srpt_sales_category(
            String SUBREPORT_DIR, String busi_name, String date, double total, List<field> rpt_sales_category_accomodation, List<field> rpt_sales_category_bar, List<field> rpt_sales_category_restaurant, List<field> rpt_sales_category_others) {
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.busi_name = busi_name;
        this.date = date;
        this.total = total;
        this.rpt_sales_category_accomodation = rpt_sales_category_accomodation;
        this.rpt_sales_category_bar = rpt_sales_category_bar;
        this.rpt_sales_category_restaurant = rpt_sales_category_restaurant;
        this.rpt_sales_category_others = rpt_sales_category_others;
    }

    public static class to_receipt_items {

        public final int id;
        public final String receipt_id;
        public final String product_name;
        public final double unit_price;
        public final double qty;
        public final String type_name;
        public final String cat_name;
        public final String description;
        public final String disc_name;
        public final double disc_rate;
        public final double discount;
        public final double customer_name;
        public final String customer_id;
        public final String customer_address;
        public final int group_id;
        public final String date_added;
        public final int nights;
        public final String user_name;

        public to_receipt_items(int id, String receipt_id, String product_name, double unit_price, double qty, String type_name, String cat_name, String description, String disc_name, double disc_rate, double discount, double customer_name, String customer_id, String customer_address, int group_id, String date_added, int nights, String user_name) {
            this.id = id;
            this.receipt_id = receipt_id;
            this.product_name = product_name;
            this.unit_price = unit_price;
            this.qty = qty;
            this.type_name = type_name;
            this.cat_name = cat_name;
            this.description = description;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_address = customer_address;
            this.group_id = group_id;
            this.date_added = date_added;
            this.nights = nights;
            this.user_name = user_name;
        }
    }

    public static class to_receipts {

        public final int id;
        public final int cashier_session_id;
        public final double tendered;
        public final String or_number;
        public final int receipt_status;
        public final String receipt_date;
        public final double discount;
        public final double credit;
        public final String approval_code;
        public final String member_id;
        public final String is_payed;
        public final double dollar;
        public final double credit_dollar;
        public final double dollar_rate;
        public final double peso;
        public final String user_name;
        public final String guest_ids;
        public final String guest_names;
        public final String room_guest_ids;
        public final String table_id;
        public final String table_name;
        public final double gross_sales;
        public final double bank_php;
        public final double bank_usd;
        public final double credit_card;

        public to_receipts(int id, int cashier_session_id, double tendered, String or_number, int receipt_status, String receipt_date, double discount, double credit, String approval_code, String member_id, String is_payed, double dollar, double credit_dollar, double dollar_rate, double peso, String user_name, String guest_ids, String guest_names, String room_guest_ids, String table_id, String table_name, double gross_sales, double bank_php, double bank_usd, double credit_card) {
            this.id = id;
            this.cashier_session_id = cashier_session_id;
            this.tendered = tendered;
            this.or_number = or_number;
            this.receipt_status = receipt_status;
            this.receipt_date = receipt_date;
            this.discount = discount;
            this.credit = credit;
            this.approval_code = approval_code;
            this.member_id = member_id;
            this.is_payed = is_payed;
            this.dollar = dollar;
            this.credit_dollar = credit_dollar;
            this.dollar_rate = dollar_rate;
            this.peso = peso;
            this.user_name = user_name;
            this.guest_ids = guest_ids;
            this.guest_names = guest_names;
            this.room_guest_ids = room_guest_ids;
            this.table_id = table_id;
            this.table_name = table_name;
            this.gross_sales = gross_sales;
            this.bank_php = bank_php;
            this.bank_usd = bank_usd;
            this.credit_card = credit_card;
        }
    }

    public List<field> getRpt_sales_category_others() {
        return rpt_sales_category_others;
    }

    public List<field> getRpt_sales_category_restaurant() {
        return rpt_sales_category_restaurant;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public String getBusi_name() {
        return busi_name;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    public List<field> getRpt_sales_category_accomodation() {
        return rpt_sales_category_accomodation;
    }

    public List<field> getRpt_sales_category_bar() {
        return rpt_sales_category_bar;
    }

    public static Srpt_sales_category get_sales_summary(String date_from, String date_to) {
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Ronald\\") + "img_templates\\rpt_sales_report\\";
        String busi_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        Date d = new Date();
        Date f = new Date();
        try {
            d = DateType.sf.parse(date_from);
            f = DateType.sf.parse(date_to);
        } catch (ParseException ex) {
            Logger.getLogger(Srpt_sales_category.class.getName()).log(Level.SEVERE, null, ex);
        }

        String date = DateType.dash.format(d) + " - " + DateType.dash.format(f);

        //doh
        double total = 0;
        List<Srpt_sales_category_accomodation.field> rpt_sales_category_accomodation = new ArrayList();
        List<Srpt_sales_category_accomodation.field> rpt_sales_category_bar = new ArrayList();
        List<Srpt_sales_category_accomodation.field> rpt_sales_category_restaurant = new ArrayList();
        List<Srpt_sales_category_accomodation.field> rpt_sales_category_others = new ArrayList();
        String where_accom = " where date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name='" + "accommodation" + "'"
                + " group by description,price,discount "
                + " order by category_name asc";
        List<to_receipt_items> datas = ret_where(where_accom);

        String where_bar = " where date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name='" + "Bar" + "'"
                + " group by description,price,discount "
                + " order by category_name asc";
        List<to_receipt_items> bar = ret_where(where_bar);

        String where_restaurant = " where date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name='" + "Restaurant" + "'"
                + " group by description,price,discount "
                + " order by category_name asc";
        List<to_receipt_items> restaurant = ret_where(where_restaurant);
        String where_others = " where "
                + " date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name<>'" + "Bar" + "' "
                + " or date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name<>'" + "accommodation" + "' "
                + " or date(date_added) between '" + date_from + "' and '" + date_to + "' and category_name<>'" + "Restaurant" + "' "
                + " group by description,price,discount "
                + " order by category_name asc";
        List<to_receipt_items> others = ret_where(where_others);

        for (to_receipt_items to : datas) {
            if (to.cat_name.equals("accommodation")) {
                String category_name = "ACCOMODATION";
                double qty = to.qty;
                double price = to.unit_price / qty;
                String description = to.description + " - " + FitIn.fmt_wc_0(to.unit_price);

                double amount = to.unit_price * qty;
                double total_amount = 1000;
                Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
                rpt_sales_category_accomodation.add(tf);
                total += amount;
            }
        }

        for (to_receipt_items to : bar) {
            if (to.cat_name.equals("Bar")) {
                String category_name = "BAR";
                double total_amount = 1000;
                double qty = to.qty;
                String description = to.description;
                double price = to.unit_price;
                double amount = to.unit_price * qty;
                Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
                rpt_sales_category_bar.add(tf);
                total += amount;
            }

        }
        for (to_receipt_items to : restaurant) {
            if (to.cat_name.equals("Restaurant")) {
                String category_name = "RESTAURANT";
                double total_amount = 1000;
                double qty = to.qty;
                String description = to.description;
                double price = to.unit_price;
                double amount = to.unit_price * qty;
                Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
                rpt_sales_category_restaurant.add(tf);
                total += amount;
            }

        }

        for (to_receipt_items to : others) {
            if (!to.cat_name.equalsIgnoreCase("Restaurant") && !to.cat_name.equalsIgnoreCase("Bar") && !to.cat_name.equalsIgnoreCase("accommodation")) {
                String category_name = to.cat_name.toUpperCase();
                double total_amount = 1000;
                double qty = to.qty;
                String description = to.description;
                double price = to.unit_price;
                double amount = to.unit_price * qty;
                System.out.println(description + " Price: " + price + "Discount: " + to.disc_rate);
                Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
                rpt_sales_category_others.add(tf);
                total += amount;
            }

        }
        Srpt_sales_category rpt = new Srpt_sales_category(
                SUBREPORT_DIR, busi_name, date, total, rpt_sales_category_accomodation, rpt_sales_category_bar, rpt_sales_category_restaurant, rpt_sales_category_others);
        return rpt;
    }

    public static void main(String[] args) {
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt_sales_report\\";
        String busi_name = "Synapse Software Technologies";
        String date = "November 9, 2013";
        double total = 0;
        List<Srpt_sales_category_accomodation.field> rpt_sales_category_accomodation = new ArrayList();
        for (int i = 0; i < 20; i++) {

            String category_name = "ACCOMODATION";
            double total_amount = 1000;
            double qty = 0 + i;
            String description = "desc";
            double price = 100 + i;
            double amount = price * qty;

            Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
            rpt_sales_category_accomodation.add(tf);

            total += amount;
        }

        List<Srpt_sales_category_accomodation.field> rpt_sales_category_bar = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String category_name = "BAR";
            double total_amount = 1000;
            double qty = 0 + i;
            String description = "desc";
            double price = 100 + i;
            double amount = price * qty;
            Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
            rpt_sales_category_bar.add(tf);

            total += amount;
        }

        List<Srpt_sales_category_accomodation.field> rpt_sales_category_restaurant = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String category_name = "RESTAURANT";
            double total_amount = 1000;
            double qty = 0 + i;
            String description = "desc";
            double price = 100 + i;
            double amount = price * qty;
            Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
            rpt_sales_category_restaurant.add(tf);

            total += amount;
        }

        List<Srpt_sales_category_accomodation.field> rpt_sales_category_others = new ArrayList();
        for (int i = 0; i < 15; i++) {
            String category_name = "";

            double total_amount = 1000;
            double qty = 0 + i;
            String description = "desc";
            double price = 100 + i;

            if (i >= 0 && i <= 5) {
                category_name = "DIVING 1";
                qty = 5;
                price = 10;
            }
            if (i >= 6 && i <= 10) {
                category_name = "DIVING 2";
                qty = 6;
                price = 10;
            }

            if (i >= 11 && i <= 15) {
                category_name = "DIVING 3";
                qty = 10;
                price = 10;
            }
            double amount = price * qty;
            Srpt_sales_category_accomodation.field tf = new field(category_name, total_amount, qty, description, price, amount);
            rpt_sales_category_others.add(tf);
            total += amount;
        }
        Srpt_sales_category rpt = new Srpt_sales_category(
                SUBREPORT_DIR, busi_name, date, total, rpt_sales_category_accomodation, rpt_sales_category_bar, rpt_sales_category_restaurant, rpt_sales_category_others);
        JRViewer viewer = Srpt_sales_category.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_category.jrxml";
            InputStream is = Srpt_sales_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pdf_viewer(Srpt_sales_category to) {

        JasperUtil.pdfViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JRViewer get_viewer(Srpt_sales_category to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());
    }

    public static List<to_receipt_items> ret_data_ordered(String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",table_no_id"
                    + ",or_no"
                    + ",sum(qty)"
                    + ",product_name"
                    + ",description"
                    + ",sum(price)"
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
                    + " from db_pos_restaurant.customer_tables_details  where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " group by description,price,discount "
                    + " order by category_name asc"
                    + "";

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

                to_receipt_items to = new to_receipt_items(id, or_no, product_name, price, qty, "", category_name, description, disc_name, disc_rate, discount, 0, customer_id, customer_address, group_id, date_added, nights, user_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipt_items> ret_where(String where) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",table_no_id"
                    + ",or_no"
                    + ",sum(qty)"
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
                    + " from db_pos_restaurant.customer_tables_details  "
                    + "" + where;

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

                to_receipt_items to = new to_receipt_items(id, or_no, product_name, price, qty, "", category_name, description, disc_name, disc_rate, discount, 0, customer_id, customer_address, group_id, date_added, nights, user_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipt_items> ret_data(String date_from, String date_to) {
        List<to_receipt_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "ri.id"
                    + ",ri.receipt_id"
                    + ",ri.product_name"
                    + ",sum(ri.unit_price)"
                    + ",sum(ri.qty)"
                    + ",ri.type_name"
                    + ",ri.cat_name"
                    + ",ri.description"
                    + ",ri.disc_name"
                    + ",ri.disc_rate"
                    + ",ri.discount"
                    + ",ri.customer_name"
                    + ",ri.customer_id"
                    + ",ri.customer_address"
                    + ",ri.group_id"
                    + ",ri.date_added"
                    + ",ri.nights"
                    + ",ri.user_name"
                    + " from " + MyDB.getNames() + ".receipt_items ri where "
                    + " date(ri.date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " group by description "
                    + " order by cat_name asc"
                    + "";

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

    public static to_receipts ret_data_customer_details(String receipt_i) {
        to_receipts to1 = null;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cashier_session_id"
                    + ",tendered"
                    + ",or_number"
                    + ",receipt_status"
                    + ",receipt_date"
                    + ",discount"
                    + ",credit"
                    + ",approval_code"
                    + ",member_id"
                    + ",is_payed"
                    + ",dollar"
                    + ",credit_dollar"
                    + ",dollar_rate"
                    + ",peso"
                    + ",user_name"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",table_name"
                    + ",gross_sales"
                    + ",bank_php"
                    + ",bank_usd"
                    + ",credit_card"
                    + " from " + MyDB.getNames() + ".receipts where "
                    + " id ='" + receipt_i + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                double tendered = rs.getDouble(3);
                String or_number = rs.getString(4);
                int receipt_status = rs.getInt(5);
                String receipt_date = rs.getString(6);
                double discount = rs.getDouble(7);
                double credit = rs.getDouble(8);
                String approval_code = rs.getString(9);
                String member_id = rs.getString(10);
                String is_payed = rs.getString(11);
                double dollar = rs.getDouble(12);
                double credit_dollar = rs.getDouble(13);
                double dollar_rate = rs.getDouble(14);
                double peso = rs.getDouble(15);
                String user_name = rs.getString(16);
                String guest_ids = rs.getString(17);
                String guest_names = rs.getString(18);
                String room_guest_ids = rs.getString(19);
                String table_id = rs.getString(20);
                String table_name = rs.getString(21);
                double gross_sales = rs.getDouble(22);
                double bank_php = rs.getDouble(23);
                double bank_usd = rs.getDouble(24);
                double credit_card = rs.getDouble(25);

                to1 = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar, credit_dollar, dollar_rate, peso, user_name, guest_ids, guest_names, room_guest_ids, table_id, table_name, gross_sales, bank_php, bank_usd, credit_card);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
