package com.human.ex;

import java.sql.Connection;
import java.util.Date;

import com.human.util.DBConn;

public class JDBCExStatementUpdateInput {

	public static void main(String[] args) {
		//AOP
		DBConn.getInstance();//�������
		//����� �Է��� �޾Ƽ� �����͸� �߰��� ����
		System.out.println("no �Է�");
		int no=DBConn.inputInt();
		
		System.out.println("name �Է�");
		String name=DBConn.inputString();
		
		System.out.println("height �Է�");
		Double height=DBConn.inputDouble();
		
		System.out.println("birth �Է�");
		Date birth=DBConn.inputDate();
		
		System.out.println("regist �Է�");
		Date regist=DBConn.inputDate();
		
		String sql="insert into person values"+"(%d,'%s',%f,to_date('%s','yyyy-mm-dd hh24:mi:ss'),to_date('%s','yyyy-mm-dd hh24:mi:ss'))";
		sql=String.format(sql, no,name,height,DBConn.dateToString(birth),DBConn.dateToString(regist));
		
		System.out.println(sql);
		DBConn.statementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
//		
//		sql="delete person where no=11";//DBConn���� sql nulló�� �ʿ�
//		DBConn.statementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
//		
//		sql="update person set name='��' where no=15";//DBConn���� sql nulló�� �ʿ�
//		DBConn.statementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
				
		
		DBConn.dbClose();//�������
		
		//ResultSet(), util -> 5/14
		
	}

}
