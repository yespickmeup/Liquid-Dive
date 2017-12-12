/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.DateUtils;
import POS_to4.to_search_prod;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection1;
import java.sql.SQLException;
import java.util.Date;
import mijzcx.synapse.desk.utils.FitIn;
import test.Dlg_check_liquid;

/**
 *
 * @author Dummy
 */
public class S2_search {

    public static List<to_search_prod> ret_product(String name) {

        List<to_search_prod> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select product_name,description,price,product_qty from " + MyDB.
                    getNames() + ".inventory2_stocks_left where description like '%" + name + "%' or lookup_code like '%" + name + "%' or product_name like '" + name + "%' ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                double qty = rs.getDouble(4);
                to_search_prod to = new to_search_prod(names, "pcs", desc, price, qty);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static class to_items {

        public String name;
        public String uom;
        public String desc;
        public final double price;
        public double qty;
        public String img_path;
        public double qty2;
        public final String guest_id;
        public final String cat_id;
        public final String category_name;
        public final int printing_assembly;
        public final int status;
        public String disc_name;
        public double disc_rate;
        public double discount;
        public String customer_name;
        public String customer_id;
        public String customer_address;
        public final String date_added;
        public final int group_id;
        public final int nights;
        public final int guest_no;
        public final String check_out;
        public final String room_guest_id;
        public final String user_name;
        public final int item_package_id;
        public final String sub_category_name;
        public final String sub_category_id;
        public final String order_no;

        public to_items(String name, String uom, String desc, double price, double qty, String img_path, double qty2, String guest_id, String cat_id, String category_name, int printing_assembly, int status, String disc_name, double disc_rate, double discount, String customer_name, String customer_id, String customer_address, String date_added, int group_id, int nights, int guest_no, String check_out, String room_guest_id, String user_name, int item_package_id, String sub_category_name, String sub_category_id, String order_no) {
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.qty = qty;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.guest_id = guest_id;
            this.cat_id = cat_id;
            this.category_name = category_name;
            this.printing_assembly = printing_assembly;
            this.status = status;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_address = customer_address;
            this.date_added = date_added;
            this.group_id = group_id;
            this.nights = nights;
            this.guest_no = guest_no;
            this.check_out = check_out;
            this.room_guest_id = room_guest_id;
            this.user_name = user_name;
            this.item_package_id = item_package_id;
            this.sub_category_name = sub_category_name;
            this.sub_category_id = sub_category_name;
            this.order_no = order_no;
        }

        public int getItem_package_id() {
            return item_package_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDisc_name() {
            return disc_name;
        }

        public void setDisc_name(String disc_name) {
            this.disc_name = disc_name;
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

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public String getCat_id() {
            return cat_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public String getCheck_out() {
            return check_out;
        }

        public String getDate_added() {
            return date_added;
        }

        public int getGroup_id() {
            return group_id;
        }

        public String getGuest_id() {
            return guest_id;
        }

        public int getGuest_no() {
            return guest_no;
        }

        public int getNights() {
            return nights;
        }

        public double getPrice() {
            return price;
        }

        public int getPrinting_assembly() {
            return printing_assembly;
        }

        public String getRoom_guest_id() {
            return room_guest_id;
        }

        public int getStatus() {
            return status;
        }
    }

    public static class to_items_status {

        public double qty;
        public String name;
        public String uom;
        public String desc;
        public double price;
        public String img_path;
        public double qty2;
        public boolean status;

        public to_items_status(double qty, String name, String uom, String desc, double price, String img_path, double qty2, boolean status) {
            this.qty = qty;
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    public static class to_orders {

        public String name;
        public String uom;
        public String desc;
        public final double price;
        public double qty;
        public String img_path;
        public double qty2;
        public List<S2_search.to_items_status> to_sub;
        public final double amount_to_pay;
        public String cat_id;
        public final String category_name;
        public final int printing_assembly;
        public String disc_name;
        public double disc_rate;
        public double discount;
        public String customer_name;
        public String customer_id;
        public String customer_address;
        public int group_id;
        public final int nights;
        public final int item_package_id;
        public final String sub_category_name;
        public final String sub_category_id;

        public to_orders(String name, String uom, String desc, double price, double qty, String img_path, double qty2, List<to_items_status> to_sub, double amount_to_pay, String cat_id, String category_name, int printing_assembly, String disc_name, double disc_rate, double discount, String customer_name, String customer_id, String customer_address, int group_id, int nights, int item_package_id, String sub_category_name, String sub_category_id) {
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.qty = qty;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.to_sub = to_sub;
            this.amount_to_pay = amount_to_pay;
            this.cat_id = cat_id;
            this.category_name = category_name;
            this.printing_assembly = printing_assembly;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_address = customer_address;
            this.group_id = group_id;
            this.nights = nights;
            this.item_package_id = item_package_id;
            this.sub_category_name = sub_category_name;
            this.sub_category_id = sub_category_id;
        }

        public int getGroup_id() {
            return group_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public double getAmount_to_pay() {
            return amount_to_pay;
        }

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
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

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public List<to_items_status> getTo_sub() {
            return to_sub;
        }

        public void setTo_sub(List<to_items_status> to_sub) {
            this.to_sub = to_sub;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public String getDisc_name() {
            return disc_name;
        }

        public void setDisc_name(String disc_name) {
            this.disc_name = disc_name;
        }
    }

    public static class to_rooms {

        public final String id;
        public final String name;
        public final String num;
        public final String status;
        public final double topay;
        public final String guest_id;
        public final String guest_name;
        public final String date_added;
        public final String room;
        public final double room_rate;
        public final List<Dlg_check_liquid.to_guests> to_guest;
        public final String type;
        public double percentage;
        public final int table_location_id;

        public to_rooms(String id, String name, String num, String status, double topay, String guest_id, String guest_name, String date_added, String room, double room_rate, List<Dlg_check_liquid.to_guests> to_guest, String type, double percentage, int table_location_id) {
            this.id = id;
            this.name = name;
            this.num = num;
            this.status = status;
            this.topay = topay;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.date_added = date_added;
            this.room = room;
            this.room_rate = room_rate;
            this.to_guest = to_guest;
            this.type = type;
            this.percentage = percentage;
            this.table_location_id = table_location_id;
        }

        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }
    }

    public static List<to_items> ret_items(String cat_id, String name, String is_active, int type_id) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",product_qty"
                    + ",img_path "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",group_id "
                    + ",item_package_id "
                    + ",types "
                    + ",types_num "
                    + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                    + "where "
                    + "description like '%" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='" + type_id + "' or "
                    + "lookup_code like '%" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='" + type_id + "' or "
                    + "product_name like '" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='" + type_id + "'  order by description asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int item_package_id = rs.getInt(9);
                int status = 0;
                String types = rs.getString(10);
                String types_num = rs.getString(11);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_ids + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status,
                        "", 0, 0, "", "", "", "", group_id, 0, 0, "", "", "", item_package_id, types, types_num, "");
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_accom(String cat_id, String name, String is_active, String types) {

        String accomodation_id = System.getProperty("accomodation_id", "11");
        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",product_qty"
                    + ",img_path "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",group_id "
                    + ",item_package_id "
                    + ",types "
                    + ",types_num "
                    + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                    + "where "
                    + "description like '%" + name + "%' and cat_id = '" + cat_id + "'  and types like '%" + types + "%'  or "
                    + "lookup_code like '%" + name + "%' and cat_id = '" + cat_id + "'  and types like '%" + types + "%'  or "
                    + "product_name like '" + name + "%' and cat_id = '" + cat_id + "'  and types like '%" + types + "%'  order by description asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int item_package_id = rs.getInt(9);
                int status = 0;
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_ids + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                String typess = rs.getString(10);
                String types_num = rs.getString(11);
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status, "", 0, 0, "", "", "", "", group_id, 0, 0, "", "", "", item_package_id, typess, types_num, "");
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_no_category(String cat_id, String name, String is_active, String happy_hour, String types) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",product_qty"
                    + ",img_path "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",group_id "
                    + ",item_package_id "
                    + ",types "
                    + ",types_num "
                    + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                    + "where "
                    + "description like '%" + name + "%' and cat_id like '%" + cat_id + "%' and types like '%" + types + "%'  or "
                    + "lookup_code like '%" + name + "%' and cat_id like '%" + cat_id + "%'  and types like '%" + types + "%' or  "
                    + "product_name like '" + name + "%' and cat_id like '%" + cat_id + "%'  and types like '%" + types + "%' "
                    + "order by description asc";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int item_package_id = rs.getInt(9);
                int status = 0;
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_ids + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                String typess = rs.getString(10);
                String types_num = rs.getString(11);
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status, "", 0, 0, "", "", "", "", group_id, 0, 0, "", "", "", item_package_id, typess, types_num, "");
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_no_category_top(String cat_id, String name, String is_active, String happy_hour, String types) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String where2 = " description like '%" + name + "%' and cat_id = '" + "10" + "' and types like '%" + types + "%' and is_active like '" + is_active + "'  or ";
//            where2 = where2 + " lookup_code like '%" + name + "%' and cat_id = '" + "10" + "'  and types like '%" + types + "%' or ";
            where2 = where2 + " description like '%" + name + "%' and cat_id = '" + "12" + "' and types like '%" + types + "%' and is_active like '" + is_active + "'   ";
//where2 = where2 + " and happy_hour <> '" + happy_hour + "' or ";
//            where2 = where2 + " lookup_code like '%" + name + "%' and cat_id = '" + "12" + "'  and is_active like '" + is_active + "' or ";
//            where2 = where2 + " product_name like '" + name + "%' and cat_id = '" + "10" + "'  and is_active like '" + is_active + "' or ";
//            where2 = where2 + " product_name like '" + name + "%' and cat_id = '" + "12" + "'  and is_active like '" + is_active + "' ";
            where2 = where2 + "  order by description asc";

            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",product_qty"
                    + ",img_path "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",group_id "
                    + ",item_package_id "
                    + ",types "
                    + ",types_num "
                    + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                    + "where " + where2;

//            System.out.println(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int item_package_id = rs.getInt(9);
                int status = 0;
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String typess = rs.getString(10);
                String types_num = rs.getString(11);
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_ids + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status, "", 0, 0, "", "", "", "", group_id, 0, 0, "", "", "", item_package_id, typess, types_num, "");
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static int count_other_orders_status(String room_no, int selected_guests, int all_guests) {
        int count = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "count(id)"
                    + "from " + MyDB.getNames() + ".customer_tables_details "
                    + "where "
                    + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'  and cat_id<>'" + "10" + "' and cat_id<>'" + "10" + "'  ";
//                    + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'  and cat_id<>'" + "12" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                count = rs.getInt(1);
            }

//             JOptionPane.showMessageDialog(null, count);
            return count;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }

    }

    public static List<to_items> ret_items_room(String room_no, int selected_guests, int all_guests) {

        List<to_items> datas = new ArrayList();
        List<to_items> datas2 = new ArrayList();
        List<to_items> datas_others = new ArrayList();
        if (to_users.user_level1.equals("5")) {
            datas2 = ret_items_room_11(room_no, selected_guests, all_guests);
        }
        datas.addAll(datas2);
//        datas.addAll(datas_others);

        int check_outs = to_users.get_check_outs();
        try {
            Connection conn = MyConnection1.connect();

            String s0 = "";

            if (to_users.user_level1.equals("6")) {
                s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",(price)"
                        + ",(qty)"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status"
                        + ",disc_name"
                        + ",disc_rate"
                        + ",(discount)"
                        + ",customer_name"
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + ",nights "
                        + ",guest_no "
                        + ",check_out "
                        + ",room_guest_id "
                        + ",user_name "
                        + ",category_name "
                        + ",sub_category_name "
                        + ",sub_category_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details "
                        + "where "
                        + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'  and cat_id='" + "10" + "' or "
                        + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'  and cat_id='" + "12" + "'";
            } else {
                s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",(price)"
                        + ",(qty)"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status"
                        + ",disc_name"
                        + ",disc_rate"
                        + ",(discount)"
                        + ",customer_name"
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + ",nights "
                        + ",guest_no "
                        + ",check_out "
                        + ",room_guest_id "
                        + ",user_name "
                        + ",category_name "
                        + ",sub_category_name "
                        + ",sub_category_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details "
                        + "where "
                        + "table_no_id = '" + room_no + "' and status <>'" + "1" + "' and cat_id='" + "12" + "' "
                        + "or table_no_id = '" + room_no + "' and status <>'" + "1" + "' and cat_id='" + "10" + "' "
                        + " ";
            }

            String saved_name = "";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String category_name = rs.getString(23);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }

                price = ((price * qty) - discount);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }

                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                }
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_room_11(String room_no, int selected_guests, int all_guests) {

        List<to_items> datas = new ArrayList();
        List<to_items> datas_others = new ArrayList();
        datas_others = ret_items_room_11_dive(room_no, selected_guests, all_guests);
        datas.addAll(datas_others);
        int check_outs = to_users.get_check_outs();
        try {
            Connection conn = MyConnection1.connect();

            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",sum(price*qty)"
                    + ",sum(qty)"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status"
                    + ",disc_name"
                    + ",disc_rate"
                    + ",(discount)"
                    + ",customer_name"
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",guest_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",sub_category_id "
                    + " from " + MyDB.getNames() + ".customer_tables_details "
                    + "where "
                    + "table_no_id = '" + room_no + "' "
                    + "and status <>'" + "1" + "' "
                    + "and cat_id<>'" + "10" + "' and cat_id<>'" + "12" + "' and cat_id='" + "11" + "' "
                    + "group by guest_id,description";
            String accomodation_id = System.getProperty("accomodation", "11");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String saved_name = "";
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);

                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(25);
                String sub_category_id = rs.getString(26);
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
//               
//                if (cat_id.equals(accomodation_id)) {
//                    price = ((price * nights));
////                    JOptionPane.showMessageDialog(null, guest_no);
//                }
//                price = ((price * qty) - discount);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }
//                 JOptionPane.showMessageDialog(null, nights);
                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_room_11_dive(String room_no, int selected_guests, int all_guests) {

        List<to_items> datas = new ArrayList();
        int check_outs = to_users.get_check_outs();
        try {
            Connection conn = MyConnection1.connect();

            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",sum(price*qty)"
                    + ",sum(qty)"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status"
                    + ",disc_name"
                    + ",disc_rate"
                    + ",(discount)"
                    + ",customer_name"
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",guest_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",sub_category_id "
                    + " from " + MyDB.getNames() + ".customer_tables_details "
                    + " where "
                    + "table_no_id = '" + room_no + "' "
                    + "and status <>'" + "1" + "' "
                    + "and cat_id<>'" + "11" + "' and cat_id<>'" + "10" + "' and cat_id<>'" + "12" + "' "
                    + "group by guest_id,description ";

            String accomodation_id = System.getProperty("accomodation", "11");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String saved_name = "";
//            JOptionPane.showMessageDialog(null, all_guests);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                if (all_guests == 0 || all_guests > 1) {

                    desc = desc + " - " + rs.getString(23).
                            toUpperCase();
                }
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(25);
                String sub_category_id = rs.getString(26);

                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
//               
//                if (cat_id.equals(accomodation_id)) {
//                    price = ((price * nights));
////                    JOptionPane.showMessageDialog(null, guest_no);
//                }
//                price = ((price * qty) - discount);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }
//                 JOptionPane.showMessageDialog(null, nights);
                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                        datas.add(to);
                        saved_name = names;
                    }
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_items_room3(String room_no) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",qty"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status "
                    + ",disc_name "
                    + ",disc_rate "
                    + ",discount"
                    + ",customer_name "
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",sub_category_id "
                    + "from " + MyDB.getNames() + ".customer_tables_details2 "
                    + "where "
                    + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_guest_orders(String room_no, String guest_name) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",qty"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status "
                    + ",disc_name "
                    + ",disc_rate "
                    + ",discount"
                    + ",customer_name "
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",sub_category_id "
                    + ",order_no"
                    + " from " + MyDB.getNames() + ".customer_tables_details "
                    + " where "
                    + "table_no_id = '" + room_no + "' and status<>'" + "1" + "' and guest_name like '%" + guest_name + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);
                String order_no = rs.getString(26);
//                System.out.println(desc + " 0asdasd");
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static int count_other_orders_where(String where_others) {

        int count = 0;

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "count(id)"
                    + "from " + MyDB.getNames() + ".customer_tables_details "
                    + " " + where_others + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;

        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }

    }

