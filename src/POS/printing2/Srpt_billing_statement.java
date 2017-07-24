/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;



/**
 *
 * @author Guinness
 */
public class Srpt_billing_statement {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String room_no;
    public final String guess_names;
    public final String print_to;        
    public final List<field> fields;

    public Srpt_billing_statement(String business_name, String address, String contact_no, String date, String room_no, String guess_names,String print_to) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.room_no = room_no;
        this.guess_names = guess_names;
        this.fields = new ArrayList();
        this.print_to=print_to;
    }

    public static class field {

        String item_code;
        String description;
        String assembly;
        double qty;
        double selling_price;
        double discount;
        double amount;

        public field() {
        }

        public field(String item_code, String description, String assembly, double qty, double selling_price, double discount, double amount) {
            this.item_code = item_code;
            this.description = description;
            this.assembly = assembly;
            this.qty = qty;
            this.selling_price = selling_price;
            this.discount = discount;
            this.amount = amount;
        }

        public String getItem_code() {
            return item_code;
        }

        public void setItem_code(String item_code) {
            this.item_code = item_code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAssembly() {
            return assembly;
        }

        public void setAssembly(String assembly) {
            this.assembly = assembly;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        String address = System.getProperty("address", "Dauin, Negros Oriental");
        String contact_no = System.getProperty("contact_no", "1235566");
        String date = "July 23, 2017 08:41 PM";
        String room_no = "DM I (FRONT)";
        String guess_names = "Ronald Pascua, Ronald Pascua";
        String print_to="";
        Srpt_billing_statement rpt = new Srpt_billing_statement(business_name, address, contact_no, date, room_no, guess_names,print_to);

        for (int i = 0; i < 10; i++) {
            String item_code = "100" + i;
            String description = "Description " + i;
            String assembly = "";
            double qty = i;
            double selling_price = 100 + i;
            double discount = 0;
            double amount = qty * selling_price;
            Srpt_billing_statement.field field = new field(item_code, description, assembly, qty, selling_price, discount, amount);
            rpt.fields.add(field);
        }

        String jrxml = "rpt_billing_statement.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_billing_statement.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_billing_statement to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }
}
