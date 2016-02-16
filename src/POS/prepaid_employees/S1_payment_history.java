/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.prepaid_employees;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_payment_history {

    public static class to_payment_history {

        public final int id;
        public final String emp_id;
        public final String emp_name;
        public final double amount;
        public final String date_added;
        public final String user_name;

        public to_payment_history(int id, String emp_id, String emp_name, double amount, String date_added, String user_name) {
            this.id = id;
            this.emp_id = emp_id;
            this.emp_name = emp_name;
            this.amount = amount;
            this.date_added = date_added;
            this.user_name = user_name;
        }
    }

    public static void add_payment_history(to_payment_history to_payment_history) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".payment_history("
                    + "emp_id"
                    + ",emp_name"
                    + ",amount"
                    + ",date_added"
                    + ",user_name"
                    + ")values("
                    + ":emp_id"
                    + ",:emp_name"
                    + ",:amount"
                    + ",:date_added"
                    + ",:user_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("emp_id", to_payment_history.emp_id).
                    setString("emp_name", to_payment_history.emp_name).
                    setNumber("amount", to_payment_history.amount).
                    setString("date_added", to_payment_history.date_added).
                    setString("user_name", to_payment_history.user_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_history.class, "Successfully Added");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_payment_history(to_payment_history to_payment_history) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".payment_history set "
                    + "amount= '" + to_payment_history.amount + "'"
                    + "where "
                    + " id ='" + to_payment_history.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_history.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_payment_history(to_payment_history to_payment_history) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".payment_history where "
                    + " id ='" + to_payment_history.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_payment_history.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_payment_history> ret_data(String emp_ids,String date_from,String date_to) {
        List<to_payment_history> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",emp_id"
                    + ",emp_name"
                    + ",amount"
                    + ",date_added"
                    + ",user_name"
                    + " from " + MyDB.getNames() + ".payment_history where "
                    + " emp_id ='" + emp_ids + "' "
                    + " and date_added between '" + date_from + "' "
                    + "and '" + date_to + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String emp_id = rs.getString(2);
                String emp_name = rs.getString(3);
                double amount = rs.getDouble(4);
                String date_added = rs.getString(5);
                String user_name = rs.getString(6);

                to_payment_history to = new to_payment_history(id, emp_id, emp_name, amount, date_added, user_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
