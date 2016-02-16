/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.expenses;

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
 * @author Maytopacka
 */
public class S1_expenses_categories {

    public static class to_expenses_categories {

        public final int id;
        public final String category_name;

        public to_expenses_categories(int id, String category_name) {
            this.id = id;
            this.category_name = category_name;
        }
    }

    public static void add_expenses_categories(to_expenses_categories to_expenses_categories) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".expenses_categories("
                    + "category_name"
                    + ")values("
                    + ":category_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("category_name", to_expenses_categories.category_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses_categories.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_expenses_categories(to_expenses_categories to_expenses_categories) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".expenses_categories set "
                    + "category_name= '" + to_expenses_categories.category_name + "'"
                    + "where "
                    + " id ='" + to_expenses_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses_categories.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_expenses_categories(to_expenses_categories to_expenses_categories) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".expenses_categories where "
                    + " id ='" + to_expenses_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_expenses_categories.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_expenses_categories> ret_data(String search) {
        List<to_expenses_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",category_name"
                    + " from " + MyDB.getNames() + ".expenses_categories where "
                    + " category_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_name = rs.getString(2);

                to_expenses_categories to = new to_expenses_categories(id, category_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_expenses_categories> ret_where(String where) {
        List<to_expenses_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",category_name"
                    + " from db_pos_restaurant.expenses_categories  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_name = rs.getString(2);

                to_expenses_categories to = new to_expenses_categories(id, category_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select category_name from " + MyDB.getNames() + ".expenses_categories";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cb_data3() {
        List<String> datas = new ArrayList();
//        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select category_name from " + MyDB.getNames() + ".expenses_categories";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<String> ret_cb_data2() {
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select category_name from " + MyDB.getNames() + ".expenses_categories";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
