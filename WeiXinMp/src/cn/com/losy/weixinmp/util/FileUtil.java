package cn.com.losy.weixinmp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static void save(InputStream is, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			byte[] b = new byte[1024];
			while((is.read(b)) != -1){
				fos.write(b);
			}
			is.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
