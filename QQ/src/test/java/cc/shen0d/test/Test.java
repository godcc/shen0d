package cc.shen0d.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		Process exec = runtime.exec("whoami");
		StringBuffer sb = new StringBuffer();
		InputStreamReader inputStreamReader = new InputStreamReader(exec.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String s;
		while ((s = bufferedReader.readLine()) != null) {
			sb.append(s);
		}
		System.out.println(sb.toString());
	}
}
