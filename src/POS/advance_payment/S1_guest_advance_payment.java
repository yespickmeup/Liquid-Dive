/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.advance_payment;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author Maytopacka
 */
public class S1_guest_advance_payment {

    public static class to_guest_advance_payment {

        public final int id;
        public final String room_id;
        public final String guest_name;
        public final String guest_id;
        public final String date_added;
        public final double amount_paid;
        public final int status;
        public final String user_name;
        public final double usd;
        public final int room_guest_id;
        public final double peso_on_bank;
        public final double usd_on_bank;
        public final String bank_no;
        public final String bank;
        public final int is_peso_on_bank;
        public final int is_usd_on_bank;
        public final String card_type;
        public final String card_holder;
        public final String card_no;
        public final String approval_code;
        public final double credit_amount;
        public final double credit_addtl;
        public final double credit_rate;

        public to_guest_advance_payment(int id, String room_id, String guest_name, String guest_id, String date_added, double amount_paid, int status, String user_name, double usd, int room_guest_id, double peso_on_bank, double usd_on_bank, String bank_no, String bank, int is_peso_on_bank, int is_usd_on_bank, String card_type, String card_holder, String card_no, String approval_code, double credit_amount, double credit_addtl, double credit_rate) {
            this.id = id;
            this.room_id = room_id;
            this.guest_name = guest_name;
            this.guest_id = guest_id;
            this.date_added = date_added;
            this.amount_paid = amount_paid;
            this.status = status;
            this.user_name = user_name;
            this.usd = usd;
            this.room_guest_id = room_guest_id;
            this.peso_on_bank = peso_on_bank;
            this.usd_on_bank = usd_on_bank;
            this.bank_no = bank_no;
            this.bank = bank;
            this.is_peso_on_bank = is_peso_on_bank;
            this.is_usd_on_bank = is_usd_on_bank;
            this.card_type = card_type;
            this.card_holder = card_holder;
            this.card_no = card_no;
            this.approval_code = approval_code;
            this.credit_amount = credit_amount;
            this.credit_addtl = credit_addtl;
            this.credit_rate = credit_rate;
        }
    }

    public static List<to_guest_advance_payment> ret_data(String room_ids, String guest_ids) {
        List<to_guest_advance_payment> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",room_id"
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
                    + " from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " room_id ='" + room_ids + "' "
                    + " and guest_id ='" + guest_ids + "' and status='" + "0" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String room_id = rs.getString(2);
                String guest_name = rs.getString(3);
                String guest_id = rs.getString(4);
                String date_added = rs.getString(5);
                double amount_paid = rs.getDouble(6);
                int status = rs.getInt(7);
                String user_name = rs.getString(8);
                double usd = rs.getDouble(9);
                int room_guest_id = rs.getInt(10);
                double peso_on_bank = rs.getDouble(11);
                double usd_on_bank = rs.getDouble(12);
                int is_peso_on_bank = rs.getInt(13);
                int is_usd_on_bank = rs.getInt(14);
                String bank_no = rs.getString(15);
                String bank = rs.getString(16);
                String card_type = rs.getString(17);
                String card_holder = rs.getString(18);
                String card_no = rs.getString(19);
                String approval_code = rs.getString(20);
                double credit_amount = rs.getDouble(21);
                double credit_addtl = rs.getDouble(22);
                double credit_rate = rs.getDouble(23);
//                System.out.println(card_no + " aa");
                to_guest_advance_payment to = new to_guest_advance_payment(id, room_id, guest_name, guest_id, date_added, amount_paid, status, user_name, usd, room_guest_id, peso_on_bank, usd_on_bank, bank_no, bank, is_peso_on_bank, is_usd_on_bank, card_type, card_holder, card_no, approval_code, credit_amount, credit_addtl, credit_rate);


                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_guest_advance_payment(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".guest_advance_payment set "
                    + "room_id= '" + to_guest_advance_payment.room_id + "'"
                    + ",guest_name= '" + to_guest_advance_payment.guest_name + "'"
                    + ",guest_id= '" + to_guest_advance_payment.guest_id + "'"
                    + ",date_added= '" + to_guest_advance_payment.date_added + "'"
                    + ",amount_paid= '" + to_guest_advance_payment.amount_paid + "'"
                    + ",status= '" + to_guest_advance_payment.status + "'"
                    + ",user_name= '" + to_guest_advance_payment.user_name + "'"
                    + ",usd= '" + to_guest_advance_payment.usd + "'"
                    + ",room_guest_id= '" + to_guest_advance_payment.room_guest_id + "'"
                    + ",peso_on_bank= '" + to_guest_advance_payment.peso_on_bank + "'"
                    + ",usd_on_bank= '" + to_guest_advance_payment.usd_on_bank + "'"
                    + ",is_peso_on_bank= '" + to_guest_advance_payment.is_peso_on_bank + "'"
                    + ",is_usd_on_bank= '" + to_guest_advance_payment.is_usd_on_bank + "'"
                    + ",bank_no= '" + to_guest_advance_payment.bank_no + "'"
                    + ",bank= '" + to_guest_advance_payment.bank + "'"
                    + ",card_type= '" + to_guest_advance_payment.card_type + "'"
                    + ",card_holder= '" + to_guest_advance_payment.card_holder + "'"
                    + ",card_no= '" + to_guest_advance_payment.card_no + "'"
                    + ",approval_code= '" + to_guest_advance_payment.approval_code + "'"
                    + ",credit_amount= '" + to_guest_advance_payment.credit_amount + "'"
                    + ",credit_addtl= '" + to_guest_advance_payment.credit_addtl + "'"
                    + ",credit_rate= '" + to_guest_advance_payment.credit_rate + "'"
                    + "where "
                    + " id ='" + to_guest_advance_payment.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_advance_payment.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_guest_advance_payment(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".guest_advance_payment where "
                    + " id ='" + to_guest_advance_payment.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_advance_payment.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }
}
