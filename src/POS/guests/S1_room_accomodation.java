/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main.MyDB;
import POS.rooms.S1_check_in;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import POS.utl.NumberFormat;
import POS_svc4.S2_search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_room_accomodation {

    public static class to_room_accomodations {

        public final int id;
        public final int table_id;
        public final String table_names;
        public final String check_in;
        public final String check_out;
        public final int status;
        public final String product_num;
        public final String description;
        public final double qty;
        public final double price;

        public to_room_accomodations(int id, int table_id, String table_names, String check_in, String check_out, int status, String product_num, String description, double qty, double price) {
            this.id = id;
            this.table_id = table_id;
            this.table_names = table_names;
            this.check_in = check_in;
            this.check_out = check_out;
            this.status = status;
            this.product_num = product_num;
            this.description = description;
            this.qty = qty;
            this.price = price;
        }
    }

    public static List<to_room_accomodations> ret_data(String table_ids) {
        List<to_room_accomodations> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",table_id"
                    + ",table_names"
                    + ",check_in"
                    + ",check_out"
                    + ",status"
                    + ",product_num"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + " from " + MyDB.getNames() + ".room_accomodations where "
                    + " table_id ='" + table_ids + "' "
                    + " and status <> '" + "1" + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int table_id = rs.getInt(2);
                String table_names = "ADDED";
                String check_in = rs.getString(4);
                Date d = new Date();
                d = DateType.datetime.parse(rs.getString(4));
                check_in = DateType.month_date.format(d);
                String check_out = rs.getString(5);
                int status = rs.getInt(6);
                String product_num = rs.getString(7);
                String description = rs.getString(8);
                double qty = rs.getDouble(9);
                double price = rs.getDouble(10);

                to_room_accomodations to = new to_room_accomodations(id, table_id, table_names, check_in, check_out, status, product_num, description, qty, price);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_data(String table_id, List<S2_search.to_items> items, int guest_size) {
        String now = DateType.datetime.format(new Date());
        try {
            Connection conn = MyConnection1.connect();
            String s1 = "update " + MyDB.getNames() + ".room_accomodations set "
                    + "status= '" + "2" + "'"
                    + ",check_out= '" + now + "'"
                    + "where "
                    + " table_id ='" + table_id + "' "
                    + " and status <>'" + "1" + "' "
                    + " ";

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Lg.s(S1_room_accomodation.class, "Successfully Updated");

            double rate = 0;
            String product_num = "";
            for (S2_search.to_items to1 : items) {
                String s0 = "insert into " + MyDB.getNames() + ".room_accomodations("
                        + "table_id"
                        + ",table_names"
                        + ",check_in"
                        + ",status"
                        + ",product_num"
                        + ",description"
                        + ",qty"
                        + ",price"
                        + ")values("
                        + ":table_id"
                        + ",:table_names"
                        + ",:check_in"
                        + ",:status"
                        + ",:product_num"
                        + ",:description"
                        + ",:qty"
                        + ",:price"
                        + ")";
                s0 = SqlStringUtil.parse(s0).
                        setString("table_id", table_id).
                        setString("table_names", "").
                        setString("check_in", DateType.datetime.format(new Date())).
                        setNumber("status", 0).
                        setString("product_num", to1.name).
                        setString("description", to1.desc).
                        setNumber("qty", to1.qty).
                        setNumber("price", to1.price).
                        ok();
                rate += to1.price;
//                product_num = to1.name;
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_check_in.class, "Successfully Added room accomodation");
            }

            String s6 = "select product_num from " + MyDB.getNames() + ".room_accomodations "
                    + "where "
                    + " table_id ='" + table_id + "' "
                    + " and status ='" + "0" + "' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s6);
            if (rs.next()) {
                product_num = rs.getString(1);
            }

            
            rate = rate / guest_size;
            String date = DateType.sf.format(new Date());
            String s3 = "update " + MyDB.getNames() + ".guest_charges set "
                    + "amount= '" + NumberFormat.df.format(rate) + "'"
                    + ",product_num= '" + product_num + "'"
                    + "where "
                    + " table_no ='" + table_id + "' "
                    + " and status <>'" + "1" + "' and Date(date_added)='" + date + "'"
                    + " ";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_room_accomodations> ret_data_billing(String table_ids) {
        List<to_room_accomodations> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",table_id"
                    + ",table_names"
                    + ",check_in"
                    + ",check_out"
                    + ",status"
                    + ",product_num"
                    + ",description"
                    + ",qty"
                    + ",price"
                    + " from " + MyDB.getNames() + ".room_accomodations  "
                    + " where table_id='" + table_ids + "' and status<> '" + "1" + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int table_id = rs.getInt(2);
                String table_names = rs.getString(3);
                String check_in = rs.getString(4);
                String check_out = rs.getString(5);
                int status = rs.getInt(6);
                String product_num = rs.getString(7);
                String description = rs.getString(8);
                double qty = rs.getDouble(9);
                double price = rs.getDouble(10);

                to_room_accomodations to = new to_room_accomodations(id, table_id, table_names, check_in, check_out, status, product_num, description, qty, price);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(String table_id, String del_product_num, String update_product_num, double amount, int table_size) {
        try {

            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".room_accomodations where "
                    + " table_id ='" + table_id + "' "
                    + " and status ='" + "0" + "' "
                    + " and product_num ='" + del_product_num + "' "
                    + " ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_room_accomodation.class, "Successfully deleted accom");

            String s1 = "update " + MyDB.getNames() + ".room_accomodations set "
                    + "check_out= '" + null + "'"
                    + ",status= '" + "0" + "'"
                    + "where "
                    + " table_id ='" + table_id + "' "
                    + " and status ='" + "2" + "' "
                    + " and product_num ='" + update_product_num + "' "
                    + " ";

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            if (table_size == 1) {
                String s2 = "delete from " + MyDB.getNames() + ".guest_charges  "
                        + "where "
                        + " table_no ='" + table_id + "' "
                        + " and status ='" + "0" + "' "
                        + "  and Date(date_added)='" + DateType.sf.format(new Date()) + "'"
                        + " ";

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_room_accomodation.class, "Successfully update guest charges");
            } else {
                String s2 = "update " + MyDB.getNames() + ".guest_charges set "
                        + "product_num= '" + update_product_num + "'"
                        + ",amount= '" + amount + "'"
                        + "where "
                        + " table_no ='" + table_id + "' "
                        + " and status ='" + "0" + "' "
                        + " and product_num ='" + update_product_num + "' and Date(date_added)='" + DateType.sf.
                        format(new Date()) + "'"
                        + " ";

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_room_accomodation.class, "Successfully update guest charges");
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
