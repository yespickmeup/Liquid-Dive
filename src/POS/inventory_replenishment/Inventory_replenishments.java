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
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Inventory_replenishments {

    public static class to_inventory_replenishments {

        public final int id;
        public final String replenishment_no;
        public final String date_added;
        public final String added_by;
        public final String remarks;
        public final int status;
        public final int no_of_items;

        public to_inventory_replenishments(int id, String replenishment_no, String date_added, String added_by, String remarks, int status, int no_of_items) {
            this.id = id;
            this.replenishment_no = replenishment_no;
            this.date_added = date_added;
            this.added_by = added_by;
            this.remarks = remarks;
            this.status = status;
            this.no_of_items = no_of_items;
        }
    }

    public static void add_data(to_inventory_replenishments to_inventory_replenishments, List<Inventory_replenishment_items.to_inventory_replenishment_items> to_inventory_replenishment_items1) {
        try {
            Connection conn = MyConnection1.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into " + MyDB.getNames() + ".inventory_replenishments("
                    + "replenishment_no"
                    + ",date_added"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",no_of_items"
                    + ")values("
                    + ":replenishment_no"
                    + ",:date_added"
                    + ",:added_by"
                    + ",:remarks"
                    + ",:status"
                    + ",:no_of_items"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("replenishment_no", to_inventory_replenishments.replenishment_no)
                    .setString("date_added", to_inventory_replenishments.date_added)
                    .setString("added_by", to_inventory_replenishments.added_by)
                    .setString("remarks", to_inventory_replenishments.remarks)
                    .setNumber("status", to_inventory_replenishments.status)
                    .setNumber("no_of_items", to_inventory_replenishments.no_of_items)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Inventory_replenishment_items.to_inventory_replenishment_items to_inventory_replenishment_items : to_inventory_replenishment_items1) {
                String s2 = "insert into " + MyDB.getNames() + ".inventory_replenishment_items("
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

                s2 = SqlStringUtil.parse(s2)
                        .setString("replenishment_no", to_inventory_replenishments.replenishment_no)
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
                        .setString("date_added", to_inventory_replenishments.date_added)
                        .setString("added_by", to_inventory_replenishments.added_by)
                        .setString("remarks", to_inventory_replenishments.remarks)
                        .ok();
                stmt.addBatch(s2);

                String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set product_qty='" + 0 + "' where product_name='" + to_inventory_replenishment_items.item_code + "' ";
                stmt.addBatch(s1);
//                double new_qty = 0;
//                String s3 = "select product_qty from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + to_stock_in.prod_num + "' ";
//                Statement stmt2 = conn.createStatement();
//                ResultSet rs = stmt2.executeQuery(s3);
//                if (rs.next()) {
//                    new_qty = rs.getDouble(1);
//                }
//
//                new_qty += to_stock_in.qty;

            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Inventory_replenishments.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_inventory_replenishments to_inventory_replenishments) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory_replenishments set "
                    + "replenishment_no= :replenishment_no "
                    + ",date_added= :date_added "
                    + ",added_by= :added_by "
                    + ",remarks= :remarks "
                    + ",status= :status "
                    + ",no_of_items= :no_of_items "
                    + " where id='" + to_inventory_replenishments.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("replenishment_no", to_inventory_replenishments.replenishment_no)
                    .setString("date_added", to_inventory_replenishments.date_added)
                    .setString("added_by", to_inventory_replenishments.added_by)
                    .setString("remarks", to_inventory_replenishments.remarks)
                    .setNumber("status", to_inventory_replenishments.status)
                    .setNumber("no_of_items", to_inventory_replenishments.no_of_items)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            Lg.s(Inventory_replenishments.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_inventory_replenishments to_inventory_replenishments) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".inventory_replenishments  "
                    + " where id='" + to_inventory_replenishments.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Inventory_replenishments.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_inventory_replenishments> ret_data(String where) {
        List<to_inventory_replenishments> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",replenishment_no"
                    + ",date_added"
                    + ",added_by"
                    + ",remarks"
                    + ",status"
                    + ",no_of_items"
                    + " from " + MyDB.getNames() + ".inventory_replenishments"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String replenishment_no = rs.getString(2);
                String date_added = rs.getString(3);
                String added_by = rs.getString(4);
                String remarks = rs.getString(5);
                int status = rs.getInt(6);
                int no_of_items = rs.getInt(7);

                to_inventory_replenishments to = new to_inventory_replenishments(id, replenishment_no, date_added, added_by, remarks, status, no_of_items);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String increment_id() {
        String id = "000000000000";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select max(id) from " + MyDB.getNames() + ".inventory_replenishments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select replenishment_no from " + MyDB.getNames() + ".inventory_replenishments where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "000000000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
