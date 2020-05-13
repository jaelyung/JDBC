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
			//4.ResultSet 얻어오기 (요청한 실행결과물)
			rs=st.executeQuery("select * from person");
			
			while(rs.next()) {
				//int no=rs.getInt("no");
				int no=rs.getInt(1);
				String name=rs.getString(2);//2대신 "name"가능
				double height=rs.getDouble(3);
				//자바에서 사용시 java.util.Date	DB에 넣을 땐 java.sql.Date
				//getTime, getTimestamp Date에 넣어도 동작함
				Date birth1=rs.getDate(4);//java.util //2020-05-13
				//getDate -> 날짜만 출력
				Date birth2=rs.getTime(4);//09:17:27
				//getTime -> 시간만 출력
				Date birth3=rs.getTimestamp(4);//09:17:27.0		Date->timestamp
				Date regist=rs.getTimestamp(5);//09:17:27.756	timestamp->timestamp
				
				System.out.println(no+"~"+name+"~"+height+"~"+birth1+"~"+birth2+"~"+birth3+"~"+regist);
				DateFormat df=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				System.out.println(df.format(birth1));//2020/05/13 12:00:00 //시간은 기본값
				System.out.println(df.format(birth2));//1970/01/01 09:17:27 //날짜 기본값
				System.out.println(df.format(birth3));//2020/05/13 09:17:27 //시간, 날짜 다 담겨있음
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
