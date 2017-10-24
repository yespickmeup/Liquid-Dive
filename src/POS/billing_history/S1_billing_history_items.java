/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.billing_history;

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
 * @author Maytopacka
 */
public class S1_billing_history_items {

    public static class to_billing_history_items {

        public final int id;
        public final String room_id;
        public final String room_name;
        public final String or_no;
        public final double qty;
        public final String product_name;
        public final String description;
        public final double price;
        public final String img_path;
        public final int status;
        public final int guest_id;
        public final String guest_name;
        public final String cat_id;
        public final String cat_name;
        public final String date_added;
        public final int printing_assembly;
        public final String disc_name;
        public final double disc_rate;
        public final String discount;
        public final String user_name;
        public final int billing_history_id;
        public final double discount_amount;
        public to_billing_history_items(int id, String room_id, String room_name, String or_no, double qty, String product_name, String description, double price, String img_path, int status, int guest_id, String guest_name, String cat_id, String cat_name, String date_added, int printing_assembly, String disc_name, double disc_rate, String discount, String user_name, int billing_history_id,double discount_amount) {
            this.id = id;
            this.room_id = room_id;
            this.room_name = room_name;
            this.or_no = or_no;
            this.qty = qty;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.img_path = img_path;
            this.status = status;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.cat_id = cat_id;
            this.cat_name = cat_name;
            this.date_added = date_added;
            this.printing_assembly = printing_assembly;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.user_name = user_name;
            this.billing_history_id = billing_history_id;
            this.discount_amount=discount_amount;
        }
    }

    public static void add_billing_history_items(List<to_billing_history_items> to_billing_history_items1) {
        try {
            Connection conn = MyConnection1.connect();
            for (to_billing_history_items to_billing_history_items : to_billing_history_items1) {
                String s0 = "insert into " + MyDB.getNames() + ".billing_history_items("
                        + "room_id"
                        + ",room_name"
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
                        + ",cat_name"
                        + ",date_added"
                        + ",printing_assembly"
                        + ",disc_name"
                        + ",disc_rate"
                        + ",discount"
                        + ",user_name"
                        + ",billing_history_id"
                        + ")values("
                        + ":room_id"
                        + ",:room_name"
                        + ",:or_no"
                        + ",:qty"
                        + ",:product_name"
                        + ",:description"
                        + ",:price"
                        + ",:img_path"
                        + ",:status"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ",:cat_id"
                        + ",:cat_name"
                        + ",:date_added"
                        + ",:printing_assembly"
                        + ",:disc_name"
                        + ",:disc_rate"
                        + ",:discount"
                        + ",:user_name"
                        + ",:billing_history_id"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("room_id", to_billing_history_items.room_id).
                        setString("room_name", to_billing_history_items.room_name).
                        setString("or_no", to_billing_history_items.or_no).
                        setNumber("qty", to_billing_history_items.qty).
                        setString("product_name", to_billing_history_items.product_name).
                        setString("description", to_billing_history_items.description).
                        setNumber("price", to_billing_history_items.price).
                        setString("img_path", to_billing_history_items.img_path).
                        setNumber("status", to_billing_history_items.status).
                        setNumber("guest_id", to_billing_history_items.guest_id).
                        setString("guest_name", to_billing_history_items.guest_name).
                        setString("cat_id", to_billing_history_items.cat_id).
                        setString("cat_name", to_billing_history_items.cat_name).
                        setString("date_added", to_billing_history_items.date_added).
                        setNumber("printing_assembly", to_billing_history_items.printing_assembly).
                        setString("disc_name", to_billing_history_items.disc_name).
                        setNumber("disc_rate", to_billing_history_items.disc_rate).
                        setString("discount", to_billing_history_items.discount).
                        setString("user_name", to_billing_history_items.user_name).
                        setNumber("billing_history_id", to_billing_history_items.billing_history_id).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_billing_history_items.class, "Successfully Added");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    
    public static List<to_billing_history_items> ret_data(String billing_history_ids) {
        List<to_billing_history_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",room_id"
                    + ",room_name"
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
                    + ",cat_name"
                    + ",date_added"
                    + ",printing_assembly"
                    + ",disc_name"
                    + ",disc_rate"
                    + ",discount"
                    + ",user_name"
                    + ",billing_history_id"
                    
                    + " from " + MyDB.getNames() + ".billing_history_items where "
                    + " billing_history_id='"+billing_history_ids+"' order by date_added asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String room_id = rs.getString(2);
                String room_name = rs.getString(3);
                String or_no = rs.getString(4);
                double qty = rs.getDouble(5);
                String product_name = rs.getString(6);
                String description = rs.getString(7);
                double price = rs.getDouble(8);
                String img_path = rs.getString(9);
                int status = rs.getInt(10);
                int guest_id = rs.getInt(11);
                String guest_name = rs.getString(12);
                String cat_id = rs.getString(13);
                String cat_name = rs.getString(14);
                String date_added = rs.getString(15);
                int printing_assembly = rs.getInt(16);
                String disc_name = rs.getString(17);
                double disc_rate = rs.getDouble(18);
                String discount = rs.getString(19);
                String user_name = rs.getString(20);
                int billing_history_id = rs.getInt(21);
                double discount_amount=price*disc_rate;
                to_billing_history_items to = new to_billing_history_items(id, room_id, room_name, or_no, qty, product_name, description, price, img_path, status, guest_id, guest_name, cat_id, cat_name, date_added, printing_assembly, disc_name, disc_rate, discount, user_name, billing_history_id,discount_amount);
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