    public static List<to_items> ret_guest_orders_where(String room_no, String where, int selected_guest, int all_guest, String where_guest_11, String where_guest_11_dive) {

        List<to_items> holder = new ArrayList();
        List<to_items> others = new ArrayList();

        int check_outs = to_users.get_check_outs();
//        JOptionPane.showMessageDialog(null, check_outs);
        String accomodation_id = System.getProperty("accomodation_id", "11");//or table_no_id = '" + room_no + "' and status='" + "0" + "' and cat_id='" + accomodation_id + "'
        List<to_items> datas2 = new ArrayList();
        if (to_users.user_level1.equals("5")) {
            datas2 = ret_guest_orders_where_11(room_no, where, selected_guest, all_guest, where_guest_11, where_guest_11_dive);
//             JOptionPane.showMessageDialog(null, datas2.size());
//            others =  ret_guest_orders_where_11_dives(room_no, where, selected_guest, all_guest, where_guest_11);           
        }
        holder.addAll(datas2);
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + " product_name"
                    + ",description"
                    + ",price"
                    + ",sum(qty)"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status "
                    + ",disc_name "
                    + ",disc_rate "
                    + ",discount"
                    + ",customer_name "
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",sub_category_id "
                    + ",order_no"
                    + ",id"
                    + " from " + MyDB.getNames() + ".customer_tables_details "
                    + " " + where + "  group by product_name,Date(date_added),price,discount order by date_added asc "; //
//            System.out.println(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String saved_name = "";
            int day_count = 0;
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);

                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);

                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
