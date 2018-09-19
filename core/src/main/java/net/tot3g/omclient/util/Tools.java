package net.tot3g.omclient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import net.tot3g.omclient.Constants;

/**
 * Tools : utility class
 * 
 * @author e-Synergy Junlapong
 * @author e-Synergy Prapapan
 * @since 2008/05/11 * 
 */

public class Tools {

	/** logger */
	private static Logger log = Logger.getLogger(Tools.class);

	/**
	 * Check Object is null, Check string is empty
	 * 
	 * @param object
	 * @return true: object is null / false: object is not null
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}

		if (object instanceof String) {
			if ("".equals(((String) object))
					|| "null".equalsIgnoreCase(((String) object))
					|| ((String) object).length() == 0) {

				return true;
			}
		}
		return false;
	}

	/**
	 * Check Object is not null, Check string is not empty
	 * 
	 * @param object
	 * @return true: object is not null / false: object is null
	 */
	public static boolean isNotEmpty(Object object) {
		return !(isEmpty(object));
	}

	/**
	 * 
	 * @param object
	 * @return true : object is null or 0 / false : object is not null or not 0
	 */
	public static boolean isEmptyOrZero(Object object) {
		if (object == null) {
			return true;
		}

		if (object instanceof String) {
			if ("".equals(((String) object))) {
				return true;
			}
		}

		if (object instanceof Long) {
			if (((Long) object).longValue() == 0l) {
				return true;
			}
		}
		if (object instanceof Double) {
			if (((Double) object).doubleValue() == 0d) {
				return true;
			}
		}
		if (object instanceof Integer) {
			if (((Integer) object).intValue() == 0) {
				return true;
			}			
		}

		return false;
	}

	/**
	 * convert object null to empty string
	 * 
	 * @param object
	 * @return string
	 */
	public static String nullToEmptyString(Object object) {

		if (isEmpty(object)) {
			return "";
		}
		return object.toString();
	}
	// Support Number empty
	public static Object emptyToNull(Object object) {

		if (isEmpty(object)) {
			return null;
		}
		return object;
	}
	

	/**
	 * convert object null to 0 Double
	 * 
	 * @param object
	 * @return Double
	 */
	public static Double nullToDouble(Double object) {

		if (isEmpty(object)) {
			return new Double(0.00);
		}
		return object;
	}

	/**
	 * convert object null to 0 Long
	 * 
	 * @param object
	 * @return Long
	 */
	public static Long nullToLong(Long object) {

		if (isEmpty(object)) {
			return new Long(0);
		}
		return object;
	}

	/**
	 * convert Integer type from request
	 * 
	 * @param param
	 *            String
	 * @return Long
	 */
	public static Long toLongFromRequest(String param) {
		if (isEmpty(param) || "null".equalsIgnoreCase(param)) {
			return null;
		} else {
			return new Long(param);
		}
	}

	/**
	 * convert Double type from request
	 * 
	 * @param param
	 *            String
	 * @return Double
	 */
	public static Double toDoubleFromRequest(String param) {
		if (isEmpty(param) || "null".equalsIgnoreCase(param)) {
			return null;
		} else {
			return new Double(param);
		}
	}

	/**
	 * removeSepratorHeaderDate
	 * 
	 * @param yyyy/mm/dd
	 * @return yyyymmdd
	 */
	public static String removeSepratorHeaderDate(String headerDateString) {
		return headerDateString.substring(0, 4)
				+ headerDateString.substring(5, 7)
				+ headerDateString.substring(8, 10);
	}

