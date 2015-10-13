package com.hyx.dianping.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SharedUtils {
	// 定义标记的写入与读取
	private static final String FILE_NAME = "dianping";
	private static final String MODE_NAME = "welcome";

	// 获取boolean类型的值；
	public static boolean getWelcomeBoolean(Context context) {
		return context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE)
				.getBoolean(MODE_NAME, false);
	}

	// 写入boolean类型的值；
	public static void putWelcomeBoolean(Context context, boolean isFirst) {
		Editor editor = context.getSharedPreferences(FILE_NAME,
				Context.MODE_APPEND).edit();
		// 通过上下文对象的getSharedPreferences的对象来获得edit()对象；
		editor.putBoolean(MODE_NAME, isFirst);
		editor.commit();// 提交；
	}
}
