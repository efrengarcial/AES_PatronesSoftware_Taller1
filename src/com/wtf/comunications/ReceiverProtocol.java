package com.wtf.comunications;

import java.util.Observer;


public interface ReceiverProtocol extends Runnable  {
	void run() ;

	void addObserver(Observer o);
}
