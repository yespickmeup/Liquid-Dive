/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.redo_receipts;

import POS.Main.MyDB;
import POS.expenses.S1_expenses;

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
public class S2_expenses {

    public static class to_expenses {

        public final int id;
        public final String date_added;
        public final String user_name;
        public final String amount;
        public final String purpose;
        public final int session_id;
        public final String category_name;
        public final String vat;

        public to_expenses(int id, String date_added, String user_name, String amount, String purpose, int session_id, String category_name, String vat) {
            this.id = id;
            this.date_added = date_added;
            this.user_name = user_name;
            this.amount = amount;
            this.purpose = purpose;
            this.session_id = session_id;
            this.category_name = category_name;
            this.vat = vat;
        }
    }

    public static void edit_expenses(S2_expenses.to_expenses to_expenses) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".expenses set "
                    + "date_added= '" + to_expenses.date_added + "'"
                    + ",user_name= '" + to_expenses.user_name + "'"
                    + ",amount= '" + to_expenses.amount + "'"
                    + ",purpose= '" + to_expenses.purpose + "'"
                    + ",session_id= '" + to_expenses.session_id + "'"
                    + ",category_name= '" + to_expenses.category_name + "'"
                    + ",vat= '" + to_expenses.vat + "'"
                    + "where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<S2_expenses.to_expenses> ret_data(String date_from, String date_to, String user_name1) {
        List<S2_expenses.to_expenses> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + ",category_name"
                    + ",vat"
                    + " from " + MyDB.getNames() + ".expenses where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    //                    + " and category_name like'%" + category + "%' "
                    + " and user_name like'%" + user_name1 + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                String user_name = rs.getString(3);
                String amount = rs.getString(4);
                String purpose = rs.getString(5);
                int session_id = rs.getInt(6);
                String category_name = rs.getString(7);
                String vat = rs.getString(8);

                S2_expenses.to_expenses to = new S2_expenses.to_expenses(id, date_added, user_name, amount, purpose, session_id, category_name, vat);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void add_expenses(S2_expenses.to_expenses to_expenses) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".expenses("
                    + "date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + ",category_name"
                    + ",vat"
                    + ")values("
                    + ":date_added"
                    + ",:user_name"
                    + ",:amount"
                    + ",:purpose"
                    + ",:session_id"
                    + ",:category_name"
                    + ",:vat"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("date_added", to_expenses.date_added).
                    setString("user_name", to_expenses.user_name).
                    setString("amount", to_expenses.amount).
                    setString("purpose", to_expenses.purpose).
                    setNumber("session_id", to_expenses.session_id).
                    setString("category_name", to_expenses.category_name).
                    setString("vat", to_expenses.vat).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_expenses(to_expenses to_expenses) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".expenses where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
