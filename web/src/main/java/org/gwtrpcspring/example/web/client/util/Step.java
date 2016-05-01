package org.gwtrpcspring.example.web.client.util;

public interface Step {

	public void execute();
	public void undo();
	public String getHistoryToken();
}
