package orp.gwtrpspring.example.web.client.panel;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class DesktopManager {

	private static DesktopManager instance;
	private DockLayoutPanel dlp;
	private Widget content;
	
	protected DesktopManager(){
		dlp = new DockLayoutPanel(Unit.PX);
	}
	 
	public static DesktopManager getInstance() {
		if (instance == null) {
			instance = new DesktopManager();
		}
		return instance;
	}
	
	public void setMenu(Composite menu) {
		dlp.addWest(menu, 160);
	}
	
	public void setHeader(Composite header) {
		dlp.addNorth(header, 60);
	}
	
	public void setMainContent(Widget newContent) {
		if (content !=null) {
			dlp.remove(content);
		}
		content = newContent;
		dlp.add(content);
	}
	
	public Widget getContainer() {
		return dlp;
	}
}
