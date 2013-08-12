package com.wtf.comunications;

import java.util.Observer;


public interface IReceiverComm extends Runnable  {
	void run() ;

	void addObserver(Observer o);
}
