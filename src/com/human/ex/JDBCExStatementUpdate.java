package com.human.ex;

import java.sql.Connection;

import com.human.util.DBConn;

public class JDBCExStatementUpdate {

	public static void main(String[] args) {
		//AOP
		DBConn.getInstance();//�������
		String sql="insert into person values"+"(16,'ȫ3',123.23,sysdate,systimestamp)";//DBConn���� sql nulló�� �ʿ�
		
		DBConn.StatementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
		sql="delete person where no=11";//DBConn���� sql nulló�� �ʿ�
		
		DBConn.StatementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
		sql="update person set name='��' where no=15";//DBConn���� sql nulló�� �ʿ�
		
		DBConn.StatementUpdate(sql);//�ַ��� ->������ �ٲ�� �κ�
		DBConn.dbClose();//�������
		
		//ResultSet(), util -> 5/14
		
	}

}
