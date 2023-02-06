package Controller.smaple2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel 名 = new JLabel("帳號");
		名.setBounds(93, 61, 46, 15);
		contentPane.add(名);
		
		JLabel 密碼 = new JLabel("密碼");
		密碼.setBounds(93, 146, 46, 15);
		contentPane.add(密碼);
		
		username = new JTextField();
		username.setBounds(208, 58, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(208, 143, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.帳號密碼 getText()
				 * 2.queryUser(帳號,密碼):member
				 * 3.!=null--->loginSuccess
				 * 4.null-->loginError
				 */
				String Username=username.getText();
				String Password=password.getText();
				
				member m=new implMember().queryMember(Username,Password);
				
          if(m!=null)  //	String SQL="select *from member where username=? and password=?";  	member m=null;
          {
        	  loginSuccess l=new loginSuccess();
        	  l.show();
        	  dispose();
          }
          else
			{
				loginError l=new loginError();
				l.show();
				dispose();
			}
				
				
			}
		});
		login.setBounds(150, 204, 87, 23);
		contentPane.add(login);
	}

}