//                System.out.println(desc + " 0asdasd");
                int group_id = rs.getInt(17);

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);
                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);
                String order_no = rs.getString(26);
                int id = rs.getInt(27);
//                System.out.println("id: " + id + " names: " + names + " Discount: " + discount+" qty: "+qty);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                if (cat_id.equals(accomodation_id)) {
                    price = (price);
                }
//                price = ((qty * price) - discount);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }
//                System.out.println("desc: "+desc+ " price: "+price);
                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }

                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }
                }

            }

            return holder;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_guest_orders_where_11(String room_no, String where, int selected_guest, int all_guest, String where_guest_11, String where_guest_11_dive) {

        List<to_items> holder = new ArrayList();
        List<to_items> new_data = new ArrayList();

        int check_outs = to_users.get_check_outs();
//        JOptionPane.showMessageDialog(null, check_outs);
        String accomodation_id = System.getProperty("accomodation_id", "11");//or table_no_id = '" + room_no + "' and status='" + "0" + "' and cat_id='" + accomodation_id + "'
        List<to_items> datas = new ArrayList();

        datas = ret_guest_orders_where_11_dives(room_no, where, selected_guest, all_guest, where_guest_11, where_guest_11_dive);
        holder.addAll(datas);
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "ct.product_name"
                    + ",ct.description"
                    + ",(ct.price)"
                    + ",sum(ct.qty)"
                    + ",ct.img_path "
                    + ",ct.guest_id "
                    + ",ct.cat_id "
                    + ",ct.printing_assembly "
                    + ",ct.status "
                    + ",ct.disc_name "
                    + ",ct.disc_rate "
                    + ",(ct.discount)"
                    + ",ct.customer_name "
                    + ",ct.customer_id"
                    + ",ct.customer_address "
                    + ",ct.date_added "
                    + ",ct.group_id "
                    + ",ct.nights "
                    + ",ct.guest_no "
                    + ",ct.check_out "
                    + ",ct.room_guest_id "
                    + ",ct.user_name "
                    + ",ct.category_name"
                    + ",ct.sub_category_name "
                    + ",ct.sub_category_id "
                    + ",ct.order_no"
                    //                    + ",(select i.item_package_id from " + MyDB.getNames() + ".inventory2_stocks_left i where i.product_name=ct.product_name order by id desc limit 1)"
                    + " from " + MyDB.getNames() + ".customer_tables_details ct "
                    + " " + where_guest_11 + " group by ct.guest_id,ct.product_name,ct.price,ct.discount";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String saved_name = "";
            int day_count = 0;
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
//                System.out.println("Names: " + names + ", desc: " + desc);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
//                System.out.println(desc + " 0asdasd");
                int group_id = rs.getInt(17);

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);

                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);
                String order_no = rs.getString(26);

                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
