package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class ConfiguratorSupport.
 */
public class ConfiguratorSupport {
	
	/** The props. */
	private static Properties props = new Properties();
	
	/** The str file name. */
	private static String strFileName;
	
	/** The str value. */
	private String strValue;

	/**
	 * Gets the property.
	 *
	 * @param strKey the str key
	 * @return the property
	 */
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

	/**
	 * Sets the property.
	 *
	 * @param strKey the str key
	 * @param strValue the str value
	 * @throws Throwable the throwable
	 */
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

	/**
	 * Removes the property.
	 *
	 * @param strKey the str key
	 */
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

	/**
	 * Instantiates a new configurator support.
	 *
	 * @param strFileName the str file name
	 */
	public ConfiguratorSupport(String strFileName) {
		ConfiguratorSupport.strFileName = strFileName;
	}

	/**
	 * Clean.
	 */
	public void clean() {
		props.clear();
	}
}

