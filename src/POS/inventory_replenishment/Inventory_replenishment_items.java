/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory_replenishment;

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
public class Inventory_replenishment_items {

    public static class to_inventory_replenishment_items {

        public final int id;
        public final String replenishment_no;
        public final String item_code;
        public final String description;
        public final double product_qty;
        public final double price;
        public final double cost;
        public final String category;
        public final String category_id;
        public final String sub_category;
        public final String sub_category_id;
        public final int is_active;
        public final int item_package;
        public final int status;
        public final String date_added;
        public final String added_by;
        public final String remarks;

        public to_inventory_replenishment_items(int id, String replenishment_no, String item_code, String description, double product_qty, double price, double cost, String category, String category_id, String sub_category, String sub_category_id, int is_active, int item_package, int status, String date_added, String added_by, String remarks) {
            this.id = id;
            this.replenishment_no = replenishment_no;
            this.item_code = item_code;
            this.description = description;
            this.product_qty = product_qty;
            this.price = price;
            this.cost = cost;
            this.category = category;
            this.category_id = category_id;
            this.sub_category = sub_category;
            this.sub_category_id = sub_category_id;
            this.is_active = is_active;
            this.item_package = item_package;
            this.status = status;
            this.date_added = date_added;
            this.added_by = added_by;
            this.remarks = remarks;
        }
    }

    public static void add_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".inventory_replenishment_items("
                    + "replenishment_no"
                    + ",item_code"
                    + ",description"
                    + ",product_qty"
                    + ",price"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",sub_category"
                    + ",sub_category_id"
                    + ",is_active"
                    + ",item_package"
                    + ",status"
                    + ",date_added"
                    + ",added_by"
                    + ",remarks"
                    + ")values("
                    + ":replenishment_no"
                    + ",:item_code"
                    + ",:description"
                    + ",:product_qty"
                    + ",:price"
                    + ",:cost"
                    + ",:category"
                    + ",:category_id"
                    + ",:sub_category"
                    + ",:sub_category_id"
                    + ",:is_active"
                    + ",:item_package"
                    + ",:status"
                    + ",:date_added"
                    + ",:added_by"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("replenishment_no", to_inventory_replenishment_items.replenishment_no)
                    .setString("item_code", to_inventory_replenishment_items.item_code)
                    .setString("description", to_inventory_replenishment_items.description)
                    .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                    .setNumber("price", to_inventory_replenishment_items.price)
                    .setNumber("cost", to_inventory_replenishment_items.cost)
                    .setString("category", to_inventory_replenishment_items.category)
                    .setString("category_id", to_inventory_replenishment_items.category_id)
                    .setString("sub_category", to_inventory_replenishment_items.sub_category)
                    .setString("sub_category_id", to_inventory_replenishment_items.sub_category_id)
                    .setNumber("is_active", to_inventory_replenishment_items.is_active)
                    .setNumber("item_package", to_inventory_replenishment_items.item_package)
                    .setNumber("status", to_inventory_replenishment_items.status)
                    .setString("date_added", to_inventory_replenishment_items.date_added)
                    .setString("added_by", to_inventory_replenishment_items.added_by)
                    .setString("remarks", to_inventory_replenishment_items.remarks)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory_replenishment_items set "
                    + "replenishment_no= :replenishment_no "
                    + ",item_code= :item_code "
                    + ",description= :description "
                    + ",product_qty= :product_qty "
                    + ",price= :price "
                    + ",cost= :cost "
                    + ",category= :category "
                    + ",category_id= :category_id "
                    + ",sub_category= :sub_category "
                    + ",sub_category_id= :sub_category_id "
                    + ",is_active= :is_active "
                    + ",item_package= :item_package "
                    + ",status= :status "
                    + ",date_added= :date_added "
                    + ",added_by= :added_by "
                    + ",remarks= :remarks "
                    + " where id='" + to_inventory_replenishment_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("replenishment_no", to_inventory_replenishment_items.replenishment_no)
                    .setString("item_code", to_inventory_replenishment_items.item_code)
                    .setString("description", to_inventory_replenishment_items.description)
                    .setNumber("product_qty", to_inventory_replenishment_items.product_qty)
                    .setNumber("price", to_inventory_replenishment_items.price)
                    .setNumber("cost", to_inventory_replenishment_items.cost)
                    .setString("category", to_inventory_replenishment_items.category)
                    .setString("category_id", to_inventory_replenishment_items.category_id)
                    .setString("sub_category", to_inventory_replenishment_items.sub_category)
                    .setString("sub_category_id", to_inventory_replenishment_items.sub_category_id)
                    .setNumber("is_active", to_inventory_replenishment_items.is_active)
                    .setNumber("item_package", to_inventory_replenishment_items.item_package)
                    .setNumber("status", to_inventory_replenishment_items.status)
                    .setString("date_added", to_inventory_replenishment_items.date_added)
                    .setString("added_by", to_inventory_replenishment_items.added_by)
                    .setString("remarks", to_inventory_replenishment_items.remarks)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_inventory_replenishment_items to_inventory_replenishment_items) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".inventory_replenishment_items  "
                    + " where id='" + to_inventory_replenishment_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishment_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_inventory_replenishment_items> ret_data(String where) {
        List<to_inventory_replenishment_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",replenishment_no"
                    + ",item_code"
                    + ",description"
                    + ",product_qty"
                    + ",price"
                    + ",cost"
                    + ",category"
                    + ",category_id"
                    + ",sub_category"
                    + ",sub_category_id"
                    + ",is_active"
                    + ",item_package"
                    + ",status"
                    + ",date_added"
                    + ",added_by"
                    + ",remarks"
                    + " from " + MyDB.getNames() + ".inventory_replenishment_items"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String replenishment_no = rs.getString(2);
                String item_code = rs.getString(3);
                String description = rs.getString(4);
                double product_qty = rs.getDouble(5);
                double price = rs.getDouble(6);
                double cost = rs.getDouble(7);
                String category = rs.getString(8);
                String category_id = rs.getString(9);
                String sub_category = rs.getString(10);
                String sub_category_id = rs.getString(11);
                int is_active = rs.getInt(12);
                int item_package = rs.getInt(13);
                int status = rs.getInt(14);
                String date_added = rs.getString(15);
                String added_by = rs.getString(16);
                String remarks = rs.getString(17);

                to_inventory_replenishment_items to = new to_inventory_replenishment_items(id, replenishment_no, item_code, description, product_qty, price, cost, category, category_id, sub_category, sub_category_id, is_active, item_package, status, date_added, added_by, remarks);
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
