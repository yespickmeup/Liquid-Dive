/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main.MyDB;
import POS.rooms.S1_check_in;
import POS.utl.DateType;
import POS.utl.DateUtils;
import POS.utl.NumberFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection1;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import test.Dlg_check_liquid;

/**
 *
 * @author i1
 */
public class S2_guest_charges {

    public static class to_guest_charges {

        public final int id;
        public final String guest_id;
        public final String guest_name;
        public final String date_added;
        public final double amount;
        public final int status;

        public to_guest_charges(int id, String guest_id, String guest_name, String date_added, double amount, int status) {
            this.id = id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.date_added = date_added;
            this.amount = amount;
            this.status = status;
        }
    }

    public static void add_data(to_guest_charges to_guest_charges) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".guest_charges("
                    + "guest_id"
                    + ",guest_name"
                    + ",date_added"
                    + ",amount"
                    + ",status"
                    + ")values("
                    + ":guest_id"
                    + ",:guest_name"
                    + ",:date_added"
                    + ",:amount"
                    + ",:status"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("guest_id", to_guest_charges.guest_id).
                    setString("guest_name", to_guest_charges.guest_name).
                    setString("date_added", to_guest_charges.date_added).
                    setNumber("amount", to_guest_charges.amount).
                    setNumber("status", to_guest_charges.status).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_guest_charges.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static class to_rooms_occupied {

        public final int id;
        public final int room_id;
        public final List<to_rooms_occupied_guest> to1;

        public to_rooms_occupied(int id, int room_id, List<to_rooms_occupied_guest> to1) {
            this.id = id;
            this.room_id = room_id;
            this.to1 = to1;
        }
    }

    public static class to_rooms_occupied_guest {

        public final String guest_id;
        public final String guest_name;
        public final String date_added;

