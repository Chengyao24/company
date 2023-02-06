package Controller.smaple2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberUI frame = new addMemberUI();
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
	public addMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(150, 21, 188, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel cz = new JLabel("名子");
		cz.setBounds(10, 10, 33, 15);
		panel.add(cz);
		
		name = new JTextField();
		name.setBounds(66, 7, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(150, 68, 188, 37);
		contentPane.add(panel_1);
		
		JLabel cxv = new JLabel("帳號");
		cxv.setBounds(10, 10, 46, 15);
		panel_1.add(cxv);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(66, 7, 96, 21);
		panel_1.add(username);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(150, 115, 188, 37);
		contentPane.add(panel_2);
		
		JLabel cz_2 = new JLabel("密碼");
		cz_2.setBounds(10, 10, 46, 15);
		panel_2.add(cz_2);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(66, 7, 96, 21);
		panel_2.add(password);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(150, 162, 188, 37);
		contentPane.add(panel_3);
		
		JLabel cz_3 = new JLabel("地址");
		cz_3.setBounds(10, 10, 46, 15);
		panel_3.add(cz_3);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(66, 7, 96, 21);
		panel_3.add(address);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(150, 209, 188, 37);
		contentPane.add(panel_4);
		
		JLabel cz_4 = new JLabel("手機");
		cz_4.setBounds(10, 10, 46, 15);
		panel_4.add(cz_4);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(66, 7, 96, 21);
		panel_4.add(mobile);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(150, 256, 188, 37);
		contentPane.add(panel_5);
		
		JLabel cz_5 = new JLabel("電話");
		cz_5.setBounds(10, 10, 46, 15);
		panel_5.add(cz_5);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(66, 7, 96, 21);
		panel_5.add(phone);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				 * 1.username-->getText
				2.帳號判斷-->queryusername():boolean
				 * 3.true-->重複-->addError
				 * 4.false-->接收所有資料-->new member-->add()-->a
				 * */
				
				String Username=username.getText();
				if(new implMember().queryUsername(Username))  //符合資料庫裡的username
				{
					addMemberError error=new addMemberError();
					error.show();
					dispose();
					
				}
				else {
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Mobile=mobile.getText();
					String Phone=phone.getText();
					
					member m=new member(Name,Username,Password,Address,Mobile,Phone);
					
					new implMember().add(m);
					
					addMemberSuccess success=new addMemberSuccess();
					success.show();
					dispose();
					
					
					
					
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(191, 332, 87, 46);
		contentPane.add(btnNewButton);
	}

}
