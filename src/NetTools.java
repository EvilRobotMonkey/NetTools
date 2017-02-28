import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class NetTools {

	
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	String sparam="md://sms/18301652550/%E4%BA%B2%E7%88%B1%E7%9A%84%E9%82%B9%E5%B0%8F%E9%9B%B7%EF%BC%8C%E4%BD%A0%E5%9C%A8%E4%B8%AD%E8%8B%B1%E4%BA%BA%E5%AF%BF%E7%9A%84%E4%BF%9D%E5%8D%95AH009005%E5%BA%94%E7%BC%B4%E8%B4%B9%E6%97%A5%E4%B8%BA2017/01/08%EF%BC%8C%E7%BB%AD%E6%9C%9F%E4%BF%9D%E8%B4%B9%E4%B8%BA1,649.00%E5%85%83%EF%BC%8C%E8%AF%B7%E7%A1%AE%E4%BF%9D%E5%8F%B7%E7%A0%81%E4%B8%BA622700********9881%E7%9A%84%E4%B8%AD%E5%9B%BD%E5%BB%BA%E8%AE%BE%E9%93%B6%E8%A1%8C%E8%B4%A6%E6%88%B7%E4%B8%AD%E6%9C%89%E8%B6%B3%E5%A4%9F%E4%BD%99%E9%A2%9D%E4%BB%A5%E5%8F%8A%E6%97%B6%E7%BB%AD%E4%BF%9D%E3%80%82";
    	Pattern pattern = Pattern.compile("(1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8})");
    	Matcher matcher = pattern.matcher(sparam);
    	StringBuffer bf = new StringBuffer();
    	while (matcher.find()) {
    	bf.append(matcher.group());
    	}
    	 
    	
    	  Matcher slashMatcher = Pattern.compile("/").matcher(sparam);
    	   int mIdx = 0;
    	   while(slashMatcher.find()) {
    	      mIdx++;
    	      //当"/"符号第几次次出现的位置
    	      if(mIdx == 3){
    	         break;
    	      }
    	   }
    	   System.out.println(sparam.substring(slashMatcher.start()+1,slashMatcher.start()+11));
    	
   }

	
   

    
}
