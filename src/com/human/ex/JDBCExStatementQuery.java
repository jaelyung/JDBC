package com.human.ex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.human.util.DBConn;

public class JDBCExStatementQuery {

	public static void main(String[] args) {
		DBConn.getInstance();//공통로직
//		String sql="select * from person";
//		DBConn.statementQuery(sql);
		
		String sql="select * from person";//DBConn에서 sql null처리 필요
		ResultSet rs=DBConn.statementQuery(sql);//주로직 ->내용이 바뀌는 부분
		//ResultSet rs=> rs 출력부분 주로직에서 변경필요
		try {
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
//				DateFormat df=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//				System.out.println(df.format(birth1));//2020/05/13 12:00:00 //시간은 기본값
//				System.out.println(df.format(birth2));//1970/01/01 09:17:27 //날짜 기본값
//				System.out.println(df.format(birth3));//2020/05/13 09:17:27 //시간, 날짜 다 담겨있음
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConn.dbClose();//공통로직
		
		System.out.println("종료");
	}

}
