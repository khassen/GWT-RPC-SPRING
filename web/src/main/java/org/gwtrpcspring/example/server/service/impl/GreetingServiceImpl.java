package org.gwtrpcspring.example.server.service.impl;

import org.gwtrpcspring.RemoteServiceUtil;
import org.gwtrpcspring.example.client.GreetingService;

/**
 * The server side implementation of the RPC service.
 */
public class GreetingServiceImpl implements GreetingService {

	public String greetServer(String input) {
		String serverInfo = RemoteServiceUtil.getThreadLocalContext().getServerInfo();
		String userAgent = RemoteServiceUtil.getThreadLocalRequest().getHeader("User-Agent");

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
}
