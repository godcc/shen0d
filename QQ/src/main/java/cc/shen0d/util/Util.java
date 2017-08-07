package cc.shen0d.util;

import java.security.MessageDigest;

/**
 * 工具类
 * 
 * @author sihan
 *
 */
public class Util {

	public static String Md5Encode(String str) {
		StringBuffer md5Code = new StringBuffer();
		try {
			MessageDigest instance = MessageDigest.getInstance("md5");
			instance.update(str.getBytes());
			byte[] digest = instance.digest();
			int i;
			for (int offset = 0; offset < digest.length; offset++) {
				i = digest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					md5Code.append("0");
				md5Code.append(Integer.toHexString(i));
			}
			// 16位加密
			// return buf.toString().substring(8, 24);
		} catch (Exception e) {

		}
		// 32位加密
		return md5Code.toString();
	}

	public static void main(String[] args) {
		String md5Encode = Md5Encode("wssss");
		System.out.println(md5Encode);
	}

}
