/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongTinCanHoDAL;
import static DAL.ThongTinCanHoDAL.layMaCanHo;
import static DAL.ThongTinCanHoDAL.updateCH_DAL;
import Entities.CanHo;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ThongTinCanHoBLL {

    public static void Table(JTable tbl,List<CanHo> list) throws SQLException{
        List<CanHo> dsCanHo = list;
        Object[] colName = new Object[]{"Mã căn hộ", "Diện tích", "Giá", "Số phòng", "Tên khu"};
        Object[][] data = new Object[dsCanHo.size()][5];
        int i = 0;
        for (CanHo ch : dsCanHo) {
            data[i][0] = ch.getMaCanHo();
            data[i][1] = ch.getDienTich();
            data[i][2] = ch.getGia()+"$";
            data[i][3] = ch.getSoPhong();
            data[i][4] = ch.getTenKhu();
            i++;
        }

        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }
    
    public static void HienThongTinCanho(JTable tbl) throws SQLException {
        Table(tbl, ThongTinCanHoDAL.dsCanHo());
    }
    
    public static void TKThongTinCanho(JTable tbl,float tudt,float dendt,long tugia,long dengia,int sophong) throws SQLException {
        Table(tbl, ThongTinCanHoDAL.dsTTCanHo_DAL(tudt, dendt, tugia, dengia, sophong));
    }

    public static void updateCH_BLL(String mach, String macd) throws SQLException {
        try {
            updateCH_DAL(mach, macd);
        } catch (NumberFormatException e) {
            System.out.println("Errors in updateCH_BLL: " + e.getMessage());
        }
    }
    
    public static ComboBoxModel SoPhong_BLL() throws SQLException{
        Set<Integer> set=new TreeSet<>();
        for(CanHo ch: ThongTinCanHoDAL.dsCanHo()){
            set.add(ch.getSoPhong());
        }
        return new DefaultComboBoxModel(set.toArray());
    }
    
    // hiển thị căn hộ đã bán 
    
    public static void hienThiCanHoDaBan(JTable tbl) throws SQLException{
        List<CanHo> dsCanHo = DAL.ThongTinCanHoDAL.dsCanHoDaBan();
        Object[] colName = new Object[]{"Mã căn hộ", "Diện tích", "Giá", "Số phòng", "Tên khu"};
        Object[][] data = new Object[dsCanHo.size()][5];
        int i = 0;
        for (CanHo ch : dsCanHo) {
            data[i][0] = ch.getMaCanHo();
            data[i][1] = ch.getDienTich();
            data[i][2] = ch.getGia()+"$";
            data[i][3] = ch.getSoPhong();
            data[i][4] = ch.getTenKhu();
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }
    
     public static ComboBoxModel cbbMaCanHo(){
        StringBuilder items= new StringBuilder();
            for (CanHo maCanHo : layMaCanHo()) {
                items.append(maCanHo.getMaCanHo());
                items.append(",");
            }
       return new DefaultComboBoxModel(items.toString().split(","));
    }
//    public static void dsCanHo_BLL(JTable tbl) throws SQLException{
//        Set<Object> set=new TreeSet<>();
//        for(CanHo ch: ThongTinCanHoDAL.dsCanHo()){
//            set.add(ch.getMaCanHo());
//            set.add(ch.getDienTich());
//            set.add(ch.getSoPhong());
//            set.add(ch.getTenKhu());
//        }
//        
//        TableModel tableModel=new DefaultTableModel();
//    }

   
}
