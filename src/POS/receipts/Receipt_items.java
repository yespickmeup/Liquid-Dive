/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.receipts;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Receipt_items {

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

    public static void add_data(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".receipt_items("
                    + "receipt_id"
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
                    + ")values("
                    + ":receipt_id"
                    + ",:product_name"
                    + ",:unit_price"
                    + ",:qty"
                    + ",:type_name"
                    + ",:cat_name"
                    + ",:description"
                    + ",:disc_name"
                    + ",:disc_rate"
                    + ",:discount"
                    + ",:customer_name"
                    + ",:customer_id"
                    + ",:customer_address"
                    + ",:group_id"
                    + ",:date_added"
                    + ",:nights"
                    + ",:user_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("receipt_id", to_receipt_items.receipt_id)
                    .setString("product_name", to_receipt_items.product_name)
                    .setNumber("unit_price", to_receipt_items.unit_price)
                    .setNumber("qty", to_receipt_items.qty)
                    .setString("type_name", to_receipt_items.type_name)
                    .setString("cat_name", to_receipt_items.cat_name)
                    .setString("description", to_receipt_items.description)
                    .setString("disc_name", to_receipt_items.disc_name)
                    .setNumber("disc_rate", to_receipt_items.disc_rate)
                    .setNumber("discount", to_receipt_items.discount)
                    .setNumber("customer_name", to_receipt_items.customer_name)
                    .setString("customer_id", to_receipt_items.customer_id)
                    .setString("customer_address", to_receipt_items.customer_address)
                    .setNumber("group_id", to_receipt_items.group_id)
                    .setString("date_added", to_receipt_items.date_added)
                    .setNumber("nights", to_receipt_items.nights)
                    .setString("user_name", to_receipt_items.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".receipt_items set "
                    + "receipt_id= :receipt_id "
                    + ",product_name= :product_name "
                    + ",unit_price= :unit_price "
                    + ",qty= :qty "
                    + ",type_name= :type_name "
                    + ",cat_name= :cat_name "
                    + ",description= :description "
                    + ",disc_name= :disc_name "
                    + ",disc_rate= :disc_rate "
                    + ",discount= :discount "
                    + ",customer_name= :customer_name "
                    + ",customer_id= :customer_id "
                    + ",customer_address= :customer_address "
                    + ",group_id= :group_id "
                    + ",date_added= :date_added "
                    + ",nights= :nights "
                    + ",user_name= :user_name "
                    + " where id='" + to_receipt_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("receipt_id", to_receipt_items.receipt_id)
                    .setString("product_name", to_receipt_items.product_name)
                    .setNumber("unit_price", to_receipt_items.unit_price)
                    .setNumber("qty", to_receipt_items.qty)
                    .setString("type_name", to_receipt_items.type_name)
                    .setString("cat_name", to_receipt_items.cat_name)
                    .setString("description", to_receipt_items.description)
                    .setString("disc_name", to_receipt_items.disc_name)
                    .setNumber("disc_rate", to_receipt_items.disc_rate)
                    .setNumber("discount", to_receipt_items.discount)
                    .setNumber("customer_name", to_receipt_items.customer_name)
                    .setString("customer_id", to_receipt_items.customer_id)
                    .setString("customer_address", to_receipt_items.customer_address)
                    .setNumber("group_id", to_receipt_items.group_id)
                    .setString("date_added", to_receipt_items.date_added)
                    .setNumber("nights", to_receipt_items.nights)
                    .setString("user_name", to_receipt_items.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_receipt_items to_receipt_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".receipt_items  "
                    + " where id='" + to_receipt_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Receipt_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipt_items> ret_data(String where) {
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
                    + " from " + MyDB.getNames() + ".receipt_items"
                    + " " + where;

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

}
