/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.pnl_ordering;

import POS.Main;
import POS.Main.MyDB;
import POS.printing2.Srpt_billing_statement;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Ordering {

    public static class orders {

        public final String table_no_id;
        public final String date_added;
        public final String guest_id;
        public final String guest_name;
        public final String room_guest_id;
        public final String user_name;
        public final String order_no;
        public final double no_of_items;
        public final double amount_due;
        public final double line_discount;
        public final double net_due;
        public boolean is_selected;

        public orders(String table_no_id, String date_added, String guest_id, String guest_name, String room_guest_id, String user_name, String order_no, double no_of_items, double amount_due, double line_discount, double net_due, boolean is_selected) {
            this.table_no_id = table_no_id;
            this.date_added = date_added;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.room_guest_id = room_guest_id;
            this.user_name = user_name;
            this.order_no = order_no;
            this.no_of_items = no_of_items;
            this.amount_due = amount_due;
            this.line_discount = line_discount;
            this.net_due = net_due;
            this.is_selected = is_selected;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

    }

    public static void main(String[] args) {

        Main.MyDB.setNames("db_pos_restaurant_liquid");
        String where = " where table_no_id='102' and guest_id='00008012' and status=0 "
                + " or table_no_id='102' and guest_id='00008009' and status=0 "
                + " group by order_no";
        List<Ordering.orders> orders = ret_orders(where);
        for (Ordering.orders order : orders) {
            System.out.println("Table No: " + order.table_no_id);
            System.out.println("Date Added: " + order.date_added);
            System.out.println("Order No: " + order.order_no);
            System.out.println("No of Items: " + order.no_of_items);
            System.out.println("Amount Due: " + order.amount_due);
            System.out.println("Line Discount: " + order.line_discount);
            System.out.println("Net Due: " + order.net_due);
            System.out.println("************************************");
        }
    }

    public static List<Ordering.orders> ret_orders(String where) {
        List<Ordering.orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + " table_no_id"
                    + ",date_added"
                    + ",guest_id"
                    + ",guest_name"
                    + ",room_guest_id"
                    + ",order_no"
                    + ",count(id)"
                    + ",sum(qty*price)"
                    + ",sum(discount)"
                    + " from " + Main.MyDB.getNames() + ".customer_tables_details "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String table_no_id = rs.getString(1);
                String date_added = rs.getString(2);
                String guest_id = rs.getString(3);
                String guest_name = rs.getString(4);
                String room_guest_id = rs.getString(5);
                String order_no = rs.getString(6);
                double no_of_items = rs.getDouble(7);
                double amount_due = rs.getDouble(8);
                double line_discount = rs.getDouble(9);
                double net_due = amount_due - line_discount;
                Ordering.orders order = new orders(table_no_id, date_added, guest_id, guest_name, room_guest_id, guest_name, order_no, no_of_items, amount_due, line_discount, net_due, false);
                datas.add(order);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<Srpt_billing_statement.field> ret_data(String where) {
        List<Srpt_billing_statement.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "ct.id"
                    + ",(select t.table_name from " + MyDB.getNames() + ".tables t where t.id= ct.table_no_id)"
                    + ",ct.or_no"
                    + ",ct.qty"
                    + ",ct.product_name"
                    + ",ct.description"
                    + ",ct.price"
                    + ",ct.img_path"
                    + ",ct.status"
                    + ",ct.guest_id"
                    + ",ct.guest_name"
                    + ",ct.cat_id"
                    + ",ct.date_added"
                    + ",ct.printing_assembly"
                    + ",ct.disc_name"
                    + ",ct.disc_rate"
                    + ",ct.discount"
                    + ",ct.customer_name"
                    + ",ct.customer_id"
                    + ",ct.customer_address"
                    + ",ct.user_lvl"
                    + ",ct.group_id"
                    + ",ct.check_out"
                    + ",ct.nights"
                    + ",ct.guest_no"
                    + ",ct.room_guest_id"
                    + ",(select u.user_code from " + MyDB.getNames() + ".users u where  ct.user_name=u.user_name) "
                    + ",ct.category_name"
                    + ",ct.sub_category_name"
                    + ",ct.sub_category_id"
                    + ",ct.order_no"
                    + ",(select GROUP_CONCAT(c.guest_name) from " + MyDB.getNames() + ".customer_tables_details c where c.order_no=ct.order_no)     "
                    + " from " + MyDB.getNames() + ".customer_tables_details ct "
                    + " "
                    + " " + where;

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
                String date_added = DateType.convert_slash_datetime3(rs.getString(13));
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
                String order_no = rs.getString(31);
                String guest_names = rs.getString(32);
                guest_name = guest_names;
                String item_code = product_name;
                String assembly = "" + printing_assembly;
                double selling_price = price;
                double amount = (selling_price * qty);
                String datetime = date_added;
                String sub_cat_id = "" + sub_category_id;
                boolean is_selected = false;
                double net_due = amount - discount;
                Srpt_billing_statement.field field = new Srpt_billing_statement.field(item_code, description, assembly, qty, selling_price, discount, amount, datetime,
                        cat_id, sub_cat_id, is_selected, order_no, table_no_id, date_added, guest_id, guest_name, user_name, net_due,0);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<Srpt_billing_statement.field> ret_data_sum(String where) {
        List<Srpt_billing_statement.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "ct.id"
                    + ",(select t.table_name from " + MyDB.getNames() + ".tables t where t.id= ct.table_no_id)"
                    + ",ct.or_no"
                    + ",sum(ct.qty)"
                    + ",ct.product_name"
                    + ",ct.description"
                    + ",ct.price"
                    + ",ct.img_path"
                    + ",ct.status"
                    + ",ct.guest_id"
                    + ",ct.guest_name"
                    + ",ct.cat_id"
                    + ",ct.date_added"
                    + ",ct.printing_assembly"
                    + ",ct.disc_name"
                    + ",ct.disc_rate"
                    + ",ct.discount"
                    + ",ct.customer_name"
                    + ",ct.customer_id"
                    + ",ct.customer_address"
                    + ",ct.user_lvl"
                    + ",ct.group_id"
                    + ",ct.check_out"
                    + ",ct.nights"
                    + ",ct.guest_no"
                    + ",ct.room_guest_id"
                    + ",(select u.user_code from " + MyDB.getNames() + ".users u where  ct.user_name=u.user_name) "
                    + ",ct.category_name"
                    + ",ct.sub_category_name"
                    + ",ct.sub_category_id"
                    + ",ct.order_no"
                    + " from " + MyDB.getNames() + ".customer_tables_details ct"
                    + " " + where;
//            System.out.println(s0);
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
                String date_added = DateType.convert_slash_datetime3(rs.getString(13));
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
                String order_no = rs.getString(31);

                String item_code = product_name;
                String assembly = "" + printing_assembly;
                double selling_price = price;
                double amount = (selling_price * qty);
                String datetime = date_added;
                String sub_cat_id = "" + sub_category_id;
                boolean is_selected = false;
                double net_due = amount - discount;
                Srpt_billing_statement.field field = new Srpt_billing_statement.field(item_code, description, assembly, qty, selling_price, discount, amount,
                        datetime, cat_id, sub_cat_id, is_selected, order_no, table_no_id, date_added, guest_id, guest_name, user_name, net_due,0);
                datas.add(field);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