//                if (cat_id.equals(accomodation_id)) {
//                    price = (price * nights);
//                }
//                price = ((qty * price) - discount);
//                System.out.println("desc: "+desc+ " price: "+price);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }
                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }

                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }
                }

            }

            return holder;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_guest_orders_where_11_dives(String room_no, String where, int selected_guest, int all_guest, String where_guest_11, String where_guest_11_dive) {

        List<to_items> holder = new ArrayList();
        List<to_items> new_data = new ArrayList();

        int check_outs = to_users.get_check_outs();
//        JOptionPane.showMessageDialog(null, check_outs);
        String accomodation_id = System.getProperty("accomodation_id", "11");//or table_no_id = '" + room_no + "' and status='" + "0" + "' and cat_id='" + accomodation_id + "'
        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "ct.product_name"
                    + ",ct.description"
                    + ",ct.price"
                    + ",sum(ct.qty)"
                    + ",ct.img_path "
                    + ",ct.guest_id "
                    + ",ct.cat_id "
                    + ",ct.printing_assembly "
                    + ",ct.status "
                    + ",ct.disc_name "
                    + ",ct.disc_rate "
                    + ",(ct.discount)"
                    + ",ct.customer_name "
                    + ",ct.customer_id"
                    + ",ct.customer_address "
                    + ",ct.date_added "
                    + ",ct.group_id "
                    + ",ct.nights "
                    + ",ct.guest_no "
                    + ",ct.check_out "
                    + ",ct.room_guest_id "
                    + ",ct.user_name "
                    + ",ct.guest_name "
                    + ",ct.category_name "
                    + ",ct.sub_category_name "
                    + ",ct.sub_category_id "
                    + ",ct.order_no"
                    + ",(select i.item_package_id from " + MyDB.getNames() + ".inventory2_stocks_left i where i.product_name=ct.product_name order by id desc limit 1)"
                    + " from " + MyDB.getNames() + ".customer_tables_details ct "
                    + " " + where_guest_11_dive + " group by ct.guest_id,ct.product_name,ct.discount";
//            System.out.println(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String saved_name = "";
            int day_count = 0;
//            JOptionPane.showMessageDialog(null, selected_guest + " "+all_guest);
            while (rs.next()) {

                String names = rs.getString(1);
                String desc = rs.getString(2);

                String guest_id = rs.getString(6);
                if (selected_guest > 1 || (all_guest > 1 && selected_guest == 0) || selected_guest == 0) {
                    desc = desc + " - " + rs.getString(23).
                            toUpperCase();
                }
                double price = rs.getDouble(3);
//                System.out.println("desc: " + desc + " = " + price);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);

                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
//                System.out.println(desc + " 0asdasd");
                int group_id = rs.getInt(17);

                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);

                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(25);
                String sub_category_id = rs.getString(26);
                String order_no = rs.getString(27);
                int item_package = rs.getInt(28);

                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }

                if (item_package == 1) {
                    String s3 = "select "
                            + " range_from"
                            + ",range_to"
                            + ",rate"
                            + ",description"
                            + " from " + MyDB.getNames() + ".item_packages where "
                            + " product_name ='" + names + "' "
                            + " ";
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);

                    while (rs3.next()) {

                        int range_from = FitIn.toInt(rs3.getString(1));
                        int range_to = FitIn.toInt(rs3.getString(2));
                        double rate = FitIn.toInt(rs3.getString(3));

                        if (qty >= range_from && qty <= range_to) {
                            price = rate;
                            if (selected_guest > 1) {
                                desc = rs3.getString(4) + " - " + rs.getString(23).
                                        toUpperCase();
                            }

                        }
                    }
                }

