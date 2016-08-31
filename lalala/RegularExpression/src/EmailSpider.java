import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailSpider {

	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\FGHsg_\\Desktop\\aaa.html"));
			String line = "";
			while((line=br.readLine())!=null){
				parse(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static void parse(String line) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		while(m.find()){
			System.out.println(m.group());
		}
	}

}
