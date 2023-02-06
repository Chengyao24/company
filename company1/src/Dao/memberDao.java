package Dao;

import java.util.List;

import Model.member;

public interface memberDao {
	
	 //create新增
	//void add(String name, String username, String password, String address, String mobile,String phone)
	void add(member m); //inject注入  執行一次就不用,用void
	
	//read查詢
	String queryAll1();   //不行單筆
	List<member> queryAll2();  //可以單筆抓出來看
	
	member queryId(int id);//query是SQL查詢的意思
	member queryMember(String username,String password); //用在登入
	boolean queryUsername(String username);
	
	
	//update修改
	
	void update(member m);

	
	
	//delete刪除
	void delete(int id);

}
