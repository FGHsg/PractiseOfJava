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
		
		//������ʶ .�����ַ� *������� +һ������?һ����һ��Ҳû��
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
		//������ʶ 
/*		\d ����[0-9]
		\D������ 
		\s�հ��ַ���[ \t\n\x0B\f\r] 
		\S �ǿհ��ַ���[ \t\n\x0B\f\r] 
		\w�����ַ���[a-zA-Z_0-9]  
		\W  �ǵ����ַ���[a-zA-Z_0-9] 
*/		
		/*p(" \n\r\t".matches("\\s{4}"));
		p("\\".matches("\\\\"));//�����ر�ע��
*/
		//������ʶ�߽�ƥ��
	/*
	^	�еĿ�ͷ
	$	�еĽ�β
	\b	���ʱ߽�
	\B	�ǵ��ʱ߽�
	\A	����Ŀ�ͷ
	\G	��һ��ƥ��Ľ�β
	\Z	����Ľ�β�����������Ľ�����������еĻ���
	\z	����Ľ�β*/
	/*p("hello sir".matches("^h[a-z]{4}\\b.*"));
	//�հ���  �Կհ��ַ������ǻ��з���ͷ �Ի��з���β�ķ���
	p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
	*/
	
	
	//matches :��Զƥ�������ַ��� ƥ����ַ����ᱻ���� ��Ҫ��reset���� find ���ڷ�Χ�ڷ������������ַ���  lookingAt ��Զ���ַ�����ʼ�ĵط��� 
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
		p(m.group(1));//ʹ��group��������ʾ���� ���������ʽ�����һ��С�����������ľ��ǵ�һ������
	}
	
}

public static void p(Object a){
	System.out.println(a);
}
}
