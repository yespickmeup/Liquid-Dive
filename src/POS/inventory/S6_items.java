/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main.MyDB;
import POS.to2.to_add_product;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.PoolConnection;

/**
 *
 * @author Dummy
 */
public class S6_items {

    public static class to_inventory2_stocks_left {

        public final int id;
        public final String lookup_code;
        public final int prod_num;
        public final String product_name;
        public final String description;
        public final double price;
        public final double product_qty;
        public final String types;
        public final String types_num;
        public final String is_vat;
        public final int prod_assembly;
        public final int is_linient;
        public final int w_commission;
        public final double comm_amount;
        public final int cat_id;
        public final double cost;
        public final String img_path;
        public final int printing_assembly;
        public final int is_active;
        public final int group_id;
        public final String item_package_id;
        public final int happy_hour;

        public to_inventory2_stocks_left(int id, String lookup_code, int prod_num, String product_name, String description, double price, double product_qty, String types, String types_num, String is_vat, int prod_assembly, int is_linient, int w_commission, double comm_amount, int cat_id, double cost, String img_path, int printing_assembly, int is_active, int group_id, String item_package_id, int happy_hour) {
            this.id = id;
            this.lookup_code = lookup_code;
            this.prod_num = prod_num;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.product_qty = product_qty;
            this.types = types;
            this.types_num = types_num;
            this.is_vat = is_vat;
            this.prod_assembly = prod_assembly;
            this.is_linient = is_linient;
            this.w_commission = w_commission;
            this.comm_amount = comm_amount;
            this.cat_id = cat_id;
            this.cost = cost;
            this.img_path = img_path;
            this.printing_assembly = printing_assembly;
            this.is_active = is_active;
            this.group_id = group_id;
            this.item_package_id = item_package_id;
            this.happy_hour = happy_hour;
        }
    }

    public static void edit_data(to_add_product to_add_product, String is_linient, String is_active, String type, String type_id, int happy_hour) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                    + "product_name= '" + to_add_product.name + "'"
                    + ",description= '" + to_add_product.desc + "'"
                    + ",price= '" + to_add_product.price + "'"
                    + ",product_qty= '" + to_add_product.qty + "'"
                    + ",is_vat= '" + to_add_product.vat + "'"
                    + ",prod_assembly= '" + "0" + "'"
                    + ",is_linient= '" + is_linient + "'"
                    + ",w_commission= '" + to_add_product.w_commission + "'"
                    + ",comm_amount= '" + to_add_product.comm_amount + "'"
                    + ",cat_id= '" + to_add_product.cat_id + "'"
                    + ",cost= '" + to_add_product.cost + "'"
                    + ",img_path= '" + "empty" + "'"
                    + ",printing_assembly= '" + to_add_product.printing_assembly + "'"
                    + ",is_active= '" + is_active + "'"
                    + ",happy_hour= '" + to_add_product.happy_hour + "'"
                    + ",types= '" + to_add_product.type_name + "'"
                    + ",types_num= '" + to_add_product.type_id + "'"
                    //                        + ",types= '" + type + "'"
                    //                        + ",types_num= '" + type_id + "'"
                    + "where "
                    + " product_name ='" + to_add_product.name + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_type(String num, String cat_id, String type, String type_id) {
//        JOptionPane.showMessageDialog(null, num + ", " + cat_id + " = " + type + " " + type_id);C
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                    + "types= '" + type + "' "
                    + ",types_num= '" + type_id + "' "
                    + ",cat_id= '" + cat_id + "' "
                    + "where "
                    + " prod_num ='" + num + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static class to_types {

        public final String cat_id;
        public final String type_id;

        public to_types(String cat_id, String type_id) {
            this.cat_id = cat_id;
            this.type_id = type_id;
        }
    }

    public static to_types select_type(String cat_name, String type_name) {

        to_types to = new to_types("0", "0");

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select cat_num from " + MyDB.getNames() + ".category "
                    + "where "
                    + " cat_name ='" + cat_name + "' "
                    + " ";

            String cat_id = "0";
            String type_id = "0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cat_id = rs.getString(1);
            }
//           
            String s2 = "select type_num from " + MyDB.getNames() + ".category_type "
                    + "where "
                    + " type_name ='" + type_name + "' and cat_num='" + cat_id + "' "
                    + " ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            if (rs2.next()) {
                type_id = rs2.getString(1);
            }

            to = new to_types(cat_id, type_id);
//            JOptionPane.showMessageDialog(null, to.cat_id + " = " + cat_name);
            return to;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_data_active(String barcode, String is_active) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                    + "is_active= '" + is_active + "'"
                    + "where "
                    + " product_name ='" + barcode + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_add_product to_inventory2_stocks_left) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".inventory2_stocks_left where "
                    + " product_name ='" + to_inventory2_stocks_left.name + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }

    public static List<S6_items.to_inventory2_stocks_left> ret_data(String search) {
        List<S6_items.to_inventory2_stocks_left> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",lookup_code"
                    + ",prod_num"
                    + ",product_name"
                    + ",description"
                    + ",price"
                    + ",product_qty"
                    + ",types"
                    + ",types_num"
                    + ",is_vat"
                    + ",prod_assembly"
                    + ",is_linient"
                    + ",w_commission"
                    + ",comm_amount"
                    + ",cat_id"
                    + ",cost"
                    + ",img_path"
                    + ",printing_assembly"
                    + ",is_active"
                    + ",group_id"
                    + ",item_package_id"
                    + ",happy_hour"
                    + " from db_pos_restaurant.inventory2_stocks_left where "
                    + " description like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String lookup_code = rs.getString(2);
                int prod_num = rs.getInt(3);
                String product_name = rs.getString(4);
                String description = rs.getString(5);
                double price = rs.getDouble(6);
                double product_qty = rs.getDouble(7);
                String types = rs.getString(8);
                String types_num = rs.getString(9);
                String is_vat = rs.getString(10);
                int prod_assembly = rs.getInt(11);
                int is_linient = rs.getInt(12);
                int w_commission = rs.getInt(13);
                double comm_amount = rs.getDouble(14);
                int cat_id = rs.getInt(15);
                double cost = rs.getDouble(16);
                String img_path = rs.getString(17);
                int printing_assembly = rs.getInt(18);
                int is_active = rs.getInt(19);
                int group_id = rs.getInt(20);
                String item_package_id = rs.getString(21);
                int happy_hour = rs.getInt(22);
                S6_items.to_inventory2_stocks_left to = new S6_items.to_inventory2_stocks_left(id, lookup_code, prod_num, product_name, description, price, product_qty, types, types_num, is_vat, prod_assembly, is_linient, w_commission, comm_amount, cat_id, cost, img_path, printing_assembly, is_active, group_id, item_package_id, happy_hour);
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
