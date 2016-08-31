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
//			/*添加 返回受影响的行数*/
//			int i = state.executeUpdate("insert into charactor values(1,'刘备','国君','男',10000,1000)");
//			if(i==1){
//				System.out.println("添加成功");
//			}
			
//			/*删除 返回受影响的行数*/
//			int i1 = state.executeUpdate("delete from charactor where id =1");
//			if(i1!=0){
//				System.out.println("删除成功");
//			}
//			else{
//				System.out.println("删除失败");
//			}
			
			/*查询 保证安全性*/
			//该指令甚至可以用于创建数据库 表格
//			ps= connect.prepareStatement("create database abc");
//			ps= connect.prepareStatement("create table aabbcc");//注意此时创建的表格还是在默认数据库下 如果要改变到新建的数据库 则要重新设置
			ps= connect.prepareStatement("select * from charactor where id= ? and named = ?");
			ps.setInt(1, 1);
			ps.setString(2,"诸葛亮");
			rs= ps.executeQuery();
			
			rs = state.executeQuery("select * from charactor");//SQL语句
			
			while(rs.next()){//rs指向的事第一行的下一行
				int id = rs.getInt(1);//得到第一个字段
				String name = rs.getString(2);
				String occupation = rs.getString(3);
				
				System.out.println(id + " "+name + " "+occupation);
			}
		}
		catch(Exception e){}
	}
}
