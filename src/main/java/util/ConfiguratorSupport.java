package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguratorSupport {
	private static Properties props = new Properties();
	private static String strFileName;
	private String strValue;

	public String getProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return strValue;
	}

	public void setProperty(String strKey, String strValue) throws Throwable {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.setProperty(strKey, strValue);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void removeProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public ConfiguratorSupport(String strFileName) {
		ConfiguratorSupport.strFileName = strFileName;
	}

	public void clean() {
		props.clear();
	}
}

