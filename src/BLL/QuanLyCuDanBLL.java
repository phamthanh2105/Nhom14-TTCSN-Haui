/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static DAL.QuanLyCuDanDAL.dsCuDan;
import static DAL.QuanLyCuDanDAL.layMaCuDan;
import Entities.CuDan;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import GUI.RegexExpression;


public class QuanLyCuDanBLL {
    //Begin TabQuanLyCuDan
    public static void LoadTable(JTable tbl, List list){
        List<CuDan> dsCuDan = list;
        Object[] colName = new Object[]{"Mã cư dân", "Tên cư dân", "Ngày sinh", "Giới tính", "SĐT", "Số CCCD", "Quê quán"};
        Object[][] data = new Object[dsCuDan.size()][8];
        int i = 0;
        for (CuDan cd : dsCuDan) {
            data[i][0] = cd.getMaCuDan();
            data[i][1] = cd.getTenCuDan();
            data[i][2] = cd.getNgaySinh();
            if (cd.isGioiTinh() == true) {
                data[i][3] = "Nam";
            } else {
                data[i][3] = "Nữ";
            }
            data[i][4] = cd.getSoDT();
            data[i][5] = cd.getSoCMT();
            data[i][6] = cd.getQueQuan();
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }
    
    public static void HienThongTinCuDan(JTable tbl) throws SQLException {
        List<CuDan> dsCuDan = DAL.QuanLyCuDanDAL.dsCuDan();
        LoadTable(tbl, dsCuDan);
    }

    public static void updateCD_BLL(JTextField macd, JTextField tencd, JTextField ngsinh, JComboBox gioitinh, JTextField sdt, JTextField socmt, JTextField quequan) throws SQLException, ParseException {
        List<CuDan> dsCuDan = DAL.QuanLyCuDanDAL.dsCuDan();
        boolean flag = false;

        for (CuDan cd : dsCuDan) {
            if (cd.getMaCuDan().equals(macd.getText())) {
                flag = true;
                break;
            }
        }

        if (!flag || macd.getText() == null) {
            JOptionPane.showMessageDialog(null, "Chọn mã cư dân.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //set gioitinh
            boolean gt = false;
            gt = gioitinh.getSelectedItem().toString().equals("Nam");

            CuDan cd = new CuDan(macd.getText(), RegexExpression.toUpperCaseFirstCharacter(tencd.getText()), ngsinh.getText(), gt, sdt.getText(), socmt.getText().trim(), quequan.getText());
            DAL.QuanLyCuDanDAL.updateCD_DAL(cd);
        }
    }
    
    public static void TimKiemCD_BLL(JTable tbl, String info) throws SQLException{
        List<CuDan> dsCuDanTK= DAL.QuanLyCuDanDAL.TimKiemCD_DAL(info);
        LoadTable(tbl, dsCuDanTK);
    }
    //End TabQuanLyCuDan

    //Begin TabThongTinCanho
    public static void insertCD_BLL(String macd,JTextField tencd, JTextField ngsinh, JComboBox gioitinh, JTextField sdt, JTextField socmt, JTextField quequan) throws SQLException {
        try {
            boolean gt =false;
            gt=gioitinh.getSelectedItem().toString().equals("Nam");
            CuDan cd = new CuDan(macd, RegexExpression.toUpperCaseFirstCharacter(tencd.getText()), ngsinh.getText(), gt, sdt.getText(), socmt.getText(), quequan.getText());
            
            DAL.QuanLyCuDanDAL.insertCD_DAL(cd);
        } catch (HeadlessException | SQLException e) {
            System.out.println("Errors in insertCD_BLL: " + e.getMessage() + macd);
        }
    }
    
     
    public static ComboBoxModel cmb_BLL() throws SQLException{
        StringBuilder items=new StringBuilder();
        for(CuDan cd: dsCuDan()){
            items.append(cd.getMaCuDan());
            items.append(",");
        }
        return new DefaultComboBoxModel(items.toString().split(","));
    }
    
    
    //End TabThongTinCanho
    /*
        
    */
    public static ComboBoxModel cbbMaCuDan(){
        StringBuilder items= new StringBuilder();
            for (CuDan maCuDan : layMaCuDan()) {
                items.append(maCuDan.getMaCuDan());
                items.append(",");
            }
       return new DefaultComboBoxModel(items.toString().split(","));
    }
  
    
     
}
