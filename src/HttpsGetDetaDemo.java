import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;


public class HttpsGetDetaDemo {
	public static void get12306net()
	{
		String uri = "https://kyfw.12306.cn/otn/";
		String result =getNetDateTools("uri");
	}
	private static String getNetDateTools(String url)
	{
		 long responseLength = 0;       //响应长度
		 String responseContent = null; //响应内容
		HttpClient httpClient =new DefaultHttpClient();
		try{
			KeyStore trust =KeyStore.getInstance(KeyStore.getDefaultType());
			FileInputStream fis = new FileInputStream(new File("E:\\github_workspace\\Tao_Oat\\NetTools\\srca.cer"));
			trust.load(null,null);
//			trust.setCertificateEntry("ca", ca);
//			trust.load(fis, "hongyu75".toCharArray()); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseContent;
		
		
	}

}
