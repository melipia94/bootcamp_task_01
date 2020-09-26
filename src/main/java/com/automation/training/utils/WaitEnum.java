package com.automation.training.utils;

public enum WaitEnum {
	
	
	LONG(200),
	VERY_LONG (400),
	SHORT(60),
	VER_SHORT(30);

    // Enum Constructo
	private long timeOut;
    WaitEnum(long timeOutInSeconds) {
        this.timeOut = timeOutInSeconds;
    }

    // Getter Method
    public long getTimeOut() {
        return timeOut;
    }
}
