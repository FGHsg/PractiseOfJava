import java.sql.*;
public class Db01 {
	public static void main(String args[]){
		
		PreparedStatement ps= null;
		Connection connect = null;
		Statement state = null;
		ResultSet rs = null;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");			
			connect = DriverManager.getConnection("jdbc:odbc:SQL server", "sa", "321wssba");
			state = connect.createStatement();
//			/*��� ������Ӱ�������*/
//			int i = state.executeUpdate("insert into charactor values(1,'����','����','��',10000,1000)");
//			if(i==1){
//				System.out.println("��ӳɹ�");
//			}
			
//			/*ɾ�� ������Ӱ�������*/
//			int i1 = state.executeUpdate("delete from charactor where id =1");
//			if(i1!=0){
//				System.out.println("ɾ���ɹ�");
//			}
//			else{
//				System.out.println("ɾ��ʧ��");
//			}
			
			/*��ѯ ��֤��ȫ��*/
			//��ָ�������������ڴ������ݿ� ���
//			ps= connect.prepareStatement("create database abc");
//			ps= connect.prepareStatement("create table aabbcc");//ע���ʱ�����ı������Ĭ�����ݿ��� ���Ҫ�ı䵽�½������ݿ� ��Ҫ��������
			ps= connect.prepareStatement("select * from charactor where id= ? and named = ?");
			ps.setInt(1, 1);
			ps.setString(2,"�����");
			rs= ps.executeQuery();
			
			rs = state.executeQuery("select * from charactor");//SQL���
			
			while(rs.next()){//rsָ����µ�һ�е���һ��
				int id = rs.getInt(1);//�õ���һ���ֶ�
				String name = rs.getString(2);
				String occupation = rs.getString(3);
				
				System.out.println(id + " "+name + " "+occupation);
			}
		}
		catch(Exception e){}
	}
}