	/**
	 * formatDate
	 * 
	 * @param objDate
	 * @return MM/dd/yyyy
	 */
	public static String formatDate(Date objDate) {

		String str = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			str = simpleDateFormat.format(objDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}
	
	/**
	 * formatDate
	 * 
	 * @param strDate
	 * @return strDate by format
	 */
	public static String formatDate(Date objDate, String format) {

		String str = "";

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);			
			str = simpleDateFormat.format(objDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}	

	/**
	 * formatDate
	 * 
	 * @param strDate
	 * @return MM/dd/yyyy
	 */
	public static String formatDate(String strDate) {

		String str = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date d = simpleDateFormat.parse(strDate);
			str = simpleDateFormat.format(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * formatDate
	 * 
	 * @param strDate
	 * @return strDate by format
	 */
	public static String formatDate(String strDate, String format) {

		String str = "";

		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			Date d = simpleDateFormat.parse(strDate);
			str = simpleDateFormat.format(d);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}
	
	/**
	 * calculateDate
	 * 
	 * type 1 = day
	 * type 2 = month
	 * type 3 = year
	 * 
	 * @param strDate Ex. "2008/12/11"
	 * @param numDate Ex. -5,+2 etc...
	 * @param format  Ex. "YYYY/MM/DD" etc...
	 * @param type    Ex. 1,2,3
	 * @return Date
	 */
	
	public static Date calculateDate(String strDate,int numDate,String format,int type){
		String[] dates = strDate.split("/");
		GregorianCalendar cal = new GregorianCalendar();
		// us format
		if("MM/dd/yyyy".equals(format)){
			cal = new GregorianCalendar(
					new Long(dates[2]).intValue(),
					new Long(dates[0]).intValue() -1,
					new Long(dates[1]).intValue());
		}
		
		// uk format
		if("dd/MM/yyyy".equals(format)){
			cal = new GregorianCalendar(
					new Long(dates[2]).intValue(),
					new Long(dates[1]).intValue() -1,
					new Long(dates[0]).intValue());
		}
		
		// th format
		if("dd/MM/yyyy".equals(format)){
			cal = new GregorianCalendar(
					new Long(dates[2]).intValue(),
					new Long(dates[1]).intValue() -1,
					new Long(dates[0]).intValue());
		}
		
		// jp format
		if("yyyy/MM/dd".equals(format)){
			cal = new GregorianCalendar(
					new Long(dates[0]).intValue(),
					new Long(dates[1]).intValue() -1,
					new Long(dates[2]).intValue());
		}
		
		
		if(type == 1){
			cal.add(GregorianCalendar.DATE, numDate);
		}else if(type == 2){
			cal.add(GregorianCalendar.MONTH, numDate);
		}else if(type == 3){
			cal.add(GregorianCalendar.YEAR, numDate);
		}
		
		return cal.getTime();
	}
	
	/**
	 * formatMonthYM
	 * 
	 * @param strMonth Ex."YYYY/MM" Or "YYYYMM"
	 * 
	 * @return strMonth by format Ex."YYYY/MM" 
	 */
	public static String formatSeparateMonthYM(String strMonth) {

		String str = "";

		try {
			//YYYY/MM 
			if (strMonth.length() != 6)
				return strMonth;
			else
				str = addSepratorYM(strMonth);
			
		} catch (Exception e) {
			return str;
		}

		return str;
	}
	
	
	
	/**
	 * formatMonthYM
	 * 
	 * @param strMonth Ex."MM/YYYY" 
	 * 
	 * @return strMonth by format Ex."MM/YYYY" 
	 */
	public static boolean formatSalseMonthYearMY(String strMonthYear) {

		boolean str = false;
			if (strMonthYear.length()== 7) {
				String sep1 = strMonthYear.substring(2,3);
				String month = strMonthYear.substring(0,2);
				String year  = strMonthYear.substring(3,7);
				System.out.println("String year  = strMonthYear.substring(3,7);"+year);
				//String numYear = checkYear(year);
				if(sep1.equals("/")){
					if ((month.equals("01")||month.equals("02")
					  ||month.equals("03")||month.equals("04")
					  ||month.equals("05")||month.equals("06")
					  ||month.equals("07")||month.equals("08")
					  ||month.equals("09")||month.equals("10")
					  ||month.equals("11")||month.equals("12"))&&(checkYear(year))
					  
				)
					str = true;
			} else {
				str = false;
			}
			}		
		return str;
	}
		
			
	/**
	 * removeSeprator
	 * 
	 * @param dateString Ex. "YYYY/MM/DD" 
	 * @return dateString Ex. "YYYYMMDD"
	 */
    public static String removeSeprator(String dateString) {

        return dateString.substring(0,4)+dateString.substring(5,7)+dateString.substring(8,10) ;

    }
    
    /**
	 * addSeprator
	 * 
	 * @param dateString Ex. "YYYYMMDD"
	 * @return dateString Ex. "YYYY/MM/DD"
	 */
    public static String addSeprator(String dateString) {

        return dateString.substring(0,4)+ "/"+dateString.substring(4,6)+ "/"+dateString.substring(6,8) ;

    }

    /**
	 * removeSepratorYM
	 * 
	 * @param dateString Ex. "YYYY/MM"
	 * @return dateString Ex. "YYYYMM"
	 */
    public static String removeSepratorYM(String ymString) {

        return ymString.substring(0,4) + ymString.substring(5,7);

    }
    
    /**
	 * addSepratorYM
	 * 
	 * @param dateString Ex. "YYYYMM"
	 * @return dateString Ex. "YYYY/MM"
	 */
    public static String addSepratorYM(String ymString) {

		if (isEmpty(ymString)) {
			return ymString;
		} else {
			return ymString.substring(0,4)+ "/" + ymString.substring(4,6);
		}
    }
    
	/**
	 * checkHeaderDate
	 * 
	 * @param strDate
	 *        "YYYY/MM/DD" OR "YYYYMMDD"
	 * @return "" if invalid date, strDate valid date
	 */
	public static String checkHeaderDate(String strDate) {
		
		String retDate = "";
		
		if (isEmpty(strDate)) return "";
	
		String year = "";
		String month = "";
		String date = "";

		try {
			//strDate = YYYY/MM/DD
			if (strDate.length()== 10) {
				year  = strDate.substring(0,4);
				month = strDate.substring(5,7);
				date  = strDate.substring(8,10);		
				String sep1 = strDate.substring(4,5);
				String sep2 = strDate.substring(7,8);
				
				if(!sep1.equals("/")||!sep2.equals("/")){
					return retDate;
				}
				
			} else {
				//strDate= YYYYMMDD
				year  = strDate.substring(0,4);
				month = strDate.substring(4,6);
				date  = strDate.substring(6,8);
				return retDate;
			}
		} catch (Exception ex){
			return retDate;
		} 
		
/*
		String[] dates = strDate.split("/");

		if (dates.length != 3) {
			return retDate;

		} else if (!(checkYear(dates[0]) && dates[1].length() == 2 && dates[2].length() == 2)) {
			return retDate;
		}
		
*/		
		int yyyy, mm, dd;
		
		try {
			yyyy = new Integer(year).intValue();
			mm = new Integer(month).intValue();
			dd = new Integer(date).intValue();
		} catch (Exception ex) {
			return retDate;
		}

		Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(yyyy, mm - 1, dd);

		try {
			java.util.Date ud = cal.getTime();
			DateFormat fmt = DateFormat.getDateInstance();
			retDate = fmt.format(ud);
			return retDate;
		} catch (IllegalArgumentException ex) {
			return retDate;
		}
	}

	/**
	 * checkYear accept year 1900 - 9999
	 * 
	 * @param objectYear
	 * @return true if valid year, otherwise false
	 */
	public static boolean checkYear(String objectYear) {

		return objectYear.length() == 4
				&& checkNumeric(objectYear, 4, false) == 0;
		// && Integer.parseInt(objectYear) >= 1900;
	}

	/**
	 * check date format from objectMonth (YYYY/MM)
	 * 
	 * @param objectMonth
	 *            (YYYY/MM)
	 * @return if correct return true
	 */
	public static boolean checkHeaderYM(String objectMonth) {

		return objectMonth.length() == 7
				&& checkHeaderDate(objectMonth + "/01").length() > 0;
	}

	/**
	 * getMonthEndDate ex. 2006/05 return 2006/05/31
	 * 
	 * @param separateDate
	 * @return
	 */
	public static String getMonthEndDate(String separateDate) {

		Calendar cal = Calendar.getInstance();

		if (separateDate.length() != 11) {
			cal.set(Calendar.YEAR, Integer.parseInt(separateDate.substring(0, 4)));
			cal.set(Calendar.MONTH, Integer.parseInt(separateDate.substring(5,
					7)) - 1);
		} else {
			cal.set(Calendar.YEAR, Integer.parseInt(separateDate
					.substring(0, 5)));
			cal.set(Calendar.MONTH, Integer.parseInt(separateDate.substring(6,
					8)) - 1);
		}
		cal.set(Calendar.DATE, Integer.parseInt("01"));
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

		String str = simpleDateFormat.format(cal.getTime());

		return str;
	}

	/**
	 * ex. 2006/01 return 2005/12
	 * 
	 * @param separateDate
	 * @return
	 */
	public static String getLastMonth(String separateDate) {

		Calendar cal = Calendar.getInstance();

		if (separateDate.length() != 11) {
			cal.set(Calendar.YEAR, Integer.parseInt(separateDate
					.substring(0, 4)));
			cal.set(Calendar.MONTH, Integer.parseInt(separateDate.substring(5,
					7)) - 1);
		} else {
			cal.set(Calendar.YEAR, Integer.parseInt(separateDate
					.substring(0, 5)));
			cal.set(Calendar.MONTH, Integer.parseInt(separateDate.substring(6,
					8)) - 1);
		}

		cal.add(Calendar.MONTH, -1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");

		String str = simpleDateFormat.format(cal.getTime());

		return str;
	}

	/**
	 * getAmountDaysOfMonth
	 * 
	 * @param objectMonth -> Ex.'2008/04'
	 * @param isNowFlg -> true: checked by now date in Month , false: don't checked by now date in Month
	 * @return amount days of month -> 30
	 */
	public static int getAmountDaysOfMonth(String objectMonth, boolean isNowFlg ) {

		String objMonthEndDate = "";
		
		if(isNowFlg){
			String sysDate = getSysDate();
			String sysMonth = sysDate.substring(0, sysDate.length()-3);
			if(objectMonth.compareTo(sysMonth) == 0){
				objMonthEndDate = sysDate;
			} else {
				objMonthEndDate = getMonthEndDate(objectMonth);
			}
		} else {
			objMonthEndDate = getMonthEndDate(objectMonth);
		}
		
		String[] str = objMonthEndDate.split("/");

		return Integer.parseInt(str[2]);
	}
	
    public static String getSysDate (){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(new Date());
    }
    
	/**
	 * checkNumeric
	 * 
	 * @param num
	 * @param maxLength :
	 *            amount digit
	 * @param acceptMinus :
	 *            true: minus value , false: plus value
	 * @return 0: normal value is numeric (Ex."9999", "-9999", "9999.99",
	 *         "-9999.99", ...)
	 * @return -1: normal value is not numeric (Ex."99-99", ".99", "99.",
	 *         "99.99.99", "-.9999", ...)
	 * @return -2: amount digit for normal value invalid (Ex.user require =
	 *         "-9999" but input = "99999")
	 * @return -3: amount digit for decimal value invalid (Ex.user require =
	 *         "-9999.99" but input = "99999.999")
	 */
	public static int checkNumeric(String num, int maxLength,boolean acceptMinus) {
		return checkNumeric(num, maxLength, acceptMinus, false, 0);
	}

	/**
	 * checkNumeric
	 * 
	 * @param num
	 * @param maxLength :
	 *            amount digit
	 * @param acceptMinus :
	 *            true:minus value , false: plus value
	 * @param acceptDecimal :
	 *            true:decimal value , false:not decimal value
	 * @param maxDecimalLength:
	 *            amount of characters that can be maximum input
	 * @return 0: normal value is numeric (Ex."9999", "-9999", "9999.99",
	 *         "-9999.99", ...)
	 * @return -1: normal value is not numeric (Ex."99-99", ".99", "99.",
	 *         "99.99.99", "-.9999", ...)
	 * @return -2: amount digit for normal value invalid (Ex.user require =
	 *         "-9999" but input = "99999")
	 * @return -3: amount digit for decimal value invalid (Ex.user require =
	 *         "-9999.99" but input = "99999.999")
	 */
	public static int checkNumeric(String num, int maxLength,
			boolean acceptMinus, boolean acceptDecimal, int maxDecimalLength) {

		int errorNo = 0;
		int checkMaxLength = maxLength;
		String checkInteger = "";
		String checkDecimal = "";
		int minusPos = 0;
		int dotPos = 0;

		if (isNotEmpty(num)) {

			String wNum = num.replaceAll(",", "");

			if (isEmpty(wNum))
				return -1;
			checkInteger = wNum;

			for (int i = 0; i < wNum.length(); i++) {
				char c = wNum.charAt(i);

				if ((c < '0' || c > '9')) {
					if (c != '-' && c != '.') {
						// normal value is not numeric(input form error)
						return -1;
					}
				}
			}
			// Position of minus sign
			minusPos = wNum.indexOf("-");

			// Position of decimal point
			dotPos = wNum.indexOf(".");

			/** ** Check on minus *** */
			if (minusPos != -1) {
				// There is a minus.
				if (acceptMinus) {

					// The minus can be input.
					if (wNum.length() == 1) {
						// Only the minus sign.(input form error)
						return -1;
					}

					if (minusPos != 0) {
						// The minus sign not be first character.(input form
						// error)
						return -1;

					} else {
						int minusCnt = 0;
						for (int i = 0; i < wNum.length(); i++) {
							char c = wNum.charAt(i);
							if (c == '-') {
								minusCnt += 1;
							}
						}
						// The minus sign more than one.(input form error)
						if (minusCnt > 1) {
							return -1;
						}
						// Amount digit more than maxLength.(input form error)
						checkMaxLength += 1;
					}
				} else {
					// Have minus sign but user not acceptMinus
					return -1;
				}
			}

			/** ** Check on decimal *** */
			if (dotPos != -1) {
				// There is decimal
				if (acceptDecimal) {

					if (wNum.length() == 1) {
						// Only the dot sign.(input form error)
						return -1;
					} else if (dotPos == 0) {
						// The dot sign be first character.(input form error)
						return -1;
					} else if (dotPos == wNum.length()) {
						// The dot sign be last character.(input form error)
						return -1;
					} else if (dotPos == 1 && minusPos == 0) {
						// The minus sign be first character and the dot sign be
						// secound character "-." (input form error)
						return -1;
					} else {
						int dotCnt = 0;
						for (int i = 0; i < wNum.length(); i++) {
							char c = wNum.charAt(i);
							if (c == '.') {
								dotCnt += 1;
							}
						}
						// The dot sign more than one.(input form error)
						if (dotCnt > 1) {
							return -1;
						}
					}

					String[] wNums = split(wNum, ".");

					if (wNums.length == 1) {
						// Ex. ".99", "99." (input form error)
						return -1;

					} else if (wNums.length == 2) {
						checkInteger = wNums[0];
						checkDecimal = wNums[1];
					} else {
						// The decimal point cannot input two or more
						// existence(input form error) Ex."999.99.99"
						return -1;
					}

				} else {
					// Have dot sign but user not acceptDecimal(input form
					// error)
					return -1;
				}
			}

			// Check amount digit for normal value(not decimal)
			if (!acceptDecimal) {
				// Amount digit more than max digit user define
				if (checkInteger.length() > checkMaxLength) {
					return -2;
				}

			} else {
				// Amount digit more than max digit user define or amount
				// decimal more than max decimal user define
				if (checkInteger.length() > checkMaxLength
						|| checkDecimal.length() > maxDecimalLength) {
					return -3;
				}
			}
		}

		return errorNo;
	}

	/**
	 * The string array is acquired from the character string delimited by the
	 * delimiter.
	 * 
	 * @param commaVal
	 * @return
	 */
	public static String[] split(String val, String separateStr) {

		if (isEmpty(val)) {
			return null;
		}

		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(val, separateStr);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * @param num1
	 * @param num2
	 * @return Double value.
	 */
	public static Double multipleToDouble(Number num1, Number num2) {

		if (isEmpty(num1) || isEmpty(num2)) {
			return null;
		}

		double result = num1.doubleValue() * num2.doubleValue();
		return new Double(round(result, 2));
	}

	/**
	 * return add total
	 * 
	 * @return Long value
	 */
	public static Long addition(Long val1, Long val2) {

		if (isEmpty(val2)) {
			return val1;
		}

		if (isEmpty(val1)) {
			return val2;
		}

		return new Long(val1.longValue() + val2.longValue());
	}

	/**
	 * addition
	 * 
	 * @return Double value
	 */
	public static Double addition(Double val1, Double val2) {

		if (isEmpty(val2)) {
			return val1;
		}

		if (isEmpty(val1)) {
			return val2;
		}

		return new Double(val1.doubleValue() + val2.doubleValue());
	}

	/**
	 * @param divide
	 * @param divider
	 * @return Double value.
	 */
	public static Double divide2Double(Number divide, Number divider) {

		if (isEmpty(divide) || isEmptyOrZero(divider)) {
			return null;
		}

		if (divide.doubleValue() == 0) {
			return new Double(0);
		}

		return new Double(divide.doubleValue() / divider.doubleValue());
	}

	/**
	 * @param divide
	 * @param divider
	 * @return Long value.
	 */
	public static Long divide2Long(Number divide, Number divider) {

		Double value = divide2Double(divide, divider);

		if (isEmpty(value)) {
			return null;
		}

		if (value.doubleValue() == 0) {
			value = new Double(0);
		}

		return round(value);
	}

	/**
	 * round
	 * 
	 * @param value
	 * @param roundDigit
	 * @return round(10.1234, 2)---> 10.12
	 */
	public static double round(double value, int roundDigit) {

		double roundMultiple = 1;
		for (int i = 0; i < roundDigit; i++) {
			roundMultiple *= 10;
		}

		long longVal = (Math.round(value * roundMultiple));
		double retval = longVal / roundMultiple;
		return retval;
	}

	/**
	 * @param value
	 *            The value ceiling is being performed on.
	 * @return long value
	 */
	public static Long round(Double value) {

		BigDecimal bd = new BigDecimal(value.doubleValue());
		bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP); // 0-4 will be floored,
		// 5-9 will be ceiled

		return new Long(bd.longValue());
	}

	/**
	 * <P>
	 * check the value is a double primitive format.
	 * </P>
	 * 
	 * @param divide
	 * @param divider
	 *            check divider is not equal 0.
	 * @param format
	 *            The format convertion is being performed on.
	 * @return percent value in format.
	 */
	public static Double calculatePercent(Number divide, Number divider,
			int prec) {

		double val1 = 0;
		double val2 = 0;

		if (isEmptyOrZero(divider) || isEmpty(divide)) {
			return null;
		}

		if (divide.doubleValue() == 0) {
			return new Double(0);
		}

		val1 = Double.parseDouble(String.valueOf(divide));
		val2 = Double.parseDouble(String.valueOf(divider));

		double tmp = (val1 / val2) * 100d;

		if (tmp < 0d) {
			return null;
		}

		return new Double(round(tmp, prec));
	}
	
	/**
	 * formatEscape
	 * 
	 * @param strValue Ex."aaaa\aaaaa" Or "aaaa/aaaaa" Or "aaaa`aaaa"
	 * 
	 * @return strValue by format Ex."aaaa'aaaaa"  Or "aaaa\'aaaaa" Or "aaaa\`aaaa"
	 */
	public static String formatEscape(String strValue) {
		String newString;
	
		newString = strValue.replace("\\", "/");	
		newString = newString.replace("'", "\\\'");
		newString = newString.replace("`", "\\`");
		newString = newString.replace(",", "\\,");
	
		return newString;
	}
	
	/**
	 * formatEscapeCSV
	 * 
	 * @param strValue Ex."ABC"" -> "ABC"""
	 * 
	 * @return strValue by format Ex."ABC"" -> "ABC"""
	 */
	public static String formatEscapeCSV(String strValue) {
		String newString;

		newString = strValue.replace("\"", "\"\"");
	
		return newString;
	}
	
	/**
	 * formatEscapeOracle
	 * 
	 * @param strValue Ex."aaaa'aaaaa" 
	 * 
	 * @return strValue by format Ex."aaaa''aaaaa"
	 */
	public static String formatEscapeOracle(String strValue){
		String newString;
		newString = strValue.replace("'", "''");	
		return newString;
	}
	
	public static String checkHeaderDateFormat(String strDate,String format) {
		
		String retDate = "";
		String sep1 = "";
		String sep2 = "";
		
		if (isEmpty(strDate)) return "";
	
		String year = "";
		String month = "";
		String date = "";

		try {
			//strDate = YYYY/MM/DD
			if (strDate.length()== 10) {
				// us format
				if("MM/dd/yyyy".equals(format)){
					month  = strDate.substring(0,2);
					date = strDate.substring(3,5);
					year  = strDate.substring(6,10);		
					sep1 = strDate.substring(2,3);
					sep2 = strDate.substring(5,6);
				}
				
				// uk format
				if("dd/MM/yyyy".equals(format)){
					date  = strDate.substring(0,2);
					month = strDate.substring(3,5);
					year  = strDate.substring(6,10);		
					sep1 = strDate.substring(2,3);
					sep2 = strDate.substring(5,6);
				}
				
				// th format
				if("dd/MM/yyyy".equals(format)){
					date  = strDate.substring(0,2);
					month = strDate.substring(3,5);
					year  = strDate.substring(6,10);		
					sep1 = strDate.substring(2,3);
					sep2 = strDate.substring(5,6);
				}
				
				// jp format
				if("yyyy/MM/dd".equals(format)){
					year  = strDate.substring(0,4);
					month = strDate.substring(5,7);
					date  = strDate.substring(8,10);		
					sep1 = strDate.substring(4,5);
					sep2 = strDate.substring(7,8);
				}
				
				if(!sep1.equals("/")||!sep2.equals("/")){
					return retDate;
				}
				
			}else{
				return retDate;
			}
		} catch (Exception ex){
			return retDate;
		} 
		
		int yyyy, mm, dd;
		
		try {
			yyyy = new Integer(year).intValue();
			mm = new Integer(month).intValue();
			dd = new Integer(date).intValue();
		} catch (Exception ex) {
			return retDate;
		}

		Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(yyyy, mm - 1, dd);

		try {
			java.util.Date ud = cal.getTime();
			DateFormat fmt = DateFormat.getDateInstance();
			retDate = fmt.format(ud);
			return retDate;
		} catch (IllegalArgumentException ex) {
			return retDate;
		}
	}
		
	
	public static String getLocaleString (HttpServletRequest request){
		return (request.getHeader("Accept-Language").split(",")[0]).toLowerCase();
	}
	
	
	/**
	 * checkInputDate
	 * 
	 * @param source date
	 * @return true if valid date
	 */
	public static boolean checkInputDate(String source,String localeDateFormat){
		boolean result = true;			
		try {
			DateFormat dateFormat = new SimpleDateFormat(localeDateFormat);	
			@SuppressWarnings("unused")
			Date date = dateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * convertInputDate
	 * 
	 * @param source date
	 * @return yyyy/MM/dd format
	 */
	public static String convertInputDate(String source,String localeDateFormat){		
		String result = "";
		if(Tools.isNotEmpty(source)){
			try {
				DateFormat dateFormat = new SimpleDateFormat(localeDateFormat);	
				Date date = dateFormat.parse(source);
				DateFormat serverFormat = new SimpleDateFormat(Constants.HQ_DATE_FORMAT);
				result = serverFormat.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = source;
		}
		return result;
	}
	
	/**
	 * convertOutputDate
	 * 
	 * @param source date
	 * @return locale format date
	 */
	public static String convertOutputDate(String source,String localeDateFormat){
		String result = "";
		if(Tools.isNotEmpty(source)){
			try {
				DateFormat serverFormat = new SimpleDateFormat(Constants.HQ_DATE_FORMAT);
				DateFormat dateFormat = new SimpleDateFormat(localeDateFormat);
				Date date = serverFormat.parse(source);			
				result = dateFormat.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = source;
		}		
		return result;
	}	
	
	/**
	 * formatEscape
	 * 
	 * @param decimalPoint Ex. 0,1,2,3
	 * @param value Ex. 10.5,10.55,10.555,10.5555
	 * 
	 * @return value  Ex. 11,10.6,10.56,10.556
	 */
	public static double roundDecimal(double value,double decimalPoint){
		
		double result = 0.00;
		float power = (float)Math.pow(10,(decimalPoint));
		result = new BigDecimal((float)value*power).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue()/power;
		return result;
	}
	

	/**
	 * This function aim at helping developers calculate date arithmetic with 
	 * ease.
	 * If you want to add or subtract date based on your 
	 * desired format,for instance, calculateDate("yyyy/MM/dd","2008/12/30",2) 
	 * will results in 2009/01/01. 
	 * 
	 * @param dateFormat
	 * @param dateToBeCalculated
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static String calculateDate(String dateFormat, String dateToBeCalculated, int value) throws ParseException{
		
		DateFormat df = new SimpleDateFormat(dateFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(df.parse(dateToBeCalculated));
		c.add(Calendar.DATE, value);
		
		Date newEndDateObject = c.getTime();
		String newEndDate = df.format(newEndDateObject);
		System.out.println(newEndDate);
		return newEndDate;
	}
	
	/**
	 * 
	 * @param dateFormat
	 * @param dateToBeCalculated
	 * @param value
	 * @return
	 * @throws ParseException
	 */
    public static String calculateMonth(String dateFormat, String dateToBeCalculated, int value) throws ParseException
    {
	SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(sdf.parse(dateToBeCalculated));
	calendar.add(Calendar.MONTH, value); // number of days to add
	String result = sdf.format(calendar.getTime()); // dt is now the new date
	return result;
    }
	
	
	
	
	/**
	 * Get checksum digit from barcode value entered. Barcode Type
	 * that can be accepted including UPC-A(UCC-12), EAN-13(UCC-13),
	 * EAN/UCC-14, SSCC and EAN/UCC-8.  
	 * @param barcode
	 * @return
	 */
	public static boolean isBarCodeCorrectForUpcA(String barcode) {
		String lastDigit = Character.toString(barcode.charAt(barcode.length()-1));
		String pureBarcode = barcode.substring(0,barcode.length()-1);
		int checkSum = 0;

		int barcodeLength = pureBarcode.length();
		int sumOfOddPosition = 0;
		int sumOfEvenPosition = 0;
		for (int i = barcodeLength; i > 0; i = i - 2) {
			sumOfOddPosition += Integer.valueOf(pureBarcode.substring(i - 1, i));
		}
		for (int i = barcodeLength - 1; i > 0; i = i - 2) {
			sumOfEvenPosition += Integer.valueOf(pureBarcode.substring(i - 1, i));
		}
		int sumOfBoth = sumOfOddPosition * 3 + sumOfEvenPosition;
		int modResult = sumOfBoth % 10;
		checkSum = modResult == 0 ? 0 : 10 - modResult;
		boolean isBarCodeCorrectForUpcA = Integer.toString(checkSum).equals(lastDigit);
		return isBarCodeCorrectForUpcA;
	}
	
	/**
	 * Convert upcE(8 digits) to upcA (12 digits)
	 * @param upcEBarCode
	 * @return
	 */
	public static String convertFromUpcEToUpcA(String upcEBarCode){
		String lastDigitOfUpcE = upcEBarCode.substring(7,8);
		String sixDigitBarcode = upcEBarCode.substring(1, 7);
		int lastDititOfSixDigitBarcode = Integer.valueOf(sixDigitBarcode.substring(5));
		String convertedUpcABarcode = "";
		switch (lastDititOfSixDigitBarcode) {
		case 4:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,4)+"0"+"0000"+sixDigitBarcode.substring(4,5);
			break;
		case 3:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,3)+"00"+"000"+sixDigitBarcode.substring(3,5);
			break;
		case 2:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,2)+"2"+"00"+"00"+sixDigitBarcode.substring(2,5);
			break;
		case 1:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,2)+"1"+"00"+"00"+sixDigitBarcode.substring(2,5);
			break;	
		case 0:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,2)+"000"+"00"+sixDigitBarcode.substring(2,5);
			break;		
		default:
			convertedUpcABarcode = "0"+sixDigitBarcode.substring(0,5)+"0000"+sixDigitBarcode.substring(5,6);
			break;
		}
		return convertedUpcABarcode+lastDigitOfUpcE;
	}
	
	
	
	/**
	 * format input to format number (US Locale) EX. input 9000 result is 9,000
	 * 
	 * @param input
	 * @return
	 */
	
	public static String formatNumberUS(double input){
		DecimalFormatSymbols s = new DecimalFormatSymbols(Locale.US);
		NumberFormat formatter = new DecimalFormat("##,###,##0",s);
		return formatter.format(input);
	}
	
	public static String formatNumberUS(long input){
		DecimalFormatSymbols s = new DecimalFormatSymbols(Locale.US);
		NumberFormat formatter = new DecimalFormat("##,###,##0",s);
		return formatter.format(input);
	}
	//number format with 4 decimal place.
	public static String formatNumberPHP4(BigDecimal input){
		DecimalFormatSymbols s = new DecimalFormatSymbols(Locale.US);
		NumberFormat formatter = new DecimalFormat("##,###,##0.0000",s);
		return formatter.format(input);
	}
	//number format with 2 decimal place.
		public static String formatNumberPHP2(BigDecimal input){
			DecimalFormatSymbols s = new DecimalFormatSymbols(Locale.US);
			NumberFormat formatter = new DecimalFormat("##,###,##0.00",s);
			return formatter.format(input);
		}
	
	//check range between startDate and endDate
	public static long calculateRangeBetweenDate(Date startDate, Date endDate)
	{
		long diff = endDate.getTime() - startDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}
	
	/** Check format date **/
	public static boolean isThisDateValid(String dateToValidate, String dateFromat){
		 
		if(dateToValidate == null){
			return false;
		}
 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
 
		try {
 
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
//			System.out.println(date);
 
		} catch (ParseException e) {
 
//			e.printStackTrace();
			return false;
		}
 
		return true;
	}
	
	public static BigDecimal nullToBigDecimal(BigDecimal object) {

		if (isEmpty(object)) {
			return new BigDecimal(0);
		}
		return object;
	}
	
	public static String extract(String response, String field, int startPos) {
		int start = StringUtils.indexOf(response, "<" + field + ">", startPos);
		int end = StringUtils.indexOf(response, "</" + field + ">", startPos);
		return StringUtils.substring(response, start + field.length() + 2, end);
	}

}
