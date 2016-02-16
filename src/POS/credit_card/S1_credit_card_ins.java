/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.credit_card;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_credit_card_ins {

    public static class to_credit_card_ins {

        public final int id;
        public final String date_added;
        public final double amount;
        public final String user_name;
        public final String bank;

        public to_credit_card_ins(int id, String date_added, double amount, String user_name, String bank) {
            this.id = id;
            this.date_added = date_added;
            this.amount = amount;
            this.user_name = user_name;
            this.bank = bank;
        }
    }

    public static void add_credit_card_ins(to_credit_card_ins to_credit_card_ins,double payments,double reflenishment,double balance) {
        
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "insert into " + MyDB.getNames() + ".credit_card_ins("
                    + "date_added"
                    + ",amount"
                    + ",user_name"
                    + ",bank"
                    + ")values("
                    + ":date_added"
                    + ",:amount"
                    + ",:user_name"
                    + ",:bank"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("date_added", to_credit_card_ins.date_added).
                    setNumber("amount", to_credit_card_ins.amount).
                    setString("user_name", to_credit_card_ins.user_name).
                    setString("bank", to_credit_card_ins.bank).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_card_ins.class, "Successfully Added");
            
            double new_ref=to_credit_card_ins.amount+reflenishment;
            double new_payment=payments-to_credit_card_ins.amount;
            
            S2_credit_card_balance.edit_actual_balance(new_ref);
            S2_credit_card_balance.edit_credit_card_payment(new_payment);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void edit_credit_card_ins(to_credit_card_ins to_credit_card_ins,double payments,double reflenishment,double balance,double amount,double last_amount) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "update " + MyDB.getNames() + ".credit_card_ins set "
                    + "date_added= '" + to_credit_card_ins.date_added + "'"
                    + ",amount= '" + to_credit_card_ins.amount + "'"
                    + ",user_name= '" + to_credit_card_ins.user_name + "'"
                    + ",bank= '" + to_credit_card_ins.bank + "'"
                    + "where "
                    + " id ='" + to_credit_card_ins.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_card_ins.class, "Successfully Updated");
            
             double new_ref=(reflenishment-last_amount)+amount;
//            double new_payment=payments-to_credit_card_ins.amount;
            
            S2_credit_card_balance.edit_actual_balance(new_ref);
//            S2_credit_card_balance.edit_credit_card_payment(new_payment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static void delete_credit_card_ins(String id,double amount,double payments,double reflenishment,double balance) {
        try {
            Connection conn = MyConnection1.connect();
            String s0 = "delete from " + MyDB.getNames() + ".credit_card_ins where "
                    + " id ='" + id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_credit_card_ins.class, "Successfully Deleted");
            
            double new_ref=reflenishment-amount;
            double new_payment=payments+amount;
            
            S2_credit_card_balance.edit_actual_balance(new_ref);
            S2_credit_card_balance.edit_credit_card_payment(new_payment);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<to_credit_card_ins> ret_data(String date_from, String date_to, String banks) {
        List<to_credit_card_ins> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",amount"
                    + ",user_name"
                    + ",bank"
                    + " from " + MyDB.getNames() + ".credit_card_ins where "
                    + " Date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and bank like '%" + banks + "%' "
                    + " ";
            
            Date d=new Date();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                d = DateType.datetime.parse(date_added);
                date_added = DateType.liquid.format(d);
                double amount = rs.getDouble(3);
                String user_name = rs.getString(4);
                String bank = rs.getString(5);

                to_credit_card_ins to = new to_credit_card_ins(id, date_added, amount, user_name, bank);
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
