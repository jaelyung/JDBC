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
			//1.사용할 데이터베이스  드라이브 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩완료");
			//2.해당 데이터베이스에 접속 url, user, pw
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="human";
			String pw="human";
			conn=DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 접속성공");
			//3.Connection을 통해서 statement 객체 생성
			//statement는 서로(client<->server) 데이터 주고 받을 때 사용
			st=conn.createStatement();
			//프로그램에서는 auto commit 기본값
			int n=st.executeUpdate("insert into person values"+"(13,'홍3',123.23,sysdate,systimestamp)");
			if(n==1) {//n은 변경된 개수
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
			}
			
			n=st.executeUpdate("delete from person where no=2");
			if(n>0) {//n은 변경된 개수
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
			}
			
			n=st.executeUpdate("update person set name='강' where no=1");
			if(n>0) {//n은 변경된 개수
				System.out.println("정상동작");
			}else {
				System.out.println("비정상동작");
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
