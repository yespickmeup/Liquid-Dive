/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import rpt_liquid.Srpt_bar_and_resto.field;

/**
 *
 * @author i1
 */
public class Srpt_liquid_billing {

    public final String busi_name;
    public final double room_rate;
    public final String accomodation;
    public final String SUBREPORT_DIR;
    public final List<Srpt_bar_and_resto.field> rpt_bar_and_resto;
    public final List<Srpt_bar_and_resto.field> rpt_bar;
    public final List<Srpt_others.field> rpt_others;
    public final List<Srpt_accomodation.field> rpt_accomodation;
    public final List<Srpt_history_advance_payments.field> rpt_advance_payments;
    public final List<Srpt_category_discounts.field> rpt_category_discounts;
    public final String my_date;
    public final String guest_id;
    public final String table_no;
    public final String check_in;
    public final String transfers;
    public final String accomodation_1;
    public final double accom_total;
    public final String img_path;
    public final double to_pay;
    public final String guest_name;
    public final double dollar;
    public final double total_charges;
    public final double discount;
    public final double dollar_rate;
    public final double advance_payment;
    public final double advance_payment_usd;
    public final double paid_peso;
    public final double paid_usd;
    public final double paid_cc;
    public final double bank_php;
    public final double bank_usd;
    public final double credit_card;
    public final double dollar_to_pay;
    public final List<Srpt_bar_and_resto.field> rpt_summary;

    public Srpt_liquid_billing(String busi_name, double room_rate, String accomodation, String SUBREPORT_DIR
            , List<field> rpt_bar_and_resto, List<field> rpt_bar, List<Srpt_others.field> rpt_others
            , List<Srpt_accomodation.field> rpt_accomodation, List<Srpt_history_advance_payments.field> rpt_advance_payments
            ,List<Srpt_category_discounts.field> rpt_category_discounts, String my_date, String guest_id
            , String table_no, String check_in, String transfers, String accomodation_1
            , double accom_total, String img_path, double to_pay, String guest_name
            , double dollar, double total_charges, double discount, double dollar_rate
            , double advance_payment, double advance_payment_usd, double paid_peso, double paid_usd
            , double paid_cc, double bank_php, double bank_usd, double credit_card
            , double dollar_to_pay,List<Srpt_bar_and_resto.field> rpt_summary
            ) {
        this.busi_name = busi_name;
        this.room_rate = room_rate;
        this.accomodation = accomodation;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_bar_and_resto = rpt_bar_and_resto;
        this.rpt_bar = rpt_bar;
        this.rpt_others = rpt_others;
        this.rpt_accomodation = rpt_accomodation;
         this.rpt_advance_payments = rpt_advance_payments;
         this.rpt_category_discounts=rpt_category_discounts;
        this.my_date = my_date;
        this.guest_id = guest_id;
        this.table_no = table_no;
        this.check_in = check_in;
        this.transfers = transfers;
        this.accomodation_1 = accomodation_1;
        this.accom_total = accom_total;
        this.img_path = img_path;
        this.to_pay = to_pay;
        this.guest_name = guest_name;
        this.dollar = dollar;
        this.total_charges = total_charges;
        this.discount = discount;
        this.dollar_rate = dollar_rate;
        this.advance_payment = advance_payment;
        this.advance_payment_usd = advance_payment_usd;
        this.paid_peso = paid_peso;
        this.paid_usd = paid_usd;
        this.paid_cc = paid_cc;
        this.bank_php = bank_php;
        this.bank_usd = bank_usd;
        this.credit_card = credit_card;
        this.dollar_to_pay=dollar_to_pay;
        this.rpt_summary=rpt_summary;
    }

    public double getDollar_to_pay() {
        return dollar_to_pay;
    }

    
    public List<Srpt_category_discounts.field> getRpt_category_discounts() {
        return rpt_category_discounts;
    }

    
    public List<Srpt_history_advance_payments.field> getRpt_advance_payments() {
        return rpt_advance_payments;
    }

    public double getCredit_card() {
        return credit_card;
    }

    public double getBank_php() {
        return bank_php;
    }

    public double getBank_usd() {
        return bank_usd;
    }

