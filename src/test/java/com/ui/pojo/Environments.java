package com.ui.pojo;

public class Environments {

	private String url;
	private int MAX_NUMBER_OF_FLAKY_ATTEMPTS;
	
	public int getMAX_NUMBER_OF_FLAKY_ATTEMPTS() {
		return MAX_NUMBER_OF_FLAKY_ATTEMPTS;
	}

	public void setMAX_NUMBER_OF_FLAKY_ATTEMPTS(int mAX_NUMBER_OF_FLAKY_ATTEMPTS) {
		MAX_NUMBER_OF_FLAKY_ATTEMPTS = mAX_NUMBER_OF_FLAKY_ATTEMPTS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
