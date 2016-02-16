/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.redo_receipts;

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
public class S2_receipts {

    public static class to_receipts {

        public final int id;
        public final int cashier_session_id;
        public final double tendered;
        public final String or_number;
        public final int receipt_status;
        public final String receipt_date;
        public final double discount;
        public final double credit;
        public final String approval_code;
        public final String member_id;
        public final String is_payed;
        public final double dollar;
        public final double credit_dollar;
        public final double dollar_rate;
        public final double peso;
        public final String user_name;
        public final String guest_ids;
        public final String guest_names;
        public final String room_guest_ids;
        public final String table_id;
        public final String table_name;
        public final double gross_sales;
        public final double bank_php;
        public final double bank_usd;
        public final double credit_card;

        public to_receipts(int id, int cashier_session_id, double tendered, String or_number, int receipt_status, String receipt_date, double discount, double credit, String approval_code, String member_id, String is_payed, double dollar, double credit_dollar, double dollar_rate, double peso, String user_name, String guest_ids, String guest_names, String room_guest_ids, String table_id, String table_name, double gross_sales, double bank_php, double bank_usd, double credit_card) {
            this.id = id;
            this.cashier_session_id = cashier_session_id;
            this.tendered = tendered;
            this.or_number = or_number;
            this.receipt_status = receipt_status;
            this.receipt_date = receipt_date;
            this.discount = discount;
            this.credit = credit;
            this.approval_code = approval_code;
            this.member_id = member_id;
            this.is_payed = is_payed;
            this.dollar = dollar;
            this.credit_dollar = credit_dollar;
            this.dollar_rate = dollar_rate;
            this.peso = peso;
            this.user_name = user_name;
            this.guest_ids = guest_ids;
            this.guest_names = guest_names;
            this.room_guest_ids = room_guest_ids;
            this.table_id = table_id;
            this.table_name = table_name;
            this.gross_sales = gross_sales;
            this.bank_php = bank_php;
            this.bank_usd = bank_usd;
            this.credit_card = credit_card;
        }
    }

    public static void edit_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".receipts set "
                    + "cashier_session_id= '" + to_receipts.cashier_session_id + "'"
                    + ",tendered= '" + to_receipts.tendered + "'"
                    + ",or_number= '" + to_receipts.or_number + "'"
                    + ",receipt_status= '" + to_receipts.receipt_status + "'"
                    + ",receipt_date= '" + to_receipts.receipt_date + "'"
                    + ",discount= '" + to_receipts.discount + "'"
                    + ",credit= '" + to_receipts.credit + "'"
                    + ",approval_code= '" + to_receipts.approval_code + "'"
                    + ",member_id= '" + to_receipts.member_id + "'"
                    + ",is_payed= '" + to_receipts.is_payed + "'"
                    + ",dollar= '" + to_receipts.dollar + "'"
                    + ",credit_dollar= '" + to_receipts.credit_dollar + "'"
                    + ",dollar_rate= '" + to_receipts.dollar_rate + "'"
                    + ",peso= '" + to_receipts.peso + "'"
                    + ",user_name= '" + to_receipts.user_name + "'"
                    + ",guest_ids= '" + to_receipts.guest_ids + "'"
                    + ",guest_names= '" + to_receipts.guest_names + "'"
                    + ",room_guest_ids= '" + to_receipts.room_guest_ids + "'"
                    + ",table_id= '" + to_receipts.table_id + "'"
                    + ",table_name= '" + to_receipts.table_name + "'"
                    + ",gross_sales= '" + to_receipts.gross_sales + "'"
                    + ",bank_php= '" + to_receipts.bank_php + "'"
                    + ",bank_usd= '" + to_receipts.bank_usd + "'"
                    + ",credit_card= '" + to_receipts.credit_card + "'"
                    + "where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_receipts.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_receipts> ret_data(String date_from,String date_to,String guest,String user_names) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",cashier_session_id"
                    + ",tendered"
                    + ",or_number"
                    + ",receipt_status"
                    + ",receipt_date"
                    + ",discount"
                    + ",credit"
                    + ",approval_code"
                    + ",member_id"
                    + ",is_payed"
                    + ",dollar"
                    + ",credit_dollar"
                    + ",dollar_rate"
                    + ",peso"
                    + ",user_name"
                    + ",guest_ids"
                    + ",guest_names"
                    + ",room_guest_ids"
                    + ",table_id"
                    + ",table_name"
                    + ",gross_sales"
                    + ",bank_php"
                    + ",bank_usd"
                    + ",credit_card"
                    + " from " + MyDB.getNames() + ".receipts where "
                    + " date(receipt_date) between '" + date_from + "' and '" + date_to + "' "
                    + " and guest_names like'%" + guest + "%' "
                    + " and user_name like'%" + user_names + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                double tendered = rs.getDouble(3);
                String or_number = rs.getString(4);
                int receipt_status = rs.getInt(5);
                String receipt_date = rs.getString(6);
                double discount = rs.getDouble(7);
                double credit = rs.getDouble(8);
                String approval_code = rs.getString(9);
                String member_id = rs.getString(10);
                String is_payed = rs.getString(11);
                double dollar = rs.getDouble(12);
                double credit_dollar = rs.getDouble(13);
                double dollar_rate = rs.getDouble(14);
                double peso = rs.getDouble(15);
                String user_name = rs.getString(16);
                String guest_ids = rs.getString(17);
                String guest_names = rs.getString(18);
                String room_guest_ids = rs.getString(19);
                String table_id = rs.getString(20);
                String table_name = rs.getString(21);
                double gross_sales = rs.getDouble(22);
                double bank_php = rs.getDouble(23);
                double bank_usd = rs.getDouble(24);
                double credit_card = rs.getDouble(25);

                to_receipts to = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar, credit_dollar, dollar_rate, peso, user_name, guest_ids, guest_names, room_guest_ids, table_id, table_name, gross_sales, bank_php, bank_usd, credit_card);
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
