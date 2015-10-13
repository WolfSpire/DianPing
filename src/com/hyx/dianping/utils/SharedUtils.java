package com.hyx.dianping.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SharedUtils {
	// �����ǵ�д�����ȡ
	private static final String FILE_NAME = "dianping";
	private static final String MODE_NAME = "welcome";

	// ��ȡboolean���͵�ֵ��
	public static boolean getWelcomeBoolean(Context context) {
		return context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE)
				.getBoolean(MODE_NAME, false);
	}

	// д��boolean���͵�ֵ��
	public static void putWelcomeBoolean(Context context, boolean isFirst) {
		Editor editor = context.getSharedPreferences(FILE_NAME,
				Context.MODE_APPEND).edit();
		// ͨ�������Ķ����getSharedPreferences�Ķ��������edit()����
		editor.putBoolean(MODE_NAME, isFirst);
		editor.commit();// �ύ��
	}
}
