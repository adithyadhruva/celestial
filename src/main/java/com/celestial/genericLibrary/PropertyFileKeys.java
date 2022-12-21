package com.celestial.genericLibrary;
/**
 * this is Property file class
 * @author Dell
 *
 */
public enum PropertyFileKeys {
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),IMAGE("img");
	private String keys;
	//setter
	/**
	 * this is property file method
	 * @param keys
	 */
	private PropertyFileKeys(String keys) {
		this.keys=keys;
	}
	//getter
	/**
	 * this is get key method
	 * @return
	 */
	public String getKey() {
		return keys.toString();
		
	}

}





