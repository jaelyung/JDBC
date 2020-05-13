package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCEx {

	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1.����� �����ͺ��̽�  ����̺� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε��Ϸ�");
			//2.�ش� �����ͺ��̽��� ���� url, user, pw
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="human";
			String pw="human";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("�����ͺ��̽� ���Ӽ���");
			//3.Connection�� ���ؼ� statement ��ü ����
			//statement�� ����(client<->server) ������ �ְ� ���� �� ���
			st=conn.createStatement();
			//4.ResultSet ������ (��û�� ��������)
			rs=st.executeQuery("select * from person");
			
			while(rs.next()) {
				//int no=rs.getInt("no");
				int no=rs.getInt(1);
				String name=rs.getString(2);//2��� "name"����
				double height=rs.getDouble(3);
				//�ڹٿ��� ���� java.util.Date	DB�� ���� �� java.sql.Date
				//getTime, getTimestamp Date�� �־ ������
				Date birth1=rs.getDate(4);//java.util //2020-05-13
				//getDate -> ��¥�� ���
				Date birth2=rs.getTime(4);//09:17:27
				//getTime -> �ð��� ���
				Date birth3=rs.getTimestamp(4);//09:17:27.0		Date->timestamp
				Date regist=rs.getTimestamp(5);//09:17:27.756	timestamp->timestamp
				
				System.out.println(no+"~"+name+"~"+height+"~"+birth1+"~"+birth2+"~"+birth3+"~"+regist);
				DateFormat df=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				System.out.println(df.format(birth1));//2020/05/13 12:00:00 //�ð��� �⺻��
				System.out.println(df.format(birth2));//1970/01/01 09:17:27 //��¥ �⺻��
				System.out.println(df.format(birth3));//2020/05/13 09:17:27 //�ð�, ��¥ �� �������
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(rs!=null) rs.close();
					if(st!=null) st.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}

}
