package com.automation.training.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.pmw.tinylog.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Utils {
	private static final String JSON_FILE_PATH = "src/test/resources/dataProvider.json";
	private static JsonParser parser = new JsonParser();
	public static Map<String, String> getDate(int days){
		Map<String, String> dateMap = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date date = cal.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMMMM-dd");
		String date1 = format1.format(date);
		dateMap.put("year", date1.split("-")[0]);
		dateMap.put("month", date1.split("-")[1]);
		dateMap.put("day", date1.split("-")[2]);
		if(date1.split("-")[2].startsWith("0")) dateMap.put("day", date1.split("-")[2].split("0")[1]);
		else dateMap.put("day", date1.split("-")[2]);
		return dateMap;  

	}
	public static String getJsonDataProvider(String dataString) {
		try {
			Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
			JsonObject jsonObject = (JsonObject) obj;
			return jsonObject.get(dataString).getAsString();
		
		} catch (FileNotFoundException e) {
			Logger.error(e.getMessage(), e);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		return "";
	}
	public static String getUserProperty(String property) {
		try {
			Properties p = new Properties();
			p.load(new FileReader("user.properties"));
			return p.getProperty(property);	
			
		}catch (FileNotFoundException e) {
			Logger.error(e.getMessage(), e);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		return "";
	}
	
}
