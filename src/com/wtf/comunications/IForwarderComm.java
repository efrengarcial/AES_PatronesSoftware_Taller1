package com.wtf.comunications;

import java.io.IOException;

public interface IForwarderComm {
	 void sendRequest (String  theDest ,Message theMsg) throws IOException;
}
