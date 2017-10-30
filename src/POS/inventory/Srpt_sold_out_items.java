/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Srpt_sold_out_items {

    public final String business_name;
    public final String date;
    public final String category;
    public final String sub_category;
    public final List<Srpt_sold_out_items.field> fields;
    public final double paid;
    public final double unpaid;
    public Srpt_sold_out_items(String business_name, String date, String category, String sub_category,double paid,double unpaid) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.category = category;
        this.sub_category = sub_category;
        this.paid=paid;
        this.unpaid=unpaid;
    }

    public static class field {

        String table_no_id;
        String order_no;
        String item_code;
        String description;
        double qty;
        double price;
        double discount;
        double amount;
        String status;
        String guest_id;
        String guest_name;
        String category;
        String category_id;
        String sub_category;
        String sub_category_id;
        String date_added;
        String added_by;
        String room_guest_id;

        public field() {
        }

        public field(String table_no_id, String order_no, String item_code, String description, double qty, double price, double discount, double amount, String status, String guest_id, String guest_name, String category, String category_id, String sub_category, String sub_category_id, String date_added, String added_by, String room_guest_id) {
            this.table_no_id = table_no_id;
            this.order_no = order_no;
            this.item_code = item_code;
            this.description = description;
            this.qty = qty;
            this.price = price;
            this.discount = discount;
            this.amount = amount;
            this.status = status;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.category = category;
            this.category_id = category_id;
            this.sub_category = sub_category;
            this.sub_category_id = sub_category_id;
            this.date_added = date_added;
            this.added_by = added_by;
            this.room_guest_id = room_guest_id;
        }

        public String getTable_no_id() {
            return table_no_id;
        }

        public void setTable_no_id(String table_no_id) {
            this.table_no_id = table_no_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getRoom_guest_id() {
            return room_guest_id;
        }

        public void setRoom_guest_id(String room_guest_id) {
            this.room_guest_id = room_guest_id;
        }
    }

    public static List<Srpt_sold_out_items.field> ret_data(String where) {
        List<Srpt_sold_out_items.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + " ct.id"
                    + ",ct.table_no_id"
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
                    + ",ct.user_name"
                    + ",ct.category_name"
                    + ",ct.sub_category_name"
                    + ",ct.sub_category_id"
                    + ",ct.order_no"
                    + ",s.item_package_id"
                    + " from " + MyDB.getNames() + ".customer_tables_details ct "
                    + " join  " + MyDB.getNames() + ".inventory2_stocks_left s "
                    + " on s.product_name=ct.product_name "
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
                String order_no = rs.getString(31);
                int item_package = rs.getInt(32);
                double amount = (qty * price) - discount;
                String status1 = "Yes";
                if (status == 0) {
                    status1 = "No";
                }

                
                if ( item_package == 1) {
                    String s3 = "select "
                            + " range_from"
                            + ",range_to"
                            + ",rate"
                            + ",description"
                            + " from " + MyDB.getNames() + ".item_packages where "
                            + " product_name ='" + product_name + "' "
                            + " ";
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);

                    while (rs3.next()) {

                        int range_from = FitIn.toInt(rs3.getString(1));
                        int range_to = FitIn.toInt(rs3.getString(2));
                        double rate = FitIn.toInt(rs3.getString(3));
                      
                        if (qty >= range_from && qty <= range_to) {
                            price = rate;
                            if(description.isEmpty()){
                                description=rs3.getString(4);
                            }
                        }
                    }
                }

                String category = "";
                String category_id = cat_id;
                String sub_category = "";
                String sub_category_id1 = "";
                try {
                    date_added = DateType.dash2.format(DateType.datetime.parse(date_added));
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_sold_out_items.class.getName()).log(Level.SEVERE, null, ex);
                }
                String added_by = user_name;
                Srpt_sold_out_items.field field = new field(table_no_id, order_no, product_name, description, qty, price, discount, amount, status1, guest_id, guest_name, category, category_id, sub_category, sub_category_id1, date_added, added_by, guest_id);
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
