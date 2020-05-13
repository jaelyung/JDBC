package com.human.ex;

import java.sql.Connection;

import com.human.util.DBConn;

public class JDBCExStatementUpdate {

	public static void main(String[] args) {
		//AOP
		DBConn.getInstance();//공통로직
		String sql="insert into person values"+"(16,'홍3',123.23,sysdate,systimestamp)";//DBConn에서 sql null처리 필요
		
		DBConn.StatementUpdate(sql);//주로직 ->내용이 바뀌는 부분
		sql="delete person where no=11";//DBConn에서 sql null처리 필요
		
		DBConn.StatementUpdate(sql);//주로직 ->내용이 바뀌는 부분
		sql="update person set name='박' where no=15";//DBConn에서 sql null처리 필요
		
		DBConn.StatementUpdate(sql);//주로직 ->내용이 바뀌는 부분
		DBConn.dbClose();//공통로직
		
		//ResultSet(), util -> 5/14
		
	}

}
