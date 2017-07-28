package com.jygj.summ.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	public static String PATTERN_yyyyMM = "yyyyMM";
	public static String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
	public static String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static String PATTERN_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";
	public static String PATTERN_yyyyMMdd = "yyyyMMdd";
	public static String PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static String PATTERN_HTTP = "EEE, dd MMM yyyy HH:mm:ss zzz";
	
	public static String getCurrentTimeString(){
		return parseDateToString( 
				Calendar.getInstance().getTime(), PATTERN_yyyyMMddHHmmssSSS );
	}
	
	public static String parseDateToString(Date date, String pattern) {
		if (date == null || "".equals(date)) {
			return "";
		}
		SimpleDateFormat _df = new SimpleDateFormat(pattern);
		return _df.format(date);
	}
	
	public final static String getDateLong(Date date){
		return String.valueOf(date.getTime());
	}
	
	public static Date format(Date date ,String pattern){
		if (date == null) {
			return date;
		}
		SimpleDateFormat _df = new SimpleDateFormat(pattern);
		_df.format(date);
		return date;
	}
	
	public static double getCurrentTime_fortoken(){
		return Double.parseDouble(getCurrentTimeString().substring(0, 13));
	}
	
	public static String parseDateToHttp( Date date ){
		if (date == null) {
			return "";
		}
		SimpleDateFormat _df = new SimpleDateFormat( PATTERN_HTTP, Locale.US );
		return _df.format(date);
	}
	
	public static Date parseLongToDate(long time ){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.getTime();
	}
	
	/** 
     * 使用参数Format将字符串转为Date 
	 * @throws ParseException
     */  
    public static Date parseStringToDate(String strDate, String pattern) throws ParseException{  
    	SimpleDateFormat _df = new SimpleDateFormat(pattern);
        return _df.parse(strDate);  
    } 
	
	public static long getTimeDiff(Date begin_date , Date end_date){
		return  end_date.getTime() - begin_date.getTime() ;
	}


	/**
	 * 根据日期转换星期
	 * @param date
	 * @return
	 */
	public static String dateAndday(Date date){
		String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar calendar = Calendar.getInstance();
		if(date != null){
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0){
			w = 0;
		}
		return weekOfDays[w];
	}

	public static List<Date>  weekAndDay(int week ,Date start ,Date over) throws ParseException {
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> listDate1 = getDatesBetweenTwoDate(start,over);
		List<Date> dates = new ArrayList<Date>();
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < listDate1.size(); i++) {
			c.setTime(listDate1.get(i));
			if(c.get(Calendar.DAY_OF_WEEK)==week){
				//获取时间段内的所有周二日期
				int s = start.compareTo(simpleDateFormat2.parse(simpleDateFormat2.format(c.getTime())));
				int o = over.compareTo(simpleDateFormat2.parse(simpleDateFormat2.format(c.getTime())));
				if (s <= 0 && o >= 0){
					dates.add(simpleDateFormat2.parse(simpleDateFormat2.format(c.getTime())));
				}
			}
		}
		return dates;
	}

	/**
	 * 根据年龄获取出生年份
	 * @param age
	 * @return
	 * @throws ParseException
	 */
	public static Date yaerAndBirthday(int age) throws ParseException {
		Calendar mycalendar = Calendar.getInstance();//获取现在时间
		String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
		int birth = Integer.valueOf(year)-age;
		String birthday = String.valueOf(birth)+"-1-01";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(birthday);
		return date;
	}


	/**
	 *	时间戳转换日期date
	 * @return
	 */
	public static Date stringForDate(String time) throws ParseException {
		Date date = new Date(Long.parseLong(time));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return date;
	}

	/**
	 * 日期转换时间戳
	 * @param date
	 * @return
	 */
	public static String dateForString(Date date){
		Long time = date.getTime();
		return String.valueOf(time);
	}


	/**
	 * 获取日期之间天数差
	 * @return
     */
	public static  int getDateCha(Date fDate , Date oDate){

		if (null == fDate || null == oDate) {
			return -1;
		}
		long intervalMilli = oDate.getTime() - fDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}


	/**
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 *
	 * @param beginDate
	 * @param endDate
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(beginDate);// 把开始时间加入集合
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(beginDate);
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			cal.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				lDate.add(cal.getTime());
			} else {
				break;
			}
		}
		lDate.add(endDate);// 把结束时间加入集合
		return lDate;
	}

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


	public static long getMonthLastDay2(long time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		calendar.add(Calendar.MONTH,+1);
		return calendar.getTimeInMillis()-1;
	}

//	public static Date getMonthLastDay(int year , int month) throws ParseException {
//		Date endDate = null;
//		if(year%100 == 0 && year%400 == 0 && month == 2){
//			endDate = simpleDateFormat.parse(String.valueOf(year)+"-"+String.valueOf(month)+"-29");
//		}else{
//			switch (month)
//			{
//				case 2:
//					endDate = simpleDateFormat.parse(String.valueOf(year)+"-"+String.valueOf(month)+"-28");
//					break;
//				case 1:
//				case 3:
//				case 5:
//				case 7:
//				case 8:
//				case 10:
//				case 12:
//					endDate = simpleDateFormat.parse(String.valueOf(year)+"-"+String.valueOf(month)+"-31");
//					break;
//				case 4:
//				case 6:
//				case 9:
//				case 11:
//					endDate = simpleDateFormat.parse(String.valueOf(year)+"-"+String.valueOf(month)+"-28");
//					break;
//			}
//		}
//
//		return endDate;
//	}

	/**
	 * 获取月份起始日期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMinMonthDate(Date date) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calMax = Calendar.getInstance();
		calMax.setTime(date);
		calMax.set(Calendar.DATE, calMax.getActualMinimum(Calendar.DATE));
		return simpleDateFormat.format(calMax.getTime());
	}

	/**
	 * 获取月份最后日期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMaxMonthDate(Date date) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calMin = Calendar.getInstance();
		calMin.setTime(date);
		calMin.set(Calendar.DATE, calMin.getActualMaximum(Calendar.DATE));
		calMin.set(Calendar.DAY_OF_MONTH, calMin.getActualMaximum(Calendar.DAY_OF_MONTH));
		return simpleDateFormat.format(calMin.getTime());
	}

}