        public to_rooms_occupied_guest(String guest_id, String guest_name, String date_added) {
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.date_added = date_added;
        }
    }

//    public static void main(String[] args) {
//        List<to_rooms_occupied> datas = ret_data("");
//        for (to_rooms_occupied to : datas) {
////            System.out.println(to.room_id);
//            for (to_rooms_occupied_guest t : to.to1) {
//                System.out.println(t.guest_name);
//            }
//        }
//    }
    public static List<to_rooms_occupied> ret_data(String search) {
        List<to_rooms_occupied> datas = new ArrayList();

        Date now = new Date();
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",rooom_id"
                    + ",room_rate"
                    + " from " + MyDB.getNames() + ".room_guests where "
                    + " status ='" + "0" + "' group by rooom_id "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int rooom_id = rs.getInt(2);
                String ss = "select percentage,rate from " + MyDB.getNames() + ".tables where id='" + rooom_id + "'";
                Statement stmts = conn.createStatement();
                ResultSet rss = stmts.executeQuery(ss);
                double percentage = 0;
                double room_rate = 0;
                if (rss.next()) {
                    percentage = rss.getDouble(1);
                    room_rate = rss.getDouble(2);
                    percentage = room_rate * (percentage / 100);
                    room_rate = room_rate - percentage;
                }


                List<to_rooms_occupied_guest> to1 = new ArrayList();
                String s1 = "select "
                        + "guest_id"
                        + ",guest_name"
                        + ",checkin_date"
                        + " from " + MyDB.getNames() + ".room_guests where "
                        + " rooom_id ='" + rooom_id + "' and status='" + "0" + "' "
                        + " ";
                Statement stmt1 = conn.createStatement();
                ResultSet rs1 = stmt1.executeQuery(s1);
                while (rs1.next()) {
                    String guest_id = rs1.getString(1);
                    String guest_name = rs1.getString(2);
                    String date_added = rs1.getString(3);

                    to_rooms_occupied_guest to = new to_rooms_occupied_guest(guest_id, guest_name, date_added);
                    to1.add(to);
                }


                for (to_rooms_occupied_guest t : to1) {
                    double my_rate = to1.size();

                    String s3 = "select "
                            + "id"
                            + ",guest_id"
                            + ",guest_name"
                            + ",date_added"
                            + ",nights"
                            + " from " + MyDB.getNames() + ".customer_tables_details where "
                            + " cat_id = '" + "11" + "' "
                            + " and status='" + "0" + "' "
                            + " and guest_id='" + t.guest_id + "' and table_no_id='" + rooom_id + "'";
                    boolean exists = false;
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery(s3);
                    double nights = 0;
                    String ids = "";
                    String date_added = "";
                    if (rs3.next()) {
                        System.out.println("");
                        nights = rs3.getInt(5);
                        ids = rs3.getString(1);
                        date_added = rs3.getString(4);
                        exists = true;
                        System.out.println(nights);
                    }

                    if (exists == true) {
                        Date a = new Date();
                        a = DateType.datetime.parse(date_added);
                        nights = DateUtils.count_days(a, now) + 1;
                        String s2 = "update  " + MyDB.getNames() + ""
                                + ".customer_tables_details set nights='" + nights + "' where id='" + ids + "'";
                        PreparedStatement stmt2 = conn.prepareStatement(s2);
                        stmt2.execute();
                    }
                }
                to_rooms_occupied to = new to_rooms_occupied(id, rooom_id, to1);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String select_guest_id(String guest_name) {
        String ids = "-2";

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "guest_id"
                    + " from " + MyDB.getNames() + ".room_guests where "
                    + " guest_name ='" + guest_name + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);

            }
            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static boolean select_guests(String table_no) {

//        JOptionPane.showMessageDialog(null, table_no);
        boolean naa = false;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select id "
                    + " from " + MyDB.getNames() + ".room_guests where "
                    + " rooom_id ='" + table_no + "' and status='" + "0" + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                naa = true;
            }
            return naa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static boolean select_guests3(String table_no) {

//        JOptionPane.showMessageDialog(null, table_no);
        boolean naa = false;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select id "
                    + " from " + MyDB.getNames() + ".room_guests2 where "
                    + " rooom_id ='" + table_no + "' and status='" + "0" + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                naa = true;
            }
            return naa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_wo_orders(String table_id, List<Dlg_check_liquid.to_guests> guest) {
        try {
            Connection conn = MyConnection1.connect();

            for (Dlg_check_liquid.to_guests to : guest) {
                System.out.println(to.name + " + " + to.id + " = " + to.status + " *****************   ");
                if (to.status == true) {
                    String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                            + " rooom_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

                    String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                            + " table_no ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt1 = conn.prepareStatement(s1);
                    stmt1.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges");

                    String s2 = "delete from " + MyDB.getNames() + ".bill_discounts where "
                            + " table_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt3 = conn.prepareStatement(s2);
                    stmt3.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted discounts");
                    
                    
                     String s4 = "delete from " + MyDB.getNames() + ".guest_advance_payment where "
                            + " room_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted advances");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_wo_orders_top(String table_id, List<Dlg_check_liquid.to_guests> guest) {
        try {
            Connection conn = MyConnection1.connect();

            for (Dlg_check_liquid.to_guests to : guest) {
                if (to.status == true) {


                    String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                            + " rooom_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

                    String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                            + " table_no ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt1 = conn.prepareStatement(s1);
                    stmt1.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges2");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_wo_orders_front(String table_id, List<Dlg_check_liquid.to_guests> guest) {
        try {
            Connection conn = MyConnection1.connect();
            for (Dlg_check_liquid.to_guests to : guest) {
                if (to.status == true) {


                    String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                            + " rooom_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

                    String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                            + " table_no ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt1 = conn.prepareStatement(s1);
                    stmt1.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_w_orders(String table_id, List<Dlg_check_liquid.to_guests> guest) {

        try {
            Connection conn = MyConnection1.connect();

            for (Dlg_check_liquid.to_guests to : guest) {
                System.out.println(to.name + " + " + to.id + " = " + to.status + " *****************   ");
                if (to.status == true) {

                    String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                            + " rooom_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

                    String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                            + " table_no ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt1 = conn.prepareStatement(s1);
                    stmt1.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges");

                    String s2 = "delete from " + MyDB.getNames() + ".customer_tables_details where "
                            + " table_no_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <> '" + "1" + "' "
                            + " ";

                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();

                    String s3 = "delete from " + MyDB.getNames() + ".bill_discounts where "
                            + " table_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted discounts");
                    
                    String s4 = "delete from " + MyDB.getNames() + ".guest_advance_payment where "
                            + " room_id ='" + table_id + "' "
                            + " and guest_id ='" + to.id + "' "
                            + " and status <>'" + "1" + "' "
                            + " ";

                    PreparedStatement stmt4 = conn.prepareStatement(s4);
                    stmt4.execute();
                    Lg.s(S2_guest_charges.class, "Successfully Deleted advances");
                    
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_w_orders_top(String table_id) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                    + " rooom_id ='" + table_id + "' "
                    + " and status <>'" + "1" + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

            String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                    + " table_no ='" + table_id + "' "
                    + " and status <>'" + "1" + "' "
                    + " ";

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges");

            String s2 = "delete from " + MyDB.getNames() + ".customer_tables_details where "
                    + " table_no_id ='" + table_id + "' "
                    + " and status <> '" + "1" + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void clear_room_w_orders_front(String table_id) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".room_guests where "
                    + " rooom_id ='" + table_id + "' "
                    + " and status <>'" + "1" + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_guest_charges.class, "Successfully Deleted room_guest");

            String s1 = "delete from " + MyDB.getNames() + ".guest_charges where "
                    + " table_no ='" + table_id + "' "
                    + " and status <>'" + "1" + "' "
                    + " ";

            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Lg.s(S2_guest_charges.class, "Successfully Deleted guest_charges");

            String s2 = "delete from " + MyDB.getNames() + ".customer_tables_details where "
                    + " table_no_id ='" + table_id + "' "
                    + " and status <> '" + "1" + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(select_guest_id("Walk-In"));
    }
}
