/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author Guinness
 */
public class Srpt_sales_by_category {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String cashier;
    public final String category;
    public final String category_type;
    public final List<field> fields;

    public Srpt_sales_by_category(String business_name, String address, String contact_no, String date, String cashier, String category, String category_type) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.cashier = cashier;
        this.category = category;
        this.category_type = category_type;
        this.fields = new ArrayList();
    }

    public static class field {

        String table_no_id;
        String or_no;
        double qty;
        String product_name;
        String description;
        double price;
        int status;
        String guest_id;
        String guest_name;
        String cat_id;
        String date_added;
        int printing_assembly;
        double disc_rate;
        double discount;
        int nights;
        int guest_no;
        int room_guest_id;
        String user_name;
        String category_name;
        String sub_category_name;
        String sub_category_id;
        String order_no;
        double amount;

        public field() {
        }

        public field(String table_no_id, String or_no, double qty, String product_name, String description, double price, int status, String guest_id,
                String guest_name, String cat_id, String date_added, int printing_assembly, double disc_rate, double discount, int nights, int guest_no, int room_guest_id, String user_name, String category_name, String sub_category_name, String sub_category_id, String order_no, double amount) {
            this.table_no_id = table_no_id;
            this.or_no = or_no;
            this.qty = qty;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.status = status;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.cat_id = cat_id;
            this.date_added = date_added;
            this.printing_assembly = printing_assembly;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.nights = nights;
            this.guest_no = guest_no;
            this.room_guest_id = room_guest_id;
            this.user_name = user_name;
            this.category_name = category_name;
            this.sub_category_name = sub_category_name;
            this.sub_category_id = sub_category_id;
            this.order_no = order_no;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getTable_no_id() {
            return table_no_id;
        }

        public void setTable_no_id(String table_no_id) {
            this.table_no_id = table_no_id;
        }

        public String getOr_no() {
            return or_no;
        }

        public void setOr_no(String or_no) {
            this.or_no = or_no;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
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

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public int getPrinting_assembly() {
            return printing_assembly;
        }

        public void setPrinting_assembly(int printing_assembly) {
            this.printing_assembly = printing_assembly;
        }

        public double getDisc_rate() {
            return disc_rate;
        }

        public void setDisc_rate(double disc_rate) {
            this.disc_rate = disc_rate;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public int getNights() {
            return nights;
        }

        public void setNights(int nights) {
            this.nights = nights;
        }

        public int getGuest_no() {
            return guest_no;
        }

        public void setGuest_no(int guest_no) {
            this.guest_no = guest_no;
        }

        public int getRoom_guest_id() {
            return room_guest_id;
        }

        public void setRoom_guest_id(int room_guest_id) {
            this.room_guest_id = room_guest_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getSub_category_name() {
            return sub_category_name;
        }

        public void setSub_category_name(String sub_category_name) {
            this.sub_category_name = sub_category_name;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }
    }

    public static List<Srpt_sales_by_category.field> ret_data(String where) {
        List<Srpt_sales_by_category.field> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + " ctd.id"
                    + ",ctd.table_no_id"
                    + ",ctd.or_no"
                    + ",sum(ctd.qty)"
                    + ",ctd.product_name"
                    + ",ctd.description"
                    + ",ctd.price"
                    + ",ctd.img_path"
                    + ",ctd.status"
                    + ",ctd.guest_id"
                    + ",ctd.guest_name"
                    + ",ctd.cat_id"
                    + ",ctd.date_added"
                    + ",ctd.printing_assembly"
                    + ",ctd.disc_name"
                    + ",ctd.disc_rate"
                    + ",ctd.discount"
                    + ",ctd.customer_name"
                    + ",ctd.customer_id"
                    + ",ctd.customer_address"
                    + ",ctd.user_lvl"
                    + ",ctd.group_id"
                    + ",ctd.check_out"
                    + ",ctd.nights"
                    + ",ctd.guest_no"
                    + ",ctd.room_guest_id"
                    + ",ctd.user_name"
                    + ",ctd.category_name"
                    + ",ctd.sub_category_name"
                    + ",ctd.sub_category_id"
                    + ",ctd.order_no "
                    + ",isl.types "
                    + ",isl.types_num "
                    + ",isl.item_package_id"
                    + " from " + MyDB.getNames() + ".customer_tables_details ctd join  " + MyDB.getNames() + ".inventory2_stocks_left isl on ctd.product_name = isl.product_name"
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
                String category_type = rs.getString(32);
                String category_type_num = rs.getString(33);
                int item_package_id = rs.getInt(34);

                if (item_package_id == 1) {
                    description = description + " - " + guest_name;
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

                        }
                    }
                }

                double amount = (qty * price) - discount;
                Srpt_sales_by_category.field field1 = new Srpt_sales_by_category.field(table_no_id, or_no, qty, product_name, description, price, status, guest_id, guest_name, cat_id, date_added, printing_assembly, disc_rate, discount, nights, guest_no, room_guest_id, user_name, category_name, category_type, category_type_num, order_no, amount);
                datas.add(field1);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

}
