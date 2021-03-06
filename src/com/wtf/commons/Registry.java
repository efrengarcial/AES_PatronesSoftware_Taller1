package com.wtf.commons;

import java.util.Hashtable;

public class Registry {
	private Hashtable<String,Entry> hTable = new Hashtable<String,Entry>() ;
	
	public synchronized void putAll(Hashtable<String,Entry> register ) { 
		hTable.clear();
		hTable.putAll(register);
	}
	
	public void put (String theKey, Entry theEntry) { 
		hTable.put(theKey,theEntry);
	}
	public Entry get(String aKey) { 
		return (Entry) hTable.get (aKey)  ; 
	}
	
	public void remove(String theKey) { 
		hTable.remove(theKey);
	}
	
	public  Hashtable<String,Entry> getAll(){
		return hTable;
	}
}

