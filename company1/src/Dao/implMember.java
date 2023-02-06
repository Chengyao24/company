package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {

	/*	member m=new member("ABC","red","000","台北","44","123");
		new implMember().add(m);*/
		//System.out.println(new implMember().queryAll2());
		//System.out.println(new implMember().queryAll1());
		/*List<member> l=new implMember().queryAll2();
		for(member o:l)  //l的類型是member
		{
			System.out.println(o.getId()+"\t"o.getName());
		}
		
		System.out.println(l.size());  //l的長度*/
		//System.out.println(new implMember().queryId(10));
		//System.out.println(new implMember().queryMember("abc", "123"));
/*		member m=new implMember().queryId(5);
	m.setPassword("Awe123");
		new implMember().update(m);*/
		new implMember().delete(10);
	
		


		
	
	

	}

	@Override
	public void add(member m) {
		Connection conn=DbConnection.getDB();
		String sQL="insert into member(name,username,password,address,mobile,phone) "
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String queryAll1() {//query查詢要用resultSet
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";  //選取所有資料庫資料
		String show="";   //讓之後getString名那些可以連接下去
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t行動:"+rs.getString("mobile")+
						"\t電話:"+rs.getString("phone")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public List<member> queryAll2() {             //query查詢要用resultSet
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member> l=new ArrayList();         //將陣列轉成集合,陣列有數量限制[3],list<>集合沒有,經由下面給的資料
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				member m=new member();  //new一個空的建構式,藉由m修改member裡的id,修改的值為rs(資料庫裡getid資料)
						m.setId(rs.getInt("id"));                            //把資料撈出來給m
						m.setName(rs.getString("name"));
						m.setUsername(rs.getString("username"));
						m.setPassword(rs.getString("password"));
						m.setAddress(rs.getString("address"));
						m.setMobile(rs.getString("mobile"));
						m.setPhone(rs.getString("phone"));
						l.add(m); //把資料給l List<member> l=new ArrayList();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public member queryId(int id) { //query查詢要用resultSet
		 
			/*
			 * 1.連線->Connection
			 * 2.SQL-->where id=?
			 * 3.ResultSet
			 * 4.if->rs.next()
			 * 5.true-->rs-->new member()
			 * 6.false-->null
			 */
			
			Connection conn=DbConnection.getDB();
			String SQL="select * from member where id=?";
			member m=null;
			try {
				PreparedStatement ps=conn.prepareStatement(SQL);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					 m=new member();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setAddress(rs.getString("address"));
					m.setMobile(rs.getString("mobile"));
					m.setPhone(rs.getString("phone"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					return m;
		 }


	
	@Override
	public member queryMember(String username, String password) { //用在登入
		/*
		 * 1.先連線-->Connection
		 * 2.SQL-->where username=? and password=?
		 * 3.if(rs.next())
		 * 4.true--->new member()-->rs填入
		 * 5.false-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where username=? and password=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				m=new member(); //new一個member空的建構式,將資料庫資料帶入
				m.setId(rs.getInt("id")); //在member裡透過set將從資料庫id的資料帶入
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public void update(member m) {
		/*
		 * 1.先連線
		 * 2.SQL-->update 全部內容 where id=?
		 * 3.preparedStatement執行
		 */
		Connection conn=DbConnection.getDB();
		String SQL="update member set name=?,username=?,password=?,address=?,mobile=?,phone=?"
				+"where id=?";

		
	
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5,m.getMobile());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
						
		
				
		
		
		}

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
		String SQL="delete from member where id=?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public boolean queryUsername(String username) { //用在註冊時,看有沒有這個username
		Connection conn=DbConnection.getDB();
		String SQL="select *from member where username=?";
		boolean m=false;  //預設沒有這個人
		PreparedStatement ps;
		
		try {
			ps=conn.prepareStatement(SQL);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		return m;
	}

}
