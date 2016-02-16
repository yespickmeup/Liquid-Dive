/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.billing_history;

import POS.Main.MyDB;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_billing_history {

    public static class to_billing_histories {

        public final int id;
        public final String room_id;
        public final String room_name;
        public final String guest_ids;
        public final String guest_names;
        public final String checkin_date;
        public final String checkout_date;
        public final int status;
        public final double gross_sales;
        public final double to_pay;
        public final double adv_peso;
        public final double adv_usd;
        public final double paid_peso;
        public final double paid_dollar;
        public final double paid_credit;
        public final double dollar_rate;
        public final double discount;
        public final double discount_rate;
        public final String discount_name;
        public final String room_guest_ids;
        public final String user_name;
        public final double bank_php;
        public final double bank_usd;
        public final double credit_card;

        public to_billing_histories(int id, String room_id, String room_name, String guest_ids
                , String guest_names, String checkin_date, String checkout_date, int status
                , double gross_sales, double to_pay, double adv_peso, double adv_usd, double paid_peso, double paid_dollar
                , double paid_credit, double dollar_rate, double discount, double discount_rate, String discount_name
                , String room_guest_ids, String user_name, double bank_php, double bank_usd,double credit_card) {
            this.id = id;
            this.room_id = room_id;
            this.room_name = room_name;
            this.guest_ids = guest_ids;
            this.guest_names = guest_names;
            this.checkin_date = checkin_date;
            this.checkout_date = checkout_date;
            this.status = status;
            this.gross_sales = gross_sales;
            this.to_pay = to_pay;
            this.adv_peso = adv_peso;
            this.adv_usd = adv_usd;
            this.paid_peso = paid_peso;
            this.paid_dollar = paid_dollar;
            this.paid_credit = paid_credit;
            this.dollar_rate = dollar_rate;
            this.discount = discount;
            this.discount_rate = discount_rate;
            this.discount_name = discount_name;
            this.room_guest_ids = room_guest_ids;
            this.user_name = user_name;
            this.bank_php = bank_php;
            this.bank_usd = bank_usd;
            this.credit_card=credit_card;
        }
    }

    public static void add_billing_histories(to_billing_histories to_billing_histories,int payable,double due,double credit_card) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".billing_histories("
                    + "room_id"
                    + ",room_name"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",checkin_date"
                    + ",checkout_date"
                    + ",status"
                    + ",gross_sales"
                    + ",to_pay"
                    + ",adv_peso"
                    + ",adv_usd"
                    + ",paid_peso"
                    + ",paid_dollar"
                    + ",paid_credit"
                    + ",dollar_rate"
                    + ",discount"
                    + ",discount_rate"
                    + ",discount_name"
                    + ",room_guest_ids"
                    + ",user_name"
                    + ",bank_php"
                    + ",bank_usd"
                     + ",payable"
                     + ",due"
                     + ",credit_card"
                    + ")values("
                    + ":room_id"
                    + ",:room_name"
                    + ",:guest_ids"
                    + ",:guest_names"
                    + ",:checkin_date"
                    + ",:checkout_date"
                    + ",:status"
                    + ",:gross_sales"
                    + ",:to_pay"
                    + ",:adv_peso"
                    + ",:adv_usd"
                    + ",:paid_peso"
                    + ",:paid_dollar"
                    + ",:paid_credit"
                    + ",:dollar_rate"
                    + ",:discount"
                    + ",:discount_rate"
                    + ",:discount_name"
                    + ",:room_guest_ids"
                    + ",:user_name"
                    + ",:bank_php"
                    + ",:bank_usd"
                     + ",:payable"
                    + ",:due"
                    + ",:credit_card"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("room_id", to_billing_histories.room_id).
                    setString("room_name", to_billing_histories.room_name).
                    setString("guest_ids", to_billing_histories.guest_ids).
                    setString("guest_names", to_billing_histories.guest_names).
                    setString("checkin_date", to_billing_histories.checkin_date).
                    setString("checkout_date", to_billing_histories.checkout_date).
                    setNumber("status", to_billing_histories.status).
                    setNumber("gross_sales", to_billing_histories.gross_sales).
                    setNumber("to_pay", to_billing_histories.to_pay).
                    setNumber("adv_peso", to_billing_histories.adv_peso).
                    setNumber("adv_usd", to_billing_histories.adv_usd).
                    setNumber("paid_peso", to_billing_histories.paid_peso).
                    setNumber("paid_dollar", to_billing_histories.paid_dollar).
                    setNumber("paid_credit", to_billing_histories.paid_credit).
                    setNumber("dollar_rate", to_billing_histories.dollar_rate).
                    setNumber("discount", to_billing_histories.discount).
                    setNumber("discount_rate", to_billing_histories.discount_rate).
                    setString("discount_name", to_billing_histories.discount_name).
                    setString("room_guest_ids", to_billing_histories.room_guest_ids).
                    setString("user_name", to_billing_histories.user_name).
                    setNumber("bank_php", to_billing_histories.bank_php).
                    setNumber("bank_usd", to_billing_histories.bank_usd).
                     setNumber("payable", payable).
                    setNumber("due", due).
                      setNumber("credit_card", credit_card).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_billing_history.class, "Successfully Added");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static String increment_id() {
        int id = 0;
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select max(id) from " + MyDB.getNames() + ".billing_histories";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            id = FitIn.toInt(ReceiptIncrementor.increment("" + id));
            return "" + id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_billing_histories> ret_data(String search, String date_from, String date_to) {
        List<to_billing_histories> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",room_id"
                    + ",room_name"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",checkin_date"
                    + ",checkout_date"
                    + ",status"
                    + ",gross_sales"
                    + ",to_pay"
                    + ",adv_peso"
                    + ",adv_usd"
                    + ",paid_peso"
                    + ",paid_dollar"
                    + ",paid_credit"
                    + ",dollar_rate"
                    + ",discount"
                    + ",discount_rate"
                    + ",discount_name"
                    + ",room_guest_ids"
                    + ",user_name"
                    + ",bank_php"
                    + ",bank_usd"
                    + ",credit_card"
                    + " from " + MyDB.getNames() + ".billing_histories where "
                    + " guest_names like'%" + search + "%'and  Date(checkout_date) between '" + date_from + "' and '" + date_to + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String room_id = rs.getString(2);
                String room_name = rs.getString(3);
                String guest_ids = rs.getString(4);
                String guest_names = rs.getString(5);
                String checkin_date = rs.getString(6);
                String checkout_date = rs.getString(7);
                int status = rs.getInt(8);
                double gross_sales = rs.getDouble(9);
                double to_pay = rs.getDouble(10);
                double adv_peso = rs.getDouble(11);
                double adv_usd = rs.getDouble(12);
                double paid_peso = rs.getDouble(13);
                double paid_dollar = rs.getDouble(14);
                double paid_credit = rs.getDouble(15);
                double dollar_rate = rs.getDouble(16);
                double discount = rs.getDouble(17);
                double discount_rate = rs.getDouble(18);
                String discount_name = rs.getString(19);
                String room_guest_ids = rs.getString(20);
                String user_name = rs.getString(21);
                double bank_php = rs.getDouble(22);
                double bank_usd = rs.getDouble(23);
                 double credit_card = rs.getDouble(24);
                to_billing_histories to = new to_billing_histories(id, room_id, room_name, guest_ids, guest_names, checkin_date, checkout_date
                        , status, gross_sales, to_pay, adv_peso, adv_usd, paid_peso, paid_dollar, paid_credit, dollar_rate, discount
                        , discount_rate, discount_name, room_guest_ids, user_name, bank_php, bank_usd,credit_card);
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
