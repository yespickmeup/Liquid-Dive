/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_in;

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
public class Stock_in_main {

    public static class to_stock_in_main {

        public final int id;
        public final String ref_no;
        public final int item_count;
        public final double total_cost;
        public final String date_added;
        public final String branch;
        public final int branch_id;
        public final String user_name;
        public final int user_id;
        public final int status;
        public final String remarks;
        public final String supplier;

        public to_stock_in_main(int id, String ref_no, int item_count, double total_cost, String date_added, String branch, int branch_id, String user_name, int user_id, int status, String remarks, String supplier) {
            this.id = id;
            this.ref_no = ref_no;
            this.item_count = item_count;
            this.total_cost = total_cost;
            this.date_added = date_added;
            this.branch = branch;
            this.branch_id = branch_id;
            this.user_name = user_name;
            this.user_id = user_id;
            this.status = status;
            this.remarks = remarks;
            this.supplier = supplier;
        }
    }

    public static void add_data(to_stock_in_main to_stock_in_main, List<Stock_in.to_stock_in> items) {
        try {
            Connection conn = MyConnection1.connect();
            conn.setAutoCommit(false);
            String s0 = "insert into " + MyDB.getNames() + ".stock_in_main("
                    + "ref_no"
                    + ",item_count"
                    + ",total_cost"
                    + ",date_added"
                    + ",branch"
                    + ",branch_id"
                    + ",user_name"
                    + ",user_id"
                    + ",status"
                    + ",remarks"
                    + ",supplier"
                    + ")values("
                    + ":ref_no"
                    + ",:item_count"
                    + ",:total_cost"
                    + ",:date_added"
                    + ",:branch"
                    + ",:branch_id"
                    + ",:user_name"
                    + ",:user_id"
                    + ",:status"
                    + ",:remarks"
                    + ",:supplier"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("ref_no", to_stock_in_main.ref_no)
                    .setNumber("item_count", to_stock_in_main.item_count)
                    .setNumber("total_cost", to_stock_in_main.total_cost)
                    .setString("date_added", to_stock_in_main.date_added)
                    .setString("branch", to_stock_in_main.branch)
                    .setNumber("branch_id", to_stock_in_main.branch_id)
                    .setString("user_name", to_stock_in_main.user_name)
                    .setNumber("user_id", to_stock_in_main.user_id)
                    .setNumber("status", to_stock_in_main.status)
                    .setString("remarks", to_stock_in_main.remarks)
                    .setString("supplier", to_stock_in_main.supplier)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            for (Stock_in.to_stock_in to_stock_in : items) {
                String s2 = "insert into " + MyDB.getNames() + ".stock_in("
                        + "prod_num"
                        + ",prod_name"
                        + ",qty"
                        + ",amount"
                        + ",date_added"
                        + ",cashier_name"
                        + ",cashier_id"
                        + ",remarks"
                        + ",branch_id"
                        + ",branch"
                        + ",status"
                        + ",cost"
                        + ",types"
                        + ",types_num"
                        + ",cat_id"
                        + ",stock_in_no"
                        + ",supplier"
                        + ")values("
                        + ":prod_num"
                        + ",:prod_name"
                        + ",:qty"
                        + ",:amount"
                        + ",:date_added"
                        + ",:cashier_name"
                        + ",:cashier_id"
                        + ",:remarks"
                        + ",:branch_id"
                        + ",:branch"
                        + ",:status"
                        + ",:cost"
                        + ",:types"
                        + ",:types_num"
                        + ",:cat_id"
                        + ",:stock_in_no"
                        + ",:supplier"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setString("prod_num", to_stock_in.prod_num)
                        .setString("prod_name", to_stock_in.prod_name)
                        .setNumber("qty", to_stock_in.qty)
                        .setNumber("amount", to_stock_in.amount)
                        .setString("date_added", to_stock_in_main.date_added)
                        .setString("cashier_name", to_stock_in_main.user_name)
                        .setString("cashier_id", to_stock_in_main.user_name)
                        .setString("remarks", to_stock_in_main.remarks)
                        .setNumber("branch_id", to_stock_in_main.branch_id)
                        .setString("branch", to_stock_in_main.branch)
                        .setNumber("status", to_stock_in_main.status)
                        .setNumber("cost", to_stock_in.cost)
                        .setString("types", to_stock_in.types)
                        .setString("types_num", to_stock_in.types_num)
                        .setString("cat_id", to_stock_in.cat_id)
                        .setString("stock_in_no", to_stock_in_main.ref_no)
                        .setString("supplier", to_stock_in_main.supplier)
                        .ok();
                stmt.addBatch(s2);

                double new_qty = 0;
                String s3 = "select product_qty from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + to_stock_in.prod_num + "' ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs = stmt2.executeQuery(s3);
                if (rs.next()) {
                    new_qty = rs.getDouble(1);
                }

                new_qty += to_stock_in.qty;

                String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set product_qty='" + new_qty + "',cost='" + to_stock_in.cost + "' where product_name='" + to_stock_in.prod_num + "' ";

                stmt.addBatch(s1);

            }

            stmt.executeBatch();
            conn.commit();
            Lg.s(Stock_in_main.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_stock_in_main to_stock_in_main) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".stock_in_main set "
                    + "ref_no= :ref_no "
                    + ",item_count= :item_count "
                    + ",total_cost= :total_cost "
                    + ",date_added= :date_added "
                    + ",branch= :branch "
                    + ",branch_id= :branch_id "
                    + ",user_name= :user_name "
                    + ",user_id= :user_id "
                    + ",status= :status "
                    + " where id='" + to_stock_in_main.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("ref_no", to_stock_in_main.ref_no)
                    .setNumber("item_count", to_stock_in_main.item_count)
                    .setNumber("total_cost", to_stock_in_main.total_cost)
                    .setString("date_added", to_stock_in_main.date_added)
                    .setString("branch", to_stock_in_main.branch)
                    .setNumber("branch_id", to_stock_in_main.branch_id)
                    .setString("user_name", to_stock_in_main.user_name)
                    .setNumber("user_id", to_stock_in_main.user_id)
                    .setNumber("status", to_stock_in_main.status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_in_main.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_stock_in_main to_stock_in_main) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".stock_in_main  "
                    + " where id='" + to_stock_in_main.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_in_main.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_stock_in_main> ret_data(String where) {
        List<to_stock_in_main> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",ref_no"
                    + ",item_count"
                    + ",total_cost"
                    + ",date_added"
                    + ",branch"
                    + ",branch_id"
                    + ",user_name"
                    + ",user_id"
                    + ",status"
                    + ",remarks"
                    + ",supplier"
                    + " from " + MyDB.getNames() + ".stock_in_main"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String ref_no = rs.getString(2);
                int item_count = rs.getInt(3);
                double total_cost = rs.getDouble(4);
                String date_added = rs.getString(5);
                String branch = rs.getString(6);
                int branch_id = rs.getInt(7);
                String user_name = rs.getString(8);
                int user_id = rs.getInt(9);
                int status = rs.getInt(10);
                String remarks = rs.getString(11);
                String supplier = rs.getString(12);
                to_stock_in_main to = new to_stock_in_main(id, ref_no, item_count, total_cost, date_added, branch, branch_id, user_name, user_id, status, remarks, supplier);
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
        String id = "00000000";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select max(id) from " + MyDB.getNames() + ".stock_in_main ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
                String s2 = "select ref_no from " + MyDB.getNames() + ".stock_in_main where id='" + id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    id = rs2.getString(1);
                }
            }
            if (id == null) {
                id = "00000000";
            }
            id = ReceiptIncrementor.increment(id);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String ret_cat_id(String type_name) {

        String id = "0";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select id from " + MyDB.getNames() + ".category where cat_name like '" + type_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String ret_sub_cat_id(String type_name) {

        String id = "0";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select id from " + MyDB.getNames() + ".category_type where type_name like'" + type_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
