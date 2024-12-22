/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.*;

public class CreateContract {

    public void CreateContract(String tenkh,String ngsinh,String socmnd,String diachi,String sodt) throws Exception {
        //tao file word
        XWPFDocument document = new XWPFDocument();

        //tao doan van ban
        //slogan
        XWPFParagraph slogan = document.createParagraph();
        XWPFRun run = slogan.createRun();
        slogan.setAlignment(ParagraphAlignment.CENTER);
        String title = "CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";
        run.setFontSize(16);
        //run.setFontFamily("Times New Roman");
        run.setBold(true);
        run.setText(title);
        run.addBreak();
        String title1 = "Độc lập - Tự Do - Hạnh phúc";
        run.setText(title1);
        run.addBreak();
        String title4 = "------------";
        run.setText(title4);
        run.addBreak();
        String title2 = "HỢP ĐỒNG MUA BÁN CHUNG CƯ";
        run.setText(title2);
        run.addBreak();
        
        XWPFRun run2=slogan.createRun();
        String title3 = "Số:......./HD";
        run2.setFontSize(14);
        run2.setText(title3);
        //Paragraph 1
        XWPFParagraph para1 = document.createParagraph();
        para1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runPara1 = para1.createRun();
        runPara1.setFontSize(14);
        String text1 = "Căn cứ";
        runPara1.setText(text1);runPara1.addBreak();
        runPara1.setBold(true);;
        runPara1.setUnderline(UnderlinePatterns.THICK);
        
        XWPFRun runPara2 = para1.createRun();
        runPara2.setFontSize(14);
        String text2 = "-  Các quy định pháp luật hiện hành.";
        String text3 = "-  Các quyết định phê duyệt dự án.";
        runPara2.setText(text2);
        runPara2.addBreak();
        runPara2.setText(text3);
        runPara2.addBreak();
        runPara2.addBreak();
        String text4 = "Hôm nay, ngày.....tháng.....năm....., tại............., hai bên chúng tôi gồm:";
        runPara2.setText(text4);
        //Para3 Bên bán
        XWPFParagraph BenBan=document.createParagraph();
        XWPFRun runBenBan=BenBan.createRun();
        runBenBan.setFontSize(16);
        runBenBan.setBold(true);
        String text5="1. BÊN BÁN NHÀ Ở CHUNG CƯ (gọi tắt là 'Bên bán'):";
        String text6="    TẬP ĐOÀN NAM CƯỜNG";
        runBenBan.setText(text5);runBenBan.addBreak();
        runBenBan.setText(text6);runBenBan.addBreak();
        
        XWPFRun runBenBan1=BenBan.createRun();
        runBenBan1.setFontSize(14);
        String truSo="     Trụ sở chính: Tầng 3, Tòa nhà C’land, 81 Lê Đức Thọ, Từ Liêm, Hà Nội";
        String sdt="     Điện thoại: 0981 682 633";
        String fax="Fax: 0981 696 969";
        String taikhoan="     Tài khoản số: 0308213567213";
        String masothue="     Mã số thuế: MSTBCL0701";
        String nguoidaidien="     Người đại diện: Hò Văn Tèn";
        String chucvu="Chức vụ: Trưởng phòng nhân sự";
        String text7="(Theo Giấy ủy quyền ngày.....tháng.....năm..... của...............................)";
        runBenBan1.setText(truSo);runBenBan1.addBreak();
        runBenBan1.setText(sdt);runBenBan1.addTab();runBenBan1.addTab();
        runBenBan1.setText(fax);runBenBan1.addBreak();
        runBenBan1.setText(taikhoan);runBenBan1.addBreak();
        runBenBan1.setText(masothue);runBenBan1.addBreak();
        runBenBan1.setText(nguoidaidien);runBenBan1.addTab();runBenBan1.addTab();
        runBenBan1.setText(chucvu);runBenBan1.addBreak();
        runBenBan1.setText(text7);
        //Para4 Bên mua
        XWPFParagraph BenMua=document.createParagraph();
        XWPFRun runBenMua=BenMua.createRun();
        runBenMua.setFontSize(16);
        runBenMua.setBold(true);
        String text8="2. BÊN MUA NHÀ Ở CHUNG CƯ(gọi tắt là 'Bên mua'):";
        String text9="    Ông/Bà: "+tenkh;
        runBenMua.setText(text8);runBenMua.addBreak();
        runBenMua.setText(text9);runBenMua.addBreak();
        
        XWPFRun runBenMua1=BenMua.createRun();
        runBenMua1.setFontSize(14);
        String ngaysinh="     Ngày sinh: "+ngsinh;
        String socmt="     Số CCND: "+socmnd;
        String diachi1="     Địa chỉ: "+diachi;
        String sdt1="     Số điện thoại: "+sodt;
        runBenMua1.setText(ngaysinh);runBenMua1.addBreak();
        runBenMua1.setText(socmt);runBenMua1.addBreak();
        runBenMua1.setText(diachi1);runBenMua1.addBreak();
        runBenMua1.setText(sdt1);
        
        //Ký tên
        XWPFTable KyTen=document.createTable();
        KyTen.setWidth("8500");
        KyTen.setTableAlignment(TableRowAlign.CENTER);
        KyTen.removeBorders();
        
        XWPFParagraph para3=document.createParagraph();
        para3.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFTableRow rowOne=KyTen.getRow(0);
        rowOne.getCell(0).setParagraph(para3);
        rowOne.getCell(0).setText("BÊN MUA");
        rowOne.addNewTableCell().setParagraph(para3);
        rowOne.getCell(1).setText("BÊN BÁN");
        
        XWPFTableRow rowTwo=KyTen.createRow();
        rowTwo.getCell(0).setParagraph(para3);
        rowTwo.getCell(0).setText("(ký ghi rõ họ tên, nếu là tổ chức mua nhà thì đóng dấu của tổ chức)");
        rowTwo.getCell(1).setParagraph(para3);
        rowTwo.getCell(1).setText("(ký ghi rõ họ tên, chức vụ và đóng dấu của doanh nghiệp)");
        
        //ghi file
        try {
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Admin\\Documents\\Hợp đồng mua chung cư Central Park.docx"));
            document.write(out);
            out.close();
            document.close();
            JOptionPane.showMessageDialog(null, "Tạo hợp đồng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
