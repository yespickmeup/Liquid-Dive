package POS.stock_in;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.MyConnection1;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guinness
 */
public class Srpt_stock_in {

    public final String business_name;
    public final String date;
    public final String category;
    public final String sub_category;
    public final List<field> fields;

    public Srpt_stock_in(String business_name, String date, String category, String sub_category) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.date = date;
        this.category = category;
        this.sub_category = sub_category;
    }

    public static class field {

        String product_num;
        String prod_name;
        double qty;
        double cost;
        double amount;
        String date_added;
        String category;
        String category_id;
        String sub_category;
        String sub_category_id;
        String supplier;

        public field() {
        }

        public field(String product_num, String prod_name, double qty, double cost, double amount, String date_added, String category, String category_id, String sub_category, String sub_category_id, String supplier) {
            this.product_num = product_num;
            this.prod_name = prod_name;
            this.qty = qty;
            this.cost = cost;
            this.amount = amount;
            this.date_added = date_added;
            this.category = category;
            this.category_id = category_id;
            this.sub_category = sub_category;
            this.sub_category_id = sub_category_id;
            this.supplier = supplier;
        }

        public String getProduct_num() {
            return product_num;
        }

        public void setProduct_num(String product_num) {
            this.product_num = product_num;
        }

        public String getProd_name() {
            return prod_name;
        }

        public void setProd_name(String prod_name) {
            this.prod_name = prod_name;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getSub_category() {
            return sub_category;
        }

        public void setSub_category(String sub_category) {
            this.sub_category = sub_category;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

    }

    public static void main2(String[] args) {
        MyDB.setNames("db_pos_restaurant");
        List<field> datas = ret_data("");
        System.out.println("Size: " + datas.size());
    }

    public static void main(String[] args) {
        MyDB.setNames("db_pos_restaurant");

        List<Srpt_stock_in.field> datas = Srpt_stock_in.ret_data("");
        String business_name = System.getProperty("business_name", "Liquid Dive Dumaguete");
        String date = DateType.month_date.format(new Date());

        String category = "All";
        String sub_category = "All";
        String printed_by = "Administrator";
        Srpt_stock_in rpt = new Srpt_stock_in(business_name, date, category, sub_category);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_stock_in.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_stock_in.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_stock_in to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "si.id"
                    + ",si.prod_num"
                    + ",si.prod_name"
                    + ",si.qty"
                    + ",si.amount"
                    + ",si.date_added"
                    + ",si.cashier_name"
                    + ",si.cashier_id"
                    + ",si.remarks"
                    + ",si.branch_id"
                    + ",si.branch"
                    + ",si.status"
                    + ",si.cost"
                    + ",si.types"
                    + ",si.types_num"
                    + ",si.cat_id"
                    + ",si.supplier"
                    + " from " + MyDB.getNames() + ".stock_in si "
                    + " join  " + MyDB.getNames() + ".inventory2_stocks_left s "
                    + " on si.prod_num=s.product_name "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String prod_num = rs.getString(2);
                String prod_name = rs.getString(3);
                double qty = rs.getDouble(4);
                double amount = rs.getDouble(5);
                String date_added = rs.getString(6);
                date_added = DateType.convert_slash(date_added);
                String cashier_name = rs.getString(7);
                String cashier_id = rs.getString(8);
                String remarks = rs.getString(9);
                int branch_id = rs.getInt(10);
                String branch = rs.getString(11);
                int status = rs.getInt(12);
                double cost = rs.getDouble(13);

                String category = "";
                String category_id = rs.getString(16);
                String sub_category = rs.getString(14);
                String sub_category_id = rs.getString(15);
                String supplier = rs.getString(16);

                amount = qty * cost;
                Srpt_stock_in.field f = new field(prod_num, prod_name, qty, cost, amount, date_added, category, category_id, sub_category, sub_category_id, supplier);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

    public static List<field> ret_data_out(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection1.connect();
            String s0 = "select "
                    + "si.id"
                    + ",si.prod_num"
                    + ",si.prod_name"
                    + ",si.qty"
                    + ",si.amount"
                    + ",si.date_added"
                    + ",si.cashier_name"
                    + ",si.cashier_id"
                    + ",si.remarks"
                    + ",si.branch_id"
                    + ",si.branch"
                    + ",si.status"
                    + ",si.cost"
                    + ",si.types"
                    + ",si.types_num"
                    + ",si.cat_id"
                    + ",si.supplier"
                    + " from " + MyDB.getNames() + ".stock_out si "
                    + " join  " + MyDB.getNames() + ".inventory2_stocks_left s "
                    + " on si.prod_num=s.product_name "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String prod_num = rs.getString(2);
                String prod_name = rs.getString(3);
                double qty = rs.getDouble(4);
                double amount = rs.getDouble(5);
                String date_added = rs.getString(6);
                date_added = DateType.convert_slash(date_added);
                String cashier_name = rs.getString(7);
                String cashier_id = rs.getString(8);
                String remarks = rs.getString(9);
                int branch_id = rs.getInt(10);
                String branch = rs.getString(11);
                int status = rs.getInt(12);
                double cost = rs.getDouble(13);

                String category = "";
                String category_id = rs.getString(16);
                String sub_category = rs.getString(14);
                String sub_category_id = rs.getString(15);
                String supplier = rs.getString(16);

                amount = qty * cost;
                Srpt_stock_in.field f = new field(prod_num, prod_name, qty, cost, amount, date_added, category, category_id, sub_category, sub_category_id, supplier);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection1.close();
        }
    }

}
