package com.human.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExInsert {

	public static void main(String[] args) {
		//insert
		Connection conn=null;
		Statement st=null;
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
			//���α׷������� auto commit �⺻��
			int n=st.executeUpdate("insert into person values"+"(13,'ȫ3',123.23,sysdate,systimestamp)");
			if(n==1) {//n�� ����� ����
				System.out.println("������");
			}else {
				System.out.println("��������");
			}
			
			n=st.executeUpdate("delete from person where no=2");
			if(n>0) {//n�� ����� ����
				System.out.println("������");
			}else {
				System.out.println("��������");
			}
			
			n=st.executeUpdate("update person set name='��' where no=1");
			if(n>0) {//n�� ����� ����
				System.out.println("������");
			}else {
				System.out.println("��������");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(st!=null) st.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

	}

}
