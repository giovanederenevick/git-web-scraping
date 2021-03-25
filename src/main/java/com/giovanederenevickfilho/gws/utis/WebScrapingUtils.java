package com.giovanederenevickfilho.gws.utis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScrapingUtils {
	
	private static final String GIT_HUB_URL = "https://github.com";
	
	private static final String FILE_INFO_WITH_LINES = "^(?<lines>\\d{0,})\\s"
			+ ".{0,}\\s"
			+ ".{0,}\\s"
			+ ".{0,}\\s" 
			+ "(?<bytes>.{0,})\\s"
			+ "(?<size>.{1,})";
	
	private static final String FILE_INFO = "^(?<bytes>.{0,})\\s"
			+ "(?<size>.{1,})";
	
	private static final Pattern PATTERN_FILE_INFO_WITH_LINES;
	private static final Pattern PATTERN_FILE_INFO;
	
	static {
		PATTERN_FILE_INFO_WITH_LINES = Pattern.compile(FILE_INFO_WITH_LINES);
		PATTERN_FILE_INFO = Pattern.compile(FILE_INFO);
	}

	public static String getGitHubUrl() {
		return GIT_HUB_URL;
	}

	public static Pattern getPatternFileInfoWithLines() {
		return PATTERN_FILE_INFO_WITH_LINES;
	}

	public static Pattern getPatternFileInfo() {
		return PATTERN_FILE_INFO;
	}

	public static Long getCountLines(String elementString) {
		Matcher m = PATTERN_FILE_INFO_WITH_LINES.matcher(elementString);
		if(m.matches()) {
			return Long.parseLong(m.group("lines"));
		}
		
		return 0L;
	}

	public static Double getCountBytes(String elementString) {
		Matcher m = PATTERN_FILE_INFO_WITH_LINES.matcher(elementString);
		if(m.matches()) {	
			return getCountBytesFormat(m.group("bytes"),m.group("size"));
		}
		
		m = PATTERN_FILE_INFO.matcher(elementString);
		if(m.matches()) {
			return getCountBytesFormat(m.group("bytes"),m.group("size"));
		}
		
		return 0D;
	}
	
	private static Double getCountBytesFormat(String bytes, String textFormat) {
		Double countBytes = Double.parseDouble(bytes);
		if("KB".equalsIgnoreCase(textFormat)) {
			countBytes *= 1024;
		}
		if("MB".equalsIgnoreCase(textFormat)) {
			countBytes *= 1024*1024;
		}		
		return countBytes;
	}

}
