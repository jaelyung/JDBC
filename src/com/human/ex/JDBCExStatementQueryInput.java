package com.human.ex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.human.util.DBConn;

public class JDBCExStatementQueryInput {

	public static void main(String[] args) {
		DBConn.getInstance();//�������
		//����� �Է��� �޾Ƽ� Ư�� no�� ����غ���.
		System.out.println("�˻��ϰ����ϴ� no�� �Է��ϼ���");
		int inputNo=DBConn.inputInt();
		//String sql="select * from person";
		String sql=String.format("select * from person where no=%d",inputNo);
		//Ư�� no�� �˻��ϱ� ���� String.format ���
		//���ڿ� ���� where name='%s'  =>����Ŭ ���ڿ� ���� '' �־�� �۵�
		
		ResultSet rs=DBConn.statementQuery(sql);//�ַ��� ->������ �ٲ�� �κ�
		//ResultSet rs=> rs ��ºκ� �ַ������� �����ʿ�
		try {
			while(rs.next()) {
				//int no=rs.getInt("no");
				int no=rs.getInt(1);
				String name=rs.getString(2);//2��� "name"����
				double height=rs.getDouble(3);
				//�ڹٿ��� ���� java.util.Date	DB�� ���� �� java.sql.Date
				//getTime, getTimestamp Date�� �־ ������
				Date birth1=rs.getDate(4);//java.util //2020-05-13
				//getDate -> ��¥�� ���
				Date birth2=rs.getTime(4);//09:17:27
				//getTime -> �ð��� ���
				Date birth3=rs.getTimestamp(4);//09:17:27.0		Date->timestamp
				Date regist=rs.getTimestamp(5);//09:17:27.756	timestamp->timestamp
				
				System.out.println(no+"~"+name+"~"+height+"~"+birth1+"~"+birth2+"~"+birth3+"~"+regist);
//				DateFormat df=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//				System.out.println(df.format(birth1));//2020/05/13 12:00:00 //�ð��� �⺻��
//				System.out.println(df.format(birth2));//1970/01/01 09:17:27 //��¥ �⺻��
//				System.out.println(df.format(birth3));//2020/05/13 09:17:27 //�ð�, ��¥ �� �������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConn.dbClose();//�������
		
		System.out.println("����");
	}

}
