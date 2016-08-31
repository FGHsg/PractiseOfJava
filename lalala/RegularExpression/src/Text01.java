import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Text01 {

public static void main(String[] args) {
		/*p("aaa".matches("..."));
		p("a5678d".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fad");
		p(m.matches());
		p("fad".matches("[a-z]{3}"));
		*/
		
		//初步认识 .所有字符 *零个或多个 +一个或多个?一个或一个也没有
		/*p("aa".matches(".."));
		p("".matches("a*"));
		p("aa".matches("a*"));
		p("aa".matches("a+"));*/		
//		p("109.178.202.125".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		
		/*p("A".matches("[ABC]"));
		p("A".matches("[^ABC]"));
		p("A".matches("[a-zA-Z]"));
		p("A".matches("[A-Z&&[DFG]]"));
		p("A".matches("[A-Z&&[^D-G]]"));
		*/
		//初步认识 
/*		\d 数字[0-9]
		\D非数字 
		\s空白字符：[ \t\n\x0B\f\r] 
		\S 非空白字符：[ \t\n\x0B\f\r] 
		\w单词字符：[a-zA-Z_0-9]  
		\W  非单词字符：[a-zA-Z_0-9] 
*/		
		/*p(" \n\r\t".matches("\\s{4}"));
		p("\\".matches("\\\\"));//必须特别注意
*/
		//初步认识边界匹配
	/*
	^	行的开头
	$	行的结尾
	\b	单词边界
	\B	非单词边界
	\A	输入的开头
	\G	上一个匹配的结尾
	\Z	输入的结尾，仅用于最后的结束符（如果有的话）
	\z	输入的结尾*/
	/*p("hello sir".matches("^h[a-z]{4}\\b.*"));
	//空白行  以空白字符但不是换行符开头 以换行符结尾的符号
	p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
	*/
	
	
	//matches :永远匹配整个字符串 匹配的字符串会被回收 故要用reset回收 find 找在范围内符合条件的子字符串  lookingAt 永远从字符串开始的地方找 
	/*Pattern p = Pattern.compile("\\d{3,5}");
	String s= "123-12345-1345-12";
	Matcher m = p.matcher(s);
	p(m.matches());
	m.reset();
	p(m.find());
	p(m.start()+"-"+m.end());
	p(m.find());
	p(m.find());
	p(m.find());
	
	p(m.lookingAt());
	p(m.lookingAt());
	p(m.lookingAt());
	p(m.lookingAt());*/
	
	/*//replacement
	Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);

	Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA adsdfsdfs");
	
	while(m.find()){
		p(m.group());
	}
	p(m.replaceAll("JAVA"));
	
	int i=0 ;
	StringBuffer buf = new StringBuffer();
	while(m.find()){
		i++;
		if(i%2==0){
			m.appendReplacement(buf, "java");
			p(m.start()+"-"+m.end());
		}
		else{
			m.appendReplacement(buf, "JAVA");
			p(m.start()+"-"+m.end());
		}
		
	}
	m.appendTail(buf);
	p(buf);*/
	
	//group
	Pattern p = Pattern.compile("(\\d{3,5})([a-z]{1,3})");

	Matcher m = p.matcher("111ff-3345ded-43556f");
	while(m.find()){
		p(m.group(1));//使用group函数来显示分组 在正则表达式里面第一个小括号括起来的就是第一个分组
	}
	
}

public static void p(Object a){
	System.out.println(a);
}
}

