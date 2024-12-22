/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ThongTinMuaBanDAL;
import Entities.CanHo;
import Entities.HopDong;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * 
 */
public class ThongTinMuaBanBLL {

    public static void LoadTable(JTable tbl, List list){
        List<HopDong> dsHopDong = list;
        Object[] colName = new Object[]{"Mã hợp đồng", "Tên khách hàng", "Mã căn hộ", "Mã cư dân", "Địa chỉ KH", "Giá", "Ngày giao dịch"};
        Object[][] data = new Object[dsHopDong.size()][7];
        int i = 0;
        for (HopDong hd : dsHopDong) {
            data[i][0] = hd.getMaHopDong();
            data[i][1] = hd.getTenKH();
            data[i][2] = hd.getMaCanHo();
            data[i][3] = hd.getMaCuDan();
            data[i][4] = hd.getDiaChiKhachHang();
            data[i][5] = hd.getGia()+"$";
            data[i][6] = hd.getNgayGiaoDich();
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }
    
    public static void HienThongTinMuaBan(JTable tbl) throws Exception {
        List<HopDong> dsHopDong = DAL.ThongTinMuaBanDAL.dsHopDong();
        LoadTable(tbl, dsHopDong);
    }
    
    public static void insertHD_BLL(String mahd,String ngaygd,String diachikh,String macd,String mach,String tenkh){
        ThongTinMuaBanDAL.insertHD_DAL(mahd,ngaygd,diachikh,macd,mach);
    }
    
    public static void UpdateHD_BLL(String diachikh,String macd,String tenkh){
        ThongTinMuaBanDAL.UpdateHD_DAL(diachikh, macd, tenkh);
    }
    
    public static  void TimKiem_BLL(JTable tbl,String info) throws SQLException{
        List<HopDong> dsHopDongTK= ThongTinMuaBanDAL.TimKiem_DAL(info);
        LoadTable(tbl, dsHopDongTK);
    }
    
    public static long doanhThu(){
         long doanhThu=0;
        try {
            List<CanHo> dsCanHo=DAL.ThongTinCanHoDAL.dsCanHoDaBan();
           
            long gia=0;
            for (CanHo dsCh : dsCanHo) {
                gia= dsCh.getGia();
                doanhThu +=gia;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinMuaBanBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doanhThu;
    }
}
