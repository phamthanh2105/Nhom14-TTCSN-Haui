/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.KhuCanHoBLL;
import BLL.*;
import DAL.QuanLyCuDanDAL;
import DAL.QuanLyHopDongDAL;
import DAL.ThongTinCanHoDAL;
import Entities.CanHo;
import Entities.CuDan;
import Entities.HopDong;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * 
 */
public final class QuanLyGUI extends javax.swing.JFrame {

	/**
	 * Creates new form QuanLyGUI
	 */
	DefaultTableModel dtmCuDan = new DefaultTableModel();
	public static QuanLyGUI it;

	public QuanLyGUI() {

		initComponents();
		it = this; // Sử dụng biến static trỏ đến đối tượng của QuanLyGUI
		show_KhuCanHo();
		show_CanHo();
		showCuDan();
		showThongTinMuaBan();
		showCanHoDaBan();
		show_TaiKhoan();
		pnChange.setVisible(false);
	}

	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table

	public void enabledFrame() {
		this.setEnabled(true);
	}// hàm cho phép thao tác trên frame này

	public void clearAllControl_KhuCanHo() {
		txbSoTang.setText("");
		txbSoCanTT.setText("");
		txbDiaChi.setText("");
		txbTenKhu.setText("");
	}

	public void clearAllControl_CanHo() {
		txbSoPhong.setText("");
		txbGia.setText("");
		txbDienTich.setText("");
		txbMaCuDan.setText("");
		txbTenKhu_CanHo.setText("");
	}

	public void clearAllControl_TaiKhoanNV() {
		txbTenTK_NV.setText("");
		txbMK_NV.setText("");
	}

	public void clearAllControl_TaiKhoanQL() {
		txbTenTK_QL_New.setText("");
		txbMK_QL_New.setText("");
		txbMK_QL_Confirm.setText("");
	}

	public void show_KhuCanHo() {
		tbKhu.setModel(KhuCanHoBLL.show()); // load data to table
		renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
		tbKhu.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String

		cbbMaKhu.setModel(KhuCanHoBLL.cbb_show()); // load data to combobox
	}

	public void show_CanHo() {

		tbCanHo.setModel(CanHoBLL.show());
		renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
		tbCanHo.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String

		cbbMaCanHo.setModel(CanHoBLL.cbb_show());
	}

	private void show_TaiKhoan() {

		tbTaiKhoan.setModel(TaiKhoanBLL.show());
		renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
		tbTaiKhoan.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String
	}

	private void showCuDan() {
		try {
			QuanLyCuDanBLL ql = new QuanLyCuDanBLL();
			ql.HienThongTinCuDan(tblCuDan);
		} catch (SQLException ex) {
			Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void showThongTinMuaBan() {
		try {
			ThongTinMuaBanBLL thongTinMuaBan = new ThongTinMuaBanBLL();
			thongTinMuaBan.HienThongTinMuaBan(tblMuaBan);
			cbbMaCuDanMuaBan.setModel(QuanLyCuDanBLL.cbbMaCuDan());
			cbbMaCanHoMuaBan.removeAllItems();
			cbbMaCanHoMuaBan.setModel(ThongTinCanHoBLL.cbbMaCanHo());

		} catch (Exception ex) {
			Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void showCanHoDaBan() {
		try {
			ThongTinCanHoBLL thongTinCanHo = new ThongTinCanHoBLL();
			thongTinCanHo.hienThiCanHoDaBan(tblDsCanHoDaBan);
			txtTongDoanhThu.setText(String.valueOf(ThongTinMuaBanBLL.doanhThu()) + "\t$");
			txtSoCanDaBan.setText(String.valueOf(tblDsCanHoDaBan.getRowCount()));
		} catch (Exception e) {
		}

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane3 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane5 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		btDangXuat = new javax.swing.JButton();
		jLabel36 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txbTenKhu = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txbSoTang = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txbSoCanTT = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txbDiaChi = new javax.swing.JTextField();
		btThem_Khu = new javax.swing.JButton();
		btSua_Khu = new javax.swing.JButton();
		btXoa_Khu = new javax.swing.JButton();
		txbTimKiem1 = new javax.swing.JTextField();
		cbbMaKhu = new javax.swing.JComboBox<String>();
		btViewAllArea = new javax.swing.JButton();
		jLabel31 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbKhu = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbCanHo = new javax.swing.JTable();
		jPanel8 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		cbbMaCanHo = new javax.swing.JComboBox<String>();
		jLabel8 = new javax.swing.JLabel();
		txbDienTich = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txbGia = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		txbMaCuDan = new javax.swing.JTextField();
		txbTenKhu_CanHo = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		txbSoPhong = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		btSua_CanHo = new javax.swing.JButton();
		btViewAllApartment = new javax.swing.JButton();
		jPanel12 = new javax.swing.JPanel();
		btTim_CanHo = new javax.swing.JButton();
		cbTrangThai = new javax.swing.JCheckBox();
		jLabel13 = new javax.swing.JLabel();
		cbbDienTich = new javax.swing.JComboBox<String>();
		cbbGia = new javax.swing.JComboBox<String>();
		jLabel15 = new javax.swing.JLabel();
		jLabel35 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jTablePanel2 = new javax.swing.JTabbedPane();
		jPanel10 = new javax.swing.JPanel();
		btThem_NV = new javax.swing.JButton();
		btXoa_NV = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		txbTenTK_NV = new javax.swing.JTextField();
		txbMK_NV = new javax.swing.JTextField();
		btSua_NV = new javax.swing.JButton();
		jPanel11 = new javax.swing.JPanel();
		pnChangeInfo = new javax.swing.JPanel();
		jLabel33 = new javax.swing.JLabel();
		btTiepTuc = new javax.swing.JButton();
		pnChange = new javax.swing.JPanel();
		jLabel16 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		txbTenTK_QL_New = new javax.swing.JTextField();
		txbMK_QL_New = new javax.swing.JPasswordField();
		txbMK_QL_Confirm = new javax.swing.JPasswordField();
		btLuu_QL = new javax.swing.JButton();
		btThoat_QL = new javax.swing.JButton();
		jScrollPane4 = new javax.swing.JScrollPane();
		tbTaiKhoan = new javax.swing.JTable();
		jPanel5 = new javax.swing.JPanel();
		jPanel15 = new javax.swing.JPanel();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		txtMaHopDong = new javax.swing.JTextField();
		txtNgayGiaoDich = new javax.swing.JTextField();
		txtDiaChiKhachHang = new javax.swing.JTextField();
		txtTenKhachHang = new javax.swing.JTextField();
		cbbMaCanHoMuaBan = new javax.swing.JComboBox();
		jLabel38 = new javax.swing.JLabel();
		cbbMaCuDanMuaBan = new javax.swing.JComboBox();
		jLabel40 = new javax.swing.JLabel();
		txtGia = new javax.swing.JTextField();
		jPanel17 = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		tblMuaBan = new javax.swing.JTable();
		jPanel6 = new javax.swing.JPanel();
		pnThongTin = new javax.swing.JPanel();
		jLabel14 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		txtMaCuDan = new javax.swing.JTextField();
		txtTenCuDan = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		txtSoDienThoai = new javax.swing.JTextField();
		txtCMT = new javax.swing.JTextField();
		txtQueQuan = new javax.swing.JTextField();
		cbbGioiTinh = new javax.swing.JComboBox();
		jScrollPane6 = new javax.swing.JScrollPane();
		tblCuDan = new javax.swing.JTable();
		txtTimKiem = new javax.swing.JTextField();
		btnTimKiem = new javax.swing.JButton();
		btnTaiLai = new javax.swing.JButton();
		tblCanHoDaBan = new javax.swing.JPanel();
		jScrollPane8 = new javax.swing.JScrollPane();
		tblDsCanHoDaBan = new javax.swing.JTable();
		jLabel28 = new javax.swing.JLabel();
		jLabel37 = new javax.swing.JLabel();
		txtTongDoanhThu = new javax.swing.JTextField();
		jLabel39 = new javax.swing.JLabel();
		txtSoCanDaBan = new javax.swing.JTextField();

		jTable1.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane3.setViewportView(jTable1);

		jTable2.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane5.setViewportView(jTable2);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
		jLabel1.setText("Quản Lý");

		btDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		btDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("logout.png"))); // NOI18N
		btDangXuat.setToolTipText("Đăng xuất");
		btDangXuat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btDangXuatActionPerformed(evt);
			}
		});

		jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("managerIcon.png"))); // NOI18N

		jTabbedPane1.setForeground(new java.awt.Color(0, 0, 162));
		jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jPanel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(0, 0, 162));
		jLabel2.setText("Mã Khu");

		txbTenKhu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(0, 0, 162));
		jLabel3.setText("Tên Khu");

		txbSoTang.setEditable(false);
		txbSoTang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 0, 162));
		jLabel4.setText("Số Tầng");

		txbSoCanTT.setEditable(false);
		txbSoCanTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(0, 0, 162));
		jLabel5.setText("Số Căn/tầng");

		jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(0, 0, 162));
		jLabel6.setText("Địa Chỉ");

		txbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		btThem_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btThem_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("add_ql.png"))); // NOI18N
		btThem_Khu.setToolTipText("Thêm khu mới");
		btThem_Khu.setPreferredSize(new java.awt.Dimension(24, 24));
		btThem_Khu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btThem_KhuActionPerformed(evt);
			}
		});

		btSua_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btSua_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("edit_ql.png"))); // NOI18N
		btSua_Khu.setToolTipText("Sửa thông tin khu");
		btSua_Khu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSua_KhuActionPerformed(evt);
			}
		});

		btXoa_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btXoa_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("remove_ql.png"))); // NOI18N
		btXoa_Khu.setToolTipText("Xóa khu");
		btXoa_Khu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btXoa_KhuActionPerformed(evt);
			}
		});

		txbTimKiem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		txbTimKiem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txbTimKiem1ActionPerformed(evt);
			}
		});
		txbTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txbTimKiem1KeyReleased(evt);
			}
		});

		cbbMaKhu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		cbbMaKhu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbbMaKhuActionPerformed(evt);
			}
		});

		btViewAllArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btViewAllArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("viewAll_ql.png"))); // NOI18N
		btViewAllArea.setToolTipText("Xem thông tin tất cả các khu");
		btViewAllArea.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btViewAllAreaActionPerformed(evt);
			}
		});

		jLabel31.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel31.setForeground(new java.awt.Color(0, 0, 162));
		jLabel31.setText("Tìm kiếm");

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel9Layout.createSequentialGroup().addGap(55, 55, 55)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(jLabel6,
										javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(28, 28, 28).addGroup(
								jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(cbbMaKhu, javax.swing.GroupLayout.PREFERRED_SIZE,
																201, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txbTenKhu, javax.swing.GroupLayout.PREFERRED_SIZE,
																201, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(64, 64, 64)
														.addGroup(jPanel9Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel4).addComponent(jLabel5))
														.addGap(39, 39, 39)
														.addGroup(jPanel9Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(txbSoTang,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 202,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(txbSoCanTT,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addComponent(txbDiaChi)).addGap(86, 86, 86)
												.addGroup(jPanel9Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(btThem_Khu,
																javax.swing.GroupLayout.PREFERRED_SIZE, 48,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btSua_Khu, javax.swing.GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE)
														.addComponent(btXoa_Khu, javax.swing.GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE))
												.addGap(0, 176, Short.MAX_VALUE))
										.addGroup(jPanel9Layout.createSequentialGroup()
												.addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txbTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 313,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btViewAllArea, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(58, 58, 58)))));
		jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel9Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btViewAllArea)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txbTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(84, 84, 84)
						.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btThem_Khu, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(cbbMaKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4).addComponent(txbSoTang,
												javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel9Layout.createSequentialGroup().addGap(39, 39, 39)
										.addGroup(jPanel9Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txbTenKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txbSoCanTT, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel9Layout
										.createSequentialGroup().addGap(28, 28, 28).addComponent(btSua_Khu)))
						.addGap(32, 32, 32)
						.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(btXoa_Khu))
						.addGap(71, 71, 71)));

		tbKhu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		tbKhu.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "STT", "Mã Khu", "Tên Khu", "Số Tầng", "Số căn/tầng", "Địa Chỉ" }));
		tbKhu.setToolTipText("");
		tbKhu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbKhuMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tbKhu);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel9,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Khu Căn Hộ", jPanel2);

		tbCanHo.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null } },
				new String[] { "STT", "Mã Căn Hộ", "Diện Tích", "Giá", "Trạng Thái", "Số Phòng", "Mã Cư Dân", "Khu" }) {
			Class[] types = new Class[] { java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class,
					java.lang.Object.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		tbCanHo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbCanHoMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tbCanHo);

		jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel7.setForeground(new java.awt.Color(0, 0, 162));
		jLabel7.setText("Mã Căn Hộ");

		cbbMaCanHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		cbbMaCanHo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbbMaCanHoActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel8.setForeground(new java.awt.Color(0, 0, 162));
		jLabel8.setText("Diện Tích");

		txbDienTich.setEditable(false);
		txbDienTich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(0, 0, 162));
		jLabel9.setText("Giá");

		txbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(0, 0, 162));
		jLabel10.setText("Mã Cư Dân");

		txbMaCuDan.setEditable(false);
		txbMaCuDan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txbTenKhu_CanHo.setEditable(false);
		txbTenKhu_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel11.setForeground(new java.awt.Color(0, 0, 162));
		jLabel11.setText("Khu");

		txbSoPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(0, 0, 162));
		jLabel12.setText("Số Phòng");

		btSua_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btSua_CanHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("edit_ql.png"))); // NOI18N
		btSua_CanHo.setToolTipText("Sửa thông tin căn hộ");
		btSua_CanHo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSua_CanHoActionPerformed(evt);
			}
		});

		btViewAllApartment.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btViewAllApartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("viewAll_ql.png"))); // NOI18N
		btViewAllApartment.setToolTipText("Xem thông tin tất cả các căn hộ");
		btViewAllApartment.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btViewAllApartmentActionPerformed(evt);
			}
		});

		jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btTim_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btTim_CanHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("search_ql.png"))); // NOI18N
		btTim_CanHo.setToolTipText("Tìm căn hộ theo chỉ tiêu");
		btTim_CanHo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btTim_CanHoActionPerformed(evt);
			}
		});

		cbTrangThai.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

		jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel13.setForeground(new java.awt.Color(0, 0, 162));
		jLabel13.setText("Diện tích");

		cbbDienTich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		cbbDienTich.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Từ 40m² - 60m²", "Từ 60m² - 80mm²", "Trên 80m²" }));

		cbbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		cbbGia.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Dưới 150.000$", "Từ 150.000$ - 300.000$", "Trên 300.000$" })); //"Dưới 1 tỷ", "Từ 1 tỷ - 2 tỷ", "Trên 2 tỷ"

		jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel15.setForeground(new java.awt.Color(0, 0, 162));
		jLabel15.setText("Giá");

		jLabel35.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel35.setForeground(new java.awt.Color(0, 0, 162));
		jLabel35.setText("Đã bán");

		javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
		jPanel12.setLayout(jPanel12Layout);
		jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(jLabel13)
						.addGap(18, 18, 18)
						.addComponent(cbbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
						.addComponent(jLabel15).addGap(18, 18, 18)
						.addComponent(cbbGia, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(53, 53, 53).addComponent(jLabel35)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(cbTrangThai)
						.addGap(81, 81, 81).addComponent(btTim_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)));
		jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
						.addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btTim_CanHo, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cbbGia, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cbbDienTich, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel12Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jLabel13,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(25, 25, 25)));

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addGap(48, 48, 48)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12))
						.addGap(18, 18, 18)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(txbGia).addComponent(txbSoPhong)
								.addComponent(cbbMaCanHo, 0, 217, Short.MAX_VALUE))
						.addGap(62, 62, 62)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel8).addComponent(jLabel10).addComponent(jLabel11))
						.addGap(56, 56, 56)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel8Layout.createSequentialGroup()
										.addComponent(txbMaCuDan, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(70, 70, 70).addComponent(btSua_CanHo,
												javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(txbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txbTenKhu_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 155, Short.MAX_VALUE))
				.addGroup(jPanel8Layout.createSequentialGroup().addGap(50, 50, 50).addGroup(jPanel8Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel8Layout.createSequentialGroup()
								.addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btViewAllApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(65, 65, 65))
						.addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel7)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btViewAllApartment))
						.addGap(72, 72, 72)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel8Layout.createSequentialGroup().addGap(3, 3, 3)
										.addGroup(jPanel8Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel8).addComponent(txbDienTich,
														javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(
										jPanel8Layout.createSequentialGroup()
												.addGroup(jPanel8Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7).addComponent(
																cbbMaCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(28, 28, 28)
												.addGroup(jPanel8Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
																35, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txbGia, javax.swing.GroupLayout.PREFERRED_SIZE,
																33, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txbMaCuDan,
																javax.swing.GroupLayout.PREFERRED_SIZE, 31,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10).addComponent(btSua_CanHo))))
						.addGap(40, 40, 40)
						.addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txbSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel12).addComponent(jLabel11).addComponent(txbTenKhu_CanHo,
										javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(115, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
				.addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel8,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jTabbedPane1.addTab("Căn Hộ", jPanel3);

		jTablePanel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

		btThem_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btThem_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("adduser.png"))); // NOI18N
		btThem_NV.setToolTipText("Thêm tài khoản mới");
		btThem_NV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btThem_NVActionPerformed(evt);
			}
		});

		btXoa_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btXoa_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("removeuser.png"))); // NOI18N
		btXoa_NV.setToolTipText("Xóa");
		btXoa_NV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btXoa_NVActionPerformed(evt);
			}
		});

		jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel19.setForeground(new java.awt.Color(0, 0, 162));
		jLabel19.setText("Tên Tài Khoản");

		jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel20.setForeground(new java.awt.Color(0, 0, 162));
		jLabel20.setText("Mật Khẩu");

		txbTenTK_NV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txbMK_NV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		btSua_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btSua_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("edituser.png"))); // NOI18N
		btSua_NV.setToolTipText("Sửa mật khẩu");
		btSua_NV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSua_NVActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel10Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(btThem_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(26, 26, 26)
										.addComponent(btSua_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20))
								.addGroup(jPanel10Layout.createSequentialGroup().addContainerGap(255, Short.MAX_VALUE)
										.addGroup(jPanel10Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txbMK_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 221,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txbTenTK_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 221,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(154, 154, 154))
				.addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel10Layout.createSequentialGroup().addGap(93, 93, 93)
								.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel19).addComponent(jLabel20)))
						.addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(btXoa_NV,
								javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel10Layout.createSequentialGroup().addGap(43, 43, 43).addComponent(btXoa_NV)
						.addGap(108, 108, 108)
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txbTenTK_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel19))
						.addGap(30, 30, 30)
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txbMK_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel20))
						.addGap(40, 40, 40)
						.addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btSua_NV).addComponent(btThem_NV))
						.addContainerGap(247, Short.MAX_VALUE)));

		jTablePanel2.addTab("Nhân Viên", jPanel10);

		jLabel33.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
		jLabel33.setForeground(new java.awt.Color(255, 51, 51));
		jLabel33.setText("Thay đổi thông tin tài khoản");

		btTiepTuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("continue_ql.png"))); // NOI18N
		btTiepTuc.setToolTipText("Tiếp tục");
		btTiepTuc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btTiepTucActionPerformed(evt);
			}
		});

		jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel16.setForeground(new java.awt.Color(0, 0, 162));
		jLabel16.setText("Xác nhận mật khẩu mới");

		jLabel32.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel32.setForeground(new java.awt.Color(0, 0, 162));
		jLabel32.setText("Mật khẩu mới");

		jLabel34.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
		jLabel34.setForeground(new java.awt.Color(0, 0, 162));
		jLabel34.setText("Tên tài khoản mới");

		txbTenTK_QL_New.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txbMK_QL_New.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		txbMK_QL_Confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

		btLuu_QL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btLuu_QL.setIcon(new javax.swing.ImageIcon(getClass().getResource("save_ql.png"))); // NOI18N
		btLuu_QL.setToolTipText("Lưu");
		btLuu_QL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btLuu_QLActionPerformed(evt);
			}
		});

		btThoat_QL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		btThoat_QL.setIcon(new javax.swing.ImageIcon(getClass().getResource("cancel_ql.png"))); // NOI18N
		btThoat_QL.setToolTipText("Hủy");
		btThoat_QL.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btThoat_QLActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnChangeLayout = new javax.swing.GroupLayout(pnChange);
		pnChange.setLayout(pnChangeLayout);
		pnChangeLayout.setHorizontalGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeLayout.createSequentialGroup()
						.addGap(0, 6, Short.MAX_VALUE)
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel32).addComponent(jLabel16).addComponent(jLabel34))
						.addGap(61, 61, 61)
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(txbTenTK_QL_New)
								.addComponent(txbMK_QL_New, javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txbMK_QL_Confirm, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 207,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pnChangeLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btLuu_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(27, 27, 27).addComponent(btThoat_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(33, 33, 33)));
		pnChangeLayout.setVerticalGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChangeLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txbTenTK_QL_New, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(33, 33, 33)
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel32).addComponent(txbMK_QL_New,
										javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(40, 40, 40)
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel16).addComponent(txbMK_QL_Confirm,
										javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btLuu_QL).addComponent(btThoat_QL))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnChangeInfoLayout = new javax.swing.GroupLayout(pnChangeInfo);
		pnChangeInfo.setLayout(pnChangeInfoLayout);
		pnChangeInfoLayout.setHorizontalGroup(pnChangeInfoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChangeInfoLayout.createSequentialGroup().addGap(326, 326, 326)
						.addComponent(btTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeInfoLayout.createSequentialGroup()
						.addContainerGap(118, Short.MAX_VALUE)
						.addGroup(pnChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnChangeInfoLayout.createSequentialGroup()
												.addComponent(pnChange, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(88, 88, 88))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnChangeInfoLayout.createSequentialGroup()
												.addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(178, 178, 178)))));
		pnChangeInfoLayout
				.setVerticalGroup(
						pnChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnChangeInfoLayout.createSequentialGroup().addGap(75, 75, 75)
										.addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(30, 30, 30).addComponent(btTiepTuc).addGap(39, 39, 39)
										.addComponent(pnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 245,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(145, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
		jPanel11.setLayout(jPanel11Layout);
		jPanel11Layout.setHorizontalGroup(
				jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnChangeInfo,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel11Layout.setVerticalGroup(
				jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnChangeInfo,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTablePanel2.addTab("Quản Lý", jPanel11);

		tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null } },
				new String[] { "Tên Tài Khoản", "Mật Khẩu" }));
		tbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbTaiKhoanMouseClicked(evt);
			}
		});
		jScrollPane4.setViewportView(tbTaiKhoan);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
						.addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTablePanel2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane4).addComponent(jTablePanel2));

		jTabbedPane1.addTab("Tài Khoản", jPanel4);

		jLabel25.setText("Mã hợp đồng");

		jLabel26.setText("Ngày giao dịch");

		jLabel27.setText("Địa chỉ khách hàng");

		jLabel29.setText("Mã căn hộ");

		jLabel30.setText("Tên khách hàng");

		cbbMaCanHoMuaBan.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbbMaCanHoMuaBan.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cbbMaCanHoMuaBanItemStateChanged(evt);
			}
		});
		cbbMaCanHoMuaBan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cbbMaCanHoMuaBanMouseClicked(evt);
			}
		});

		jLabel38.setText("Mã cư dân");

		cbbMaCuDanMuaBan.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel40.setText("Giá");

		txtGia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtGiaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
		jPanel15.setLayout(jPanel15Layout);
		jPanel15Layout
				.setHorizontalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel15Layout.createSequentialGroup().addComponent(jLabel25)
												.addGap(46, 46, 46)
												.addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 171,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel15Layout.createSequentialGroup().addGroup(jPanel15Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(30, 30, 30)
														.addGroup(jPanel15Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jPanel15Layout.createSequentialGroup()
																		.addComponent(cbbMaCanHoMuaBan,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				80,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(0, 0, Short.MAX_VALUE))
																.addComponent(txtTenKhachHang))))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel15Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(
														jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(
														jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel15Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel15Layout.createSequentialGroup().addGap(18, 18, 18)
														.addGroup(jPanel15Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(txtDiaChiKhachHang,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 173,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(txtGia,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 173,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(cbbMaCuDanMuaBan,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 80,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(jPanel15Layout.createSequentialGroup().addGap(18, 18, 18)
														.addComponent(txtNgayGiaoDich,
																javax.swing.GroupLayout.PREFERRED_SIZE, 173,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(115, 115, 115)));
		jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel15Layout.createSequentialGroup().addGroup(jPanel15Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel15Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel15Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel25)
								.addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(29, 29, 29)
								.addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel30))
								.addGap(30, 30, 30)
								.addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel29).addComponent(cbbMaCanHoMuaBan,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel38)
								.addComponent(cbbMaCuDanMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel27).addComponent(txtDiaChiKhachHang,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel40).addComponent(txtGia,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel26).addComponent(txtNgayGiaoDich,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tblMuaBan.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		tblMuaBan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblMuaBanMouseClicked(evt);
			}
		});
		jScrollPane7.setViewportView(tblMuaBan);

		javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
		jPanel17.setLayout(jPanel17Layout);
		jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel17Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
						.addContainerGap()));
		jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel17Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 472,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel5Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel17,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 340,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Thông Tin Mua Bán", jPanel5);

		jLabel14.setText("Mã cư dân");
		jLabel14.setToolTipText("");

		jLabel17.setText("Tên cư dân");

		jLabel18.setText("Ngày sinh");

		jLabel21.setText("Giới tính");

		jLabel22.setText("Số điện thoại");

		jLabel23.setText("Số căn cước công dân");

		jLabel24.setText("Quê quán");

		cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

		tblCuDan.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		tblCuDan.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblCuDanMouseClicked(evt);
			}
		});
		jScrollPane6.setViewportView(tblCuDan);

		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTimKiemActionPerformed(evt);
			}
		});

		btnTaiLai.setText("Tải lại");
		btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTaiLaiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout
				.setHorizontalGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
						.addGroup(pnThongTinLayout.createSequentialGroup().addGap(55, 55, 55).addGroup(
								pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(31, 31, 31)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(pnThongTinLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtTenCuDan, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														txtMaCuDan, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 171,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(pnThongTinLayout.createSequentialGroup().addGroup(pnThongTinLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(pnThongTinLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(txtCMT, javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtQueQuan).addComponent(txtSoDienThoai,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 171,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(pnThongTinLayout.createSequentialGroup()
												.addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 185,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(pnThongTinLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(btnTaiLai, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))))
								.addGap(54, 54, 54)));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup().addContainerGap().addGroup(pnThongTinLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnThongTinLayout.createSequentialGroup().addGroup(pnThongTinLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14)
								.addComponent(txtMaCuDan, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel17).addComponent(txtTenCuDan,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel18).addComponent(txtNgaySinh,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel21).addComponent(cbbGioiTinh,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(pnThongTinLayout.createSequentialGroup().addGroup(pnThongTinLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel22)
								.addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel23).addComponent(txtCMT,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel24).addComponent(txtQueQuan,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(44, 44, 44)
								.addGroup(pnThongTinLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTimKiem))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(btnTaiLai)
						.addGap(13, 13, 13)
						.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 434,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(
				jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnThongTin,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup().addComponent(pnThongTin,
						javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(94, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Thông Tin Cư Dân", jPanel6);

		tblDsCanHoDaBan.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		jScrollPane8.setViewportView(tblDsCanHoDaBan);

		jLabel28.setText("Danh sách căn hộ đã bán");

		jLabel37.setText("Tổng doanh thu ");

		txtTongDoanhThu.setEditable(false);
		txtTongDoanhThu.setForeground(new java.awt.Color(255, 0, 102));
		txtTongDoanhThu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		jLabel39.setText("Tổng căn hộ đã bán");

		txtSoCanDaBan.setEditable(false);
		txtSoCanDaBan.setForeground(new java.awt.Color(255, 0, 102));
		txtSoCanDaBan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtSoCanDaBan.setAutoscrolls(false);
		txtSoCanDaBan.setFocusable(false);

		javax.swing.GroupLayout tblCanHoDaBanLayout = new javax.swing.GroupLayout(tblCanHoDaBan);
		tblCanHoDaBan.setLayout(tblCanHoDaBanLayout);
		tblCanHoDaBanLayout.setHorizontalGroup(tblCanHoDaBanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane8)
				.addGroup(tblCanHoDaBanLayout.createSequentialGroup()
						.addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(tblCanHoDaBanLayout.createSequentialGroup().addGap(349, 349, 349)
										.addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 336,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 342, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblCanHoDaBanLayout
										.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(tblCanHoDaBanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 161,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel39))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(tblCanHoDaBanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(txtTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE,
														347, Short.MAX_VALUE)
												.addComponent(txtSoCanDaBan))))
						.addContainerGap()));
		tblCanHoDaBanLayout.setVerticalGroup(tblCanHoDaBanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(tblCanHoDaBanLayout.createSequentialGroup().addGap(27, 27, 27)
						.addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 262,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(tblCanHoDaBanLayout.createSequentialGroup().addGap(54, 54, 54)
										.addComponent(jLabel39))
								.addGroup(tblCanHoDaBanLayout.createSequentialGroup().addGap(48, 48, 48).addComponent(
										txtSoCanDaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(156, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Thống Kê Doanh Thu", tblCanHoDaBan);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel36).addGap(370, 370, 370)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(42, 42, 42))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addComponent(jTabbedPane1).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
												Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(
														jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTabbedPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(24, 24, 24)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void btDangXuatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btDangXuatActionPerformed
		this.dispose();
		DangNhapUI dn = new DangNhapUI("Quản lý chung cư");
		dn.showWindow();
	}// GEN-LAST:event_btDangXuatActionPerformed

	private void btThem_KhuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btThem_KhuActionPerformed
		this.setEnabled(false);
		ThemKhu_PhongGUI fr = new ThemKhu_PhongGUI(this, true);
		fr.setVisible(true);
	}// GEN-LAST:event_btThem_KhuActionPerformed

	private void tbKhuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbKhuMouseClicked

		cbbMaKhu.setSelectedItem(tbKhu.getValueAt(tbKhu.getSelectedRow(), 1).toString()); // Dữ liệu trong combobox phải
																							// có trước
		txbTenKhu.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 2).toString());
		txbSoTang.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 3).toString());
		txbSoCanTT.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 4).toString());
		txbDiaChi.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 5).toString());

	}// GEN-LAST:event_tbKhuMouseClicked

	private void btSua_KhuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSua_KhuActionPerformed

		if (txbTenKhu.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên khu không được bỏ trống!");
		} else if (txbDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống!");
		} else {
			if (KhuCanHoBLL.update(cbbMaKhu.getSelectedItem().toString(),
					RegexExpression.toUpperCaseFirstCharacter(txbTenKhu.getText()),
					RegexExpression.toUpperCaseFirstCharacter(txbDiaChi.getText()))) {
				show_KhuCanHo();
				show_CanHo();
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Không sửa được!");
			}
		}

	}// GEN-LAST:event_btSua_KhuActionPerformed

	private void btXoa_KhuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btXoa_KhuActionPerformed
		if (KhuCanHoBLL.checkEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa có khu căn hộ nào!", "Notification",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			Object[] items = { "Xác nhận", "Hủy" };
			int rs = JOptionPane.showOptionDialog(null, "Xóa khu và tất cả thông tin liên quan!", "Xóa khu căn hộ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, items, items[0]);
			if (rs == JOptionPane.YES_OPTION) {
				this.setEnabled(false);
				XacNhanTTTKGUI xn = new XacNhanTTTKGUI(this, true);
				xn.setVisible(true);
				if (xn.checkAccountManager() && xn.checkEvent) {
					if (KhuCanHoBLL.delete(cbbMaKhu.getSelectedItem().toString())) {
						show_KhuCanHo();
						show_CanHo();
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
						clearAllControl_KhuCanHo();
						clearAllControl_CanHo();
					} else {
						JOptionPane.showMessageDialog(null, "Không xóa được!");
					}
				}
			}
		}

	}// GEN-LAST:event_btXoa_KhuActionPerformed

	private void tbCanHoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbCanHoMouseClicked

		cbbMaCanHo.setSelectedItem(tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 1));
		txbDienTich.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 2).toString()));
		txbGia.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 3).toString()));
		txbSoPhong.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 5).toString()));
		if ((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 6)) == null) {
			txbMaCuDan.setText("<Empty>");
		} else {
			txbMaCuDan.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 6).toString()));
		}
		txbTenKhu_CanHo.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 7).toString()));

	}// GEN-LAST:event_tbCanHoMouseClicked

	private void btSua_CanHoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSua_CanHoActionPerformed

		try {

			if (txbGia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Giá không được bỏ trống!");
			} else if (Long.parseLong(txbGia.getText()) < 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng giá là số dương!");
			} else if (txbSoPhong.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Số phòng không được bỏ trống");
			} else if (Integer.parseInt(txbSoPhong.getText()) < 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng số phòng là số dương!");
			} else {
				boolean check = CanHoBLL.update(cbbMaCanHo.getSelectedItem().toString(),
						Long.parseLong(txbGia.getText()), Integer.parseInt(txbSoPhong.getText()));

				if (check) {
					show_CanHo();
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Không sửa được!");
				}
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số");
		}

	}// GEN-LAST:event_btSua_CanHoActionPerformed

	private void txbTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txbTimKiem1ActionPerformed
		// JOptionPane.showMessageDialog(rootPane,"Changed!");//khi nhấn enter
		try {
			tbKhu.setModel(KhuCanHoBLL.search(txbTimKiem1.getText()));
		} catch (SQLException ex) {
			Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_txbTimKiem1ActionPerformed

	private void btTim_CanHoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btTim_CanHoActionPerformed
		try {
			float tuDienTich = 0;
			float denDienTich = 0;
			long tuGia = 0;
			long denGia = 0;
			switch (cbbDienTich.getSelectedIndex()) {
			case 0:
				tuDienTich = 40;
				denDienTich = 60;
				break;
			case 1:
				tuDienTich = 60;
				denDienTich = 80;
				break;
			default:
				tuDienTich = 80;
			}

			switch (cbbGia.getSelectedIndex()) {
			case 0:
				denGia = 150000;
				break;
			case 1:
				tuGia = 150000;
				denGia = 300000;
				break;
			default:
				tuGia = 300000;
			}

			tbCanHo.setModel(CanHoBLL.search(cbTrangThai.isSelected(), tuGia, denGia, tuDienTich, denDienTich));
		} catch (NullPointerException ex) {
			// do nothing
		}

	}// GEN-LAST:event_btTim_CanHoActionPerformed

	private void tbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbTaiKhoanMouseClicked

		txbTenTK_NV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 0)).toString());
		txbMK_NV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 1)).toString());

	}// GEN-LAST:event_tbTaiKhoanMouseClicked

	private void btViewAllApartmentActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btViewAllApartmentActionPerformed
		show_CanHo();
	}// GEN-LAST:event_btViewAllApartmentActionPerformed

	private void btViewAllAreaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btViewAllAreaActionPerformed
		show_KhuCanHo();
	}// GEN-LAST:event_btViewAllAreaActionPerformed

	private void btLuu_QLActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btLuu_QLActionPerformed

		String newPassWord = new String(txbMK_QL_New.getPassword()); // get String from passWord
		String confirmPassWord = new String(txbMK_QL_Confirm.getPassword());

		if (!RegexExpression.checkUserName(txbTenTK_QL_New.getText())) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản không hợp lệ!");
		} else if (!RegexExpression.checkPassWord(newPassWord)) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!");
		} else if (!newPassWord.equals(confirmPassWord)) {
			JOptionPane.showMessageDialog(null, "Vui lòng xác nhận lại mật khẩu!");
		} else {
			if (TaiKhoanBLL.update(txbTenTK_QL_New.getText(), confirmPassWord, true)) {
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
				clearAllControl_TaiKhoanQL();

			} else {
				JOptionPane.showMessageDialog(null, "Không sửa được!");
			}
			pnChange.setVisible(false);
			btTiepTuc.setVisible(true);
		}

	}// GEN-LAST:event_btLuu_QLActionPerformed

	private void btSua_NVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSua_NVActionPerformed
		if (!RegexExpression.checkPassWord(txbMK_NV.getText())) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!");
		} else {
			if (TaiKhoanBLL.update(txbTenTK_NV.getText(), txbMK_NV.getText())) {
				show_TaiKhoan();
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
			} else {
				JOptionPane.showMessageDialog(null, "Không sửa được!");
			}
		}
	}// GEN-LAST:event_btSua_NVActionPerformed

	private void btXoa_NVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btXoa_NVActionPerformed
		if (TaiKhoanBLL.checkEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa có tài khoản nào!", "Notification",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (txbTenTK_NV.getText().length() > 25 && txbTenTK_NV.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Chọn dòng trước khi xóa!");
			} else {
				if (TaiKhoanBLL.delete(txbTenTK_NV.getText())) {
					show_TaiKhoan();
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
					clearAllControl_TaiKhoanNV();
				} else {
					JOptionPane.showMessageDialog(null, "Không xóa được!");
				}
			}
		}
	}// GEN-LAST:event_btXoa_NVActionPerformed

	private void btThem_NVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btThem_NVActionPerformed

		try {
			if (!RegexExpression.checkUserName(txbTenTK_NV.getText())) {
				JOptionPane.showMessageDialog(null, "Tên tài khoản không hợp lệ!");
			} else if (!RegexExpression.checkPassWord(txbMK_NV.getText())) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!");
			} else {
				if (TaiKhoanBLL.insert(txbTenTK_NV.getText(), txbMK_NV.getText())) {
					show_TaiKhoan();
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
					clearAllControl_TaiKhoanNV();
				} else {
					JOptionPane.showMessageDialog(null, "Không thêm được!");
				}
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Vui lòng không nhập mã trùng!");
		}

	}// GEN-LAST:event_btThem_NVActionPerformed

	private void cbbMaKhuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbbMaKhuActionPerformed

		try {
			Object[] obj = KhuCanHoBLL.showControlWithCombobox(cbbMaKhu.getSelectedItem().toString());
			txbDiaChi.setText(obj[0].toString());
			txbSoCanTT.setText(obj[1].toString());
			txbSoTang.setText(obj[2].toString());
			txbTenKhu.setText(obj[3].toString());
		} catch (NullPointerException e) {
			// do nothing :3
		}

	}// GEN-LAST:event_cbbMaKhuActionPerformed

	private void cbbMaCanHoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbbMaCanHoActionPerformed

		try {
			Object[] o = CanHoBLL.showControlWithCombobox(cbbMaCanHo.getSelectedItem().toString());
			txbDienTich.setText(o[0].toString());
			txbGia.setText(o[1].toString());
			txbMaCuDan.setText(o[2].toString());
			txbSoPhong.setText(o[3].toString());
			txbTenKhu_CanHo.setText(o[4].toString());
		} catch (NullPointerException ex) {
			// do noting
		}

	}// GEN-LAST:event_cbbMaCanHoActionPerformed

	private void txbTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txbTimKiem1KeyReleased
		try {
			tbKhu.setModel(KhuCanHoBLL.search(txbTimKiem1.getText()));
		} catch (SQLException ex) {
			Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_txbTimKiem1KeyReleased

	private void btTiepTucActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btTiepTucActionPerformed
		XacNhanTTTKGUI xn = new XacNhanTTTKGUI(this, true);
		xn.setVisible(true);
		if (xn.checkAccountManager() && xn.checkEvent) { // neu dung
			pnChange.setVisible(true);
			btTiepTuc.setVisible(false);
		}
	}// GEN-LAST:event_btTiepTucActionPerformed

	private void btThoat_QLActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btThoat_QLActionPerformed
		pnChange.setVisible(false);
		btTiepTuc.setVisible(true);
	}// GEN-LAST:event_btThoat_QLActionPerformed

	private void tblCuDanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblCuDanMouseClicked
		txtMaCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 0).toString());
		txtTenCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 1).toString());
		txtNgaySinh.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 2).toString());
		cbbGioiTinh.setSelectedItem(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 3).toString());
		txtSoDienThoai.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 4).toString());
		txtCMT.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 5).toString());
		txtQueQuan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 6).toString());
	}// GEN-LAST:event_tblCuDanMouseClicked

	private void tblMuaBanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblMuaBanMouseClicked
		txtMaHopDong.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 0) + "");
		txtTenKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 1) + "");
		cbbMaCanHoMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 2) + "");
		cbbMaCuDanMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 3) + "");
		txtDiaChiKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 4) + "");
		txtGia.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 5) + "\t$");
		txtNgayGiaoDich.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 6) + "");
	}// GEN-LAST:event_tblMuaBanMouseClicked

	private void cbbMaCanHoMuaBanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cbbMaCanHoMuaBanMouseClicked

	}// GEN-LAST:event_cbbMaCanHoMuaBanMouseClicked

	private void cbbMaCanHoMuaBanItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cbbMaCanHoMuaBanItemStateChanged

	}// GEN-LAST:event_cbbMaCanHoMuaBanItemStateChanged

	private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtGiaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtGiaActionPerformed

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimKiemActionPerformed
		ArrayList<CuDan> dsCuDan; // xử lý tìm kiếm
		QuanLyCuDanDAL tkCuDan = new QuanLyCuDanDAL();
		dsCuDan = tkCuDan.xuLyTimKiem(txtTimKiem.getText());
		if (dsCuDan.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không tồn tại cư dân [" + txtTimKiem.getText() + "]");
		} else {
			Object[] colName = new Object[] { "Mã cư dân", "Tên cư dân", "Ngày sinh", "Giới tính", "SĐT", "Số CCCD",
					"Quê quán" };
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
			tblCuDan.setModel(tableModel);
		}

	}// GEN-LAST:event_btnTimKiemActionPerformed

	private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTaiLaiActionPerformed
		showCuDan();
	}// GEN-LAST:event_btnTaiLaiActionPerformed

	protected void xuLyLuuCuDan() {
		CuDan cuDan = new CuDan();
		cuDan.setMaCuDan(txtMaCuDan.getText());
		cuDan.setTenCuDan(txtTenCuDan.getText());
		cuDan.setNgaySinh(txtNgaySinh.getText());
		boolean gt = false;
		gt = cbbGioiTinh.getSelectedItem().toString().equals("Nam");
		cuDan.setGioiTinh(gt);
		cuDan.setSoDT(txtSoDienThoai.getText());
		cuDan.setSoCMT(txtCMT.getText());
		cuDan.setQueQuan(txtQueQuan.getText());
		QuanLyCuDanDAL qlCuDan = new QuanLyCuDanDAL();
		qlCuDan.themCuDan(cuDan);

	}

	protected void xuLyUpdateCuDan() {
		CuDan cuDan = new CuDan();
		cuDan.setMaCuDan(txtMaCuDan.getText());
		cuDan.setTenCuDan(txtTenCuDan.getText());
		cuDan.setNgaySinh(txtNgaySinh.getText());
		boolean gt = false;
		gt = cbbGioiTinh.getSelectedItem().toString().equals("Nam");
		cuDan.setGioiTinh(gt);
		cuDan.setSoDT(txtSoDienThoai.getText());
		cuDan.setSoCMT(txtCMT.getText());
		cuDan.setQueQuan(txtQueQuan.getText());
		QuanLyCuDanDAL qlCuDan = new QuanLyCuDanDAL();
		qlCuDan.updateCuDan(cuDan);
	}

	protected void xuLyUpdateHopDong() {
		HopDong hopDong = new HopDong();
		hopDong.setMaHopDong(txtMaHopDong.getText());
		hopDong.setNgayGiaoDich(txtNgayGiaoDich.getText());
		hopDong.setDiaChiKhachHang(txtDiaChiKhachHang.getText());
		hopDong.setMaCuDan(cbbMaCuDanMuaBan.getSelectedItem() + "");
		hopDong.setMaCanHo(cbbMaCanHoMuaBan.getSelectedItem() + "");
		hopDong.setTenKH(txtTenKhachHang.getText());
		QuanLyHopDongDAL qlHopDong = new QuanLyHopDongDAL();
		qlHopDong.updateHopDong(hopDong);

	}

	protected void xuLyLuuHopDong() {
		HopDong hopDong = new HopDong();
		hopDong.setMaHopDong(txtMaHopDong.getText());
		hopDong.setNgayGiaoDich(txtNgayGiaoDich.getText());
		hopDong.setDiaChiKhachHang(txtDiaChiKhachHang.getText());
		hopDong.setMaCuDan(cbbMaCuDanMuaBan.getSelectedItem() + "");
		hopDong.setMaCanHo(cbbMaCanHoMuaBan.getSelectedItem() + "");
		hopDong.setTenKH(txtTenKhachHang.getText());
		QuanLyHopDongDAL qlHopDong = new QuanLyHopDongDAL();
		qlHopDong.themHopDong(hopDong);
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		// </editor-fold>

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btDangXuat;
	private javax.swing.JButton btLuu_QL;
	private javax.swing.JButton btSua_CanHo;
	private javax.swing.JButton btSua_Khu;
	private javax.swing.JButton btSua_NV;
	private javax.swing.JButton btThem_Khu;
	private javax.swing.JButton btThem_NV;
	private javax.swing.JButton btThoat_QL;
	private javax.swing.JButton btTiepTuc;
	private javax.swing.JButton btTim_CanHo;
	private javax.swing.JButton btViewAllApartment;
	private javax.swing.JButton btViewAllArea;
	private javax.swing.JButton btXoa_Khu;
	private javax.swing.JButton btXoa_NV;
	private javax.swing.JButton btnTaiLai;
	private javax.swing.JButton btnTimKiem;
	private javax.swing.JCheckBox cbTrangThai;
	private javax.swing.JComboBox<String> cbbDienTich;
	private javax.swing.JComboBox<String> cbbGia;
	private javax.swing.JComboBox cbbGioiTinh;
	private javax.swing.JComboBox<String> cbbMaCanHo;
	private javax.swing.JComboBox cbbMaCanHoMuaBan;
	private javax.swing.JComboBox cbbMaCuDanMuaBan;
	private javax.swing.JComboBox<String> cbbMaKhu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel37;
	private javax.swing.JLabel jLabel38;
	private javax.swing.JLabel jLabel39;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel40;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel17;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTabbedPane jTablePanel2;
	private javax.swing.JPanel pnChange;
	private javax.swing.JPanel pnChangeInfo;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JTable tbCanHo;
	private javax.swing.JTable tbKhu;
	private javax.swing.JTable tbTaiKhoan;
	private javax.swing.JPanel tblCanHoDaBan;
	private javax.swing.JTable tblCuDan;
	private javax.swing.JTable tblDsCanHoDaBan;
	private javax.swing.JTable tblMuaBan;
	private javax.swing.JTextField txbDiaChi;
	private javax.swing.JTextField txbDienTich;
	private javax.swing.JTextField txbGia;
	private javax.swing.JTextField txbMK_NV;
	private javax.swing.JPasswordField txbMK_QL_Confirm;
	private javax.swing.JPasswordField txbMK_QL_New;
	private javax.swing.JTextField txbMaCuDan;
	private javax.swing.JTextField txbSoCanTT;
	private javax.swing.JTextField txbSoPhong;
	private javax.swing.JTextField txbSoTang;
	private javax.swing.JTextField txbTenKhu;
	private javax.swing.JTextField txbTenKhu_CanHo;
	private javax.swing.JTextField txbTenTK_NV;
	private javax.swing.JTextField txbTenTK_QL_New;
	private javax.swing.JTextField txbTimKiem1;
	private javax.swing.JTextField txtCMT;
	private javax.swing.JTextField txtDiaChiKhachHang;
	private javax.swing.JTextField txtGia;
	private javax.swing.JTextField txtMaCuDan;
	private javax.swing.JTextField txtMaHopDong;
	private javax.swing.JTextField txtNgayGiaoDich;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtQueQuan;
	private javax.swing.JTextField txtSoCanDaBan;
	private javax.swing.JTextField txtSoDienThoai;
	private javax.swing.JTextField txtTenCuDan;
	private javax.swing.JTextField txtTenKhachHang;
	private javax.swing.JTextField txtTimKiem;
	private javax.swing.JTextField txtTongDoanhThu;
	// End of variables declaration//GEN-END:variables

}
