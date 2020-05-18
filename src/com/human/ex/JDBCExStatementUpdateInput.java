package com.human.ex;

import java.sql.Connection;
import java.util.Date;

import com.human.util.DBConn;

public class JDBCExStatementUpdateInput {

	public static void main(String[] args) {
		//AOP
		DBConn.getInstance();//공통로직
		//사용자 입력을 받아서 데이터를 추가해 보자
		System.out.println("no 입력");
		int no=DBConn.inputInt();
		
		System.out.println("name 입력");
		String name=DBConn.inputString();
		
		System.out.println("height 입력");
		Double height=DBConn.inputDouble();
		
		System.out.println("birth 입력");
		Date birth=DBConn.inputDate();
		
		System.out.println("regist 입력");
		Date regist=DBConn.inputDate();
		
		String sql="insert into person values"+"(%d,'%s',%f,to_date('%s','yyyy-mm-dd hh24:mi:ss'),to_date('%s','yyyy-mm-dd hh24:mi:ss'))";
		sql=String.format(sql, no,name,height,DBConn.dateToString(birth),DBConn.dateToString(regist));
		
		System.out.println(sql);
		DBConn.statementUpdate(sql);//주로직 ->내용이 바뀌는 부분
//		
//		sql="delete person where no=11";//DBConn에서 sql null처리 필요
//		DBConn.statementUpdate(sql);//주로직 ->내용이 바뀌는 부분
//		
//		sql="update person set name='박' where no=15";//DBConn에서 sql null처리 필요
//		DBConn.statementUpdate(sql);//주로직 ->내용이 바뀌는 부분
				
		
		DBConn.dbClose();//공통로직
		
		//ResultSet(), util -> 5/14
		
	}

}
