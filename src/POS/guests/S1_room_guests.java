/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class S1_room_guests {

    public static class to_room_guests {

        public final int id;
        public final int rooom_id;
        public final String guest_id;
        public final String guest_name;
        public final String checkin_date;
        public final String checkout_date;
        public final int status;
        public final double to_pay;
        public final double paid;
        public final double room_rate;
        public final int staff;
        public final String table_ids;
        public final String room_guest_ids;
        

        public to_room_guests(int id, int rooom_id, String guest_id, String guest_name, String checkin_date
                , String checkout_date, int status, double to_pay, double paid, double room_rate
                , int staff,String table_ids,String room_guest_ids) {
            this.id = id;
            this.rooom_id = rooom_id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.checkin_date = checkin_date;
            this.checkout_date = checkout_date;
            this.status = status;
            this.to_pay = to_pay;
            this.paid = paid;
            this.room_rate = room_rate;
            this.staff = staff;
            this.table_ids=table_ids;
            this.room_guest_ids=room_guest_ids;
            
        }
    }

    public static List<to_room_guests> ret_data(String search) {
        List<to_room_guests> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",rooom_id"
                    + ",guest_id"
                    + ",guest_name"
                    + ",checkin_date"
                    + ",checkout_date"
                    + ",status"
                    + ",to_pay"
                    + ",paid"
                    + ",room_rate"
                    + ",staff"
                    + " from " + MyDB.getNames() + ".room_guests where "
                    + " guest_name like'%" + search + "%' "
                    + " and status ='" + "0" + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int rooom_id = rs.getInt(2);
                String guest_id = rs.getString(3);
                String guest_name = rs.getString(4);
                String checkin_date = rs.getString(5);
                String s2 = "select "
                        + "table_name"
                        + " from " + MyDB.getNames() + ".tables where "
                        + " id ='" + rooom_id + "' "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    checkin_date = rs2.getString(1);
                }
                String checkout_date = rs.getString(6);
                int status = rs.getInt(7);
                double to_pay = rs.getDouble(8);
                double paid = rs.getDouble(9);
                double room_rate = rs.getDouble(10);
                int staff = rs.getInt(11);
                String table_ids=""+rooom_id;
                String room_guest_ids=""+id;
                to_room_guests to = new to_room_guests(id, rooom_id, guest_id, guest_name, checkin_date
                        , checkout_date, status, to_pay, paid, room_rate, staff,table_ids,room_guest_ids);
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
