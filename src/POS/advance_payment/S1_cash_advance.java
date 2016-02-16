/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.advance_payment;

import POS.Main.MyDB;
import POS.to.to_users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection1;
import java.sql.SQLException;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_cash_advance {

    public static String get_guest_id(String guest) {
        String id = "-2";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "guest_id"
                    + " from " + MyDB.getNames() + ".room_guests where guest_name='" + guest + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String get_room_id(String room) {
        String id = "-2";
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + " from " + MyDB.getNames() + ".tables where table_name='" + room + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount_paid)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment where room_id='" + room_id + "' and guest_id='" + guest_id + "' and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_all(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount_paid)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_all_usd(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(usd)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_all2(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(usd)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_credit_card(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(credit_amount)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_bank_php(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(peso_on_bank)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_bank_usd(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(usd_on_bank)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "where room_id='" + room_id + "'  and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_where(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount_paid)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_where2(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(usd)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_credit_card(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "credit_amount"
                    + ",credit_rate"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                double credit_rate = (rs.getDouble(2) / 100) * rs.getDouble(1);
                double am = rs.getDouble(1);// + credit_rate;
                amount += am;
            }
            return amount;
        } catch (SQLException e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_where_bank_php(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(peso_on_bank)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_where_bank_usd(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(usd_on_bank)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static double get_guest_advance_where3(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "sum(amount_paid)"
                    + " from " + MyDB.getNames() + ".guest_advance_payment2 "
                    + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection1.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static class to_guest_advance_payment {

        public final int id;
        public final String room_id;
        public final String guest_name;
        public final String guest_id;
        public final String date_added;
        public final double amount_paid;
        public final int status;

        public to_guest_advance_payment(int id, String room_id, String guest_name, String guest_id, String date_added, double amount_paid, int status) {
            this.id = id;
            this.room_id = room_id;
            this.guest_name = guest_name;
            this.guest_id = guest_id;
            this.date_added = date_added;
            this.amount_paid = amount_paid;
            this.status = status;
        }
    }

    public static void add_data(to_guest_advance_payment to_guest_advance_payment, double usd, int room_guest_id, double peso_on_bank, double usd_on_bank, int is_peso_on_bank, int is_usd_on_bank, String bank_no, String bank,
            String card_type,
            String card_holder,
            String card_no,
            String approval_code,
            double credit_amount,
            double credit_addtl,
            double credit_rate) {

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".guest_advance_payment("
                    + "room_id"
                    + ",guest_name"
                    + ",guest_id"
                    + ",date_added"
                    + ",amount_paid"
                    + ",status"
                    + ",user_name"
                    + ",usd"
                    + ",room_guest_id"
                    + ",peso_on_bank"
                    + ",usd_on_bank"
                    + ",is_peso_on_bank"
                    + ",is_usd_on_bank"
                    + ",bank_no"
                    + ",bank"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",credit_amount"
                    + ",credit_addtl"
                    + ",credit_rate"
                    + ")values("
                    + ":room_id"
                    + ",:guest_name"
                    + ",:guest_id"
                    + ",:date_added"
                    + ",:amount_paid"
                    + ",:status"
                    + ",:user_name"
                    + ",:usd"
                    + ",:room_guest_id"
                    + ",:peso_on_bank"
                    + ",:usd_on_bank"
                    + ",:is_peso_on_bank"
                    + ",:is_usd_on_bank"
                    + ",:bank_no"
                    + ",:bank"
                    + ",:card_type"
                    + ",:card_holder"
                    + ",:card_no"
                    + ",:approval_code"
                    + ",:credit_amount"
                    + ",:credit_addtl"
                    + ",:credit_rate"
                    + ")";
            s0 = SqlStringUtil.parse(s0).
                    setString("room_id", to_guest_advance_payment.room_id).
                    setString("guest_name", to_guest_advance_payment.guest_name).
                    setString("guest_id", to_guest_advance_payment.guest_id).
                    setString("date_added", to_guest_advance_payment.date_added).
                    setNumber("amount_paid", to_guest_advance_payment.amount_paid).
                    setNumber("status", to_guest_advance_payment.status).
                    setString("user_name", to_users.ret_user(to_users.username1)).
                    setNumber("usd", usd).
                    setNumber("room_guest_id", room_guest_id).
                    setNumber("peso_on_bank", peso_on_bank).
                    setNumber("usd_on_bank", usd_on_bank).
                    setNumber("is_peso_on_bank", is_peso_on_bank).
                    setNumber("is_usd_on_bank", is_usd_on_bank).
                    setString("bank_no", bank_no).
                    setString("bank", bank).
                    setString("card_type", card_type).
                    setString("card_holder", card_holder).
                    setString("card_no", card_no).
                    setString("approval_code", approval_code).
                    setNumber("credit_amount", credit_amount).
                    setNumber("credit_addtl", credit_addtl).
                    setNumber("credit_rate", credit_rate).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_data(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".guest_advance_payment set "
                    + "room_id= '" + to_guest_advance_payment.room_id + "'"
                    + ",guest_name= '" + to_guest_advance_payment.guest_name + "'"
                    + ",guest_id= '" + to_guest_advance_payment.guest_id + "'"
                    + ",date_added= '" + to_guest_advance_payment.date_added + "'"
                    + ",amount_paid= '" + to_guest_advance_payment.amount_paid + "'"
                    + ",status= '" + to_guest_advance_payment.status + "'"
                    + "where "
                    + " room_id ='" + to_guest_advance_payment.room_id + "' "
                    + " and guest_id ='" + to_guest_advance_payment.guest_id + "' "
                    + " and status ='" + "0"
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_data(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " room_id ='" + to_guest_advance_payment.room_id + "' "
                    + " and guest_id ='" + to_guest_advance_payment.guest_id + "' "
                    + " and status ='" + to_guest_advance_payment.status + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
