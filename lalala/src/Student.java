
public class Student {//学生类
	private int on;
	private String name;
	private int age;
	private int java;
	private int c_shar;
	private int html;
	private int sql;
	private int sum;
	private int avg;
	
	public void setOn(int on){
		this.on=on;
	}
	public int getOn(){
		return this.on;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getC_shar() {
		return c_shar;
	}
	public void setC_shar(int c_shar) {
		this.c_shar = c_shar;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getSum() {
		return sum;
	}
	public void setSum() {
		this.sum=this.java+this.sql+this.html+this.c_shar;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg =this.sum/4;
	}
	
	/*toString；类用于输出当前对象的成员变量值，用一个String变量来存储，调用是只需要print（该类的引用）
	 * */
	public String toString(){
		String msg="\t"+this.on+"\t"+this.name+"\t"+this.age+"\t"+this.java+"\t"
		+this.c_shar+"\t"+this.html+"\t"+this.sql+"\t"+this.sum+"\t"+this.avg;
		return msg;
	}
}
