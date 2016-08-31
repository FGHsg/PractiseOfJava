
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import com.bjsxt.hibernate.model.Student;
import com.mysql.jdbc.Connection;



public class Session {
	String tableName = "_Student";//Assumetion develop
	Map<String,String> cfs = new HashMap<String,String>();
	String[] methodNames ;
	
	public Session(){
		
		cfs.put("_id", "id");
		cfs.put("_name", "name");
		cfs.put("_age", "age");//yuanben zai peizhiwenjianzhong 
		methodNames = new String[cfs.size()];
	}
	
	public void save(Student s) throws Exception {	
		String sql =  createSQL();

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn  = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/hibernate","root","321wssba");
		PreparedStatement ps = conn.prepareStatement(sql);
		
		for(int i = 0;i<methodNames.length;i++){
			
			Method m= s.getClass().getMethod(methodNames[i]);//reflect system
			Class r = m.getReturnType();
			if(r.getName().equals("java.lang.String")){
				String returnValue = (String)m.invoke(s);
				ps.setString(i+1,returnValue);			
			}
			
			if(r.getName().equals("int")){
				Integer returnValue = (Integer)m.invoke(s);
				ps.setInt(i+1,returnValue);				
			}
		}
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}

	private String createSQL() {
		String str1="";
		String str2="";
		int index = 0;
		for(String s :cfs.keySet()){
			String v = cfs.get(s);//将set对应的值返回到V
			v = Character.toUpperCase(v.charAt(0)) + v.substring(1,v.length());
			methodNames[index] = "get" + v; 			
			str1+=s+",";
			index++;
		}
		str1 =str1.substring(0,str1.length()-1);		
		for(int i =0;i<cfs.size();i++){
			str2+="?,";
		}
		str2 = str2.substring(0,str2.length()-1);	
		String sql = "insert into " + tableName +"(" + str1 + ")" +"values (" +str2 + ")";		
		return sql;
	}

}
