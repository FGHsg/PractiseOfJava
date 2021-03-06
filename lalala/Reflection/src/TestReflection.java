import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "T";
		
		Class c = Class.forName(str);
		 
		Object o =c.newInstance();
		Method[] m1 = c.getMethods();
		for(Method m : m1){
			if(m.getName().equals("mm")){
				m.invoke(o);
			}
			
			if(m.getName().equals("m1")){
				m.invoke(o,1,2);
				for(Class paramType : m.getParameterTypes()){
					System.out.println(paramType.getName());
				}
			}
			
			if(m.getName().equals("returnName")){
				
				Class returnType = m.getReturnType();
				System.out.println(returnType.getName());
				
			}
		}
	}

}

class T{
	int i;
	String s;
	public void mm(){
		System.out.println("mm invoked!");
	}
	public void m1(int i,int j){
		int b = i+j;
		System.out.println(b);
	}
	
	public String returnName(){
		return "fgh";
	}
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	
	
}