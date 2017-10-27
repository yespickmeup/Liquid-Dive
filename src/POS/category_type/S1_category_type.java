/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category_type;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class S1_category_type {

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

    public static List<to_category_type> ret_data(String search) {
        List<to_category_type> datas = new ArrayList();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",type_num"
                    + ",type_name"
                    + ",cat_num"
                    + ",cat_name"
                    + " from " + MyDB.getNames() + ".category_type where "
                    + " cat_name like'%" + search + "%' "
                    + " ";

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
