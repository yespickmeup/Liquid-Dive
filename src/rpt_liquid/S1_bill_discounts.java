/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_bill_discounts {

    public static class to_bill_discounts {

        public final int id;
        public final String discount;
        public final double rate;
        public final int table_id;
        public final String guest_id;
        public final int status;
        public final String guest_name;

        public to_bill_discounts(int id, String discount, double rate, int table_id, String guest_id, int status, String guest_name) {
            this.id = id;
            this.discount = discount;
            this.rate = rate;
            this.table_id = table_id;
            this.guest_id = guest_id;
            this.status = status;
            this.guest_name = guest_name;
        }
    }

    public static void add_data(to_bill_discounts to_bill_discounts) {
        try {
            Connection conn = MyConnection1.connect();

            String s1 = "select id from " + MyDB.getNames() + ".bill_discounts where table_id='" + to_bill_discounts.table_id + "'"
                    + " and status='" + "0" + "' and guest_id like '" + to_bill_discounts.guest_id + "'";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s1);
            if (!rs2.next()) {
                String s0 = "insert into " + MyDB.getNames() + ".bill_discounts("
                        + "discount"
                        + ",rate"
                        + ",table_id"
                        + ",guest_id"
                        + ",status"
                        + ",guest_name"
                        + ")values("
                        + ":discount"
                        + ",:rate"
                        + ",:table_id"
                        + ",:guest_id"
                        + ",:status"
                        + ",:guest_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("discount", to_bill_discounts.discount).
                        setNumber("rate", to_bill_discounts.rate).
                        setNumber("table_id", to_bill_discounts.table_id).
                        setString("guest_id", to_bill_discounts.guest_id).
                        setNumber("status", to_bill_discounts.status).
                        setString("guest_name", to_bill_discounts.guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_bill_discounts.class, "Successfully Added");
            } else {
                int id = rs2.getInt(1);
                String s0 = "update " + MyDB.getNames() + ".bill_discounts set rate='" + to_bill_discounts.rate + "',discount='" + to_bill_discounts.discount + "' "
                        + " where id='" + id + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static to_bill_discounts ret_data(String table_ids, String guest_ids) {
        to_bill_discounts to1 = new to_bill_discounts(-1, "", 0, 0, "", 0, "");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",discount"
                    + ",rate"
                    + ",table_id"
                    + ",guest_id"
                    + ",status"
                    + ",guest_name"
                    + " from " + MyDB.getNames() + ".bill_discounts where "
                    + " table_id ='" + table_ids + "'"
                    + " and guest_id like '%" + guest_ids + "%' and status='"+"0"+"'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String discount = rs.getString(2);
                double rate = rs.getDouble(3);
                int table_id = rs.getInt(4);
                String guest_id = rs.getString(5);
                int status = rs.getInt(6);
                String guest_name = rs.getString(7);
                to1 = new to_bill_discounts(id, discount, rate, table_id, guest_id, status, guest_name);
            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
    
    
    
    public static void main(String[] args) {
//        Main.MyDB.setNames("db_pos_restaurant");
        to_bill_discounts to = ret_data("13", "00000025");
        System.out.println(to.discount);


    }
}
