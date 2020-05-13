package com.human.ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.human.util.DBConn;

public class JDBCExSingleton {

	public static void main(String[] args) {
		Connection conn=DBConn.getInstance();
		Statement st;
		try {
			st=conn.createStatement();
			//���α׷������� auto commit �⺻��
			int n=st.executeUpdate("insert into person values"+"(14,'ȫ3',123.23,sysdate,systimestamp)");
			if(n==1) {//n�� ����� ����
				System.out.println("������");
			}else {
				System.out.println("��������");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.dbClose();
		}
		
		
	}

}
