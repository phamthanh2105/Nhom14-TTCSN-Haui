package BLL;
import DAL.CanHoDAL;
import DAL.KhuCanHoDAL;
import Entities.*;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;

public class CanHoBLL {
    private CanHoBLL(){
        
    }

    public static TableModel show(){
        
        List<CanHo> list = CanHoDAL.show();
        String[] columnNames = {"STT","Mã Căn Hộ","Diện Tích","Giá","Trạng Thái","Số Phòng","Mã Cư Dân","Khu"};
        Object[][] data = new Object[list.size()][columnNames.length];
        int row = 0;
        for(CanHo c : list){
            data[row][0] = (row + 1);
            data[row][1] = c.getMaCanHo();
            data[row][2] = c.getDienTich();
            data[row][3] = c.getGia()+ "$";
            data[row][4] = c.isTrangThai();
            data[row][5] = c.getSoPhong();
            data[row][6] = c.getMaCuDan();
            data[row][7] = c.getTenKhu();
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0 :return String.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return Boolean.class; //tạo checkbox cho cột này
                    case 5: return String.class;
                    case 6: return String.class;
                    default: return String.class;
                }
            };
        };
        
       return table;
        
    }
    
    public static ComboBoxModel cbb_show(){
         
       StringBuilder items = new StringBuilder();
       for(CanHo c: CanHoDAL.show()){
           items.append(c.getMaCanHo());
           items.append("#");
       }
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
    
    public static Object[] showControlWithCombobox(String cbbValue){
        return CanHoDAL.showControlWithCombobox(cbbValue);
    }
    
    public static ComboBoxModel cbb_showTenKhu(){
        
        StringBuilder items = new StringBuilder();
        for(int i = 0;i<KhuCanHoDAL.show().size();i++){
            items.append(KhuCanHoDAL.show().get(i).getTenKhu());
            items.append("#");
        }
        
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
    
    public static boolean update(String maCanHo,long gia,int soPhong){
        return CanHoDAL.update(maCanHo, gia, soPhong);
    }
    
    public static TableModel search(boolean check,long tuGia,long denGia,float tuDienTich,float denDienTich){
        List<CanHo> list = CanHoDAL.search(check,tuGia,denGia,tuDienTich,denDienTich);
        String[] columnNames = {"STT","Mã Căn Hộ","Diện Tích","Giá","Trạng Thái","Số Phòng","Mã Cư Dân","Khu"};
        Object[][] data = new Object[list.size()][columnNames.length];
        int row = 0;
        for(CanHo c : list){
            data[row][0] = (row + 1);
            data[row][1] = c.getMaCanHo();
            data[row][2] = c.getDienTich();
            data[row][3] = c.getGia()+"$";
            data[row][4] = c.isTrangThai();
            data[row][5] = c.getSoPhong();
            data[row][6] = c.getMaCuDan();
            data[row][7] = c.getTenKhu();
            row++;
        }
        
        DefaultTableModel table = new DefaultTableModel(data,columnNames){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0 :return String.class;
                    case 1: return String.class;
                    case 2: return String.class;
                    case 3: return String.class;
                    case 4: return Boolean.class; //tạo checkbox cho cột này
                    case 5: return String.class;
                    case 6: return String.class;
                    default: return String.class;
                }
            };
        };
        
       return table;
    }
    
}
