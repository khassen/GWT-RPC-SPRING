package org.gwtrpcspring.example.client;


import org.gwtrpcspring.web.client.resource.MainClientBundle;

import orp.gwtrpspring.example.web.client.panel.DesktopManager;
import orp.gwtrpspring.example.web.client.panel.HeaderPanel;
import orp.gwtrpspring.example.web.client.panel.MenuPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtRpcSpringExample implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MainClientBundle.INSTANCE.mainStyle().ensureInjected();
		

	    HandlerManager eventBus = new HandlerManager(this);
		AppController appViewer = new AppController(eventBus);
		DesktopManager.getInstance().setHeader( new HeaderPanel());


		RootLayoutPanel.get().add(DesktopManager.getInstance().getContainer());
		DesktopManager.getInstance().setMenu(new MenuPanel(eventBus));

		//DesktopManager.getInstance().setMainContent(new WelcomePanel());
	
	
		
	}
	
	
}
