/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_card;

import POS.Main.MyDB;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maytopacka
 */
public class S3_credit_card_payments {

    public static class to_credits {

        public final int id;
        public final String or_no;
        public final String bank_name;
        public final String card_type;
        public final String card_holder;
        public final String card_no;
        public final String approval_code;
        public final double amount;
        public final String user_name;
        public final String user_id;
        public final String date_payed;
        public final double dollar_amount;
        public final double dollar_rate;
        public final int session_id;

        public to_credits(int id, String or_no, String bank_name, String card_type, String card_holder, String card_no, String approval_code, double amount, String user_name, String user_id, String date_payed, double dollar_amount, double dollar_rate, int session_id) {
            this.id = id;
            this.or_no = or_no;
            this.bank_name = bank_name;
            this.card_type = card_type;
            this.card_holder = card_holder;
            this.card_no = card_no;
            this.approval_code = approval_code;
            this.amount = amount;
            this.user_name = user_name;
            this.user_id = user_id;
            this.date_payed = date_payed;
            this.dollar_amount = dollar_amount;
            this.dollar_rate = dollar_rate;
            this.session_id = session_id;
        }
    }

    public static List<to_credits> ret_data(String date_from, String date_to) {
        List<to_credits> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",or_no"
                    + ",bank_name"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",user_name"
                    + ",user_id"
                    + ",date_payed"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + ",session_id"
                    + " from " + MyDB.getNames() + ".credits where "
                    + " Date(date_payed) between '" + date_from + "' and '" + date_to + "' "
                    + " ";

            Date d = new Date();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String or_no = rs.getString(2);
                String bank_name = rs.getString(3);
                String card_type = rs.getString(4);
                String card_holder = rs.getString(5);
                String card_no = rs.getString(6);
                String approval_code = rs.getString(7);
                double amount = rs.getDouble(8);
                String user_name = rs.getString(9);
                String user_id = rs.getString(10);
                user_name = to_users.ret_data(user_name);
                String date_payed = rs.getString(11);
                d = DateType.datetime.parse(date_payed);
                date_payed = DateType.liquid.format(d);

                double dollar_amount = rs.getDouble(12);
                double dollar_rate = rs.getDouble(13);
                int session_id = rs.getInt(14);

                to_credits to = new to_credits(id, or_no, bank_name, card_type, card_holder, card_no, approval_code, amount, user_name, user_id, date_payed, dollar_amount, dollar_rate, session_id);
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
