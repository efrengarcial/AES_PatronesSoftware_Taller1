package com.wtf.commons;

import java.util.Calendar;
import java.util.LinkedHashMap;

public class StackMap extends LinkedHashMap<Calendar, Float> {
	
	private static final long serialVersionUID = -5906100478003476286L;
	private static final int STACK_SIZE=5;
	
	public boolean removeEldestEntry(Calendar cal, Float temp) {
		return size() > STACK_SIZE;
	}	
	
}
