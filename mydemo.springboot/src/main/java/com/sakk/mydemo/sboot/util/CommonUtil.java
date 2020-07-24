package com.sakk.mydemo.sboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

public class CommonUtil {

	public static String changeDateToString(String format, Date date) {
		if (date == null) {
			return null;
		}

		if (format == null || format.trim().isEmpty()) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		return new SimpleDateFormat(format).format(date);
	}

	public static Date changeStringToDate(String format, String dateString) {

		if (dateString == null || dateString.trim().isEmpty()) {
			return null;
		}

		if (format == null || format.trim().isEmpty()) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		try {
			return new SimpleDateFormat(format).parse(dateString.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String changeFormatOfDateString(String fromFormat, String toFormat, String dateString) {

		if (fromFormat == null || toFormat == null || dateString == null || fromFormat.trim().isEmpty()
				|| toFormat.trim().isEmpty() || dateString.trim().isEmpty()) {
			return "";
		}

		Date tempDate = CommonUtil.changeStringToDate(fromFormat, dateString);

		if (tempDate == null) {
			return "";
		}

		String formattedString = CommonUtil.changeDateToString(toFormat, tempDate);

		return (formattedString == null) ? "" : formattedString;
	}

	public static Date getStartTimeOfTheDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getEndTimeOfTheDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static boolean isValidDateFormat(String format, String dateString) {
		if (format == null || format.trim().isEmpty()) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		if (dateString == null || dateString.trim().isEmpty()) {
			return false;
		}

		try {
			Date date = new SimpleDateFormat(format).parse(dateString.trim());
			System.out.println(date);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	public static boolean isValidStringForDateOnlyFormat(String dateString) {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(dateString).matches();
	}

	public static boolean isValidStringForDateTimeFormat(String dateTimeString) {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9] ((1[0-2]|0?[1-9]):([0-5][0-9]) ([AaPp][Mm]))$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(dateTimeString).matches();
	}

	public static String getTodayOrYesterdayStringWithTime(Date date) {
		if (date == null) {
			return "";
		}

		Calendar calendar = fromDateToCalendar(date);
		Calendar now = Calendar.getInstance();

		if ((now.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
				&& (now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))) {

			if (now.get(Calendar.DATE) == calendar.get(Calendar.DATE)) {
				return ("TODAY(" + CommonUtil.changeDateToString(CommonConstant.STD_TIME_FORMAT, date) + ")");
			} else if (now.get(Calendar.DATE) - calendar.get(Calendar.DATE) == 1) {
				return ("YESTERDAY(" + CommonUtil.changeDateToString(CommonConstant.STD_TIME_FORMAT, date) + ")");
			}

		}

		return "";
	}

	public static Calendar fromDateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Date getYesterdayDate() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public static int getWeeksOfCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
	}

	public static boolean canParseStringToNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static String escapeHTML(String str) {
		return StringEscapeUtils.escapeHtml(str);
	}

}