    public double getDiscount() {
        return discount;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public double getAccom_total() {
        return accom_total;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public String getAccomodation_1() {
        return accomodation_1;
    }

    public String getBusi_name() {
        return busi_name;
    }

    public String getCheck_in() {
        return check_in;
    }

    public double getDollar() {
        return dollar;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public String getMy_date() {
        return my_date;
    }

    public double getRoom_rate() {
        return room_rate;
    }

    public List<field> getRpt_bar_and_resto() {
        return rpt_bar_and_resto;
    }

    public List<field> getRpt_bar() {
        return rpt_bar;
    }

    public List<Srpt_others.field> getRpt_others() {
        return rpt_others;
    }

    public List<Srpt_accomodation.field> getRpt_accomodation() {
        return rpt_accomodation;
    }

    public String getTable_no() {
        return table_no;
    }

    public double getTo_pay() {
        return to_pay;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public String getTransfers() {
        return transfers;
    }

    public double getAdvance_payment() {
        return advance_payment;
    }

    public double getDollar_rate() {
        return dollar_rate;
    }

    public double getAdvance_payment_usd() {
        return advance_payment_usd;
    }

    public double getPaid_cc() {
        return paid_cc;
    }

    public double getPaid_peso() {
        return paid_peso;
    }

    public double getPaid_usd() {
        return paid_usd;
    }

    public static void main(String[] args) {

        String busi_name = "Synapse Casa";
        double room_rate = 100;
        String accomodation = "accomodation";
//        String SUBREPORT_DIR = "/POS/rpt_liquid/";
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
//         String SUBREPORT_DIR = "C:\\Users\\i1\\Dropbox\\ronald_prototypes\\report_no_db\\src\\rpt_liquid\\";
        // array list for restos

        String my_date = "January 1,2013";
        String guest_id = "1";
        String table_no = "1";
        String check_in = "check in";
        String transfers = "none";
        String accomodation_1 = "accom@";
        double accom_total = 1000;
        String img_path = System.getProperty("img_path", "C:\\Users\\Maytopacka\\");
        double to_pay = 1002;
        String guest_name = "Ron@";
        double dollar_rate = 14;
        double dollar = to_pay / dollar_rate;
        List<Srpt_bar_and_resto.field> rpt_bar_and_resto = new ArrayList();
        for (int i = 0; i < 3; i++) {
            Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field("desc" + i, new Date(), i + 100, 0);
            rpt_bar_and_resto.add(tbar);
        }

        List<Srpt_others.field> rpt_others = new ArrayList();
        int h = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                h++;
            }
            Srpt_others.field tbar = new Srpt_others.field("category" + h, "desc", i, 100 + i);
            rpt_others.add(tbar);

        }
        List<Srpt_accomodation.field> accom = new ArrayList();
        for (int i = 0; i < 2; i++) {
            double qty = i;
            int nights = i;
            String description = "desc" + i;
            double price = 100 + i;
            double amount = 200 + i;
            String date_stayed = "(January 1, 2013 - January 5, 2012)";
            Srpt_accomodation.field tbar = new Srpt_accomodation.field(qty, nights, description, price, amount, date_stayed, "");
            accom.add(tbar);
        }
        List<Srpt_history_advance_payments.field> advances = new ArrayList();
        for (int i = 0; i < 10; i++) {
            String date_added = "date";
            double php_cash = i + 1;
            double php_bank = i + 2;
            double usd_cash = i + 3;
            double usd_bank = i + 1;
            String bank = "";
            String approval_code = "";
            double credit_card = 0;
            double credit_card_rate=0;
            Srpt_history_advance_payments.field to2 = new Srpt_history_advance_payments.field(date_added, php_cash, php_bank, usd_cash, usd_bank, bank, approval_code, credit_card
                    , "",credit_card_rate);
          
            advances.add(to2);
        }
        
         List<Srpt_category_discounts.field> category_discounts = new ArrayList();
        for (int i = 0; i < 5; i++) {
            String category = "cat " + i;
            double due = 0;
            double disc_percent = i;
            double disc_amount = i * 2;
            double sub_total = 0;
            Srpt_category_discounts.field tbar = new Srpt_category_discounts.field(category, due, disc_percent, disc_amount, sub_total);
            category_discounts.add(tbar);
        }
        Srpt_liquid_billing rpt = new Srpt_liquid_billing(busi_name, room_rate, accomodation
                , SUBREPORT_DIR, rpt_bar_and_resto, rpt_bar_and_resto, rpt_others, accom,advances,category_discounts, my_date
                , guest_id, table_no, check_in, transfers, accomodation_1, accom_total, img_path
                , to_pay, guest_name, dollar, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,new ArrayList());
        JRViewer viewer = Srpt_liquid_billing.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_billing_liquid.jrxml";
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pdf_viewer(Srpt_liquid_billing to) {

        JasperUtil.pdfViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JRViewer get_viewer(Srpt_liquid_billing to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }
      public static JRViewer get_viewer2(Srpt_liquid_billing to) {

        return JasperUtil.getJasperViewer(
                compileJasper2(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }
      
       public static JasperReport compileJasper2() {
        try {
            String jrxml = "rpt_billing_liquid_paid_summary.jrxml";
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
