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
			//프로그램에서는 auto commit 기본값
			int n=st.executeUpdate("insert into person values"+"(14,'홍3',123.23,sysdate,systimestamp)");
			if(n==1) {//n은 변경된 개수
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.dbClose();
		}
		
		
	}

}
