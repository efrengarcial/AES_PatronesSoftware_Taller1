package com.wtf.comunications;

import java.io.IOException;

import com.wtf.comunications.messages.Message;

public interface IForwarderComm {
	 void sendRequest (String  theDest ,Message theMsg) throws IOException;
}
