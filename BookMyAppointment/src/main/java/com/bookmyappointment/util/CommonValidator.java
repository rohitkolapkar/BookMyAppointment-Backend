package com.bookmyappointment.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonValidator {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean checkDuplicateRoleUsingSet(String[] input) {
		List inputList = Arrays.asList(input);
		Set inputSet = new HashSet(inputList);
		if (inputSet.size() < inputList.size()) {
			return true;
		}
		return false;
	}

	public static boolean isValidDateFormat(String format, String value) {
		boolean flag = false;
		Date date = null;
		try {
			flag = true;
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				flag = false;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
			flag = false;
		}
		return flag;
	}
}
