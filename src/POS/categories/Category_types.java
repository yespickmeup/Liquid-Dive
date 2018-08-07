/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.categories;

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
public class Category_types {

    public static class to_category_type {

        public final int id;
        public final int type_num;
        public final String type_name;
        public final String cat_num;
        public final String cat_name;

        public to_category_type(int id, int type_num, String type_name, String cat_num, String cat_name) {
            this.id = id;
            this.type_num = type_num;
            this.type_name = type_name;
            this.cat_num = cat_num;
            this.cat_name = cat_name;
        }
    }

    public static void add_data(to_category_type to_category_type) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".category_type("
                    + "type_num"
                    + ",type_name"
                    + ",cat_num"
                    + ",cat_name"
                    + ")values("
                    + ":type_num"
                    + ",:type_name"
                    + ",:cat_num"
                    + ",:cat_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("type_num", to_category_type.type_num)
                    .setString("type_name", to_category_type.type_name)
                    .setString("cat_num", to_category_type.cat_num)
                    .setString("cat_name", to_category_type.cat_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category_types.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_category_type to_category_type) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".category_type set "
                    + "type_num= :type_num "
                    + ",type_name= :type_name "
                    + ",cat_num= :cat_num "
                    + ",cat_name= :cat_name "
                    + " where id='" + to_category_type.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("type_num", to_category_type.type_num)
                    .setString("type_name", to_category_type.type_name)
                    .setString("cat_num", to_category_type.cat_num)
                    .setString("cat_name", to_category_type.cat_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category_types.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_category_type to_category_type) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".category_type  "
                    + " where id='" + to_category_type.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category_types.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_category_type> ret_data(String where) {
        List<to_category_type> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",type_num"
                    + ",type_name"
                    + ",cat_num"
                    + ",cat_name"
                    + " from " + MyDB.getNames() + ".category_type"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int type_num = rs.getInt(2);
                String type_name = rs.getString(3);
                String cat_num = rs.getString(4);
                String cat_name = rs.getString(5);

                to_category_type to = new to_category_type(id, type_num, type_name, cat_num, cat_name);
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
