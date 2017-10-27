/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_in;

import POS.Main;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class Srpt_stock_in_main {

    public final String business_name;
    public final String date;
    public final String transaction_no;
    public final double total_item;
    public final double total_cost;
    public final String stock_in_date;
    public final String remarks;
    public final String supplier;
    public final List<field> fields;

    public Srpt_stock_in_main(String business_name, String date, String transaction_no, double total_item, double total_cost, String stock_in_date, String remarks, String supplier) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.transaction_no = transaction_no;
        this.total_item = total_item;
        this.total_cost = total_cost;
        this.stock_in_date = stock_in_date;
        this.remarks = remarks;
        this.supplier = supplier;
    }

    public static class field {

        String item_code;
        String description;
        double qty;
        double cost;
        double price;
        double amount;
        String date_added;
        String added_by;
        String remarks;
        String category;
        String category_id;
        String sub_category;
        String sub_category_id;
        String supplier;

        public field() {
        }

        public field(String item_code, String description, double qty, double cost, double price, double amount, String date_added, String added_by, String remarks, String category, String category_id, String sub_category, String sub_category_id, String supplier) {
            this.item_code = item_code;
            this.description = description;
            this.qty = qty;
            this.cost = cost;
            this.price = price;
            this.amount = amount;
            this.date_added = date_added;
            this.added_by = added_by;
            this.remarks = remarks;
            this.category = category;
            this.category_id = category_id;
            this.sub_category = sub_category;
            this.sub_category_id = sub_category_id;
            this.supplier = supplier;
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

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getAdded_by() {
            return added_by;
        }

        public void setAdded_by(String added_by) {
            this.added_by = added_by;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getSub_category() {
            return sub_category;
        }

        public void setSub_category(String sub_category) {
            this.sub_category = sub_category;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

    }

    public static Srpt_stock_in_main ret_data(String stock_in_id) {
        Srpt_stock_in_main rpt = null;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",ref_no"
                    + ",item_count"
                    + ",total_cost"
                    + ",date_added"
                    + ",branch"
                    + ",branch_id"
                    + ",user_name"
                    + ",user_id"
                    + ",status"
                    + ",remarks"
                    + ",supplier"
                    + " from " + Main.MyDB.getNames() + ".stock_in_main"
                    + " where id ='" + stock_in_id + "' ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String ref_no = rs.getString(2);
                int item_count = rs.getInt(3);
                double total_cost = rs.getDouble(4);
                String date_added = rs.getString(5);
                String branch = rs.getString(6);
                int branch_id = rs.getInt(7);
                String user_name = rs.getString(8);
                int user_id = rs.getInt(9);
                int status = rs.getInt(10);
                String remarks = rs.getString(11);
                String supplier = rs.getString(12);

                String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
                String date = DateType.month_date.format(new Date());
                String transaction_no = ref_no;
                double total_item = item_count;

                String stock_in_date = DateType.convert_slash(date_added);
                rpt = new Srpt_stock_in_main(business_name, date, transaction_no, total_item, total_cost, stock_in_date, remarks, supplier);

                List<field> fields = new ArrayList();
                String s2 = "select "
                        + "id"
                        + ",prod_num"
                        + ",prod_name"
                        + ",qty"
                        + ",amount"
                        + ",date_added"
                        + ",cashier_name"
                        + ",cashier_id"
                        + ",remarks"
                        + ",branch_id"
                        + ",branch"
                        + ",status"
                        + ",cost"
                        + ",types"
                        + ",types_num"
                        + ",cat_id"
                        + ",stock_in_no"
                        + ",supplier"
                        + " from " + Main.MyDB.getNames() + ".stock_in"
                        + " where stock_in_no='" + ref_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt.executeQuery(s2);
                while (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String prod_num = rs2.getString(2);
                    String prod_name = rs2.getString(3);
                    double qty = rs2.getDouble(4);
                    double amount = rs2.getDouble(5);
                    String date_added2 = rs2.getString(6);
                    String cashier_name = rs2.getString(7);
                    String cashier_id = rs2.getString(8);
                    String remarks2 = rs2.getString(9);
                    int branch_id2 = rs2.getInt(10);
                    String branch2 = rs2.getString(11);
                    int status2 = rs2.getInt(12);
                    double cost = rs2.getDouble(13);
                    String types = rs2.getString(14);
                    String types_num = rs2.getString(15);
                    String cat_id = rs2.getString(16);
                    String stock_in_no = rs2.getString(17);
                    String supplier2 = rs2.getString(18);

                    String item_code = prod_num;
                    String description = prod_name;

                    double price = amount;
                    double amount2 = qty * cost;
                    date_added2 = DateType.convert_slash(date_added2);
                    String added_by = cashier_name;
                    String category = "";
                    String category_id = cat_id;
                    String sub_category = types;
                    String sub_category_id = types_num;
                    field f = new field(item_code, description, qty, cost, price, amount2, date_added2, added_by, remarks2, category, category_id, sub_category, sub_category_id, supplier2);
                    fields.add(f);
                }
                rpt.fields.addAll(fields);
            }
            return rpt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static Srpt_stock_in_main ret_data_out(String stock_in_id) {
        Srpt_stock_in_main rpt = null;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",ref_no"
                    + ",item_count"
                    + ",total_cost"
                    + ",date_added"
                    + ",branch"
                    + ",branch_id"
                    + ",user_name"
                    + ",user_id"
                    + ",status"
                    + ",remarks"
                    + ",supplier"
                    + " from " + Main.MyDB.getNames() + ".stock_out_main"
                    + " where id ='" + stock_in_id + "' ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String ref_no = rs.getString(2);
                int item_count = rs.getInt(3);
                double total_cost = rs.getDouble(4);
                String date_added = rs.getString(5);
                String branch = rs.getString(6);
                int branch_id = rs.getInt(7);
                String user_name = rs.getString(8);
                int user_id = rs.getInt(9);
                int status = rs.getInt(10);
                String remarks = rs.getString(11);
                String supplier = rs.getString(12);

                String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
                String date = DateType.month_date.format(new Date());
                String transaction_no = ref_no;
                double total_item = item_count;

                String stock_in_date = DateType.convert_slash(date_added);
                rpt = new Srpt_stock_in_main(business_name, date, transaction_no, total_item, total_cost, stock_in_date, remarks, supplier);

                List<field> fields = new ArrayList();
                String s2 = "select "
                        + "id"
                        + ",prod_num"
                        + ",prod_name"
                        + ",qty"
                        + ",amount"
                        + ",date_added"
                        + ",cashier_name"
                        + ",cashier_id"
                        + ",remarks"
                        + ",branch_id"
                        + ",branch"
                        + ",status"
                        + ",cost"
                        + ",types"
                        + ",types_num"
                        + ",cat_id"
                        + ",stock_in_no"
                        + ",supplier"
                        + " from " + Main.MyDB.getNames() + ".stock_out"
                        + " where stock_in_no='" + ref_no + "' ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt.executeQuery(s2);
                while (rs2.next()) {
                    int id2 = rs2.getInt(1);
                    String prod_num = rs2.getString(2);
                    String prod_name = rs2.getString(3);
                    double qty = rs2.getDouble(4);
                    double amount = rs2.getDouble(5);
                    String date_added2 = rs2.getString(6);
                    String cashier_name = rs2.getString(7);
                    String cashier_id = rs2.getString(8);
                    String remarks2 = rs2.getString(9);
                    int branch_id2 = rs2.getInt(10);
                    String branch2 = rs2.getString(11);
                    int status2 = rs2.getInt(12);
                    double cost = rs2.getDouble(13);
                    String types = rs2.getString(14);
                    String types_num = rs2.getString(15);
                    String cat_id = rs2.getString(16);
                    String stock_in_no = rs2.getString(17);
                    String supplier2 = rs2.getString(18);

                    String item_code = prod_num;
                    String description = prod_name;

                    double price = amount;
                    double amount2 = qty * cost;
                    date_added2 = DateType.convert_slash(date_added2);
                    String added_by = cashier_name;
                    String category = "";
                    String category_id = cat_id;
                    String sub_category = types;
                    String sub_category_id = types_num;
                    field f = new field(item_code, description, qty, cost, price, amount2, date_added2, added_by, remarks2, category, category_id, sub_category, sub_category_id, supplier2);
                    fields.add(f);
                }
                rpt.fields.addAll(fields);
            }
            return rpt;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
