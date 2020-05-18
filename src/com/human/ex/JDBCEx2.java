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

public class JDBCEx2 {//PreparedStatement 사용

	public static void main(String[] args) {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
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
			String sql="select * from dept where LOC=?";
			String loc="DALLAS";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, loc);
			//4.ResultSet 얻어오기 (요청한 실행결과물)
			rs=pst.executeQuery();
			
			while(rs.next()) {
				//int no=rs.getInt("no");
				int deptNo=rs.getInt(1);
				String dName=rs.getString(2);//2대신 "name"가능
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
