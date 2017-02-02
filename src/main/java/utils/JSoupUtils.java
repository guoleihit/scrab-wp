package utils;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/** 
 * @author E-mail: guoleihit@gmail.com
 * @version ：2017年2月2日 下午5:33:53  
 */
public class JSoupUtils {

    public static String getElementValue(Element wrapperElement, String cssQuery){
        try{
            Element elm = wrapperElement.select(cssQuery).first();
            return elm.text();
        }catch(Exception e){
            e.printStackTrace();
            return "";   
        }
    }
    
    public static class ConnectionFactory {
        private static final int DEFAULT_TIMEOUT = 30 * 1000;

        public static Connection getConnection(String url, int timeout,
                Map<String, String> cookies, boolean validateCert) {
            Connection con = Jsoup.connect(url).timeout(timeout)
                    .cookies(cookies).validateTLSCertificates(validateCert);
            return con;
        }

        public static Connection getConnection(String url, boolean validateCert) {
            return getConnection(url, DEFAULT_TIMEOUT,
                    new HashMap<String,String>(), validateCert);
        }
    }
}
