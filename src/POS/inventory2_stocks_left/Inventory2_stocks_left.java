/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory2_stocks_left;

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
public class Inventory2_stocks_left {

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
        public boolean is_selected;

        public to_inventory2_stocks_left(int id, String lookup_code, int prod_num, String product_name, String description, double price, double product_qty, String types, String types_num, String is_vat, int prod_assembly, int is_linient, int w_commission, double comm_amount, int cat_id, double cost, String img_path, int printing_assembly, int is_active, int group_id, String item_package_id, int happy_hour, boolean is_selected) {
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
            this.is_selected = is_selected;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }
        
    }

    public static void add_data(to_inventory2_stocks_left to_inventory2_stocks_left) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".inventory2_stocks_left("
                    + "lookup_code"
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
                    + ")values("
                    + ":lookup_code"
                    + ",:prod_num"
                    + ",:product_name"
                    + ",:description"
                    + ",:price"
                    + ",:product_qty"
                    + ",:types"
                    + ",:types_num"
                    + ",:is_vat"
                    + ",:prod_assembly"
                    + ",:is_linient"
                    + ",:w_commission"
                    + ",:comm_amount"
                    + ",:cat_id"
                    + ",:cost"
                    + ",:img_path"
                    + ",:printing_assembly"
                    + ",:is_active"
                    + ",:group_id"
                    + ",:item_package_id"
                    + ",:happy_hour"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("lookup_code", to_inventory2_stocks_left.lookup_code)
                    .setNumber("prod_num", to_inventory2_stocks_left.prod_num)
                    .setString("product_name", to_inventory2_stocks_left.product_name)
                    .setString("description", to_inventory2_stocks_left.description)
                    .setNumber("price", to_inventory2_stocks_left.price)
                    .setNumber("product_qty", to_inventory2_stocks_left.product_qty)
                    .setString("types", to_inventory2_stocks_left.types)
                    .setString("types_num", to_inventory2_stocks_left.types_num)
                    .setString("is_vat", to_inventory2_stocks_left.is_vat)
                    .setNumber("prod_assembly", to_inventory2_stocks_left.prod_assembly)
                    .setNumber("is_linient", to_inventory2_stocks_left.is_linient)
                    .setNumber("w_commission", to_inventory2_stocks_left.w_commission)
                    .setNumber("comm_amount", to_inventory2_stocks_left.comm_amount)
                    .setNumber("cat_id", to_inventory2_stocks_left.cat_id)
                    .setNumber("cost", to_inventory2_stocks_left.cost)
                    .setString("img_path", to_inventory2_stocks_left.img_path)
                    .setNumber("printing_assembly", to_inventory2_stocks_left.printing_assembly)
                    .setNumber("is_active", to_inventory2_stocks_left.is_active)
                    .setNumber("group_id", to_inventory2_stocks_left.group_id)
                    .setString("item_package_id", to_inventory2_stocks_left.item_package_id)
                    .setNumber("happy_hour", to_inventory2_stocks_left.happy_hour)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory2_stocks_left.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_inventory2_stocks_left to_inventory2_stocks_left) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                    + "lookup_code= :lookup_code "
                    + ",prod_num= :prod_num "
                    + ",product_name= :product_name "
                    + ",description= :description "
                    + ",price= :price "
                    + ",product_qty= :product_qty "
                    + ",types= :types "
                    + ",types_num= :types_num "
                    + ",is_vat= :is_vat "
                    + ",prod_assembly= :prod_assembly "
                    + ",is_linient= :is_linient "
                    + ",w_commission= :w_commission "
                    + ",comm_amount= :comm_amount "
                    + ",cat_id= :cat_id "
                    + ",cost= :cost "
                    + ",img_path= :img_path "
                    + ",printing_assembly= :printing_assembly "
                    + ",is_active= :is_active "
                    + ",group_id= :group_id "
                    + ",item_package_id= :item_package_id "
                    + ",happy_hour= :happy_hour "
                    + " where id='" + to_inventory2_stocks_left.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("lookup_code", to_inventory2_stocks_left.lookup_code)
                    .setNumber("prod_num", to_inventory2_stocks_left.prod_num)
                    .setString("product_name", to_inventory2_stocks_left.product_name)
                    .setString("description", to_inventory2_stocks_left.description)
                    .setNumber("price", to_inventory2_stocks_left.price)
                    .setNumber("product_qty", to_inventory2_stocks_left.product_qty)
                    .setString("types", to_inventory2_stocks_left.types)
                    .setString("types_num", to_inventory2_stocks_left.types_num)
                    .setString("is_vat", to_inventory2_stocks_left.is_vat)
                    .setNumber("prod_assembly", to_inventory2_stocks_left.prod_assembly)
                    .setNumber("is_linient", to_inventory2_stocks_left.is_linient)
                    .setNumber("w_commission", to_inventory2_stocks_left.w_commission)
                    .setNumber("comm_amount", to_inventory2_stocks_left.comm_amount)
                    .setNumber("cat_id", to_inventory2_stocks_left.cat_id)
                    .setNumber("cost", to_inventory2_stocks_left.cost)
                    .setString("img_path", to_inventory2_stocks_left.img_path)
                    .setNumber("printing_assembly", to_inventory2_stocks_left.printing_assembly)
                    .setNumber("is_active", to_inventory2_stocks_left.is_active)
                    .setNumber("group_id", to_inventory2_stocks_left.group_id)
                    .setString("item_package_id", to_inventory2_stocks_left.item_package_id)
                    .setNumber("happy_hour", to_inventory2_stocks_left.happy_hour)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory2_stocks_left.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_inventory2_stocks_left to_inventory2_stocks_left) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".inventory2_stocks_left  "
                    + " where id='" + to_inventory2_stocks_left.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory2_stocks_left.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_inventory2_stocks_left> ret_data(String where) {
        List<to_inventory2_stocks_left> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "i.id"
                    + ",i.lookup_code"
                    + ",i.prod_num"
                    + ",i.product_name"
                    + ",i.description"
                    + ",i.price"
                    + ",i.product_qty"
                    + ",i.types"
                    + ",i.types_num"
                    + ",i.is_vat"
                    + ",i.prod_assembly"
                    + ",i.is_linient"
                    + ",i.w_commission"
                    + ",i.comm_amount"
                    + ",i.cat_id"
                    + ",i.cost"
                    + ",c.cat_name"
                    + ",i.printing_assembly"
                    + ",i.is_active"
                    + ",i.group_id"
                    + ",i.item_package_id"
                    + ",i.happy_hour"
                    + " from " + MyDB.getNames() + ".inventory2_stocks_left i "
                    + " join " + MyDB.getNames() + ".category c on"
                    + " c.id=i.cat_id "
                    + " " + where;

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

                to_inventory2_stocks_left to = new to_inventory2_stocks_left(id, lookup_code, prod_num, product_name, description, price, product_qty, types, types_num, is_vat, prod_assembly, is_linient, w_commission, comm_amount, cat_id, cost, img_path, printing_assembly, is_active, group_id, item_package_id, happy_hour, false);
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
