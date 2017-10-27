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
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Stock_in {

    public static class to_stock_in {

        public final int id;
        public final String prod_num;
        public final String prod_name;
        public final double qty;
        public final double amount;
        public final String date_added;
        public final String cashier_name;
        public final String cashier_id;
        public final String remarks;
        public final int branch_id;
        public final String branch;
        public final int status;
        public final double cost;
        public final String types;
        public final String types_num;
        public final String cat_id;
        public final String stock_in_no;
        public final String supplier;

        public to_stock_in(int id, String prod_num, String prod_name, double qty, double amount, String date_added, String cashier_name, String cashier_id, String remarks, int branch_id, String branch, int status, double cost, String types, String types_num, String cat_id, String stock_in_no, String supplier) {
            this.id = id;
            this.prod_num = prod_num;
            this.prod_name = prod_name;
            this.qty = qty;
            this.amount = amount;
            this.date_added = date_added;
            this.cashier_name = cashier_name;
            this.cashier_id = cashier_id;
            this.remarks = remarks;
            this.branch_id = branch_id;
            this.branch = branch;
            this.status = status;
            this.cost = cost;
            this.types = types;
            this.types_num = types_num;
            this.cat_id = cat_id;
            this.stock_in_no = stock_in_no;
            this.supplier = supplier;
        }
    }

    public static void add_data(to_stock_in to_stock_in) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".stock_in("
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

            s0 = SqlStringUtil.parse(s0)
                    .setString("prod_num", to_stock_in.prod_num)
                    .setString("prod_name", to_stock_in.prod_name)
                    .setNumber("qty", to_stock_in.qty)
                    .setNumber("amount", to_stock_in.amount)
                    .setString("date_added", to_stock_in.date_added)
                    .setString("cashier_name", to_stock_in.cashier_name)
                    .setString("cashier_id", to_stock_in.cashier_id)
                    .setString("remarks", to_stock_in.remarks)
                    .setNumber("branch_id", to_stock_in.branch_id)
                    .setString("branch", to_stock_in.branch)
                    .setNumber("status", to_stock_in.status)
                    .setNumber("cost", to_stock_in.cost)
                    .setString("types", to_stock_in.types)
                    .setString("types_num", to_stock_in.types_num)
                    .setString("cat_id", to_stock_in.cat_id)
                    .setString("stock_in_no", to_stock_in.stock_in_no)
                    .setString("supplier", to_stock_in.supplier)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_in.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_stock_in to_stock_in) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".stock_in set "
                    + "prod_num= :prod_num "
                    + ",prod_name= :prod_name "
                    + ",qty= :qty "
                    + ",amount= :amount "
                    + ",date_added= :date_added "
                    + ",cashier_name= :cashier_name "
                    + ",cashier_id= :cashier_id "
                    + ",remarks= :remarks "
                    + ",branch_id= :branch_id "
                    + ",branch= :branch "
                    + ",status= :status "
                    + ",cost= :cost "
                    + ",types= :types "
                    + ",types_num= :types_num "
                    + ",cat_id= :cat_id "
                    + ",stock_in_no= :stock_in_no "
                    + ",supplier= :supplier"
                    + " where id='" + to_stock_in.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("prod_num", to_stock_in.prod_num)
                    .setString("prod_name", to_stock_in.prod_name)
                    .setNumber("qty", to_stock_in.qty)
                    .setNumber("amount", to_stock_in.amount)
                    .setString("date_added", to_stock_in.date_added)
                    .setString("cashier_name", to_stock_in.cashier_name)
                    .setString("cashier_id", to_stock_in.cashier_id)
                    .setString("remarks", to_stock_in.remarks)
                    .setNumber("branch_id", to_stock_in.branch_id)
                    .setString("branch", to_stock_in.branch)
                    .setNumber("status", to_stock_in.status)
                    .setNumber("cost", to_stock_in.cost)
                    .setString("types", to_stock_in.types)
                    .setString("types_num", to_stock_in.types_num)
                    .setString("cat_id", to_stock_in.cat_id)
                    .setString("stock_in_no", to_stock_in.stock_in_no)
                    .setString("supplier", to_stock_in.supplier)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_in.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_stock_in to_stock_in) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".stock_in  "
                    + " where id='" + to_stock_in.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Stock_in.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_stock_in> ret_data(String where) {
        List<to_stock_in> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",prod_num"
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
                    + " from " + MyDB.getNames() + ".stock_in"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String prod_num = rs.getString(2);
                String prod_name = rs.getString(3);
                double qty = rs.getDouble(4);
                double amount = rs.getDouble(5);
                String date_added = rs.getString(6);
                String cashier_name = rs.getString(7);
                String cashier_id = rs.getString(8);
                String remarks = rs.getString(9);
                int branch_id = rs.getInt(10);
                String branch = rs.getString(11);
                int status = rs.getInt(12);
                double cost = rs.getDouble(13);
                String types = rs.getString(14);
                String types_num = rs.getString(15);
                String cat_id = rs.getString(16);
                String stock_in_no = rs.getString(17);
                String supplier=rs.getString(18);
                to_stock_in to = new to_stock_in(id, prod_num, prod_name, qty, amount, date_added, cashier_name, cashier_id, remarks, branch_id, branch, status, cost, types, types_num, cat_id, stock_in_no,supplier);
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
