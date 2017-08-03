package cn.com.losy.weixinmp.util;

import java.util.Random;

public class RandomUitl {
	
	/**
	 * 返回小于max的随机数
	 * @param max
	 * @return
	 */
	public static int getInt(int max) {
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt(max);
	}
}
