/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category_discounts;

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
public class S1_category_discounts {

    public static class to_category_discounts {

        public final int id;
        public final String guest_ids;
        public final String guest_names;
        public final String room_guest_ids;
        public final String table_id;
        public final String date_added;
        public final String user_name;
        public final int status;
        public final double due;
        public final double discount_percent;
        public final double discount_amount;
        public final String category_name;
        public final String category_id;
        public final int item_count;
        public final String discount;

        public to_category_discounts(int id, String guest_ids, String guest_names, String room_guest_ids, String table_id, String date_added, String user_name, int status, double due, double discount_percent, double discount_amount, String category_name, String category_id, int item_count, String discount) {
            this.id = id;
            this.guest_ids = guest_ids;
            this.guest_names = guest_names;
            this.room_guest_ids = room_guest_ids;
            this.table_id = table_id;
            this.date_added = date_added;
            this.user_name = user_name;
            this.status = status;
            this.due = due;
            this.discount_percent = discount_percent;
            this.discount_amount = discount_amount;
            this.category_name = category_name;
            this.category_id = category_id;
            this.item_count = item_count;
            this.discount = discount;
        }
    }

    public static void add_category_discounts(to_category_discounts to_category_discounts) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".category_discounts("
                    + "guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",date_added"
                    + ",user_name"
                    + ",status"
                    + ",due"
                    + ",discount_percent"
                    + ",discount_amount"
                    + ",category_name"
                    + ",category_id"
                    + ",item_count"
                    + ",discount"
                    + ")values("
                    + ":guest_ids"
                    + ",:guest_names"
                    + ",:room_guest_ids"
                    + ",:table_id"
                    + ",:date_added"
                    + ",:user_name"
                    + ",:status"
                    + ",:due"
                    + ",:discount_percent"
                    + ",:discount_amount"
                    + ",:category_name"
                    + ",:category_id"
                    + ",:item_count"
                    + ",:discount"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("guest_ids", to_category_discounts.guest_ids).
                    setString("guest_names", to_category_discounts.guest_names).
                    setString("room_guest_ids", to_category_discounts.room_guest_ids).
                    setString("table_id", to_category_discounts.table_id).
                    setString("date_added", to_category_discounts.date_added).
                    setString("user_name", to_category_discounts.user_name).
                    setNumber("status", to_category_discounts.status).
                    setNumber("due", to_category_discounts.due).
                    setNumber("discount_percent", to_category_discounts.discount_percent).
                    setNumber("discount_amount", to_category_discounts.discount_amount).
                    setString("category_name", to_category_discounts.category_name).
                    setString("category_id", to_category_discounts.category_id).
                    setNumber("item_count", to_category_discounts.item_count).
                    setString("discount", to_category_discounts.discount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_category_discounts.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_category_discounts(to_category_discounts to_category_discounts) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".category_discounts set "
                    + "guest_ids= :guest_ids"
                    + ",guest_names= :guest_names"
                    + ",room_guest_ids= :room_guest_ids"
                    + ",table_id= :table_id"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",status= :status"
                    + ",due= :due"
                    + ",discount_percent= :discount_percent"
                    + ",discount_amount= :discount_amount"
                    + ",category_name= :category_name"
                    + ",category_id= :category_id"
                    + ",item_count= :item_count"
                    + ",discount= :discount"
                    + " where "
                    + " id ='" + to_category_discounts.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0).
                    setString("guest_ids", to_category_discounts.guest_ids).
                    setString("guest_names", to_category_discounts.guest_names).
                    setString("room_guest_ids", to_category_discounts.room_guest_ids).
                    setString("table_id", to_category_discounts.table_id).
                    setString("date_added", to_category_discounts.date_added).
                    setString("user_name", to_category_discounts.user_name).
                    setNumber("status", to_category_discounts.status).
                    setNumber("due", to_category_discounts.due).
                    setNumber("discount_percent", to_category_discounts.discount_percent).
                    setNumber("discount_amount", to_category_discounts.discount_amount).
                    setString("category_name", to_category_discounts.category_name).
                    setString("category_id", to_category_discounts.category_id).
                    setNumber("item_count", to_category_discounts.item_count).
                    setString("discount", to_category_discounts.discount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_category_discounts.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static to_category_discounts ret_data(String room_guest_id, String category) {
        to_category_discounts to1 = null;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",date_added"
                    + ",user_name"
                    + ",status"
                    + ",due"
                    + ",discount_percent"
                    + ",discount_amount"
                    + ",category_name"
                    + ",category_id"
                    + ",item_count"
                    + ",discount"
                    + " from " + MyDB.getNames() + ".category_discounts where "
                    + " room_guest_ids = :room_guest_ids "
                    + " and category_name like :category_name "
                    + " ";
            s0 = SqlStringUtil.parse(s0).
                    setString("room_guest_ids", room_guest_id).
                    setString("category_name", category.toUpperCase()).
                    ok();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String guest_ids = rs.getString(2);
                String guest_names = rs.getString(3);
                String room_guest_ids = rs.getString(4);
                String table_id = rs.getString(5);
                String date_added = rs.getString(6);
                String user_name = rs.getString(7);
                int status = rs.getInt(8);
                double due = rs.getDouble(9);
                double discount_percent = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);

                String category_name = rs.getString(12);
                String category_id = rs.getString(13);
                int item_count = rs.getInt(14);
                String discount = rs.getString(15);
                to1 = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due, discount_percent, discount_amount, category_name, category_id, item_count, discount);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static to_category_discounts ret_data_no_category(String room_guest_id) {
        to_category_discounts to1 = null;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",date_added"
                    + ",user_name"
                    + ",status"
                    + ",due"
                    + ",discount_percent"
                    + ",sum(discount_amount)"
                    + ",category_name"
                    + ",category_id"
                    + ",item_count"
                    + ",discount"
                    + " from " + MyDB.getNames() + ".category_discounts where "
                    + " room_guest_ids = :room_guest_ids "
                    + " ";
            s0 = SqlStringUtil.parse(s0).
                    setString("room_guest_ids", room_guest_id).
                    ok();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);;
                String guest_ids = rs.getString(2);
                String guest_names = rs.getString(3);
                String room_guest_ids = rs.getString(4);
                String table_id = rs.getString(5);
                String date_added = rs.getString(6);
                String user_name = rs.getString(7);
                int status = rs.getInt(8);
                double due = rs.getDouble(9);
                double discount_percent = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);

                String category_name = rs.getString(12);
                String category_id = rs.getString(13);
                int item_count = rs.getInt(14);
                String discount = rs.getString(15);
                to1 = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due, discount_percent, discount_amount, category_name, category_id, item_count, discount);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_category_discounts> ret_data(String room_guest_ids1) {
        List<to_category_discounts> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",date_added"
                    + ",user_name"
                    + ",status"
                    + ",due"
                    + ",discount_percent"
                    + ",discount_amount"
                    + ",category_name"
                    + ",category_id"
                    + ",item_count"
                    + ",discount"
                    + " from " + MyDB.getNames() + ".category_discounts where "
                    + " room_guest_ids  = '" + room_guest_ids1+ "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
//            System.out.println(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String guest_ids = rs.getString(2);
                String guest_names = rs.getString(3);
                String room_guest_ids = rs.getString(4);
                String table_id = rs.getString(5);
                String date_added = rs.getString(6);
                String user_name = rs.getString(7);
                int status = rs.getInt(8);
                double due = rs.getDouble(9);
                double discount_percent = rs.getDouble(10);
                double discount_amount = rs.getDouble(11);
                String category_name = rs.getString(12);
                String category_id = rs.getString(13);
                int item_count = rs.getInt(14);
                String discount = rs.getString(15);

                to_category_discounts to = new to_category_discounts(id, guest_ids, guest_names, room_guest_ids, table_id, date_added, user_name, status, due, discount_percent, discount_amount, category_name, category_id, item_count, discount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
