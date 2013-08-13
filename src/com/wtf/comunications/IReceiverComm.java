package com.wtf.comunications;

import java.util.Observer;


public interface IReceiverComm extends Runnable  {
	 
	public byte[] receive();

	void addObserver(Observer o);
}
