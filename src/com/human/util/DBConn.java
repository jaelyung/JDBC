package com.human.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	//.getInstance()
	//new DBConn(); 작업을 하지 못하게, 객체를 한번만 생성할 수 있게하기
	private DBConn() {} //외부에서 생성 불가능 내부에서 한번만 생성하게 함
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
			//프로그램에서는 auto commit 기본값
			resultValue=st.executeUpdate(sql);
//			if(n==1) {//n은 변경된 개수
//				System.out.println("정상동작");
//			}else {
//				System.out.println("비정상동작");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			DBConn.dbClose();
		}
		return resultValue;
	}
	//insert, select ...  DB를 반복적으로 열고 닫는 작업을 코드로 작성
	public static Connection getInstance() {
		if(dbConn==null) {//객체가 아예 없으면
			try {
				//1.사용할 데이터베이스  드라이브 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩완료");
				//2.해당 데이터베이스에 접속 url, user, pw
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				String user="human";
				String pw="human";
				dbConn=DriverManager.getConnection(url, user, pw);
				System.out.println("데이터베이스 접속성공");
				
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
			if(st!=null) st.close();//Statement를 먼저 닫는다
			if(dbConn!=null) dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConn=null;
		}
	}
	
	
	
}
