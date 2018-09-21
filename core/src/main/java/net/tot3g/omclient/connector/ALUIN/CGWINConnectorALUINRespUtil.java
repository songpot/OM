package net.tot3g.omclient.connector.ALUIN;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

public class CGWINConnectorALUINRespUtil {
	
	private static String extract(String response, String field, int startPos) {
		int start = StringUtils.indexOf(response, "<" + field + ">", startPos);
		int end = StringUtils.indexOf(response, "</" + field + ">", startPos);
		return StringUtils.substring(response, start + field.length() + 2, end);
	}	
	
	public static String extractUtil(String response, String field, int startPos) {
		return extract(response,field,startPos);
	}
	
	public static String createTagResponse(String xmlResponse,
			String responsetag) {
		String response = extract(xmlResponse, "ax220:" + responsetag, 0);
		return response;
	}
	
	public static String extractDateTime(String str, int format) {

		String result = "";

		try {

			if (!"".equals(str) && str != null) {
				// format 1 --> 2015-09-07T09:40:38.000Z
				if (format == 1) {
					String[] arr1 = StringUtils.split(str, "T");
					String[] arr2 = StringUtils.split(arr1[1], ".");
					result = arr1[0] + " " + arr2[0];
				}
				// Edit by Wanatsanan 10/11/2017
				else if(format == 2)
				{ 
					// format 2 --> 2015-09-07T09:40:38.000Z and add Bangkok Time zone (+07:00)
					
					String[] arr1 = StringUtils.split(str, "T");
					String[] arr2 = StringUtils.split(arr1[1], ".");
					String gmt = arr1[0] + " " + arr2[0];
					
					try 
					{
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						cal.setTime(df.parse(gmt));
						cal.add(Calendar.HOUR_OF_DAY, 7);
						result = df.format(cal.getTime());
						
					} catch (ParseException e) {
						e.printStackTrace();
						result = gmt;
					}
					
				}
			} // end if != null

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		return result;
	}

}
