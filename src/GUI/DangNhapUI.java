package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DAL.ConnectSQL;
import DAL.TaiKhoanDAL;
import Entities.TaiKhoan;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DangNhapUI extends JFrame {

	ConnectSQL cn = new ConnectSQL();

	JTextField txtTaiKhoan, txtMatKhau;
	JButton btnDangNhap, btnThoat;

	public DangNhapUI(String title) {
		super(title);
		addControl();
		addEvents();
	}

	private void addControl() {

		Container conn = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		conn.add(pnMain);
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle = new JLabel("Đăng nhập hệ thống ");
		lblTitle.setForeground(Color.BLUE);
		Font fontTitle = new Font("arial", Font.BOLD, 18);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);

		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		pnMain.add(pnDangNhap);

		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTaiKhoan = new JLabel("Tài khoản");
		txtTaiKhoan = new JTextField(20);
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		pnDangNhap.add(pnTaiKhoan);

		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau = new JLabel("Mật Khẩu");
		txtMatKhau = new JPasswordField(20);
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(txtMatKhau);
		pnDangNhap.add(pnMatKhau);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnDangNhap = new JButton("Đăng nhập");
		btnThoat = new JButton("Thoát");
		pnButton.add(btnDangNhap);
		pnButton.add(btnThoat);
		pnDangNhap.add(pnButton);
		btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
		TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.red), "Thông tin đăng nhập ");
		pnDangNhap.setBorder(border);
	}

	private void addEvents() {
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xuLyDangNhap();
				} catch (SQLException ex) {
					Logger.getLogger(DangNhapUI.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
		});
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	protected void xuLyDangNhap() throws SQLException {

		TaiKhoan tk = TaiKhoanDAL.dangNhap(txtTaiKhoan.getText(), txtMatKhau.getText());
		if (tk == null) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại ");
		} else {
			this.dispose();
			if (tk.isVaiTro() == true) {
				QuanLyGUI ql = new QuanLyGUI();
				ql.setVisible(true);

			} else {
				NhanVienGUI nv = new NhanVienGUI();
				nv.setVisible(true);

			}
		}
	}

	public void showWindow() {
		this.setSize(350, 250);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
