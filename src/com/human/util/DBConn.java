package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	//.getInstance()
	//new DBConn(); �۾��� ���� ���ϰ�, ��ü�� �ѹ��� ������ �� �ְ��ϱ�
	private DBConn() {} //�ܺο��� ���� �Ұ��� ���ο��� �ѹ��� �����ϰ� ��
	private static Connection dbConn=null;
	private static Statement st=null;
	public static int StatementUpdate(String sql) {
		int resultValue=0;
		
		//dbConn=DBConn.getInstance();
//		DBConn.getInstance();
		try {
			if(st==null) {
				st=dbConn.createStatement();
			}
			//���α׷������� auto commit �⺻��
			resultValue=st.executeUpdate(sql);
//			if(n==1) {//n�� ����� ����
//				System.out.println("������");
//			}else {
//				System.out.println("��������");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			DBConn.dbClose();
		}
		return resultValue;
	}
	//insert, select ...  DB�� �ݺ������� ���� �ݴ� �۾��� �ڵ�� �ۼ�
	public static Connection getInstance() {
		if(dbConn==null) {//��ü�� �ƿ� ������
			try {
				//1.����� �����ͺ��̽�  ����̺� ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("����̹� �ε��Ϸ�");
				//2.�ش� �����ͺ��̽��� ���� url, user, pw
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="human";
				String pw="human";
				dbConn=DriverManager.getConnection(url, user, pw);
				System.out.println("�����ͺ��̽� ���Ӽ���");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static void dbClose() {
		try {
			if(st!=null) st.close();//Statement�� ���� �ݴ´�
			if(dbConn!=null) dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn=null;
		}
	}
	
	
	
}
