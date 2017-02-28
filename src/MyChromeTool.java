import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class MyChromeTool {
	
    private static HttpClient httpClient = null;
    private static String content = null;
    private static Map<String,String> hashMap =new HashMap<>();
	public static void startNet(String uri)
	{
		getNetInfo(uri,null);
    	Map<String,String>hasMap=new HashMap<>();
    	hasMap.put("searchText","1119");
    	
	}
	 public static HttpClient getHttpClient() {

    	 DefaultHttpClient httpClient = new DefaultHttpClient();
//    	 String proxyHost = "127.0.0.1";
//    	 int proxyPort = 8888;
//    	 HttpHost proxy = new HttpHost(proxyHost,proxyPort);
//    	 httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
//    	 httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
    	 return httpClient;
    	}
    private static void getNetInfo(final String uri,final Map<String,String>params)
    {
    	 new Thread() {
	            @SuppressWarnings("deprecation")
				public void run() {
	                if (httpClient == null)
	                    httpClient = getHttpClient();
	               
//	                HttpPost post = new HttpPost(uri);
//	                HttpPost httpPost = new HttpPost(uri);
	                HttpGet httpPost = new HttpGet(uri);
	                HashMap<String, String> headers = new HashMap<String, String>();
	                headers.put("Cache-Control", "max-age=0");
	                headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	                headers.put("Accept-Encoding", "gzip, deflate, sdch");
	                headers.put("Accept-Language", "zh-CN,zh;q=0.8");
	                headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) " +
	                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2763.0 Safari/537.36");
//	                headers.put("Content-Length","15");
//	                headers.put("Content-Type","application/x-www-form-urlencoded");
//	                headers.put("Referer","http://supercms.ankang06.org/fairy/onefairy");
//	                headers.put("Origin","http://supercms.ankang06.org");
	                headers.put("Upgrade-Insecure-Requests", "1");
//	                headers.put("Host", "supercms.ankang06.org");

	                for (String key : headers.keySet()) {
	                	httpPost.setHeader(key , headers.get(key));
	                }
//	                
	                try {
//	        			if(params!=null)
//	        			{
//	        				List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
//		        			for (Map.Entry<String, String> item : params.entrySet()) {
//		        				BasicNameValuePair pair = new BasicNameValuePair(item.getKey(),item.getValue());
//		        				parameters.add(pair);
//		        			}
//		        			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
//		        				httpPost.setEntity(entity);
//		                
//	        			}
//	        			BasicCookieStore cookieStore=new BasicCookieStore();
//	        			BasicClientCookie cookie = new BasicClientCookie("JSESSIONID",
//	        			        JSESSIONID);
//	        			    cookie.setVersion(0);
//	        			    cookie.setDomain("127.0.0.1");
//	        			    cookie.setPath("/");
//	        			    cookie.setExpiryDate(new Date());
//	        			    cookieStore.addCookie(cookie);
	                	
//	                httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
//	                httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 30000);
	                HttpResponse response;
	            
	                    response = httpClient.execute(httpPost);
	                    System.out.println(response.getStatusLine().getStatusCode());
	                    if (response.getStatusLine().getStatusCode() == 200) {
//	                        String result = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
	                        Header[] resHeaders = response.getAllHeaders();
	                        String encod="gzip";

	                        for (int i = 0; i < resHeaders.length; i++) {
	                        	System.out.println(resHeaders[i].getName()+"="+resHeaders[i].getValue());
//	                           Log.i("headersInfo", resHeaders[i].getName()+"="+resHeaders[i].getValue());
//	                            if(resHeaders[i].getName().equals("Content-Type")){
	//
//	                            }
//	                            if(resHeaders[i].getName().equals("Content-Encoding"))
//	                                encod= resHeaders[i].getValue();
	                        }
	                        
//	                        Cookie: PHPSESSID=ora6di845u77hjsj748rg9ig31;
//	                        Hm_lvt_f2aef0b5d60c9e29de10238ab642716c=1466854680; 
//	                        Hm_lpvt_f2aef0b5d60c9e29de10238ab642716c=1466856961
	                        
	                        StringBuffer sb=new StringBuffer();
//	                        if(encod.equals("gzip")) {
	                        //For GZip response
	                        InputStream is = response.getEntity().getContent();
	                        GZIPInputStream gzin = new GZIPInputStream(is);
	                        InputStreamReader isr = new InputStreamReader(gzin, HTTP.UTF_8);
	                        java.io.BufferedReader br = new java.io.BufferedReader(isr);
	                        String tempbf;
	                        while ((tempbf = br.readLine()) != null) {
	                            sb.append(tempbf);
	                            sb.append("\r\n");
	                        }
	                        isr.close();
	                        gzin.close();
//	                        }

	                        List<Cookie> cookies = ((AbstractHttpClient) httpClient).getCookieStore().getCookies();
	                        Cookie cookie = null;

	                        for (int i = 0; i < cookies.size(); i++) {
	                            cookie = cookies.get(i);
//	                            Log.i("cookieName", cookie.getName());
//	                            Log.i("cookieValue", cookie.getValue());
	                            System.out.println("cookieName"+"  "+cookie.getName());
	                            System.out.println("cookieValue"+"  "+cookie.getValue());
	                            hashMap.put(cookie.getName(),cookie.getValue());
	                        }
	                     
	                        content=sb.toString();
	                        
//	                        String emailPattern = "^([a-z0-9_\\.\\-\\+]+)@([\\da-z\\.\\-]+)\\.([a-z\\.]{2,6})$"; 
//	                        pattern = Pattern.compile(emailPattern); 
//	                        matcher = pattern.matcher("test@qq.com"); 
	                        
	                        System.out.println(content);
//	                        Log.i("conntent",sb.toString());
	                    }
	                } catch (ClientProtocolException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }catch (Exception e) {
     				e.printStackTrace();
     			}
	            }
	            ;
	        }.start();
    }

}
