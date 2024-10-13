package com.ktdsuniversity.edu.common.vo;

public class StoreResultVO {

	private String originFilename;
	private String obfuscatedFileName;
	
	public StoreResultVO(String originFilename, String obfuscatedFileName) {
		this.originFilename = originFilename;
		this.obfuscatedFileName = obfuscatedFileName;
	}

	public String getOriginFilename() {
		return originFilename;
	}

	public String getObfuscatedFileName() {
		return obfuscatedFileName;
	}
}