//                if (cat_id.equals(accomodation_id)) {
//                    price = (price * nights);
//                }
//                price = ((qty * price) - discount);
                if (discount != 0) {
                    desc = desc + "             @ " + FitIn.fmt_wc_0(disc_rate * 100) + "% DISCOUNT";
                }
                if (price != 0) {
                    if (check_outs == 0 && cat_id.equals("11")) {
                    } else {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }

                } else {
                    if (!cat_id.equals("11") && price == 0) {
                        to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, order_no);
                        holder.add(to);
                    }
                }

            }

            return holder;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_items> ret_guest_orders_where3(String room_no, String where) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "product_name"
                    + ",description"
                    + ",price"
                    + ",qty"
                    + ",img_path "
                    + ",guest_id "
                    + ",cat_id "
                    + ",printing_assembly "
                    + ",status "
                    + ",disc_name "
                    + ",disc_rate "
                    + ",discount"
                    + ",customer_name "
                    + ",customer_id"
                    + ",customer_address "
                    + ",date_added "
                    + ",group_id "
                    + ",nights "
                    + ",guest_no "
                    + ",check_out "
                    + ",room_guest_id "
                    + ",user_name "
                    + ",category_name "
                    + ",sub_category_name "
                    + ",category_id "
                    + "from " + MyDB.getNames() + ".customer_tables_details2 "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                int nights = rs.getInt(18);
                int guest_no = rs.getInt(19);

                String check_out = rs.getString(20);
                String room_guest_id = rs.getString(21);
                String user_name = rs.getString(22);
                String sub_category_name = rs.getString(24);
                String sub_category_id = rs.getString(25);

                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                        + "cat_name"
                        + " from " + MyDB.getNames() + ".category where "
                        + " id ='" + cat_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id, nights, guest_no, check_out, room_guest_id, user_name, 0, sub_category_name, sub_category_id, "");
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_guest_chargers_where(String room_no, String where) {

        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_guest_chargers_where3(String room_no, String where) {

        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges2 "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static int ret_guest_charge_count(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        int charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "checkin_date "
                    + "from " + MyDB.getNames() + ".room_guests"
                    + "" + where + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs.getString(1));
                charge = DateUtils.count_days(d, new Date());
//                charge = rs.getInt(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_guest_charge_(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_table_charge(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges "
                    + " " + where + "";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_guest_chargers_where_all(String room_no) {

        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges "
                    + " where status='" + "0" + "' and table_no = '" + room_no + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double ret_guest_chargers_where_all3(String room_no) {

        double charge = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount)"
                    + "from " + MyDB.getNames() + ".guest_charges2 "
                    + " where status='" + "0" + "' and table_no = '" + room_no + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static class item_packages {

        public final int range_from;
        public final int range_to;
        public final double rate;

        public item_packages(int range_from, int range_to, double rate) {
            this.range_from = range_from;
            this.range_to = range_to;
            this.rate = rate;
        }

    }
}
