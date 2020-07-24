package com.sakk.mydemo.sboot.util;

public class CommonConstant {

	public static final String STD_DATE_TIME_FORMAT = "dd/MM/yyyy hh:mm a";
	public static final String STD_DATE_FORMAT = "dd/MM/yyyy";
	public static final String STD_TIME_FORMAT = "hh:mm a";
	public static final String STD_DAY_NAME_SHORT_FORMAT = "EEE";
	public static final String STD_DATE_ONLY_FORMAT = "dd";
	public static final String STD_MONTH_AND_YEAR_FORMAT = "MMM yyyy";
	public static final String LOGIN_USER_SESSION_NAME = "loginUser";
	public static final String MSG_PREFIX_SUCCESS = "success|";
	public static final String MSG_PREFIX_ERROR = "error|";
	public static final String FORM_MSG_KEY = "frmMessage";
	public static final int API_RESPONSE_ERROR_CODE = -1;
	public static final int API_RESPONSE_SUCCESS_CODE = 1;
	public static final int API_RESPONSE_SESSION_EXPIRED_CODE = 1001;

	
	public enum UserStatus {
		ACTIVE(1, "Active"), INACTIVE(0, "Inactive");

		private int code;
		private String desc;

		UserStatus(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public int getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}

		public static String getDescByCode(int code) {
			for (UserStatus us : values()) {
				if (us.getCode() == code) {
					return us.getDesc();
				}
			}
			return "";
		}

	}
	
	public enum MessageStatus {
		SUCCESS(1, "Success"), FAIL(-1, "Fail");

		private int code;
		private String desc;

		MessageStatus(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public int getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}

		public static String getDescByCode(int code) {
			for (MessageStatus us : values()) {
				if (us.getCode() == code) {
					return us.getDesc();
				}
			}
			return "";
		}

	}
	
	public enum LoginStatus {
		SUCCESS(1, "Login Success"), FAIL(-1, "Login Fail");

		private int code;
		private String desc;

		LoginStatus(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public int getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}

		public static String getDescByCode(int code) {
			for (LoginStatus ls : values()) {
				if (ls.getCode() == code) {
					return ls.getDesc();
				}
			}
			return "";
		}

	}

}
