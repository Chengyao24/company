package Controller.smaple;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField nameUpdate;
	private JTextField addressUpdate;
	private JTextField updateId;
	private JTextField deleteId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 102));
		panel.setForeground(new Color(64, 128, 128));
		panel.setBounds(42, 22, 231, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setBounds(40, 137, 45, 42);
		panel.add(lblNewLabel_3);
		
		address = new JTextField();
		address.setBounds(80, 148, 96, 21);
		panel.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("行動:");
		lblNewLabel_4.setBounds(39, 196, 59, 30);
		panel.add(lblNewLabel_4);
		
		mobile = new JTextField();
		mobile.setBounds(80, 201, 96, 21);
		panel.add(mobile);
		mobile.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("電話:");
		lblNewLabel_5.setBounds(39, 250, 30, 44);
		panel.add(lblNewLabel_5);
		
		phone = new JTextField();
		phone.setBounds(80, 262, 96, 21);
		panel.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				
				member m=new member(Name,Username,Password,Address,Mobile,Phone);
				
				new implMember().add(m);
				
				
			}
		});
		btnNewButton.setBounds(54, 307, 87, 38);
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 153, 102));
		panel_2.setBounds(34, 16, 166, 30);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel name1 = new JLabel("名:");
		name1.setBounds(10, 10, 15, 15);
		panel_2.add(name1);
		
		name = new JTextField();
		name.setBounds(35, 7, 96, 21);
		panel_2.add(name);
		name.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 153, 102));
		panel_4.setBounds(34, 61, 166, 28);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳:\r\n");
		lblNewLabel_1.setBounds(10, 10, 15, 15);
		panel_4.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(35, 7, 96, 21);
		panel_4.add(username);
		username.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(102, 153, 102));
		panel_5.setBounds(40, 99, 154, 34);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("密:");
		lblNewLabel_2.setBounds(10, 10, 32, 15);
		panel_5.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setBounds(31, 7, 96, 21);
		panel_5.add(password);
		password.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(64, 128, 128));
		panel_1.setBackground(new Color(102, 153, 102));
		panel_1.setBounds(328, 22, 521, 383);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel total = new JLabel("");
		total.setBounds(30, 347, 46, 26);
		panel_1.add(total);
		
		JTextArea show = new JTextArea();
		show.setBounds(20, 179, 421, 166);
		panel_1.add(show);
		
		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.deleteId-->getText-->轉型-->int
				 * 2.執行 delete(id)
				 */
				int Id=Integer.parseInt(deleteId.getText());
				new implMember().delete(Id);
				
			}
		});
		delete.setBounds(20, 136, 61, 32);
		panel_1.add(delete);
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
		
				public  void mouseClicked(MouseEvent e) {
						/*
						 * 1.nameUpdate,addressUpdate ,updateId-->getText
						 * 2.updateId-->轉成int--->queryId(id)-->member m
						 * 3.m.setName(),m.setAddress()
						 * 4.update(m)
						 */
				String Name=nameUpdate.getText();
				String Address=addressUpdate.getText();
				
				int ID=Integer.parseInt(updateId.getText());
				member m=new implMember().queryId(ID);
				m.setName(Name);
				m.setAddress(Address);
				
				new implMember().update(m);
				
					 
				
			}
		});
		
		update.setBounds(20, 105, 61, 32);
		panel_1.add(update);
		
		JLabel lblNewLabel = new JLabel("會員查詢系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 22));
		lblNewLabel.setBounds(177, 10, 163, 40);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 153, 102));
		panel_3.setForeground(new Color(143, 188, 143));
		panel_3.setBounds(91, 59, 204, 36);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel name1_1 = new JLabel("姓名:");
		name1_1.setBounds(38, 10, 38, 25);
		panel_3.add(name1_1);
		
		nameUpdate = new JTextField();
		nameUpdate.setBounds(86, 12, 96, 21);
		panel_3.add(nameUpdate);
		nameUpdate.setColumns(10);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setForeground(new Color(143, 188, 143));
		panel_3_1.setBackground(new Color(102, 153, 102));
		panel_3_1.setBounds(100, 105, 182, 36);
		panel_1.add(panel_3_1);
		
		JLabel name1_1_1 = new JLabel("地址:");
		name1_1_1.setBounds(10, 12, 48, 23);
		panel_3_1.add(name1_1_1);
		
		addressUpdate = new JTextField();
		addressUpdate.setColumns(10);
		addressUpdate.setBounds(68, 12, 96, 21);
		panel_3_1.add(addressUpdate);
		
		JButton queryAll = new JButton("查詢");
		queryAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.show.setText-->queryAll1():String
				 */
				
				show.setText(new implMember().queryAll1());
				List<member> l=new implMember().queryAll2();
				total.setText("共:"+l.size()+"筆");
			}
		});
		queryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*1.show.setText-->queryAll1():String*/
				
				show.setText(new implMember().queryAll1());
			}
		});
		
		
		queryAll.setBounds(20, 70, 61, 32);
		panel_1.add(queryAll);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(301, 105, 182, 36);
		panel_1.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setForeground(new Color(143, 188, 143));
		panel_3_1_1.setBackground(new Color(102, 153, 102));
		
		JLabel name1_1_1_1 = new JLabel("ID:");
		name1_1_1_1.setBounds(10, 5, 45, 35);
		panel_3_1_1.add(name1_1_1_1);
		
		updateId = new JTextField();
		updateId.setColumns(10);
		updateId.setBounds(65, 12, 96, 21);
		panel_3_1_1.add(updateId);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setLayout(null);
		panel_3_1_1_1.setForeground(new Color(143, 188, 143));
		panel_3_1_1_1.setBackground(new Color(102, 153, 102));
		panel_3_1_1_1.setBounds(91, 136, 182, 36);
		panel_1.add(panel_3_1_1_1);
		
		JLabel name1_1_1_1_1 = new JLabel("ID:");
		name1_1_1_1_1.setBounds(10, 5, 45, 35);
		panel_3_1_1_1.add(name1_1_1_1_1);
		
		deleteId = new JTextField();
		deleteId.setColumns(10);
		deleteId.setBounds(65, 12, 96, 21);
		panel_3_1_1_1.add(deleteId);
	}
}
