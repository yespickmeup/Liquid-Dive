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
import java.util.Locale.Category;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Guinness
 */
public class Categories {

    public static class to_category {

        public final int id;
        public final int cat_num;
        public final String cat_name;
        public final String img_path;
        public final int table_location_id;
        public final int open_item;
        public final int printing_assembly;
        public final int group_id;

        public to_category(int id, int cat_num, String cat_name, String img_path, int table_location_id, int open_item, int printing_assembly, int group_id) {
            this.id = id;
            this.cat_num = cat_num;
            this.cat_name = cat_name;
            this.img_path = img_path;
            this.table_location_id = table_location_id;
            this.open_item = open_item;
            this.printing_assembly = printing_assembly;
            this.group_id = group_id;
        }
    }

    public static void add_data(to_category to_category) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".category("
                    + "cat_num"
                    + ",cat_name"
                    + ",img_path"
                    + ",table_location_id"
                    + ",open_item"
                    + ",printing_assembly"
                    + ",group_id"
                    + ")values("
                    + ":cat_num"
                    + ",:cat_name"
                    + ",:img_path"
                    + ",:table_location_id"
                    + ",:open_item"
                    + ",:printing_assembly"
                    + ",:group_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("cat_num", to_category.cat_num)
                    .setString("cat_name", to_category.cat_name)
                    .setString("img_path", to_category.img_path)
                    .setNumber("table_location_id", to_category.table_location_id)
                    .setNumber("open_item", to_category.open_item)
                    .setNumber("printing_assembly", to_category.printing_assembly)
                    .setNumber("group_id", to_category.group_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void update_data(to_category to_category) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".category set "
                    + "cat_num= :cat_num "
                    + ",cat_name= :cat_name "
                    + ",img_path= :img_path "
                    + ",table_location_id= :table_location_id "
                    + ",open_item= :open_item "
                    + ",printing_assembly= :printing_assembly "
                    + ",group_id= :group_id "
                    + " where id='" + to_category.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("cat_num", to_category.cat_num)
                    .setString("cat_name", to_category.cat_name)
                    .setString("img_path", to_category.img_path)
                    .setNumber("table_location_id", to_category.table_location_id)
                    .setNumber("open_item", to_category.open_item)
                    .setNumber("printing_assembly", to_category.printing_assembly)
                    .setNumber("group_id", to_category.group_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_category to_category) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".category  "
                    + " where id='" + to_category.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Category.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_category> ret_data(String where) {
        List<to_category> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cat_num"
                    + ",cat_name"
                    + ",img_path"
                    + ",table_location_id"
                    + ",open_item"
                    + ",printing_assembly"
                    + ",group_id"
                    + " from " + MyDB.getNames() + ".category"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cat_num = rs.getInt(2);
                String cat_name = rs.getString(3);
                String img_path = rs.getString(4);
                int table_location_id = rs.getInt(5);
                int open_item = rs.getInt(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);

                to_category to = new to_category(id, cat_num, cat_name, img_path, table_location_id, open_item, printing_assembly, group_id);
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
