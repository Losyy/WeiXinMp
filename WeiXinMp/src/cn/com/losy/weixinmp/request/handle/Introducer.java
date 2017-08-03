package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.util.EmojiUtil;

/**
 * 功能介绍类
 * 
 * @author ximin
 *
 */
public class Introducer {
	/**
	 * 功能介绍- 二维码生成
	 * 
	 * @return
	 */
	public static String introduceEwm() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供二维码生成功能。请输入[二维码]字样，后接文字").append("\n");
		buffer.append("如 二维码洛西Losy很完美");
		return buffer.toString();
	}

	/**
	 * 功能介绍- 彩票开奖查询
	 * 
	 * @return
	 */
	public static String introduceCpcx() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供彩票开奖查询功能。请输入[彩票]字样，后接彩票种类").append("\n");
		buffer.append("如 彩票双色球");
		return buffer.toString();
	}

	/**
	 * 功能介绍- 翻译
	 * 
	 * @return
	 */
	public static String introduceFy() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供翻译功能。请输入[翻译]字样，后接需要翻译的词").append("\n");
		buffer.append("如 翻译hello world");
		return buffer.toString();
	}

	/**
	 * 功能介绍- 快递查询
	 * 
	 * @return
	 */
	public static String introduceKdcx() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供快递查询。请输入[快递]字样，后接快递商，再接一空格，最后输入快递单号").append("\n");
		buffer.append("如 快递圆通 200093247451");
		return buffer.toString();
	}

	/**
	 * 功能介绍- 天气预报
	 * 
	 * @return
	 */
	public static String introduceTqyb() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供当天天气预报查询。请输入[天气]或[天气预报]字样，后接城市").append("\n");
		buffer.append("如 天气福州");
		return buffer.toString();
	}

	/**
	 * 功能介绍- 身份证查询
	 * 
	 * @return
	 */
	public static String introduceSfzcx() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("提供身份证归属地信息查询。请输入[身份证]或[身份证查询]字样，后接身份证号码").append("\n");
		buffer.append("如 身份证350624199012271516");
		return buffer.toString();
	}

	/**
	 * 无法识别
	 * 
	 * @return
	 */
	public static String wrongCode() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("无法识别的功能代号或文字，请参照帮助菜单。").append("\n");
		buffer.append("\n");
		return buffer.toString();
	}

	/**
	 * 菜单- 主菜单
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer mainMenu = new StringBuffer();
		mainMenu.append("您好，我是洛西Losy，请回复代号使用功能或查看功能介绍：").append("\n\n");

		mainMenu.append("1  身份证查询").append("\n");
		mainMenu.append("2  天气预报  \ue04b").append("\n");
		mainMenu.append("3  快递查询  \ue42f").append("\n");
		mainMenu.append("4  翻译  \ue50c").append("\n");
		mainMenu.append("5  历史上的今天").append("\n");
		mainMenu.append("6  彩票开奖查询  \ue12f").append("\n");
		mainMenu.append("7  啦啦啦  \ue415").append("\n");
		mainMenu.append("8  啦啦啦图").append("\n");
		mainMenu.append("9  二维码生成").append("\n");
		mainMenu.append("更多功能，敬请挖掘！ " + EmojiUtil.emoji(0x1F47B)).append("\n");

		mainMenu.append("\n");
		mainMenu.append("回复? 或 help 或帮助  显示此帮助菜单");
		return mainMenu.toString();
	}
}
