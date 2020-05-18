package com.human.ex;

//null값을 넣는 방법을 알아 보자.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class InsertNull {

	public static void main(String[] args) throws Exception {
		String sql = "insert into person values(?,?,?,?)";
		Connection conn =null;
		PreparedStatement pst = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		System.out.println("접속 완료!!!");
		
		conn = DriverManager.getConnection(url,"scott","1234");
		pst = conn.prepareStatement(sql);
		//preparedStatement setNull(pindex, Types.INTEGER)
		//정수형 타입을 null로 설정:java.sql.Types.INTEGER
		//실수형 타입을 null로 설정:java.sql.Types.DOUBLE
		//숫자형 타입을 null로 설정:java.sql.Types.NUMERIC
		//문자형 타입을 null로 설정:java.sql.Types.VARCHAR / setString(pindex, null)
		
		pst.setNull(1, Types.INTEGER);
		pst.setString(2, null); //pst.setNull(2,Types.VARCHAR)
		pst.setNull(3, Types.DOUBLE);
		pst.setNull(4, Types.DATE);
		pst.executeUpdate();
		
		if(conn !=null) conn.close();
		if(pst !=null) pst.close();
		
	}

}