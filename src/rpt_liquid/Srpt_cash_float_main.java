/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import rpt_liquid.Srpt_cash_float.field;

/**
 *
 * @author Maytopacka
 */
public class Srpt_cash_float_main {

    public final List<Srpt_cash_float.field> rpt_float;
    public final String SUBREPORT_DIR;

    public Srpt_cash_float_main(List<Srpt_cash_float.field> rpt_float, String SUBREPORT_DIR) {
        this.rpt_float = rpt_float;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
    }

    public List<field> getRpt_float() {
        return rpt_float;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public static void main(String[] args) {
//        Main.MyDB.setNames("db_pos_restaurant");
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
        List<Srpt_cash_float.field> datas = Srpt_cash_float.ret_data("",new ArrayList(),"");
        Srpt_cash_float_main rpt = new Srpt_cash_float_main(datas, SUBREPORT_DIR);

        System.out.println(datas.size());
        JRViewer viewer = Srpt_cash_float_main.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cash_float_main.jrxml";
            InputStream is = Srpt_cash_float_main.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pdf_viewer(Srpt_cash_float_main to) {

        JasperUtil.pdfViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JRViewer get_viewer(Srpt_cash_float_main to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }
}
