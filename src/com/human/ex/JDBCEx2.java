package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCEx2 {//PreparedStatement ���

	public static void main(String[] args) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
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
			String sql="select * from dept where LOC=?";
			String loc="DALLAS";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, loc);
			//4.ResultSet ������ (��û�� ��������)
			rs=pst.executeQuery();
			
			while(rs.next()) {
				//int no=rs.getInt("no");
				int deptNo=rs.getInt(1);
				String dName=rs.getString(2);//2��� "name"����
				String address=rs.getString(3);
								
				System.out.println(deptNo+"~"+dName+"~"+address);	
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
					if(pst!=null) pst.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}

}
