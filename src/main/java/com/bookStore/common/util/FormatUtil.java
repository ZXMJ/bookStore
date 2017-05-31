package com.bookStore.common.util;

public class FormatUtil {

	/**
	 * @Description: String类型转float
	 *
	 * @date 2017年3月23日,上午11:31:19
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param str
	 * @param defaultResult 默认值
	 * @return
	 */
	public static float parseFloat(String str, long defaultResult) {
		try {
			if (str != null && !"".equals(str.trim())) {
				return  Float.parseFloat(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return defaultResult;
	}
	
	/**
	 * @Description: String转int
	 *
	 * @date 2017年3月23日,下午1:15:34
	 * @author fanbaoshen
	 * @version 5.0
	 *
	 * @param pageNoStr
	 * @param defaultResult 默认值
	 * @return
	 */
	public static int parseInt(String str, int defaultResult) {
		try {
			if (str != null && !"".equals(str.trim())) {
				return Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return defaultResult;
	}
}
