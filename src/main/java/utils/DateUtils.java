package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @author E-mail: guoleihit@gmail.com
 * @version ：2017年2月2日 下午5:19:22  
 */
public class DateUtils {

    public static Date parseDate(String dateStr, String dateFormat){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * transform dateStr from srcDateFormatStr to targetDateFormatStr
     * @param dateStr
     * @param srcDateFormatStr
     * @param targetDateFormatStr
     * @return
     */
    public static String trasformDateStr(String dateStr, String srcDateFormatStr, String targetDateFormatStr){
        DateFormat srcDateFormat = new SimpleDateFormat(srcDateFormatStr);
        DateFormat targetDateFormat = new SimpleDateFormat(targetDateFormatStr);
        Date date;
        try {
            date = srcDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
        return targetDateFormat.format(date);
    }
}
